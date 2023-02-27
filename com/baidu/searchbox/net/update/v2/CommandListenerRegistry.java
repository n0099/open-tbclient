package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.net.update.CommandPostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class CommandListenerRegistry {
    public static final String TAG = "CommandListenerRegistry";
    public final Map<Pair<String, String>, AbstractCommandListener> mListenerMap = new HashMap();

    private void registerListeners() {
    }

    public CommandListenerRegistry() {
        try {
            registerListeners();
        } catch (Error unused) {
        }
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

    public AbstractCommandListener getCommandListener(String str, String str2) {
        return this.mListenerMap.get(pair(str, str2));
    }

    public void collectPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        for (Pair<String, String> pair : this.mListenerMap.keySet()) {
            if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                try {
                    collectPostData(context, getCommandListener((String) pair.first, (String) pair.second), commandPostData, (String) pair.first, (String) pair.second);
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                        Log.e(TAG, "addPostData error " + e.getMessage());
                    }
                }
            }
        }
        commandPostData.cleanEmptyData();
    }

    public void collectPostData(Context context, CommandPostData commandPostData, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                try {
                    String[] split = next.split("/");
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        AbstractCommandListener commandListener = getCommandListener(split[0], split[1]);
                        if (commandListener == null) {
                            if (AppConfig.isDebug()) {
                                throw new DebugException("Please Remove UnUsed Preload Item In List");
                                break;
                            }
                        } else {
                            collectPostData(context, commandListener, commandPostData, split[0], split[1]);
                        }
                    }
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                }
            }
        }
        commandPostData.cleanEmptyData();
    }

    public void registerCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        this.mListenerMap.put(pair(str, str2), abstractCommandListener);
    }
}
