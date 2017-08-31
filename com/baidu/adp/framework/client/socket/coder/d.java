package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d pD = null;
    private SecretKey pE = null;
    private byte[] pF = null;

    public static d dk() {
        if (pD == null) {
            synchronized (d.class) {
                if (pD == null) {
                    pD = new d();
                }
            }
        }
        return pD;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = t.m(bArr);
            String au = t.au(32);
            byte[] bArr2 = new byte[au.length()];
            for (int i = 0; i < au.length(); i++) {
                bArr2[i] = (byte) au.charAt(i);
            }
            this.pE = t.aT(au);
            this.pF = t.b(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.pE = null;
            this.pF = new byte[0];
        }
    }

    private d() {
    }

    public byte[] dl() {
        return this.pF;
    }

    public SecretKey getSecretKey() {
        return this.pE;
    }
}
