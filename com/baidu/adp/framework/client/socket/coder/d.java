package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d uH = null;
    private SecretKey uI = null;
    private byte[] uJ = null;

    public static d fG() {
        if (uH == null) {
            synchronized (d.class) {
                if (uH == null) {
                    uH = new d();
                }
            }
        }
        return uH;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey n = u.n(bArr);
            String as = u.as(32);
            byte[] bArr2 = new byte[as.length()];
            for (int i = 0; i < as.length(); i++) {
                bArr2[i] = (byte) as.charAt(i);
            }
            this.uI = u.bn(as);
            this.uJ = u.b(n, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.uI = null;
            this.uJ = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fH() {
        return this.uJ;
    }

    public SecretKey getSecretKey() {
        return this.uI;
    }
}
