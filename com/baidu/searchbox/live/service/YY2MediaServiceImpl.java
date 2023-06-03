package com.baidu.searchbox.live.service;

import android.content.Context;
import com.baidu.searchbox.live.goback.IYYGobackController;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginLoadCallback;
import com.baidu.searchbox.live.interfaces.service.YY2MediaService;
import com.baidu.searchbox.live.interfaces.smallwindow.IYYSmallWindowController;
import com.baidu.searchbox.live.interfaces.storage.IYYStorageController;
import com.baidu.searchbox.live.nps.LiveMediaPluginManager;
import com.baidu.searchbox.live.recommendmore.ILiveRecMoreController;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/service/YY2MediaServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/YY2MediaService;", "", "pkgName", "", "getInstallPluginVersion", "(Ljava/lang/String;)I", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "getRecMoreController", "(Landroid/content/Context;)Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "getStorageOptInfoHelperInterface", "()Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "Lcom/baidu/searchbox/live/goback/IYYGobackController;", "getYYGobackController", "()Lcom/baidu/searchbox/live/goback/IYYGobackController;", "Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "getYYSmallWindowController", "()Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "", "isMediaPluginLoaded", "()Z", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "loadMediaPlugin", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;)V", "data", "onYYJoinChannelSuc", "(Ljava/lang/String;)V", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class YY2MediaServiceImpl implements YY2MediaService {
    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYSmallWindowController getYYSmallWindowController() {
        return null;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYStorageController getStorageOptInfoHelperInterface() {
        LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveMediaPluginManager, "LiveMediaPluginManager.getInstance()");
        return liveMediaPluginManager.getStorageOptInfoHelperInterface();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYGobackController getYYGobackController() {
        LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveMediaPluginManager, "LiveMediaPluginManager.getInstance()");
        return liveMediaPluginManager.getYYGobackController();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public boolean isMediaPluginLoaded() {
        return LiveMediaPluginManager.getInstance().isLoaded("com.baidu.live.media.business");
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public int getInstallPluginVersion(String str) {
        return LiveMediaPluginManager.getInstance().getInstallPluginVersion(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public ILiveRecMoreController getRecMoreController(Context context) {
        return LiveMediaPluginManager.getInstance().getRecMoreController(context);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public void onYYJoinChannelSuc(String str) {
        LiveMediaPluginManager.getInstance().onYYJoinChannelSuc(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public void loadMediaPlugin(Context context, final MultiPluginLoadCallback multiPluginLoadCallback) {
        LiveMediaPluginManager.getInstance().loadPlugin(context, "com.baidu.live.media.business", "", new PluginLoadCallback() { // from class: com.baidu.searchbox.live.service.YY2MediaServiceImpl$loadMediaPlugin$1
            @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
            public void onResult(boolean z, int i, String str) {
                MultiPluginLoadCallback multiPluginLoadCallback2 = MultiPluginLoadCallback.this;
                if (multiPluginLoadCallback2 != null) {
                    multiPluginLoadCallback2.onResult(z, i, str);
                }
            }
        });
    }
}
