package com.baidu.searchbox.ng.ai.apps.runtime;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.account.AiAppAccount;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.database.subpackage.SubPackageInfoHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsBGAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetwork;
import com.baidu.searchbox.ng.ai.apps.network.AiAppWebSocket;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.process.MsgClientProvider;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.safe.webview.AiAppWebSafe;
import com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting;
import com.baidu.searchbox.ng.ai.apps.storage.AiAppStorage;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes2.dex */
public class AiApp extends ContextWrapper implements MsgClientProvider {
    public static final boolean DEBUG = false;
    public static final String MODEL_TAG = "AiApp";
    private static final String TAG = "AiApp";
    public final String id;
    private AiAppAccount mAccount;
    private Activity mActivity;
    private AiAppsBGAudioPlayer mBackgroundPlayer;
    AiAppsConfigData mConfig;
    private AiAppsLaunchInfo mLaunchInfo;
    private AiAppNetwork mNetwork;
    private AiAppSetting mSetting;
    private AiAppStorage mStorage;
    private AiAppWebSafe mWebSafe;
    private AiAppWebSocket mWebSocket;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Holder {
        private static AiApp sInstance;

        private Holder() {
        }
    }

    @Nullable
    public static AiApp get() {
        return Holder.sInstance;
    }

    public static synchronized void updateAiApp(AiAppsLaunchInfo aiAppsLaunchInfo) {
        synchronized (AiApp.class) {
            if (aiAppsLaunchInfo != null) {
                if (!TextUtils.isEmpty(aiAppsLaunchInfo.mAppId)) {
                    if (Holder.sInstance == null || !aiAppsLaunchInfo.mAppId.equals(Holder.sInstance.id)) {
                        terminate();
                        AiApp unused = Holder.sInstance = new AiApp(aiAppsLaunchInfo.mAppId);
                    }
                    Holder.sInstance.updateLaunchInfo(aiAppsLaunchInfo);
                }
            }
        }
    }

    public static synchronized void terminate() {
        synchronized (AiApp.class) {
            if (Holder.sInstance != null) {
                Holder.sInstance.release();
                AiApp unused = Holder.sInstance = null;
            }
        }
    }

    public void purge() {
        getSetting().clear();
        getStorage().clear();
    }

    private AiApp(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.mWebSafe = new AiAppWebSafe();
        this.mWebSafe.preLoadDataAsync(str);
    }

    public void bindActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void onActivityResume(Activity activity) {
        getSetting().onActivityResume(activity);
    }

    public boolean onBackKeyPressed() {
        return false;
    }

    private void release() {
        AiAppsFileUtils.deleteFile(StorageUtil.getAiappTmpDirectory(getAiAppId()));
        if (this.mBackgroundPlayer != null) {
            this.mBackgroundPlayer.release();
        }
        if (this.mWebSafe != null) {
            this.mWebSafe.release();
        }
        if (this.mWebSocket != null) {
            this.mWebSocket.release();
        }
    }

    public void setConfig(AiAppsConfigData aiAppsConfigData) {
        this.mConfig = aiAppsConfigData;
    }

    public AiAppsConfigData getConfig() {
        return this.mConfig;
    }

    public void updateLaunchInfo(AiAppsLaunchInfo aiAppsLaunchInfo) {
        this.mLaunchInfo = aiAppsLaunchInfo;
    }

