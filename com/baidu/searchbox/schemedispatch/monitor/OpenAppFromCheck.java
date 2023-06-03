package com.baidu.searchbox.schemedispatch.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidCheckUtils;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OpenAppFromCheck extends OpenAppBaseCheck implements IFromCheck {
    public static final String DATA_TAG_FROM_LIST = "from_wlist";
    public static final String SCHEME_FROM_WHITE_LIST_FILENAME = "scheme_from_white_list_invoke";
    public static final String TAG = "OpenAppFromCheck";
    public HashMap<String, List<SchemeCheckInfo>> mFromWhiteMap = new HashMap<>();
    public ArrayList<String> mFromWhiteKeyList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromWhiteList() {
        try {
            saveFromDataToCache(new JSONObject(FileUtils.readCacheData(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME)));
        } catch (JSONException e) {
            if (OpenAppBaseCheck.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IFromCheck
    public synchronized ArrayList<String> getFromKeyList() {
        return (ArrayList) this.mFromWhiteKeyList.clone();
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.schemedispatch.monitor.OpenAppFromCheck.1
            @Override // java.lang.Runnable
            public void run() {
                OpenAppFromCheck.this.loadFromWhiteList();
                FileUtils.deleteCache(AppRuntime.getAppContext(), SchemeForbidCheckUtils.SCHEME_FROM_WHITE_LIST_FILENAME);
            }
        }, "SchemeFromWhiteListLoad", 2);
    }

    private synchronized void saveFromDataToCache(JSONObject jSONObject) {
        this.mFromWhiteMap.clear();
        this.mFromWhiteKeyList.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                generateItem(next, optJSONArray);
                this.mFromWhiteKeyList.add(next);
            }
        }
    }

    private synchronized void generateItem(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        this.mFromWhiteMap.put(str, SchemeCheckInfoKt.toSchemeCheckInfoList(arrayList));
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.IFromCheck
    public SchemeCheckInfo checkSchemeInFromWhiteList(String str, String str2, String str3) {
        SchemeCheckInfo schemeCheckInfo = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (this) {
            if (this.mFromWhiteMap.get(str2) != null) {
                schemeCheckInfo = OpenAppBaseCheck.getInfoInList(str, this.mFromWhiteMap.get(str2));
                SchemeForbidStatisticUtils.onEvent(str, str, true, OpenAppBaseCheck.canInvoke(schemeCheckInfo), "from", str3);
            }
        }
        return schemeCheckInfo;
    }

    @Override // com.baidu.searchbox.schemedispatch.monitor.OpenAppBaseCheck
    public boolean saveWhiteListDispatch(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("from_wlist");
        if (optJSONObject == null) {
            if (OpenAppBaseCheck.DEBUG) {
                Log.d(TAG, "from whitelist is empty");
            }
            return false;
        } else if (!FileUtils.cache(AppRuntime.getAppContext(), SCHEME_FROM_WHITE_LIST_FILENAME, optJSONObject.toString(), 0)) {
            return false;
        } else {
            synchronized (this) {
                this.mFromWhiteMap.clear();
                this.mFromWhiteKeyList.clear();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                    if (optJSONArray != null) {
                        generateItem(next, optJSONArray);
                        this.mFromWhiteKeyList.add(next);
                    }
                }
            }
            return true;
        }
    }
}
