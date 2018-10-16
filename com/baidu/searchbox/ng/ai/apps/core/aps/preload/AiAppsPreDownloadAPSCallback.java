package com.baidu.searchbox.ng.ai.apps.core.aps.preload;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.b.a.c.a.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsAPSStatusSync;
import com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsBaseApsCallback;
import com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps;
import com.baidu.searchbox.ng.ai.apps.core.aps.preload.AiAppsPreDownload;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.performance.aps.AiAppsAPSPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AiAppsPreDownloadAPSCallback extends AiAppsBaseApsCallback {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsPreDownloadAPSCallback";
    private String mAppId;
    private AiAppsLaunchParams mAppsLaunchParams;
    private Context mContext;
    private AiAppsPreDownload.DownloadCallback mDownloadCallback;
    private List<UbcFlowEvent> mFlowEventList;

    public AiAppsPreDownloadAPSCallback(Context context, String str, AiAppsPreDownload.DownloadCallback downloadCallback) {
        super(str);
        this.mAppId = str;
        this.mContext = context;
        this.mDownloadCallback = downloadCallback;
        this.mFlowEventList = new ArrayList();
        this.mAppsLaunchParams = new AiAppsLaunchParams();
        this.mAppsLaunchParams.mAppId = str;
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_REQ));
    }

    @Override // com.baidu.b.a.b.a.a.a
    protected Context getContext() {
        return this.mContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onConfigurationChanged(a aVar) {
        if (this.mDownloadCallback != null) {
            this.mDownloadCallback.preDownloadFailed(1);
        }
        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFailed(this.mAppId);
        onApsCheckFinish(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onUpdate(a aVar) {
        onApsCheckFinish(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onNewItemAdded(a aVar) {
        onApsCheckFinish(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onItemFiltered(a aVar) {
        if (this.mDownloadCallback != null) {
            this.mDownloadCallback.preDownloadFailed(2);
        }
        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFailed(this.mAppId);
        onApsCheckFinish(false);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFetchError(com.baidu.b.a.b.b.a aVar) {
        if (this.mDownloadCallback != null) {
            this.mDownloadCallback.preDownloadFailed(3);
        }
        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFailed(this.mAppId);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadStart(String str) {
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_DOWNLOAD));
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        if (this.mDownloadCallback != null) {
            this.mDownloadCallback.preDownloadFailed(0);
        }
        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFailed(this.mAppId);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, a aVar2) {
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_DOWNLOAD));
        String optString = AiAppJSONUtils.parseString(aVar2.Zr).optString(AiAppsApsUtils.ICON_URL);
        if (LaunchAiApps.checkZipSign(aVar2, this.mAppsLaunchParams) == null && LaunchAiApps.renameAiAppsZip(aVar2) == null && LaunchAiApps.unZipAiAppBundle(aVar2, this.mAppsLaunchParams) == null) {
            downloadAiAppIcon(optString, aVar2);
            List<UbcFlowEvent> generateUBCEventFormLaunchParams = LaunchAiApps.generateUBCEventFormLaunchParams(this.mAppsLaunchParams);
            if (generateUBCEventFormLaunchParams != null) {
                this.mFlowEventList.addAll(generateUBCEventFormLaunchParams);
                return;
            }
            return;
        }
        if (this.mDownloadCallback != null) {
            this.mDownloadCallback.preDownloadFailed(4);
        }
        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFailed(this.mAppId);
    }

    private void onApsCheckFinish(boolean z) {
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_REQ));
        if (!z) {
            onUBCStatisticsEnd();
        }
    }

    private void downloadAiAppIcon(final String str, final a aVar) {
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_ICON));
        LaunchAiApps.downloadAiAppsIconByFresco(str, new LaunchAiApps.DownloadAiAppsIconListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.preload.AiAppsPreDownloadAPSCallback.1
            @Override // com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.DownloadAiAppsIconListener
            public void getIcon(Bitmap bitmap) {
                AiAppsPreDownloadAPSCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_ICON));
                AiAppsPreDownloadAPSCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.START_UPDATE_DB));
                LaunchAiApps.updateDbInfo(AppRuntime.getAppContext(), aVar, bitmap, AiAppsPreDownloadAPSCallback.this.mAppId, str, new LaunchAiApps.UpdateDbListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.preload.AiAppsPreDownloadAPSCallback.1.1
                    @Override // com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.UpdateDbListener
                    public void dbUpdate(AiAppsDbInfo aiAppsDbInfo) {
                        if (AiAppsPreDownloadAPSCallback.this.mDownloadCallback != null) {
                            AiAppsPreDownloadAPSCallback.this.mDownloadCallback.preDownloadSuccess();
                        }
                        AiAppsAPSStatusSync.getInstance().aiAppPreDownloadFinish(AiAppsPreDownloadAPSCallback.this.mAppId);
                        AiAppsPreDownloadAPSCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.END_UPDATE_DB));
                        AiAppsPreDownloadAPSCallback.this.onUBCStatisticsEnd();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUBCStatisticsEnd() {
        AiAppsAPSPerformanceUBC.onDownloadMainStatistics(this.mAppId, AiAppsAPSPerformanceUBC.TYPE_PRE_DOWNLOAD, this.mFlowEventList);
        this.mFlowEventList.clear();
    }
}
