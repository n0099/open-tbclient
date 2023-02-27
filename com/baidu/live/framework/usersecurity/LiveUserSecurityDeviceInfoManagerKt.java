package com.baidu.live.framework.usersecurity;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\"%\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"", "purpose", "getManufacturer", "(Ljava/lang/String;)Ljava/lang/String;", "getModel", "", "isDeviceInfoServiceAvailable", "()Z", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "kotlin.jvm.PlatformType", "service$delegate", "Lkotlin/Lazy;", "getService", "()Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "service", "lib-live-feed-page_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveUserSecurityDeviceInfoManagerKt {
    public static final /* synthetic */ KProperty[] a = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(LiveUserSecurityDeviceInfoManagerKt.class, "lib-live-feed-page_release"), "service", "getService()Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;"))};
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(new Function0<LiveUserSecurityDeviceInfoService>() { // from class: com.baidu.live.framework.usersecurity.LiveUserSecurityDeviceInfoManagerKt$service$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LiveUserSecurityDeviceInfoService invoke() {
            return (LiveUserSecurityDeviceInfoService) ServiceManager.getService(LiveUserSecurityDeviceInfoService.Companion.getSERVICE_REFERENCE());
        }
    });

    public static final LiveUserSecurityDeviceInfoService c() {
        Lazy lazy = b;
        KProperty kProperty = a[0];
        return (LiveUserSecurityDeviceInfoService) lazy.getValue();
    }

    public static final boolean d() {
        if (c() != null) {
            return true;
        }
        return false;
    }

    public static final String a(String str) {
        String manufacturer;
        LiveUserSecurityDeviceInfoService c = c();
        if (c == null || (manufacturer = c.getManufacturer(str)) == null) {
            return "";
        }
        return manufacturer;
    }

    public static /* synthetic */ String b(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return a(str);
    }
}
