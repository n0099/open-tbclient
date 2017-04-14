package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d qb = null;
    private SecretKey qc = null;
    private byte[] qd = null;

    public static d dj() {
        if (qb == null) {
            synchronized (d.class) {
                if (qb == null) {
                    qb = new d();
                }
            }
        }
        return qb;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String au = v.au(32);
            byte[] bArr2 = new byte[au.length()];
            for (int i = 0; i < au.length(); i++) {
                bArr2[i] = (byte) au.charAt(i);
            }
            this.qc = v.aJ(au);
            this.qd = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.qc = null;
            this.qd = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dk() {
        return this.qd;
    }

    public SecretKey getSecretKey() {
        return this.qc;
    }
}
