package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long OW = 0;
    private final Handler OT;
    private final ByteBuffer OU;
    private final d OV;
    private boolean OX;
    private int OY;
    private a OZ;
    private final e.a Oh;
    private final l Oq;
    private int Pa;
    private final f Pb;
    private int Pc;
    private long Pe;
    private long Pf;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Pg;
        public boolean Ph;
        public int Pi;
        public int Pj;
        public int Pk;
        public int Pl;
        public byte[] Pm;
        public byte[] Pn;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.OX = false;
        this.Pb = new f();
        this.Pc = 0;
        this.Pe = 0L;
        this.Pf = 0L;
        this.OT = handler;
        this.Oh = aVar;
        this.Oq = lVar;
        this.OU = ByteBuffer.allocateDirect(lVar.mT() + 14);
        this.OV = new d(lVar.mU());
        this.OZ = null;
        this.mState = 1;
    }

    protected void u(Object obj) {
        this.Pe = 0L;
        this.Pf = 0L;
        Message obtainMessage = this.OT.obtainMessage();
        obtainMessage.obj = obj;
        this.OT.sendMessage(obtainMessage);
    }

    private boolean na() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.OZ == null) {
            if (this.OU.position() >= 2) {
                byte b = this.OU.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.OU.get(1);
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
                    if (!this.OX && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.OX && i4 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i5 < 126) {
                    i2 = 2;
                } else if (i5 == 126) {
                    i2 = 4;
                } else if (i5 == 127) {
                    i2 = 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.OU.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.OU.get(2) & 255) << 8) | (this.OU.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.OU.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.OU.get(2) & 255) << 56) | ((this.OU.get(3) & 255) << 48) | ((this.OU.get(4) & 255) << 40) | ((this.OU.get(5) & 255) << 32) | ((this.OU.get(6) & 255) << 24) | ((this.OU.get(7) & 255) << 16) | ((this.OU.get(8) & 255) << 8) | (this.OU.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.OZ = new a();
                    this.OZ.Pg = i4;
                    this.OZ.Ph = z;
                    this.OZ.Pi = i3;
                    this.OZ.Pk = (int) j;
                    this.OZ.Pj = i2;
                    this.OZ.Pl = this.OZ.Pj + this.OZ.Pk;
                    this.OZ.Pm = null;
                    int position = this.OU.position();
                    this.OZ.Pn = new byte[this.OZ.Pj];
                    this.OU.position(0);
                    this.OU.get(this.OZ.Pn, 0, this.OZ.Pj);
                    this.OU.position(this.OZ.Pj);
                    this.OU.limit(position);
                    this.OU.compact();
                    return this.OZ.Pk == 0 || this.OU.position() >= this.OZ.Pk;
                }
                return false;
            }
            return false;
        } else if (this.Pa >= this.OZ.Pk) {
            if (this.OZ.Pg > 7) {
                if (this.OZ.Pg == 8) {
                    if (this.OZ.Pk < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.OZ.Pn[1] & 255) + ((this.OZ.Pn[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.OZ.Pk > 2) {
                            byte[] bArr2 = new byte[this.OZ.Pk - 2];
                            System.arraycopy(this.OZ.Pn, 2, bArr2, 0, this.OZ.Pk - 2);
                            f fVar = new f();
                            fVar.j(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    d(i, str);
                } else if (this.OZ.Pg == 9) {
                    l(this.OV.toByteArray());
                } else if (this.OZ.Pg == 10) {
                    m(this.OV.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.OX) {
                    this.OX = true;
                    this.OY = this.OZ.Pg;
                    if (this.OY == 1 && this.Oq.mX()) {
                        this.Pb.reset();
                    }
                }
                if (this.OY == 1 && this.Oq.mX() && !this.Pb.j(this.OV.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.OZ.Ph) {
                    if (this.OY == 1) {
                        if (this.Oq.mX() && !this.Pb.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Oq.mS()) {
                            k(this.OV.toByteArray());
                        } else {
                            onTextMessage(new String(this.OV.toByteArray(), "UTF-8"));
                        }
                    } else if (this.OY == 2) {
                        n(this.OV.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.OX = false;
                    this.OV.reset();
                }
            }
            this.OZ = null;
            this.Pa = 0;
            return this.OU.position() > 0;
        } else {
            int position2 = this.OU.position();
            if (this.OZ.Pk - this.Pa < position2) {
                position2 = this.OZ.Pk - this.Pa;
            }
            int position3 = this.OU.position();
            if (this.OZ.Pk > 0) {
                bArr = new byte[position2];
                this.OU.position(0);
                this.OU.get(bArr, 0, position2);
            }
            this.OU.position(position2);
            this.OU.limit(position3);
            this.OU.compact();
            if (bArr != null) {
                this.OV.write(bArr);
            }
            this.Pa = position2 + this.Pa;
            return this.Pa >= this.OZ.Pk;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        u(new k.q(z, map));
    }

    protected void d(int i, String str) {
        u(new k.c(i, str));
    }

    protected void l(byte[] bArr) {
        u(new k.j(bArr));
    }

    protected void m(byte[] bArr) {
        u(new k.C0023k(bArr));
    }

    protected void onTextMessage(String str) {
        u(new k.s(str));
    }

    protected void k(byte[] bArr) {
        u(new k.m(bArr));
    }

    protected void n(byte[] bArr) {
        this.Pf = System.currentTimeMillis();
        u(new k.a(bArr, this.Pe, this.Pf));
    }

    private boolean nb() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.OU.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.OU.get(position + 0) != 13 || this.OU.get(position + 1) != 10 || this.OU.get(position + 2) != 13 || this.OU.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.OU.position();
                Map<String, String> map = null;
                if (this.OU.get(0) == 72 && this.OU.get(1) == 84 && this.OU.get(2) == 84 && this.OU.get(3) == 80) {
                    Pair<Integer, String> nc = nc();
                    if (((Integer) nc.first).intValue() >= 300) {
                        u(new k.p(((Integer) nc.first).intValue(), (String) nc.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.OU.position(0);
                        byte[] bArr = new byte[position];
                        this.OU.get(bArr);
                        map = o(bArr);
                    }
                } else {
                    z = false;
                }
                this.OU.position(position + 4);
                this.OU.limit(position2);
                this.OU.compact();
                if (this.Pc < this.Oh.mD() && map.size() == 0) {
                    this.Pc++;
                    return true;
                }
                this.Pc = 0;
                if (!z) {
                    z2 = this.OU.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                z3 = z2;
            }
        }
        return z3;
    }

    private Map<String, String> o(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> nc() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.OU.position() && this.OU.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.OU.position() && this.OU.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.OU.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.OU.position() && this.OU.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.OU.position(i6);
        this.OU.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean nd() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return na();
        }
        if (this.mState == 1) {
            return nb();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Oh.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.OU.clear();
            do {
                try {
                    int read = this.Oh.read(this.OU);
                    if (read > 0) {
                        if (this.Pe <= 0) {
                            this.Pe = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            OW += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (nd());
                    } else if (read < 0) {
                        u(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        u(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            u(new k.d(e2));
        } catch (WebSocketException e3) {
            u(new k.l(e3));
        } catch (Exception e4) {
            u(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void mJ() {
        synchronized (m.class) {
            OW = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = OW;
        }
        return j;
    }
}
