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

    public static d hg() {
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
            String aA = u.aA(32);
            byte[] bArr2 = new byte[aA.length()];
            for (int i = 0; i < aA.length(); i++) {
                bArr2[i] = (byte) aA.charAt(i);
            }
            this.xN = u.bD(aA);
            this.xO = u.b(v, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.xN = null;
            this.xO = new byte[0];
        }
    }

    private d() {
    }

    public byte[] hh() {
        return this.xO;
    }

    public SecretKey getSecretKey() {
        return this.xN;
    }
}
