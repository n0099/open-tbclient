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
    private static long Ax = 0;
    private a AA;
    private int AB;
    private final f AC;
    private int AD;
    private long AE;
    private long AF;
    private final Handler Au;
    private final ByteBuffer Av;
    private final d Aw;
    private boolean Ay;
    private int Az;
    private int mState;
    private boolean mStopped;
    private final e.a zG;
    private final l zO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AG;
        public boolean AH;
        public int AI;
        public int AJ;
        public int AK;
        public int AM;
        public byte[] AN;
        public byte[] AO;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Ay = false;
        this.AC = new f();
        this.AD = 0;
        this.AE = 0L;
        this.AF = 0L;
        this.Au = handler;
        this.zG = aVar;
        this.zO = lVar;
        this.Av = ByteBuffer.allocateDirect(lVar.il() + 14);
        this.Aw = new d(lVar.im());
        this.AA = null;
        this.mState = 1;
    }

    protected void s(Object obj) {
        this.AE = 0L;
        this.AF = 0L;
        Message obtainMessage = this.Au.obtainMessage();
        obtainMessage.obj = obj;
        this.Au.sendMessage(obtainMessage);
    }

    private boolean is() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.AA == null) {
            if (this.Av.position() >= 2) {
                byte b = this.Av.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Av.get(1);
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
                    if (!this.Ay && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Ay && i4 != 0) {
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
                if (this.Av.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Av.get(2) & 255) << 8) | (this.Av.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Av.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Av.get(2) & 255) << 56) | ((this.Av.get(3) & 255) << 48) | ((this.Av.get(4) & 255) << 40) | ((this.Av.get(5) & 255) << 32) | ((this.Av.get(6) & 255) << 24) | ((this.Av.get(7) & 255) << 16) | ((this.Av.get(8) & 255) << 8) | (this.Av.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.AA = new a();
                    this.AA.AG = i4;
                    this.AA.AH = z;
                    this.AA.AI = i3;
                    this.AA.AK = (int) j;
                    this.AA.AJ = i2;
                    this.AA.AM = this.AA.AJ + this.AA.AK;
                    this.AA.AN = null;
                    int position = this.Av.position();
                    this.AA.AO = new byte[this.AA.AJ];
                    this.Av.position(0);
                    this.Av.get(this.AA.AO, 0, this.AA.AJ);
                    this.Av.position(this.AA.AJ);
                    this.Av.limit(position);
                    this.Av.compact();
                    return this.AA.AK == 0 || this.Av.position() >= this.AA.AK;
                }
                return false;
            }
            return false;
        } else if (this.AB >= this.AA.AK) {
            if (this.AA.AG > 7) {
                if (this.AA.AG == 8) {
                    if (this.AA.AK < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.AA.AO[1] & 255) + ((this.AA.AO[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.AA.AK > 2) {
                            byte[] bArr2 = new byte[this.AA.AK - 2];
                            System.arraycopy(this.AA.AO, 2, bArr2, 0, this.AA.AK - 2);
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
                } else if (this.AA.AG == 9) {
                    p(this.Aw.toByteArray());
                } else if (this.AA.AG == 10) {
                    q(this.Aw.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Ay) {
                    this.Ay = true;
                    this.Az = this.AA.AG;
                    if (this.Az == 1 && this.zO.ip()) {
                        this.AC.reset();
                    }
                }
                if (this.Az == 1 && this.zO.ip() && !this.AC.n(this.Aw.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AA.AH) {
                    if (this.Az == 1) {
                        if (this.zO.ip() && !this.AC.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zO.ik()) {
                            o(this.Aw.toByteArray());
                        } else {
                            C(new String(this.Aw.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Az == 2) {
                        r(this.Aw.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Ay = false;
                    this.Aw.reset();
                }
            }
            this.AA = null;
            this.AB = 0;
            return this.Av.position() > 0;
        } else {
            int position2 = this.Av.position();
            if (this.AA.AK - this.AB < position2) {
                position2 = this.AA.AK - this.AB;
            }
            int position3 = this.Av.position();
            if (this.AA.AK > 0) {
                bArr = new byte[position2];
                this.Av.position(0);
                this.Av.get(bArr, 0, position2);
            }
            this.Av.position(position2);
            this.Av.limit(position3);
            this.Av.compact();
            if (bArr != null) {
                this.Aw.write(bArr);
            }
            this.AB = position2 + this.AB;
            return this.AB >= this.AA.AK;
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
        this.AF = System.currentTimeMillis();
        s(new k.a(bArr, this.AE, this.AF));
    }

    private boolean it() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Av.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Av.get(position + 0) != 13 || this.Av.get(position + 1) != 10 || this.Av.get(position + 2) != 13 || this.Av.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Av.position();
                Map<String, String> map = null;
                if (this.Av.get(0) == 72 && this.Av.get(1) == 84 && this.Av.get(2) == 84 && this.Av.get(3) == 80) {
                    Pair<Integer, String> iu = iu();
                    if (((Integer) iu.first).intValue() >= 300) {
                        s(new k.p(((Integer) iu.first).intValue(), (String) iu.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Av.position(0);
                        byte[] bArr = new byte[position];
                        this.Av.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.Av.position(position + 4);
                this.Av.limit(position2);
                this.Av.compact();
                if (this.AD < this.zG.hS() && map.size() == 0) {
                    this.AD++;
                    return true;
                }
                this.AD = 0;
                if (!z) {
                    z2 = this.Av.position() > 0;
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
        while (i < this.Av.position() && this.Av.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Av.position() && this.Av.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Av.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Av.position() && this.Av.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Av.position(i6);
        this.Av.get(bArr, 0, i8);
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
            this.zG.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Av.clear();
            do {
                try {
                    int read = this.zG.read(this.Av);
                    if (read > 0) {
                        if (this.AE <= 0) {
                            this.AE = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Ax += read;
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
            Ax = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Ax;
        }
        return j;
    }
}
