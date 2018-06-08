package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d uQ = null;
    private SecretKey uR = null;
    private byte[] uS = null;

    public static d fH() {
        if (uQ == null) {
            synchronized (d.class) {
                if (uQ == null) {
                    uQ = new d();
                }
            }
        }
        return uQ;
    }

    public void i(byte[] bArr) {
        try {
            PublicKey o = u.o(bArr);
            String ar = u.ar(32);
            byte[] bArr2 = new byte[ar.length()];
            for (int i = 0; i < ar.length(); i++) {
                bArr2[i] = (byte) ar.charAt(i);
            }
            this.uR = u.bk(ar);
            this.uS = u.b(o, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.uR = null;
            this.uS = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fI() {
        return this.uS;
    }

    public SecretKey getSecretKey() {
        return this.uR;
    }
}
