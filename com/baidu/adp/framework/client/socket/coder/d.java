package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ad;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pP = null;
    private SecretKey pQ = null;
    private byte[] pR = null;

    public static d eI() {
        if (pP == null) {
            synchronized (d.class) {
                if (pP == null) {
                    pP = new d();
                }
            }
        }
        return pP;
    }

    public void i(byte[] bArr) {
        try {
            PublicKey q = ad.q(bArr);
            String af = ad.af(32);
            byte[] bArr2 = new byte[af.length()];
            for (int i = 0; i < af.length(); i++) {
                bArr2[i] = (byte) af.charAt(i);
            }
            this.pQ = ad.aP(af);
            this.pR = ad.a(q, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pQ = null;
            this.pR = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eJ() {
        return this.pR;
    }

    public SecretKey getSecretKey() {
        return this.pQ;
    }
}
