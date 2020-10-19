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
/* loaded from: classes10.dex */
public class d {
    private static volatile d dDs;

    public static d aOG() {
        if (dDs == null) {
            synchronized (d.class) {
                if (dDs == null) {
                    dDs = new d();
                }
            }
        }
        return dDs;
    }

    private d() {
    }

    public byte[] a(j jVar) {
        if (jVar == null) {
            return null;
        }
        try {
            byte[] a2 = com.baidu.swan.games.bdtls.a.a.a(jVar, new g());
            if (a2 != null) {
                h aPE = h.dDM.aPE();
                aPE.c((byte) 22);
                aPE.c((short) a2.length);
                aPE.T(a2);
                return com.baidu.swan.games.bdtls.a.b.a(aPE);
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
            h aPE = h.dDM.aPE();
            aPE.c((byte) 23);
            byte[] aPQ = jVar.aPQ();
            if (aPQ != null && aPQ.length > 0 && aPQ.length <= 32767) {
                aPE.c((short) aPQ.length);
                aPE.T(aPQ);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.aPP());
                aPE.lF(f.length);
                aPE.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aPE);
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
            switch (X.aPz()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(X.aPD());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.DEBUG) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        f.a(jVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            iVar.f(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            iVar.f(2);
                        } else {
                            iVar.f(-1);
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
                        iVar.f(-1);
                        break;
                    }
                    break;
                case 23:
                    iVar.vN(new String(AES.d(X.getContent(), jVar.aPP())));
                    iVar.f(1);
                    break;
            }
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
            }
            iVar.f(-1);
        }
        return iVar;
    }

    public static byte[] lA(int i) {
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
