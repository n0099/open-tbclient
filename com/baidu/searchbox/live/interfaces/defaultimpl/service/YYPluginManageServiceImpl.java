package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import alaim.AlaMgetLiveStatus.DataReq;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskProgressListener;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.interaction.cloudcontrol.ccs.InteractionPrivacySwitch;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginInstallCallback;
import com.baidu.searchbox.live.nps.LiveMediaPluginManager;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.searchbox.ui.state.StateManager;
import com.baidu.tieba.cg1;
import com.baidu.tieba.hf1;
import com.baidu.tieba.jf1;
import com.baidu.tieba.kf1;
import com.baidu.tieba.mf1;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\bF\u0010GJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u001aJ#\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020$0#2\u0006\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010)J\u001f\u0010,\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010+\u001a\u00020$H\u0016¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b4\u00105JC\u00108\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022*\u00107\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b06H\u0002¢\u0006\u0004\b8\u00109R\u001e\u0010<\u001a\n ;*\u0004\u0018\u00010:0:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010D\u001a\n ;*\u0004\u0018\u00010C0C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "", "pluginPackageName", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "isRetry", "", "dispatchDownloadSuccess", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;Z)V", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;", "downloadBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "packageName", "url", "path", "fileName", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "bundlePath", "hookHostAssets", "(Ljava/lang/String;)Z", "Landroid/content/res/Resources;", "hostResources", "hookResources", "(Landroid/content/res/Resources;Ljava/lang/String;)Z", "installBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;)V", "apkPath", "installPluginApk", "Lkotlin/Pair;", "", "installPluginApkWithCode", "(Ljava/lang/String;)Lkotlin/Pair;", "msg", LocalFilesFilterKt.FILTER_NAME_LOG, "(Ljava/lang/String;)V", "logD", "bundleType", "resetBundleType", "(Ljava/lang/String;I)V", "Lcom/baidu/nps/pm/BundleInfoGroup;", "group", "transBundleGroup", "(Lcom/baidu/nps/pm/BundleInfoGroup;)Landroid/util/SparseArray;", "Lcom/baidu/nps/pm/BundleInfo;", StateManager.KEY_STATE, "transBundleInfo", "(Lcom/baidu/nps/pm/BundleInfo;)Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "Lkotlin/Function4;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "transPackagePath", "(Ljava/lang/String;Lkotlin/Function4;)V", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appService", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "delayCount", "I", "Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "yalogApi", "Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "Lcom/baidu/searchbox/live/interfaces/service/LiveYalogService;", "yalogService", "Lcom/baidu/searchbox/live/interfaces/service/LiveYalogService;", "<init>", "()V", "Companion", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class YYPluginManageServiceImpl implements YYPluginManageService {
    public static final String BD_LIVE_CREATE_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1616394905587.png";
    public static final String BD_LIVE_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1601198043514.png";
    public static final Companion Companion = new Companion(null);
    public static final int INSTALL_ERR_PREPARE_ERROR = -111;
    public static final String MEDIA_MAIN_PACKAGE_NAME = "com.baidu.searchbox.livenps";
    public static final String YY_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1608868898198.png";
    public static final String YY_MAIN_PACKAGE_NAME = "com.baidu.searchbox.yylive.entrance";
    public final AppInfoService appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
    public int delayCount;
    public final LiveYalogApi yalogApi;
    public final LiveYalogService yalogService;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl$Companion;", "", "BD_LIVE_CREATE_ICON_URL", "Ljava/lang/String;", "BD_LIVE_ICON_URL", "", "INSTALL_ERR_PREPARE_ERROR", "I", "MEDIA_MAIN_PACKAGE_NAME", "YY_ICON_URL", "YY_MAIN_PACKAGE_NAME", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YYPluginManageServiceImpl() {
        LiveYalogApi liveYalogApi;
        LiveYalogService liveYalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogService = liveYalogService;
        if (liveYalogService != null) {
            liveYalogApi = liveYalogService.buildYalogApi("live_plugin");
        } else {
            liveYalogApi = null;
        }
        this.yalogApi = liveYalogApi;
        this.delayCount = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        LiveYalogApi liveYalogApi = this.yalogApi;
        if (liveYalogApi != null) {
            liveYalogApi.i("3036", "live-com-installer", "YYPluginManageServiceImpl:  " + str);
            return;
        }
        Log.e("live-com-installer", "YYPluginManageServiceImpl:  " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logD(String str) {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null && appInfoService.isDebug()) {
            Log.e("live-com-installer", "YYPluginManageServiceImpl:  " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YYPluginBundleInfo transBundleInfo(BundleInfo bundleInfo) {
        if (bundleInfo == null) {
            return null;
        }
        String packageName = bundleInfo.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "bundle.packageName");
        return new YYPluginBundleInfo(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public SparseArray<YYPluginBundleInfo> getPluginBundleInfo(String str) {
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
        if (bundleGroup != null) {
            return transBundleGroup(bundleGroup);
        }
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean hookHostAssets(String str) {
        Application applicationContext = ContextHolder.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "ContextHolder.getApplicationContext()");
        return ResourcesHookUtil.hookAssets(applicationContext.getAssets(), str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void downloadBundle(final String str, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        NPSPackageManager.getInstance().downloadUpdatePackage(str, new hf1() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadBundle$1
            @Override // com.baidu.tieba.hf1
            public void onProgress(long j, long j2) {
                YYPluginDownloadCallback yYPluginDownloadCallback2 = YYPluginDownloadCallback.this;
                if (yYPluginDownloadCallback2 != null) {
                    yYPluginDownloadCallback2.onProgress(str, j, j2);
                }
            }

            @Override // com.baidu.tieba.hf1
            public void onResult(int i, String str2) {
                boolean z;
                YYPluginDownloadCallback yYPluginDownloadCallback2 = YYPluginDownloadCallback.this;
                if (yYPluginDownloadCallback2 != null) {
                    String str3 = str;
                    if (i == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    yYPluginDownloadCallback2.onResult(str3, z, str2);
                }
            }
        }, new jf1() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadBundle$2
            @Override // com.baidu.tieba.jf1
            public final void checkAuthorization(IBundleInfo iBundleInfo, int i, kf1 kf1Var) {
                kf1Var.onResult(1);
            }
        }, 1);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean hookResources(Resources resources, String str) {
        return ResourcesHookUtil.hookResources(resources, str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void installBundle(final String str, final YYPluginInstallCallback yYPluginInstallCallback) {
        NPSPackageManager.getInstance().downloadBundle(str, new hf1() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installBundle$1
            @Override // com.baidu.tieba.hf1
            public void onProgress(long j, long j2) {
                yYPluginInstallCallback.onProgress(str, j, j2);
            }

            @Override // com.baidu.tieba.hf1
            public void onResult(int i, String str2) {
                if (i == 2) {
                    YYPluginManageServiceImpl.dispatchDownloadSuccess$default(YYPluginManageServiceImpl.this, str, yYPluginInstallCallback, false, 4, null);
                } else {
                    yYPluginInstallCallback.onError(str, i, str2);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void resetBundleType(String str, int i) {
        log("resetBundleType, packagename " + str + ", type = " + i);
        mf1.j().s(NPSPackageManager.getInstance().getBundleGroup(str).getBundleByType(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchDownloadSuccess(final String str, final YYPluginInstallCallback yYPluginInstallCallback, boolean z) {
        if (z) {
            ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$dispatchDownloadSuccess$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    int i5;
                    YYPluginBundleInfo transBundleInfo;
                    int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
                    if (prepareBundle != 41) {
                        YYPluginManageServiceImpl yYPluginManageServiceImpl = YYPluginManageServiceImpl.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("isRetry: true, ");
                        i = YYPluginManageServiceImpl.this.delayCount;
                        sb.append(i);
                        yYPluginManageServiceImpl.logD(sb.toString());
                        i2 = YYPluginManageServiceImpl.this.delayCount;
                        if (i2 <= 3) {
                            YYPluginManageServiceImpl yYPluginManageServiceImpl2 = YYPluginManageServiceImpl.this;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("isRetry: true, ");
                            i4 = YYPluginManageServiceImpl.this.delayCount;
                            sb2.append(i4);
                            sb2.append("   dispatch");
                            yYPluginManageServiceImpl2.logD(sb2.toString());
                            YYPluginManageServiceImpl.this.dispatchDownloadSuccess(str, yYPluginInstallCallback, true);
                        } else {
                            YYPluginManageServiceImpl yYPluginManageServiceImpl3 = YYPluginManageServiceImpl.this;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("isRetry: true, ");
                            i3 = YYPluginManageServiceImpl.this.delayCount;
                            sb3.append(i3);
                            sb3.append("   onError");
                            yYPluginManageServiceImpl3.log(sb3.toString());
                            YYPluginManageServiceImpl.this.delayCount = 1;
                            YYPluginInstallCallback yYPluginInstallCallback2 = yYPluginInstallCallback;
                            String str2 = str;
                            yYPluginInstallCallback2.onError(str2, -111, "prepare Code " + prepareBundle);
                        }
                    } else {
                        YYPluginManageServiceImpl.this.delayCount = 1;
                        transBundleInfo = YYPluginManageServiceImpl.this.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(str));
                        if (transBundleInfo == null) {
                            yYPluginInstallCallback.onError(str, -100, "transform error");
                        } else {
                            yYPluginInstallCallback.onLoaded(transBundleInfo);
                        }
                    }
                    YYPluginManageServiceImpl yYPluginManageServiceImpl4 = YYPluginManageServiceImpl.this;
                    i5 = yYPluginManageServiceImpl4.delayCount;
                    yYPluginManageServiceImpl4.delayCount = i5 + 1;
                }
            }, "live_nps_install", 0, this.delayCount * 100);
            return;
        }
        this.delayCount = 1;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$dispatchDownloadSuccess$2
            @Override // java.lang.Runnable
            public final void run() {
                YYPluginBundleInfo transBundleInfo;
                int prepareBundle = NPSPackageManager.getInstance().prepareBundle(str);
                if (prepareBundle == 41) {
                    transBundleInfo = YYPluginManageServiceImpl.this.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(str));
                    if (transBundleInfo == null) {
                        yYPluginInstallCallback.onError(str, -100, "transform error");
                    } else {
                        yYPluginInstallCallback.onLoaded(transBundleInfo);
                    }
                } else if (prepareBundle != 44) {
                    YYPluginInstallCallback yYPluginInstallCallback2 = yYPluginInstallCallback;
                    String str2 = str;
                    yYPluginInstallCallback2.onError(str2, -111, "prepare Code " + prepareBundle);
                } else {
                    YYPluginManageServiceImpl.this.dispatchDownloadSuccess(str, yYPluginInstallCallback, true);
                }
            }
        }, "live_nps_install", 0);
    }

    public static /* synthetic */ void dispatchDownloadSuccess$default(YYPluginManageServiceImpl yYPluginManageServiceImpl, String str, YYPluginInstallCallback yYPluginInstallCallback, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        yYPluginManageServiceImpl.dispatchDownloadSuccess(str, yYPluginInstallCallback, z);
    }

    private final SparseArray<YYPluginBundleInfo> transBundleGroup(BundleInfoGroup bundleInfoGroup) {
        SparseArray<YYPluginBundleInfo> sparseArray = new SparseArray<>();
        try {
            sparseArray.append(1, transBundleInfo(bundleInfoGroup.getBundleByType(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sparseArray.append(2, transBundleInfo(bundleInfoGroup.getBundleByType(2)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            sparseArray.append(3, transBundleInfo(bundleInfoGroup.getBundleByType(3)));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return sparseArray;
    }

    private final void transPackagePath(String str, Function4<? super String, ? super String, ? super String, ? super String, Unit> function4) {
        String str2;
        String str3;
        DataReq.Builder builder = null;
        builder = null;
        boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "entrance", false, 2, (Object) null);
        String str4 = BD_LIVE_CREATE_ICON_URL;
        String str5 = "com.baidu.searchbox.yylive.entrance";
        if (contains$default) {
            str2 = "yy直播入口一级插件";
            str4 = YY_ICON_URL;
        } else {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "minilib", false, 2, (Object) null)) {
                str2 = "yy直播极小包插件";
                str3 = "com.baidu.searchbox.yylive.minilib";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "extlib", false, 2, (Object) null)) {
                str2 = "yy直播扩展库插件";
                str3 = "com.baidu.searchbox.yylive.extlib";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) NpsLoadChainLog.PAGE, false, 2, (Object) null)) {
                str2 = "yy直播直播间二级插件";
                str3 = YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1;
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) InteractionPrivacySwitch.MODULE, false, 2, (Object) null)) {
                str2 = "yy直播玩法二级插件";
                str3 = YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2;
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.yylib", false, 2, (Object) null)) {
                str2 = "YY业务基础库二级插件";
                str3 = LiveYYPluginManager.YY_NPS_YYLIB_PKG_NAME;
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.game", false, 2, (Object) null)) {
                str2 = "yy游戏直播";
                str3 = "com.baidu.searchbox.yylive.game";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.createlive", false, 2, (Object) null)) {
                str2 = "yy开播";
                str3 = "com.baidu.searchbox.yylive.createlive";
            } else {
                if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "bjhlivenps", false, 2, (Object) null)) {
                    str2 = "媒体直播开播插件";
                    str5 = LiveMediaPluginManager.BJH_PLUGIN_PKG_NAME;
                } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "media.business", false, 2, (Object) null)) {
                    str2 = "媒体直播业务二级插件";
                    str5 = "com.baidu.live.media.business";
                } else {
                    str5 = "";
                    str2 = "直播插件";
                    str4 = BD_LIVE_ICON_URL;
                }
                builder = "com.baidu.searchbox.livenps";
            }
            builder = "com.baidu.searchbox.yylive.entrance";
            str4 = YY_ICON_URL;
            str5 = str3;
        }
        function4.invoke(str2, str4, builder, str5);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void downloadFile(final String str, String str2, final String str3, final String str4, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        new DownloadTask.Builder(str2, str3, str4).setPassIfAlreadyCompleted(true).build().enqueue(new DownloadTaskProgressListener() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadFile$1
            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void connected(DownloadTask downloadTask, int i, long j, long j2) {
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause) {
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void taskStart(DownloadTask downloadTask, TaskProgressListenerAssist.Listener1Model listener1Model) {
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, TaskProgressListenerAssist.Listener1Model listener1Model) {
                File file = new File(str3, str4);
                if (endCause == EndCause.COMPLETED && file.exists()) {
                    YYPluginDownloadCallback yYPluginDownloadCallback2 = yYPluginDownloadCallback;
                    if (yYPluginDownloadCallback2 != null) {
                        yYPluginDownloadCallback2.onResult(str, true, "");
                        return;
                    }
                    return;
                }
                YYPluginDownloadCallback yYPluginDownloadCallback3 = yYPluginDownloadCallback;
                if (yYPluginDownloadCallback3 != null) {
                    yYPluginDownloadCallback3.onResult(str, false, "download failed");
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void progress(DownloadTask downloadTask, long j, long j2) {
                YYPluginDownloadCallback yYPluginDownloadCallback2 = yYPluginDownloadCallback;
                if (yYPluginDownloadCallback2 != null) {
                    yYPluginDownloadCallback2.onProgress(str, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean installPluginApk(String str) {
        boolean z;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = "";
        transPackagePath(str, new Function4<String, String, String, String, Unit>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installPluginApk$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3, String str4, String str5) {
                invoke2(str2, str3, str4, str5);
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2, String str3, String str4, String str5) {
                Ref.ObjectRef.this.element = str2;
                objectRef2.element = str3;
                objectRef3.element = str4;
                objectRef4.element = str5;
            }
        });
        if (!new File(str).exists()) {
            if (((String) objectRef4.element).length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                log("apk file not exist, try reset bundle status in db");
                mf1.j().s(NPSPackageManager.getInstance().getBundleGroup((String) objectRef4.element).getBundleByType(2));
                return false;
            }
        }
        PackageInfo a = cg1.a(str, 128);
        if (a == null) {
            return false;
        }
        BundleInfo bundleInfo = new BundleInfo();
        bundleInfo.setName((String) objectRef.element);
        bundleInfo.setIconUrl((String) objectRef2.element);
        bundleInfo.setApkPath(str);
        bundleInfo.setPackageName(a.packageName);
        bundleInfo.setVersionCode(a.versionCode);
        if (!TextUtils.isEmpty((String) objectRef3.element)) {
            bundleInfo.setMainBundle((String) objectRef3.element);
        }
        int installLocalBundle = NPSPackageManager.getInstance().installLocalBundle(bundleInfo);
        log("bundleInfo.packageName = " + bundleInfo.getPackageName() + ", bundleInfo.versionCode = " + bundleInfo.getVersionCode() + ", installRetCode = " + installLocalBundle);
        if (installLocalBundle == 13) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public Pair<Boolean, Integer> installPluginApkWithCode(String str) {
        boolean z;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = "";
        transPackagePath(str, new Function4<String, String, String, String, Unit>() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installPluginApkWithCode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3, String str4, String str5) {
                invoke2(str2, str3, str4, str5);
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.String */
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2, String str3, String str4, String str5) {
                Ref.ObjectRef.this.element = str2;
                objectRef2.element = str3;
                objectRef3.element = str4;
                objectRef4.element = str5;
            }
        });
        boolean z2 = true;
        if (!new File(str).exists()) {
            if (((String) objectRef4.element).length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                log("apk file not exist, try reset bundle status in db");
                mf1.j().s(NPSPackageManager.getInstance().getBundleGroup((String) objectRef4.element).getBundleByType(2));
                return TuplesKt.to(Boolean.FALSE, -1001);
            }
        }
        PackageInfo a = cg1.a(str, 128);
        if (a != null) {
            BundleInfo bundleInfo = new BundleInfo();
            bundleInfo.setName((String) objectRef.element);
            bundleInfo.setIconUrl((String) objectRef2.element);
            bundleInfo.setApkPath(str);
            bundleInfo.setPackageName(a.packageName);
            bundleInfo.setVersionCode(a.versionCode);
            if (!TextUtils.isEmpty((String) objectRef3.element)) {
                bundleInfo.setMainBundle((String) objectRef3.element);
            }
            int installLocalBundle = NPSPackageManager.getInstance().installLocalBundle(bundleInfo);
            log("bundleInfo.packageName = " + bundleInfo.getPackageName() + ", bundleInfo.versionCode = " + bundleInfo.getVersionCode() + ", installRetCode = " + installLocalBundle);
            if (installLocalBundle != 13) {
                z2 = false;
            }
            return TuplesKt.to(Boolean.valueOf(z2), Integer.valueOf(installLocalBundle));
        }
        return TuplesKt.to(Boolean.FALSE, -1002);
    }
}
