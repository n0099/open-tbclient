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
    private static volatile d cUF;

    public static d axM() {
        if (cUF == null) {
            synchronized (d.class) {
                if (cUF == null) {
                    cUF = new d();
                }
            }
        }
        return cUF;
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
                h ayK = h.cUZ.ayK();
                ayK.c((byte) 22);
                ayK.c((short) a.length);
                ayK.Q(a);
                return com.baidu.swan.games.bdtls.a.b.a(ayK);
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
            h ayK = h.cUZ.ayK();
            ayK.c((byte) 23);
            byte[] ayW = jVar.ayW();
            if (ayW != null && ayW.length > 0 && ayW.length <= 32767) {
                ayK.c((short) ayW.length);
                ayK.Q(ayW);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.ayV());
                ayK.ik(f.length);
                ayK.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(ayK);
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
            h U = com.baidu.swan.games.bdtls.a.b.U(bArr);
            switch (U.ayF()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(U.ayJ());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.DEBUG) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        f.a(jVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            iVar.c(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            iVar.c(2);
                        } else {
                            iVar.c(-1);
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
                        iVar.c(-1);
                        break;
                    }
                    break;
                case 23:
                    iVar.rj(new String(AES.d(U.getContent(), jVar.ayV())));
                    iVar.c(1);
                    break;
            }
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
            }
            iVar.c(-1);
        }
        return iVar;
    }

    /* renamed from: if  reason: not valid java name */
    public static byte[] m27if(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int M(byte[] bArr) {
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
    public static String N(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }
}
