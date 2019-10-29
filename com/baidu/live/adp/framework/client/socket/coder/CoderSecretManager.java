package com.baidu.live.adp.framework.client.socket.coder;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.SecureHelper;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes6.dex */
public class CoderSecretManager {
    private static CoderSecretManager sInstance = null;
    private SecretKey mSecretKey = null;
    private byte[] mSecretKeyBytes = null;

    public static CoderSecretManager getInstance() {
        if (sInstance == null) {
            synchronized (CoderSecretManager.class) {
                if (sInstance == null) {
                    sInstance = new CoderSecretManager();
                }
            }
        }
        return sInstance;
    }

    public void initial(byte[] bArr) {
        try {
            PublicKey loadRSAPublicKey = SecureHelper.loadRSAPublicKey(bArr);
            String newRandomString = SecureHelper.newRandomString(32);
            byte[] bArr2 = new byte[newRandomString.length()];
            for (int i = 0; i < newRandomString.length(); i++) {
                bArr2[i] = (byte) newRandomString.charAt(i);
            }
            this.mSecretKey = SecureHelper.newAESKey(newRandomString);
            this.mSecretKeyBytes = SecureHelper.encryptWithRSA(loadRSAPublicKey, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.mSecretKey = null;
            this.mSecretKeyBytes = new byte[0];
        }
    }

    private CoderSecretManager() {
    }

    public byte[] getSecretKeyBytes() {
        return this.mSecretKeyBytes;
    }

    public SecretKey getSecretKey() {
        return this.mSecretKey;
    }
}
