package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.utils.Constant;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskProgressListener;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.Md5;
import com.baidu.searchbox.live.interfaces.multiplugin.MainPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginInstallCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginLoadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.SubPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService;
import com.baidu.tieba.s91;
import com.baidu.tieba.u91;
import com.baidu.tieba.v91;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u0007¢\u0006\u0004\b@\u0010AJ9\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010%J'\u0010)\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00104\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b:\u0010;R\u001e\u0010>\u001a\n =*\u0004\u0018\u00010<0<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/MultiPluginManagerService;", "", "packageName", "url", "path", "fileName", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginDownloadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "downloadBundleFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginDownloadCallback;)V", "pkgName", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginDownloadCallback;", "downloadCallback", "downloadUpdatePackage", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginDownloadCallback;)V", "Lcom/baidu/nps/pm/BundleInfo;", "bundle", "genBundleCacheFileName", "(Lcom/baidu/nps/pm/BundleInfo;)Ljava/lang/String;", "genBundleFileName", "", "getBundleStatus", "(Ljava/lang/String;)I", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MainPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "type", "", "Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "getSubBundleInfo", "(Ljava/lang/String;I)Ljava/util/List;", "getValidBackupBundle", "(Ljava/lang/String;)Lcom/baidu/nps/pm/BundleInfo;", "getVersionInfoByName", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/File;", "apkFile", "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginInstallCallback;", "installLocalMultiBundle", "(Lcom/baidu/nps/pm/BundleInfo;Ljava/io/File;Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginInstallCallback;)V", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginInstallCallback;", "installCallback", "installMultiBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginInstallCallback;)V", "", "isAvailable", "(Ljava/lang/String;)Z", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;", "loadCallback", "loadMultiBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;)V", "Lcom/baidu/nps/pm/BundleInfoGroup;", "group", "transBundleGroup", "(Lcom/baidu/nps/pm/BundleInfoGroup;)Landroid/util/SparseArray;", "transBundleInfo", "(Lcom/baidu/nps/pm/BundleInfo;)Lcom/baidu/searchbox/live/interfaces/multiplugin/MainPluginBundleInfo;", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appService", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "<init>", "()V", "Companion", "PluginDownloadCallback", "PluginInstallCallback", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MultiPluginManagerServiceImpl implements MultiPluginManagerService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int INSTALL_ERR_BK_FILE_DOWNLOAD_FAIL = -130;
    public static final int INSTALL_ERR_BK_FILE_MD5_FAILED = -132;
    public static final int INSTALL_ERR_BK_FILE_NOT_EXIST = -131;
    public transient /* synthetic */ FieldHolder $fh;
    public final AppInfoService appService;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bb\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginDownloadCallback;", "Lkotlin/Any;", "", "pkgName", "", "downloadSize", "totalSize", "", "onProgress", "(Ljava/lang/String;JJ)V", "", "isSuc", "msg", "onResult", "(Ljava/lang/String;ZLjava/lang/String;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface PluginDownloadCallback {
        void onProgress(String str, long j, long j2);

        void onResult(String str, boolean z, String str2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$PluginInstallCallback;", "Lkotlin/Any;", "", "pkgName", "", "retCode", "retMsg", "", "onResult", "(Ljava/lang/String;ILjava/lang/String;)V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface PluginInstallCallback {
        void onResult(String str, int i, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(448528475, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(448528475, "Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/MultiPluginManagerServiceImpl$Companion;", "", "INSTALL_ERR_BK_FILE_DOWNLOAD_FAIL", "I", "INSTALL_ERR_BK_FILE_MD5_FAILED", "INSTALL_ERR_BK_FILE_NOT_EXIST", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    public MultiPluginManagerServiceImpl() {
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
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public void downloadUpdatePackage(String str, final MultiPluginDownloadCallback multiPluginDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, multiPluginDownloadCallback) == null) {
            NPSPackageManager.getInstance().downloadUpdatePackage(str, new s91(multiPluginDownloadCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$downloadUpdatePackage$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ MultiPluginDownloadCallback $downloadCallback;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {multiPluginDownloadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$downloadCallback = multiPluginDownloadCallback;
                }

                @Override // com.baidu.tieba.s91
                public void onProgress(long j, long j2) {
                    MultiPluginDownloadCallback multiPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (multiPluginDownloadCallback2 = this.$downloadCallback) != null) {
                        multiPluginDownloadCallback2.onProgress(j, j2);
                    }
                }

                @Override // com.baidu.tieba.s91
                public void onResult(int i, String str2) {
                    MultiPluginDownloadCallback multiPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) && (multiPluginDownloadCallback2 = this.$downloadCallback) != null) {
                        multiPluginDownloadCallback2.onResult(i, str2);
                    }
                }
            }, new u91() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$downloadUpdatePackage$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tieba.u91
                public void checkAuthorization(IBundleInfo iBundleInfo, int i, v91 v91Var) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i, v91Var) == null) && v91Var != null) {
                        v91Var.onResult(1);
                    }
                }
            }, 1, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public void installMultiBundle(String str, MultiPluginInstallCallback multiPluginInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, multiPluginInstallCallback) == null) {
            NPSPackageManager.getInstance().installBundle(str, true, (IInstallCallback) new MultiPluginManagerServiceImpl$installMultiBundle$1(this, multiPluginInstallCallback, str));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public void loadMultiBundle(String str, final MultiPluginLoadCallback multiPluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, multiPluginLoadCallback) == null) {
            NPSManager.getInstance().loadBundleOnly(str, 0, new IInvokeCallback(multiPluginLoadCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$loadMultiBundle$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiPluginLoadCallback $loadCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {multiPluginLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$loadCallback = multiPluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                        if (i == 14) {
                            MultiPluginLoadCallback multiPluginLoadCallback2 = this.$loadCallback;
                            if (multiPluginLoadCallback2 != null) {
                                multiPluginLoadCallback2.onResult(true, i, str2);
                                return;
                            }
                            return;
                        }
                        MultiPluginLoadCallback multiPluginLoadCallback3 = this.$loadCallback;
                        if (multiPluginLoadCallback3 != null) {
                            multiPluginLoadCallback3.onResult(false, i, str2);
                        }
                    }
                }
            }, true, null);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public int getBundleStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return NPSPackageManager.getInstance().getBundleStatus(str, true);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public SparseArray<MainPluginBundleInfo> getPluginBundleInfo(String str) {
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

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public boolean isAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (43 == NPSPackageManager.getInstance().getBundleStatus(str, true)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadBundleFile(final String str, String str2, final String str3, final String str4, final PluginDownloadCallback pluginDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, this, str, str2, str3, str4, pluginDownloadCallback) == null) {
            new DownloadTask.Builder(str2, str3, str4).setPassIfAlreadyCompleted(true).build().enqueue(new DownloadTaskProgressListener(str3, str4, pluginDownloadCallback, str) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$downloadBundleFile$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ MultiPluginManagerServiceImpl.PluginDownloadCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $fileName;
                public final /* synthetic */ String $packageName;
                public final /* synthetic */ String $path;

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void connected(DownloadTask downloadTask, int i, long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{downloadTask, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, resumeFailedCause) == null) {
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void taskStart(DownloadTask downloadTask, TaskProgressListenerAssist.Listener1Model listener1Model) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadTask, listener1Model) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str3, str4, pluginDownloadCallback, str};
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
                    this.$callback = pluginDownloadCallback;
                    this.$packageName = str;
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, TaskProgressListenerAssist.Listener1Model listener1Model) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048579, this, downloadTask, endCause, exc, listener1Model) == null) {
                        File file = new File(this.$path, this.$fileName);
                        if (endCause == EndCause.COMPLETED && file.exists()) {
                            MultiPluginManagerServiceImpl.PluginDownloadCallback pluginDownloadCallback2 = this.$callback;
                            if (pluginDownloadCallback2 != null) {
                                pluginDownloadCallback2.onResult(this.$packageName, true, "");
                                return;
                            }
                            return;
                        }
                        MultiPluginManagerServiceImpl.PluginDownloadCallback pluginDownloadCallback3 = this.$callback;
                        if (pluginDownloadCallback3 != null) {
                            pluginDownloadCallback3.onResult(this.$packageName, false, "multi bk download failed");
                        }
                    }
                }

                @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
                public void progress(DownloadTask downloadTask, long j, long j2) {
                    MultiPluginManagerServiceImpl.PluginDownloadCallback pluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadTask, Long.valueOf(j), Long.valueOf(j2)}) == null) && (pluginDownloadCallback2 = this.$callback) != null) {
                        pluginDownloadCallback2.onProgress(this.$packageName, j, j2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String genBundleCacheFileName(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, bundleInfo)) == null) {
            return bundleInfo.getPackageName() + "_" + bundleInfo.getMd5() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String genBundleFileName(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, bundleInfo)) == null) {
            return bundleInfo.getPackageName() + "_v_" + bundleInfo.getVersionCode() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BundleInfo getValidBackupBundle(String str) {
        InterceptResult invokeL;
        BundleInfo bundleByType;
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null && bundleGroup.getBundleByType(1) == null && (bundleByType = bundleGroup.getBundleByType(4)) != null && bundleByType.isSubBundle() && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo(bundleByType.getMainBudble())) != null && bundleInfo.isMainBundle()) {
                for (SubBundleInfo sub : bundleInfo.getSubBundle()) {
                    Intrinsics.checkExpressionValueIsNotNull(sub, "sub");
                    if (Intrinsics.areEqual(str, sub.getPackageName()) && bundleByType.getVersionCode() >= sub.getMinVersion() && bundleByType.getVersionCode() <= sub.getMaxVersion()) {
                        return bundleByType;
                    }
                }
                return null;
            }
            return null;
        }
        return (BundleInfo) invokeL.objValue;
    }

    private final MainPluginBundleInfo transBundleInfo(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String str = "";
            List<SubBundleInfo> subBundle = bundleInfo.getSubBundle();
            if (subBundle != null) {
                for (SubBundleInfo it : subBundle) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    sb.append(new SubPluginBundleInfo(it.getPackageName(), Integer.valueOf(it.getMinVersion()), Integer.valueOf(it.getMaxVersion())));
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    str = sb.toString();
                }
            }
            return new MainPluginBundleInfo(bundleInfo.getPackageName(), Integer.valueOf(bundleInfo.getVersionCode()), Boolean.valueOf(bundleInfo.needForceUpdate()), Boolean.valueOf(bundleInfo.isMainBundle()), Boolean.valueOf(bundleInfo.isSubBundle()), bundleInfo.getMainBudble(), str, bundleInfo.getExt());
        }
        return (MainPluginBundleInfo) invokeL.objValue;
    }

    private final String getVersionInfoByName(String str) {
        InterceptResult invokeL;
        boolean z;
        Integer num;
        Integer num2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            String str2 = "=={\n";
            if (bundleGroup != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("=={\n");
                sb.append("update version = ");
                BundleInfo bundleByType = bundleGroup.getBundleByType(1);
                Integer num3 = null;
                if (bundleByType != null) {
                    num = Integer.valueOf(bundleByType.getVersionCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", \n");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append("downloaded version = ");
                BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
                if (bundleByType2 != null) {
                    num2 = Integer.valueOf(bundleByType2.getVersionCode());
                } else {
                    num2 = null;
                }
                sb3.append(num2);
                sb3.append(", \n");
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append("installed version = ");
                BundleInfo bundleByType3 = bundleGroup.getBundleByType(3);
                if (bundleByType3 != null) {
                    num3 = Integer.valueOf(bundleByType3.getVersionCode());
                }
                sb5.append(num3);
                sb5.append(" \n");
                str2 = sb5.toString();
            }
            return str2 + "}";
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installLocalMultiBundle(final BundleInfo bundleInfo, final File file, final PluginInstallCallback pluginInstallCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, bundleInfo, file, pluginInstallCallback) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(file, pluginInstallCallback, bundleInfo) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.MultiPluginManagerServiceImpl$installLocalMultiBundle$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ File $apkFile;
                public final /* synthetic */ BundleInfo $bundle;
                public final /* synthetic */ MultiPluginManagerServiceImpl.PluginInstallCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {file, pluginInstallCallback, bundleInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$apkFile = file;
                    this.$callback = pluginInstallCallback;
                    this.$bundle = bundleInfo;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.$apkFile.exists()) {
                            MultiPluginManagerServiceImpl.PluginInstallCallback pluginInstallCallback2 = this.$callback;
                            String packageName = this.$bundle.getPackageName();
                            Intrinsics.checkExpressionValueIsNotNull(packageName, "bundle.packageName");
                            pluginInstallCallback2.onResult(packageName, MultiPluginManagerServiceImpl.INSTALL_ERR_BK_FILE_NOT_EXIST, "apk not exist");
                            return;
                        }
                        String md5 = this.$bundle.getMd5();
                        String str2 = null;
                        if (md5 != null) {
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
                            if (md5 != null) {
                                str = md5.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            str = null;
                        }
                        String md52 = Md5.toMd5(new FileInputStream(this.$apkFile));
                        if (md52 != null) {
                            Locale locale2 = Locale.getDefault();
                            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.getDefault()");
                            if (md52 != null) {
                                str2 = md52.toLowerCase(locale2);
                                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase(locale)");
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        if (str != null && Intrinsics.areEqual(str, str2)) {
                            BundleInfo installBundle = BundleInfo.toBundleInfo(this.$bundle);
                            Intrinsics.checkExpressionValueIsNotNull(installBundle, "installBundle");
                            installBundle.setApkPath(this.$apkFile.getAbsolutePath());
                            int installLocalBundle = NPSPackageManager.getInstance().installLocalBundle(installBundle);
                            if (installLocalBundle == 13) {
                                this.$apkFile.delete();
                            }
                            MultiPluginManagerServiceImpl.PluginInstallCallback pluginInstallCallback3 = this.$callback;
                            String packageName2 = this.$bundle.getPackageName();
                            Intrinsics.checkExpressionValueIsNotNull(packageName2, "bundle.packageName");
                            pluginInstallCallback3.onResult(packageName2, installLocalBundle, "multi_bk_install " + installLocalBundle);
                            return;
                        }
                        this.$apkFile.delete();
                        MultiPluginManagerServiceImpl.PluginInstallCallback pluginInstallCallback4 = this.$callback;
                        String packageName3 = this.$bundle.getPackageName();
                        Intrinsics.checkExpressionValueIsNotNull(packageName3, "bundle.packageName");
                        pluginInstallCallback4.onResult(packageName3, MultiPluginManagerServiceImpl.INSTALL_ERR_BK_FILE_MD5_FAILED, "md5 failed");
                    }
                }
            }, "live_multi_nps_install", 0);
        }
    }

    private final SparseArray<MainPluginBundleInfo> transBundleGroup(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, bundleInfoGroup)) == null) {
            SparseArray<MainPluginBundleInfo> sparseArray = new SparseArray<>();
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
            try {
                sparseArray.append(4, transBundleInfo(bundleInfoGroup.getBundleByType(4)));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.MultiPluginManagerService
    public List<SubPluginBundleInfo> getSubBundleInfo(String str, int i) {
        InterceptResult invokeLI;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null && (bundleByType = bundleGroup.getBundleByType(i)) != null && bundleByType.isMainBundle()) {
                ArrayList arrayList = new ArrayList();
                for (SubBundleInfo subBundleInfo : bundleByType.getSubBundle()) {
                    if (subBundleInfo != null) {
                        arrayList.add(new SubPluginBundleInfo(subBundleInfo.getPackageName(), Integer.valueOf(subBundleInfo.getMinVersion()), Integer.valueOf(subBundleInfo.getMaxVersion())));
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLI.objValue;
    }
}
