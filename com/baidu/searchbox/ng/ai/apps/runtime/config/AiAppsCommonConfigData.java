package com.baidu.searchbox.ng.ai.apps.runtime.config;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsCommonConfigData {
    protected static final boolean DEBUG = false;
    private static final String JSON_NETWORK_KEY = "networkTimeout";
    private static final String TAG = "AiAppsCommonConfigData";

    /* loaded from: classes2.dex */
    public static class NetworkConfig {
        private static final int DEFAULT_TIMEOUT_MS = 60000;
        private static final String JSON_CONNECT_SOCKET_KEY = "connectSocket";
        private static final String JSON_DOWNLOAD_FILE_KEY = "downloadFile";
        private static final String JSON_REQUEST_KEY = "request";
        private static final String JSON_UPLOAD_FILE_KEY = "uploadFile";
        public static final int MAX_REQUESTS = 10;
        public int mConnectSocketMs;
        public int mDownloadFileMs;
        public int mRequestMs;
        public int mUploadFileMs;

        public static NetworkConfig buildNetworkConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return createNullObject();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(AiAppsCommonConfigData.JSON_NETWORK_KEY);
            if (optJSONObject == null) {
                return createNullObject();
            }
            NetworkConfig networkConfig = new NetworkConfig();
            networkConfig.mRequestMs = optJSONObject.optInt("request", 60000);
            networkConfig.mConnectSocketMs = optJSONObject.optInt(JSON_CONNECT_SOCKET_KEY, 60000);
            networkConfig.mUploadFileMs = optJSONObject.optInt(JSON_UPLOAD_FILE_KEY);
            networkConfig.mDownloadFileMs = optJSONObject.optInt(JSON_DOWNLOAD_FILE_KEY);
            return networkConfig;
        }

        private static NetworkConfig createNullObject() {
            NetworkConfig networkConfig = new NetworkConfig();
            networkConfig.mRequestMs = 60000;
            networkConfig.mConnectSocketMs = 60000;
            return networkConfig;
        }
    }
}
