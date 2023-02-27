package com.baidu.searchbox.live.interfaces.service;

import android.util.SparseArray;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.multiplugin.MainPluginBundleInfo;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginDownloadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginInstallCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginLoadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.SubPluginBundleInfo;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000  2\u00020\u0001:\u0001 J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/MultiPluginManagerService;", "Lkotlin/Any;", "", "pkgName", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginDownloadCallback;", "downloadCallback", "", "downloadUpdatePackage", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginDownloadCallback;)V", "", "getBundleStatus", "(Ljava/lang/String;)I", "Landroid/util/SparseArray;", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MainPluginBundleInfo;", "getPluginBundleInfo", "(Ljava/lang/String;)Landroid/util/SparseArray;", "type", "", "Lcom/baidu/searchbox/live/interfaces/multiplugin/SubPluginBundleInfo;", "getSubBundleInfo", "(Ljava/lang/String;I)Ljava/util/List;", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginInstallCallback;", "installCallback", "installMultiBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginInstallCallback;)V", "", "isAvailable", "(Ljava/lang/String;)Z", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;", "loadCallback", "loadMultiBundle", "(Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MultiPluginManagerService {
    public static final int BUNDLE_TYPE_BACKUP = 4;
    public static final int BUNDLE_TYPE_DOWNLOADED = 2;
    public static final int BUNDLE_TYPE_INSTALLED = 3;
    public static final int BUNDLE_TYPE_UPDATED = 1;
    public static final Companion Companion = Companion.$$INSTANCE;

    void downloadUpdatePackage(String str, MultiPluginDownloadCallback multiPluginDownloadCallback);

    int getBundleStatus(String str);

    SparseArray<MainPluginBundleInfo> getPluginBundleInfo(String str);

    List<SubPluginBundleInfo> getSubBundleInfo(String str, int i);

    void installMultiBundle(String str, MultiPluginInstallCallback multiPluginInstallCallback);

    boolean isAvailable(String str);

    void loadMultiBundle(String str, MultiPluginLoadCallback multiPluginLoadCallback);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/MultiPluginManagerService$Companion;", "", "BUNDLE_TYPE_BACKUP", "I", "BUNDLE_TYPE_DOWNLOADED", "BUNDLE_TYPE_INSTALLED", "BUNDLE_TYPE_UPDATED", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final int BUNDLE_TYPE_BACKUP = 4;
        public static final int BUNDLE_TYPE_DOWNLOADED = 2;
        public static final int BUNDLE_TYPE_INSTALLED = 3;
        public static final int BUNDLE_TYPE_UPDATED = 1;
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("multi_plugin");

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void downloadUpdatePackage$default(MultiPluginManagerService multiPluginManagerService, String str, MultiPluginDownloadCallback multiPluginDownloadCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    multiPluginDownloadCallback = null;
                }
                multiPluginManagerService.downloadUpdatePackage(str, multiPluginDownloadCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadUpdatePackage");
        }
    }
}
