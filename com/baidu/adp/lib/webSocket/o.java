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
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class o extends Thread {
    private static long ur = 0;
    private int mState;
    private boolean mStopped;
    private final e.a tA;
    private final n tI;
    private final Handler uo;
    private final ByteBuffer up;
    private final d uq;
    private boolean us;
    private int ut;
    private a uu;
    private int uv;
    private final f uw;
    private int ux;
    private long uy;
    private long uz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int uA;
        public boolean uB;
        public int uC;
        public int uD;
        public int uE;
        public int uF;
        public byte[] uG;
        public byte[] uH;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.us = false;
        this.uw = new f();
        this.ux = 0;
        this.uy = 0L;
        this.uz = 0L;
        this.uo = handler;
        this.tA = aVar;
        this.tI = nVar;
        this.up = ByteBuffer.allocateDirect(nVar.hr() + 14);
        this.uq = new d(nVar.hs());
        this.uu = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.uy = 0L;
        this.uz = 0L;
        Message obtainMessage = this.uo.obtainMessage();
        obtainMessage.obj = obj;
        this.uo.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean hy() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.uu == null) {
            if (this.up.position() >= 2) {
                byte b = this.up.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.up.get(1);
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
                    if (!this.us && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.us && i4 != 0) {
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
                if (this.up.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.up.get(2) & 255) << 8) | (this.up.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.up.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.up.get(2) & 255) << 56) | ((this.up.get(3) & 255) << 48) | ((this.up.get(4) & 255) << 40) | ((this.up.get(5) & 255) << 32) | ((this.up.get(6) & 255) << 24) | ((this.up.get(7) & 255) << 16) | ((this.up.get(8) & 255) << 8) | (this.up.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.uu = new a(null);
                    this.uu.uA = i4;
                    this.uu.uB = z;
                    this.uu.uC = i3;
                    this.uu.uE = (int) j;
                    this.uu.uD = i2;
                    this.uu.uF = this.uu.uD + this.uu.uE;
                    this.uu.uG = null;
                    int position = this.up.position();
                    this.uu.uH = new byte[this.uu.uD];
                    this.up.position(0);
                    this.up.get(this.uu.uH, 0, this.uu.uD);
                    this.up.position(this.uu.uD);
                    this.up.limit(position);
                    this.up.compact();
                    return this.uu.uE == 0 || this.up.position() >= this.uu.uE;
                }
                return false;
            }
            return false;
        } else if (this.uv < this.uu.uE) {
            int position2 = this.up.position();
            if (this.uu.uE - this.uv < position2) {
                position2 = this.uu.uE - this.uv;
            }
            int position3 = this.up.position();
            if (this.uu.uE > 0) {
                bArr = new byte[position2];
                this.up.position(0);
                this.up.get(bArr, 0, position2);
            }
            this.up.position(position2);
            this.up.limit(position3);
            this.up.compact();
            if (bArr != null) {
                this.uq.write(bArr);
            }
            this.uv = position2 + this.uv;
            return this.uv >= this.uu.uE;
        } else {
            if (this.uu.uA <= 7) {
                if (!this.us) {
                    this.us = true;
                    this.ut = this.uu.uA;
                    if (this.ut == 1 && this.tI.hv()) {
                        this.uw.reset();
                    }
                }
                if (this.ut == 1 && this.tI.hv() && !this.uw.q(this.uq.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.uu.uB) {
                    if (this.ut == 1) {
                        if (this.tI.hv() && !this.uw.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.tI.hq()) {
                            r(this.uq.toByteArray());
                        } else {
                            B(new String(this.uq.toByteArray(), "UTF-8"));
                        }
                    } else if (this.ut != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.uq.toByteArray());
                    }
                    this.us = false;
                    this.uq.reset();
                }
            } else if (this.uu.uA == 8) {
                if (this.uu.uE >= 2) {
                    i = (this.uu.uH[1] & 255) + ((this.uu.uH[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.uu.uE > 2) {
                        byte[] bArr2 = new byte[this.uu.uE - 2];
                        System.arraycopy(this.uu.uH, 2, bArr2, 0, this.uu.uE - 2);
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
                d(i, str);
            } else if (this.uu.uA == 9) {
                s(this.uq.toByteArray());
            } else if (this.uu.uA != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.uq.toByteArray());
            }
            this.uu = null;
            this.uv = 0;
            return this.up.position() > 0;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        t(new m.q(z, map));
    }

    protected void d(int i, String str) {
        t(new m.c(i, str));
    }

    protected void s(byte[] bArr) {
        t(new m.j(bArr));
    }

    protected void t(byte[] bArr) {
        t(new m.k(bArr));
    }

    protected void B(String str) {
        t(new m.s(str));
    }

    protected void r(byte[] bArr) {
        t(new m.C0010m(bArr));
    }

    protected void u(byte[] bArr) {
        this.uz = System.currentTimeMillis();
        t(new m.a(bArr, this.uy, this.uz));
    }

    private boolean hz() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.up.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.up.get(position + 0) != 13 || this.up.get(position + 1) != 10 || this.up.get(position + 2) != 13 || this.up.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.up.position();
                Map<String, String> map = null;
                if (this.up.get(0) == 72 && this.up.get(1) == 84 && this.up.get(2) == 84 && this.up.get(3) == 80) {
                    Pair<Integer, String> hA = hA();
                    if (((Integer) hA.first).intValue() >= 300) {
                        t(new m.p(((Integer) hA.first).intValue(), (String) hA.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.up.position(0);
                        byte[] bArr = new byte[position];
                        this.up.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.up.position(position + 4);
                this.up.limit(position2);
                this.up.compact();
                if (this.ux < this.tA.gY() && map.size() == 0) {
                    this.ux++;
                    return true;
                }
                this.ux = 0;
                if (!z) {
                    z2 = this.up.position() > 0;
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

    private Pair<Integer, String> hA() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.up.position() && this.up.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.up.position() && this.up.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.up.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.up.position() && this.up.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.up.position(i6);
        this.up.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean hB() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return hy();
        }
        if (this.mState == 1) {
            return hz();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.tA.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.up.clear();
            do {
                try {
                    int read = this.tA.read(this.up);
                    if (read > 0) {
                        if (this.uy <= 0) {
                            this.uy = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            ur += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (hB());
                    } else if (read < 0) {
                        t(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.gm()) {
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

    public void hh() {
        synchronized (o.class) {
            ur = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = ur;
        }
        return j;
    }
}
