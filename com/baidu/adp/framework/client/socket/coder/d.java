package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d fP = null;
    private SecretKey fQ = null;
    private byte[] fR = null;

    public static d bh() {
        if (fP == null) {
            synchronized (d.class) {
                if (fP == null) {
                    fP = new d();
                }
            }
        }
        return fP;
    }

    public void f(byte[] bArr) {
        try {
            PublicKey m = v.m(bArr);
            String ae = v.ae(32);
            byte[] bArr2 = new byte[ae.length()];
            for (int i = 0; i < ae.length(); i++) {
                bArr2[i] = (byte) ae.charAt(i);
            }
            this.fQ = v.aT(ae);
            this.fR = v.a(m, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.fQ = null;
            this.fR = new byte[0];
        }
    }

    private d() {
    }

    public byte[] bi() {
        return this.fR;
    }

    public SecretKey getSecretKey() {
        return this.fQ;
    }
}
