package com.baidu.searchbox.schemedispatch.monitor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
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
public class OpenAppGlobalCheck extends OpenAppBaseCheck implements IGlobalCheck {
    public static final String DATA_TAG_LIST = "white_list";
    public static final String DATA_TAG_TYPE = "type";
    public static final String SCHEME_WHITE_LIST_FILENAME = "scheme_white_list_invoke";
    public static final String TAG = "OpenAppGlobalCheck";
    public static List<SchemeCheckInfo> sWhiteList = new ArrayList();
    public static boolean sLoadCache = false;

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.monitor.OpenAppGlobalCheck.1
            @Override // java.lang.Runnable
            public void run() {
                OpenAppGlobalCheck.loadWhiteList();
                FileUtils.deleteCache(AppRuntime.getAppContext(), SchemeForbidCheckUtils.SCHEME_WHITE_LIST_FILENAME);
            }
        }, "SchemeWhiteListLoad", 2);
    }

    public static synchronized void loadWhiteList() {
        synchronized (OpenAppGlobalCheck.class) {
            long currentTimeMillis = System.currentTimeMillis();
            sWhiteList.clear();
            sWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(OpenAppBaseCheck.readCache(SCHEME_WHITE_LIST_FILENAME)));
            sLoadCache = true;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (OpenAppBaseCheck.DEBUG) {
                Log.d(TAG, "Load Scheme White List Cost: " + (currentTimeMillis2 - currentTimeMillis));
            }
        }
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IGlobalCheck
    public synchronized SchemeCheckInfo adCheckSchemeInGlobalWhiteList(String str, String str2, SchemeStatisticField schemeStatisticField) {
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SchemeCheckInfo publicScheme = OpenAppBaseCheck.getPublicScheme(str);
        if (OpenAppBaseCheck.canInvoke(publicScheme)) {
            return publicScheme;
        }
        if (UrlUtil.isUrl(str)) {
            return SchemeCheckInfoKt.defaultNoAlertSchemeInfo(str);
        }
        if (!sLoadCache) {
            loadWhiteList();
        }
        SchemeCheckInfo infoInList = OpenAppBaseCheck.getInfoInList(str, sWhiteList);
        SchemeStatisticField addField = schemeStatisticField.addField("scheme", str).addField("enable", "1").addField("type", "clk_global");
        if (OpenAppBaseCheck.canInvoke(infoInList)) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        SchemeForbidStatisticUtils.onEvent(addField.addField("invokable", str3));
        long currentTimeMillis2 = System.currentTimeMillis();
        if (OpenAppBaseCheck.DEBUG) {
            Log.d(TAG, "Check Scheme Cost: " + (currentTimeMillis2 - currentTimeMillis) + "\n In whitelist: " + infoInList);
        }
        return infoInList;
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IGlobalCheck
    public synchronized SchemeCheckInfo checkSchemeInGlobalWhiteList(Context context, String str, String str2, String str3, SchemeStatisticField schemeStatisticField) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Uri parse = Uri.parse(str2);
        if (parse != null && parse.getScheme() != null) {
            SchemeCheckInfo schemeInDefault = OpenAppBaseCheck.getSchemeInDefault(str2);
            if (schemeInDefault != null && schemeInDefault.notAlert()) {
                return schemeInDefault;
            }
            if (!sLoadCache) {
                loadWhiteList();
            }
            SchemeCheckInfo infoInList = OpenAppBaseCheck.getInfoInList(str2, sWhiteList);
            if (infoInList != null) {
                schemeInDefault = infoInList;
            }
            SchemeForbidStatisticUtils.doSchemeForbidStatistic(str, str2, true, OpenAppBaseCheck.canInvoke(schemeInDefault), str3, schemeStatisticField);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (OpenAppBaseCheck.DEBUG) {
                Log.d(TAG, "Check Scheme Cost: " + (currentTimeMillis2 - currentTimeMillis) + "\n In whitelist: " + schemeInDefault);
            }
            return schemeInDefault;
        }
        return SchemeCheckInfoKt.defaultSchemeCheckInfo(str2);
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        JSONArray optJSONArray = jSONObject.optJSONArray("white_list");
        if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            ArrayList<SchemeCheckInfo> schemeCheckInfoList = SchemeCheckInfoKt.toSchemeCheckInfoList(arrayList);
            if (!OpenAppBaseCheck.writeCache(arrayList, SCHEME_WHITE_LIST_FILENAME)) {
                return false;
            }
            SchemeSpUtil.getInstance().putString("scheme_forbid_type_key", optString);
            synchronized (OpenAppGlobalCheck.class) {
                sWhiteList.clear();
                sWhiteList.addAll(schemeCheckInfoList);
            }
            return true;
        }
        if (OpenAppBaseCheck.DEBUG) {
            Log.d(TAG, "Type or whitelist is empty");
        }
        return false;
    }
}
