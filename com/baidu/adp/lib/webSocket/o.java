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
    private static long Ba = 0;
    private final Handler AX;
    private final ByteBuffer AY;
    private final d AZ;
    private final e.a Ak;
    private final n As;
    private boolean Bb;
    private int Bc;
    private a Bd;
    private int Be;
    private final f Bf;
    private int Bg;
    private long Bh;
    private long Bi;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Bj;
        public boolean Bk;
        public int Bl;
        public int Bm;
        public int Bn;
        public int Bo;
        public byte[] Bp;
        public byte[] Bq;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.Bb = false;
        this.Bf = new f();
        this.Bg = 0;
        this.Bh = 0L;
        this.Bi = 0L;
        this.AX = handler;
        this.Ak = aVar;
        this.As = nVar;
        this.AY = ByteBuffer.allocateDirect(nVar.in() + 14);
        this.AZ = new d(nVar.io());
        this.Bd = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.Bh = 0L;
        this.Bi = 0L;
        Message obtainMessage = this.AX.obtainMessage();
        obtainMessage.obj = obj;
        this.AX.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean iu() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Bd == null) {
            if (this.AY.position() >= 2) {
                byte b = this.AY.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.AY.get(1);
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
                    if (!this.Bb && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Bb && i4 != 0) {
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
                if (this.AY.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.AY.get(2) & 255) << 8) | (this.AY.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.AY.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.AY.get(2) & 255) << 56) | ((this.AY.get(3) & 255) << 48) | ((this.AY.get(4) & 255) << 40) | ((this.AY.get(5) & 255) << 32) | ((this.AY.get(6) & 255) << 24) | ((this.AY.get(7) & 255) << 16) | ((this.AY.get(8) & 255) << 8) | (this.AY.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.Bd = new a(null);
                    this.Bd.Bj = i4;
                    this.Bd.Bk = z;
                    this.Bd.Bl = i3;
                    this.Bd.Bn = (int) j;
                    this.Bd.Bm = i2;
                    this.Bd.Bo = this.Bd.Bm + this.Bd.Bn;
                    this.Bd.Bp = null;
                    int position = this.AY.position();
                    this.Bd.Bq = new byte[this.Bd.Bm];
                    this.AY.position(0);
                    this.AY.get(this.Bd.Bq, 0, this.Bd.Bm);
                    this.AY.position(this.Bd.Bm);
                    this.AY.limit(position);
                    this.AY.compact();
                    return this.Bd.Bn == 0 || this.AY.position() >= this.Bd.Bn;
                }
                return false;
            }
            return false;
        } else if (this.Be < this.Bd.Bn) {
            int position2 = this.AY.position();
            if (this.Bd.Bn - this.Be < position2) {
                position2 = this.Bd.Bn - this.Be;
            }
            int position3 = this.AY.position();
            if (this.Bd.Bn > 0) {
                bArr = new byte[position2];
                this.AY.position(0);
                this.AY.get(bArr, 0, position2);
            }
            this.AY.position(position2);
            this.AY.limit(position3);
            this.AY.compact();
            if (bArr != null) {
                this.AZ.write(bArr);
            }
            this.Be = position2 + this.Be;
            return this.Be >= this.Bd.Bn;
        } else {
            if (this.Bd.Bj <= 7) {
                if (!this.Bb) {
                    this.Bb = true;
                    this.Bc = this.Bd.Bj;
                    if (this.Bc == 1 && this.As.ir()) {
                        this.Bf.reset();
                    }
                }
                if (this.Bc == 1 && this.As.ir() && !this.Bf.q(this.AZ.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Bd.Bk) {
                    if (this.Bc == 1) {
                        if (this.As.ir() && !this.Bf.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.As.im()) {
                            r(this.AZ.toByteArray());
                        } else {
                            x(new String(this.AZ.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Bc != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.AZ.toByteArray());
                    }
                    this.Bb = false;
                    this.AZ.reset();
                }
            } else if (this.Bd.Bj == 8) {
                if (this.Bd.Bn >= 2) {
                    i = (this.Bd.Bq[1] & 255) + ((this.Bd.Bq[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.Bd.Bn > 2) {
                        byte[] bArr2 = new byte[this.Bd.Bn - 2];
                        System.arraycopy(this.Bd.Bq, 2, bArr2, 0, this.Bd.Bn - 2);
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
            } else if (this.Bd.Bj == 9) {
                s(this.AZ.toByteArray());
            } else if (this.Bd.Bj != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.AZ.toByteArray());
            }
            this.Bd = null;
            this.Be = 0;
            return this.AY.position() > 0;
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

    protected void x(String str) {
        t(new m.s(str));
    }

    protected void r(byte[] bArr) {
        t(new m.C0008m(bArr));
    }

    protected void u(byte[] bArr) {
        this.Bi = System.currentTimeMillis();
        t(new m.a(bArr, this.Bh, this.Bi));
    }

    private boolean iv() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.AY.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AY.get(position + 0) != 13 || this.AY.get(position + 1) != 10 || this.AY.get(position + 2) != 13 || this.AY.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AY.position();
                Map<String, String> map = null;
                if (this.AY.get(0) == 72 && this.AY.get(1) == 84 && this.AY.get(2) == 84 && this.AY.get(3) == 80) {
                    Pair<Integer, String> iw = iw();
                    if (((Integer) iw.first).intValue() >= 300) {
                        t(new m.p(((Integer) iw.first).intValue(), (String) iw.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AY.position(0);
                        byte[] bArr = new byte[position];
                        this.AY.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.AY.position(position + 4);
                this.AY.limit(position2);
                this.AY.compact();
                if (this.Bg < this.Ak.hV() && map.size() == 0) {
                    this.Bg++;
                    return true;
                }
                this.Bg = 0;
                if (!z) {
                    z2 = this.AY.position() > 0;
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

    private Pair<Integer, String> iw() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.AY.position() && this.AY.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AY.position() && this.AY.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AY.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AY.position() && this.AY.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AY.position(i6);
        this.AY.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean ix() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return iu();
        }
        if (this.mState == 1) {
            return iv();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ak.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AY.clear();
            do {
                try {
                    int read = this.Ak.read(this.AY);
                    if (read > 0) {
                        if (this.Bh <= 0) {
                            this.Bh = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            Ba += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ix());
                    } else if (read < 0) {
                        t(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.hk()) {
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

    public void id() {
        synchronized (o.class) {
            Ba = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = Ba;
        }
        return j;
    }
}
