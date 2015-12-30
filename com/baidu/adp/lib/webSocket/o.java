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
    private static long AI = 0;
    private final Handler AF;
    private final ByteBuffer AG;
    private final d AH;
    private boolean AJ;
    private int AK;
    private a AL;
    private int AM;
    private final f AN;
    private int AO;
    private int mState;
    private boolean mStopped;
    private final e.a zR;
    private final n zZ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AP;
        public boolean AQ;
        public int AR;
        public int AS;
        public int AT;
        public int AU;
        public byte[] AV;
        public byte[] AW;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AJ = false;
        this.AN = new f();
        this.AO = 0;
        this.AF = handler;
        this.zR = aVar;
        this.zZ = nVar;
        this.AG = ByteBuffer.allocateDirect(nVar.jS() + 14);
        this.AH = new d(nVar.jT());
        this.AL = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.AF.obtainMessage();
        obtainMessage.obj = obj;
        this.AF.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=8] */
    private boolean jZ() {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.AL == null) {
            if (this.AG.position() >= 2) {
                byte b = this.AG.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.AG.get(1);
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
                    if (!this.AJ && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.AJ && i4 != 0) {
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
                if (this.AG.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.AG.get(2) & 255) << 8) | (this.AG.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.AG.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.AG.get(2) & 255) << 56) | ((this.AG.get(3) & 255) << 48) | ((this.AG.get(4) & 255) << 40) | ((this.AG.get(5) & 255) << 32) | ((this.AG.get(6) & 255) << 24) | ((this.AG.get(7) & 255) << 16) | ((this.AG.get(8) & 255) << 8) | (this.AG.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.AL = new a(null);
                    this.AL.AP = i4;
                    this.AL.AQ = z;
                    this.AL.AR = i3;
                    this.AL.AT = (int) j;
                    this.AL.AS = i2;
                    this.AL.AU = this.AL.AS + this.AL.AT;
                    this.AL.AV = null;
                    int position = this.AG.position();
                    this.AL.AW = new byte[this.AL.AS];
                    this.AG.position(0);
                    this.AG.get(this.AL.AW, 0, this.AL.AS);
                    this.AG.position(this.AL.AS);
                    this.AG.limit(position);
                    this.AG.compact();
                    return this.AL.AT == 0 || this.AG.position() >= this.AL.AT;
                }
                return false;
            }
            return false;
        } else if (this.AM < this.AL.AT) {
            int position2 = this.AG.position();
            if (this.AL.AT - this.AM < position2) {
                position2 = this.AL.AT - this.AM;
            }
            int position3 = this.AG.position();
            if (this.AL.AT > 0) {
                bArr = new byte[position2];
                this.AG.position(0);
                this.AG.get(bArr, 0, position2);
            }
            this.AG.position(position2);
            this.AG.limit(position3);
            this.AG.compact();
            if (bArr != null) {
                this.AH.write(bArr);
            }
            this.AM = position2 + this.AM;
            return this.AM >= this.AL.AT;
        } else {
            if (this.AL.AP <= 7) {
                if (!this.AJ) {
                    this.AJ = true;
                    this.AK = this.AL.AP;
                    if (this.AK == 1 && this.zZ.jW()) {
                        this.AN.reset();
                    }
                }
                if (this.AK == 1 && this.zZ.jW() && !this.AN.E(this.AH.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AL.AQ) {
                    if (this.AK == 1) {
                        if (this.zZ.jW() && !this.AN.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zZ.jR()) {
                            F(this.AH.toByteArray());
                        } else {
                            I(new String(this.AH.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AK != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.AH.toByteArray());
                    }
                    this.AJ = false;
                    this.AH.reset();
                }
            } else if (this.AL.AP == 8) {
                if (this.AL.AT >= 2) {
                    i = (this.AL.AW[1] & 255) + ((this.AL.AW[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.AL.AT > 2) {
                        byte[] bArr2 = new byte[this.AL.AT - 2];
                        System.arraycopy(this.AL.AW, 2, bArr2, 0, this.AL.AT - 2);
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
            } else if (this.AL.AP == 9) {
                G(this.AH.toByteArray());
            } else if (this.AL.AP != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.AH.toByteArray());
            }
            this.AL = null;
            this.AM = 0;
            return this.AG.position() > 0;
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
        q(new m.C0009m(bArr));
    }

    protected void w(byte[] bArr) {
        q(new m.a(bArr));
    }

    private boolean ka() {
        boolean z;
        boolean z2;
        int position = this.AG.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AG.get(position + 0) != 13 || this.AG.get(position + 1) != 10 || this.AG.get(position + 2) != 13 || this.AG.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AG.position();
                Map<String, String> map = null;
                if (this.AG.get(0) == 72 && this.AG.get(1) == 84 && this.AG.get(2) == 84 && this.AG.get(3) == 80) {
                    Pair<Integer, String> kb = kb();
                    if (((Integer) kb.first).intValue() >= 300) {
                        q(new m.p(((Integer) kb.first).intValue(), (String) kb.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AG.position(0);
                        byte[] bArr = new byte[position];
                        this.AG.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.AG.position(position + 4);
                this.AG.limit(position2);
                this.AG.compact();
                if (this.AO < this.zR.jA() && map.size() == 0) {
                    this.AO++;
                    return true;
                }
                this.AO = 0;
                if (!z) {
                    z2 = this.AG.position() > 0;
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

    private Pair<Integer, String> kb() {
        int i = 4;
        while (i < this.AG.position() && this.AG.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AG.position() && this.AG.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AG.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AG.position() && this.AG.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AG.position(i6);
        this.AG.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean kc() {
        if (this.mState == 3 || this.mState == 2) {
            return jZ();
        }
        if (this.mState == 1) {
            return ka();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zR.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [750=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AG.clear();
            do {
                try {
                    int read = this.zR.read(this.AG);
                    if (read > 0) {
                        synchronized (o.class) {
                            AI += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (kc());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.iQ()) {
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

    public void jI() {
        synchronized (o.class) {
            AI = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AI;
        }
        return j;
    }
}
