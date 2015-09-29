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
    private static long AA = 0;
    private boolean AB;
    private int AC;
    private a AD;
    private int AE;
    private final f AF;
    private int AG;
    private final Handler Ax;
    private final ByteBuffer Ay;
    private final d Az;
    private int mState;
    private boolean mStopped;
    private final e.a zJ;
    private final n zR;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AH;
        public boolean AI;
        public int AJ;
        public int AK;
        public int AL;
        public int AM;
        public byte[] AN;
        public byte[] AO;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AB = false;
        this.AF = new f();
        this.AG = 0;
        this.Ax = handler;
        this.zJ = aVar;
        this.zR = nVar;
        this.Ay = ByteBuffer.allocateDirect(nVar.jP() + 14);
        this.Az = new d(nVar.jQ());
        this.AD = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.Ax.obtainMessage();
        obtainMessage.obj = obj;
        this.Ax.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=8] */
    private boolean jW() {
        int i;
        long j;
        int i2 = 2;
        if (this.AD != null) {
            if (this.AE < this.AD.AL) {
                int position = this.Ay.position();
                if (this.AD.AL - this.AE < position) {
                    position = this.AD.AL - this.AE;
                }
                byte[] bArr = null;
                int position2 = this.Ay.position();
                if (this.AD.AL > 0) {
                    bArr = new byte[position];
                    this.Ay.position(0);
                    this.Ay.get(bArr, 0, position);
                }
                this.Ay.position(position);
                this.Ay.limit(position2);
                this.Ay.compact();
                if (bArr != null) {
                    this.Az.write(bArr);
                }
                this.AE = position + this.AE;
                return this.AE >= this.AD.AL;
            }
            if (this.AD.AH <= 7) {
                if (!this.AB) {
                    this.AB = true;
                    this.AC = this.AD.AH;
                    if (this.AC == 1 && this.zR.jT()) {
                        this.AF.reset();
                    }
                }
                if (this.AC == 1 && this.zR.jT() && !this.AF.E(this.Az.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AD.AI) {
                    if (this.AC == 1) {
                        if (this.zR.jT() && !this.AF.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zR.jO()) {
                            F(this.Az.toByteArray());
                        } else {
                            I(new String(this.Az.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AC != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.Az.toByteArray());
                    }
                    this.AB = false;
                    this.Az.reset();
                }
            } else if (this.AD.AH == 8) {
                int i3 = 1005;
                String str = null;
                if (this.AD.AL >= 2) {
                    i3 = ((this.AD.AO[0] & 255) * 256) + (this.AD.AO[1] & 255);
                    if (i3 < 1000 || (!(i3 < 1000 || i3 > 2999 || i3 == 1000 || i3 == 1001 || i3 == 1002 || i3 == 1003 || i3 == 1007 || i3 == 1008 || i3 == 1009 || i3 == 1010 || i3 == 1011) || i3 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i3);
                    }
                    if (this.AD.AL > 2) {
                        byte[] bArr2 = new byte[this.AD.AL - 2];
                        System.arraycopy(this.AD.AO, 2, bArr2, 0, this.AD.AL - 2);
                        f fVar = new f();
                        fVar.E(bArr2);
                        if (!fVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    }
                }
                l(i3, str);
            } else if (this.AD.AH == 9) {
                G(this.Az.toByteArray());
            } else if (this.AD.AH != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.Az.toByteArray());
            }
            this.AD = null;
            this.AE = 0;
            return this.Ay.position() > 0;
        } else if (this.Ay.position() >= 2) {
            byte b = this.Ay.get(0);
            boolean z = (b & 128) != 0;
            int i4 = (b & 112) >> 4;
            int i5 = b & 15;
            byte b2 = this.Ay.get(1);
            boolean z2 = (b2 & 128) != 0;
            int i6 = b2 & Byte.MAX_VALUE;
            if (i4 != 0) {
                throw new WebSocketException("RSV != 0 and no extension negotiated");
            }
            if (z2) {
                throw new WebSocketException("masked server frame");
            }
            if (i5 > 7) {
                if (!z) {
                    throw new WebSocketException("fragmented control frame");
                }
                if (i6 > 125) {
                    throw new WebSocketException("control frame with payload length > 125 octets");
                }
                if (i5 != 8 && i5 != 9 && i5 != 10) {
                    throw new WebSocketException("control frame using reserved opcode " + i5);
                }
                if (i5 == 8 && i6 == 1) {
                    throw new WebSocketException("received close control frame with payload len 1");
                }
            } else if (i5 != 0 && i5 != 1 && i5 != 2) {
                throw new WebSocketException("data frame using reserved opcode " + i5);
            } else {
                if (!this.AB && i5 == 0) {
                    throw new WebSocketException("received continuation data frame outside fragmented message");
                }
                if (this.AB && i5 != 0) {
                    throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                }
            }
            int i7 = z2 ? 4 : 0;
            if (i6 < 126) {
                i = i7 + 2;
            } else if (i6 == 126) {
                i = i7 + 4;
            } else if (i6 != 127) {
                throw new Exception("BdLogic error");
            } else {
                i = i7 + 10;
            }
            if (this.Ay.position() >= i) {
                if (i6 == 126) {
                    j = ((this.Ay.get(2) & 255) << 8) | (this.Ay.get(3) & 255);
                    if (j < 126) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 4;
                } else if (i6 != 127) {
                    j = i6;
                } else if ((this.Ay.get(2) & 128) != 0) {
                    throw new WebSocketException("invalid data frame length (> 2^63)");
                } else {
                    j = ((this.Ay.get(2) & 255) << 56) | ((this.Ay.get(3) & 255) << 48) | ((this.Ay.get(4) & 255) << 40) | ((this.Ay.get(5) & 255) << 32) | ((this.Ay.get(6) & 255) << 24) | ((this.Ay.get(7) & 255) << 16) | ((this.Ay.get(8) & 255) << 8) | (this.Ay.get(9) & 255);
                    if (j < 65536) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 10;
                }
                this.AD = new a(null);
                this.AD.AH = i5;
                this.AD.AI = z;
                this.AD.AJ = i4;
                this.AD.AL = (int) j;
                this.AD.AK = i;
                this.AD.AM = this.AD.AK + this.AD.AL;
                if (z2) {
                    this.AD.AN = new byte[4];
                    for (int i8 = 0; i8 < 4; i8++) {
                        this.AD.AN[i2] = (byte) (this.Ay.get(i2 + i8) & 255);
                    }
                    int i9 = i2 + 4;
                } else {
                    this.AD.AN = null;
                }
                int position3 = this.Ay.position();
                this.AD.AO = new byte[this.AD.AK];
                this.Ay.position(0);
                this.Ay.get(this.AD.AO, 0, this.AD.AK);
                this.Ay.position(this.AD.AK);
                this.Ay.limit(position3);
                this.Ay.compact();
                return this.AD.AL == 0 || this.Ay.position() >= this.AD.AL;
            }
            return false;
        } else {
            return false;
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

    private boolean jX() {
        boolean z;
        boolean z2;
        int position = this.Ay.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ay.get(position + 0) != 13 || this.Ay.get(position + 1) != 10 || this.Ay.get(position + 2) != 13 || this.Ay.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ay.position();
                Map<String, String> map = null;
                if (this.Ay.get(0) == 72 && this.Ay.get(1) == 84 && this.Ay.get(2) == 84 && this.Ay.get(3) == 80) {
                    Pair<Integer, String> jY = jY();
                    if (((Integer) jY.first).intValue() >= 300) {
                        q(new m.p(((Integer) jY.first).intValue(), (String) jY.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ay.position(0);
                        byte[] bArr = new byte[position];
                        this.Ay.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ay.position(position + 4);
                this.Ay.limit(position2);
                this.Ay.compact();
                if (this.AG < this.zJ.jx() && map.size() == 0) {
                    this.AG++;
                    return true;
                }
                this.AG = 0;
                if (!z) {
                    z2 = this.Ay.position() > 0;
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

    private Pair<Integer, String> jY() {
        int i = 4;
        while (i < this.Ay.position() && this.Ay.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ay.position() && this.Ay.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ay.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ay.position() && this.Ay.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ay.position(i6);
        this.Ay.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean jZ() {
        if (this.mState == 3 || this.mState == 2) {
            return jW();
        }
        if (this.mState == 1) {
            return jX();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zJ.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [746=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ay.clear();
            do {
                try {
                    int read = this.zJ.read(this.Ay);
                    if (read > 0) {
                        synchronized (o.class) {
                            AA += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (jZ());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.iM()) {
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

    public void jF() {
        synchronized (o.class) {
            AA = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AA;
        }
        return j;
    }
}
