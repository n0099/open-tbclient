package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d qc = null;
    private SecretKey qd = null;
    private byte[] qe = null;

    public static d eQ() {
        if (qc == null) {
            synchronized (d.class) {
                if (qc == null) {
                    qc = new d();
                }
            }
        }
        return qc;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey n = v.n(bArr);
            String aq = v.aq(32);
            byte[] bArr2 = new byte[aq.length()];
            for (int i = 0; i < aq.length(); i++) {
                bArr2[i] = (byte) aq.charAt(i);
            }
            this.qd = v.ba(aq);
            this.qe = v.a(n, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.qd = null;
            this.qe = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eR() {
        return this.qe;
    }

    public SecretKey getSecretKey() {
        return this.qd;
    }
}
