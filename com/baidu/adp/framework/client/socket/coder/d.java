package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d iK = null;
    private SecretKey iL = null;
    private byte[] iM = null;

    public static d cb() {
        if (iK == null) {
            synchronized (d.class) {
                if (iK == null) {
                    iK = new d();
                }
            }
        }
        return iK;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String av = v.av(32);
            byte[] bArr2 = new byte[av.length()];
            for (int i = 0; i < av.length(); i++) {
                bArr2[i] = (byte) av.charAt(i);
            }
            this.iL = v.aV(av);
            this.iM = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.iL = null;
            this.iM = new byte[0];
        }
    }

    private d() {
    }

    public byte[] cc() {
        return this.iM;
    }

    public SecretKey getSecretKey() {
        return this.iL;
    }
}
