package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d ex = null;
    private SecretKey ey = null;
    private byte[] ez = null;

    public static d bl() {
        if (ex == null) {
            synchronized (d.class) {
                if (ex == null) {
                    ex = new d();
                }
            }
        }
        return ex;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey o = ab.o(bArr);
            String ab = ab.ab(32);
            byte[] bArr2 = new byte[ab.length()];
            for (int i = 0; i < ab.length(); i++) {
                bArr2[i] = (byte) ab.charAt(i);
            }
            this.ey = ab.aH(ab);
            this.ez = ab.a(o, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.ey = null;
            this.ez = new byte[0];
        }
    }

    private d() {
    }

    public byte[] bm() {
        return this.ez;
    }

    public SecretKey getSecretKey() {
        return this.ey;
    }
}
