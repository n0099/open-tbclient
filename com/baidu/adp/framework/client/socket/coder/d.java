package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d gr = null;
    private SecretKey gs = null;
    private byte[] gt = null;

    public static d bg() {
        if (gr == null) {
            synchronized (d.class) {
                if (gr == null) {
                    gr = new d();
                }
            }
        }
        return gr;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String ah = v.ah(32);
            byte[] bArr2 = new byte[ah.length()];
            for (int i = 0; i < ah.length(); i++) {
                bArr2[i] = (byte) ah.charAt(i);
            }
            this.gs = v.aU(ah);
            this.gt = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.gs = null;
            this.gt = new byte[0];
        }
    }

    private d() {
    }

    public byte[] bh() {
        return this.gt;
    }

    public SecretKey getSecretKey() {
        return this.gs;
    }
}
