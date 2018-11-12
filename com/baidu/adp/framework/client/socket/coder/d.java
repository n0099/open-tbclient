package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d xP = null;
    private SecretKey xQ = null;
    private byte[] xR = null;

    public static d hf() {
        if (xP == null) {
            synchronized (d.class) {
                if (xP == null) {
                    xP = new d();
                }
            }
        }
        return xP;
    }

    public void o(byte[] bArr) {
        try {
            PublicKey u = u.u(bArr);
            String aR = u.aR(32);
            byte[] bArr2 = new byte[aR.length()];
            for (int i = 0; i < aR.length(); i++) {
                bArr2[i] = (byte) aR.charAt(i);
            }
            this.xQ = u.bD(aR);
            this.xR = u.b(u, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.xQ = null;
            this.xR = new byte[0];
        }
    }

    private d() {
    }

    public byte[] hg() {
        return this.xR;
    }

    public SecretKey getSecretKey() {
        return this.xQ;
    }
}
