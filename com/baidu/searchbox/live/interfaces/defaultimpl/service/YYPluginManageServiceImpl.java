package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.app.Application;
import android.content.res.Resources;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.listener.DownloadTaskProgressListener;
import com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist;
import com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginInstallCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.repackage.q61;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "", "pluginPackageName", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "downloadBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "packageName", "url", "path", "fileName", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "bundlePath", "", "hookHostAssets", "(Ljava/lang/String;)Z", "Landroid/content/res/Resources;", "hostResources", "hookResources", "(Landroid/content/res/Resources;Ljava/lang/String;)Z", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", "installBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;)V", "apkPath", "installPluginApk", "Lcom/baidu/nps/pm/BundleInfoGroup;", "group", "transBundleGroup", "(Lcom/baidu/nps/pm/BundleInfoGroup;)Landroid/util/SparseArray;", "Lcom/baidu/nps/pm/BundleInfo;", "bundle", "transBundleInfo", "(Lcom/baidu/nps/pm/BundleInfo;)Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYPluginManageServiceImpl implements YYPluginManageService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YYPluginManageServiceImpl() {
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

    private final SparseArray<YYPluginBundleInfo> transBundleGroup(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bundleInfoGroup)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bundleInfo)) == null) {
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
            NPSPackageManager.getInstance().downloadUpdatePackage(str, new q61(yYPluginDownloadCallback, str) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadBundle$1
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

                @Override // com.repackage.q61
                public void onProgress(long j, long j2) {
                    YYPluginDownloadCallback yYPluginDownloadCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (yYPluginDownloadCallback2 = this.$callback) == null) {
                        return;
                    }
                    yYPluginDownloadCallback2.onProgress(this.$pluginPackageName, j, j2);
                }

                @Override // com.repackage.q61
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
            NPSPackageManager.getInstance().installBundle(str, new IInstallCallback(this, str, yYPluginInstallCallback) { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installBundle$1
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

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.$callback.onProgress(this.$pluginPackageName, j, j2);
                    }
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i, String str2) {
                    YYPluginBundleInfo transBundleInfo;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                        if (i == 13) {
                            transBundleInfo = this.this$0.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(this.$pluginPackageName));
                            if (transBundleInfo == null) {
                                this.$callback.onError(this.$pluginPackageName, -100, "transform error");
                                return;
                            } else {
                                this.$callback.onLoaded(transBundleInfo);
                                return;
                            }
                        }
                        this.$callback.onError(this.$pluginPackageName, i, str2);
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean installPluginApk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? NPSPackageManager.getInstance().installBundleForDebug(str) == 13 : invokeL.booleanValue;
    }
}
