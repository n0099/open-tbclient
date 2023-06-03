package com.baidu.searchbox.yy.gameassist;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\"%\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"", "isDebug", "()Z", "", "tag", "msg", "", "yalog", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appService$delegate", "Lkotlin/Lazy;", "getAppService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "appService", "Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "yalogApi$delegate", "getYalogApi", "()Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;", "yalogApi", "lib-gameassist-host_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class YalogKt {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(YalogKt.class, "lib-gameassist-host_release"), "yalogApi", "getYalogApi()Lcom/baidu/searchbox/live/interfaces/yalog/LiveYalogApi;")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(YalogKt.class, "lib-gameassist-host_release"), "appService", "getAppService()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;"))};
    public static final Lazy yalogApi$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LiveYalogApi>() { // from class: com.baidu.searchbox.yy.gameassist.YalogKt$yalogApi$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LiveYalogApi invoke() {
            LiveYalogService liveYalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
            if (liveYalogService != null) {
                return liveYalogService.buildYalogApi("game_assist");
            }
            return null;
        }
    });
    public static final Lazy appService$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AppInfoService>() { // from class: com.baidu.searchbox.yy.gameassist.YalogKt$appService$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AppInfoService invoke() {
            return (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        }
    });

    public static final AppInfoService getAppService() {
        Lazy lazy = appService$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (AppInfoService) lazy.getValue();
    }

    public static final LiveYalogApi getYalogApi() {
        Lazy lazy = yalogApi$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (LiveYalogApi) lazy.getValue();
    }

    public static final boolean isDebug() {
        AppInfoService appService = getAppService();
        if (appService != null) {
            return appService.isDebug();
        }
        return false;
    }

    public static final void yalog(String str, String str2) {
        LiveYalogApi yalogApi = getYalogApi();
        if (yalogApi != null) {
            yalogApi.i("1120", str, str2);
        }
        if (isDebug()) {
            Log.e(str, str2);
        }
    }
}
