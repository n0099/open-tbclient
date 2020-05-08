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
    private static long Pa = 0;
    private final Handler OX;
    private final ByteBuffer OY;
    private final d OZ;
    private final e.a Ol;
    private final l Ou;
    private boolean Pb;
    private int Pc;
    private a Pe;
    private int Pf;
    private final f Pg;
    private int Ph;
    private long Pi;
    private long Pj;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Pk;
        public boolean Pl;
        public int Pm;
        public int Pn;
        public int Po;
        public int Pp;
        public byte[] Pq;
        public byte[] Pr;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Pb = false;
        this.Pg = new f();
        this.Ph = 0;
        this.Pi = 0L;
        this.Pj = 0L;
        this.OX = handler;
        this.Ol = aVar;
        this.Ou = lVar;
        this.OY = ByteBuffer.allocateDirect(lVar.mT() + 14);
        this.OZ = new d(lVar.mU());
        this.Pe = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Pi = 0L;
        this.Pj = 0L;
        Message obtainMessage = this.OX.obtainMessage();
        obtainMessage.obj = obj;
        this.OX.sendMessage(obtainMessage);
    }

    private boolean na() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Pe == null) {
            if (this.OY.position() >= 2) {
                byte b = this.OY.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.OY.get(1);
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
                    if (!this.Pb && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Pb && i4 != 0) {
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
                if (this.OY.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.OY.get(2) & 255) << 8) | (this.OY.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.OY.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.OY.get(2) & 255) << 56) | ((this.OY.get(3) & 255) << 48) | ((this.OY.get(4) & 255) << 40) | ((this.OY.get(5) & 255) << 32) | ((this.OY.get(6) & 255) << 24) | ((this.OY.get(7) & 255) << 16) | ((this.OY.get(8) & 255) << 8) | (this.OY.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Pe = new a();
                    this.Pe.Pk = i4;
                    this.Pe.Pl = z;
                    this.Pe.Pm = i3;
                    this.Pe.Po = (int) j;
                    this.Pe.Pn = i2;
                    this.Pe.Pp = this.Pe.Pn + this.Pe.Po;
                    this.Pe.Pq = null;
                    int position = this.OY.position();
                    this.Pe.Pr = new byte[this.Pe.Pn];
                    this.OY.position(0);
                    this.OY.get(this.Pe.Pr, 0, this.Pe.Pn);
                    this.OY.position(this.Pe.Pn);
                    this.OY.limit(position);
                    this.OY.compact();
                    return this.Pe.Po == 0 || this.OY.position() >= this.Pe.Po;
                }
                return false;
            }
            return false;
        } else if (this.Pf >= this.Pe.Po) {
            if (this.Pe.Pk > 7) {
                if (this.Pe.Pk == 8) {
                    if (this.Pe.Po < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Pe.Pr[1] & 255) + ((this.Pe.Pr[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Pe.Po > 2) {
                            byte[] bArr2 = new byte[this.Pe.Po - 2];
                            System.arraycopy(this.Pe.Pr, 2, bArr2, 0, this.Pe.Po - 2);
                            f fVar = new f();
                            fVar.j(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    d(i, str);
                } else if (this.Pe.Pk == 9) {
                    l(this.OZ.toByteArray());
                } else if (this.Pe.Pk == 10) {
                    m(this.OZ.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Pb) {
                    this.Pb = true;
                    this.Pc = this.Pe.Pk;
                    if (this.Pc == 1 && this.Ou.mX()) {
                        this.Pg.reset();
                    }
                }
                if (this.Pc == 1 && this.Ou.mX() && !this.Pg.j(this.OZ.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Pe.Pl) {
                    if (this.Pc == 1) {
                        if (this.Ou.mX() && !this.Pg.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ou.mS()) {
                            k(this.OZ.toByteArray());
                        } else {
                            onTextMessage(new String(this.OZ.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Pc == 2) {
                        n(this.OZ.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Pb = false;
                    this.OZ.reset();
                }
            }
            this.Pe = null;
            this.Pf = 0;
            return this.OY.position() > 0;
        } else {
            int position2 = this.OY.position();
            if (this.Pe.Po - this.Pf < position2) {
                position2 = this.Pe.Po - this.Pf;
            }
            int position3 = this.OY.position();
            if (this.Pe.Po > 0) {
                bArr = new byte[position2];
                this.OY.position(0);
                this.OY.get(bArr, 0, position2);
            }
            this.OY.position(position2);
            this.OY.limit(position3);
            this.OY.compact();
            if (bArr != null) {
                this.OZ.write(bArr);
            }
            this.Pf = position2 + this.Pf;
            return this.Pf >= this.Pe.Po;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void d(int i, String str) {
        v(new k.c(i, str));
    }

    protected void l(byte[] bArr) {
        v(new k.j(bArr));
    }

    protected void m(byte[] bArr) {
        v(new k.C0023k(bArr));
    }

    protected void onTextMessage(String str) {
        v(new k.s(str));
    }

    protected void k(byte[] bArr) {
        v(new k.m(bArr));
    }

    protected void n(byte[] bArr) {
        this.Pj = System.currentTimeMillis();
        v(new k.a(bArr, this.Pi, this.Pj));
    }

    private boolean nb() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.OY.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.OY.get(position + 0) != 13 || this.OY.get(position + 1) != 10 || this.OY.get(position + 2) != 13 || this.OY.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.OY.position();
                Map<String, String> map = null;
                if (this.OY.get(0) == 72 && this.OY.get(1) == 84 && this.OY.get(2) == 84 && this.OY.get(3) == 80) {
                    Pair<Integer, String> nc = nc();
                    if (((Integer) nc.first).intValue() >= 300) {
                        v(new k.p(((Integer) nc.first).intValue(), (String) nc.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.OY.position(0);
                        byte[] bArr = new byte[position];
                        this.OY.get(bArr);
                        map = o(bArr);
                    }
                } else {
                    z = false;
                }
                this.OY.position(position + 4);
                this.OY.limit(position2);
                this.OY.compact();
                if (this.Ph < this.Ol.mD() && map.size() == 0) {
                    this.Ph++;
                    return true;
                }
                this.Ph = 0;
                if (!z) {
                    z2 = this.OY.position() > 0;
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

    private Map<String, String> o(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> nc() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.OY.position() && this.OY.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.OY.position() && this.OY.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.OY.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.OY.position() && this.OY.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.OY.position(i6);
        this.OY.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean nd() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return na();
        }
        if (this.mState == 1) {
            return nb();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ol.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.OY.clear();
            do {
                try {
                    int read = this.Ol.read(this.OY);
                    if (read > 0) {
                        if (this.Pi <= 0) {
                            this.Pi = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Pa += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (nd());
                    } else if (read < 0) {
                        v(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        v(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            v(new k.d(e2));
        } catch (WebSocketException e3) {
            v(new k.l(e3));
        } catch (Exception e4) {
            v(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void mJ() {
        synchronized (m.class) {
            Pa = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Pa;
        }
        return j;
    }
}
