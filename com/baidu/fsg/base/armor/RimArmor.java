package com.baidu.fsg.base.armor;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class RimArmor {
    public static final String KEY = "key";
    public static RimArmor ins;

    static {
        try {
            System.loadLibrary("bd_fsg_rim_v1_3");
        } catch (Throwable unused) {
        }
    }

    public static synchronized RimArmor getInstance() {
        RimArmor rimArmor;
        synchronized (RimArmor.class) {
            if (ins == null) {
                RimArmor rimArmor2 = new RimArmor();
                ins = rimArmor2;
                rimArmor2.init(ResUtils.getApplicationContext());
            }
            rimArmor = ins;
        }
        return rimArmor;
    }

    private native void init(Context context);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        try {
            return decrypt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public native String encrypt(String str);

    public String encryptProxy(String str) {
        try {
            return encrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String getFpk(Context context);

    public native String getToken();

    public native String getak();

    public native String getpw();

    public String getpwProxy() {
        try {
            return getpw();
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String localDecrypt(String str);

    public String localDecryptProxy(String str) {
        try {
            return localDecrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String localEncrypt(String str);

    public String localEncryptProxy(String str) {
        try {
            return localEncrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
