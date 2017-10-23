package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pF = null;
    private SecretKey pG = null;
    private byte[] pH = null;

    public static d dk() {
        if (pF == null) {
            synchronized (d.class) {
                if (pF == null) {
                    pF = new d();
                }
            }
        }
        return pF;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = u.m(bArr);
            String ax = u.ax(32);
            byte[] bArr2 = new byte[ax.length()];
            for (int i = 0; i < ax.length(); i++) {
                bArr2[i] = (byte) ax.charAt(i);
            }
            this.pG = u.aT(ax);
            this.pH = u.b(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pG = null;
            this.pH = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dl() {
        return this.pH;
    }

    public SecretKey getSecretKey() {
        return this.pG;
    }
}
