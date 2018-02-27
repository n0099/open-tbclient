package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d adY = null;
    private SecretKey adZ = null;
    private byte[] aea = null;

    public static d kO() {
        if (adY == null) {
            synchronized (d.class) {
                if (adY == null) {
                    adY = new d();
                }
            }
        }
        return adY;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = u.m(bArr);
            String dq = u.dq(32);
            byte[] bArr2 = new byte[dq.length()];
            for (int i = 0; i < dq.length(); i++) {
                bArr2[i] = (byte) dq.charAt(i);
            }
            this.adZ = u.bb(dq);
            this.aea = u.b(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.adZ = null;
            this.aea = new byte[0];
        }
    }

    private d() {
    }

    public byte[] kP() {
        return this.aea;
    }

    public SecretKey getSecretKey() {
        return this.adZ;
    }
}
