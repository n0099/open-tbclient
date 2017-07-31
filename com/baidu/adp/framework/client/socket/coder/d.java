package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d rK = null;
    private SecretKey rL = null;
    private byte[] rM = null;

    public static d du() {
        if (rK == null) {
            synchronized (d.class) {
                if (rK == null) {
                    rK = new d();
                }
            }
        }
        return rK;
    }

    public void m(byte[] bArr) {
        try {
            PublicKey s = t.s(bArr);
            String ax = t.ax(32);
            byte[] bArr2 = new byte[ax.length()];
            for (int i = 0; i < ax.length(); i++) {
                bArr2[i] = (byte) ax.charAt(i);
            }
            this.rL = t.aW(ax);
            this.rM = t.a(s, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.rL = null;
            this.rM = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dv() {
        return this.rM;
    }

    public SecretKey getSecretKey() {
        return this.rL;
    }
}
