package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d xM = null;
    private SecretKey xN = null;
    private byte[] xO = null;

    public static d hc() {
        if (xM == null) {
            synchronized (d.class) {
                if (xM == null) {
                    xM = new d();
                }
            }
        }
        return xM;
    }

    public void p(byte[] bArr) {
        try {
            PublicKey v = u.v(bArr);
            String aB = u.aB(32);
            byte[] bArr2 = new byte[aB.length()];
            for (int i = 0; i < aB.length(); i++) {
                bArr2[i] = (byte) aB.charAt(i);
            }
            this.xN = u.bD(aB);
            this.xO = u.b(v, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.xN = null;
            this.xO = new byte[0];
        }
    }

    private d() {
    }

    public byte[] hd() {
        return this.xO;
    }

    public SecretKey getSecretKey() {
        return this.xN;
    }
}
