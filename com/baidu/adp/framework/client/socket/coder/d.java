package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d rN = null;
    private SecretKey rO = null;
    private byte[] rP = null;

    public static d du() {
        if (rN == null) {
            synchronized (d.class) {
                if (rN == null) {
                    rN = new d();
                }
            }
        }
        return rN;
    }

    public void m(byte[] bArr) {
        try {
            PublicKey s = t.s(bArr);
            String ax = t.ax(32);
            byte[] bArr2 = new byte[ax.length()];
            for (int i = 0; i < ax.length(); i++) {
                bArr2[i] = (byte) ax.charAt(i);
            }
            this.rO = t.aX(ax);
            this.rP = t.b(s, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.rO = null;
            this.rP = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dv() {
        return this.rP;
    }

    public SecretKey getSecretKey() {
        return this.rO;
    }
}
