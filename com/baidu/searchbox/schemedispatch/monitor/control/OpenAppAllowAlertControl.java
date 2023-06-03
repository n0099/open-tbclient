package com.baidu.searchbox.schemedispatch.monitor.control;

import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.AlertConfiguration;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OpenAppAllowAlertControl extends OpenAppAlertControl {
    public static final String ALLOW_LIST_KEY = "allow_list_key";
    public static List<AlertConfiguration> mAllowList = new ArrayList();

    static {
        initRuleList();
    }

    public static void initRuleList() {
        String readCacheData = FileUtils.readCacheData(AppRuntime.getAppContext(), ALLOW_LIST_KEY);
        if (!TextUtils.isEmpty(readCacheData)) {
            mAllowList = (List) OpenAppAlertControl.mGson.fromJson(readCacheData, new TypeToken<List<AlertConfiguration>>() { // from class: com.baidu.searchbox.schemedispatch.monitor.control.OpenAppAllowAlertControl.1
            }.getType());
        }
    }

    public static void addRule(String str) {
        if (OpenAppAlertControl.isSwitchOn() && OpenAppAlertControl.addRule(str, mAllowList, ALLOW_LIST_KEY)) {
            SchemeForbidStatisticUtils.ubcSchemeRule(true);
        }
    }

    public static boolean checkRule(String str) {
        if (!OpenAppAlertControl.isSwitchOn()) {
            return false;
        }
        return OpenAppAlertControl.checkRule(str, mAllowList, ALLOW_LIST_KEY);
    }

    public static void removeRule(String str) {
        if (!OpenAppAlertControl.isSwitchOn()) {
            return;
        }
        OpenAppAlertControl.removeRule(str, mAllowList, ALLOW_LIST_KEY);
    }
}
