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
    private static long uh = 0;
    private int mState;
    private boolean mStopped;
    private final e.a tr;
    private final n tz;
    private final Handler ue;
    private final ByteBuffer uf;
    private final d ug;
    private boolean ui;
    private int uj;
    private a uk;
    private int ul;
    private final f um;
    private int uo;
    private long up;
    private long uq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int ur;
        public boolean us;
        public int ut;
        public int uu;
        public int uv;
        public int uw;
        public byte[] ux;
        public byte[] uy;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.ui = false;
        this.um = new f();
        this.uo = 0;
        this.up = 0L;
        this.uq = 0L;
        this.ue = handler;
        this.tr = aVar;
        this.tz = nVar;
        this.uf = ByteBuffer.allocateDirect(nVar.hp() + 14);
        this.ug = new d(nVar.hq());
        this.uk = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.up = 0L;
        this.uq = 0L;
        Message obtainMessage = this.ue.obtainMessage();
        obtainMessage.obj = obj;
        this.ue.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean hw() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.uk == null) {
            if (this.uf.position() >= 2) {
                byte b = this.uf.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.uf.get(1);
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
                    if (!this.ui && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.ui && i4 != 0) {
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
                if (this.uf.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.uf.get(2) & 255) << 8) | (this.uf.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.uf.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.uf.get(2) & 255) << 56) | ((this.uf.get(3) & 255) << 48) | ((this.uf.get(4) & 255) << 40) | ((this.uf.get(5) & 255) << 32) | ((this.uf.get(6) & 255) << 24) | ((this.uf.get(7) & 255) << 16) | ((this.uf.get(8) & 255) << 8) | (this.uf.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.uk = new a(null);
                    this.uk.ur = i4;
                    this.uk.us = z;
                    this.uk.ut = i3;
                    this.uk.uv = (int) j;
                    this.uk.uu = i2;
                    this.uk.uw = this.uk.uu + this.uk.uv;
                    this.uk.ux = null;
                    int position = this.uf.position();
                    this.uk.uy = new byte[this.uk.uu];
                    this.uf.position(0);
                    this.uf.get(this.uk.uy, 0, this.uk.uu);
                    this.uf.position(this.uk.uu);
                    this.uf.limit(position);
                    this.uf.compact();
                    return this.uk.uv == 0 || this.uf.position() >= this.uk.uv;
                }
                return false;
            }
            return false;
        } else if (this.ul < this.uk.uv) {
            int position2 = this.uf.position();
            if (this.uk.uv - this.ul < position2) {
                position2 = this.uk.uv - this.ul;
            }
            int position3 = this.uf.position();
            if (this.uk.uv > 0) {
                bArr = new byte[position2];
                this.uf.position(0);
                this.uf.get(bArr, 0, position2);
            }
            this.uf.position(position2);
            this.uf.limit(position3);
            this.uf.compact();
            if (bArr != null) {
                this.ug.write(bArr);
            }
            this.ul = position2 + this.ul;
            return this.ul >= this.uk.uv;
        } else {
            if (this.uk.ur <= 7) {
                if (!this.ui) {
                    this.ui = true;
                    this.uj = this.uk.ur;
                    if (this.uj == 1 && this.tz.ht()) {
                        this.um.reset();
                    }
                }
                if (this.uj == 1 && this.tz.ht() && !this.um.q(this.ug.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.uk.us) {
                    if (this.uj == 1) {
                        if (this.tz.ht() && !this.um.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.tz.ho()) {
                            r(this.ug.toByteArray());
                        } else {
                            B(new String(this.ug.toByteArray(), "UTF-8"));
                        }
                    } else if (this.uj != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.ug.toByteArray());
                    }
                    this.ui = false;
                    this.ug.reset();
                }
            } else if (this.uk.ur == 8) {
                if (this.uk.uv >= 2) {
                    i = (this.uk.uy[1] & 255) + ((this.uk.uy[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.uk.uv > 2) {
                        byte[] bArr2 = new byte[this.uk.uv - 2];
                        System.arraycopy(this.uk.uy, 2, bArr2, 0, this.uk.uv - 2);
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
            } else if (this.uk.ur == 9) {
                s(this.ug.toByteArray());
            } else if (this.uk.ur != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.ug.toByteArray());
            }
            this.uk = null;
            this.ul = 0;
            return this.uf.position() > 0;
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
        t(new m.C0009m(bArr));
    }

    protected void u(byte[] bArr) {
        this.uq = System.currentTimeMillis();
        t(new m.a(bArr, this.up, this.uq));
    }

    private boolean hx() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.uf.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.uf.get(position + 0) != 13 || this.uf.get(position + 1) != 10 || this.uf.get(position + 2) != 13 || this.uf.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.uf.position();
                Map<String, String> map = null;
                if (this.uf.get(0) == 72 && this.uf.get(1) == 84 && this.uf.get(2) == 84 && this.uf.get(3) == 80) {
                    Pair<Integer, String> hy = hy();
                    if (((Integer) hy.first).intValue() >= 300) {
                        t(new m.p(((Integer) hy.first).intValue(), (String) hy.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.uf.position(0);
                        byte[] bArr = new byte[position];
                        this.uf.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.uf.position(position + 4);
                this.uf.limit(position2);
                this.uf.compact();
                if (this.uo < this.tr.gW() && map.size() == 0) {
                    this.uo++;
                    return true;
                }
                this.uo = 0;
                if (!z) {
                    z2 = this.uf.position() > 0;
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

    private Pair<Integer, String> hy() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.uf.position() && this.uf.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.uf.position() && this.uf.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.uf.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.uf.position() && this.uf.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.uf.position(i6);
        this.uf.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean hz() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return hw();
        }
        if (this.mState == 1) {
            return hx();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.tr.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.uf.clear();
            do {
                try {
                    int read = this.tr.read(this.uf);
                    if (read > 0) {
                        if (this.up <= 0) {
                            this.up = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            uh += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (hz());
                    } else if (read < 0) {
                        t(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.gk()) {
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

    public void hf() {
        synchronized (o.class) {
            uh = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = uh;
        }
        return j;
    }
}
