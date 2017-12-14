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
    private static long Aw = 0;
    private int AA;
    private final f AB;
    private int AC;
    private long AD;
    private long AE;
    private final Handler At;
    private final ByteBuffer Au;
    private final d Av;
    private boolean Ax;
    private int Ay;
    private a Az;
    private int mState;
    private boolean mStopped;
    private final e.a zF;
    private final l zN;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AF;
        public boolean AG;
        public int AH;
        public int AI;
        public int AJ;
        public int AK;
        public byte[] AM;
        public byte[] AN;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Ax = false;
        this.AB = new f();
        this.AC = 0;
        this.AD = 0L;
        this.AE = 0L;
        this.At = handler;
        this.zF = aVar;
        this.zN = lVar;
        this.Au = ByteBuffer.allocateDirect(lVar.il() + 14);
        this.Av = new d(lVar.im());
        this.Az = null;
        this.mState = 1;
    }

    protected void s(Object obj) {
        this.AD = 0L;
        this.AE = 0L;
        Message obtainMessage = this.At.obtainMessage();
        obtainMessage.obj = obj;
        this.At.sendMessage(obtainMessage);
    }

    private boolean is() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Az == null) {
            if (this.Au.position() >= 2) {
                byte b = this.Au.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Au.get(1);
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
                    if (!this.Ax && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Ax && i4 != 0) {
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
                if (this.Au.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Au.get(2) & 255) << 8) | (this.Au.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Au.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Au.get(2) & 255) << 56) | ((this.Au.get(3) & 255) << 48) | ((this.Au.get(4) & 255) << 40) | ((this.Au.get(5) & 255) << 32) | ((this.Au.get(6) & 255) << 24) | ((this.Au.get(7) & 255) << 16) | ((this.Au.get(8) & 255) << 8) | (this.Au.get(9) & 255);
                        if (j < IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Az = new a();
                    this.Az.AF = i4;
                    this.Az.AG = z;
                    this.Az.AH = i3;
                    this.Az.AJ = (int) j;
                    this.Az.AI = i2;
                    this.Az.AK = this.Az.AI + this.Az.AJ;
                    this.Az.AM = null;
                    int position = this.Au.position();
                    this.Az.AN = new byte[this.Az.AI];
                    this.Au.position(0);
                    this.Au.get(this.Az.AN, 0, this.Az.AI);
                    this.Au.position(this.Az.AI);
                    this.Au.limit(position);
                    this.Au.compact();
                    return this.Az.AJ == 0 || this.Au.position() >= this.Az.AJ;
                }
                return false;
            }
            return false;
        } else if (this.AA >= this.Az.AJ) {
            if (this.Az.AF > 7) {
                if (this.Az.AF == 8) {
                    if (this.Az.AJ < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Az.AN[1] & 255) + ((this.Az.AN[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Az.AJ > 2) {
                            byte[] bArr2 = new byte[this.Az.AJ - 2];
                            System.arraycopy(this.Az.AN, 2, bArr2, 0, this.Az.AJ - 2);
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
                } else if (this.Az.AF == 9) {
                    p(this.Av.toByteArray());
                } else if (this.Az.AF == 10) {
                    q(this.Av.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Ax) {
                    this.Ax = true;
                    this.Ay = this.Az.AF;
                    if (this.Ay == 1 && this.zN.ip()) {
                        this.AB.reset();
                    }
                }
                if (this.Ay == 1 && this.zN.ip() && !this.AB.n(this.Av.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Az.AG) {
                    if (this.Ay == 1) {
                        if (this.zN.ip() && !this.AB.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zN.ik()) {
                            o(this.Av.toByteArray());
                        } else {
                            C(new String(this.Av.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Ay == 2) {
                        r(this.Av.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Ax = false;
                    this.Av.reset();
                }
            }
            this.Az = null;
            this.AA = 0;
            return this.Au.position() > 0;
        } else {
            int position2 = this.Au.position();
            if (this.Az.AJ - this.AA < position2) {
                position2 = this.Az.AJ - this.AA;
            }
            int position3 = this.Au.position();
            if (this.Az.AJ > 0) {
                bArr = new byte[position2];
                this.Au.position(0);
                this.Au.get(bArr, 0, position2);
            }
            this.Au.position(position2);
            this.Au.limit(position3);
            this.Au.compact();
            if (bArr != null) {
                this.Av.write(bArr);
            }
            this.AA = position2 + this.AA;
            return this.AA >= this.Az.AJ;
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
        this.AE = System.currentTimeMillis();
        s(new k.a(bArr, this.AD, this.AE));
    }

    private boolean it() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Au.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Au.get(position + 0) != 13 || this.Au.get(position + 1) != 10 || this.Au.get(position + 2) != 13 || this.Au.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Au.position();
                Map<String, String> map = null;
                if (this.Au.get(0) == 72 && this.Au.get(1) == 84 && this.Au.get(2) == 84 && this.Au.get(3) == 80) {
                    Pair<Integer, String> iu = iu();
                    if (((Integer) iu.first).intValue() >= 300) {
                        s(new k.p(((Integer) iu.first).intValue(), (String) iu.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Au.position(0);
                        byte[] bArr = new byte[position];
                        this.Au.get(bArr);
                        map = s(bArr);
                    }
                } else {
                    z = false;
                }
                this.Au.position(position + 4);
                this.Au.limit(position2);
                this.Au.compact();
                if (this.AC < this.zF.hS() && map.size() == 0) {
                    this.AC++;
                    return true;
                }
                this.AC = 0;
                if (!z) {
                    z2 = this.Au.position() > 0;
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
        while (i < this.Au.position() && this.Au.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Au.position() && this.Au.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Au.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Au.position() && this.Au.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Au.position(i6);
        this.Au.get(bArr, 0, i8);
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
            this.zF.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Au.clear();
            do {
                try {
                    int read = this.zF.read(this.Au);
                    if (read > 0) {
                        if (this.AD <= 0) {
                            this.AD = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Aw += read;
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
            Aw = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Aw;
        }
        return j;
    }
}
