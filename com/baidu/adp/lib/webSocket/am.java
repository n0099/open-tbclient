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
    private static long AO = 0;
    private final Handler AL;
    private final ByteBuffer AM;
    private final d AN;
    private boolean AP;
    private int AQ;
    private an AR;
    private int AS;
    private final i AT;
    private int AU;
    private final al Ah;
    private int mState;
    private boolean mStopped;
    private final f zY;

    public am(Handler handler, f fVar, al alVar, String str) {
        super(str);
        this.mStopped = false;
        this.AP = false;
        this.AT = new i();
        this.AU = 0;
        this.AL = handler;
        this.zY = fVar;
        this.Ah = alVar;
        this.AM = ByteBuffer.allocateDirect(alVar.jY() + 14);
        this.AN = new d(alVar.jZ());
        this.AR = null;
        this.mState = 1;
    }

    protected void p(Object obj) {
        Message obtainMessage = this.AL.obtainMessage();
        obtainMessage.obj = obj;
        this.AL.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=8] */
    private boolean kf() {
        int i;
        long j;
        int i2 = 2;
        if (this.AR != null) {
            if (this.AS < this.AR.AZ) {
                int position = this.AM.position();
                if (this.AR.AZ - this.AS < position) {
                    position = this.AR.AZ - this.AS;
                }
                byte[] bArr = null;
                int position2 = this.AM.position();
                if (this.AR.AZ > 0) {
                    bArr = new byte[position];
                    this.AM.position(0);
                    this.AM.get(bArr, 0, position);
                }
                this.AM.position(position);
                this.AM.limit(position2);
                this.AM.compact();
                this.AN.write(bArr);
                this.AS = position + this.AS;
                return this.AS >= this.AR.AZ;
            }
            if (this.AR.AV <= 7) {
                if (!this.AP) {
                    this.AP = true;
                    this.AQ = this.AR.AV;
                    if (this.AQ == 1 && this.Ah.kc()) {
                        this.AT.reset();
                    }
                }
                if (this.AQ == 1 && this.Ah.kc() && !this.AT.r(this.AN.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.AR.AW) {
                    if (this.AQ == 1) {
                        if (this.Ah.kc() && !this.AT.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ah.jX()) {
                            s(this.AN.toByteArray());
                        } else {
                            J(new String(this.AN.toByteArray(), "UTF-8"));
                        }
                    } else if (this.AQ != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        j(this.AN.toByteArray());
                    }
                    this.AP = false;
                    this.AN.reset();
                }
            } else if (this.AR.AV == 8) {
                int i3 = 1005;
                String str = null;
                if (this.AR.AZ >= 2) {
                    i3 = ((this.AR.Bc[0] & 255) * 256) + (this.AR.Bc[1] & 255);
                    if (i3 < 1000 || (!(i3 < 1000 || i3 > 2999 || i3 == 1000 || i3 == 1001 || i3 == 1002 || i3 == 1003 || i3 == 1007 || i3 == 1008 || i3 == 1009 || i3 == 1010 || i3 == 1011) || i3 >= 5000)) {
                        throw new WebSocketException("invalid close code " + i3);
                    }
                    if (this.AR.AZ > 2) {
                        byte[] bArr2 = new byte[this.AR.AZ - 2];
                        System.arraycopy(this.AR.Bc, 2, bArr2, 0, this.AR.AZ - 2);
                        i iVar = new i();
                        iVar.r(bArr2);
                        if (!iVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    }
                }
                l(i3, str);
            } else if (this.AR.AV == 9) {
                t(this.AN.toByteArray());
            } else if (this.AR.AV != 10) {
                throw new Exception("BdLogic error");
            } else {
                u(this.AN.toByteArray());
            }
            this.AR = null;
            this.AS = 0;
            return this.AM.position() > 0;
        } else if (this.AM.position() >= 2) {
            byte b = this.AM.get(0);
            boolean z = (b & 128) != 0;
            int i4 = (b & 112) >> 4;
            int i5 = b & 15;
            byte b2 = this.AM.get(1);
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
                if (!this.AP && i5 == 0) {
                    throw new WebSocketException("received continuation data frame outside fragmented message");
                }
                if (this.AP && i5 != 0) {
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
            if (this.AM.position() >= i) {
                if (i6 == 126) {
                    j = ((this.AM.get(2) & 255) << 8) | (this.AM.get(3) & 255);
                    if (j < 126) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 4;
                } else if (i6 != 127) {
                    j = i6;
                } else if ((this.AM.get(2) & 128) != 0) {
                    throw new WebSocketException("invalid data frame length (> 2^63)");
                } else {
                    j = ((this.AM.get(2) & 255) << 56) | ((this.AM.get(3) & 255) << 48) | ((this.AM.get(4) & 255) << 40) | ((this.AM.get(5) & 255) << 32) | ((this.AM.get(6) & 255) << 24) | ((this.AM.get(7) & 255) << 16) | ((this.AM.get(8) & 255) << 8) | (this.AM.get(9) & 255);
                    if (j < 65536) {
                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                    }
                    i2 = 10;
                }
                this.AR = new an(null);
                this.AR.AV = i5;
                this.AR.AW = z;
                this.AR.AX = i4;
                this.AR.AZ = (int) j;
                this.AR.AY = i;
                this.AR.Ba = this.AR.AY + this.AR.AZ;
                if (z2) {
                    this.AR.Bb = new byte[4];
                    for (int i8 = 0; i8 < 4; i8++) {
                        this.AR.Bb[i2] = (byte) (this.AM.get(i2 + i8) & 255);
                    }
                    int i9 = i2 + 4;
                } else {
                    this.AR.Bb = null;
                }
                int position3 = this.AM.position();
                this.AR.Bc = new byte[this.AR.AY];
                this.AM.position(0);
                this.AM.get(this.AR.Bc, 0, this.AR.AY);
                this.AM.position(this.AR.AY);
                this.AM.limit(position3);
                this.AM.compact();
                return this.AR.AZ == 0 || this.AM.position() >= this.AR.AZ;
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

    protected void J(String str) {
        p(new ak(str));
    }

    protected void s(byte[] bArr) {
        p(new ae(bArr));
    }

    protected void j(byte[] bArr) {
        p(new s(bArr));
    }

    private boolean kg() {
        boolean z;
        boolean z2;
        int position = this.AM.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.AM.get(position + 0) != 13 || this.AM.get(position + 1) != 10 || this.AM.get(position + 2) != 13 || this.AM.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.AM.position();
                Map<String, String> map = null;
                if (this.AM.get(0) == 72 && this.AM.get(1) == 84 && this.AM.get(2) == 84 && this.AM.get(3) == 80) {
                    Pair<Integer, String> kh = kh();
                    if (((Integer) kh.first).intValue() >= 300) {
                        p(new ah(((Integer) kh.first).intValue(), (String) kh.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.AM.position(0);
                        byte[] bArr = new byte[position];
                        this.AM.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.AM.position(position + 4);
                this.AM.limit(position2);
                this.AM.compact();
                if (this.AU < this.zY.jG() && map.size() == 0) {
                    this.AU++;
                    return true;
                }
                this.AU = 0;
                if (!z) {
                    z2 = this.AM.position() > 0;
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

    private Pair<Integer, String> kh() {
        int i = 4;
        while (i < this.AM.position() && this.AM.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.AM.position() && this.AM.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.AM.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.AM.position() && this.AM.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.AM.position(i6);
        this.AM.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean ki() {
        if (this.mState == 3 || this.mState == 2) {
            return kf();
        }
        if (this.mState == 1) {
            return kg();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.zY.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [749=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.AM.clear();
            do {
                try {
                    int read = this.zY.read(this.AM);
                    if (read > 0) {
                        synchronized (am.class) {
                            AO += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ki());
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

    public void jP() {
        synchronized (am.class) {
            AO = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (am.class) {
            j = AO;
        }
        return j;
    }
}
