package a.a.a.a.v;

import android.util.Base64;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f1344a = new C0004a();

    /* renamed from: a.a.a.a.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements b {
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public static String a(String str, String str2) {
        b bVar = f1344a;
        Charset forName = Charset.forName("UTF-8");
        C0004a c0004a = (C0004a) bVar;
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2.getBytes(forName), 0), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str.getBytes(forName), 0)), forName);
    }
}
