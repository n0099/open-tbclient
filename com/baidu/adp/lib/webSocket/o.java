package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends Thread {
    private static long rX = 0;
    private int mState;
    private boolean mStopped;
    private final Handler rU;
    private final ByteBuffer rV;
    private final d rW;
    private boolean rY;
    private int rZ;
    private final e.a rg;
    private final n rp;
    private a sa;
    private int sb;
    private final f sc;
    private int sd;
    private long se;
    private long sf;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int sg;
        public boolean sh;
        public int si;
        public int sj;
        public int sk;
        public int sl;
        public byte[] sm;
        public byte[] so;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.rY = false;
        this.sc = new f();
        this.sd = 0;
        this.se = 0L;
        this.sf = 0L;
        this.rU = handler;
        this.rg = aVar;
        this.rp = nVar;
        this.rV = ByteBuffer.allocateDirect(nVar.gw() + 14);
        this.rW = new d(nVar.gx());
        this.sa = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.se = 0L;
        this.sf = 0L;
        Message obtainMessage = this.rU.obtainMessage();
        obtainMessage.obj = obj;
        this.rU.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean gD() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.sa == null) {
            if (this.rV.position() >= 2) {
                byte b = this.rV.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.rV.get(1);
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
                    if (!this.rY && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.rY && i4 != 0) {
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
                if (this.rV.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.rV.get(2) & 255) << 8) | (this.rV.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.rV.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.rV.get(2) & 255) << 56) | ((this.rV.get(3) & 255) << 48) | ((this.rV.get(4) & 255) << 40) | ((this.rV.get(5) & 255) << 32) | ((this.rV.get(6) & 255) << 24) | ((this.rV.get(7) & 255) << 16) | ((this.rV.get(8) & 255) << 8) | (this.rV.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.sa = new a(null);
                    this.sa.sg = i4;
                    this.sa.sh = z;
                    this.sa.si = i3;
                    this.sa.sk = (int) j;
                    this.sa.sj = i2;
                    this.sa.sl = this.sa.sj + this.sa.sk;
                    this.sa.sm = null;
                    int position = this.rV.position();
                    this.sa.so = new byte[this.sa.sj];
                    this.rV.position(0);
                    this.rV.get(this.sa.so, 0, this.sa.sj);
                    this.rV.position(this.sa.sj);
                    this.rV.limit(position);
                    this.rV.compact();
                    return this.sa.sk == 0 || this.rV.position() >= this.sa.sk;
                }
                return false;
            }
            return false;
        } else if (this.sb < this.sa.sk) {
            int position2 = this.rV.position();
            if (this.sa.sk - this.sb < position2) {
                position2 = this.sa.sk - this.sb;
            }
            int position3 = this.rV.position();
            if (this.sa.sk > 0) {
                bArr = new byte[position2];
                this.rV.position(0);
                this.rV.get(bArr, 0, position2);
            }
            this.rV.position(position2);
            this.rV.limit(position3);
            this.rV.compact();
            if (bArr != null) {
                this.rW.write(bArr);
            }
            this.sb = position2 + this.sb;
            return this.sb >= this.sa.sk;
        } else {
            if (this.sa.sg <= 7) {
                if (!this.rY) {
                    this.rY = true;
                    this.rZ = this.sa.sg;
                    if (this.rZ == 1 && this.rp.gA()) {
                        this.sc.reset();
                    }
                }
                if (this.rZ == 1 && this.rp.gA() && !this.sc.q(this.rW.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.sa.sh) {
                    if (this.rZ == 1) {
                        if (this.rp.gA() && !this.sc.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.rp.gv()) {
                            r(this.rW.toByteArray());
                        } else {
                            A(new String(this.rW.toByteArray(), "UTF-8"));
                        }
                    } else if (this.rZ != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.rW.toByteArray());
                    }
                    this.rY = false;
                    this.rW.reset();
                }
            } else if (this.sa.sg == 8) {
                if (this.sa.sk >= 2) {
                    i = (this.sa.so[1] & 255) + ((this.sa.so[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.sa.sk > 2) {
                        byte[] bArr2 = new byte[this.sa.sk - 2];
                        System.arraycopy(this.sa.so, 2, bArr2, 0, this.sa.sk - 2);
                        f fVar = new f();
                        fVar.q(bArr2);
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
            } else if (this.sa.sg == 9) {
                s(this.rW.toByteArray());
            } else if (this.sa.sg != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.rW.toByteArray());
            }
            this.sa = null;
            this.sb = 0;
            return this.rV.position() > 0;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        t(new m.q(z, map));
    }

    protected void e(int i, String str) {
        t(new m.c(i, str));
    }

    protected void s(byte[] bArr) {
        t(new m.j(bArr));
    }

    protected void t(byte[] bArr) {
        t(new m.k(bArr));
    }

    protected void A(String str) {
        t(new m.s(str));
    }

    protected void r(byte[] bArr) {
        t(new m.C0010m(bArr));
    }

    protected void u(byte[] bArr) {
        this.sf = System.currentTimeMillis();
        t(new m.a(bArr, this.se, this.sf));
    }

    private boolean gE() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.rV.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.rV.get(position + 0) != 13 || this.rV.get(position + 1) != 10 || this.rV.get(position + 2) != 13 || this.rV.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.rV.position();
                Map<String, String> map = null;
                if (this.rV.get(0) == 72 && this.rV.get(1) == 84 && this.rV.get(2) == 84 && this.rV.get(3) == 80) {
                    Pair<Integer, String> gF = gF();
                    if (((Integer) gF.first).intValue() >= 300) {
                        t(new m.p(((Integer) gF.first).intValue(), (String) gF.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.rV.position(0);
                        byte[] bArr = new byte[position];
                        this.rV.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.rV.position(position + 4);
                this.rV.limit(position2);
                this.rV.compact();
                if (this.sd < this.rg.gd() && map.size() == 0) {
                    this.sd++;
                    return true;
                }
                this.sd = 0;
                if (!z) {
                    z2 = this.rV.position() > 0;
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

    private Map<String, String> v(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> gF() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.rV.position() && this.rV.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.rV.position() && this.rV.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.rV.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.rV.position() && this.rV.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.rV.position(i6);
        this.rV.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean gG() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return gD();
        }
        if (this.mState == 1) {
            return gE();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.rg.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.rV.clear();
            do {
                try {
                    int read = this.rg.read(this.rV);
                    if (read > 0) {
                        if (this.se <= 0) {
                            this.se = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            rX += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (gG());
                    } else if (read < 0) {
                        t(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.fq()) {
                        this.mStopped = true;
                        t(new m.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (WebSocketException e2) {
            t(new m.l(e2));
        } catch (SocketException e3) {
            t(new m.d(e3));
        } catch (Exception e4) {
            t(new m.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void gm() {
        synchronized (o.class) {
            rX = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = rX;
        }
        return j;
    }
}
