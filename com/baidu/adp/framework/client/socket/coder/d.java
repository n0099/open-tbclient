package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pY = null;
    private SecretKey pZ = null;
    private byte[] qa = null;

    public static d eP() {
        if (pY == null) {
            synchronized (d.class) {
                if (pY == null) {
                    pY = new d();
                }
            }
        }
        return pY;
    }

    public void v(byte[] bArr) {
        try {
            PublicKey D = v.D(bArr);
            String ar = v.ar(32);
            byte[] bArr2 = new byte[ar.length()];
            for (int i = 0; i < ar.length(); i++) {
                bArr2[i] = (byte) ar.charAt(i);
            }
            this.pZ = v.aX(ar);
            this.qa = v.a(D, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pZ = null;
            this.qa = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eQ() {
        return this.qa;
    }

    public SecretKey getSecretKey() {
        return this.pZ;
    }
}
