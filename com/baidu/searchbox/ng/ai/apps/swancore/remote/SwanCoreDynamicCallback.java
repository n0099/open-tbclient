package com.baidu.searchbox.ng.ai.apps.swancore.remote;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.b.a.b.a.a.a;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanCoreDynamicCallback extends a {
    private static final String APS_PARAM_SWAN_FORCE = "swan_force";
    private static final String APS_PARAM_SWAN_FORCE_VALUE_FORCE = "1";
    private static final String APS_PARAM_SWAN_VER = "swan_version";
    private static final boolean DEBUG = false;
    private static final String SWAN_CORE_APS_CHANNEL_ID = "33";
    private static final String SWAN_CORE_APS_CHANNEL_NAME = "swan_core";
    private static final String TAG = "SwanCoreDynamicCallback";
    private boolean isSwanForce;

    public SwanCoreDynamicCallback(boolean z) {
        super(SWAN_CORE_APS_CHANNEL_ID, "swan_core");
        this.isSwanForce = false;
        this.isSwanForce = z;
    }

    @Override // com.baidu.b.a.b.a.a.a
    protected Context getContext() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getUrlParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getHeaderParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getCommonParams() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public Map<String, String> getExtParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(APS_PARAM_SWAN_VER, AiAppsSwanCoreManager.getSwanCoreVersionString());
        if (this.isSwanForce) {
            hashMap.put(APS_PARAM_SWAN_FORCE, "1");
        }
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onConfigurationChanged(com.baidu.b.a.c.a.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onUpdate(com.baidu.b.a.c.a.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onNewItemAdded(com.baidu.b.a.c.a.a aVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onItemFiltered(com.baidu.b.a.c.a.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFetchError(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public String getDownloadPath() {
        return null;
    }

    @Override // com.baidu.b.a.b.a.a
    public int getDownloadOptions() {
        return 0;
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadStart(String str) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, final com.baidu.b.a.c.a.a aVar2) {
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.swancore.remote.SwanCoreDynamicCallback.1
            @Override // java.lang.Runnable
            public void run() {
                SwanCoreInfo parseDynamicFile = SwanCoreInfo.parseDynamicFile(aVar2);
                if (parseDynamicFile == null) {
                    SwanCoreDynamicCallback.this.deleteLocalFile(aVar2);
                } else if (RemoteSwanCoreControl.doRemoteUpdate(parseDynamicFile.version, parseDynamicFile.bundleFilePath, parseDynamicFile.sign).isOk()) {
                    SwanCoreDynamicCallback.this.deleteLocalFile(aVar2);
                } else {
                    SwanCoreDynamicCallback.this.deleteLocalFile(aVar2);
                }
            }
        }, "doSwanCoreInstall");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLocalFile(com.baidu.b.a.c.a.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.filePath)) {
            AiAppsFileUtils.deleteFile(aVar.filePath);
        }
    }

    /* loaded from: classes2.dex */
    public static class SwanCoreInfo {
        public String bundleFilePath;
        public String sign;
        public String version;

        public static SwanCoreInfo parseDynamicFile(com.baidu.b.a.c.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            try {
                SwanCoreInfo swanCoreInfo = new SwanCoreInfo();
                JSONObject jSONObject = new JSONObject(aVar.ZA);
                swanCoreInfo.version = jSONObject.optString("version_code");
                swanCoreInfo.sign = jSONObject.optString("sign");
                swanCoreInfo.bundleFilePath = aVar.filePath;
                return swanCoreInfo;
            } catch (JSONException e) {
                return null;
            }
        }

        public String toString() {
            return "SwanCoreInfo{version='" + this.version + "', bundleFilePath='" + this.bundleFilePath + "'}";
        }
    }
}
