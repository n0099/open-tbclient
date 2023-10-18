package com.baidu.searchbox.live.host2live.video;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u0012J\u0019\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/host2live/video/LiveType;", "type", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "checkAndLoadLivePlugin", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;)V", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveActInterface", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;)Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "", "isLivePluginSupportVideoInsert", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)Z", "isRealLive", "", "scheme", "liveItemSelectedLog", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;ZLjava/lang/String;)V", "isLivePluginSupport", "livePluginSupportLog", "needReleaseLive", "releaseLive", "Companion", "LoadResultCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IVideoInsertLiveService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", "Lkotlin/Any;", "", "result", "", "code", "", "onEvent", "(ZI)V", "onResult", "(Z)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface LoadResultCallback {
        void onEvent(boolean z, int i);

        void onResult(boolean z);
    }

    void checkAndLoadLivePlugin(LiveType liveType, LoadResultCallback loadResultCallback);

    ILiveActInterface getLiveActInterface(LiveType liveType, Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility);

    boolean isLivePluginSupportVideoInsert(LiveType liveType);

    void liveItemSelectedLog(LiveType liveType, boolean z, String str);

    void livePluginSupportLog(LiveType liveType, boolean z, String str);

    boolean needReleaseLive(LiveType liveType);

    boolean releaseLive(LiveType liveType);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_INSERT_VIDEO);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ILiveActInterface getLiveActInterface$default(IVideoInsertLiveService iVideoInsertLiveService, LiveType liveType, Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    iLiveToListInvokeAbility = null;
                }
                return iVideoInsertLiveService.getLiveActInterface(liveType, activity, iLiveToListInvokeAbility);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLiveActInterface");
        }

        public static /* synthetic */ void liveItemSelectedLog$default(IVideoInsertLiveService iVideoInsertLiveService, LiveType liveType, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = "";
                }
                iVideoInsertLiveService.liveItemSelectedLog(liveType, z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveItemSelectedLog");
        }

        public static /* synthetic */ void livePluginSupportLog$default(IVideoInsertLiveService iVideoInsertLiveService, LiveType liveType, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = "";
                }
                iVideoInsertLiveService.livePluginSupportLog(liveType, z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: livePluginSupportLog");
        }

        public static /* synthetic */ boolean needReleaseLive$default(IVideoInsertLiveService iVideoInsertLiveService, LiveType liveType, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    liveType = LiveType.MEDIA;
                }
                return iVideoInsertLiveService.needReleaseLive(liveType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: needReleaseLive");
        }

        public static /* synthetic */ boolean releaseLive$default(IVideoInsertLiveService iVideoInsertLiveService, LiveType liveType, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    liveType = LiveType.MEDIA;
                }
                return iVideoInsertLiveService.releaseLive(liveType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: releaseLive");
        }
    }
}
