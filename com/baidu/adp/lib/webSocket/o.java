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
    private static long uq = 0;
    private int mState;
    private boolean mStopped;
    private final n tH;
    private final e.a tz;
    private final Handler um;
    private final ByteBuffer uo;
    private final d up;
    private boolean ur;
    private int us;
    private a ut;
    private int uu;
    private final f uv;
    private int uw;
    private long ux;
    private long uy;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public boolean uA;
        public int uB;
        public int uC;
        public int uD;
        public int uE;
        public byte[] uF;
        public byte[] uG;
        public int uz;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.ur = false;
        this.uv = new f();
        this.uw = 0;
        this.ux = 0L;
        this.uy = 0L;
        this.um = handler;
        this.tz = aVar;
        this.tH = nVar;
        this.uo = ByteBuffer.allocateDirect(nVar.hr() + 14);
        this.up = new d(nVar.hs());
        this.ut = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.ux = 0L;
        this.uy = 0L;
        Message obtainMessage = this.um.obtainMessage();
        obtainMessage.obj = obj;
        this.um.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean hy() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.ut == null) {
            if (this.uo.position() >= 2) {
                byte b = this.uo.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.uo.get(1);
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
                    if (!this.ur && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.ur && i4 != 0) {
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
                if (this.uo.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.uo.get(2) & 255) << 8) | (this.uo.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.uo.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.uo.get(2) & 255) << 56) | ((this.uo.get(3) & 255) << 48) | ((this.uo.get(4) & 255) << 40) | ((this.uo.get(5) & 255) << 32) | ((this.uo.get(6) & 255) << 24) | ((this.uo.get(7) & 255) << 16) | ((this.uo.get(8) & 255) << 8) | (this.uo.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.ut = new a(null);
                    this.ut.uz = i4;
                    this.ut.uA = z;
                    this.ut.uB = i3;
                    this.ut.uD = (int) j;
                    this.ut.uC = i2;
                    this.ut.uE = this.ut.uC + this.ut.uD;
                    this.ut.uF = null;
                    int position = this.uo.position();
                    this.ut.uG = new byte[this.ut.uC];
                    this.uo.position(0);
                    this.uo.get(this.ut.uG, 0, this.ut.uC);
                    this.uo.position(this.ut.uC);
                    this.uo.limit(position);
                    this.uo.compact();
                    return this.ut.uD == 0 || this.uo.position() >= this.ut.uD;
                }
                return false;
            }
            return false;
        } else if (this.uu < this.ut.uD) {
            int position2 = this.uo.position();
            if (this.ut.uD - this.uu < position2) {
                position2 = this.ut.uD - this.uu;
            }
            int position3 = this.uo.position();
            if (this.ut.uD > 0) {
                bArr = new byte[position2];
                this.uo.position(0);
                this.uo.get(bArr, 0, position2);
            }
            this.uo.position(position2);
            this.uo.limit(position3);
            this.uo.compact();
            if (bArr != null) {
                this.up.write(bArr);
            }
            this.uu = position2 + this.uu;
            return this.uu >= this.ut.uD;
        } else {
            if (this.ut.uz <= 7) {
                if (!this.ur) {
                    this.ur = true;
                    this.us = this.ut.uz;
                    if (this.us == 1 && this.tH.hv()) {
                        this.uv.reset();
                    }
                }
                if (this.us == 1 && this.tH.hv() && !this.uv.q(this.up.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.ut.uA) {
                    if (this.us == 1) {
                        if (this.tH.hv() && !this.uv.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.tH.hq()) {
                            r(this.up.toByteArray());
                        } else {
                            B(new String(this.up.toByteArray(), "UTF-8"));
                        }
                    } else if (this.us != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.up.toByteArray());
                    }
                    this.ur = false;
                    this.up.reset();
                }
            } else if (this.ut.uz == 8) {
                if (this.ut.uD >= 2) {
                    i = (this.ut.uG[1] & 255) + ((this.ut.uG[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.ut.uD > 2) {
                        byte[] bArr2 = new byte[this.ut.uD - 2];
                        System.arraycopy(this.ut.uG, 2, bArr2, 0, this.ut.uD - 2);
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
            } else if (this.ut.uz == 9) {
                s(this.up.toByteArray());
            } else if (this.ut.uz != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.up.toByteArray());
            }
            this.ut = null;
            this.uu = 0;
            return this.uo.position() > 0;
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

    protected void B(String str) {
        t(new m.s(str));
    }

    protected void r(byte[] bArr) {
        t(new m.C0010m(bArr));
    }

    protected void u(byte[] bArr) {
        this.uy = System.currentTimeMillis();
        t(new m.a(bArr, this.ux, this.uy));
    }

    private boolean hz() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.uo.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.uo.get(position + 0) != 13 || this.uo.get(position + 1) != 10 || this.uo.get(position + 2) != 13 || this.uo.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.uo.position();
                Map<String, String> map = null;
                if (this.uo.get(0) == 72 && this.uo.get(1) == 84 && this.uo.get(2) == 84 && this.uo.get(3) == 80) {
                    Pair<Integer, String> hA = hA();
                    if (((Integer) hA.first).intValue() >= 300) {
                        t(new m.p(((Integer) hA.first).intValue(), (String) hA.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.uo.position(0);
                        byte[] bArr = new byte[position];
                        this.uo.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.uo.position(position + 4);
                this.uo.limit(position2);
                this.uo.compact();
                if (this.uw < this.tz.gY() && map.size() == 0) {
                    this.uw++;
                    return true;
                }
                this.uw = 0;
                if (!z) {
                    z2 = this.uo.position() > 0;
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
        while (i < this.uo.position() && this.uo.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.uo.position() && this.uo.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.uo.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.uo.position() && this.uo.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.uo.position(i6);
        this.uo.get(bArr, 0, i8);
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
            this.tz.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.uo.clear();
            do {
                try {
                    int read = this.tz.read(this.uo);
                    if (read > 0) {
                        if (this.ux <= 0) {
                            this.ux = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            uq += read;
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
            uq = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = uq;
        }
        return j;
    }
}
