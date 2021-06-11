package com.baidu.location.b;

import android.util.Base64;
import com.baidu.location.Jni;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public IvParameterSpec f6563a;

    /* renamed from: b  reason: collision with root package name */
    public SecretKeySpec f6564b;

    /* renamed from: c  reason: collision with root package name */
    public Cipher f6565c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6566d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static j f6567a = new j();
    }

    public j() {
        this.f6566d = false;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains("|")) {
                return;
            }
            String[] split = str.split("\\|");
            this.f6563a = new IvParameterSpec(split[1].getBytes("UTF-8"));
            this.f6564b = new SecretKeySpec(split[0].getBytes("UTF-8"), "AES");
            this.f6565c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            this.f6566d = true;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
        }
    }

    public static j a() {
        return a.f6567a;
    }

    public String a(String str) {
        if (this.f6566d) {
            try {
                this.f6565c.init(2, this.f6564b, this.f6563a);
                return new String(this.f6565c.doFinal(Base64.decode(str, 0)), "UTF-8");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public boolean b() {
        return this.f6566d;
    }
}
