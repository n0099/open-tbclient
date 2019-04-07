package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d xL = null;
    private SecretKey xM = null;
    private byte[] xN = null;

    public static d hc() {
        if (xL == null) {
            synchronized (d.class) {
                if (xL == null) {
                    xL = new d();
                }
            }
        }
        return xL;
    }

    public void p(byte[] bArr) {
        try {
            PublicKey v = u.v(bArr);
            String aA = u.aA(32);
            byte[] bArr2 = new byte[aA.length()];
            for (int i = 0; i < aA.length(); i++) {
                bArr2[i] = (byte) aA.charAt(i);
            }
            this.xM = u.bD(aA);
            this.xN = u.b(v, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.xM = null;
            this.xN = new byte[0];
        }
    }

    private d() {
    }

    public byte[] hd() {
        return this.xN;
    }

    public SecretKey getSecretKey() {
        return this.xM;
    }
}
