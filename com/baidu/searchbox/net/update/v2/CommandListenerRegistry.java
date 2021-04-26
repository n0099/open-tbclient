package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class CommandListenerRegistry {
    public static final String TAG = "CommandListenerRegistry";
    public final Map<Pair<String, String>, AbstractCommandListener> mListenerMap = new HashMap();

    public CommandListenerRegistry() {
        registerListeners();
    }

    private Pair<String, String> pair(String str, String str2) {
        return new Pair<>(str, str2);
    }

    private void registerListeners() {
    }

    public void collectPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        for (Pair<String, String> pair : this.mListenerMap.keySet()) {
            if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                try {
                    AbstractCommandListener commandListener = getCommandListener((String) pair.first, (String) pair.second);
                    JSONObject version = commandPostData.getVersion();
                    JSONObject data = commandPostData.getData();
                    JSONObject optJSONObject = version.optJSONObject((String) pair.first);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        version.put((String) pair.first, optJSONObject);
                    }
                    JSONObject optJSONObject2 = data.optJSONObject((String) pair.first);
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                        data.put((String) pair.first, optJSONObject2);
                    }
                    commandListener.addPostData(context, (String) pair.first, (String) pair.second, new CommandPostData(optJSONObject, optJSONObject2, commandPostData.getPubData()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (AppConfig.isDebug()) {
                        Log.e(TAG, "addPostData error " + e2.getMessage());
                    }
                }
            }
        }
        commandPostData.cleanEmptyData();
    }

    public AbstractCommandListener getCommandListener(String str, String str2) {
        return this.mListenerMap.get(pair(str, str2));
    }

    public void registerCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        this.mListenerMap.put(pair(str, str2), abstractCommandListener);
    }
}
