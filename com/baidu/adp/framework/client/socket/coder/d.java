package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d ou = null;
    private SecretKey ov = null;
    private byte[] ow = null;

    public static d cS() {
        if (ou == null) {
            synchronized (d.class) {
                if (ou == null) {
                    ou = new d();
                }
            }
        }
        return ou;
    }

    public void i(byte[] bArr) {
        try {
            PublicKey o = u.o(bArr);
            String aq = u.aq(32);
            byte[] bArr2 = new byte[aq.length()];
            for (int i = 0; i < aq.length(); i++) {
                bArr2[i] = (byte) aq.charAt(i);
            }
            this.ov = u.aY(aq);
            this.ow = u.b(o, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.ov = null;
            this.ow = new byte[0];
        }
    }

    private d() {
    }

    public byte[] cT() {
        return this.ow;
    }

    public SecretKey getSecretKey() {
        return this.ov;
    }
}
