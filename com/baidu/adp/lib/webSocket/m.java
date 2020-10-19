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
    private static long Rc = 0;
    private final Handler QZ;
    private final e.a Qp;
    private final l Qx;
    private final ByteBuffer Ra;
    private final d Rb;
    private boolean Rd;
    private int Re;
    private a Rf;
    private int Rg;
    private final f Rh;
    private int Ri;
    private long Rj;
    private long Rk;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Rl;
        public boolean Rm;
        public int Rn;
        public int Ro;
        public int Rp;
        public int Rq;
        public byte[] Rr;
        public byte[] Rs;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Rd = false;
        this.Rh = new f();
        this.Ri = 0;
        this.Rj = 0L;
        this.Rk = 0L;
        this.QZ = handler;
        this.Qp = aVar;
        this.Qx = lVar;
        this.Ra = ByteBuffer.allocateDirect(lVar.oR() + 14);
        this.Rb = new d(lVar.oS());
        this.Rf = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.Rj = 0L;
        this.Rk = 0L;
        Message obtainMessage = this.QZ.obtainMessage();
        obtainMessage.obj = obj;
        this.QZ.sendMessage(obtainMessage);
    }

    private boolean oY() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Rf == null) {
            if (this.Ra.position() >= 2) {
                byte b = this.Ra.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ra.get(1);
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
                    if (!this.Rd && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Rd && i4 != 0) {
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
                if (this.Ra.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ra.get(2) & 255) << 8) | (this.Ra.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ra.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ra.get(2) & 255) << 56) | ((this.Ra.get(3) & 255) << 48) | ((this.Ra.get(4) & 255) << 40) | ((this.Ra.get(5) & 255) << 32) | ((this.Ra.get(6) & 255) << 24) | ((this.Ra.get(7) & 255) << 16) | ((this.Ra.get(8) & 255) << 8) | (this.Ra.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Rf = new a();
                    this.Rf.Rl = i4;
                    this.Rf.Rm = z;
                    this.Rf.Rn = i3;
                    this.Rf.Rp = (int) j;
                    this.Rf.Ro = i2;
                    this.Rf.Rq = this.Rf.Ro + this.Rf.Rp;
                    this.Rf.Rr = null;
                    int position = this.Ra.position();
                    this.Rf.Rs = new byte[this.Rf.Ro];
                    this.Ra.position(0);
                    this.Ra.get(this.Rf.Rs, 0, this.Rf.Ro);
                    this.Ra.position(this.Rf.Ro);
                    this.Ra.limit(position);
                    this.Ra.compact();
                    return this.Rf.Rp == 0 || this.Ra.position() >= this.Rf.Rp;
                }
                return false;
            }
            return false;
        } else if (this.Rg >= this.Rf.Rp) {
            if (this.Rf.Rl > 7) {
                if (this.Rf.Rl == 8) {
                    if (this.Rf.Rp < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Rf.Rs[1] & 255) + ((this.Rf.Rs[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Rf.Rp > 2) {
                            byte[] bArr2 = new byte[this.Rf.Rp - 2];
                            System.arraycopy(this.Rf.Rs, 2, bArr2, 0, this.Rf.Rp - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    c(i, str);
                } else if (this.Rf.Rl == 9) {
                    n(this.Rb.toByteArray());
                } else if (this.Rf.Rl == 10) {
                    o(this.Rb.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Rd) {
                    this.Rd = true;
                    this.Re = this.Rf.Rl;
                    if (this.Re == 1 && this.Qx.oV()) {
                        this.Rh.reset();
                    }
                }
                if (this.Re == 1 && this.Qx.oV() && !this.Rh.l(this.Rb.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Rf.Rm) {
                    if (this.Re == 1) {
                        if (this.Qx.oV() && !this.Rh.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Qx.oQ()) {
                            m(this.Rb.toByteArray());
                        } else {
                            onTextMessage(new String(this.Rb.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Re == 2) {
                        p(this.Rb.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Rd = false;
                    this.Rb.reset();
                }
            }
            this.Rf = null;
            this.Rg = 0;
            return this.Ra.position() > 0;
        } else {
            int position2 = this.Ra.position();
            if (this.Rf.Rp - this.Rg < position2) {
                position2 = this.Rf.Rp - this.Rg;
            }
            int position3 = this.Ra.position();
            if (this.Rf.Rp > 0) {
                bArr = new byte[position2];
                this.Ra.position(0);
                this.Ra.get(bArr, 0, position2);
            }
            this.Ra.position(position2);
            this.Ra.limit(position3);
            this.Ra.compact();
            if (bArr != null) {
                this.Rb.write(bArr);
            }
            this.Rg = position2 + this.Rg;
            return this.Rg >= this.Rf.Rp;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void c(int i, String str) {
        z(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        z(new k.C0024k(bArr));
    }

    protected void onTextMessage(String str) {
        z(new k.s(str));
    }

    protected void m(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.Rk = System.currentTimeMillis();
        z(new k.a(bArr, this.Rj, this.Rk));
    }

    private boolean oZ() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ra.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ra.get(position + 0) != 13 || this.Ra.get(position + 1) != 10 || this.Ra.get(position + 2) != 13 || this.Ra.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ra.position();
                Map<String, String> map = null;
                if (this.Ra.get(0) == 72 && this.Ra.get(1) == 84 && this.Ra.get(2) == 84 && this.Ra.get(3) == 80) {
                    Pair<Integer, String> pa = pa();
                    if (((Integer) pa.first).intValue() >= 300) {
                        z(new k.p(((Integer) pa.first).intValue(), (String) pa.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ra.position(0);
                        byte[] bArr = new byte[position];
                        this.Ra.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ra.position(position + 4);
                this.Ra.limit(position2);
                this.Ra.compact();
                if (this.Ri < this.Qp.oB() && map.size() == 0) {
                    this.Ri++;
                    return true;
                }
                this.Ri = 0;
                if (!z) {
                    z2 = this.Ra.position() > 0;
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

    private Map<String, String> q(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> pa() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Ra.position() && this.Ra.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ra.position() && this.Ra.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ra.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ra.position() && this.Ra.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ra.position(i6);
        this.Ra.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean pb() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oY();
        }
        if (this.mState == 1) {
            return oZ();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Qp.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ra.clear();
            do {
                try {
                    int read = this.Qp.read(this.Ra);
                    if (read > 0) {
                        if (this.Rj <= 0) {
                            this.Rj = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Rc += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pb());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        z(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            z(new k.d(e2));
        } catch (WebSocketException e3) {
            z(new k.l(e3));
        } catch (Exception e4) {
            z(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void oH() {
        synchronized (m.class) {
            Rc = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Rc;
        }
        return j;
    }
}
