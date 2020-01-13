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
    private static volatile d cgE;

    public static d ajs() {
        if (cgE == null) {
            synchronized (d.class) {
                if (cgE == null) {
                    cgE = new d();
                }
            }
        }
        return cgE;
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
                h akq = h.cgY.akq();
                akq.b((byte) 22);
                akq.b((short) a.length);
                akq.C(a);
                return com.baidu.swan.games.bdtls.a.b.a(akq);
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
            h akq = h.cgY.akq();
            akq.b((byte) 23);
            byte[] akC = jVar.akC();
            if (akC != null && akC.length > 0 && akC.length <= 32767) {
                akq.b((short) akC.length);
                akq.C(akC);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.akB());
                akq.hv(f.length);
                akq.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(akq);
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
            h G = com.baidu.swan.games.bdtls.a.b.G(bArr);
            switch (G.akl()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(G.akp());
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
                    iVar.og(new String(AES.c(G.getContent(), jVar.akB())));
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

    public static byte[] hp(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int y(byte[] bArr) {
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
    public static String z(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }
}
