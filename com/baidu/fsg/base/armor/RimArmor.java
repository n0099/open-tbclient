package com.baidu.fsg.base.armor;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class RimArmor {
    public static final String KEY = "key";
    private static RimArmor ins;

    private native void init(Context context);

    public native String decrypt(String str);

    public native String encrypt(String str);

    public native String getToken();

    public native String getak();

    public native String getpw();

    public native String localDecrypt(String str);

    public native String localEncrypt(String str);

    static {
        System.loadLibrary("bd_fsg_rim_v1_1");
    }

    private RimArmor() {
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (ins == null) {
                ins = new RimArmor();
                ins.init(ResUtils.getApplicationContext());
            }
            rimArmor = ins;
        }
        return rimArmor;
    }

    public String getpwProxy() {
        try {
            return getpw();
        } catch (Throwable th) {
            return "";
        }
    }

    public String encryptProxy(String str) {
        try {
            return encrypt(str);
        } catch (Throwable th) {
            return "";
        }
    }

    public String decryptProxy(String str) {
        try {
            return decrypt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String localEncryptProxy(String str) {
        try {
            return localEncrypt(str);
        } catch (Throwable th) {
            return "";
        }
    }

    public String localDecryptProxy(String str) {
        try {
            return localDecrypt(str);
        } catch (Throwable th) {
            return "";
        }
    }
}
