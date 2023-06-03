package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenAppFeedCheck extends OpenAppBaseCheck implements IFeedCheck {
    public static final String DATA_TAG_LIGHT_BROWSE_LIST = "feed_wlist";
    public static final String DATA_TAG_LIGHT_BROWSE_TYPE = "feed_opt";
    public static final String SCHEME_FEED_WHITE_LIST_FILENAME = "scheme_feed_white_list_invoke";
    public static final String SCHEME_FORBID_FEED_TYPE_SPKEY = "scheme_forbid_feed_opt_key";
    public static final String TAG = "OpenAppFeedCheck";
    public static List<SchemeCheckInfo> sFeedWhiteList = new ArrayList();

    public static synchronized void loadFeedWhiteList() {
        synchronized (OpenAppFeedCheck.class) {
            sFeedWhiteList.clear();
            sFeedWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(OpenAppBaseCheck.readCache(SCHEME_FEED_WHITE_LIST_FILENAME)));
        }
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.monitor.OpenAppFeedCheck.1
            @Override // java.lang.Runnable
            public void run() {
                OpenAppFeedCheck.loadFeedWhiteList();
                FileUtils.deleteCache(AppRuntime.getAppContext(), SchemeForbidCheckUtils.SCHEME_FEED_WHITE_LIST_FILENAME);
            }
        }, "SchemeFeedWhiteListLoad", 2);
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IFeedCheck
    public synchronized SchemeCheckInfo adCheckSchemeInFeedWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField) {
        String str3;
        SchemeCheckInfo schemeCheckInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_feed_opt_key", "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(schemeStatisticField.addField("scheme", str).addField("enable", "0").addField("type", "clk_feed").addField("invokable", "1"));
            return null;
        }
        if (!TextUtils.equals(str2, "0")) {
            schemeCheckInfo = OpenAppBaseCheck.getInfoInList(str, sFeedWhiteList);
        }
        SchemeStatisticField addField = schemeStatisticField.addField("scheme", str).addField("enable", "1").addField("type", "clk_feed");
        if (OpenAppBaseCheck.canInvoke(schemeCheckInfo)) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        SchemeForbidStatisticUtils.onEvent(addField.addField("invokable", str3));
        return schemeCheckInfo;
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IFeedCheck
    public synchronized SchemeCheckInfo checkSchemeInFeedWhiteList(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_feed_opt_key", "0"), "0")) {
            SchemeForbidStatisticUtils.onEvent(str2, str, false, true, "feed", str3);
            return null;
        }
        SchemeCheckInfo infoInList = OpenAppBaseCheck.getInfoInList(str, sFeedWhiteList);
        SchemeForbidStatisticUtils.onEvent(str2, str, true, OpenAppBaseCheck.canInvoke(infoInList), "feed", str3);
        return infoInList;
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        String optString = jSONObject.optString("feed_opt");
        JSONArray optJSONArray = jSONObject.optJSONArray("feed_wlist");
        if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            if (!OpenAppBaseCheck.writeCache(arrayList, SCHEME_FEED_WHITE_LIST_FILENAME)) {
                return false;
            }
            SchemeSpUtil.getInstance().putString("scheme_forbid_feed_opt_key", optString);
            synchronized (OpenAppFeedCheck.class) {
                sFeedWhiteList.clear();
                sFeedWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(arrayList));
            }
            return true;
        }
        if (OpenAppBaseCheck.DEBUG) {
            Log.d(TAG, "Type or feed whitelist is empty");
        }
        return false;
    }
}
