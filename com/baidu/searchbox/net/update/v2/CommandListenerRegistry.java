package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class CommandListenerRegistry {
    private static final String TAG = "CommandListenerRegistry";
    private final Map<Pair<String, String>, AbstractCommandListener> mListenerMap = new HashMap();

    public CommandListenerRegistry() {
        registerListeners();
    }

    private void registerListeners() {
    }

    public void registerCommandListener(String str, String str2, AbstractCommandListener abstractCommandListener) {
        this.mListenerMap.put(pair(str, str2), abstractCommandListener);
    }

    private Pair<String, String> pair(String str, String str2) {
        return new Pair<>(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractCommandListener getCommandListener(String str, String str2) {
        return this.mListenerMap.get(pair(str, str2));
    }

    public void collectPostData(Context context, CommandPostData commandPostData, IUpdatePostDataFilter iUpdatePostDataFilter) {
        JSONObject jSONObject;
        for (Pair<String, String> pair : this.mListenerMap.keySet()) {
            if (iUpdatePostDataFilter == null || !iUpdatePostDataFilter.isNeedFilter((String) pair.first, (String) pair.second)) {
                try {
                    AbstractCommandListener commandListener = getCommandListener((String) pair.first, (String) pair.second);
                    JSONObject version = commandPostData.getVersion();
                    JSONObject data = commandPostData.getData();
                    JSONObject optJSONObject = version.optJSONObject((String) pair.first);
                    if (optJSONObject == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        version.put((String) pair.first, jSONObject2);
                        jSONObject = jSONObject2;
                    } else {
                        jSONObject = optJSONObject;
                    }
                    JSONObject optJSONObject2 = data.optJSONObject((String) pair.first);
                    if (optJSONObject2 == null) {
                        JSONObject jSONObject3 = new JSONObject();
                        data.put((String) pair.first, jSONObject3);
                        optJSONObject2 = jSONObject3;
                    }
                    commandListener.addPostData(context, (String) pair.first, (String) pair.second, new CommandPostData(jSONObject, optJSONObject2, commandPostData.getPubData()));
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
}
