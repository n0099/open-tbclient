package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pV = null;
    private SecretKey pW = null;
    private byte[] pX = null;

    public static d eL() {
        if (pV == null) {
            synchronized (d.class) {
                if (pV == null) {
                    pV = new d();
                }
            }
        }
        return pV;
    }

    public void v(byte[] bArr) {
        try {
            PublicKey D = v.D(bArr);
            String ag = v.ag(32);
            byte[] bArr2 = new byte[ag.length()];
            for (int i = 0; i < ag.length(); i++) {
                bArr2[i] = (byte) ag.charAt(i);
            }
            this.pW = v.aY(ag);
            this.pX = v.a(D, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pW = null;
            this.pX = new byte[0];
        }
    }

    private d() {
    }

    public byte[] eM() {
        return this.pX;
    }

    public SecretKey getSecretKey() {
        return this.pW;
    }
}
