package com.baidu.searchbox.wordscommand.bussiness;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.wordscommand.util.InvokeParamsSpUtil;
/* loaded from: classes4.dex */
public class InvokeParamsManager {
    public static String getInvokeSchemeFromSp() {
        String string = InvokeParamsSpUtil.getInstance().getString(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME, "");
        if (AppConfig.isDebug()) {
            Log.d("InvokeParamsManager", "GetInvokeScheme: " + string);
        }
        return string;
    }

    public static void release() {
        InvokeParamsSpUtil.getInstance().remove(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME);
        if (AppConfig.isDebug()) {
            Log.d("InvokeParamsManager", "RemoveSchemeFromSp");
        }
    }

    public static void saveInvokeSchemeToSp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InvokeParamsSpUtil.getInstance().putString(InvokeParamsSpUtil.PARAM_INVOKE_SCHEME, str);
        if (AppConfig.isDebug()) {
            Log.d("InvokeParamsManager", "SaveSchemeToSp: " + str);
        }
    }
}
