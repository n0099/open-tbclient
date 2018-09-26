package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d xa = null;
    private SecretKey xb = null;
    private byte[] xc = null;

    public static d gO() {
        if (xa == null) {
            synchronized (d.class) {
                if (xa == null) {
                    xa = new d();
                }
            }
        }
        return xa;
    }

    public void p(byte[] bArr) {
        try {
            PublicKey v = u.v(bArr);
            String aA = u.aA(32);
            byte[] bArr2 = new byte[aA.length()];
            for (int i = 0; i < aA.length(); i++) {
                bArr2[i] = (byte) aA.charAt(i);
            }
            this.xb = u.bE(aA);
            this.xc = u.b(v, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.xb = null;
            this.xc = new byte[0];
        }
    }

    private d() {
    }

    public byte[] gP() {
        return this.xc;
    }

    public SecretKey getSecretKey() {
        return this.xb;
    }
}
