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
    private static long AX = 0;
    private final Handler AU;
    private final ByteBuffer AV;
    private final d AW;
    private boolean AY;
    private int AZ;
    private final e.a Ah;
    private final n Ap;
    private a Ba;
    private int Bb;
    private final f Bc;
    private int Bd;
    private long Be;
    private long Bf;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Bg;
        public boolean Bh;
        public int Bi;
        public int Bj;
        public int Bk;
        public int Bl;
        public byte[] Bm;
        public byte[] Bn;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AY = false;
        this.Bc = new f();
        this.Bd = 0;
        this.Be = 0L;
        this.Bf = 0L;
        this.AU = handler;
        this.Ah = aVar;
        this.Ap = nVar;
        this.AV = ByteBuffer.allocateDirect(nVar.in() + 14);
        this.AW = new d(nVar.io());
        this.Ba = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.Be = 0L;
        this.Bf = 0L;
        Message obtainMessage = this.AU.obtainMessage();
        obtainMessage.obj = obj;
        this.AU.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean iu() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Ba == null) {
            if (this.AV.position() >= 2) {
                byte b = this.AV.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.AV.get(1);
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
                    if (!this.AY && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.AY && i4 != 0) {
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
                if (this.AV.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.AV.get(2) & 255) << 8) | (this.AV.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.AV.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.AV.get(2) & 255) << 56) | ((this.AV.get(3) & 255) << 48) | ((this.AV.get(4) & 255) << 40) | ((this.AV.get(5) & 255) << 32) | ((this.AV.get(6) & 255) << 24) | ((this.AV.get(7) & 255) << 16) | ((this.AV.get(8) & 255) << 8) | (this.AV.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.Ba = new a(null);
                    this.Ba.Bg = i4;
                    this.Ba.Bh = z;
                    this.Ba.Bi = i3;
                    this.Ba.Bk = (int) j;
                    this.Ba.Bj = i2;
                    this.Ba.Bl = this.Ba.Bj + this.Ba.Bk;
                    this.Ba.Bm = null;
                    int position = this.AV.position();
                    this.Ba.Bn = new byte[this.Ba.Bj];
                    this.AV.position(0);
                    this.AV.get(this.Ba.Bn, 0, this.Ba.Bj);
                    this.AV.position(this.Ba.Bj);
                    this.AV.limit(position);
                    this.AV.compact();
                    return this.Ba.Bk == 0 || this.AV.position() >= this.Ba.Bk;
                }
                return false;
            }
            return false;
        } else if (this.Bb < this.Ba.Bk) {
            int position2 = this.AV.position();
            if (this.Ba.Bk - this.Bb < position2) {
                position2 = this.Ba.Bk - this.Bb;
            }
            int position3 = this.AV.position();
            if (this.Ba.Bk > 0) {
                bArr = new byte[position2];
                this.AV.position(0);
                this.AV.get(bArr, 0, position2);
            }
            this.AV.position(position2);
            this.AV.limit(position3);
            this.AV.compact();
            if (bArr != null) {
                this.AW.write(bArr);
            }
            this.Bb = position2 + this.Bb;
            return this.Bb >= this.Ba.Bk;
        } else {
            if (this.Ba.Bg <= 7) {
                if (!this.AY) {
                    this.AY = true;
                    this.AZ = this.Ba.Bg;
                    if (this.AZ == 1 && this.Ap.ir()) {
                        this.Bc.reset();
                    }
                }
                if (this.AZ == 1 && this.Ap.ir() && !this.Bc.q(this.AW.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Ba.Bh) {
                    if (this.AZ == 1) {
                        if (this.Ap.ir() && !this.Bc.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ap.im()) {
                            r(this.AW.toByteArray());
                        } else {
                            x(new String(this.AW.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AZ != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        u(this.AW.toByteArray());
                    }
                    this.AY = false;
                    this.AW.reset();
                }
            } else if (this.Ba.Bg == 8) {
                if (this.Ba.Bk >= 2) {
                    i = (this.Ba.Bn[1] & 255) + ((this.Ba.Bn[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.Ba.Bk > 2) {
                        byte[] bArr2 = new byte[this.Ba.Bk - 2];
                        System.arraycopy(this.Ba.Bn, 2, bArr2, 0, this.Ba.Bk - 2);
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
            } else if (this.Ba.Bg == 9) {
                s(this.AW.toByteArray());
            } else if (this.Ba.Bg != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(this.AW.toByteArray());
            }
            this.Ba = null;
            this.Bb = 0;
            return this.AV.position() > 0;
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
        this.Bf = System.currentTimeMillis();
        t(new m.a(bArr, this.Be, this.Bf));
    }

    private boolean iv() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.AV.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AV.get(position + 0) != 13 || this.AV.get(position + 1) != 10 || this.AV.get(position + 2) != 13 || this.AV.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AV.position();
                Map<String, String> map = null;
                if (this.AV.get(0) == 72 && this.AV.get(1) == 84 && this.AV.get(2) == 84 && this.AV.get(3) == 80) {
                    Pair<Integer, String> iw = iw();
                    if (((Integer) iw.first).intValue() >= 300) {
                        t(new m.p(((Integer) iw.first).intValue(), (String) iw.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AV.position(0);
                        byte[] bArr = new byte[position];
                        this.AV.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.AV.position(position + 4);
                this.AV.limit(position2);
                this.AV.compact();
                if (this.Bd < this.Ah.hV() && map.size() == 0) {
                    this.Bd++;
                    return true;
                }
                this.Bd = 0;
                if (!z) {
                    z2 = this.AV.position() > 0;
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
        while (i < this.AV.position() && this.AV.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AV.position() && this.AV.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AV.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AV.position() && this.AV.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AV.position(i6);
        this.AV.get(bArr, 0, i8);
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
            this.Ah.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AV.clear();
            do {
                try {
                    int read = this.Ah.read(this.AV);
                    if (read > 0) {
                        if (this.Be <= 0) {
                            this.Be = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            AX += read;
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
                    if (!com.baidu.adp.lib.util.i.hj()) {
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
            AX = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AX;
        }
        return j;
    }
}
