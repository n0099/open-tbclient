package cn.jiguang.d.h.a;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes3.dex */
public final class b {
    public static RSAPublicKey P(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            return null;
        }
    }
}
