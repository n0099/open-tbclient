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
    private static long AG = 0;
    private final Handler AD;
    private final ByteBuffer AE;
    private final d AF;
    private boolean AH;
    private int AI;
    private a AJ;
    private int AK;
    private final f AL;
    private int AM;
    private int mState;
    private boolean mStopped;
    private final e.a zP;
    private final n zX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AN;
        public boolean AO;
        public int AP;
        public int AQ;
        public int AR;
        public int AS;
        public byte[] AT;
        public byte[] AU;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AH = false;
        this.AL = new f();
        this.AM = 0;
        this.AD = handler;
        this.zP = aVar;
        this.zX = nVar;
        this.AE = ByteBuffer.allocateDirect(nVar.jR() + 14);
        this.AF = new d(nVar.jS());
        this.AJ = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.AD.obtainMessage();
        obtainMessage.obj = obj;
        this.AD.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=8] */
    private boolean jY() {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.AJ == null) {
            if (this.AE.position() >= 2) {
                byte b = this.AE.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.AE.get(1);
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
                    if (!this.AH && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.AH && i4 != 0) {
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
                if (this.AE.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.AE.get(2) & 255) << 8) | (this.AE.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.AE.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.AE.get(2) & 255) << 56) | ((this.AE.get(3) & 255) << 48) | ((this.AE.get(4) & 255) << 40) | ((this.AE.get(5) & 255) << 32) | ((this.AE.get(6) & 255) << 24) | ((this.AE.get(7) & 255) << 16) | ((this.AE.get(8) & 255) << 8) | (this.AE.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.AJ = new a(null);
                    this.AJ.AN = i4;
                    this.AJ.AO = z;
                    this.AJ.AP = i3;
                    this.AJ.AR = (int) j;
                    this.AJ.AQ = i2;
                    this.AJ.AS = this.AJ.AQ + this.AJ.AR;
                    this.AJ.AT = null;
                    int position = this.AE.position();
                    this.AJ.AU = new byte[this.AJ.AQ];
                    this.AE.position(0);
                    this.AE.get(this.AJ.AU, 0, this.AJ.AQ);
                    this.AE.position(this.AJ.AQ);
                    this.AE.limit(position);
                    this.AE.compact();
                    return this.AJ.AR == 0 || this.AE.position() >= this.AJ.AR;
                }
                return false;
            }
            return false;
        } else if (this.AK < this.AJ.AR) {
            int position2 = this.AE.position();
            if (this.AJ.AR - this.AK < position2) {
                position2 = this.AJ.AR - this.AK;
            }
            int position3 = this.AE.position();
            if (this.AJ.AR > 0) {
                bArr = new byte[position2];
                this.AE.position(0);
                this.AE.get(bArr, 0, position2);
            }
            this.AE.position(position2);
            this.AE.limit(position3);
            this.AE.compact();
            if (bArr != null) {
                this.AF.write(bArr);
            }
            this.AK = position2 + this.AK;
            return this.AK >= this.AJ.AR;
        } else {
            if (this.AJ.AN <= 7) {
                if (!this.AH) {
                    this.AH = true;
                    this.AI = this.AJ.AN;
                    if (this.AI == 1 && this.zX.jV()) {
                        this.AL.reset();
                    }
                }
                if (this.AI == 1 && this.zX.jV() && !this.AL.E(this.AF.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AJ.AO) {
                    if (this.AI == 1) {
                        if (this.zX.jV() && !this.AL.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zX.jQ()) {
                            F(this.AF.toByteArray());
                        } else {
                            I(new String(this.AF.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AI != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.AF.toByteArray());
                    }
                    this.AH = false;
                    this.AF.reset();
                }
            } else if (this.AJ.AN == 8) {
                if (this.AJ.AR >= 2) {
                    i = (this.AJ.AU[1] & 255) + ((this.AJ.AU[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.AJ.AR > 2) {
                        byte[] bArr2 = new byte[this.AJ.AR - 2];
                        System.arraycopy(this.AJ.AU, 2, bArr2, 0, this.AJ.AR - 2);
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
            } else if (this.AJ.AN == 9) {
                G(this.AF.toByteArray());
            } else if (this.AJ.AN != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.AF.toByteArray());
            }
            this.AJ = null;
            this.AK = 0;
            return this.AE.position() > 0;
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

    protected void I(String str) {
        q(new m.s(str));
    }

    protected void F(byte[] bArr) {
        q(new m.C0008m(bArr));
    }

    protected void w(byte[] bArr) {
        q(new m.a(bArr));
    }

    private boolean jZ() {
        boolean z;
        boolean z2;
        int position = this.AE.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AE.get(position + 0) != 13 || this.AE.get(position + 1) != 10 || this.AE.get(position + 2) != 13 || this.AE.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AE.position();
                Map<String, String> map = null;
                if (this.AE.get(0) == 72 && this.AE.get(1) == 84 && this.AE.get(2) == 84 && this.AE.get(3) == 80) {
                    Pair<Integer, String> ka = ka();
                    if (((Integer) ka.first).intValue() >= 300) {
                        q(new m.p(((Integer) ka.first).intValue(), (String) ka.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AE.position(0);
                        byte[] bArr = new byte[position];
                        this.AE.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.AE.position(position + 4);
                this.AE.limit(position2);
                this.AE.compact();
                if (this.AM < this.zP.jz() && map.size() == 0) {
                    this.AM++;
                    return true;
                }
                this.AM = 0;
                if (!z) {
                    z2 = this.AE.position() > 0;
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

    private Pair<Integer, String> ka() {
        int i = 4;
        while (i < this.AE.position() && this.AE.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AE.position() && this.AE.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AE.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AE.position() && this.AE.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AE.position(i6);
        this.AE.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean kb() {
        if (this.mState == 3 || this.mState == 2) {
            return jY();
        }
        if (this.mState == 1) {
            return jZ();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zP.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [750=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AE.clear();
            do {
                try {
                    int read = this.zP.read(this.AE);
                    if (read > 0) {
                        synchronized (o.class) {
                            AG += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (kb());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.iP()) {
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

    public void jH() {
        synchronized (o.class) {
            AG = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AG;
        }
        return j;
    }
}
