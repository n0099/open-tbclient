package com.baidu.adp.framework.client.socket.coder;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d vw = null;
    private SecretKey vx = null;
    private byte[] vy = null;

    public static d ge() {
        if (vw == null) {
            synchronized (d.class) {
                if (vw == null) {
                    vw = new d();
                }
            }
        }
        return vw;
    }

    public void h(byte[] bArr) {
        try {
            PublicKey o = u.o(bArr);
            String at = u.at(32);
            byte[] bArr2 = new byte[at.length()];
            for (int i = 0; i < at.length(); i++) {
                bArr2[i] = (byte) at.charAt(i);
            }
            this.vx = u.bo(at);
            this.vy = u.b(o, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.vx = null;
            this.vy = new byte[0];
        }
    }

    private d() {
    }

    public byte[] gf() {
        return this.vy;
    }

    public SecretKey gg() {
        return this.vx;
    }
}
