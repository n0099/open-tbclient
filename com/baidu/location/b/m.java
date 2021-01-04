package com.baidu.location.b;

import android.util.Base64;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.location.Jni;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes15.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private IvParameterSpec f2635a;

    /* renamed from: b  reason: collision with root package name */
    private SecretKeySpec f2636b;
    private boolean c;

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static m f2637a = new m();
    }

    private m() {
        this.c = false;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains("|")) {
                return;
            }
            String[] split = str.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            this.f2635a = new IvParameterSpec(split[1].getBytes("UTF-8"));
            this.f2636b = new SecretKeySpec(split[0].getBytes("UTF-8"), com.baidu.sapi2.utils.e.q);
            this.c = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static m a() {
        return a.f2637a;
    }

    public String a(String str) {
        if (this.c) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, this.f2636b, this.f2635a);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized String b(String str) {
        String str2 = null;
        synchronized (this) {
            if (this.c) {
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    cipher.init(2, this.f2636b, this.f2635a);
                    str2 = new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str2;
    }

    public boolean b() {
        return this.c;
    }
}
