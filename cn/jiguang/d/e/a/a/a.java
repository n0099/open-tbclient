package cn.jiguang.d.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.h;
import cn.jiguang.d.e.a.d;
import cn.jiguang.d.e.a.e;
import cn.jiguang.d.e.a.f;
import cn.jiguang.d.e.a.g;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class a {
    public static h a(c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            return null;
        }
        switch (cVar.c) {
            case 0:
                return new f(cVar, byteBuffer);
            case 1:
                return new e(cVar, byteBuffer);
            case 19:
                return new cn.jiguang.d.e.a.a(cVar, byteBuffer);
            case 25:
                return new cn.jiguang.d.e.a.c(cVar, byteBuffer);
            case 26:
                return new g(cVar, byteBuffer);
            case 30:
            case 32:
                return new cn.jiguang.d.e.a.b(cVar, byteBuffer);
            default:
                return null;
        }
    }

    public static boolean b(Context context, byte[] bArr) {
        try {
            d i = i(bArr);
            if (i != null) {
                long c = cn.jiguang.d.a.d.c(context);
                long j = i.bM().f;
                if (c == 0 || j == 0 || c == j) {
                    cn.jiguang.d.d.e.bD();
                    cn.jiguang.d.d.e.a(context, i.bM(), i.bN());
                } else {
                    cn.jiguang.d.f.a.bO().a(context, j, bArr);
                }
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCommands", "dispatchMessage error:" + th.getMessage());
        }
        return false;
    }

    public static d d(byte[] bArr, String str) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        c cVar = new c(false, bArr2);
        int i = cVar.a - 20;
        if (i < 0 || bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 20, bArr3, 0, i);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i);
            wrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                wrap = ByteBuffer.wrap(cn.jiguang.d.h.a.a.b(str, bArr3));
            } catch (Exception e) {
                return null;
            }
        }
        return new d(cVar, wrap);
    }

    public static h h(byte[] bArr) {
        d i = i(bArr);
        if (i != null) {
            return a(i.bM(), i.bN());
        }
        return null;
    }

    public static d i(byte[] bArr) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        int i = bArr2[0] & 128;
        c cVar = new c(false, bArr2);
        int i2 = cVar.a - 20;
        if (i2 < 0 || bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 20, bArr3, 0, i2);
        if (i > 0) {
            try {
                wrap = ByteBuffer.wrap(cn.jiguang.d.h.a.a.b(cn.jiguang.d.h.a.a.b(), bArr3));
            } catch (Exception e) {
                return null;
            }
        } else {
            System.arraycopy(bArr, 20, bArr3, 0, i2);
            wrap = ByteBuffer.wrap(bArr3);
        }
        return new d(cVar, wrap);
    }
}
