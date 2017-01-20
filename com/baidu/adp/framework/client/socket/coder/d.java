package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d iH = null;
    private SecretKey iI = null;
    private byte[] iJ = null;

    public static d cb() {
        if (iH == null) {
            synchronized (d.class) {
                if (iH == null) {
                    iH = new d();
                }
            }
        }
        return iH;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String av = v.av(32);
            byte[] bArr2 = new byte[av.length()];
            for (int i = 0; i < av.length(); i++) {
                bArr2[i] = (byte) av.charAt(i);
            }
            this.iI = v.aU(av);
            this.iJ = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.iI = null;
            this.iJ = new byte[0];
        }
    }

    private d() {
    }

    public byte[] cc() {
        return this.iJ;
    }

    public SecretKey getSecretKey() {
        return this.iI;
    }
}
