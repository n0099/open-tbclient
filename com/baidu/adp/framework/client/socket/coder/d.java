package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d aeg = null;
    private SecretKey aeh = null;
    private byte[] aei = null;

    public static d kO() {
        if (aeg == null) {
            synchronized (d.class) {
                if (aeg == null) {
                    aeg = new d();
                }
            }
        }
        return aeg;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = u.m(bArr);
            String dq = u.dq(32);
            byte[] bArr2 = new byte[dq.length()];
            for (int i = 0; i < dq.length(); i++) {
                bArr2[i] = (byte) dq.charAt(i);
            }
            this.aeh = u.bb(dq);
            this.aei = u.b(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.aeh = null;
            this.aei = new byte[0];
        }
    }

    private d() {
    }

    public byte[] kP() {
        return this.aei;
    }

    public SecretKey getSecretKey() {
        return this.aeh;
    }
}
