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
public class OpenAppBlockAlertControl extends OpenAppAlertControl {
    public static final String BLOCK_LIST_KEY = "block_list_key";
    public static List<AlertConfiguration> mBlockList = new ArrayList();

    static {
        initRuleList();
    }

    public static void initRuleList() {
        String readCacheData = FileUtils.readCacheData(AppRuntime.getAppContext(), BLOCK_LIST_KEY);
        if (!TextUtils.isEmpty(readCacheData)) {
            mBlockList = (List) OpenAppAlertControl.mGson.fromJson(readCacheData, new TypeToken<List<AlertConfiguration>>() { // from class: com.baidu.searchbox.schemedispatch.monitor.control.OpenAppBlockAlertControl.1
            }.getType());
        }
    }

    public static void addRule(String str) {
        if (OpenAppAlertControl.isSwitchOn() && OpenAppAlertControl.addRule(str, mBlockList, BLOCK_LIST_KEY)) {
            SchemeForbidStatisticUtils.ubcSchemeRule(false);
        }
    }

    public static boolean checkRule(String str) {
        if (!OpenAppAlertControl.isSwitchOn()) {
            return false;
        }
        return OpenAppAlertControl.checkRule(str, mBlockList, BLOCK_LIST_KEY);
    }

    public static void removeRule(String str) {
        if (!OpenAppAlertControl.isSwitchOn()) {
            return;
        }
        OpenAppAlertControl.removeRule(str, mBlockList, BLOCK_LIST_KEY);
    }
}
