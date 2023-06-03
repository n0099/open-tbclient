package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenAppNoAlertCheck extends OpenAppBaseCheck implements INoAlertCheck {
    public static final String ALERT_SWITCH_LIST = "alertwlist_switch_list";
    public static final String H5_SWITCH = "h5";
    public static final String NA_SWITCH = "na";
    public static final String PLUGIN_SWITCH = "plugin";
    public static final String SCHEME_ALWAYS_ALLOW_LIST_FILENAME = "scheme_always_allow_list";
    public static final String SCHEME_NAME_FILENAME = "scheme_name_filename";
    public static final String SCHEME_NO_ALERT_LIST_FILENAME = "scheme_no_alert_list";
    public static final String SWITCH_OFF = "0";
    public static final String SWITCH_ON = "1";
    public static final String TAG = "OpenAppNoAlertCheck";

    @Override // com.baidu.searchbox.schemedispatch.monitor.INoAlertCheck
    public List<String> getAlwaysAllowSchema() {
        return OpenAppBaseCheck.readCache("scheme_always_allow_list");
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.monitor.OpenAppNoAlertCheck.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_no_alert_list");
                FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_name_filename");
            }
        }, "NoAlertList", 2);
    }

    public static void updateAlwaysAllowSchema(List<String> list) {
        OpenAppBaseCheck.writeCache(list, "scheme_always_allow_list");
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.INoAlertCheck
    public void addAlwaysAllowSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<String> alwaysAllowSchema = getAlwaysAllowSchema();
        if (alwaysAllowSchema != null && alwaysAllowSchema.size() > 0) {
            arrayList.addAll(alwaysAllowSchema);
        }
        updateAlwaysAllowSchema(arrayList);
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.INoAlertCheck
    public String getNoAlertSwitch(String str) {
        return SchemeSpUtil.getInstance().getString(str, "1");
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.INoAlertCheck
    public boolean isInNoAlertList(String str, List<String> list) {
        return OpenAppBaseCheck.isInWhiteList(str, list);
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(ALERT_SWITCH_LIST);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("h5", "1");
            String optString2 = optJSONObject.optString("na", "0");
            String optString3 = optJSONObject.optString("plugin", "1");
            SchemeSpUtil.getInstance().putString("h5", optString);
            SchemeSpUtil.getInstance().putString("na", optString2);
            SchemeSpUtil.getInstance().putString("plugin", optString3);
            return true;
        } else if (OpenAppBaseCheck.DEBUG) {
            Log.d(TAG, "alertSwitchList is empty");
            return false;
        } else {
            return false;
        }
    }
}
