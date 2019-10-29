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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long tw = 0;
    private int mState;
    private boolean mStopped;
    private final e.a sD;
    private final l sL;
    private int tA;
    private a tB;
    private int tC;
    private final f tD;
    private int tE;
    private long tF;
    private long tG;
    private final Handler ts;
    private final ByteBuffer tt;
    private final d tu;
    private boolean tz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int tH;
        public boolean tI;
        public int tJ;
        public int tK;
        public int tL;
        public int tM;
        public byte[] tN;
        public byte[] tO;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.tz = false;
        this.tD = new f();
        this.tE = 0;
        this.tF = 0L;
        this.tG = 0L;
        this.ts = handler;
        this.sD = aVar;
        this.sL = lVar;
        this.tt = ByteBuffer.allocateDirect(lVar.hG() + 14);
        this.tu = new d(lVar.hH());
        this.tB = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.tF = 0L;
        this.tG = 0L;
        Message obtainMessage = this.ts.obtainMessage();
        obtainMessage.obj = obj;
        this.ts.sendMessage(obtainMessage);
    }

    private boolean hO() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.tB == null) {
            if (this.tt.position() >= 2) {
                byte b = this.tt.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.tt.get(1);
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
                    if (!this.tz && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.tz && i4 != 0) {
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
                if (this.tt.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.tt.get(2) & 255) << 8) | (this.tt.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.tt.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.tt.get(2) & 255) << 56) | ((this.tt.get(3) & 255) << 48) | ((this.tt.get(4) & 255) << 40) | ((this.tt.get(5) & 255) << 32) | ((this.tt.get(6) & 255) << 24) | ((this.tt.get(7) & 255) << 16) | ((this.tt.get(8) & 255) << 8) | (this.tt.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.tB = new a();
                    this.tB.tH = i4;
                    this.tB.tI = z;
                    this.tB.tJ = i3;
                    this.tB.tL = (int) j;
                    this.tB.tK = i2;
                    this.tB.tM = this.tB.tK + this.tB.tL;
                    this.tB.tN = null;
                    int position = this.tt.position();
                    this.tB.tO = new byte[this.tB.tK];
                    this.tt.position(0);
                    this.tt.get(this.tB.tO, 0, this.tB.tK);
                    this.tt.position(this.tB.tK);
                    this.tt.limit(position);
                    this.tt.compact();
                    return this.tB.tL == 0 || this.tt.position() >= this.tB.tL;
                }
                return false;
            }
            return false;
        } else if (this.tC >= this.tB.tL) {
            if (this.tB.tH > 7) {
                if (this.tB.tH == 8) {
                    if (this.tB.tL < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.tB.tO[1] & 255) + ((this.tB.tO[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.tB.tL > 2) {
                            byte[] bArr2 = new byte[this.tB.tL - 2];
                            System.arraycopy(this.tB.tO, 2, bArr2, 0, this.tB.tL - 2);
                            f fVar = new f();
                            fVar.h(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.tB.tH == 9) {
                    j(this.tu.toByteArray());
                } else if (this.tB.tH == 10) {
                    k(this.tu.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.tz) {
                    this.tz = true;
                    this.tA = this.tB.tH;
                    if (this.tA == 1 && this.sL.hL()) {
                        this.tD.reset();
                    }
                }
                if (this.tA == 1 && this.sL.hL() && !this.tD.h(this.tu.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.tB.tI) {
                    if (this.tA == 1) {
                        if (this.sL.hL() && !this.tD.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.sL.hF()) {
                            i(this.tu.toByteArray());
                        } else {
                            onTextMessage(new String(this.tu.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.tA == 2) {
                        l(this.tu.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.tz = false;
                    this.tu.reset();
                }
            }
            this.tB = null;
            this.tC = 0;
            return this.tt.position() > 0;
        } else {
            int position2 = this.tt.position();
            if (this.tB.tL - this.tC < position2) {
                position2 = this.tB.tL - this.tC;
            }
            int position3 = this.tt.position();
            if (this.tB.tL > 0) {
                bArr = new byte[position2];
                this.tt.position(0);
                this.tt.get(bArr, 0, position2);
            }
            this.tt.position(position2);
            this.tt.limit(position3);
            this.tt.compact();
            if (bArr != null) {
                this.tu.write(bArr);
            }
            this.tC = position2 + this.tC;
            return this.tC >= this.tB.tL;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        t(new k.q(z, map));
    }

    protected void e(int i, String str) {
        t(new k.c(i, str));
    }

    protected void j(byte[] bArr) {
        t(new k.j(bArr));
    }

    protected void k(byte[] bArr) {
        t(new k.C0019k(bArr));
    }

    protected void onTextMessage(String str) {
        t(new k.s(str));
    }

    protected void i(byte[] bArr) {
        t(new k.m(bArr));
    }

    protected void l(byte[] bArr) {
        this.tG = System.currentTimeMillis();
        t(new k.a(bArr, this.tF, this.tG));
    }

    private boolean hP() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.tt.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.tt.get(position + 0) != 13 || this.tt.get(position + 1) != 10 || this.tt.get(position + 2) != 13 || this.tt.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.tt.position();
                Map<String, String> map = null;
                if (this.tt.get(0) == 72 && this.tt.get(1) == 84 && this.tt.get(2) == 84 && this.tt.get(3) == 80) {
                    Pair<Integer, String> hQ = hQ();
                    if (((Integer) hQ.first).intValue() >= 300) {
                        t(new k.p(((Integer) hQ.first).intValue(), (String) hQ.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.tt.position(0);
                        byte[] bArr = new byte[position];
                        this.tt.get(bArr);
                        map = m(bArr);
                    }
                } else {
                    z = false;
                }
                this.tt.position(position + 4);
                this.tt.limit(position2);
                this.tt.compact();
                if (this.tE < this.sD.hp() && map.size() == 0) {
                    this.tE++;
                    return true;
                }
                this.tE = 0;
                if (!z) {
                    z2 = this.tt.position() > 0;
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

    private Map<String, String> m(byte[] bArr) throws UnsupportedEncodingException {
        String str = new String(bArr, HTTP.UTF_8);
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

    private Pair<Integer, String> hQ() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.tt.position() && this.tt.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.tt.position() && this.tt.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.tt.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.tt.position() && this.tt.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.tt.position(i6);
        this.tt.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean hR() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return hO();
        }
        if (this.mState == 1) {
            return hP();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.sD.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.tt.clear();
            do {
                try {
                    int read = this.sD.read(this.tt);
                    if (read > 0) {
                        if (this.tF <= 0) {
                            this.tF = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            tw += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (hR());
                    } else if (read < 0) {
                        t(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        t(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            t(new k.d(e2));
        } catch (WebSocketException e3) {
            t(new k.l(e3));
        } catch (Exception e4) {
            t(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void hw() {
        synchronized (m.class) {
            tw = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = tw;
        }
        return j;
    }
}
