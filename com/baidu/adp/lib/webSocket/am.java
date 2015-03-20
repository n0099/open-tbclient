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
public class am extends Thread {
    private static long AZ = 0;
    private final Handler AW;
    private final ByteBuffer AX;
    private final d AY;
    private final f Ak;
    private final al As;
    private boolean Ba;
    private int Bb;
    private an Bc;
    private int Bd;
    private final i Be;
    private int Bf;
    private int mState;
    private boolean mStopped;

    public am(Handler handler, f fVar, al alVar, String str) {
        super(str);
        this.mStopped = false;
        this.Ba = false;
        this.Be = new i();
        this.Bf = 0;
        this.AW = handler;
        this.Ak = fVar;
        this.As = alVar;
        this.AX = ByteBuffer.allocateDirect(alVar.jH() + 14);
        this.AY = new d(alVar.jI());
        this.Bc = null;
        this.mState = 1;
    }

    protected void p(Object obj) {
        Message obtainMessage = this.AW.obtainMessage();
        obtainMessage.obj = obj;
        this.AW.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=8] */
    private boolean jO() {
        int i;
        long j;
        int i2 = 2;
        if (this.Bc != null) {
            if (this.Bd < this.Bc.Bk) {
                int position = this.AX.position();
                if (this.Bc.Bk - this.Bd < position) {
                    position = this.Bc.Bk - this.Bd;
                }
                byte[] bArr = null;
                int position2 = this.AX.position();
                if (this.Bc.Bk > 0) {
                    bArr = new byte[position];
                    this.AX.position(0);
                    this.AX.get(bArr, 0, position);
                }
                this.AX.position(position);
                this.AX.limit(position2);
                this.AX.compact();
                this.AY.write(bArr);
                this.Bd = position + this.Bd;
                return this.Bd >= this.Bc.Bk;
            }
            if (this.Bc.Bg <= 7) {
                if (!this.Ba) {
                    this.Ba = true;
                    this.Bb = this.Bc.Bg;
                    if (this.Bb == 1 && this.As.jL()) {
                        this.Be.reset();
                    }
                }
                if (this.Bb == 1 && this.As.jL() && !this.Be.r(this.AY.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Bc.Bh) {
                    if (this.Bb == 1) {
                        if (this.As.jL() && !this.Be.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.As.jG()) {
                            s(this.AY.toByteArray());
                        } else {
                            G(new String(this.AY.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Bb != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        j(this.AY.toByteArray());
                    }
                    this.Ba = false;
                    this.AY.reset();
                }
            } else if (this.Bc.Bg == 8) {
                int i3 = 1005;
                String str = null;
                if (this.Bc.Bk >= 2) {
                    i3 = ((this.Bc.Bn[0] & 255) * 256) + (this.Bc.Bn[1] & 255);
                    if (i3 < 1000 || (!(i3 < 1000 || i3 > 2999 || i3 == 1000 || i3 == 1001 || i3 == 1002 || i3 == 1003 || i3 == 1007 || i3 == 1008 || i3 == 1009 || i3 == 1010 || i3 == 1011) || i3 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i3);
                    }
                    if (this.Bc.Bk > 2) {
                        byte[] bArr2 = new byte[this.Bc.Bk - 2];
                        System.arraycopy(this.Bc.Bn, 2, bArr2, 0, this.Bc.Bk - 2);
                        i iVar = new i();
                        iVar.r(bArr2);
                        if (!iVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    }
                }
                l(i3, str);
            } else if (this.Bc.Bg == 9) {
                t(this.AY.toByteArray());
            } else if (this.Bc.Bg != 10) {
                throw new Exception("BdLogic error");
            } else {
                u(this.AY.toByteArray());
            }
            this.Bc = null;
            this.Bd = 0;
            return this.AX.position() > 0;
        } else if (this.AX.position() >= 2) {
            byte b = this.AX.get(0);
            boolean z = (b & 128) != 0;
            int i4 = (b & 112) >> 4;
            int i5 = b & 15;
            byte b2 = this.AX.get(1);
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
                if (!this.Ba && i5 == 0) {
                    throw new WebSocketException("received continuation data frame outside fragmented message");
                }
                if (this.Ba && i5 != 0) {
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
            if (this.AX.position() >= i) {
                if (i6 == 126) {
                    j = ((this.AX.get(2) & 255) << 8) | (this.AX.get(3) & 255);
                    if (j < 126) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 4;
                } else if (i6 != 127) {
                    j = i6;
                } else if ((this.AX.get(2) & 128) != 0) {
                    throw new WebSocketException("invalid data frame length (> 2^63)");
                } else {
                    j = ((this.AX.get(2) & 255) << 56) | ((this.AX.get(3) & 255) << 48) | ((this.AX.get(4) & 255) << 40) | ((this.AX.get(5) & 255) << 32) | ((this.AX.get(6) & 255) << 24) | ((this.AX.get(7) & 255) << 16) | ((this.AX.get(8) & 255) << 8) | (this.AX.get(9) & 255);
                    if (j < 65536) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 10;
                }
                this.Bc = new an(null);
                this.Bc.Bg = i5;
                this.Bc.Bh = z;
                this.Bc.Bi = i4;
                this.Bc.Bk = (int) j;
                this.Bc.Bj = i;
                this.Bc.Bl = this.Bc.Bj + this.Bc.Bk;
                if (z2) {
                    this.Bc.Bm = new byte[4];
                    for (int i8 = 0; i8 < 4; i8++) {
                        this.Bc.Bm[i2] = (byte) (this.AX.get(i2 + i8) & 255);
                    }
                    int i9 = i2 + 4;
                } else {
                    this.Bc.Bm = null;
                }
                int position3 = this.AX.position();
                this.Bc.Bn = new byte[this.Bc.Bj];
                this.AX.position(0);
                this.AX.get(this.Bc.Bn, 0, this.Bc.Bj);
                this.AX.position(this.Bc.Bj);
                this.AX.limit(position3);
                this.AX.compact();
                return this.Bc.Bk == 0 || this.AX.position() >= this.Bc.Bk;
            }
            return false;
        } else {
            return false;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        p(new ai(z, map));
    }

    protected void l(int i, String str) {
        p(new u(i, str));
    }

    protected void t(byte[] bArr) {
        p(new ab(bArr));
    }

    protected void u(byte[] bArr) {
        p(new ac(bArr));
    }

    protected void G(String str) {
        p(new ak(str));
    }

    protected void s(byte[] bArr) {
        p(new ae(bArr));
    }

    protected void j(byte[] bArr) {
        p(new s(bArr));
    }

    private boolean jP() {
        boolean z;
        boolean z2;
        int position = this.AX.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AX.get(position + 0) != 13 || this.AX.get(position + 1) != 10 || this.AX.get(position + 2) != 13 || this.AX.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AX.position();
                Map<String, String> map = null;
                if (this.AX.get(0) == 72 && this.AX.get(1) == 84 && this.AX.get(2) == 84 && this.AX.get(3) == 80) {
                    Pair<Integer, String> jQ = jQ();
                    if (((Integer) jQ.first).intValue() >= 300) {
                        p(new ah(((Integer) jQ.first).intValue(), (String) jQ.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AX.position(0);
                        byte[] bArr = new byte[position];
                        this.AX.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.AX.position(position + 4);
                this.AX.limit(position2);
                this.AX.compact();
                if (this.Bf < this.Ak.jp() && map.size() == 0) {
                    this.Bf++;
                    return true;
                }
                this.Bf = 0;
                if (!z) {
                    z2 = this.AX.position() > 0;
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

    private Map<String, String> v(byte[] bArr) {
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

    private Pair<Integer, String> jQ() {
        int i = 4;
        while (i < this.AX.position() && this.AX.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AX.position() && this.AX.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AX.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AX.position() && this.AX.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AX.position(i6);
        this.AX.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean jR() {
        if (this.mState == 3 || this.mState == 2) {
            return jO();
        }
        if (this.mState == 1) {
            return jP();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ak.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [749=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AX.clear();
            do {
                try {
                    int read = this.Ak.read(this.AX);
                    if (read > 0) {
                        synchronized (am.class) {
                            AZ += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (jR());
                    } else if (read < 0) {
                        p(new v(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo().isAvailable()) {
                        this.mStopped = true;
                        p(new v(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (Exception e2) {
            p(new x(e2));
        } catch (SocketException e3) {
            p(new v(e3));
        } catch (WebSocketException e4) {
            p(new ad(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void jy() {
        synchronized (am.class) {
            AZ = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (am.class) {
            j = AZ;
        }
        return j;
    }
}
