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
    private static long zf = 0;
    private int mState;
    private boolean mStopped;
    private final e.a yp;
    private final l yx;
    private final Handler zc;
    private final ByteBuffer zd;
    private final d ze;
    private boolean zg;
    private int zh;
    private a zi;
    private int zj;
    private final f zk;
    private int zl;
    private long zm;
    private long zn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int zo;
        public boolean zp;
        public int zq;
        public int zr;
        public int zs;
        public int zt;
        public byte[] zu;
        public byte[] zv;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.zg = false;
        this.zk = new f();
        this.zl = 0;
        this.zm = 0L;
        this.zn = 0L;
        this.zc = handler;
        this.yp = aVar;
        this.yx = lVar;
        this.zd = ByteBuffer.allocateDirect(lVar.hQ() + 14);
        this.ze = new d(lVar.hR());
        this.zi = null;
        this.mState = 1;
    }

    protected void s(Object obj) {
        this.zm = 0L;
        this.zn = 0L;
        Message obtainMessage = this.zc.obtainMessage();
        obtainMessage.obj = obj;
        this.zc.sendMessage(obtainMessage);
    }

    private boolean hX() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.zi == null) {
            if (this.zd.position() >= 2) {
                byte b = this.zd.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.zd.get(1);
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
                    if (!this.zg && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.zg && i4 != 0) {
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
                if (this.zd.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.zd.get(2) & 255) << 8) | (this.zd.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.zd.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.zd.get(2) & 255) << 56) | ((this.zd.get(3) & 255) << 48) | ((this.zd.get(4) & 255) << 40) | ((this.zd.get(5) & 255) << 32) | ((this.zd.get(6) & 255) << 24) | ((this.zd.get(7) & 255) << 16) | ((this.zd.get(8) & 255) << 8) | (this.zd.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.zi = new a();
                    this.zi.zo = i4;
                    this.zi.zp = z;
                    this.zi.zq = i3;
                    this.zi.zs = (int) j;
                    this.zi.zr = i2;
                    this.zi.zt = this.zi.zr + this.zi.zs;
                    this.zi.zu = null;
                    int position = this.zd.position();
                    this.zi.zv = new byte[this.zi.zr];
                    this.zd.position(0);
                    this.zd.get(this.zi.zv, 0, this.zi.zr);
                    this.zd.position(this.zi.zr);
                    this.zd.limit(position);
                    this.zd.compact();
                    return this.zi.zs == 0 || this.zd.position() >= this.zi.zs;
                }
                return false;
            }
            return false;
        } else if (this.zj >= this.zi.zs) {
            if (this.zi.zo > 7) {
                if (this.zi.zo == 8) {
                    if (this.zi.zs < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.zi.zv[1] & 255) + ((this.zi.zv[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.zi.zs > 2) {
                            byte[] bArr2 = new byte[this.zi.zs - 2];
                            System.arraycopy(this.zi.zv, 2, bArr2, 0, this.zi.zs - 2);
                            f fVar = new f();
                            fVar.p(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.zi.zo == 9) {
                    r(this.ze.toByteArray());
                } else if (this.zi.zo == 10) {
                    s(this.ze.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.zg) {
                    this.zg = true;
                    this.zh = this.zi.zo;
                    if (this.zh == 1 && this.yx.hU()) {
                        this.zk.reset();
                    }
                }
                if (this.zh == 1 && this.yx.hU() && !this.zk.p(this.ze.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.zi.zp) {
                    if (this.zh == 1) {
                        if (this.yx.hU() && !this.zk.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.yx.hP()) {
                            q(this.ze.toByteArray());
                        } else {
                            G(new String(this.ze.toByteArray(), "UTF-8"));
                        }
                    } else if (this.zh == 2) {
                        t(this.ze.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.zg = false;
                    this.ze.reset();
                }
            }
            this.zi = null;
            this.zj = 0;
            return this.zd.position() > 0;
        } else {
            int position2 = this.zd.position();
            if (this.zi.zs - this.zj < position2) {
                position2 = this.zi.zs - this.zj;
            }
            int position3 = this.zd.position();
            if (this.zi.zs > 0) {
                bArr = new byte[position2];
                this.zd.position(0);
                this.zd.get(bArr, 0, position2);
            }
            this.zd.position(position2);
            this.zd.limit(position3);
            this.zd.compact();
            if (bArr != null) {
                this.ze.write(bArr);
            }
            this.zj = position2 + this.zj;
            return this.zj >= this.zi.zs;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        s(new k.q(z, map));
    }

    protected void e(int i, String str) {
        s(new k.c(i, str));
    }

    protected void r(byte[] bArr) {
        s(new k.j(bArr));
    }

    protected void s(byte[] bArr) {
        s(new k.C0010k(bArr));
    }

    protected void G(String str) {
        s(new k.s(str));
    }

    protected void q(byte[] bArr) {
        s(new k.m(bArr));
    }

    protected void t(byte[] bArr) {
        this.zn = System.currentTimeMillis();
        s(new k.a(bArr, this.zm, this.zn));
    }

    private boolean hY() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.zd.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.zd.get(position + 0) != 13 || this.zd.get(position + 1) != 10 || this.zd.get(position + 2) != 13 || this.zd.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.zd.position();
                Map<String, String> map = null;
                if (this.zd.get(0) == 72 && this.zd.get(1) == 84 && this.zd.get(2) == 84 && this.zd.get(3) == 80) {
                    Pair<Integer, String> hZ = hZ();
                    if (((Integer) hZ.first).intValue() >= 300) {
                        s(new k.p(((Integer) hZ.first).intValue(), (String) hZ.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.zd.position(0);
                        byte[] bArr = new byte[position];
                        this.zd.get(bArr);
                        map = u(bArr);
                    }
                } else {
                    z = false;
                }
                this.zd.position(position + 4);
                this.zd.limit(position2);
                this.zd.compact();
                if (this.zl < this.yp.hz() && map.size() == 0) {
                    this.zl++;
                    return true;
                }
                this.zl = 0;
                if (!z) {
                    z2 = this.zd.position() > 0;
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

    private Map<String, String> u(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> hZ() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.zd.position() && this.zd.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.zd.position() && this.zd.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.zd.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.zd.position() && this.zd.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.zd.position(i6);
        this.zd.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean ia() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return hX();
        }
        if (this.mState == 1) {
            return hY();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.yp.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.zd.clear();
            do {
                try {
                    int read = this.yp.read(this.zd);
                    if (read > 0) {
                        if (this.zm <= 0) {
                            this.zm = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            zf += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ia());
                    } else if (read < 0) {
                        s(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.gP()) {
                        this.mStopped = true;
                        s(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            s(new k.d(e2));
        } catch (WebSocketException e3) {
            s(new k.l(e3));
        } catch (Exception e4) {
            s(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void hG() {
        synchronized (m.class) {
            zf = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = zf;
        }
        return j;
    }
}
