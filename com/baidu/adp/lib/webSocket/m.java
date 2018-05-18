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
    private static long ze = 0;
    private int mState;
    private boolean mStopped;
    private final e.a yo;
    private final l yw;
    private final Handler zb;
    private final ByteBuffer zc;
    private final d zd;
    private boolean zf;
    private int zg;
    private a zh;
    private int zi;
    private final f zj;
    private int zk;
    private long zl;
    private long zm;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int zn;
        public boolean zo;
        public int zp;
        public int zq;
        public int zr;
        public int zs;
        public byte[] zt;
        public byte[] zu;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.zf = false;
        this.zj = new f();
        this.zk = 0;
        this.zl = 0L;
        this.zm = 0L;
        this.zb = handler;
        this.yo = aVar;
        this.yw = lVar;
        this.zc = ByteBuffer.allocateDirect(lVar.hQ() + 14);
        this.zd = new d(lVar.hR());
        this.zh = null;
        this.mState = 1;
    }

    protected void s(Object obj) {
        this.zl = 0L;
        this.zm = 0L;
        Message obtainMessage = this.zb.obtainMessage();
        obtainMessage.obj = obj;
        this.zb.sendMessage(obtainMessage);
    }

    private boolean hX() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.zh == null) {
            if (this.zc.position() >= 2) {
                byte b = this.zc.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.zc.get(1);
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
                    if (!this.zf && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.zf && i4 != 0) {
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
                if (this.zc.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.zc.get(2) & 255) << 8) | (this.zc.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.zc.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.zc.get(2) & 255) << 56) | ((this.zc.get(3) & 255) << 48) | ((this.zc.get(4) & 255) << 40) | ((this.zc.get(5) & 255) << 32) | ((this.zc.get(6) & 255) << 24) | ((this.zc.get(7) & 255) << 16) | ((this.zc.get(8) & 255) << 8) | (this.zc.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.zh = new a();
                    this.zh.zn = i4;
                    this.zh.zo = z;
                    this.zh.zp = i3;
                    this.zh.zr = (int) j;
                    this.zh.zq = i2;
                    this.zh.zs = this.zh.zq + this.zh.zr;
                    this.zh.zt = null;
                    int position = this.zc.position();
                    this.zh.zu = new byte[this.zh.zq];
                    this.zc.position(0);
                    this.zc.get(this.zh.zu, 0, this.zh.zq);
                    this.zc.position(this.zh.zq);
                    this.zc.limit(position);
                    this.zc.compact();
                    return this.zh.zr == 0 || this.zc.position() >= this.zh.zr;
                }
                return false;
            }
            return false;
        } else if (this.zi >= this.zh.zr) {
            if (this.zh.zn > 7) {
                if (this.zh.zn == 8) {
                    if (this.zh.zr < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.zh.zu[1] & 255) + ((this.zh.zu[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.zh.zr > 2) {
                            byte[] bArr2 = new byte[this.zh.zr - 2];
                            System.arraycopy(this.zh.zu, 2, bArr2, 0, this.zh.zr - 2);
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
                } else if (this.zh.zn == 9) {
                    r(this.zd.toByteArray());
                } else if (this.zh.zn == 10) {
                    s(this.zd.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.zf) {
                    this.zf = true;
                    this.zg = this.zh.zn;
                    if (this.zg == 1 && this.yw.hU()) {
                        this.zj.reset();
                    }
                }
                if (this.zg == 1 && this.yw.hU() && !this.zj.p(this.zd.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.zh.zo) {
                    if (this.zg == 1) {
                        if (this.yw.hU() && !this.zj.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.yw.hP()) {
                            q(this.zd.toByteArray());
                        } else {
                            G(new String(this.zd.toByteArray(), "UTF-8"));
                        }
                    } else if (this.zg == 2) {
                        t(this.zd.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.zf = false;
                    this.zd.reset();
                }
            }
            this.zh = null;
            this.zi = 0;
            return this.zc.position() > 0;
        } else {
            int position2 = this.zc.position();
            if (this.zh.zr - this.zi < position2) {
                position2 = this.zh.zr - this.zi;
            }
            int position3 = this.zc.position();
            if (this.zh.zr > 0) {
                bArr = new byte[position2];
                this.zc.position(0);
                this.zc.get(bArr, 0, position2);
            }
            this.zc.position(position2);
            this.zc.limit(position3);
            this.zc.compact();
            if (bArr != null) {
                this.zd.write(bArr);
            }
            this.zi = position2 + this.zi;
            return this.zi >= this.zh.zr;
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
        this.zm = System.currentTimeMillis();
        s(new k.a(bArr, this.zl, this.zm));
    }

    private boolean hY() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.zc.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.zc.get(position + 0) != 13 || this.zc.get(position + 1) != 10 || this.zc.get(position + 2) != 13 || this.zc.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.zc.position();
                Map<String, String> map = null;
                if (this.zc.get(0) == 72 && this.zc.get(1) == 84 && this.zc.get(2) == 84 && this.zc.get(3) == 80) {
                    Pair<Integer, String> hZ = hZ();
                    if (((Integer) hZ.first).intValue() >= 300) {
                        s(new k.p(((Integer) hZ.first).intValue(), (String) hZ.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.zc.position(0);
                        byte[] bArr = new byte[position];
                        this.zc.get(bArr);
                        map = u(bArr);
                    }
                } else {
                    z = false;
                }
                this.zc.position(position + 4);
                this.zc.limit(position2);
                this.zc.compact();
                if (this.zk < this.yo.hz() && map.size() == 0) {
                    this.zk++;
                    return true;
                }
                this.zk = 0;
                if (!z) {
                    z2 = this.zc.position() > 0;
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
        while (i < this.zc.position() && this.zc.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.zc.position() && this.zc.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.zc.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.zc.position() && this.zc.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.zc.position(i6);
        this.zc.get(bArr, 0, i8);
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
            this.yo.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.zc.clear();
            do {
                try {
                    int read = this.yo.read(this.zc);
                    if (read > 0) {
                        if (this.zl <= 0) {
                            this.zl = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            ze += read;
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
            ze = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = ze;
        }
        return j;
    }
}
