package cn.com.chinatelecom.gateway.lib.a;

import cn.com.chinatelecom.gateway.lib.CtAuth;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1494a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static String f1495b = "RSA/ECB/PKCS1Padding";

    public static String a(String str, RSAPublicKey rSAPublicKey) {
        byte[] a2 = a(rSAPublicKey, str.getBytes());
        return a2 != null ? e.a(a2) : "";
    }

    public static PublicKey a(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a(str)));
    }

    public static RSAPublicKey a() {
        try {
            return (RSAPublicKey) a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
        } catch (Throwable th) {
            CtAuth.warn(f1494a, "getPublicKey error", th);
            return null;
        }
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(f1495b);
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            CtAuth.warn(f1494a, "Rsa encrypt4Ux error", th);
            return null;
        }
    }
}
