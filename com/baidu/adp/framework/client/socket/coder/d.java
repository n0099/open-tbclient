package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d fQ = null;
    private SecretKey fR = null;
    private byte[] fS = null;

    public static d bg() {
        if (fQ == null) {
            synchronized (d.class) {
                if (fQ == null) {
                    fQ = new d();
                }
            }
        }
        return fQ;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = v.m(bArr);
            String ae = v.ae(32);
            byte[] bArr2 = new byte[ae.length()];
            for (int i = 0; i < ae.length(); i++) {
                bArr2[i] = (byte) ae.charAt(i);
            }
            this.fR = v.aT(ae);
            this.fS = v.a(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.fR = null;
            this.fS = new byte[0];
        }
    }

    private d() {
    }

    public byte[] bh() {
        return this.fS;
    }

    public SecretKey getSecretKey() {
        return this.fR;
    }
}
