package com.baidu.searchbox.ng.ai.apps.impl.map.aps;

import android.content.Context;
import android.os.Process;
import com.baidu.b.a.b.a.a.a;
import com.baidu.b.a.h.h;
import com.baidu.searchbox.bdmapsdk.BdMapLibHelper;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.data.BdMapLibApsInfoWrapper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AiAppsPreloadMapLibAPSCallback extends a {
    private static final String MAP_CHANNEL_ID = "42";
    private static final String MAP_CHANNEL_NAME = "map";
    private static final String MAP_PACKAGE_NAME = "com.baidu.searchbox.map";
    private static final String MAP_TASK_NAME = "loadMapLibZip";
    private static final String MODULE_TAG = "APS_MAP_TAG";
    private BdMapLibApsInfoWrapper mBdMapInfoWrapper;
    private Context mContext;

    public AiAppsPreloadMapLibAPSCallback(Context context, BdMapLibApsInfoWrapper bdMapLibApsInfoWrapper) {
        super(MAP_CHANNEL_ID, "map", MAP_PACKAGE_NAME);
        this.mContext = context;
        this.mBdMapInfoWrapper = bdMapLibApsInfoWrapper;
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
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onConfigurationChanged(com.baidu.b.a.c.a.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onConfigurationChanged");
        AiAppsPreloadMapLibHelper.onDownloadFailed(this.mBdMapInfoWrapper, 2003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onUpdate(com.baidu.b.a.c.a.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onUpdate=" + aVar.errMsg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onNewItemAdded(com.baidu.b.a.c.a.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onNewItemAdded=" + aVar.downloadUrl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onItemFiltered(com.baidu.b.a.c.a.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onItemFiltered=" + aVar.errMsg);
        AiAppsPreloadMapLibHelper.onDownloadFailed(this.mBdMapInfoWrapper, 2003);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFetchError(com.baidu.b.a.b.b.a aVar) {
        AiAppsLog.e(MODULE_TAG, "onFetchError=" + aVar.errorMsg);
        AiAppsPreloadMapLibHelper.onDownloadFailed(this.mBdMapInfoWrapper, 2002);
    }

    @Override // com.baidu.b.a.b.a.a
    public String getDownloadPath() {
        String absolutePath = BdMapLibHelper.getBdMapLibBaseDir().getAbsolutePath();
        AiAppsLog.d(MODULE_TAG, "getDownloadPath=" + absolutePath);
        return absolutePath;
    }

    @Override // com.baidu.b.a.b.a.a
    public int getDownloadOptions() {
        return 0;
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onDownloading=" + aVar.errorMsg);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadStart(String str) {
        AiAppsLog.d(MODULE_TAG, "onDownloadStart: " + str);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        AiAppsLog.d(MODULE_TAG, "onDownloadError: " + aVar.errorMsg);
        AiAppsPreloadMapLibHelper.onDownloadFailed(this.mBdMapInfoWrapper, 2002);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, final com.baidu.b.a.c.a.a aVar2) {
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.aps.AiAppsPreloadMapLibAPSCallback.1
            @Override // java.lang.Runnable
            public void run() {
                BdMapLibInfo parseDynamicFile = BdMapLibInfo.parseDynamicFile(aVar2);
                if (parseDynamicFile != null) {
                    StringBuilder sb = new StringBuilder("onFileDownloaded ");
                    if (BdMapLibHelper.matchBdMapSdkVersion(parseDynamicFile.version)) {
                        String absolutePath = BdMapLibHelper.getBdMapLibFile().getAbsolutePath();
                        sb.append(" original file: ").append(aVar2.filePath).append(" target file: ").append(absolutePath).append(" rename result: ").append(BdMapLibHelper.renameBdMapLibFile(aVar2.filePath, absolutePath)).append(" delete result: ").append(h.deleteFile(absolutePath)).append(" pid: ").append(Process.myPid());
                        BdMapLibHelper.setMapLibVersion(parseDynamicFile.version);
                        AiAppsPreloadMapLibHelper.onDownloadSuccess(AiAppsPreloadMapLibAPSCallback.this.mBdMapInfoWrapper);
                        AiAppsLog.d(AiAppsPreloadMapLibAPSCallback.MODULE_TAG, sb.toString());
                        return;
                    }
                    sb.append(" match version failed, ").append(" sdk version: ").append(BdMapLibHelper.getStandardBdMapLibVersion()).append(" so version: ").append(parseDynamicFile.version);
                    AiAppsPreloadMapLibHelper.onDownloadFailed(AiAppsPreloadMapLibAPSCallback.this.mBdMapInfoWrapper, 2004);
                    AiAppsLog.e(AiAppsPreloadMapLibAPSCallback.MODULE_TAG, sb.toString());
                }
            }
        }, MAP_TASK_NAME);
    }

    @Override // com.baidu.b.a.b.a.a.a
    protected Context getContext() {
        return this.mContext;
    }

    /* loaded from: classes4.dex */
    public static class BdMapLibInfo {
        private static final String VERSION_CODE = "version_code";
        public String version;

        public static BdMapLibInfo parseDynamicFile(com.baidu.b.a.c.a.a aVar) {
            if (aVar == null) {
                return null;
            }
            try {
                BdMapLibInfo bdMapLibInfo = new BdMapLibInfo();
                bdMapLibInfo.version = new JSONObject(aVar.ZA).optString("version_code");
                return bdMapLibInfo;
            } catch (JSONException e) {
                AiAppsLog.e(AiAppsPreloadMapLibAPSCallback.MODULE_TAG, e.toString());
                return null;
            }
        }

        public String toString() {
            return "BdMapLibInfo{version='" + this.version + '}';
        }
    }
}
