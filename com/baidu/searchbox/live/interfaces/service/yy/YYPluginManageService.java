package com.baidu.searchbox.live.interfaces.service.yy;

import android.util.SparseArray;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginInstallCallback;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService;", "Lkotlin/Any;", "", "pluginPackageName", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;", "callback", "", "downloadBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, "url", "path", "fileName", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginDownloadCallback;)V", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", "installBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;)V", "apkPath", "", "installPluginApk", "(Ljava/lang/String;)Z", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface YYPluginManageService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/yy/YYPluginManageService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.YY.YY_PLUGIN);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    void downloadBundle(String str, YYPluginDownloadCallback yYPluginDownloadCallback);

    void downloadFile(String str, String str2, String str3, String str4, YYPluginDownloadCallback yYPluginDownloadCallback);

    SparseArray<YYPluginBundleInfo> getPluginBundleInfo(String str);

    void installBundle(String str, YYPluginInstallCallback yYPluginInstallCallback);

    boolean installPluginApk(String str);
}
