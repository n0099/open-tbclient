package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d qg = null;
    private SecretKey qh = null;
    private byte[] qi = null;

    public static d dk() {
        if (qg == null) {
            synchronized (d.class) {
                if (qg == null) {
                    qg = new d();
                }
            }
        }
        return qg;
    }

    public void j(byte[] bArr) {
        try {
            PublicKey p = v.p(bArr);
            String au = v.au(32);
            byte[] bArr2 = new byte[au.length()];
            for (int i = 0; i < au.length(); i++) {
                bArr2[i] = (byte) au.charAt(i);
            }
            this.qh = v.aJ(au);
            this.qi = v.a(p, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.qh = null;
            this.qi = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dl() {
        return this.qi;
    }

    public SecretKey getSecretKey() {
        return this.qh;
    }
}
