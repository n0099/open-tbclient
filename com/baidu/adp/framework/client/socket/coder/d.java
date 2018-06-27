package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d uO = null;
    private SecretKey uP = null;
    private byte[] uQ = null;

    public static d fH() {
        if (uO == null) {
            synchronized (d.class) {
                if (uO == null) {
                    uO = new d();
                }
            }
        }
        return uO;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = u.p(bArr);
            String ar = u.ar(32);
            byte[] bArr2 = new byte[ar.length()];
            for (int i = 0; i < ar.length(); i++) {
                bArr2[i] = (byte) ar.charAt(i);
            }
            this.uP = u.bm(ar);
            this.uQ = u.b(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.uP = null;
            this.uQ = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fI() {
        return this.uQ;
    }

    public SecretKey getSecretKey() {
        return this.uP;
    }
}
