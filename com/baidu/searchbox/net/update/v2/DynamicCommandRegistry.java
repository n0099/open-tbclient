package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DynamicCommandRegistry {
    public static final String TAG = "DynamicCommandRegistry";
    public static volatile DynamicCommandRegistry mInstance;
    public final Map<Pair<String, String>, AbstractCommandListener> mDynamicListenerMap = new HashMap();

    public static DynamicCommandRegistry getInstance() {
        if (mInstance == null) {
            synchronized (DynamicCommandRegistry.class) {
                if (mInstance == null) {
                    mInstance = new DynamicCommandRegistry();
                }
            }
        }
        return mInstance;
    }

    public Map<Pair<String, String>, AbstractCommandListener> getDynamicListenerMap() {
        return this.mDynamicListenerMap;
    }

    private void collectPostData(Context context, AbstractCommandListener abstractCommandListener, CommandPostData commandPostData, String str, String str2) throws JSONException {
        if (context != null && abstractCommandListener != null && commandPostData != null) {
            JSONObject version = commandPostData.getVersion();
            JSONObject data = commandPostData.getData();
            JSONObject optJSONObject = version.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                version.put(str, optJSONObject);
            }
            JSONObject optJSONObject2 = data.optJSONObject(str);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                data.put(str, optJSONObject2);
            }
            abstractCommandListener.addPostData(context, str, str2, new CommandPostData(optJSONObject, optJSONObject2, commandPostData.getPubData()));
        }
    }

    private Pair<String, String> pair(String str, String str2) {
        return new Pair<>(str, str2);
    }

    public AbstractCommandListener getDynamicCommandListener(String str, String str2) {
        return this.mDynamicListenerMap.get(pair(str, str2));
    }

    public void collectDynamicPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        for (Pair<String, String> pair : this.mDynamicListenerMap.keySet()) {
            if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                try {
                    collectPostData(context, getDynamicCommandListener((String) pair.first, (String) pair.second), commandPostData, (String) pair.first, (String) pair.second);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (AppConfig.isDebug()) {
                        Log.e(TAG, "addPostData error " + e.getMessage());
                    }
                }
            }
        }
        commandPostData.cleanEmptyData();
    }

    public void registerDynamicCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mDynamicListenerMap.put(pair(str, str2), abstractCommandListener);
        }
    }

    public void registerDynamicCommandListener(String str, List<String> list, AbstractCommandListener abstractCommandListener) {
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                registerDynamicCommandListener(str, str2, abstractCommandListener);
            }
        }
    }
}
