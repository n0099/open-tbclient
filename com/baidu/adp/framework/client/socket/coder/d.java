package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d rM = null;
    private SecretKey rN = null;
    private byte[] rO = null;

    public static d du() {
        if (rM == null) {
            synchronized (d.class) {
                if (rM == null) {
                    rM = new d();
                }
            }
        }
        return rM;
    }

    public void m(byte[] bArr) {
        try {
            PublicKey s = t.s(bArr);
            String ax = t.ax(32);
            byte[] bArr2 = new byte[ax.length()];
            for (int i = 0; i < ax.length(); i++) {
                bArr2[i] = (byte) ax.charAt(i);
            }
            this.rN = t.aW(ax);
            this.rO = t.a(s, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.rN = null;
            this.rO = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dv() {
        return this.rO;
    }

    public SecretKey getSecretKey() {
        return this.rN;
    }
}
