package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import android.app.Application;
import android.content.res.Resources;
import android.util.SparseArray;
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
import d.a.x.d.a.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/defaultimpl/service/YYPluginManageServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "", "pluginPackageName", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;", "callback", "", "downloadBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "packageName", "url", "path", "fileName", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "bundlePath", "", "hookHostAssets", "(Ljava/lang/String;)Z", "Landroid/content/res/Resources;", "hostResources", "hookResources", "(Landroid/content/res/Resources;Ljava/lang/String;)Z", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", "installBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;)V", "apkPath", "installPluginApk", "Lcom/baidu/nps/pm/BundleInfoGroup;", "group", "transBundleGroup", "(Lcom/baidu/nps/pm/BundleInfoGroup;)Landroid/util/SparseArray;", "Lcom/baidu/nps/pm/BundleInfo;", "bundle", "transBundleInfo", "(Lcom/baidu/nps/pm/BundleInfo;)Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "<init>", "()V", "lib-live-interfaces-impl_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYPluginManageServiceImpl implements YYPluginManageService {
    private final SparseArray<YYPluginBundleInfo> transBundleGroup(BundleInfoGroup bundleInfoGroup) {
        SparseArray<YYPluginBundleInfo> sparseArray = new SparseArray<>();
        try {
            sparseArray.append(1, transBundleInfo(bundleInfoGroup.getBundleByType(1)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            sparseArray.append(2, transBundleInfo(bundleInfoGroup.getBundleByType(2)));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            sparseArray.append(3, transBundleInfo(bundleInfoGroup.getBundleByType(3)));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return sparseArray;
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
    public void downloadBundle(final String str, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        NPSPackageManager.getInstance().downloadUpdatePackage(str, new a() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadBundle$1
            @Override // d.a.x.d.a.a
            public void onProgress(long j, long j2) {
                YYPluginDownloadCallback yYPluginDownloadCallback2 = YYPluginDownloadCallback.this;
                if (yYPluginDownloadCallback2 != null) {
                    yYPluginDownloadCallback2.onProgress(str, j, j2);
                }
            }

            @Override // d.a.x.d.a.a
            public void onResult(int i2, String str2) {
                YYPluginDownloadCallback yYPluginDownloadCallback2 = YYPluginDownloadCallback.this;
                if (yYPluginDownloadCallback2 != null) {
                    yYPluginDownloadCallback2.onResult(str, i2 == 2, str2);
                }
            }
        }, YYPluginManageServiceImpl$downloadBundle$2.INSTANCE, 1);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void downloadFile(final String str, String str2, final String str3, final String str4, final YYPluginDownloadCallback yYPluginDownloadCallback) {
        new DownloadTask.Builder(str2, str3, str4).setPassIfAlreadyCompleted(true).build().enqueue(new DownloadTaskProgressListener() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$downloadFile$1
            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void connected(DownloadTask downloadTask, int i2, long j, long j2) {
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void progress(DownloadTask downloadTask, long j, long j2) {
                YYPluginDownloadCallback yYPluginDownloadCallback2 = yYPluginDownloadCallback;
                if (yYPluginDownloadCallback2 != null) {
                    yYPluginDownloadCallback2.onProgress(str, j, j2);
                }
            }

            @Override // com.baidu.searchbox.bddownload.core.listener.assist.TaskProgressListenerAssist.TaskProgressListenerCallback
            public void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause) {
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
            public void taskStart(DownloadTask downloadTask, TaskProgressListenerAssist.Listener1Model listener1Model) {
            }
        });
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
    public boolean hookResources(Resources resources, String str) {
        return ResourcesHookUtil.hookResources(resources, str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public void installBundle(final String str, final YYPluginInstallCallback yYPluginInstallCallback) {
        NPSPackageManager.getInstance().installBundle(str, new IInstallCallback() { // from class: com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceImpl$installBundle$1
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                yYPluginInstallCallback.onProgress(str, j, j2);
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i2, String str2) {
                YYPluginBundleInfo transBundleInfo;
                if (i2 == 13) {
                    transBundleInfo = YYPluginManageServiceImpl.this.transBundleInfo(NPSPackageManager.getInstance().getBundleInfo(str));
                    if (transBundleInfo == null) {
                        yYPluginInstallCallback.onError(str, -100, "transform error");
                        return;
                    } else {
                        yYPluginInstallCallback.onLoaded(transBundleInfo);
                        return;
                    }
                }
                yYPluginInstallCallback.onError(str, i2, str2);
            }
        });
    }

    @Override // com.baidu.searchbox.live.interfaces.service.yy.YYPluginManageService
    public boolean installPluginApk(String str) {
        return NPSPackageManager.getInstance().installBundleForDebug(str) == 13;
    }
}
