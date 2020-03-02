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
/* loaded from: classes11.dex */
public class d {
    private static volatile d ckJ;

    public static d alI() {
        if (ckJ == null) {
            synchronized (d.class) {
                if (ckJ == null) {
                    ckJ = new d();
                }
            }
        }
        return ckJ;
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
                h amG = h.cld.amG();
                amG.b((byte) 22);
                amG.c((short) a.length);
                amG.H(a);
                return com.baidu.swan.games.bdtls.a.b.a(amG);
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
            h amG = h.cld.amG();
            amG.b((byte) 23);
            byte[] amS = jVar.amS();
            if (amS != null && amS.length > 0 && amS.length <= 32767) {
                amG.c((short) amS.length);
                amG.H(amS);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.amR());
                amG.hM(f.length);
                amG.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(amG);
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
            h L = com.baidu.swan.games.bdtls.a.b.L(bArr);
            switch (L.amB()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(L.amF());
                    if (parseFrom != null) {
                        if (a.DEBUG) {
                            Log.d("BDTLS", "bdtls ubc application alert");
                        }
                        f.a(jVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            iVar.b(-2);
                        } else {
                            iVar.b(-1);
                        }
                        if (a.DEBUG) {
                            if (parseFrom.getDescription() != null) {
                                String str = new String(parseFrom.getDescription().toByteArray());
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
                        iVar.b(-1);
                        break;
                    }
                    break;
                case 23:
                    iVar.ow(new String(AES.c(L.getContent(), jVar.amR())));
                    iVar.b(1);
                    break;
            }
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
            }
            iVar.b(-1);
        }
        return iVar;
    }

    public static byte[] hG(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int D(byte[] bArr) {
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
    public static String E(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }
}
