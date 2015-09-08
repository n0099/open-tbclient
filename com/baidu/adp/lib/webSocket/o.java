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
    private static long Az = 0;
    private boolean AA;
    private int AB;
    private a AC;
    private int AD;
    private final f AE;
    private int AF;
    private final Handler Aw;
    private final ByteBuffer Ax;
    private final d Ay;
    private int mState;
    private boolean mStopped;
    private final e.a zI;
    private final n zQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AG;
        public boolean AH;
        public int AI;
        public int AJ;
        public int AK;
        public int AL;
        public byte[] AM;
        public byte[] AN;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AA = false;
        this.AE = new f();
        this.AF = 0;
        this.Aw = handler;
        this.zI = aVar;
        this.zQ = nVar;
        this.Ax = ByteBuffer.allocateDirect(nVar.jO() + 14);
        this.Ay = new d(nVar.jP());
        this.AC = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.Aw.obtainMessage();
        obtainMessage.obj = obj;
        this.Aw.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=8] */
    private boolean jV() {
        int i;
        long j;
        int i2 = 2;
        if (this.AC != null) {
            if (this.AD < this.AC.AK) {
                int position = this.Ax.position();
                if (this.AC.AK - this.AD < position) {
                    position = this.AC.AK - this.AD;
                }
                byte[] bArr = null;
                int position2 = this.Ax.position();
                if (this.AC.AK > 0) {
                    bArr = new byte[position];
                    this.Ax.position(0);
                    this.Ax.get(bArr, 0, position);
                }
                this.Ax.position(position);
                this.Ax.limit(position2);
                this.Ax.compact();
                if (bArr != null) {
                    this.Ay.write(bArr);
                }
                this.AD = position + this.AD;
                return this.AD >= this.AC.AK;
            }
            if (this.AC.AG <= 7) {
                if (!this.AA) {
                    this.AA = true;
                    this.AB = this.AC.AG;
                    if (this.AB == 1 && this.zQ.jS()) {
                        this.AE.reset();
                    }
                }
                if (this.AB == 1 && this.zQ.jS() && !this.AE.E(this.Ay.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AC.AH) {
                    if (this.AB == 1) {
                        if (this.zQ.jS() && !this.AE.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zQ.jN()) {
                            F(this.Ay.toByteArray());
                        } else {
                            I(new String(this.Ay.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AB != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.Ay.toByteArray());
                    }
                    this.AA = false;
                    this.Ay.reset();
                }
            } else if (this.AC.AG == 8) {
                int i3 = 1005;
                String str = null;
                if (this.AC.AK >= 2) {
                    i3 = ((this.AC.AN[0] & 255) * 256) + (this.AC.AN[1] & 255);
                    if (i3 < 1000 || (!(i3 < 1000 || i3 > 2999 || i3 == 1000 || i3 == 1001 || i3 == 1002 || i3 == 1003 || i3 == 1007 || i3 == 1008 || i3 == 1009 || i3 == 1010 || i3 == 1011) || i3 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i3);
                    }
                    if (this.AC.AK > 2) {
                        byte[] bArr2 = new byte[this.AC.AK - 2];
                        System.arraycopy(this.AC.AN, 2, bArr2, 0, this.AC.AK - 2);
                        f fVar = new f();
                        fVar.E(bArr2);
                        if (!fVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    }
                }
                l(i3, str);
            } else if (this.AC.AG == 9) {
                G(this.Ay.toByteArray());
            } else if (this.AC.AG != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.Ay.toByteArray());
            }
            this.AC = null;
            this.AD = 0;
            return this.Ax.position() > 0;
        } else if (this.Ax.position() >= 2) {
            byte b = this.Ax.get(0);
            boolean z = (b & 128) != 0;
            int i4 = (b & 112) >> 4;
            int i5 = b & 15;
            byte b2 = this.Ax.get(1);
            boolean z2 = (b2 & 128) != 0;
            int i6 = b2 & Byte.MAX_VALUE;
            if (i4 != 0) {
                throw new WebSocketException("RSV != 0 and no extension negotiated");
            }
            if (z2) {
                throw new WebSocketException("masked server frame");
            }
            if (i5 > 7) {
                if (!z) {
                    throw new WebSocketException("fragmented control frame");
                }
                if (i6 > 125) {
                    throw new WebSocketException("control frame with payload length > 125 octets");
                }
                if (i5 != 8 && i5 != 9 && i5 != 10) {
                    throw new WebSocketException("control frame using reserved opcode " + i5);
                }
                if (i5 == 8 && i6 == 1) {
                    throw new WebSocketException("received close control frame with payload len 1");
                }
            } else if (i5 != 0 && i5 != 1 && i5 != 2) {
                throw new WebSocketException("data frame using reserved opcode " + i5);
            } else {
                if (!this.AA && i5 == 0) {
                    throw new WebSocketException("received continuation data frame outside fragmented message");
                }
                if (this.AA && i5 != 0) {
                    throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                }
            }
            int i7 = z2 ? 4 : 0;
            if (i6 < 126) {
                i = i7 + 2;
            } else if (i6 == 126) {
                i = i7 + 4;
            } else if (i6 != 127) {
                throw new Exception("BdLogic error");
            } else {
                i = i7 + 10;
            }
            if (this.Ax.position() >= i) {
                if (i6 == 126) {
                    j = ((this.Ax.get(2) & 255) << 8) | (this.Ax.get(3) & 255);
                    if (j < 126) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 4;
                } else if (i6 != 127) {
                    j = i6;
                } else if ((this.Ax.get(2) & 128) != 0) {
                    throw new WebSocketException("invalid data frame length (> 2^63)");
                } else {
                    j = ((this.Ax.get(2) & 255) << 56) | ((this.Ax.get(3) & 255) << 48) | ((this.Ax.get(4) & 255) << 40) | ((this.Ax.get(5) & 255) << 32) | ((this.Ax.get(6) & 255) << 24) | ((this.Ax.get(7) & 255) << 16) | ((this.Ax.get(8) & 255) << 8) | (this.Ax.get(9) & 255);
                    if (j < 65536) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 10;
                }
                this.AC = new a(null);
                this.AC.AG = i5;
                this.AC.AH = z;
                this.AC.AI = i4;
                this.AC.AK = (int) j;
                this.AC.AJ = i;
                this.AC.AL = this.AC.AJ + this.AC.AK;
                if (z2) {
                    this.AC.AM = new byte[4];
                    for (int i8 = 0; i8 < 4; i8++) {
                        this.AC.AM[i2] = (byte) (this.Ax.get(i2 + i8) & 255);
                    }
                    int i9 = i2 + 4;
                } else {
                    this.AC.AM = null;
                }
                int position3 = this.Ax.position();
                this.AC.AN = new byte[this.AC.AJ];
                this.Ax.position(0);
                this.Ax.get(this.AC.AN, 0, this.AC.AJ);
                this.Ax.position(this.AC.AJ);
                this.Ax.limit(position3);
                this.Ax.compact();
                return this.AC.AK == 0 || this.Ax.position() >= this.AC.AK;
            }
            return false;
        } else {
            return false;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        q(new m.q(z, map));
    }

    protected void l(int i, String str) {
        q(new m.c(i, str));
    }

    protected void G(byte[] bArr) {
        q(new m.j(bArr));
    }

    protected void H(byte[] bArr) {
        q(new m.k(bArr));
    }

    protected void I(String str) {
        q(new m.s(str));
    }

    protected void F(byte[] bArr) {
        q(new m.C0008m(bArr));
    }

    protected void w(byte[] bArr) {
        q(new m.a(bArr));
    }

    private boolean jW() {
        boolean z;
        boolean z2;
        int position = this.Ax.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ax.get(position + 0) != 13 || this.Ax.get(position + 1) != 10 || this.Ax.get(position + 2) != 13 || this.Ax.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ax.position();
                Map<String, String> map = null;
                if (this.Ax.get(0) == 72 && this.Ax.get(1) == 84 && this.Ax.get(2) == 84 && this.Ax.get(3) == 80) {
                    Pair<Integer, String> jX = jX();
                    if (((Integer) jX.first).intValue() >= 300) {
                        q(new m.p(((Integer) jX.first).intValue(), (String) jX.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ax.position(0);
                        byte[] bArr = new byte[position];
                        this.Ax.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ax.position(position + 4);
                this.Ax.limit(position2);
                this.Ax.compact();
                if (this.AF < this.zI.jw() && map.size() == 0) {
                    this.AF++;
                    return true;
                }
                this.AF = 0;
                if (!z) {
                    z2 = this.Ax.position() > 0;
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

    private Map<String, String> I(byte[] bArr) {
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

    private Pair<Integer, String> jX() {
        int i = 4;
        while (i < this.Ax.position() && this.Ax.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ax.position() && this.Ax.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ax.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ax.position() && this.Ax.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ax.position(i6);
        this.Ax.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean jY() {
        if (this.mState == 3 || this.mState == 2) {
            return jV();
        }
        if (this.mState == 1) {
            return jW();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zI.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [746=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ax.clear();
            do {
                try {
                    int read = this.zI.read(this.Ax);
                    if (read > 0) {
                        synchronized (o.class) {
                            Az += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (jY());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.iL()) {
                        this.mStopped = true;
                        q(new m.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            q(new m.d(e2));
        } catch (WebSocketException e3) {
            q(new m.l(e3));
        } catch (Exception e4) {
            q(new m.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void jE() {
        synchronized (o.class) {
            Az = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = Az;
        }
        return j;
    }
}
