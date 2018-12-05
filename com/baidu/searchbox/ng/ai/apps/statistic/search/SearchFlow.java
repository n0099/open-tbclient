package com.baidu.searchbox.ng.ai.apps.statistic.search;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.ubc.Flow;
import com.baidu.ubc.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SearchFlow {
    public static final boolean DEBUG = false;
    public static final String TAG = "SearchFlow";
    public static final String UBC_EXT_KEY_APPID = "appid";
    public static final String UBC_EXT_KEY_SEARCHID = "searchid";
    public static final String UBC_EXT_KEY_SWAN = "swan";
    public static final String UBC_EXT_KEY_URL = "url";
    public static final String UBC_FROM_SWAN = "swan";
    public static final String UBC_TYPE_FAIL = "fail";
    public static final String UBC_TYPE_SUCCESS = "success";
    private String mAppId;
    private HashMap<String, SearchFlowEvent> mEventPool = new HashMap<>();
    private HashMap<String, String> mExt;
    private String mSource;
    private String mType;
    private String mUbcId;
    private String mValue;

    public SearchFlow(String str) {
        this.mUbcId = str;
    }

    public void addEvent(SearchFlowEvent searchFlowEvent) {
        if (isValid(searchFlowEvent)) {
            if (this.mEventPool.get(searchFlowEvent.id) != null) {
                this.mEventPool.remove(searchFlowEvent.id);
            }
            this.mEventPool.put(searchFlowEvent.id, searchFlowEvent);
            String str = searchFlowEvent.id;
            char c = 65535;
            switch (str.hashCode()) {
                case -1037374011:
                    if (str.equals(SearchFlowEvent.ID_NOT_REACH)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1211923090:
                    if (str.equals(SearchFlowEvent.ID_DOM_FIRST_PAINT)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mType = "success";
                    this.mValue = "";
                    return;
                case 1:
                    this.mType = "fail";
                    this.mValue = searchFlowEvent.data;
                    return;
                default:
                    return;
            }
        }
    }

    public void addExt(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mExt == null) {
                this.mExt = new HashMap<>();
            }
            this.mExt.put(str, str2);
        }
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void send() {
        AiAppExecutorUtils.getIoExecutor().execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlow.1
            @Override // java.lang.Runnable
            public void run() {
                SearchFlow.this.sendUBCData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUBCData() {
        Flow yl;
        if (!TextUtils.equals(this.mSource, "8003") && (yl = o.yl(this.mUbcId)) != null) {
            for (SearchFlowEvent searchFlowEvent : this.mEventPool.values()) {
                yl.e(searchFlowEvent.id, searchFlowEvent.extData, searchFlowEvent.timestamp);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", this.mType);
                jSONObject.put("source", this.mSource);
                jSONObject.put("value", this.mValue);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                if (this.mExt != null) {
                    for (String str : this.mExt.keySet()) {
                        jSONObject2.put(str, this.mExt.get(str));
                    }
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
            }
            yl.yg(jSONObject.toString());
            yl.end();
        }
    }

    public void destroy() {
        if (this.mEventPool != null) {
            this.mEventPool.clear();
        }
        if (this.mExt != null) {
            this.mExt.clear();
        }
        this.mAppId = null;
        this.mType = null;
        this.mSource = null;
        this.mValue = null;
        this.mEventPool = null;
        this.mExt = null;
    }

    private boolean isValid(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.id) || searchFlowEvent.timestamp <= 0) ? false : true;
    }
}
