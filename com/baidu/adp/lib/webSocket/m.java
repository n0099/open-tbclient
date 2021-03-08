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
    private static long Tt = 0;
    private final e.a SG;
    private final l SR;
    private long TA;
    private long TB;
    private final Handler Tq;
    private final ByteBuffer Tr;
    private final d Ts;
    private boolean Tu;
    private int Tv;
    private a Tw;
    private int Tx;
    private final f Ty;
    private int Tz;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int TC;
        public boolean TD;
        public int TF;
        public int TG;
        public int TH;
        public int TI;
        public byte[] TJ;
        public byte[] TK;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Tu = false;
        this.Ty = new f();
        this.Tz = 0;
        this.TA = 0L;
        this.TB = 0L;
        this.Tq = handler;
        this.SG = aVar;
        this.SR = lVar;
        this.Tr = ByteBuffer.allocateDirect(lVar.oq() + 14);
        this.Ts = new d(lVar.or());
        this.Tw = null;
        this.mState = 1;
    }

    protected void x(Object obj) {
        this.TA = 0L;
        this.TB = 0L;
        Message obtainMessage = this.Tq.obtainMessage();
        obtainMessage.obj = obj;
        this.Tq.sendMessage(obtainMessage);
    }

    private boolean oy() throws Exception {
        String str;
        int i;
        long j;
        byte[] bArr = null;
        if (this.Tw == null) {
            if (this.Tr.position() >= 2) {
                byte b = this.Tr.get(0);
                boolean z = (b & 128) != 0;
                int i2 = (b & 112) >> 4;
                int i3 = b & 15;
                byte b2 = this.Tr.get(1);
                boolean z2 = (b2 & 128) != 0;
                int i4 = b2 & Byte.MAX_VALUE;
                if (i2 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i3 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i4 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i3 != 8 && i3 != 9 && i3 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i3);
                    }
                    if (i3 == 8 && i4 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i3 != 0 && i3 != 1 && i3 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i3);
                } else {
                    if (!this.Tu && i3 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Tu && i3 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i4 < 126) {
                    i = 2;
                } else if (i4 == 126) {
                    i = 4;
                } else if (i4 == 127) {
                    i = 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.Tr.position() >= i) {
                    if (i4 == 126) {
                        j = ((this.Tr.get(2) & 255) << 8) | (this.Tr.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i4 == 127) {
                        if ((this.Tr.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Tr.get(2) & 255) << 56) | ((this.Tr.get(3) & 255) << 48) | ((this.Tr.get(4) & 255) << 40) | ((this.Tr.get(5) & 255) << 32) | ((this.Tr.get(6) & 255) << 24) | ((this.Tr.get(7) & 255) << 16) | ((this.Tr.get(8) & 255) << 8) | (this.Tr.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i4;
                    }
                    this.Tw = new a();
                    this.Tw.TC = i3;
                    this.Tw.TD = z;
                    this.Tw.TF = i2;
                    this.Tw.TH = (int) j;
                    this.Tw.TG = i;
                    this.Tw.TI = this.Tw.TG + this.Tw.TH;
                    this.Tw.TJ = null;
                    int position = this.Tr.position();
                    this.Tw.TK = new byte[this.Tw.TG];
                    this.Tr.position(0);
                    this.Tr.get(this.Tw.TK, 0, this.Tw.TG);
                    this.Tr.position(this.Tw.TG);
                    this.Tr.limit(position);
                    this.Tr.compact();
                    return this.Tw.TH == 0 || this.Tr.position() >= this.Tw.TH;
                }
                return false;
            }
            return false;
        } else if (this.Tx >= this.Tw.TH) {
            if (this.Tw.TC > 7) {
                if (this.Tw.TC == 8) {
                    int i5 = 1005;
                    if (this.Tw.TH >= 2) {
                        i5 = (this.Tw.TK[1] & 255) + ((this.Tw.TK[0] & 255) * 256);
                        if (i5 < 1000 || ((i5 >= 1000 && i5 <= 2999 && i5 != 1000 && i5 != 1001 && i5 != 1002 && i5 != 1003 && i5 != 1007 && i5 != 1008 && i5 != 1009 && i5 != 1010 && i5 != 1011) || i5 >= 5000)) {
                            throw new WebSocketException("invalid close code " + i5);
                        }
                        if (this.Tw.TH > 2) {
                            byte[] bArr2 = new byte[this.Tw.TH - 2];
                            System.arraycopy(this.Tw.TK, 2, bArr2, 0, this.Tw.TH - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                            d(i5, str);
                        }
                    }
                    str = null;
                    d(i5, str);
                } else if (this.Tw.TC == 9) {
                    n(this.Ts.toByteArray());
                } else if (this.Tw.TC == 10) {
                    o(this.Ts.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Tu) {
                    this.Tu = true;
                    this.Tv = this.Tw.TC;
                    if (this.Tv == 1 && this.SR.ov()) {
                        this.Ty.reset();
                    }
                }
                if (this.Tv == 1 && this.SR.ov() && !this.Ty.l(this.Ts.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Tw.TD) {
                    if (this.Tv == 1) {
                        if (this.SR.ov() && !this.Ty.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.SR.op()) {
                            m(this.Ts.toByteArray());
                        } else {
                            onTextMessage(new String(this.Ts.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Tv == 2) {
                        p(this.Ts.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Tu = false;
                    this.Ts.reset();
                }
            }
            this.Tw = null;
            this.Tx = 0;
            return this.Tr.position() > 0;
        } else {
            int position2 = this.Tr.position();
            if (this.Tw.TH - this.Tx < position2) {
                position2 = this.Tw.TH - this.Tx;
            }
            int position3 = this.Tr.position();
            if (this.Tw.TH > 0) {
                bArr = new byte[position2];
                this.Tr.position(0);
                this.Tr.get(bArr, 0, position2);
            }
            this.Tr.position(position2);
            this.Tr.limit(position3);
            this.Tr.compact();
            if (bArr != null) {
                this.Ts.write(bArr);
            }
            this.Tx = position2 + this.Tx;
            return this.Tx >= this.Tw.TH;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        x(new k.q(z, map));
    }

    protected void d(int i, String str) {
        x(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        x(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        x(new k.C0025k(bArr));
    }

    protected void onTextMessage(String str) {
        x(new k.s(str));
    }

    protected void m(byte[] bArr) {
        x(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.TB = System.currentTimeMillis();
        x(new k.a(bArr, this.TA, this.TB));
    }

    private boolean oz() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Tr.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Tr.get(position + 0) != 13 || this.Tr.get(position + 1) != 10 || this.Tr.get(position + 2) != 13 || this.Tr.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Tr.position();
                Map<String, String> map = null;
                if (this.Tr.get(0) == 72 && this.Tr.get(1) == 84 && this.Tr.get(2) == 84 && this.Tr.get(3) == 80) {
                    Pair<Integer, String> oA = oA();
                    if (((Integer) oA.first).intValue() >= 300) {
                        x(new k.p(((Integer) oA.first).intValue(), (String) oA.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Tr.position(0);
                        byte[] bArr = new byte[position];
                        this.Tr.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.Tr.position(position + 4);
                this.Tr.limit(position2);
                this.Tr.compact();
                if (this.Tz < this.SG.nZ() && map.size() == 0) {
                    this.Tz++;
                    return true;
                }
                this.Tz = 0;
                if (!z) {
                    z2 = this.Tr.position() > 0;
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

    private Map<String, String> q(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> oA() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Tr.position() && this.Tr.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Tr.position() && this.Tr.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Tr.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Tr.position() && this.Tr.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Tr.position(i6);
        this.Tr.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean oB() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oy();
        }
        if (this.mState == 1) {
            return oz();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.SG.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Tr.clear();
            do {
                try {
                    int read = this.SG.read(this.Tr);
                    if (read > 0) {
                        if (this.TA <= 0) {
                            this.TA = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Tt += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (oB());
                    } else if (read < 0) {
                        x(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        x(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            x(new k.d(e2));
        } catch (WebSocketException e3) {
            x(new k.l(e3));
        } catch (Exception e4) {
            x(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void og() {
        synchronized (m.class) {
            Tt = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Tt;
        }
        return j;
    }
}
