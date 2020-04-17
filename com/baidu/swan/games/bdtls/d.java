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
    private static volatile d cJS;

    public static d atZ() {
        if (cJS == null) {
            synchronized (d.class) {
                if (cJS == null) {
                    cJS = new d();
                }
            }
        }
        return cJS;
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
                h auX = h.cKm.auX();
                auX.b((byte) 22);
                auX.c((short) a.length);
                auX.J(a);
                return com.baidu.swan.games.bdtls.a.b.a(auX);
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
            h auX = h.cKm.auX();
            auX.b((byte) 23);
            byte[] avi = jVar.avi();
            if (avi != null && avi.length > 0 && avi.length <= 32767) {
                auX.c((short) avi.length);
                auX.J(avi);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] f = AES.f(str, jVar.avh());
                auX.hT(f.length);
                auX.setContent(f);
            }
            return com.baidu.swan.games.bdtls.a.b.a(auX);
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
            h N = com.baidu.swan.games.bdtls.a.b.N(bArr);
            switch (N.auS()) {
                case 21:
                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(N.auW());
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
                    iVar.pI(new String(AES.c(N.getContent(), jVar.avh())));
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

    public static byte[] hN(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int F(byte[] bArr) {
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
    public static String G(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb.toString();
    }
}
