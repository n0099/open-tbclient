package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.i;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes25.dex */
public class d {
    private static volatile d dWX;

    public static d aVx() {
        if (dWX == null) {
            synchronized (d.class) {
                if (dWX == null) {
                    dWX = new d();
                }
            }
        }
        return dWX;
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
                h aWv = h.dXr.aWv();
                aWv.c((byte) 22);
                aWv.d((short) a2.length);
                aWv.V(a2);
                return com.baidu.swan.games.bdtls.a.b.a(aWv);
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
            h aWv = h.dXr.aWv();
            aWv.c((byte) 23);
            byte[] aWH = jVar.aWH();
            if (aWH != null && aWH.length > 0 && aWH.length <= 32767) {
                aWv.d((short) aWH.length);
                aWv.V(aWH);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.aWG());
                aWv.mu(f.length);
                aWv.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aWv);
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
            h Z = com.baidu.swan.games.bdtls.a.b.Z(bArr);
            switch (Z.aWq()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(Z.aWu());
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
                    iVar.wW(new String(AES.d(Z.getContent(), jVar.aWG())));
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

    public static byte[] mp(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int R(byte[] bArr) {
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
    public static String S(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(",");
        }
        return sb.toString();
    }
}
