package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.b.a.b;
import com.baidu.b.a.c.a.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsErrorActivity;
import com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbControl;
import com.baidu.searchbox.ng.ai.apps.database.AiAppsDbInfo;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.install.decrypt.BundleDecrypt;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.AiAppsLaunchStatusTransfer;
import com.baidu.searchbox.ng.ai.apps.launch.error.LaunchError;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.performance.aps.AiAppsAPSPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppImageUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppSignChecker;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.util.data.SignDataPicker;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.facebook.common.b.f;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchAiApps {
    private static final String AIAPPS_SUFFIX = ".aiapps";
    private static final String AIAPPS_ZIP = "aiapps_zip";
    private static final int COPY_FILE_FAILED = 0;
    private static final boolean DEBUG = false;
    private static final String DO_LAUNCH_AIAPPS = "doLaunchAiApps";
    private static final String ERR_INFO_DECRYPT_FAILED = "decryt failed";
    private static final String ERR_INFO_UNZIP_FAILED = "unzip failed";
    public static final int SUCCESS_CODE = 0;
    private static final String TAG = "LaunchAiApps";
    private static final int ZIP_EXIST = 0;
    private static final int ZIP_NOT_EXIST = 1;

    /* loaded from: classes2.dex */
    public interface DownloadAiAppsIconListener {
        void getIcon(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface UpdateDbListener {
        void dbUpdate(AiAppsDbInfo aiAppsDbInfo);
    }

    @Nullable
    public static ErrCode checkZipSign(a aVar, AiAppsLaunchParams aiAppsLaunchParams) {
        ErrCode errCode;
        try {
            JSONObject jSONObject = new JSONObject(aVar.Zr);
            String optString = jSONObject.optString("sign");
            String optString2 = jSONObject.optString(AiAppsApsUtils.APP_KEY);
            if (!aiAppsLaunchParams.mAppId.contains(optString2)) {
                errCode = new ErrCode().feature(3L).error(13L).detail("local appid different from aps appkey.");
                errCode.detail(aVar.toJSONString());
                Tracer.get().record(errCode);
                AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", errCode.details().toString()).infoAdd("launchAppId", aiAppsLaunchParams.mAppId).infoAdd("apsAppId", optString2));
                errCode.markRecorded();
            } else {
                SignDataPicker signDataPicker = new SignDataPicker();
                aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_SIGN_START_TIMESTAMP, System.currentTimeMillis());
                if (!AiAppSignChecker.checkZipSign(new File(aVar.filePath), optString, signDataPicker)) {
                    errCode = new ErrCode().feature(3L).error(5L).detail("check zip file sign fail.");
                    errCode.detail(aVar.toJSONString());
                    Tracer.get().record(errCode);
                    AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", errCode.details().toString()).infoAdd("serverB64Sign", optString).infoAdd("localSign", signDataPicker.localSign).infoAdd("serverSign", signDataPicker.serverSign));
                    errCode.markRecorded();
                } else {
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_SIGN_END_TIMESTAMP, System.currentTimeMillis());
                    errCode = null;
                }
            }
            return errCode;
        } catch (JSONException e) {
            ErrCode detail = new ErrCode().feature(3L).error(6L).detail("parse extraServer with JSONException: " + e.getMessage());
            detail.detail(aVar.toJSONString());
            Tracer.get().record(detail);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", detail.details().toString()).infoAdd("data", aVar.Zr));
            detail.markRecorded();
            return detail;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean haveAiAppZip(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(getAiAppsZipFolder(), str + ".aiapps").exists();
    }

    @Nullable
    public static ErrCode renameAiAppsZip(@NonNull a aVar) {
        String str = getAiAppsZipFolder() + File.separator + aVar.packageName + ".aiapps";
        AiAppsFileUtils.deleteFile(str);
        File file = new File(str);
        File file2 = new File(aVar.filePath);
        if (file2.renameTo(file)) {
            return null;
        }
        AiAppsFileUtils.deleteFile(file2);
        ErrCode detail = new ErrCode().feature(4L).error(17L).detail("rename zip fail");
        Tracer.get().record(detail);
        return detail;
    }

    @Nullable
    public static ErrCode unZipAiAppBundle(@NonNull a aVar, AiAppsLaunchParams aiAppsLaunchParams) {
        boolean z;
        boolean z2;
        BundleDecrypt.DecryptResult decryptResult;
        File file = new File(getAiAppsZipFolder(), aVar.packageName + ".aiapps");
        if (!file.exists()) {
            ErrCode detail = new ErrCode().feature(4L).error(7L).detail("解压失败：小程序包不存在");
            Tracer.get().record(detail);
            return detail;
        }
        File unzipFolder = AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(aVar.packageName, String.valueOf(aVar.Zn));
        if (unzipFolder.exists()) {
            ErrCode detail2 = new ErrCode().feature(4L).error(7L).detail("解压失败：解压文件夹已存在");
            Tracer.get().record(detail2);
            return detail2;
        } else if (!unzipFolder.mkdirs()) {
            ErrCode detail3 = new ErrCode().feature(4L).error(7L).detail("解压失败：解压文件夹创建失败");
            Tracer.get().record(detail3);
            return detail3;
        } else {
            System.currentTimeMillis();
            BufferedInputStream obtainEncryptedBundle = BundleDecrypt.obtainEncryptedBundle(file);
            if (obtainEncryptedBundle != null) {
                if (aiAppsLaunchParams != null) {
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DECRYPT_START_TIMESTAMP, System.currentTimeMillis());
                }
                z2 = false;
                decryptResult = BundleDecrypt.decrypt(file, unzipFolder, obtainEncryptedBundle);
                z = decryptResult.isSuccess;
                if (aiAppsLaunchParams != null) {
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DECRYPT_END_TIMESTAMP, System.currentTimeMillis());
                }
            } else {
                if (aiAppsLaunchParams != null) {
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_UNZIP_START_TIMESTAMP, System.currentTimeMillis());
                }
                boolean unzipFile = AiAppsFileUtils.unzipFile(file.getPath(), unzipFolder.getPath());
                if (aiAppsLaunchParams != null) {
                    aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_UNZIP_END_TIMESTAMP, System.currentTimeMillis());
                }
                z = unzipFile;
                z2 = true;
                decryptResult = null;
            }
            System.currentTimeMillis();
            if (z) {
                return null;
            }
            ErrCode errCode = new ErrCode();
            if (z2) {
                errCode.feature(4L).error(7L).detail(ERR_INFO_UNZIP_FAILED);
            } else {
                errCode.feature(4L).error(24L).detail("decryt failed:" + (decryptResult == null ? "" : decryptResult.errInfo));
            }
            Tracer.get().record(errCode);
            return errCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getAiAppsZipFolder() {
        return AiAppsBundleHelper.ReleaseBundleHelper.getBundleFolder();
    }

    @SuppressLint({"MobilebdThread"})
    public static void doAiAppsStart(Context context, AiAppsLaunchParams aiAppsLaunchParams, AiAppsDbInfo aiAppsDbInfo) {
        AiAppsLaunchInfo createAiAppsLaunchInfo = createAiAppsLaunchInfo(aiAppsDbInfo, aiAppsLaunchParams);
        if (!AiAppsSpHelper.getsInstance().getBoolean(AiAppsPreloadManager.USED_AIAPPS, false)) {
            AiAppsSpHelper.getsInstance().putBoolean(AiAppsPreloadManager.USED_AIAPPS, true);
        }
        startActivity(context, createAiAppsLaunchInfo);
    }

    public static void updateDbInfo(final Context context, final a aVar, final Bitmap bitmap, final String str, final String str2, final UpdateDbListener updateDbListener) {
        AiAppExecutorUtils.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsDbControl aiAppsDbControl = AiAppsDbControl.getInstance(context);
                int i = LaunchAiApps.haveAiAppZip(aVar.packageName) ? 0 : 1;
                AiAppsDbInfo parseApsInfo = LaunchAiApps.parseApsInfo(aiAppsDbControl.queryAiAppsItem(str), str, aVar, bitmap, i, str2);
                aiAppsDbControl.insertOrUpdateAiAppsDataBase(parseApsInfo);
                LaunchAiApps.updateSubPackageDbInfo(str, String.valueOf(aVar.Zn));
                if (updateDbListener != null) {
                    updateDbListener.dbUpdate(parseApsInfo);
                }
                if (i != 0) {
                    Tracer.get().record(new ErrCode().feature(3L).error(6L).detail("aiapps zip not exist "));
                }
            }
        }, "update AiApp DB");
    }

    public static void updateAiAppsPendingApsErrcode(final Context context, final String str, final int i) {
        AiAppExecutorUtils.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.2
            @Override // java.lang.Runnable
            public void run() {
                AiAppsDbControl.getInstance(context).updateAiAppsPendingErrcode(str, i, true);
            }
        }, "update AiApps PendingApsErrcode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateSubPackageDbInfo(String str, String str2) {
        AiAppsConfigData buildConfigData;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (buildConfigData = AiAppsConfigData.buildConfigData(AiAppsFileUtils.readFileData(new File(AiAppsBundleHelper.ReleaseBundleHelper.getUnzipFolder(str, str2), AiAppsBundleHelper.AI_APPS_CONFIG_FILE)))) != null && buildConfigData.mSubPackageList != null) {
            SubPackageInfoHelper.getInstance().initSubPackageStatus(str, str2, buildConfigData);
        }
    }

    private static AiAppsLaunchInfo createAiAppsLaunchInfo(AiAppsDbInfo aiAppsDbInfo, AiAppsLaunchParams aiAppsLaunchParams) {
        AiAppsLaunchInfo aiAppsLaunchInfo = new AiAppsLaunchInfo();
        if (aiAppsDbInfo == null) {
            return null;
        }
        aiAppsLaunchInfo.mAppTitle = aiAppsDbInfo.name;
        aiAppsLaunchInfo.mAppIcon = AiAppImageUtils.base64ToImg(aiAppsDbInfo.icon, null);
        aiAppsLaunchInfo.mAppIconUrl = aiAppsDbInfo.iconUrl;
        aiAppsLaunchInfo.mAppId = aiAppsLaunchParams.mAppId;
        aiAppsLaunchInfo.mLaunchFrom = aiAppsLaunchParams.mFrom;
        aiAppsLaunchInfo.mPage = aiAppsLaunchParams.mPage;
        aiAppsLaunchInfo.mIsDebug = aiAppsLaunchParams.mIsDebug;
        aiAppsLaunchInfo.mAppKey = aiAppsDbInfo.appKey;
        aiAppsLaunchInfo.mDescription = aiAppsDbInfo.description;
        aiAppsLaunchInfo.mErrorCode = aiAppsDbInfo.errorCode;
        aiAppsLaunchInfo.mErrorDetail = aiAppsDbInfo.errorDetail;
        aiAppsLaunchInfo.mErrorMsg = aiAppsDbInfo.errorMsg;
        aiAppsLaunchInfo.mResumeDate = aiAppsDbInfo.resumeDate;
        aiAppsLaunchInfo.mMaxSwanVersion = aiAppsDbInfo.maxSwanVersion;
        aiAppsLaunchInfo.mMinSwanVersion = aiAppsDbInfo.minSwanVersion;
        aiAppsLaunchInfo.mServiceCategory = aiAppsDbInfo.serviceCategory;
        aiAppsLaunchInfo.mSubjectInfo = aiAppsDbInfo.subjectInfo;
        aiAppsLaunchInfo.mVersion = aiAppsDbInfo.version;
        aiAppsLaunchInfo.mExtraData = aiAppsLaunchParams.mExtraData;
        aiAppsLaunchInfo.mLaunchScheme = aiAppsLaunchParams.mLaunchScheme;
        aiAppsLaunchInfo.mType = aiAppsDbInfo.type;
        aiAppsLaunchInfo.mNotInHistory = aiAppsLaunchParams.mNotInHistory;
        aiAppsLaunchInfo.mAppOpenUrl = aiAppsDbInfo.appOpenUrl;
        aiAppsLaunchInfo.mAppDownloadUrl = aiAppsDbInfo.appDownloadUrl;
        aiAppsLaunchInfo.mTargetSwanVersion = aiAppsDbInfo.targetSwanVersion;
        aiAppsLaunchInfo.mSwanCoreVersion = aiAppsLaunchParams.mSwanCoreVersion;
        aiAppsLaunchInfo.mAppZipSize = aiAppsDbInfo.mAppZipSize;
        aiAppsLaunchInfo.versionCode = aiAppsDbInfo.versionCode;
        return aiAppsLaunchInfo;
    }

    private static AiAppsDbInfo getAiAppsInfoFromDataBase(Context context, String str) {
        return AiAppsDbControl.getInstance(context).queryAiAppsItem(str);
    }

    private static void startAiAppsActivity(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        AiAppsLauncherActivity.startAiApps(context, aiAppsLaunchInfo);
    }

    private static void startAiAppsErrorActivity(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        Intent createErrorPagesLaunchIntent = AiAppsLaunchInfo.createErrorPagesLaunchIntent(context, aiAppsLaunchInfo);
        if (createErrorPagesLaunchIntent != null) {
            createErrorPagesLaunchIntent.setComponent(new ComponentName(context, AiAppsErrorActivity.class));
            context.startActivity(createErrorPagesLaunchIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AiAppsDbInfo parseApsInfo(@Nullable AiAppsDbInfo aiAppsDbInfo, @NonNull String str, @Nullable a aVar, Bitmap bitmap, int i, String str2) {
        AiAppsDbInfo aiAppsDbInfo2 = (aiAppsDbInfo == null || !TextUtils.equals(str, aiAppsDbInfo.appId)) ? new AiAppsDbInfo() : aiAppsDbInfo;
        if (aVar != null) {
            aiAppsDbInfo2.version = String.valueOf(aVar.Zn);
            aiAppsDbInfo2.mAppZipSize = aVar.Zw;
            try {
                JSONObject jSONObject = new JSONObject(aVar.Zr);
                aiAppsDbInfo2.appId = str;
                aiAppsDbInfo2.name = aVar.name;
                aiAppsDbInfo2.description = jSONObject.optString("description");
                aiAppsDbInfo2.appKey = jSONObject.optString(AiAppsApsUtils.APP_KEY);
                aiAppsDbInfo2.errorCode = jSONObject.optInt("error_code");
                aiAppsDbInfo2.errorDetail = jSONObject.optString(AiAppsApsUtils.ERROR_DETAIL);
                aiAppsDbInfo2.errorMsg = jSONObject.optString("error_msg");
                aiAppsDbInfo2.maxSwanVersion = jSONObject.optString(AiAppsApsUtils.MAX_SWAN_VERSION);
                aiAppsDbInfo2.minSwanVersion = jSONObject.optString(AiAppsApsUtils.MIN_SWAN_VERSION);
                aiAppsDbInfo2.type = jSONObject.optInt("type");
                aiAppsDbInfo2.sign = jSONObject.optString("sign");
                aiAppsDbInfo2.resumeDate = jSONObject.optString(AiAppsApsUtils.RESUME_DATE);
                aiAppsDbInfo2.serviceCategory = jSONObject.optString(AiAppsApsUtils.SERVICE_CATEGORY);
                aiAppsDbInfo2.subjectInfo = jSONObject.optString(AiAppsApsUtils.SUBJECT_INFO);
                aiAppsDbInfo2.icon = AiAppImageUtils.encodeBitmapAsString(bitmap);
                aiAppsDbInfo2.iconUrl = str2;
                aiAppsDbInfo2.isHaveZip = i;
                aiAppsDbInfo2.version = String.valueOf(aVar.Zn);
                aiAppsDbInfo2.targetSwanVersion = jSONObject.optString(AiAppsApsUtils.TARGET_SWAN_VERSION);
                aiAppsDbInfo2.versionCode = jSONObject.optString("version_code");
                JSONObject optJSONObject = jSONObject.optJSONObject(AiAppsApsUtils.SWAN_CONF);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(AiAppsApsUtils.CALL_APP_CONFIG);
                    if (optJSONObject2 != null) {
                        aiAppsDbInfo2.appOpenUrl = optJSONObject2.optString(AiAppsApsUtils.APP_OPEN_URL);
                        aiAppsDbInfo2.appDownloadUrl = optJSONObject2.optString("download_url");
                    }
                    WebSafeWhiteListMgr.saveWebDomains(aiAppsDbInfo2.appId, "", optJSONObject.optJSONArray(AiAppsApsUtils.WEB_VIEW_DOMAINS));
                    WebSafeWhiteListMgr.saveWebActions("", optJSONObject.optJSONArray(AiAppsApsUtils.WEB_ACTION));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aiAppsDbInfo2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launchAiAppsByLocal(Context context, AiAppsLaunchParams aiAppsLaunchParams, @Nullable ErrCode errCode) {
        AiAppsLaunchInfo createLaunchAiAppsDataByLocal = createLaunchAiAppsDataByLocal(context, aiAppsLaunchParams, errCode);
        if (createLaunchAiAppsDataByLocal != null) {
            startActivity(context, createLaunchAiAppsDataByLocal);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launchAiAppsByLocal(Context context, AiAppsLaunchParams aiAppsLaunchParams, AiAppsDbInfo aiAppsDbInfo, boolean z) {
        if (aiAppsDbInfo == null || TextUtils.isEmpty(aiAppsDbInfo.appId)) {
            AiAppsLaunchStatusTransfer.getInstance().onLaunchFailed();
            ErrCode detail = new ErrCode().feature(4L).error(3L).detail("no aiapps info in database");
            Tracer.get().record(detail);
            launchAiAppsByLocalFailed(context, aiAppsLaunchParams.mAppId, aiAppsLaunchParams.mFrom, detail);
            return;
        }
        startActivity(context, createAiAppsLaunchInfo(aiAppsDbInfo, aiAppsLaunchParams));
    }

    private static AiAppsLaunchInfo createLaunchAiAppsDataByLocal(Context context, AiAppsLaunchParams aiAppsLaunchParams, @Nullable ErrCode errCode) {
        if (errCode != null && errCode.error() == 1104) {
            launchUpdateInfoPage(context, aiAppsLaunchParams.mAppId, errCode);
            AiAppsLaunchStatusTransfer.getInstance().onLaunchFailed();
            if (!errCode.hasRecorded()) {
                AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).appId(aiAppsLaunchParams.mAppId).source(aiAppsLaunchParams.mFrom).infoAdd("detail", errCode.details().toString()));
                errCode.markRecorded();
            }
            AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
            aiAppsUBCEvent.mAppId = aiAppsLaunchParams.mAppId;
            aiAppsUBCEvent.mSource = aiAppsLaunchParams.mFrom;
            aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_LAUNCH;
            aiAppsUBCEvent.mValue = "fail";
            aiAppsUBCEvent.mExt = AiAppsUBCStatistic.genJSONObject(AiAppsUBCStatistic.EXT_KEY_ERRCODE, String.valueOf(errCode.code()));
            AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
            return null;
        }
        AiAppsDbInfo aiAppsInfoFromDataBase = getAiAppsInfoFromDataBase(context, aiAppsLaunchParams.mAppId);
        if (aiAppsInfoFromDataBase == null || TextUtils.isEmpty(aiAppsInfoFromDataBase.appId)) {
            if (errCode == null) {
                errCode = new ErrCode().feature(4L).error(3L).detail("no aiapps info in database");
                Tracer.get().record(errCode);
            }
            launchAiAppsByLocalFailed(context, aiAppsLaunchParams.mAppId, aiAppsLaunchParams.mFrom, errCode);
            AiAppsLaunchStatusTransfer.getInstance().onLaunchFailed();
            return null;
        }
        return createAiAppsLaunchInfo(aiAppsInfoFromDataBase, aiAppsLaunchParams);
    }

    private static void launchAiAppsByLocalFailed(Context context, String str, String str2, ErrCode errCode) {
        if (errCode == null) {
            errCode = new ErrCode().feature(4L).error(3L).detail("no aiapps info in database");
            Tracer.get().record(errCode);
        }
        if (errCode.error() == 1104) {
            launchUpdateInfoPage(context, str, errCode);
        } else {
            LaunchError.showErrorDialog(context, errCode);
        }
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mAppId = str;
        aiAppsUBCEvent.mSource = str2;
        aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_LAUNCH;
        aiAppsUBCEvent.mValue = "fail";
        aiAppsUBCEvent.mExt = AiAppsUBCStatistic.genJSONObject(AiAppsUBCStatistic.EXT_KEY_ERRCODE, String.valueOf(errCode.code()));
        AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
        if (!errCode.hasRecorded()) {
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(errCode.code())).appId(str).source(str2).infoAdd("detail", errCode.details().toString()));
            errCode.markRecorded();
        }
        AiAppsSpHelper.getsInstance().putLong(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launchAiAppsByAps(@NonNull Context context, @NonNull AiAppsLaunchParams aiAppsLaunchParams, int i) {
        aiAppsLaunchParams.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_START_TIMESTAMP, System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AiAppsDynamicCallback(context, aiAppsLaunchParams, i));
        b.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.e.a.a(context, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        com.baidu.b.a.e.a.c(arrayList, true);
    }

    private static void startActivity(Context context, AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (aiAppsLaunchInfo.mErrorCode == 0) {
            startAiAppsActivity(context, aiAppsLaunchInfo);
            return;
        }
        AiAppsLaunchStatusTransfer.getInstance().onLaunchFailed();
        startAiAppsErrorActivity(context, aiAppsLaunchInfo);
    }

    public static void downloadAiAppsIconByFresco(String str, DownloadAiAppsIconListener downloadAiAppsIconListener) {
        downloadAiAppsIconByFresco(str, null, downloadAiAppsIconListener);
    }

    public static void downloadAiAppsIconByFresco(String str, final AiAppsLaunchParams aiAppsLaunchParams, final DownloadAiAppsIconListener downloadAiAppsIconListener) {
        Uri uri = AiAppsUtils.getUri(str);
        if (uri == null) {
            ErrCode detail = new ErrCode().feature(4L).error(10L).detail("download icon fail: icon url is null");
            Tracer.get().record(detail);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", detail.details().toString()));
            downloadAiAppsIconListener.getIcon(null);
            return;
        }
        c.bSw().e(ImageRequestBuilder.F(uri).bYr(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.searchbox.ng.ai.apps.core.aps.LaunchAiApps.3
            @Override // com.facebook.imagepipeline.e.b
            protected void onNewResultImpl(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        DownloadAiAppsIconListener.this.getIcon(copy);
                    } catch (Exception e) {
                        ErrCode detail2 = new ErrCode().feature(4L).error(10L).detail("download icon fail: " + e.getMessage());
                        Tracer.get().record(detail2);
                        AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail2.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", detail2.details().toString()));
                        DownloadAiAppsIconListener.this.getIcon(null);
                    }
                }
            }

            @Override // com.facebook.datasource.a
            protected void onFailureImpl(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                ErrCode detail2 = new ErrCode().feature(4L).error(10L).detail("download icon fail: onFailureImpl");
                Tracer.get().record(detail2);
                AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail2.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", detail2.details().toString()));
                DownloadAiAppsIconListener.this.getIcon(null);
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void onCancellation(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                super.onCancellation(bVar);
                ErrCode detail2 = new ErrCode().feature(4L).error(10L).detail("download icon fail: onCancellation");
                Tracer.get().record(detail2);
                AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail2.code())).launchParams(aiAppsLaunchParams).infoAdd("detail", detail2.details().toString()));
                DownloadAiAppsIconListener.this.getIcon(null);
            }
        }, f.bRz());
    }

    private static void launchUpdateInfoPage(Context context, String str, ErrCode errCode) {
        SchemeRouter.invokeScheme(context, Uri.parse("baiduboxapp://v1/easybrowse/open?url=" + (AiAppsRuntime.getConfigRuntime().getLowVersionUpgradePageUrl() + "?appKey=" + str + "&code=" + errCode.error()) + "&forbidautorotate=1"), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
    }

    public static List<UbcFlowEvent> generateUBCEventFormLaunchParams(AiAppsLaunchParams aiAppsLaunchParams) {
        if (aiAppsLaunchParams == null || aiAppsLaunchParams.mExtraData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_SIGN_START_TIMESTAMP, AiAppsAPSPerformanceUBC.APS_START_CHECK_SIGN));
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_CHECK_SIGN_END_TIMESTAMP, AiAppsAPSPerformanceUBC.APS_END_CHECK_SIGN));
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_UNZIP_START_TIMESTAMP, AiAppsAPSPerformanceUBC.PACKAGE_START_UNZIP));
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_UNZIP_END_TIMESTAMP, AiAppsAPSPerformanceUBC.PACKAGE_END_UNZIP));
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DECRYPT_START_TIMESTAMP, AiAppsAPSPerformanceUBC.PACKAGE_START_DECRYPT));
        arrayList.add(AiAppsAPSPerformanceUBC.generateUBCEventFormBundle(aiAppsLaunchParams.mExtraData, AiAppsPerformanceUBC.EXTRA_AIAPP_APS_DECRYPT_END_TIMESTAMP, AiAppsAPSPerformanceUBC.PACKAGE_END_DECRYPT));
        return arrayList;
    }
}
