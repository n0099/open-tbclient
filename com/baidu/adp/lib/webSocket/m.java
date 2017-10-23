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
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long Az = 0;
    private boolean AA;
    private int AB;
    private a AC;
    private int AD;
    private final f AE;
    private int AF;
    private long AG;
    private long AH;
    private final Handler Aw;
    private final ByteBuffer Ax;
    private final d Ay;
    private int mState;
    private boolean mStopped;
    private final e.a zI;
    private final l zQ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AI;
        public boolean AJ;
        public int AK;
        public int AL;
        public int AM;
        public int AN;
        public byte[] AO;
        public byte[] AP;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.AA = false;
        this.AE = new f();
        this.AF = 0;
        this.AG = 0L;
        this.AH = 0L;
        this.Aw = handler;
        this.zI = aVar;
        this.zQ = lVar;
        this.Ax = ByteBuffer.allocateDirect(lVar.il() + 14);
        this.Ay = new d(lVar.im());
        this.AC = null;
        this.mState = 1;
    }

    protected void s(Object obj) {
        this.AG = 0L;
        this.AH = 0L;
        Message obtainMessage = this.Aw.obtainMessage();
        obtainMessage.obj = obj;
        this.Aw.sendMessage(obtainMessage);
    }

    private boolean is() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.AC == null) {
            if (this.Ax.position() >= 2) {
                byte b = this.Ax.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ax.get(1);
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
                    if (!this.AA && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.AA && i4 != 0) {
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
                if (this.Ax.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ax.get(2) & 255) << 8) | (this.Ax.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ax.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ax.get(2) & 255) << 56) | ((this.Ax.get(3) & 255) << 48) | ((this.Ax.get(4) & 255) << 40) | ((this.Ax.get(5) & 255) << 32) | ((this.Ax.get(6) & 255) << 24) | ((this.Ax.get(7) & 255) << 16) | ((this.Ax.get(8) & 255) << 8) | (this.Ax.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.AC = new a();
                    this.AC.AI = i4;
                    this.AC.AJ = z;
                    this.AC.AK = i3;
                    this.AC.AM = (int) j;
                    this.AC.AL = i2;
                    this.AC.AN = this.AC.AL + this.AC.AM;
                    this.AC.AO = null;
                    int position = this.Ax.position();
                    this.AC.AP = new byte[this.AC.AL];
                    this.Ax.position(0);
                    this.Ax.get(this.AC.AP, 0, this.AC.AL);
                    this.Ax.position(this.AC.AL);
                    this.Ax.limit(position);
                    this.Ax.compact();
                    return this.AC.AM == 0 || this.Ax.position() >= this.AC.AM;
                }
                return false;
            }
            return false;
        } else if (this.AD >= this.AC.AM) {
            if (this.AC.AI > 7) {
                if (this.AC.AI == 8) {
                    if (this.AC.AM < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.AC.AP[1] & 255) + ((this.AC.AP[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.AC.AM > 2) {
                            byte[] bArr2 = new byte[this.AC.AM - 2];
                            System.arraycopy(this.AC.AP, 2, bArr2, 0, this.AC.AM - 2);
                            f fVar = new f();
                            fVar.n(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.AC.AI == 9) {
                    p(this.Ay.toByteArray());
                } else if (this.AC.AI == 10) {
                    q(this.Ay.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.AA) {
                    this.AA = true;
                    this.AB = this.AC.AI;
                    if (this.AB == 1 && this.zQ.ip()) {
                        this.AE.reset();
                    }
                }
                if (this.AB == 1 && this.zQ.ip() && !this.AE.n(this.Ay.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AC.AJ) {
                    if (this.AB == 1) {
                        if (this.zQ.ip() && !this.AE.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zQ.ik()) {
                            o(this.Ay.toByteArray());
                        } else {
                            C(new String(this.Ay.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AB == 2) {
                        r(this.Ay.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.AA = false;
                    this.Ay.reset();
                }
            }
            this.AC = null;
            this.AD = 0;
            return this.Ax.position() > 0;
        } else {
            int position2 = this.Ax.position();
            if (this.AC.AM - this.AD < position2) {
                position2 = this.AC.AM - this.AD;
            }
            int position3 = this.Ax.position();
            if (this.AC.AM > 0) {
                bArr = new byte[position2];
                this.Ax.position(0);
                this.Ax.get(bArr, 0, position2);
            }
            this.Ax.position(position2);
            this.Ax.limit(position3);
            this.Ax.compact();
            if (bArr != null) {
                this.Ay.write(bArr);
            }
            this.AD = position2 + this.AD;
            return this.AD >= this.AC.AM;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        s(new k.q(z, map));
    }

    protected void e(int i, String str) {
        s(new k.c(i, str));
    }

    protected void p(byte[] bArr) {
        s(new k.j(bArr));
    }

    protected void q(byte[] bArr) {
        s(new k.C0008k(bArr));
    }

    protected void C(String str) {
        s(new k.s(str));
    }

    protected void o(byte[] bArr) {
        s(new k.m(bArr));
    }

    protected void r(byte[] bArr) {
        this.AH = System.currentTimeMillis();
        s(new k.a(bArr, this.AG, this.AH));
    }

    private boolean it() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ax.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ax.get(position + 0) != 13 || this.Ax.get(position + 1) != 10 || this.Ax.get(position + 2) != 13 || this.Ax.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ax.position();
                Map<String, String> map = null;
                if (this.Ax.get(0) == 72 && this.Ax.get(1) == 84 && this.Ax.get(2) == 84 && this.Ax.get(3) == 80) {
                    Pair<Integer, String> iu = iu();
                    if (((Integer) iu.first).intValue() >= 300) {
                        s(new k.p(((Integer) iu.first).intValue(), (String) iu.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ax.position(0);
                        byte[] bArr = new byte[position];
                        this.Ax.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ax.position(position + 4);
                this.Ax.limit(position2);
                this.Ax.compact();
                if (this.AF < this.zI.hS() && map.size() == 0) {
                    this.AF++;
                    return true;
                }
                this.AF = 0;
                if (!z) {
                    z2 = this.Ax.position() > 0;
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

    private Map<String, String> s(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> iu() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Ax.position() && this.Ax.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ax.position() && this.Ax.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ax.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ax.position() && this.Ax.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ax.position(i6);
        this.Ax.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean iv() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return is();
        }
        if (this.mState == 1) {
            return it();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zI.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ax.clear();
            do {
                try {
                    int read = this.zI.read(this.Ax);
                    if (read > 0) {
                        if (this.AG <= 0) {
                            this.AG = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Az += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (iv());
                    } else if (read < 0) {
                        s(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.hh()) {
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

    public void ib() {
        synchronized (m.class) {
            Az = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Az;
        }
        return j;
    }
}
