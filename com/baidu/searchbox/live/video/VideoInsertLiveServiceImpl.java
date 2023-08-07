package com.baidu.searchbox.live.video;

import android.app.Activity;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveToListInvokeAbility;
import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.host2live.video.LiveType;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0014R\u001d\u0010\"\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/baidu/searchbox/live/video/VideoInsertLiveServiceImpl;", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "Lcom/baidu/searchbox/live/host2live/video/LiveType;", "type", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "checkAndLoadLivePlugin", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;)V", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;", "invokeAbility", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveActInterface", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/video/ILiveToListInvokeAbility;)Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "getLiveImpl", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "", "isLivePluginSupportVideoInsert", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)Z", "isRealLive", "", "scheme", "liveItemSelectedLog", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;ZLjava/lang/String;)V", "isLivePluginSupport", "livePluginSupportLog", "needReleaseLive", "releaseLive", "mediaImpl$delegate", "Lkotlin/Lazy;", "getMediaImpl", "()Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;", "mediaImpl", "yyImpl$delegate", "getYyImpl", "yyImpl", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoInsertLiveServiceImpl implements IVideoInsertLiveService {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoInsertLiveServiceImpl.class), "mediaImpl", "getMediaImpl()Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoInsertLiveServiceImpl.class), "yyImpl", "getYyImpl()Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService;"))};
    public final Lazy mediaImpl$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VideoInsertMediaLiveServiceImpl>() { // from class: com.baidu.searchbox.live.video.VideoInsertLiveServiceImpl$mediaImpl$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoInsertMediaLiveServiceImpl invoke() {
            return new VideoInsertMediaLiveServiceImpl();
        }
    });
    public final Lazy yyImpl$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<VideoInsertYYLiveServiceImpl>() { // from class: com.baidu.searchbox.live.video.VideoInsertLiveServiceImpl$yyImpl$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoInsertYYLiveServiceImpl invoke() {
            return new VideoInsertYYLiveServiceImpl();
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LiveType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LiveType.MEDIA.ordinal()] = 1;
            $EnumSwitchMapping$0[LiveType.YY.ordinal()] = 2;
        }
    }

    private final IVideoInsertLiveService getMediaImpl() {
        Lazy lazy = this.mediaImpl$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (IVideoInsertLiveService) lazy.getValue();
    }

    private final IVideoInsertLiveService getYyImpl() {
        Lazy lazy = this.yyImpl$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (IVideoInsertLiveService) lazy.getValue();
    }

    private final IVideoInsertLiveService getLiveImpl(LiveType liveType) {
        int i = WhenMappings.$EnumSwitchMapping$0[liveType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return getYyImpl();
            }
            throw new NoWhenBranchMatchedException();
        }
        return getMediaImpl();
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean isLivePluginSupportVideoInsert(LiveType liveType) {
        return getLiveImpl(liveType).isLivePluginSupportVideoInsert(liveType);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean needReleaseLive(LiveType liveType) {
        return getLiveImpl(liveType).needReleaseLive(liveType);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public boolean releaseLive(LiveType liveType) {
        return getLiveImpl(liveType).releaseLive(liveType);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void checkAndLoadLivePlugin(LiveType liveType, IVideoInsertLiveService.LoadResultCallback loadResultCallback) {
        getLiveImpl(liveType).checkAndLoadLivePlugin(liveType, loadResultCallback);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public ILiveActInterface getLiveActInterface(LiveType liveType, Activity activity, ILiveToListInvokeAbility iLiveToListInvokeAbility) {
        return getLiveImpl(liveType).getLiveActInterface(liveType, activity, iLiveToListInvokeAbility);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void liveItemSelectedLog(LiveType liveType, boolean z, String str) {
        getLiveImpl(liveType).liveItemSelectedLog(liveType, z, str);
    }

    @Override // com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService
    public void livePluginSupportLog(LiveType liveType, boolean z, String str) {
        getLiveImpl(liveType).livePluginSupportLog(liveType, z, str);
    }
}
