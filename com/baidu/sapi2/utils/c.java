package com.baidu.sapi2.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11026a = "login_";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11027b = "login_pop";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11028c = "modifyPWD_widge";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11029d = "normal_incomplete";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11030e = "normal_guest";

    /* renamed from: f  reason: collision with root package name */
    public static final String f11031f = "fillname_widge";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11032g = "web2native";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11033h = "native2web";
    public static final String i = "sapi_action_bduss_changed";

    public void a(String str) {
        if (TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", Build.MODEL);
            hashMap.put("sys_version", Build.VERSION.RELEASE);
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            hashMap.put("uid", currentAccount == null ? "uid_is_empty" : currentAccount.uid);
            hashMap.put("scenes", str);
            StatService.onEvent("ptoken_is_null", hashMap);
        }
    }
}
