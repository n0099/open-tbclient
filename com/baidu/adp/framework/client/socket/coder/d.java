package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d ev = null;
    private SecretKey ew = null;
    private byte[] ex = null;

    public static d bl() {
        if (ev == null) {
            synchronized (d.class) {
                if (ev == null) {
                    ev = new d();
                }
            }
        }
        return ev;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey o = ab.o(bArr);
            String W = ab.W(32);
            byte[] bArr2 = new byte[W.length()];
            for (int i = 0; i < W.length(); i++) {
                bArr2[i] = (byte) W.charAt(i);
            }
            this.ew = ab.aH(W);
            this.ex = ab.a(o, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.ew = null;
            this.ex = new byte[0];
        }
    }

    private d() {
    }

    public byte[] bm() {
        return this.ex;
    }

    public SecretKey getSecretKey() {
        return this.ew;
    }
}
