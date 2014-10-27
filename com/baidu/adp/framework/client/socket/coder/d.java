package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.w;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d co = null;
    private SecretKey cp = null;
    private byte[] cq = null;

    public static d aL() {
        if (co == null) {
            synchronized (d.class) {
                if (co == null) {
                    co = new d();
                }
            }
        }
        return co;
    }

    public void g(byte[] bArr) {
        try {
            PublicKey p = w.p(bArr);
            String O = w.O(32);
            byte[] bArr2 = new byte[O.length()];
            for (int i = 0; i < O.length(); i++) {
                bArr2[i] = (byte) O.charAt(i);
            }
            this.cp = w.aF(O);
            this.cq = w.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.cp = null;
            this.cq = new byte[0];
        }
    }

    private d() {
    }

    public byte[] aM() {
        return this.cq;
    }

    public SecretKey getSecretKey() {
        return this.cp;
    }
}
