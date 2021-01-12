package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.i;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes8.dex */
public class d {
    private static volatile d ebi;

    public static d aTY() {
        if (ebi == null) {
            synchronized (d.class) {
                if (ebi == null) {
                    ebi = new d();
                }
            }
        }
        return ebi;
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
                h aUW = h.ebC.aUW();
                aUW.c((byte) 22);
                aUW.d((short) a2.length);
                aUW.R(a2);
                return com.baidu.swan.games.bdtls.a.b.a(aUW);
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
            h aUW = h.ebC.aUW();
            aUW.c((byte) 23);
            byte[] aVi = jVar.aVi();
            if (aVi != null && aVi.length > 0 && aVi.length <= 32767) {
                aUW.d((short) aVi.length);
                aUW.R(aVi);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] h = AES.h(str, jVar.aVh());
                aUW.kW(h.length);
                aUW.setContent(h);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aUW);
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
            h V = com.baidu.swan.games.bdtls.a.b.V(bArr);
            switch (V.aUR()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(V.aUV());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (a.DEBUG) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        f.a(jVar, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            iVar.h(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            iVar.h(2);
                        } else {
                            iVar.h(-1);
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
                        iVar.h(-1);
                        break;
                    }
                    break;
                case 23:
                    iVar.vK(new String(AES.d(V.getContent(), jVar.aVh())));
                    iVar.h(1);
                    break;
            }
        } catch (Exception e) {
            if (a.DEBUG) {
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
            }
            iVar.h(-1);
        }
        return iVar;
    }

    public static byte[] kR(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int N(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr.length) {
                i = (i3 << 8) | (bArr[i2] & 255);
                i2++;
            } else {
                return i3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String O(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(",");
        }
        return sb.toString();
    }
}
