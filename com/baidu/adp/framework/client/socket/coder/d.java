package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d Jo = null;
    private SecretKey mSecretKey = null;
    private byte[] mSecretKeyBytes = null;

    public static d kU() {
        if (Jo == null) {
            synchronized (d.class) {
                if (Jo == null) {
                    Jo = new d();
                }
            }
        }
        return Jo;
    }

    public void initial(byte[] bArr) {
        try {
            PublicKey loadRSAPublicKey = u.loadRSAPublicKey(bArr);
            String newRandomString = u.newRandomString(32);
            byte[] bArr2 = new byte[newRandomString.length()];
            for (int i = 0; i < newRandomString.length(); i++) {
                bArr2[i] = (byte) newRandomString.charAt(i);
            }
            this.mSecretKey = u.newAESKey(newRandomString);
            this.mSecretKeyBytes = u.encryptWithRSA(loadRSAPublicKey, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.mSecretKey = null;
            this.mSecretKeyBytes = new byte[0];
        }
    }

    private d() {
    }

    public byte[] getSecretKeyBytes() {
        return this.mSecretKeyBytes;
    }

    public SecretKey getSecretKey() {
        return this.mSecretKey;
    }
}
