package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pU = null;
    private SecretKey pV = null;
    private byte[] pW = null;

    public static d eM() {
        if (pU == null) {
            synchronized (d.class) {
                if (pU == null) {
                    pU = new d();
                }
            }
        }
        return pU;
    }

    public void v(byte[] bArr) {
        try {
            PublicKey D = v.D(bArr);
            String af = v.af(32);
            byte[] bArr2 = new byte[af.length()];
            for (int i = 0; i < af.length(); i++) {
                bArr2[i] = (byte) af.charAt(i);
            }
            this.pV = v.aV(af);
            this.pW = v.a(D, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pV = null;
            this.pW = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eN() {
        return this.pW;
    }

    public SecretKey getSecretKey() {
        return this.pV;
    }
}
