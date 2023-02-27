package com.baidu.live.business.test;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\f\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR#\u0010\u000f\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/live/business/test/LiveFeedAbTest;", "", "KEY_PLAY_TEST", "Ljava/lang/String;", "", "isPlayTest0$delegate", "Lkotlin/Lazy;", "isPlayTest0", "()Z", "isPlayTest0$annotations", "()V", "isPlayTest1$delegate", "isPlayTest1", "isPlayTest1$annotations", "isPlayTest2$delegate", "isPlayTest2", "isPlayTest2$annotations", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedAbTest {
    public static final Lazy b;
    public static final Lazy c;
    public static final /* synthetic */ KProperty[] a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest0", "isPlayTest0()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest1", "isPlayTest1()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest2", "isPlayTest2()Z"))};
    public static final LiveFeedAbTest d = new LiveFeedAbTest();

    public static final boolean a() {
        Lazy lazy = b;
        KProperty kProperty = a[1];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    public static final boolean b() {
        Lazy lazy = c;
        KProperty kProperty = a[2];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    static {
        LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.live.business.test.LiveFeedAbTest$isPlayTest0$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                try {
                    AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
                    if (abConfigService == null) {
                        return false;
                    }
                    if (((Number) abConfigService.getSwitch("android_live_feed_page_autoplay_type_ab")).intValue() != 0) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        b = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.live.business.test.LiveFeedAbTest$isPlayTest1$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                try {
                    AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
                    if (abConfigService == null) {
                        return false;
                    }
                    if (((Number) abConfigService.getSwitch("android_live_feed_page_autoplay_type_ab")).intValue() != 1) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        c = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.baidu.live.business.test.LiveFeedAbTest$isPlayTest2$2
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                try {
                    AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
                    if (abConfigService == null) {
                        return false;
                    }
                    if (((Number) abConfigService.getSwitch("android_live_feed_page_autoplay_type_ab")).intValue() != 2) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }
}
