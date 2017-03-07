package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d qC = null;
    private SecretKey qD = null;
    private byte[] qE = null;

    public static d dk() {
        if (qC == null) {
            synchronized (d.class) {
                if (qC == null) {
                    qC = new d();
                }
            }
        }
        return qC;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String av = v.av(32);
            byte[] bArr2 = new byte[av.length()];
            for (int i = 0; i < av.length(); i++) {
                bArr2[i] = (byte) av.charAt(i);
            }
            this.qD = v.aO(av);
            this.qE = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.qD = null;
            this.qE = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dl() {
        return this.qE;
    }

    public SecretKey getSecretKey() {
        return this.qD;
    }
}
