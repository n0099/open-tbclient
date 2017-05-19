package com.baidu.android.pushservice.config;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    protected static final String TAG = "BaseConfig";
    protected String defaultConfigPath = "/com/baidu/android/pushservice/assets/defaultconfig.json";
    protected String localConfigPath;
    protected String mConfigContent;
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        this.mContext = context;
    }

    public boolean loadConfig() {
        String a;
        if (new File(this.localConfigPath).exists()) {
            a = a.a(this.mContext, this.localConfigPath);
            com.baidu.android.pushservice.e.a.c(TAG, "load config from " + this.localConfigPath);
        } else {
            a = a.a(this.mContext, this.defaultConfigPath);
            com.baidu.android.pushservice.e.a.c(TAG, "load config from " + this.defaultConfigPath);
        }
        if (!TextUtils.isEmpty(a)) {
            try {
                byte[] a2 = com.baidu.android.pushservice.i.b.a(a.getBytes());
                if (a2 != null && a2.length > 0) {
                    this.mConfigContent = new String(BaiduAppSSOJni.decryptAES(a2, a2.length, 0));
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a(TAG, e);
            } catch (UnsatisfiedLinkError e2) {
                com.baidu.android.pushservice.e.a.a(TAG, e2);
            }
        }
        com.baidu.android.pushservice.e.a.c(TAG, "the config content = " + this.mConfigContent);
        return !TextUtils.isEmpty(this.mConfigContent);
    }

    public boolean writeConfig(String str) {
        return a.a(this.localConfigPath, str);
    }
}
