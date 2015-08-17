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
    private static long AB = 0;
    private final d AA;
    private boolean AC;
    private int AD;
    private a AE;
    private int AF;
    private final f AG;
    private int AH;
    private final Handler Ay;
    private final ByteBuffer Az;
    private int mState;
    private boolean mStopped;
    private final e.a zK;
    private final n zS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int AI;
        public boolean AJ;
        public int AK;
        public int AL;
        public int AM;
        public int AN;
        public byte[] AO;
        public byte[] AP;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.AC = false;
        this.AG = new f();
        this.AH = 0;
        this.Ay = handler;
        this.zK = aVar;
        this.zS = nVar;
        this.Az = ByteBuffer.allocateDirect(nVar.jR() + 14);
        this.AA = new d(nVar.jS());
        this.AE = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        Message obtainMessage = this.Ay.obtainMessage();
        obtainMessage.obj = obj;
        this.Ay.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [219=8] */
    private boolean jY() {
        int i;
        long j;
        int i2 = 2;
        if (this.AE != null) {
            if (this.AF < this.AE.AM) {
                int position = this.Az.position();
                if (this.AE.AM - this.AF < position) {
                    position = this.AE.AM - this.AF;
                }
                byte[] bArr = null;
                int position2 = this.Az.position();
                if (this.AE.AM > 0) {
                    bArr = new byte[position];
                    this.Az.position(0);
                    this.Az.get(bArr, 0, position);
                }
                this.Az.position(position);
                this.Az.limit(position2);
                this.Az.compact();
                if (bArr != null) {
                    this.AA.write(bArr);
                }
                this.AF = position + this.AF;
                return this.AF >= this.AE.AM;
            }
            if (this.AE.AI <= 7) {
                if (!this.AC) {
                    this.AC = true;
                    this.AD = this.AE.AI;
                    if (this.AD == 1 && this.zS.jV()) {
                        this.AG.reset();
                    }
                }
                if (this.AD == 1 && this.zS.jV() && !this.AG.E(this.AA.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AE.AJ) {
                    if (this.AD == 1) {
                        if (this.zS.jV() && !this.AG.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.zS.jQ()) {
                            F(this.AA.toByteArray());
                        } else {
                            I(new String(this.AA.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AD != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        w(this.AA.toByteArray());
                    }
                    this.AC = false;
                    this.AA.reset();
                }
            } else if (this.AE.AI == 8) {
                int i3 = 1005;
                String str = null;
                if (this.AE.AM >= 2) {
                    i3 = ((this.AE.AP[0] & 255) * 256) + (this.AE.AP[1] & 255);
                    if (i3 < 1000 || (!(i3 < 1000 || i3 > 2999 || i3 == 1000 || i3 == 1001 || i3 == 1002 || i3 == 1003 || i3 == 1007 || i3 == 1008 || i3 == 1009 || i3 == 1010 || i3 == 1011) || i3 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i3);
                    }
                    if (this.AE.AM > 2) {
                        byte[] bArr2 = new byte[this.AE.AM - 2];
                        System.arraycopy(this.AE.AP, 2, bArr2, 0, this.AE.AM - 2);
                        f fVar = new f();
                        fVar.E(bArr2);
                        if (!fVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    }
                }
                l(i3, str);
            } else if (this.AE.AI == 9) {
                G(this.AA.toByteArray());
            } else if (this.AE.AI != 10) {
                throw new Exception("BdLogic error");
            } else {
                H(this.AA.toByteArray());
            }
            this.AE = null;
            this.AF = 0;
            return this.Az.position() > 0;
        } else if (this.Az.position() >= 2) {
            byte b = this.Az.get(0);
            boolean z = (b & 128) != 0;
            int i4 = (b & 112) >> 4;
            int i5 = b & 15;
            byte b2 = this.Az.get(1);
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
                if (!this.AC && i5 == 0) {
                    throw new WebSocketException("received continuation data frame outside fragmented message");
                }
                if (this.AC && i5 != 0) {
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
            if (this.Az.position() >= i) {
                if (i6 == 126) {
                    j = ((this.Az.get(2) & 255) << 8) | (this.Az.get(3) & 255);
                    if (j < 126) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 4;
                } else if (i6 != 127) {
                    j = i6;
                } else if ((this.Az.get(2) & 128) != 0) {
                    throw new WebSocketException("invalid data frame length (> 2^63)");
                } else {
                    j = ((this.Az.get(2) & 255) << 56) | ((this.Az.get(3) & 255) << 48) | ((this.Az.get(4) & 255) << 40) | ((this.Az.get(5) & 255) << 32) | ((this.Az.get(6) & 255) << 24) | ((this.Az.get(7) & 255) << 16) | ((this.Az.get(8) & 255) << 8) | (this.Az.get(9) & 255);
                    if (j < 65536) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 10;
                }
                this.AE = new a(null);
                this.AE.AI = i5;
                this.AE.AJ = z;
                this.AE.AK = i4;
                this.AE.AM = (int) j;
                this.AE.AL = i;
                this.AE.AN = this.AE.AL + this.AE.AM;
                if (z2) {
                    this.AE.AO = new byte[4];
                    for (int i8 = 0; i8 < 4; i8++) {
                        this.AE.AO[i2] = (byte) (this.Az.get(i2 + i8) & 255);
                    }
                    int i9 = i2 + 4;
                } else {
                    this.AE.AO = null;
                }
                int position3 = this.Az.position();
                this.AE.AP = new byte[this.AE.AL];
                this.Az.position(0);
                this.Az.get(this.AE.AP, 0, this.AE.AL);
                this.Az.position(this.AE.AL);
                this.Az.limit(position3);
                this.Az.compact();
                return this.AE.AM == 0 || this.Az.position() >= this.AE.AM;
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

    private boolean jZ() {
        boolean z;
        boolean z2;
        int position = this.Az.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Az.get(position + 0) != 13 || this.Az.get(position + 1) != 10 || this.Az.get(position + 2) != 13 || this.Az.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Az.position();
                Map<String, String> map = null;
                if (this.Az.get(0) == 72 && this.Az.get(1) == 84 && this.Az.get(2) == 84 && this.Az.get(3) == 80) {
                    Pair<Integer, String> ka = ka();
                    if (((Integer) ka.first).intValue() >= 300) {
                        q(new m.p(((Integer) ka.first).intValue(), (String) ka.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Az.position(0);
                        byte[] bArr = new byte[position];
                        this.Az.get(bArr);
                        map = I(bArr);
                    }
                } else {
                    z = false;
                }
                this.Az.position(position + 4);
                this.Az.limit(position2);
                this.Az.compact();
                if (this.AH < this.zK.jz() && map.size() == 0) {
                    this.AH++;
                    return true;
                }
                this.AH = 0;
                if (!z) {
                    z2 = this.Az.position() > 0;
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
        while (i < this.Az.position() && this.Az.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Az.position() && this.Az.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Az.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Az.position() && this.Az.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Az.position(i6);
        this.Az.get(bArr, 0, i8);
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
            this.zK.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [746=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Az.clear();
            do {
                try {
                    int read = this.zK.read(this.Az);
                    if (read > 0) {
                        synchronized (o.class) {
                            AB += read;
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
                    if (!com.baidu.adp.lib.util.i.iO()) {
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
            AB = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = AB;
        }
        return j;
    }
}
