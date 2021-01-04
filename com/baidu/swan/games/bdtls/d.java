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
    private static volatile d efU;

    public static d aXR() {
        if (efU == null) {
            synchronized (d.class) {
                if (efU == null) {
                    efU = new d();
                }
            }
        }
        return efU;
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
                h aYP = h.egp.aYP();
                aYP.c((byte) 22);
                aYP.d((short) a2.length);
                aYP.S(a2);
                return com.baidu.swan.games.bdtls.a.b.a(aYP);
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
            h aYP = h.egp.aYP();
            aYP.c((byte) 23);
            byte[] aZb = jVar.aZb();
            if (aZb != null && aZb.length > 0 && aZb.length <= 32767) {
                aYP.d((short) aZb.length);
                aYP.S(aZb);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] h = AES.h(str, jVar.aZa());
                aYP.mC(h.length);
                aYP.setContent(h);
            }
            return com.baidu.swan.games.bdtls.a.b.a(aYP);
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
            h W = com.baidu.swan.games.bdtls.a.b.W(bArr);
            switch (W.aYK()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(W.aYO());
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
                    iVar.wV(new String(AES.d(W.getContent(), jVar.aZa())));
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

    public static byte[] mx(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int O(byte[] bArr) {
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
    public static String P(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(",");
        }
        return sb.toString();
    }
}
