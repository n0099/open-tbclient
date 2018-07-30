package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d uG = null;
    private SecretKey uH = null;
    private byte[] uI = null;

    public static d fG() {
        if (uG == null) {
            synchronized (d.class) {
                if (uG == null) {
                    uG = new d();
                }
            }
        }
        return uG;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey n = u.n(bArr);
            String as = u.as(32);
            byte[] bArr2 = new byte[as.length()];
            for (int i = 0; i < as.length(); i++) {
                bArr2[i] = (byte) as.charAt(i);
            }
            this.uH = u.bn(as);
            this.uI = u.b(n, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.uH = null;
            this.uI = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fH() {
        return this.uI;
    }

    public SecretKey getSecretKey() {
        return this.uH;
    }
}
