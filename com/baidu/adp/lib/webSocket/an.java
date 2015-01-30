package com.baidu.adp.lib.webSocket;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class an extends Thread {
    private static long qo = 0;
    private int mState;
    private boolean mStopped;
    private final g pA;
    private final am pI;
    private final Handler ql;
    private final ByteBuffer qm;
    private final e qn;
    private boolean qp;
    private int qq;
    private ao qr;
    private final j qs;

    public an(Handler handler, g gVar, am amVar, String str) {
        super(str);
        this.mStopped = false;
        this.qp = false;
        this.qs = new j();
        this.ql = handler;
        this.pA = gVar;
        this.pI = amVar;
        this.qm = ByteBuffer.allocateDirect(amVar.gl() + 14);
        this.qn = new e(amVar.gm());
        this.qr = null;
        this.mState = 1;
    }

    protected void p(Object obj) {
        Message obtainMessage = this.ql.obtainMessage();
        obtainMessage.obj = obj;
        this.ql.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [215=8] */
    private boolean gs() {
        String str;
        int i;
        int i2;
        long j;
        int i3 = 2;
        if (this.qr == null) {
            if (this.qm.position() >= 2) {
                byte b = this.qm.get(0);
                boolean z = (b & 128) != 0;
                int i4 = (b & 112) >> 4;
                int i5 = b & 15;
                byte b2 = this.qm.get(1);
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
                    if (!this.qp && i5 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.qp && i5 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                int i7 = z2 ? 4 : 0;
                if (i6 < 126) {
                    i2 = i7 + 2;
                } else if (i6 == 126) {
                    i2 = i7 + 4;
                } else if (i6 != 127) {
                    throw new Exception("BdLogic error");
                } else {
                    i2 = i7 + 10;
                }
                if (this.qm.position() >= i2) {
                    if (i6 == 126) {
                        j = ((this.qm.get(2) & 255) << 8) | (this.qm.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                        i3 = 4;
                    } else if (i6 != 127) {
                        j = i6;
                    } else if ((this.qm.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.qm.get(2) & 255) << 56) | ((this.qm.get(3) & 255) << 48) | ((this.qm.get(4) & 255) << 40) | ((this.qm.get(5) & 255) << 32) | ((this.qm.get(6) & 255) << 24) | ((this.qm.get(7) & 255) << 16) | ((this.qm.get(8) & 255) << 8) | (this.qm.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                        i3 = 10;
                    }
                    if (j > this.pI.gl()) {
                        throw new WebSocketException("frame payload too large");
                    }
                    this.qr = new ao(null);
                    this.qr.qt = i5;
                    this.qr.qu = z;
                    this.qr.qv = i4;
                    this.qr.qx = (int) j;
                    this.qr.qw = i2;
                    this.qr.qy = this.qr.qw + this.qr.qx;
                    if (z2) {
                        this.qr.qz = new byte[4];
                        for (int i8 = 0; i8 < 4; i8++) {
                            this.qr.qz[i3] = (byte) (this.qm.get(i3 + i8) & 255);
                        }
                        int i9 = i3 + 4;
                    } else {
                        this.qr.qz = null;
                    }
                    return this.qr.qx == 0 || this.qm.position() >= this.qr.qy;
                }
                return false;
            }
            return false;
        } else if (this.qm.position() >= this.qr.qy) {
            byte[] bArr = null;
            int position = this.qm.position();
            if (this.qr.qx > 0) {
                bArr = new byte[this.qr.qx];
                this.qm.position(this.qr.qw);
                this.qm.get(bArr, 0, this.qr.qx);
            }
            this.qm.position(this.qr.qy);
            this.qm.limit(position);
            this.qm.compact();
            if (this.qr.qt <= 7) {
                if (!this.qp) {
                    this.qp = true;
                    this.qq = this.qr.qt;
                    if (this.qq == 1 && this.pI.gp()) {
                        this.qs.reset();
                    }
                }
                if (bArr != null) {
                    if (this.qn.size() + bArr.length > this.pI.gm()) {
                        throw new WebSocketException("message payload too large");
                    }
                    if (this.qq == 1 && this.pI.gp() && !this.qs.q(bArr)) {
                        throw new WebSocketException("invalid UTF-8 in text message payload");
                    }
                    this.qn.write(bArr);
                }
                if (this.qr.qu) {
                    if (this.qq == 1) {
                        if (this.pI.gp() && !this.qs.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.pI.gk()) {
                            r(this.qn.toByteArray());
                        } else {
                            y(new String(this.qn.toByteArray(), "UTF-8"));
                        }
                    } else if (this.qq != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        i(this.qn.toByteArray());
                    }
                    this.qp = false;
                    this.qn.reset();
                }
            } else if (this.qr.qt == 8) {
                int i10 = 1005;
                if (this.qr.qx >= 2) {
                    i10 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
                    if (i10 < 1000 || (!(i10 < 1000 || i10 > 2999 || i10 == 1000 || i10 == 1001 || i10 == 1002 || i10 == 1003 || i10 == 1007 || i10 == 1008 || i10 == 1009 || i10 == 1010 || i10 == 1011) || i10 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i10);
                    }
                    if (this.qr.qx > 2) {
                        byte[] bArr2 = new byte[this.qr.qx - 2];
                        System.arraycopy(bArr, 2, bArr2, 0, this.qr.qx - 2);
                        j jVar = new j();
                        jVar.q(bArr2);
                        if (!jVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                        i = i10;
                        l(i, str);
                    }
                }
                str = null;
                i = i10;
                l(i, str);
            } else if (this.qr.qt == 9) {
                s(bArr);
            } else if (this.qr.qt != 10) {
                throw new Exception("BdLogic error");
            } else {
                t(bArr);
            }
            this.qr = null;
            return this.qm.position() > 0;
        } else {
            return false;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        p(new aj(z, map));
    }

    protected void l(int i, String str) {
        p(new v(i, str));
    }

    protected void s(byte[] bArr) {
        p(new ac(bArr));
    }

    protected void t(byte[] bArr) {
        p(new ad(bArr));
    }

    protected void y(String str) {
        p(new al(str));
    }

    protected void r(byte[] bArr) {
        p(new af(bArr));
    }

    protected void i(byte[] bArr) {
        p(new t(bArr));
    }

    private boolean gt() {
        boolean z;
        boolean z2;
        for (int position = this.qm.position() - 4; position >= 0; position--) {
            if (this.qm.get(position + 0) == 13 && this.qm.get(position + 1) == 10 && this.qm.get(position + 2) == 13 && this.qm.get(position + 3) == 10) {
                int position2 = this.qm.position();
                Map<String, String> map = null;
                if (this.qm.get(0) == 72 && this.qm.get(1) == 84 && this.qm.get(2) == 84 && this.qm.get(3) == 80) {
                    Pair<Integer, String> gu = gu();
                    if (((Integer) gu.first).intValue() >= 300) {
                        p(new ai(((Integer) gu.first).intValue(), (String) gu.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.qm.position(0);
                        byte[] bArr = new byte[position];
                        this.qm.get(bArr);
                        map = u(bArr);
                    }
                } else {
                    z = false;
                }
                this.qm.position(position + 4);
                this.qm.limit(position2);
                this.qm.compact();
                if (!z) {
                    z2 = this.qm.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                return z2;
            }
        }
        return false;
    }

    private Map<String, String> u(byte[] bArr) {
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

    private Pair<Integer, String> gu() {
        int i = 4;
        while (i < this.qm.position() && this.qm.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.qm.position() && this.qm.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.qm.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.qm.position() && this.qm.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.qm.position(i6);
        this.qm.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean gv() {
        if (this.mState == 3 || this.mState == 2) {
            return gs();
        }
        if (this.mState == 1) {
            return gt();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.pA.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [736=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.qm.clear();
            do {
                try {
                    int read = this.pA.read(this.qm);
                    if (read > 0) {
                        synchronized (an.class) {
                            qo += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (gv());
                    } else if (read < 0) {
                        p(new w(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo().isAvailable()) {
                        this.mStopped = true;
                        p(new w(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (Exception e2) {
            p(new y(e2));
        } catch (SocketException e3) {
            p(new w(e3));
        } catch (WebSocketException e4) {
            p(new ae(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void gb() {
        synchronized (an.class) {
            qo = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (an.class) {
            j = qo;
        }
        return j;
    }
}
