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
    private static long PN = 0;
    private final e.a OX;
    private final Handler PI;
    private final ByteBuffer PJ;
    private final d PM;
    private boolean PO;
    private int PP;
    private a PQ;
    private int PR;
    private final f PT;
    private int PU;
    private long PV;
    private long PW;
    private final l Pf;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int PY;
        public boolean PZ;
        public int Qa;
        public int Qb;
        public int Qc;
        public int Qd;
        public byte[] Qe;
        public byte[] Qf;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.PO = false;
        this.PT = new f();
        this.PU = 0;
        this.PV = 0L;
        this.PW = 0L;
        this.PI = handler;
        this.OX = aVar;
        this.Pf = lVar;
        this.PJ = ByteBuffer.allocateDirect(lVar.nm() + 14);
        this.PM = new d(lVar.nn());
        this.PQ = null;
        this.mState = 1;
    }

    protected void x(Object obj) {
        this.PV = 0L;
        this.PW = 0L;
        Message obtainMessage = this.PI.obtainMessage();
        obtainMessage.obj = obj;
        this.PI.sendMessage(obtainMessage);
    }

    private boolean nt() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.PQ == null) {
            if (this.PJ.position() >= 2) {
                byte b = this.PJ.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.PJ.get(1);
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
                    if (!this.PO && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.PO && i4 != 0) {
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
                if (this.PJ.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.PJ.get(2) & 255) << 8) | (this.PJ.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.PJ.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.PJ.get(2) & 255) << 56) | ((this.PJ.get(3) & 255) << 48) | ((this.PJ.get(4) & 255) << 40) | ((this.PJ.get(5) & 255) << 32) | ((this.PJ.get(6) & 255) << 24) | ((this.PJ.get(7) & 255) << 16) | ((this.PJ.get(8) & 255) << 8) | (this.PJ.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.PQ = new a();
                    this.PQ.PY = i4;
                    this.PQ.PZ = z;
                    this.PQ.Qa = i3;
                    this.PQ.Qc = (int) j;
                    this.PQ.Qb = i2;
                    this.PQ.Qd = this.PQ.Qb + this.PQ.Qc;
                    this.PQ.Qe = null;
                    int position = this.PJ.position();
                    this.PQ.Qf = new byte[this.PQ.Qb];
                    this.PJ.position(0);
                    this.PJ.get(this.PQ.Qf, 0, this.PQ.Qb);
                    this.PJ.position(this.PQ.Qb);
                    this.PJ.limit(position);
                    this.PJ.compact();
                    return this.PQ.Qc == 0 || this.PJ.position() >= this.PQ.Qc;
                }
                return false;
            }
            return false;
        } else if (this.PR >= this.PQ.Qc) {
            if (this.PQ.PY > 7) {
                if (this.PQ.PY == 8) {
                    if (this.PQ.Qc < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.PQ.Qf[1] & 255) + ((this.PQ.Qf[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.PQ.Qc > 2) {
                            byte[] bArr2 = new byte[this.PQ.Qc - 2];
                            System.arraycopy(this.PQ.Qf, 2, bArr2, 0, this.PQ.Qc - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    d(i, str);
                } else if (this.PQ.PY == 9) {
                    n(this.PM.toByteArray());
                } else if (this.PQ.PY == 10) {
                    o(this.PM.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.PO) {
                    this.PO = true;
                    this.PP = this.PQ.PY;
                    if (this.PP == 1 && this.Pf.nq()) {
                        this.PT.reset();
                    }
                }
                if (this.PP == 1 && this.Pf.nq() && !this.PT.l(this.PM.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.PQ.PZ) {
                    if (this.PP == 1) {
                        if (this.Pf.nq() && !this.PT.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Pf.nl()) {
                            m(this.PM.toByteArray());
                        } else {
                            onTextMessage(new String(this.PM.toByteArray(), "UTF-8"));
                        }
                    } else if (this.PP == 2) {
                        p(this.PM.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.PO = false;
                    this.PM.reset();
                }
            }
            this.PQ = null;
            this.PR = 0;
            return this.PJ.position() > 0;
        } else {
            int position2 = this.PJ.position();
            if (this.PQ.Qc - this.PR < position2) {
                position2 = this.PQ.Qc - this.PR;
            }
            int position3 = this.PJ.position();
            if (this.PQ.Qc > 0) {
                bArr = new byte[position2];
                this.PJ.position(0);
                this.PJ.get(bArr, 0, position2);
            }
            this.PJ.position(position2);
            this.PJ.limit(position3);
            this.PJ.compact();
            if (bArr != null) {
                this.PM.write(bArr);
            }
            this.PR = position2 + this.PR;
            return this.PR >= this.PQ.Qc;
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
        this.PW = System.currentTimeMillis();
        x(new k.a(bArr, this.PV, this.PW));
    }

    private boolean nu() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.PJ.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.PJ.get(position + 0) != 13 || this.PJ.get(position + 1) != 10 || this.PJ.get(position + 2) != 13 || this.PJ.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.PJ.position();
                Map<String, String> map = null;
                if (this.PJ.get(0) == 72 && this.PJ.get(1) == 84 && this.PJ.get(2) == 84 && this.PJ.get(3) == 80) {
                    Pair<Integer, String> nv = nv();
                    if (((Integer) nv.first).intValue() >= 300) {
                        x(new k.p(((Integer) nv.first).intValue(), (String) nv.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.PJ.position(0);
                        byte[] bArr = new byte[position];
                        this.PJ.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.PJ.position(position + 4);
                this.PJ.limit(position2);
                this.PJ.compact();
                if (this.PU < this.OX.mW() && map.size() == 0) {
                    this.PU++;
                    return true;
                }
                this.PU = 0;
                if (!z) {
                    z2 = this.PJ.position() > 0;
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

    private Pair<Integer, String> nv() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.PJ.position() && this.PJ.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.PJ.position() && this.PJ.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.PJ.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.PJ.position() && this.PJ.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.PJ.position(i6);
        this.PJ.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean nw() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return nt();
        }
        if (this.mState == 1) {
            return nu();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.OX.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.PJ.clear();
            do {
                try {
                    int read = this.OX.read(this.PJ);
                    if (read > 0) {
                        if (this.PV <= 0) {
                            this.PV = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            PN += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (nw());
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

    public void nc() {
        synchronized (m.class) {
            PN = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = PN;
        }
        return j;
    }
}
