package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.b.a.c.a.a;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsAPSStatusSync;
import com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.performance.aps.AiAppsAPSPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsDynamicCallback extends AiAppsBaseApsCallback {
    private static final boolean DEBUG = false;
    public static final String ERRMSG_APP_VERSION_NOT_MATCH = "host version is invalid";
    public static final String ERRMSG_PKG_NOT_EXIST = "pkg info is not exist";
    public static final int ERRNO_APP_VERSION_NOT_MATCH = 1104;
    public static final int ERRNO_PKG_FILTERED = 1103;
    public static final int ERRNO_PKG_NEWEST = 1102;
    public static final int ERRNO_PKG_NOT_EXIST = 1101;
    private static final String TAG = "AiAppsDynamicCallback";
    public static final String TIPMSG_APP_VERSION_NOT_MATCH = "宿主版本不合法";
    public static final String TIPMSG_PKG_NOT_EXIST = "包信息不存在";
    private boolean isConfigChanged;
    private String mAiAppsIconUrl;
    private AiAppsInfoLatch mAiAppsInfoLatch;
    private String mAppId;
    private Bitmap mBitmapIcon;
    private a mConfigChangedDynamicFile;
    private Context mContext;
    private LaunchAiApps.DownloadAiAppsIconListener mDownloadAiAppsIconListener;
    private a mDynamicFile;
    private int mFlowControlFlag;
    private List<UbcFlowEvent> mFlowEventList;
    private AiAppsLaunchParams mLaunchParams;
    private boolean mPackageDownloadSuccess;
    private Runnable mSaveAiAppsInfoToDbRunnable;

    public AiAppsDynamicCallback(@NonNull Context context, @NonNull AiAppsLaunchParams aiAppsLaunchParams, int i) {
        super(aiAppsLaunchParams.mAppId);
        this.mPackageDownloadSuccess = false;
        this.mDownloadAiAppsIconListener = new LaunchAiApps.DownloadAiAppsIconListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsDynamicCallback.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.DownloadAiAppsIconListener
            public void getIcon(Bitmap bitmap) {
                AiAppsDynamicCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_ICON));
                AiAppsDynamicCallback.this.mBitmapIcon = bitmap;
                if (AiAppsDynamicCallback.this.mAiAppsInfoLatch != null) {
                    AiAppsDynamicCallback.this.mAiAppsInfoLatch.iconDownloadFinish();
                }
                if (AiAppsDynamicCallback.this.isConfigChanged && AiAppsDynamicCallback.this.mConfigChangedDynamicFile != null) {
                    AiAppsDynamicCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.START_UPDATE_DB));
                    LaunchAiApps.updateDbInfo(AiAppsDynamicCallback.this.mContext, AiAppsDynamicCallback.this.mConfigChangedDynamicFile, AiAppsDynamicCallback.this.mBitmapIcon, AiAppsDynamicCallback.this.mLaunchParams.mAppId, AiAppsDynamicCallback.this.mAiAppsIconUrl, new LaunchAiApps.UpdateDbListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsDynamicCallback.2.1
                        @Override // com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.UpdateDbListener
                        public void dbUpdate(AiAppsDbInfo aiAppsDbInfo) {
                            AiAppsDynamicCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.END_UPDATE_DB));
                            AiAppsDynamicCallback.this.onUBCStatisticsEnd();
                            AiAppsDynamicCallback.this.onApsCheckFinish(false, AiAppsDynamicCallback.this.mConfigChangedDynamicFile, null);
                        }
                    });
                }
            }
        };
        this.mSaveAiAppsInfoToDbRunnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsDynamicCallback.3
            @Override // java.lang.Runnable
            public void run() {
                if (AiAppsDynamicCallback.this.mPackageDownloadSuccess && APSFlowControlFlag.appInfoGetThenUpdateDb(AiAppsDynamicCallback.this.mFlowControlFlag)) {
                    AiAppsDynamicCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.START_UPDATE_DB));
                    LaunchAiApps.updateDbInfo(AiAppsDynamicCallback.this.mContext, AiAppsDynamicCallback.this.mDynamicFile, AiAppsDynamicCallback.this.mBitmapIcon, AiAppsDynamicCallback.this.mLaunchParams.mAppId, AiAppsDynamicCallback.this.mAiAppsIconUrl, new LaunchAiApps.UpdateDbListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsDynamicCallback.3.1
                        @Override // com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.UpdateDbListener
                        public void dbUpdate(AiAppsDbInfo aiAppsDbInfo) {
                            AiAppsDynamicCallback.this.dbUpdateFinish(aiAppsDbInfo);
                            AiAppsDynamicCallback.this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.END_UPDATE_DB));
                            AiAppsDynamicCallback.this.onUBCStatisticsEnd();
                        }
                    });
                }
            }
        };
        this.mAppId = aiAppsLaunchParams.mAppId;
        this.mContext = context;
        this.mLaunchParams = aiAppsLaunchParams;
        this.mFlowControlFlag = i;
        this.mPackageDownloadSuccess = false;
        this.mFlowEventList = new ArrayList();
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_REQ));
    }

    @Override // com.baidu.b.a.b.a.a.a
    protected Context getContext() {
        return this.mContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onConfigurationChanged(a aVar) {
        onApsCheckFinish(false, aVar, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onUpdate(a aVar) {
        onApsCheckFinish(true, aVar, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onNewItemAdded(a aVar) {
        onApsCheckFinish(true, aVar, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.b.a.b.a.a
    public void onItemFiltered(a aVar) {
        com.baidu.b.a.b.b.a aVar2 = null;
        if (aVar != null && aVar.Ky != 1102) {
            aVar2 = aVar.Ky == 1104 ? buildAppVersionUnMatchErrorInfo() : new com.baidu.b.a.b.b.a(aVar.Ky, TextUtils.isEmpty(aVar.errMsg) ? "" : aVar.errMsg, TextUtils.isEmpty(aVar.Zm) ? "" : aVar.Zm);
        }
        onApsCheckFinish(false, aVar, aVar2);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFetchError(com.baidu.b.a.b.b.a aVar) {
        onApsErrorInfo(aVar);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloading(com.baidu.b.a.b.b.a aVar) {
        if (this.mAiAppsInfoLatch != null) {
            this.mAiAppsInfoLatch.cancel();
        }
        if (APSFlowControlFlag.isNeedStartAiAppActivity(this.mFlowControlFlag)) {
            AiAppsAPSStatusSync.getInstance().registerStatusListener(this.mAppId, new AiAppsAPSStatusSync.OnCompleteListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsDynamicCallback.1
                @Override // com.baidu.searchbox.ng.ai.apps.core.aps.AiAppsAPSStatusSync.OnCompleteListener
                public void onDownloadComplete(String str) {
                    AiAppsDbInfo queryAiAppsItem;
                    if (TextUtils.equals(str, AiAppsDynamicCallback.this.mAppId) && (queryAiAppsItem = AiAppsDbControl.getInstance(AiAppsDynamicCallback.this.mContext).queryAiAppsItem(AiAppsDynamicCallback.this.mAppId)) != null) {
                        LaunchAiApps.doAiAppsStart(AiAppsDynamicCallback.this.mContext, AiAppsDynamicCallback.this.mLaunchParams, queryAiAppsItem);
                    }
                }
            });
        }
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadStart(String str) {
        initAiAppsInfoLatch();
        this.mLaunchParams.mExtraData.putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DOWNLOAD_START_TIMESTAMP, System.currentTimeMillis());
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_DOWNLOAD));
    }

    @Override // com.baidu.b.a.b.a.a
    public void onDownloadError(com.baidu.b.a.b.b.a aVar) {
        this.mPackageDownloadSuccess = false;
        if (this.mAiAppsInfoLatch != null) {
            this.mAiAppsInfoLatch.packageDownloadFailed();
        }
        onApsErrorInfo(aVar);
    }

    @Override // com.baidu.b.a.b.a.a
    public void onFileDownloaded(com.baidu.b.a.b.b.a aVar, a aVar2) {
        if (aVar2 == null) {
            ErrCode detail = new ErrCode().feature(2L).error(2L).detail("APS onFileDownloaded dynamicFile is null!");
            Tracer.get().record(detail);
            onApsErrorCode(detail);
            return;
        }
        this.mLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DOWNLOAD_END_TIMESTAMP, System.currentTimeMillis());
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_DOWNLOAD));
        this.mDynamicFile = aVar2;
        ErrCode checkZipSign = LaunchAiApps.checkZipSign(aVar2, this.mLaunchParams);
        if (checkZipSign != null) {
            checkZipSign.detail(this.mDynamicFile.toJSONString());
            onApsErrorCode(checkZipSign);
            if (this.mAiAppsInfoLatch != null) {
                this.mAiAppsInfoLatch.cancel();
                return;
            }
            return;
        }
        ErrCode renameAiAppsZip = LaunchAiApps.renameAiAppsZip(aVar2);
        if (renameAiAppsZip != null) {
            renameAiAppsZip.detail(this.mDynamicFile.toJSONString());
            onApsErrorCode(renameAiAppsZip);
            if (this.mAiAppsInfoLatch != null) {
                this.mAiAppsInfoLatch.cancel();
                return;
            }
            return;
        }
        ErrCode unZipAiAppBundle = LaunchAiApps.unZipAiAppBundle(aVar2, this.mLaunchParams);
        if (unZipAiAppBundle != null) {
            unZipAiAppBundle.detail(this.mDynamicFile.toJSONString());
            onApsErrorCode(unZipAiAppBundle);
            if (this.mAiAppsInfoLatch != null) {
                this.mAiAppsInfoLatch.cancel();
                return;
            }
            return;
        }
        List<UbcFlowEvent> generateUBCEventFormLaunchParams = LaunchAiApps.generateUBCEventFormLaunchParams(this.mLaunchParams);
        if (generateUBCEventFormLaunchParams != null) {
            this.mFlowEventList.addAll(generateUBCEventFormLaunchParams);
        }
        this.mPackageDownloadSuccess = true;
        if (this.mAiAppsInfoLatch != null) {
            this.mAiAppsInfoLatch.packageDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onApsCheckFinish(boolean z, a aVar, @Nullable com.baidu.b.a.b.b.a aVar2) {
        this.mLaunchParams.mExtraData.putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_END_TIMESTAMP, System.currentTimeMillis());
        this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_END_REQ));
        AiAppsSpHelper.getsInstance().putLong(this.mLaunchParams.mAppId, System.currentTimeMillis());
        if (aVar2 != null && aVar2.code == 1104) {
            LaunchAiApps.updateAiAppsPendingApsErrcode(this.mContext, this.mAppId, aVar2.code);
        } else {
            LaunchAiApps.updateAiAppsPendingApsErrcode(this.mContext, this.mAppId, 0);
        }
        ErrCode errCode = null;
        if (aVar2 != null) {
            errCode = new ErrCode().feature(2L).error(aVar2.code).desc(aVar2.Zm).detail(aVar2.errorMsg);
            if (aVar != null) {
                errCode.detail(aVar.toJSONString());
            }
            Tracer.get().record(errCode);
        }
        if (z && APSFlowControlFlag.apsInfoGetThenDownloadIcon(this.mFlowControlFlag)) {
            if (aVar != null) {
                this.mAiAppsIconUrl = parseString(aVar.Zr).optString(AiAppsApsUtils.ICON_URL);
            }
            initAiAppsInfoLatch();
            this.mFlowEventList.add(new UbcFlowEvent(AiAppsAPSPerformanceUBC.APS_START_ICON));
            LaunchAiApps.downloadAiAppsIconByFresco(this.mAiAppsIconUrl, this.mLaunchParams, this.mDownloadAiAppsIconListener);
        } else if (!z) {
            if (APSFlowControlFlag.emptyPackageThenLoadLocal(this.mFlowControlFlag)) {
                LaunchAiApps.launchAiAppsByLocal(this.mContext, this.mLaunchParams, errCode);
            }
            onUBCStatisticsEnd();
        }
    }

    public static JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    private void onApsErrorInfo(@Nullable com.baidu.b.a.b.b.a aVar) {
        ErrCode errCode = null;
        if (aVar != null) {
            errCode = new ErrCode().feature(2L).error(aVar.code).desc(aVar.Zm).detail(aVar.errorMsg);
            Tracer.get().record(errCode);
        }
        onApsErrorCode(errCode);
    }

    private void onApsErrorCode(@Nullable ErrCode errCode) {
        if (APSFlowControlFlag.apsErrorThenLoadLocal(this.mFlowControlFlag)) {
            LaunchAiApps.launchAiAppsByLocal(this.mContext, this.mLaunchParams, errCode);
        }
        if (errCode != null && !errCode.hasRecorded()) {
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).launchParams(this.mLaunchParams).infoAdd("detail", errCode.details().toString()));
            errCode.markRecorded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbUpdateFinish(AiAppsDbInfo aiAppsDbInfo) {
        if (APSFlowControlFlag.dbUpdateThenStartAiAppActivity(this.mFlowControlFlag)) {
            LaunchAiApps.doAiAppsStart(this.mContext, this.mLaunchParams, aiAppsDbInfo);
        }
    }

    private synchronized void initAiAppsInfoLatch() {
        if (this.mAiAppsInfoLatch == null) {
            this.mAiAppsInfoLatch = new AiAppsInfoLatch(this.mSaveAiAppsInfoToDbRunnable);
        }
    }

    private com.baidu.b.a.b.b.a buildAppVersionUnMatchErrorInfo() {
        return new com.baidu.b.a.b.b.a(ERRNO_APP_VERSION_NOT_MATCH, ERRMSG_APP_VERSION_NOT_MATCH, TIPMSG_APP_VERSION_NOT_MATCH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUBCStatisticsEnd() {
        AiAppsAPSPerformanceUBC.onDownloadMainStatistics(this.mAppId, APSFlowControlFlag.isAsyncDownloadFlow(this.mFlowControlFlag) ? AiAppsAPSPerformanceUBC.TYPE_MAIN_ASYNC : AiAppsAPSPerformanceUBC.TYPE_MAIN, this.mFlowEventList);
        this.mFlowEventList.clear();
    }
}
