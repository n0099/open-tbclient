package com.baidu.searchbox.live.video;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.host2live.video.LiveType;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0012R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/video/VideoInsertYYLiveServiceImpl;", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "Lcom/baidu/searchbox/live/host2live/video/LiveType;", "type", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "checkAndLoadLivePlugin", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;)V", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveActInterface", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;)Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "", "isLivePluginSupportVideoInsert", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)Z", "isRealLive", "", "scheme", "liveItemSelectedLog", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;ZLjava/lang/String;)V", "isLivePluginSupport", "livePluginSupportLog", "needReleaseLive", "releaseLive", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "service", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoInsertYYLiveServiceImpl implements IVideoInsertLiveService {
    public final PluginInvokeService service = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void checkAndLoadLivePlugin(LiveType liveType, IVideoInsertLiveService.LoadResultCallback loadResultCallback) {
        String str;
        VideoInsertLiveServiceImplKt.log(this, "checkAndLoadLivePlugin");
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            str = appInfoService.getLiveAppId();
        } else {
            str = null;
        }
        String stringPlus = Intrinsics.stringPlus(str, "_video_insert_live");
        PluginInvokeService pluginInvokeService = this.service;
        if (pluginInvokeService != null) {
            pluginInvokeService.checkAndLoadYYPluginInsertVideo(stringPlus, loadResultCallback);
        }
        VideoInsertLiveServiceImplKt.log(this, "checkAndLoadLivePlugin end");
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public ILiveActInterface getLiveActInterface(LiveType liveType, Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility) {
        ILiveActInterface iLiveActInterface;
        VideoInsertLiveServiceImplKt.log(this, "getLiveActInterface");
        PluginInvokeService pluginInvokeService = this.service;
        if (pluginInvokeService != null) {
            iLiveActInterface = pluginInvokeService.getLiveActInterface(activity, iLiveToListInvokeAbility);
        } else {
            iLiveActInterface = null;
        }
        VideoInsertLiveServiceImplKt.log(this, "getLiveActInterface end " + iLiveActInterface);
        return iLiveActInterface;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void liveItemSelectedLog(LiveType liveType, boolean z, String str) {
        VideoInsertLiveServiceImplKt.log(this, "liveItemSelectedLog " + z + WebvttCueParser.CHAR_SPACE + str);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void livePluginSupportLog(LiveType liveType, boolean z, String str) {
        VideoInsertLiveServiceImplKt.log(this, "livePluginSupportLog " + z + WebvttCueParser.CHAR_SPACE + str);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean isLivePluginSupportVideoInsert(LiveType liveType) {
        VideoInsertLiveServiceImplKt.log(this, "isLivePluginSupportVideoInsert");
        PluginInvokeService pluginInvokeService = this.service;
        boolean z = true;
        z = (pluginInvokeService == null || !pluginInvokeService.isYYLivePluginSupportInsertVideo()) ? false : false;
        VideoInsertLiveServiceImplKt.log(this, "isLivePluginSupportVideoInsert end: " + z);
        return z;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean needReleaseLive(LiveType liveType) {
        VideoInsertLiveServiceImplKt.log(this, "needReleaseLive");
        return false;
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean releaseLive(LiveType liveType) {
        VideoInsertLiveServiceImplKt.log(this, "releaseLive");
        return false;
    }
}
