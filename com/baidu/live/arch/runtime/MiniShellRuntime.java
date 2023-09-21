package com.baidu.live.arch.runtime;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.baidu.live.arch.utils.MixUriUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\"\u0010#J)\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\u0019\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001a\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/baidu/live/arch/runtime/MiniShellRuntime;", "", "roomId", "source", "Landroid/net/Uri;", "uri", "buildLiveScheme", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;", "Landroid/app/Application;", "appApplication", "Landroid/app/Application;", "getAppApplication", "()Landroid/app/Application;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "", "isDebug", "Z", "()Z", "isMobileBaidu", "isNps$delegate", "Lkotlin/Lazy;", "isNps", "isTieba", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "service", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "getService", "()Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "setService", "(Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;)V", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MiniShellRuntime {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniShellRuntime.class), "isNps", "isNps()Z"))};
    public static final MiniShellRuntime INSTANCE = new MiniShellRuntime();
    public static final Application appApplication;
    public static final Context appContext;
    public static final boolean isDebug;
    public static final boolean isMobileBaidu;
    public static final Lazy isNps$delegate;
    public static final boolean isTieba;
    public static AppInfoService service;

    public final boolean isNps() {
        Lazy lazy = isNps$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    static {
        Boolean bool;
        String str;
        String str2;
        Application application;
        Object service2 = ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        Intrinsics.checkExpressionValueIsNotNull(service2, "ServiceManager.getServic…panion.SERVICE_REFERENCE)");
        AppInfoService appInfoService = (AppInfoService) service2;
        service = appInfoService;
        Application application2 = null;
        if (appInfoService != null) {
            bool = Boolean.valueOf(appInfoService.isDebug());
        } else {
            bool = null;
        }
        isDebug = bool.booleanValue();
        AppInfoService appInfoService2 = service;
        if (appInfoService2 != null) {
            str = appInfoService2.getLiveAppId();
        } else {
            str = null;
        }
        isMobileBaidu = "mobilebaidu".equals(str);
        AppInfoService appInfoService3 = service;
        if (appInfoService3 != null) {
            str2 = appInfoService3.getLiveAppId();
        } else {
            str2 = null;
        }
        isTieba = "tieba".equals(str2);
        AppInfoService appInfoService4 = service;
        if (appInfoService4 != null) {
            application = appInfoService4.getApplication();
        } else {
            application = null;
        }
        appApplication = application;
        AppInfoService appInfoService5 = service;
        if (appInfoService5 != null) {
            application2 = appInfoService5.getApplication();
        }
        appContext = application2;
        isNps$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.live.arch.runtime.MiniShellRuntime$isNps$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                try {
                    Class.forName("com.baidu.nps.main.manager.NPSManager");
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
    }

    public final Application getAppApplication() {
        return appApplication;
    }

    public final Context getAppContext() {
        return appContext;
    }

    public final AppInfoService getService() {
        return service;
    }

    public final boolean isDebug() {
        return isDebug;
    }

    public final boolean isMobileBaidu() {
        return isMobileBaidu;
    }

    public final boolean isTieba() {
        return isTieba;
    }

    public static /* synthetic */ String buildLiveScheme$default(MiniShellRuntime miniShellRuntime, String str, String str2, Uri uri, int i, Object obj) {
        if ((i & 4) != 0) {
            uri = null;
        }
        return miniShellRuntime.buildLiveScheme(str, str2, uri);
    }

    public final String buildLiveScheme(String str, String str2, Uri uri) {
        return MixUriUtilKt.buildScheme(str, str2, uri);
    }

    public final void setService(AppInfoService appInfoService) {
        service = appInfoService;
    }
}
