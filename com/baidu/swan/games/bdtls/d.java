package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.i;
import com.baidu.swan.games.bdtls.model.j;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class d {
    private static volatile d dpj;

    public static d aLm() {
        if (dpj == null) {
            synchronized (d.class) {
                if (dpj == null) {
                    dpj = new d();
                }
            }
        }
        return dpj;
    }

    private d() {
    }

    public byte[] a(j jVar) {
        if (jVar == null) {
            return null;
        }
        try {
            byte[] a = com.baidu.swan.games.bdtls.a.a.a(jVar, new g());
            if (a != null) {
                h aMk = h.dpD.aMk();
                aMk.c((byte) 22);
                aMk.c((short) a.length);
                aMk.T(a);
                return com.baidu.swan.games.bdtls.a.b.a(aMk);
            }
            return null;
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
                return null;
            }
            return null;
        }
    }

    public byte[] a(j jVar, String str) {
        if (jVar == null) {
            return null;
        }
        try {
            h aMk = h.dpD.aMk();
            aMk.c((byte) 23);
            byte[] aMw = jVar.aMw();
            if (aMw != null && aMw.length > 0 && aMw.length <= 32767) {
                aMk.c((short) aMw.length);
                aMk.T(aMw);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.aMv());
                aMk.kX(f.length);
                aMk.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aMk);
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
                return null;
            }
            return null;
        }
    }

    public i a(j jVar, byte[] bArr) {
        i iVar = new i();
        try {
            h X = com.baidu.swan.games.bdtls.a.b.X(bArr);
            switch (X.aMf()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(X.aMj());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.DEBUG) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        f.a(jVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            iVar.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            iVar.d(2);
                        } else {
                            iVar.d(-1);
                        }
                        if (a.DEBUG) {
                            if (parseFrom.getDescription() != null) {
                                if (a.DEBUG) {
                                    Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                                    break;
                                }
                            } else if (a.DEBUG) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                                break;
                            }
                        }
                    } else {
                        iVar.d(-1);
                        break;
                    }
                    break;
                case 23:
                    iVar.uH(new String(AES.d(X.getContent(), jVar.aMv())));
                    iVar.d(1);
                    break;
            }
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
            }
            iVar.d(-1);
        }
        return iVar;
    }

    public static byte[] kS(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int P(byte[] bArr) {
        if (bArr != null) {
            int i = 0;
            for (byte b : bArr) {
                i = (i << 8) | (b & 255);
            }
            return i;
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String Q(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }
}
