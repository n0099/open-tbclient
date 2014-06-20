package com.baidu.adp.framework.client.socket.coder;

import android.util.SparseBooleanArray;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.r;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {
    private static d a = null;
    private SecretKey b = null;
    private byte[] c = null;
    private SparseBooleanArray d = null;

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(int i) {
        this.d.put(i, true);
    }

    public void a(byte[] bArr) {
        try {
            this.d = new SparseBooleanArray();
            PublicKey a2 = r.a(bArr);
            String a3 = r.a(32);
            byte[] bArr2 = new byte[a3.length()];
            for (int i = 0; i < a3.length(); i++) {
                bArr2[i] = (byte) a3.charAt(i);
            }
            this.b = r.a(a3);
            this.c = r.a(a2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.b = null;
            this.c = new byte[0];
        }
    }

    private d() {
    }

    public byte[] b() {
        return this.c;
    }

    public SecretKey c() {
        return this.b;
    }

    public boolean b(int i) {
        return (this.b == null || this.d.get(i, false)) ? false : true;
    }
}
