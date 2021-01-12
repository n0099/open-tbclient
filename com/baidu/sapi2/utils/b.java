package com.baidu.sapi2.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5097a = "login_";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5098b = "login_pop";
    public static final String c = "modifyPWD_widge";
    public static final String d = "normal_incomplete";
    public static final String e = "normal_guest";
    public static final String f = "fillname_widge";
    public static final String g = "web2native";
    public static final String h = "native2web";
    public static final String i = "sapi_action_bduss_changed";

    public void a(String str) {
        if (TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            HashMap hashMap = new HashMap();
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put("sys_version", Build.VERSION.RELEASE);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            hashMap.put("uid", currentAccount == null ? "uid_is_empty" : currentAccount.uid);
            hashMap.put("scenes", str);
            k.a("ptoken_is_null", hashMap);
        }
    }
}
