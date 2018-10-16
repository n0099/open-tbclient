package com.baidu.searchbox.ng.ai.apps.network.update.node;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.searchbox.ng.ai.apps.network.update.AiAppsUpdateManager;
import com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.setting.SettingDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsAccreditNode extends AiAppsBaseNode {
    private static final String ACCREDIT_LIST_NAME = "list";
    private static final boolean DEBUG = false;
    private static final String NODE_NAME = "accredit";
    private static final String TAG = "AiAppsAccreditNode";

    @Override // com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsBaseNode
    @NonNull
    public String getNodeName() {
        return NODE_NAME;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsBaseNode
    public void onUpdate(JSONObject jSONObject) {
        AiApp aiApp;
        if (jSONObject != null && (aiApp = AiApp.get()) != null) {
            aiApp.getSetting().putString(SettingDef.NODE_DATA_ACCREDIT_LIST, jSONObject.toString());
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsBaseNode
    public void onFiltered() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsBaseNode
    public void onFail() {
    }

    public static void getAccreditListData(@NonNull final TypedCallback<Map<String, ScopeInfo>> typedCallback) {
        AiAppsUpdateManager.getInstance().tryUpdate(new IOnUpdateFinish() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode.1
            @Override // com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish
            public void onUpdateFinish() {
                Map accreditListData = AiAppsAccreditNode.getAccreditListData();
                if (accreditListData.size() > 0) {
                    TypedCallback.this.onCallback(accreditListData);
                } else {
                    AiAppsUpdateManager.getInstance().update(new IOnUpdateFinish() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode.1.1
                        @Override // com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish
                        public void onUpdateFinish() {
                            TypedCallback.this.onCallback(AiAppsAccreditNode.getAccreditListData());
                        }
                    });
                }
            }
        });
    }

    public static void getAccreditListData(final String str, @NonNull final TypedCallback<ScopeInfo> typedCallback) {
        AiAppsUpdateManager.getInstance().tryUpdate(new IOnUpdateFinish() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode.2
            @Override // com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish
            public void onUpdateFinish() {
                ScopeInfo scopeInfo = (ScopeInfo) AiAppsAccreditNode.getAccreditListData().get(str);
                if (scopeInfo != null) {
                    typedCallback.onCallback(scopeInfo);
                } else {
                    AiAppsUpdateManager.getInstance().update(new IOnUpdateFinish() { // from class: com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode.2.1
                        @Override // com.baidu.searchbox.ng.ai.apps.network.update.interfaces.IOnUpdateFinish
                        public void onUpdateFinish() {
                            typedCallback.onCallback(AiAppsAccreditNode.getAccreditListData().get(str));
                        }
                    });
                }
            }
        });
    }

    public static void cleanAccreditListData() {
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            AiAppsUpdateManager.getInstance().resetNodeVersion(new AiAppsAccreditNode());
            aiApp.getSetting().putString(SettingDef.NODE_DATA_ACCREDIT_LIST, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static Map<String, ScopeInfo> getAccreditListData() {
        JSONObject optJSONObject;
        ArrayMap arrayMap = new ArrayMap();
        new JSONObject();
        AiApp aiApp = AiApp.get();
        if (aiApp == null) {
            return arrayMap;
        }
        String string = aiApp.getSetting().getString(SettingDef.NODE_DATA_ACCREDIT_LIST, "");
        if (TextUtils.isEmpty(string)) {
            return arrayMap;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(string).optJSONObject("list");
            if (optJSONObject2 == null) {
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, ScopeInfo.parse(next, optJSONObject));
                }
            }
            return arrayMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayMap;
        }
    }
}
