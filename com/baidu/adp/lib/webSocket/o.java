package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends Thread {
    private static long rv = 0;
    private int mState;
    private boolean mStopped;
    private final e.a qE;
    private final n qM;
    private final f rA;
    private int rB;
    private long rC;
    private long rD;
    private final Handler rs;
    private final ByteBuffer rt;
    private final d ru;
    private boolean rw;
    private int rx;
    private a ry;
    private int rz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int rE;
        public boolean rF;
        public int rG;
        public int rH;
        public int rI;
        public int rJ;
        public byte[] rK;
        public byte[] rL;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.rw = false;
        this.rA = new f();
        this.rB = 0;
        this.rC = 0L;
        this.rD = 0L;
        this.rs = handler;
        this.qE = aVar;
        this.qM = nVar;
        this.rt = ByteBuffer.allocateDirect(nVar.gx() + 14);
        this.ru = new d(nVar.gy());
        this.ry = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        this.rC = 0L;
        this.rD = 0L;
        Message obtainMessage = this.rs.obtainMessage();
        obtainMessage.obj = obj;
        this.rs.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean gE() {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.ry == null) {
            if (this.rt.position() >= 2) {
                byte b = this.rt.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.rt.get(1);
                boolean z2 = (b2 & 128) != 0;
                int i5 = b2 & Byte.MAX_VALUE;
                if (i3 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i4 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i5 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i4 != 8 && i4 != 9 && i4 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i4);
                    }
                    if (i4 == 8 && i5 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i4 != 0 && i4 != 1 && i4 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i4);
                } else {
                    if (!this.rw && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.rw && i4 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i5 < 126) {
                    i2 = 2;
                } else if (i5 == 126) {
                    i2 = 4;
                } else if (i5 != 127) {
                    throw new Exception("BdLogic error");
                } else {
                    i2 = 10;
                }
                if (this.rt.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.rt.get(2) & 255) << 8) | (this.rt.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.rt.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.rt.get(2) & 255) << 56) | ((this.rt.get(3) & 255) << 48) | ((this.rt.get(4) & 255) << 40) | ((this.rt.get(5) & 255) << 32) | ((this.rt.get(6) & 255) << 24) | ((this.rt.get(7) & 255) << 16) | ((this.rt.get(8) & 255) << 8) | (this.rt.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.ry = new a(null);
                    this.ry.rE = i4;
                    this.ry.rF = z;
                    this.ry.rG = i3;
                    this.ry.rI = (int) j;
                    this.ry.rH = i2;
                    this.ry.rJ = this.ry.rH + this.ry.rI;
                    this.ry.rK = null;
                    int position = this.rt.position();
                    this.ry.rL = new byte[this.ry.rH];
                    this.rt.position(0);
                    this.rt.get(this.ry.rL, 0, this.ry.rH);
                    this.rt.position(this.ry.rH);
                    this.rt.limit(position);
                    this.rt.compact();
                    return this.ry.rI == 0 || this.rt.position() >= this.ry.rI;
                }
                return false;
            }
            return false;
        } else if (this.rz < this.ry.rI) {
            int position2 = this.rt.position();
            if (this.ry.rI - this.rz < position2) {
                position2 = this.ry.rI - this.rz;
            }
            int position3 = this.rt.position();
            if (this.ry.rI > 0) {
                bArr = new byte[position2];
                this.rt.position(0);
                this.rt.get(bArr, 0, position2);
            }
            this.rt.position(position2);
            this.rt.limit(position3);
            this.rt.compact();
            if (bArr != null) {
                this.ru.write(bArr);
            }
            this.rz = position2 + this.rz;
            return this.rz >= this.ry.rI;
        } else {
            if (this.ry.rE <= 7) {
                if (!this.rw) {
                    this.rw = true;
                    this.rx = this.ry.rE;
                    if (this.rx == 1 && this.qM.gB()) {
                        this.rA.reset();
                    }
                }
                if (this.rx == 1 && this.qM.gB() && !this.rA.n(this.ru.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.ry.rF) {
                    if (this.rx == 1) {
                        if (this.qM.gB() && !this.rA.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.qM.gw()) {
                            o(this.ru.toByteArray());
                        } else {
                            y(new String(this.ru.toByteArray(), "UTF-8"));
                        }
                    } else if (this.rx != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        r(this.ru.toByteArray());
                    }
                    this.rw = false;
                    this.ru.reset();
                }
            } else if (this.ry.rE == 8) {
                if (this.ry.rI >= 2) {
                    i = (this.ry.rL[1] & 255) + ((this.ry.rL[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.ry.rI > 2) {
                        byte[] bArr2 = new byte[this.ry.rI - 2];
                        System.arraycopy(this.ry.rL, 2, bArr2, 0, this.ry.rI - 2);
                        f fVar = new f();
                        fVar.n(bArr2);
                        if (!fVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    } else {
                        str = null;
                    }
                } else {
                    i = 1005;
                    str = null;
                }
                e(i, str);
            } else if (this.ry.rE == 9) {
                p(this.ru.toByteArray());
            } else if (this.ry.rE != 10) {
                throw new Exception("BdLogic error");
            } else {
                q(this.ru.toByteArray());
            }
            this.ry = null;
            this.rz = 0;
            return this.rt.position() > 0;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        q(new m.q(z, map));
    }

    protected void e(int i, String str) {
        q(new m.c(i, str));
    }

    protected void p(byte[] bArr) {
        q(new m.j(bArr));
    }

    protected void q(byte[] bArr) {
        q(new m.k(bArr));
    }

    protected void y(String str) {
        q(new m.s(str));
    }

    protected void o(byte[] bArr) {
        q(new m.C0010m(bArr));
    }

    protected void r(byte[] bArr) {
        this.rD = System.currentTimeMillis();
        q(new m.a(bArr, this.rC, this.rD));
    }

    private boolean gF() {
        boolean z;
        boolean z2;
        int position = this.rt.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.rt.get(position + 0) != 13 || this.rt.get(position + 1) != 10 || this.rt.get(position + 2) != 13 || this.rt.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.rt.position();
                Map<String, String> map = null;
                if (this.rt.get(0) == 72 && this.rt.get(1) == 84 && this.rt.get(2) == 84 && this.rt.get(3) == 80) {
                    Pair<Integer, String> gG = gG();
                    if (((Integer) gG.first).intValue() >= 300) {
                        q(new m.p(((Integer) gG.first).intValue(), (String) gG.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.rt.position(0);
                        byte[] bArr = new byte[position];
                        this.rt.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.rt.position(position + 4);
                this.rt.limit(position2);
                this.rt.compact();
                if (this.rB < this.qE.ge() && map.size() == 0) {
                    this.rB++;
                    return true;
                }
                this.rB = 0;
                if (!z) {
                    z2 = this.rt.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                r1 = z2;
            }
        }
        return r1;
    }

    private Map<String, String> s(byte[] bArr) {
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (String str2 : split) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private Pair<Integer, String> gG() {
        int i = 4;
        while (i < this.rt.position() && this.rt.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.rt.position() && this.rt.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.rt.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.rt.position() && this.rt.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.rt.position(i6);
        this.rt.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean gH() {
        if (this.mState == 3 || this.mState == 2) {
            return gE();
        }
        if (this.mState == 1) {
            return gF();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.qE.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.rt.clear();
            do {
                try {
                    int read = this.qE.read(this.rt);
                    if (read > 0) {
                        if (this.rC <= 0) {
                            this.rC = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            rv += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (gH());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.fr()) {
                        this.mStopped = true;
                        q(new m.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (WebSocketException e2) {
            q(new m.l(e2));
        } catch (SocketException e3) {
            q(new m.d(e3));
        } catch (Exception e4) {
            q(new m.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void gn() {
        synchronized (o.class) {
            rv = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = rv;
        }
        return j;
    }
}
