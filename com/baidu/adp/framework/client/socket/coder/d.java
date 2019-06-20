package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d vt = null;
    private SecretKey vu = null;
    private byte[] vv = null;

    public static d fV() {
        if (vt == null) {
            synchronized (d.class) {
                if (vt == null) {
                    vt = new d();
                }
            }
        }
        return vt;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey n = u.n(bArr);
            String at = u.at(32);
            byte[] bArr2 = new byte[at.length()];
            for (int i = 0; i < at.length(); i++) {
                bArr2[i] = (byte) at.charAt(i);
            }
            this.vu = u.bn(at);
            this.vv = u.b(n, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.vu = null;
            this.vv = new byte[0];
        }
    }

    private d() {
    }

    public byte[] fW() {
        return this.vv;
    }

    public SecretKey getSecretKey() {
        return this.vu;
    }
}
