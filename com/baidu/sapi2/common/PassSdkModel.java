package com.baidu.sapi2.common;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class PassSdkModel {
    public static String TAG = "sapi_pass_sdk_model";
    public static PassSdkModel instance;

    public static PassSdkModel getInstance() {
        if (instance == null) {
            synchronized (PassSdkModel.class) {
                if (instance == null) {
                    instance = new PassSdkModel();
                }
            }
        }
        return instance;
    }

    public boolean checkPassSdkInit() {
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager.getConfignation() == null) {
            SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
        }
        return sapiAccountManager.getConfignation() != null;
    }

    public boolean checkPkgSign(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (!TextUtils.isEmpty(packageSign)) {
                Iterator<String> it = authorizedPackages.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (str.matches(next)) {
                        if (packageSign.equals(authorizedPackages.get(next))) {
                            String str2 = TAG;
                            Log.d(str2, "checkPkgSign pkgName=" + str + " is true, sign is true");
                            return true;
                        }
                        String str3 = TAG;
                        Log.d(str3, "checkPkgSign pkgName=" + str + " is true, sign is error, sign=" + packageSign);
                    }
                }
            }
            String str4 = TAG;
            Log.d(str4, "checkPkgSign is fail pkgName=" + str + " sign=" + packageSign);
        }
        return false;
    }
}
