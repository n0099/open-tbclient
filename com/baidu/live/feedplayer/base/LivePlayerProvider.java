package com.baidu.live.feedplayer.base;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.player.BuildParams;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR%\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/live/feedplayer/base/LivePlayerProvider;", "", "roomId", "Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "createPlayer", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/player/LivePlayer;", "", "initPlayerEvn", "()V", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "kotlin.jvm.PlatformType", "playerService$delegate", "Lkotlin/Lazy;", "getPlayerService", "()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;", "playerService", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LivePlayerProvider {
    public static final /* synthetic */ KProperty[] a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LivePlayerProvider.class), "playerService", "getPlayerService()Lcom/baidu/searchbox/live/interfaces/service/ILivePlayerService;"))};
    public static final LivePlayerProvider c = new LivePlayerProvider();
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(new Function0<ILivePlayerService>() { // from class: com.baidu.live.feedplayer.base.LivePlayerProvider$playerService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILivePlayerService invoke() {
            return (ILivePlayerService) ServiceManager.getService(ILivePlayerService.Companion.getSERVICE_REFERENCE());
        }
    });

    public final ILivePlayerService b() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return (ILivePlayerService) lazy.getValue();
    }

    public final LivePlayer a(String str) {
        return b().createPlayer(new BuildParams(str));
    }
}
