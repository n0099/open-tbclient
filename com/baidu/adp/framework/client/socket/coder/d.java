package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d vu = null;
    private SecretKey vv = null;
    private byte[] vw = null;

    public static d fV() {
        if (vu == null) {
            synchronized (d.class) {
                if (vu == null) {
                    vu = new d();
                }
            }
        }
        return vu;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey n = u.n(bArr);
            String at = u.at(32);
            byte[] bArr2 = new byte[at.length()];
            for (int i = 0; i < at.length(); i++) {
                bArr2[i] = (byte) at.charAt(i);
            }
            this.vv = u.bn(at);
            this.vw = u.b(n, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.vv = null;
            this.vw = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fW() {
        return this.vw;
    }

    public SecretKey getSecretKey() {
        return this.vv;
    }
}
