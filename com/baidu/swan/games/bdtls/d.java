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
/* loaded from: classes3.dex */
public class d {
    private static volatile d dro;

    public static d aLX() {
        if (dro == null) {
            synchronized (d.class) {
                if (dro == null) {
                    dro = new d();
                }
            }
        }
        return dro;
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
                h aMV = h.drJ.aMV();
                aMV.c((byte) 22);
                aMV.c((short) a.length);
                aMV.T(a);
                return com.baidu.swan.games.bdtls.a.b.a(aMV);
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
            h aMV = h.drJ.aMV();
            aMV.c((byte) 23);
            byte[] aNh = jVar.aNh();
            if (aNh != null && aNh.length > 0 && aNh.length <= 32767) {
                aMV.c((short) aNh.length);
                aMV.T(aNh);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.aNg());
                aMV.li(f.length);
                aMV.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aMV);
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
            switch (X.aMQ()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(X.aMU());
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
                    iVar.vb(new String(AES.d(X.getContent(), jVar.aNg())));
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

    public static byte[] ld(int i) {
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
