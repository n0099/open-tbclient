package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.g;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.i;
import com.baidu.swan.games.bdtls.model.j;
/* loaded from: classes9.dex */
public class d {
    private static volatile d edp;

    public static d aUk() {
        if (edp == null) {
            synchronized (d.class) {
                if (edp == null) {
                    edp = new d();
                }
            }
        }
        return edp;
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
                h aVi = h.edJ.aVi();
                aVi.c((byte) 22);
                aVi.d((short) a2.length);
                aVi.Q(a2);
                return com.baidu.swan.games.bdtls.a.b.a(aVi);
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
            h aVi = h.edJ.aVi();
            aVi.c((byte) 23);
            byte[] aVu = jVar.aVu();
            if (aVu != null && aVu.length > 0 && aVu.length <= 32767) {
                aVi.d((short) aVu.length);
                aVi.Q(aVu);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] h = AES.h(str, jVar.aVt());
                aVi.kZ(h.length);
                aVi.setContent(h);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aVi);
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
            switch (U.aVd()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(U.aVh());
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
                    iVar.wd(new String(AES.d(U.getContent(), jVar.aVt())));
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

    public static byte[] kU(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int M(byte[] bArr) {
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
    public static String N(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(",");
        }
        return sb.toString();
    }
}
