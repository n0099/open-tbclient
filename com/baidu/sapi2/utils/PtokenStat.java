package com.baidu.sapi2.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PtokenStat {
    public static final String FILLNAME_WIDGE = "fillname_widge";
    public static final String LOGIN = "login_";
    public static final String LOGIN_POP = "login_pop";
    public static final String MODIFY_PWD_WIDGE = "modifyPWD_widge";
    public static final String NATIVE_2_WEB = "native2web";
    public static final String NORMAL_GUEST = "normal_guest";
    public static final String NORMAL_INCOMPLETE = "normal_incomplete";
    public static final String SAPI_ACTION_BDUSS_CHANGED = "sapi_action_bduss_changed";
    public static final String WEB_2_NATIVE = "web2native";

    public void onEvent(String str) {
        String str2;
        if (!TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Config.DEVICE_PART, "android");
        hashMap.put("sys_version", Build.VERSION.RELEASE);
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            str2 = "uid_is_empty";
        } else {
            str2 = currentAccount.uid;
        }
        hashMap.put("uid", str2);
        hashMap.put("scenes", str);
        StatService.onEvent("ptoken_is_null", hashMap);
    }
}
