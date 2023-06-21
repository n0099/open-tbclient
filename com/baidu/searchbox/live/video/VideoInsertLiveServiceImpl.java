package com.baidu.searchbox.live.video;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.list.MixLiveActivity;
import com.baidu.searchbox.live.list.MixLiveTranslucentActivity;
import com.baidu.searchbox.live.video.LiveActInterfaceImpl;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0010R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/live/video/VideoInsertLiveServiceImpl;", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "checkAndLoadLivePlugin", "(Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;)V", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveActInterface", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;)Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "", "isLivePluginSupportVideoInsert", "()Z", "isRealLive", "", "scheme", "liveItemSelectedLog", "(ZLjava/lang/String;)V", "isLivePluginSupport", "livePluginSupportLog", "needReleaseLive", "releaseLive", "Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl;", "actInterface", "Lcom/baidu/searchbox/live/video/LiveActInterfaceImpl;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "pluginInvokeService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginInvokeService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoInsertLiveServiceImpl implements IVideoInsertLiveService {
    public LiveActInterfaceImpl actInterface;
    public final PluginInvokeService pluginInvokeService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());

    public final PluginInvokeService getPluginInvokeService() {
        return this.pluginInvokeService;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean isLivePluginSupportVideoInsert() {
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl isLivePluginSupportVideoInsert");
        PluginInvokeService pluginInvokeService = this.pluginInvokeService;
        boolean z = true;
        z = (pluginInvokeService == null || !pluginInvokeService.isLivePluginSupportInsertVideo()) ? false : false;
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("VideoInsertLiveServiceImpl isLivePluginSupportVideoInsert end: " + z);
        return z;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean needReleaseLive() {
        if (this.actInterface != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean releaseLive() {
        boolean z;
        LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
        companion.log("VideoInsertLiveServiceImpl releaseLive，存在的 actInterface " + this.actInterface);
        if (this.actInterface != null) {
            z = true;
        } else {
            z = false;
        }
        LiveActInterfaceImpl liveActInterfaceImpl = this.actInterface;
        if (liveActInterfaceImpl != null) {
            liveActInterfaceImpl.destroyLive();
        }
        this.actInterface = null;
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl releaseLive destroyLive end");
        return z;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void liveItemSelectedLog(boolean z, String str) {
        InsertLiveUbc.INSTANCE.liveItemSelectedLog(z, str);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void livePluginSupportLog(boolean z, String str) {
        InsertLiveUbc.INSTANCE.livePluginSupportLog(z, str);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void checkAndLoadLivePlugin(final IVideoInsertLiveService.LoadResultCallback loadResultCallback) {
        String str;
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl checkAndLoadLivePlugin");
        InsertLiveUbc.INSTANCE.insertLoadPluginStart();
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            str = appInfoService.getLiveAppId();
        } else {
            str = null;
        }
        String stringPlus = Intrinsics.stringPlus(str, "_video_insert_live");
        PluginInvokeService pluginInvokeService = this.pluginInvokeService;
        if (pluginInvokeService != null) {
            pluginInvokeService.checkAndLoadPluginInsertVideo(stringPlus, new IVideoInsertLiveService.LoadResultCallback() { // from class: com.baidu.searchbox.live.video.VideoInsertLiveServiceImpl$checkAndLoadLivePlugin$1
                @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService.LoadResultCallback
                public void onResult(boolean z) {
                    IVideoInsertLiveService.LoadResultCallback loadResultCallback2 = IVideoInsertLiveService.LoadResultCallback.this;
                    if (loadResultCallback2 != null) {
                        loadResultCallback2.onResult(z);
                    }
                }

                @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService.LoadResultCallback
                public void onEvent(boolean z, int i) {
                    InsertLiveUbc.INSTANCE.insertLoadPluginEnd(z, Integer.valueOf(i));
                }
            });
        }
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl checkAndLoadLivePlugin end");
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public ILiveActInterface getLiveActInterface(Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility) {
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 已有 actInterface: " + this.actInterface);
        Activity specifiedActivity = BdBoxActivityManager.getSpecifiedActivity(MixLiveActivity.class);
        MixLiveTranslucentActivity mixLiveTranslucentActivity = null;
        if (specifiedActivity != null) {
            LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 存在未销毁 MixLiveActivity, 执行销毁");
            if (!(specifiedActivity instanceof MixLiveActivity)) {
                specifiedActivity = null;
            }
            MixLiveActivity mixLiveActivity = (MixLiveActivity) specifiedActivity;
            if (mixLiveActivity != null) {
                mixLiveActivity.finishAndDispatchLifecycle();
            }
            LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 存在未销毁 MixLiveActivity, 执行销毁 end");
        }
        Activity specifiedActivity2 = BdBoxActivityManager.getSpecifiedActivity(MixLiveTranslucentActivity.class);
        if (specifiedActivity2 != null) {
            LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 存在未销毁 MixLiveTranslucentActivity，执行销毁");
            if (specifiedActivity2 instanceof MixLiveTranslucentActivity) {
                mixLiveTranslucentActivity = specifiedActivity2;
            }
            MixLiveTranslucentActivity mixLiveTranslucentActivity2 = mixLiveTranslucentActivity;
            if (mixLiveTranslucentActivity2 != null) {
                mixLiveTranslucentActivity2.finishAndDispatchLifecycle();
            }
            LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 存在未销毁 MixLiveTranslucentActivity，执行销毁 end");
        }
        LiveActInterfaceImpl liveActInterfaceImpl = this.actInterface;
        if (liveActInterfaceImpl != null) {
            liveActInterfaceImpl.destroyLive();
        }
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 销毁已有 actInterface end");
        this.actInterface = new LiveActInterfaceImpl(activity, iLiveToListInvokeAbility, new LiveActInterfaceImpl.ClearInterfaceCallback() { // from class: com.baidu.searchbox.live.video.VideoInsertLiveServiceImpl$getLiveActInterface$3
            @Override // com.baidu.searchbox.live.video.LiveActInterfaceImpl.ClearInterfaceCallback
            public void onClear() {
                LiveActInterfaceImpl liveActInterfaceImpl2;
                LiveActInterfaceImpl.Companion companion = LiveActInterfaceImpl.Companion;
                StringBuilder sb = new StringBuilder();
                sb.append("VideoInsertLiveServiceImpl getLiveActInterface onClear， ");
                liveActInterfaceImpl2 = VideoInsertLiveServiceImpl.this.actInterface;
                sb.append(liveActInterfaceImpl2);
                companion.log(sb.toString());
                VideoInsertLiveServiceImpl.this.actInterface = null;
            }
        });
        LiveActInterfaceImpl.Companion.log("VideoInsertLiveServiceImpl getLiveActInterface 保存新 actInterface " + iLiveToListInvokeAbility);
        return this.actInterface;
    }
}
