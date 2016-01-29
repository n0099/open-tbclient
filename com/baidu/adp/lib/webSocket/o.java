package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends Thread {
    private static long AQ = 0;
    private final Handler AN;
    private final ByteBuffer AO;
    private final d AP;
    private boolean AR;
    private int AS;
    private a AT;
    private int AU;
    private final f AV;
    private int AW;
    private final n Ai;
    private int mState;
    private boolean mStopped;
    private final e.a zZ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AX;
        public boolean AY;
        public int AZ;
        public int Ba;
        public int Bb;
        public int Bc;
        public byte[] Bd;
        public byte[] Be;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AR = false;
        this.AV = new f();
        this.AW = 0;
        this.AN = handler;
        this.zZ = aVar;
        this.Ai = nVar;
        this.AO = ByteBuffer.allocateDirect(nVar.kb() + 14);
        this.AP = new d(nVar.kd());
        this.AT = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.AN.obtainMessage();
        obtainMessage.obj = obj;
        this.AN.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=8] */
    private boolean kj() {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.AT == null) {
            if (this.AO.position() >= 2) {
                byte b = this.AO.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.AO.get(1);
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
                    if (!this.AR && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.AR && i4 != 0) {
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
                if (this.AO.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.AO.get(2) & 255) << 8) | (this.AO.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.AO.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.AO.get(2) & 255) << 56) | ((this.AO.get(3) & 255) << 48) | ((this.AO.get(4) & 255) << 40) | ((this.AO.get(5) & 255) << 32) | ((this.AO.get(6) & 255) << 24) | ((this.AO.get(7) & 255) << 16) | ((this.AO.get(8) & 255) << 8) | (this.AO.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.AT = new a(null);
                    this.AT.AX = i4;
                    this.AT.AY = z;
                    this.AT.AZ = i3;
                    this.AT.Bb = (int) j;
                    this.AT.Ba = i2;
                    this.AT.Bc = this.AT.Ba + this.AT.Bb;
                    this.AT.Bd = null;
                    int position = this.AO.position();
                    this.AT.Be = new byte[this.AT.Ba];
                    this.AO.position(0);
                    this.AO.get(this.AT.Be, 0, this.AT.Ba);
                    this.AO.position(this.AT.Ba);
                    this.AO.limit(position);
                    this.AO.compact();
                    return this.AT.Bb == 0 || this.AO.position() >= this.AT.Bb;
                }
                return false;
            }
            return false;
        } else if (this.AU < this.AT.Bb) {
            int position2 = this.AO.position();
            if (this.AT.Bb - this.AU < position2) {
                position2 = this.AT.Bb - this.AU;
            }
            int position3 = this.AO.position();
            if (this.AT.Bb > 0) {
                bArr = new byte[position2];
                this.AO.position(0);
                this.AO.get(bArr, 0, position2);
            }
            this.AO.position(position2);
            this.AO.limit(position3);
            this.AO.compact();
            if (bArr != null) {
                this.AP.write(bArr);
            }
            this.AU = position2 + this.AU;
            return this.AU >= this.AT.Bb;
        } else {
            if (this.AT.AX <= 7) {
                if (!this.AR) {
                    this.AR = true;
                    this.AS = this.AT.AX;
                    if (this.AS == 1 && this.Ai.kg()) {
                        this.AV.reset();
                    }
                }
                if (this.AS == 1 && this.Ai.kg() && !this.AV.E(this.AP.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AT.AY) {
                    if (this.AS == 1) {
                        if (this.Ai.kg() && !this.AV.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ai.ka()) {
                            F(this.AP.toByteArray());
                        } else {
                            H(new String(this.AP.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AS != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.AP.toByteArray());
                    }
                    this.AR = false;
                    this.AP.reset();
                }
            } else if (this.AT.AX == 8) {
                if (this.AT.Bb >= 2) {
                    i = (this.AT.Be[1] & 255) + ((this.AT.Be[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.AT.Bb > 2) {
                        byte[] bArr2 = new byte[this.AT.Bb - 2];
                        System.arraycopy(this.AT.Be, 2, bArr2, 0, this.AT.Bb - 2);
                        f fVar = new f();
                        fVar.E(bArr2);
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
                l(i, str);
            } else if (this.AT.AX == 9) {
                G(this.AP.toByteArray());
            } else if (this.AT.AX != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.AP.toByteArray());
            }
            this.AT = null;
            this.AU = 0;
            return this.AO.position() > 0;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        q(new m.q(z, map));
    }

    protected void l(int i, String str) {
        q(new m.c(i, str));
    }

    protected void G(byte[] bArr) {
        q(new m.j(bArr));
    }

    protected void H(byte[] bArr) {
        q(new m.k(bArr));
    }

    protected void H(String str) {
        q(new m.s(str));
    }

    protected void F(byte[] bArr) {
        q(new m.C0009m(bArr));
    }

    protected void w(byte[] bArr) {
        q(new m.a(bArr));
    }

    private boolean kk() {
        boolean z;
        boolean z2;
        int position = this.AO.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AO.get(position + 0) != 13 || this.AO.get(position + 1) != 10 || this.AO.get(position + 2) != 13 || this.AO.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AO.position();
                Map<String, String> map = null;
                if (this.AO.get(0) == 72 && this.AO.get(1) == 84 && this.AO.get(2) == 84 && this.AO.get(3) == 80) {
                    Pair<Integer, String> kl = kl();
                    if (((Integer) kl.first).intValue() >= 300) {
                        q(new m.p(((Integer) kl.first).intValue(), (String) kl.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AO.position(0);
                        byte[] bArr = new byte[position];
                        this.AO.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.AO.position(position + 4);
                this.AO.limit(position2);
                this.AO.compact();
                if (this.AW < this.zZ.jJ() && map.size() == 0) {
                    this.AW++;
                    return true;
                }
                this.AW = 0;
                if (!z) {
                    z2 = this.AO.position() > 0;
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

    private Map<String, String> I(byte[] bArr) {
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

    private Pair<Integer, String> kl() {
        int i = 4;
        while (i < this.AO.position() && this.AO.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AO.position() && this.AO.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AO.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AO.position() && this.AO.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AO.position(i6);
        this.AO.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean km() {
        if (this.mState == 3 || this.mState == 2) {
            return kj();
        }
        if (this.mState == 1) {
            return kk();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zZ.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [750=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AO.clear();
            do {
                try {
                    int read = this.zZ.read(this.AO);
                    if (read > 0) {
                        synchronized (o.class) {
                            AQ += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (km());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.iZ()) {
                        this.mStopped = true;
                        q(new m.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            q(new m.d(e2));
        } catch (WebSocketException e3) {
            q(new m.l(e3));
        } catch (Exception e4) {
            q(new m.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void jR() {
        synchronized (o.class) {
            AQ = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AQ;
        }
        return j;
    }
}
