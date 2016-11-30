package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d iL = null;
    private SecretKey iM = null;
    private byte[] iN = null;

    public static d cb() {
        if (iL == null) {
            synchronized (d.class) {
                if (iL == null) {
                    iL = new d();
                }
            }
        }
        return iL;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String au = v.au(32);
            byte[] bArr2 = new byte[au.length()];
            for (int i = 0; i < au.length(); i++) {
                bArr2[i] = (byte) au.charAt(i);
            }
            this.iM = v.aV(au);
            this.iN = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.iM = null;
            this.iN = new byte[0];
        }
    }

    private d() {
    }

    public byte[] cc() {
        return this.iN;
    }

    public SecretKey getSecretKey() {
        return this.iM;
    }
}
