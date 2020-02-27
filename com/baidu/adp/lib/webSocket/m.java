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
    private static long vZ = 0;
    private int mState;
    private boolean mStopped;
    private final Handler vW;
    private final ByteBuffer vX;
    private final d vY;
    private final e.a vo;
    private final l vx;
    private boolean wa;
    private int wb;
    private a wc;
    private int we;
    private final f wf;
    private int wg;
    private long wh;
    private long wi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int wj;
        public boolean wk;
        public int wl;
        public int wn;
        public int wo;
        public int wp;
        public byte[] wq;
        public byte[] wr;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.wa = false;
        this.wf = new f();
        this.wg = 0;
        this.wh = 0L;
        this.wi = 0L;
        this.vW = handler;
        this.vo = aVar;
        this.vx = lVar;
        this.vX = ByteBuffer.allocateDirect(lVar.iq() + 14);
        this.vY = new d(lVar.ir());
        this.wc = null;
        this.mState = 1;
    }

    protected void u(Object obj) {
        this.wh = 0L;
        this.wi = 0L;
        Message obtainMessage = this.vW.obtainMessage();
        obtainMessage.obj = obj;
        this.vW.sendMessage(obtainMessage);
    }

    private boolean ix() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.wc == null) {
            if (this.vX.position() >= 2) {
                byte b = this.vX.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.vX.get(1);
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
                    if (!this.wa && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.wa && i4 != 0) {
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
                if (this.vX.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.vX.get(2) & 255) << 8) | (this.vX.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.vX.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.vX.get(2) & 255) << 56) | ((this.vX.get(3) & 255) << 48) | ((this.vX.get(4) & 255) << 40) | ((this.vX.get(5) & 255) << 32) | ((this.vX.get(6) & 255) << 24) | ((this.vX.get(7) & 255) << 16) | ((this.vX.get(8) & 255) << 8) | (this.vX.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.wc = new a();
                    this.wc.wj = i4;
                    this.wc.wk = z;
                    this.wc.wl = i3;
                    this.wc.wo = (int) j;
                    this.wc.wn = i2;
                    this.wc.wp = this.wc.wn + this.wc.wo;
                    this.wc.wq = null;
                    int position = this.vX.position();
                    this.wc.wr = new byte[this.wc.wn];
                    this.vX.position(0);
                    this.vX.get(this.wc.wr, 0, this.wc.wn);
                    this.vX.position(this.wc.wn);
                    this.vX.limit(position);
                    this.vX.compact();
                    return this.wc.wo == 0 || this.vX.position() >= this.wc.wo;
                }
                return false;
            }
            return false;
        } else if (this.we >= this.wc.wo) {
            if (this.wc.wj > 7) {
                if (this.wc.wj == 8) {
                    if (this.wc.wo < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.wc.wr[1] & 255) + ((this.wc.wr[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.wc.wo > 2) {
                            byte[] bArr2 = new byte[this.wc.wo - 2];
                            System.arraycopy(this.wc.wr, 2, bArr2, 0, this.wc.wo - 2);
                            f fVar = new f();
                            fVar.g(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.wc.wj == 9) {
                    i(this.vY.toByteArray());
                } else if (this.wc.wj == 10) {
                    j(this.vY.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.wa) {
                    this.wa = true;
                    this.wb = this.wc.wj;
                    if (this.wb == 1 && this.vx.iu()) {
                        this.wf.reset();
                    }
                }
                if (this.wb == 1 && this.vx.iu() && !this.wf.g(this.vY.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.wc.wk) {
                    if (this.wb == 1) {
                        if (this.vx.iu() && !this.wf.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.vx.ip()) {
                            h(this.vY.toByteArray());
                        } else {
                            onTextMessage(new String(this.vY.toByteArray(), "UTF-8"));
                        }
                    } else if (this.wb == 2) {
                        k(this.vY.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.wa = false;
                    this.vY.reset();
                }
            }
            this.wc = null;
            this.we = 0;
            return this.vX.position() > 0;
        } else {
            int position2 = this.vX.position();
            if (this.wc.wo - this.we < position2) {
                position2 = this.wc.wo - this.we;
            }
            int position3 = this.vX.position();
            if (this.wc.wo > 0) {
                bArr = new byte[position2];
                this.vX.position(0);
                this.vX.get(bArr, 0, position2);
            }
            this.vX.position(position2);
            this.vX.limit(position3);
            this.vX.compact();
            if (bArr != null) {
                this.vY.write(bArr);
            }
            this.we = position2 + this.we;
            return this.we >= this.wc.wo;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        u(new k.q(z, map));
    }

    protected void e(int i, String str) {
        u(new k.c(i, str));
    }

    protected void i(byte[] bArr) {
        u(new k.j(bArr));
    }

    protected void j(byte[] bArr) {
        u(new k.C0021k(bArr));
    }

    protected void onTextMessage(String str) {
        u(new k.s(str));
    }

    protected void h(byte[] bArr) {
        u(new k.m(bArr));
    }

    protected void k(byte[] bArr) {
        this.wi = System.currentTimeMillis();
        u(new k.a(bArr, this.wh, this.wi));
    }

    private boolean iy() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.vX.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.vX.get(position + 0) != 13 || this.vX.get(position + 1) != 10 || this.vX.get(position + 2) != 13 || this.vX.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.vX.position();
                Map<String, String> map = null;
                if (this.vX.get(0) == 72 && this.vX.get(1) == 84 && this.vX.get(2) == 84 && this.vX.get(3) == 80) {
                    Pair<Integer, String> iz = iz();
                    if (((Integer) iz.first).intValue() >= 300) {
                        u(new k.p(((Integer) iz.first).intValue(), (String) iz.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.vX.position(0);
                        byte[] bArr = new byte[position];
                        this.vX.get(bArr);
                        map = l(bArr);
                    }
                } else {
                    z = false;
                }
                this.vX.position(position + 4);
                this.vX.limit(position2);
                this.vX.compact();
                if (this.wg < this.vo.hY() && map.size() == 0) {
                    this.wg++;
                    return true;
                }
                this.wg = 0;
                if (!z) {
                    z2 = this.vX.position() > 0;
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

    private Map<String, String> l(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> iz() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.vX.position() && this.vX.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.vX.position() && this.vX.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.vX.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.vX.position() && this.vX.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.vX.position(i6);
        this.vX.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean iA() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return ix();
        }
        if (this.mState == 1) {
            return iy();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.vo.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.vX.clear();
            do {
                try {
                    int read = this.vo.read(this.vX);
                    if (read > 0) {
                        if (this.wh <= 0) {
                            this.wh = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            vZ += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (iA());
                    } else if (read < 0) {
                        u(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        u(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            u(new k.d(e2));
        } catch (WebSocketException e3) {
            u(new k.l(e3));
        } catch (Exception e4) {
            u(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m14if() {
        synchronized (m.class) {
            vZ = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = vZ;
        }
        return j;
    }
}
