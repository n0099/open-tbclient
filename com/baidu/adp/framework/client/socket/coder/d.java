package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d qh = null;
    private SecretKey qi = null;
    private byte[] qj = null;

    public static d dj() {
        if (qh == null) {
            synchronized (d.class) {
                if (qh == null) {
                    qh = new d();
                }
            }
        }
        return qh;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = t.p(bArr);
            String au = t.au(32);
            byte[] bArr2 = new byte[au.length()];
            for (int i = 0; i < au.length(); i++) {
                bArr2[i] = (byte) au.charAt(i);
            }
            this.qi = t.aQ(au);
            this.qj = t.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.qi = null;
            this.qj = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dk() {
        return this.qj;
    }

    public SecretKey getSecretKey() {
        return this.qi;
    }
}
