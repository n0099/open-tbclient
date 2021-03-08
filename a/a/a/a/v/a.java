package a.a.a.a.v;

import android.util.Base64;
import com.baidu.live.adp.lib.util.SecureHelper;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class a {
    public static b BN = new C0005a();

    /* renamed from: a.a.a.a.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0005a implements b {
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public static String a(String str, String str2) {
        b bVar = BN;
        Charset forName = Charset.forName("UTF-8");
        C0005a c0005a = (C0005a) bVar;
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2.getBytes(forName), 0), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(SecureHelper.CIPHER_TRIPLE_AES);
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str.getBytes(forName), 0)), forName);
    }
}