    @Nullable
    public AiAppsLaunchInfo getLaunchInfo() {
        return this.mLaunchInfo;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public AiAppStorage getStorage() {
        if (this.mStorage == null) {
            this.mStorage = new AiAppStorage(this);
        }
        return this.mStorage;
    }

    @NonNull
    public AiAppSetting getSetting() {
        if (this.mSetting == null) {
            this.mSetting = new AiAppSetting(this);
        }
        return this.mSetting;
    }

    public AiAppAccount getAccount() {
        if (this.mAccount == null) {
            this.mAccount = new AiAppAccount(this);
        }
        return this.mAccount;
    }

    public AiAppNetwork getNetwork() {
        if (this.mNetwork == null) {
            this.mNetwork = new AiAppNetwork(this);
        }
        return this.mNetwork;
    }

    public AiAppWebSocket getWebSocket() {
        if (this.mWebSocket == null) {
            this.mWebSocket = new AiAppWebSocket();
        }
        return this.mWebSocket;
    }

    public AiAppsBGAudioPlayer getBackgroundPlayer() {
        if (this.mBackgroundPlayer == null) {
            this.mBackgroundPlayer = new AiAppsBGAudioPlayer(this);
        }
        return this.mBackgroundPlayer;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.process.MsgClientProvider
    @Nullable
    public AiAppsMessengerClient getMsgClient() {
        if (this.mActivity instanceof MsgClientProvider) {
            return ((MsgClientProvider) this.mActivity).getMsgClient();
        }
        return null;
    }

    public AiAppMaster getMaster() {
        return null;
    }

    public String getAppKey() {
        return (this.mLaunchInfo == null || TextUtils.isEmpty(this.mLaunchInfo.mAppKey)) ? "" : this.mLaunchInfo.mAppKey;
    }

    @Nullable
    public static String getAiAppId() {
        if (get() == null) {
            return null;
        }
        return get().id;
    }

    public Drawable getIcon() {
        Resources resources = AppRuntime.getAppContext().getResources();
        return (this.mLaunchInfo == null || this.mLaunchInfo.mAppIcon == null) ? resources.getDrawable(R.drawable.icon) : new BitmapDrawable(resources, this.mLaunchInfo.mAppIcon);
    }

    public String getName() {
        return this.mLaunchInfo == null ? "" : this.mLaunchInfo.mAppTitle;
    }

    public String getVersion() {
        return this.mLaunchInfo != null ? this.mLaunchInfo.mVersion : "";
    }

    public static boolean isDataValid() {
        return (get() == null || getAiAppId() == null || get().getLaunchInfo() == null) ? false : true;
    }

    public AiAppWebSafe getWebSafe() {
        if (this.mWebSafe == null) {
            this.mWebSafe = new AiAppWebSafe();
        }
        return this.mWebSafe;
    }

    public boolean isPagesInMainPackage(String str) {
        if (TextUtils.isEmpty(str) || this.mConfig == null || this.mConfig.mPageConfig == null) {
            return false;
        }
        return this.mConfig.mPageConfig.containsPage(str);
    }

    public boolean isSubPackageExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mConfig != null && this.mConfig.mSubPackageList != null && this.mConfig.mSubPackageList.mSubPackagesExistMap != null && this.mConfig.mSubPackageList.mSubPackagesExistMap.containsKey(str)) {
            return this.mConfig.mSubPackageList.mSubPackagesExistMap.get(str).booleanValue();
        }
        boolean isSubPackageExist = SubPackageInfoHelper.getInstance().isSubPackageExist(this.id, getVersion(), str);
        if (isSubPackageExist) {
            updateSubPackageMemaryCache(str, true);
            return isSubPackageExist;
        }
        return isSubPackageExist;
    }

    public void updateSubPackageMemaryCache(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mConfig != null && this.mConfig.mSubPackageList != null && this.mConfig.mSubPackageList.mSubPackagesExistMap != null) {
            this.mConfig.mSubPackageList.mSubPackagesExistMap.put(str, Boolean.valueOf(z));
        }
    }

    public String getPackageName(String str) {
        if (this.mConfig == null || this.mConfig.mSubPackageList == null || this.mConfig.mSubPackageList.mSubPackagesPagesMap == null) {
            return null;
        }
        return this.mConfig.mSubPackageList.mSubPackagesPagesMap.get(str);
    }

    public String getAPSDownloadKey(String str) {
        if (this.mConfig == null || this.mConfig.mSubPackagesPath == null || this.mConfig.mSubPackagesPath.mSubPackagesPathMap == null) {
            return null;
        }
        return this.mConfig.mSubPackagesPath.mSubPackagesPathMap.get(str);
    }

    public String getTargetSwanVersion() {
        return this.mLaunchInfo != null ? this.mLaunchInfo.mTargetSwanVersion : "";
    }

    public boolean isSupportedCoreUpdate() {
        return AiAppsSwanCoreManager.isSupportedCoreUpdate(getTargetSwanVersion());
    }

    public String getHttpRefererVersion() {
        AiAppsLaunchInfo launchInfo = getLaunchInfo();
        return launchInfo != null ? formHttpRefererVersion(launchInfo.mType) : "0";
    }

    private String formHttpRefererVersion(int i) {
        if (i == 0) {
            String str = this.mLaunchInfo != null ? this.mLaunchInfo.versionCode : "";
            if (TextUtils.isEmpty(str)) {
                str = getVersion();
            }
            AiAppsLog.e("AiApp", TextUtils.isEmpty(str) ? " version is empty " : str);
            return str;
        }
        return "0";
    }
}
