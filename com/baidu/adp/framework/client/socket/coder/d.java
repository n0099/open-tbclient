package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ae;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pU = null;
    private SecretKey pV = null;
    private byte[] pW = null;

    public static d eL() {
        if (pU == null) {
            synchronized (d.class) {
                if (pU == null) {
                    pU = new d();
                }
            }
        }
        return pU;
    }

    public void i(byte[] bArr) {
        try {
            PublicKey q = ae.q(bArr);
            String ad = ae.ad(32);
            byte[] bArr2 = new byte[ad.length()];
            for (int i = 0; i < ad.length(); i++) {
                bArr2[i] = (byte) ad.charAt(i);
            }
            this.pV = ae.aZ(ad);
            this.pW = ae.a(q, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pV = null;
            this.pW = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eM() {
        return this.pW;
    }

    public SecretKey getSecretKey() {
        return this.pV;
    }
}
