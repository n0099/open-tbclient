package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pE = null;
    private SecretKey pF = null;
    private byte[] pG = null;

    public static d dk() {
        if (pE == null) {
            synchronized (d.class) {
                if (pE == null) {
                    pE = new d();
                }
            }
        }
        return pE;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = u.m(bArr);
            String aw = u.aw(32);
            byte[] bArr2 = new byte[aw.length()];
            for (int i = 0; i < aw.length(); i++) {
                bArr2[i] = (byte) aw.charAt(i);
            }
            this.pF = u.aT(aw);
            this.pG = u.b(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pF = null;
            this.pG = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dl() {
        return this.pG;
    }

    public SecretKey getSecretKey() {
        return this.pF;
    }
}
