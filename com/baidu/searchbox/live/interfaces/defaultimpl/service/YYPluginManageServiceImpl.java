package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskProgressListener;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginInstallCallback;
import com.baidu.tieba.t91;
import com.baidu.tieba.y81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b<\u0010=J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010%J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.R\u001e\u00101\u001a\n 0*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010:\u001a\n 0*\u0004\u0018\u000109098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "", "pluginPackageName", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "isRetry", "", "dispatchDownloadSuccess", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;Z)V", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;", "downloadBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "packageName", "url", "path", "fileName", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "bundlePath", "hookHostAssets", "(Ljava/lang/String;)Z", "Landroid/content/res/Resources;", "hostResources", "hookResources", "(Landroid/content/res/Resources;Ljava/lang/String;)Z", "installBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;)V", "apkPath", "installPluginApk", "msg", "log", "(Ljava/lang/String;)V", "logD", "Lcom/baidu/nps/pm/BundleInfoGroup;", "group", "transBundleGroup", "(Lcom/baidu/nps/pm/BundleInfoGroup;)Landroid/util/SparseArray;", "Lcom/baidu/nps/pm/BundleInfo;", "bundle", "transBundleInfo", "(Lcom/baidu/nps/pm/BundleInfo;)Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appService", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "", "delayCount", "I", "Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "yalogApi", "Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "Lcom/baidu/searchbox/live/interfaces/service/LiveYalogService;", "yalogService", "Lcom/baidu/searchbox/live/interfaces/service/LiveYalogService;", "<init>", "()V", "Companion", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYPluginManageServiceImpl implements YYPluginManageService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BD_LIVE_CREATE_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1616394905587.png";
    public static final String BD_LIVE_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1601198043514.png";
    public static final Companion Companion;
    public static final int INSTALL_ERR_PREPARE_ERROR = -111;
    public static final String MEDIA_MAIN_PACKAGE_NAME = "com.baidu.searchbox.livenps";
    public static final String YY_ICON_URL = "http://bos.box.bdimg.com/searchbox/aps/1608868898198.png";
    public static final String YY_MAIN_PACKAGE_NAME = "com.baidu.searchbox.yylive.entrance";
    public transient /* synthetic */ FieldHolder $fh;
    public final AppInfoService appService;
    public int delayCount;
    public final LiveYalogApi yalogApi;
    public final LiveYalogService yalogService;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl$Companion;", "", "BD_LIVE_CREATE_ICON_URL", "Ljava/lang/String;", "BD_LIVE_ICON_URL", "", "INSTALL_ERR_PREPARE_ERROR", "I", "MEDIA_MAIN_PACKAGE_NAME", "YY_ICON_URL", "YY_MAIN_PACKAGE_NAME", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721673934, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721673934, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public YYPluginManageServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        LiveYalogService liveYalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogService = liveYalogService;
        this.yalogApi = liveYalogService != null ? liveYalogService.buildYalogApi("live_plugin") : null;
        this.delayCount = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchDownloadSuccess(final String str, final YYPluginInstallCallback yYPluginInstallCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, this, str, yYPluginInstallCallback, z) == null) {
            if (z) {
                ExecutorUtilsExt.delayPostOnElastic(new Runnable(this, str, yYPluginInstallCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$dispatchDownloadSuccess$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ YYPluginInstallCallback $callback;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $pluginPackageName;
                    public final /* synthetic */ YYPluginManageServiceImpl this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, yYPluginInstallCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$pluginPackageName = str;
                        this.$callback = yYPluginInstallCallback;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i;
                        int i2;
                        int i3;
                        int i4;
                        int i5;
                        YYPluginBundleInfo transBundleInfo;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.$pluginPackageName);
                            if (prepareBundle == 41) {
                                this.this$0.delayCount = 1;
                                transBundleInfo = this.this$0.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(this.$pluginPackageName));
                                if (transBundleInfo == null) {
                                    this.$callback.onError(this.$pluginPackageName, -100, "transform error");
                                } else {
                                    this.$callback.onLoaded(transBundleInfo);
                                }
                            } else {
                                YYPluginManageServiceImpl yYPluginManageServiceImpl = this.this$0;
                                StringBuilder sb = new StringBuilder();
                                sb.append("isRetry: true, ");
                                i = this.this$0.delayCount;
                                sb.append(i);
                                yYPluginManageServiceImpl.logD(sb.toString());
                                i2 = this.this$0.delayCount;
                                if (i2 <= 3) {
                                    YYPluginManageServiceImpl yYPluginManageServiceImpl2 = this.this$0;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("isRetry: true, ");
                                    i4 = this.this$0.delayCount;
                                    sb2.append(i4);
                                    sb2.append("   dispatch");
                                    yYPluginManageServiceImpl2.logD(sb2.toString());
                                    this.this$0.dispatchDownloadSuccess(this.$pluginPackageName, this.$callback, true);
                                } else {
                                    YYPluginManageServiceImpl yYPluginManageServiceImpl3 = this.this$0;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("isRetry: true, ");
                                    i3 = this.this$0.delayCount;
                                    sb3.append(i3);
                                    sb3.append("   onError");
                                    yYPluginManageServiceImpl3.log(sb3.toString());
                                    this.this$0.delayCount = 1;
                                    YYPluginInstallCallback yYPluginInstallCallback2 = this.$callback;
                                    String str2 = this.$pluginPackageName;
                                    yYPluginInstallCallback2.onError(str2, -111, "prepare Code " + prepareBundle);
                                }
                            }
                            YYPluginManageServiceImpl yYPluginManageServiceImpl4 = this.this$0;
                            i5 = yYPluginManageServiceImpl4.delayCount;
                            yYPluginManageServiceImpl4.delayCount = i5 + 1;
                        }
                    }
                }, "live_nps_install", 0, this.delayCount * 100);
                return;
            }
            this.delayCount = 1;
            ExecutorUtilsExt.postOnElastic(new Runnable(this, str, yYPluginInstallCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$dispatchDownloadSuccess$2
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ YYPluginInstallCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $pluginPackageName;
                public final /* synthetic */ YYPluginManageServiceImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, yYPluginInstallCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$pluginPackageName = str;
                    this.$callback = yYPluginInstallCallback;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    YYPluginBundleInfo transBundleInfo;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int prepareBundle = NPSPackageManager.getInstance().prepareBundle(this.$pluginPackageName);
                        if (prepareBundle == 41) {
                            transBundleInfo = this.this$0.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(this.$pluginPackageName));
                            if (transBundleInfo == null) {
                                this.$callback.onError(this.$pluginPackageName, -100, "transform error");
                            } else {
                                this.$callback.onLoaded(transBundleInfo);
                            }
                        } else if (prepareBundle == 44) {
                            this.this$0.dispatchDownloadSuccess(this.$pluginPackageName, this.$callback, true);
                        } else {
                            YYPluginInstallCallback yYPluginInstallCallback2 = this.$callback;
                            String str2 = this.$pluginPackageName;
                            yYPluginInstallCallback2.onError(str2, -111, "prepare Code " + prepareBundle);
                        }
                    }
                }
            }, "live_nps_install", 0);
        }
    }

    public static /* synthetic */ void dispatchDownloadSuccess$default(YYPluginManageServiceImpl yYPluginManageServiceImpl, String str, YYPluginInstallCallback yYPluginInstallCallback, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        yYPluginManageServiceImpl.dispatchDownloadSuccess(str, yYPluginInstallCallback, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            LiveYalogApi liveYalogApi = this.yalogApi;
            if (liveYalogApi != null) {
                liveYalogApi.i("3036", "live-com-installer", "YYPluginManageServiceImpl:  " + str);
                return;
            }
            Log.e("live-com-installer", "YYPluginManageServiceImpl:  " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logD(String str) {
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && (appInfoService = this.appService) != null && appInfoService.isDebug()) {
            Log.e("live-com-installer", "YYPluginManageServiceImpl:  " + str);
        }
    }

    private final SparseArray<YYPluginBundleInfo> transBundleGroup(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bundleInfoGroup)) == null) {
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
        return (SparseArray) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YYPluginBundleInfo transBundleInfo(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String packageName = bundleInfo.getPackageName();
            Intrinsics.checkExpressionValueIsNotNull(packageName, "bundle.packageName");
            return new YYPluginBundleInfo(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
        }
        return (YYPluginBundleInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void downloadBundle(final String str, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, yYPluginDownloadCallback) == null) {
            NPSPackageManager.getInstance().downloadUpdatePackage(str, new y81(yYPluginDownloadCallback, str) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadBundle$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ YYPluginDownloadCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $pluginPackageName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {yYPluginDownloadCallback, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$callback = yYPluginDownloadCallback;
                    this.$pluginPackageName = str;
                }

                @Override // com.baidu.tieba.y81
                public void onProgress(long j, long j2) {
                    YYPluginDownloadCallback yYPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (yYPluginDownloadCallback2 = this.$callback) == null) {
                        return;
                    }
                    yYPluginDownloadCallback2.onProgress(this.$pluginPackageName, j, j2);
                }

                @Override // com.baidu.tieba.y81
                public void onResult(int i, String str2) {
                    YYPluginDownloadCallback yYPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) || (yYPluginDownloadCallback2 = this.$callback) == null) {
                        return;
                    }
                    yYPluginDownloadCallback2.onResult(this.$pluginPackageName, i == 2, str2);
                }
            }, YYPluginManageServiceImpl$downloadBundle$2.INSTANCE, 1);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void downloadFile(final String str, String str2, final String str3, final String str4, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, yYPluginDownloadCallback) == null) {
            new DownloadTask.Builder(str2, str3, str4).setPassIfAlreadyCompleted(true).build().enqueue(new DownloadTaskProgressListener(str3, str4, yYPluginDownloadCallback, str) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadFile$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ YYPluginDownloadCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $fileName;
                public final /* synthetic */ String $packageName;
                public final /* synthetic */ String $path;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str3, str4, yYPluginDownloadCallback, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$path = str3;
                    this.$fileName = str4;
                    this.$callback = yYPluginDownloadCallback;
                    this.$packageName = str;
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void connected(DownloadTask downloadTask, int i, long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void progress(DownloadTask downloadTask, long j, long j2) {
                    YYPluginDownloadCallback yYPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Long.valueOf(j), Long.valueOf(j2)}) == null) || (yYPluginDownloadCallback2 = this.$callback) == null) {
                        return;
                    }
                    yYPluginDownloadCallback2.onProgress(this.$packageName, j, j2);
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, resumeFailedCause) == null) {
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, TaskProgressListenerAssist.Listener1Model listener1Model) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048579, this, downloadTask, endCause, exc, listener1Model) == null) {
                        File file = new File(this.$path, this.$fileName);
                        if (endCause == EndCause.COMPLETED && file.exists()) {
                            YYPluginDownloadCallback yYPluginDownloadCallback2 = this.$callback;
                            if (yYPluginDownloadCallback2 != null) {
                                yYPluginDownloadCallback2.onResult(this.$packageName, true, "");
                                return;
                            }
                            return;
                        }
                        YYPluginDownloadCallback yYPluginDownloadCallback3 = this.$callback;
                        if (yYPluginDownloadCallback3 != null) {
                            yYPluginDownloadCallback3.onResult(this.$packageName, false, "download failed");
                        }
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void taskStart(DownloadTask downloadTask, TaskProgressListenerAssist.Listener1Model listener1Model) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadTask, listener1Model) == null) {
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public SparseArray<YYPluginBundleInfo> getPluginBundleInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                return transBundleGroup(bundleGroup);
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean hookHostAssets(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Application applicationContext = ContextHolder.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "ContextHolder.getApplicationContext()");
            return ResourcesHookUtil.hookAssets(applicationContext.getAssets(), str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean hookResources(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, resources, str)) == null) ? ResourcesHookUtil.hookResources(resources, str) : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void installBundle(final String str, final YYPluginInstallCallback yYPluginInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, yYPluginInstallCallback) == null) {
            NPSPackageManager.getInstance().downloadBundle(str, new y81(this, str, yYPluginInstallCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installBundle$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ YYPluginInstallCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $pluginPackageName;
                public final /* synthetic */ YYPluginManageServiceImpl this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, yYPluginInstallCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$pluginPackageName = str;
                    this.$callback = yYPluginInstallCallback;
                }

                @Override // com.baidu.tieba.y81
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.$callback.onProgress(this.$pluginPackageName, j, j2);
                    }
                }

                @Override // com.baidu.tieba.y81
                public void onResult(int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                        if (i == 2) {
                            YYPluginManageServiceImpl.dispatchDownloadSuccess$default(this.this$0, this.$pluginPackageName, this.$callback, false, 4, null);
                        } else {
                            this.$callback.onError(this.$pluginPackageName, i, str2);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean installPluginApk(String str) {
        InterceptResult invokeL;
        String str2;
        PackageInfo a;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, str)) != null) {
            return invokeL.booleanValue;
        }
        String str3 = null;
        boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "entrance", false, 2, (Object) null);
        String str4 = BD_LIVE_CREATE_ICON_URL;
        if (contains$default) {
            str2 = "yy直播入口一级插件";
        } else {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "extlib", false, 2, (Object) null)) {
                str2 = "yy直播扩展库插件";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) NpsLoadChainLog.PAGE, false, 2, (Object) null)) {
                str2 = "yy直播直播间二级插件";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "interaction", false, 2, (Object) null)) {
                str2 = "yy直播玩法二级插件";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.yylib", false, 2, (Object) null)) {
                str2 = "YY业务基础库二级插件";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.game", false, 2, (Object) null)) {
                str2 = "yy游戏直播";
            } else if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "yylive.createlive", false, 2, (Object) null)) {
                str2 = "yy开播";
            } else {
                if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "bjhlivenps", false, 2, (Object) null)) {
                    str2 = "媒体直播开播插件";
                } else if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "media.business", false, 2, (Object) null)) {
                    str2 = "直播插件";
                    str4 = BD_LIVE_ICON_URL;
                    if (new File(str).exists() && (a = t91.a(str, 128)) != null) {
                        BundleInfo bundleInfo = new BundleInfo();
                        bundleInfo.setName(str2);
                        bundleInfo.setIconUrl(str4);
                        bundleInfo.setApkPath(str);
                        bundleInfo.setPackageName(a.packageName);
                        bundleInfo.setVersionCode(a.versionCode);
                        if (!TextUtils.isEmpty(str3)) {
                            bundleInfo.setMainBundle(str3);
                        }
                        int installLocalBundle = NPSPackageManager.getInstance().installLocalBundle(bundleInfo);
                        log("bundleInfo.packageName = " + bundleInfo.getPackageName() + ", bundleInfo.versionCode = " + bundleInfo.getVersionCode() + ", installRetCode = " + installLocalBundle);
                        return installLocalBundle != 13;
                    }
                    return false;
                } else {
                    str2 = "媒体直播业务二级插件";
                }
                str3 = "com.baidu.searchbox.livenps";
                if (new File(str).exists()) {
                    return false;
                }
                BundleInfo bundleInfo2 = new BundleInfo();
                bundleInfo2.setName(str2);
                bundleInfo2.setIconUrl(str4);
                bundleInfo2.setApkPath(str);
                bundleInfo2.setPackageName(a.packageName);
                bundleInfo2.setVersionCode(a.versionCode);
                if (!TextUtils.isEmpty(str3)) {
                }
                int installLocalBundle2 = NPSPackageManager.getInstance().installLocalBundle(bundleInfo2);
                log("bundleInfo.packageName = " + bundleInfo2.getPackageName() + ", bundleInfo.versionCode = " + bundleInfo2.getVersionCode() + ", installRetCode = " + installLocalBundle2);
                if (installLocalBundle2 != 13) {
                }
            }
            str3 = "com.baidu.searchbox.yylive.entrance";
        }
        str4 = YY_ICON_URL;
        if (new File(str).exists()) {
        }
    }
}
