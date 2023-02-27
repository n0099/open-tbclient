package com.baidu.live.arch.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/live/arch/utils/MiniUiThreadUtil;", "Ljava/lang/Runnable;", "runnable", "", "runOnUiThread", "(Ljava/lang/Runnable;)V", "", "postImmediate", "(Ljava/lang/Runnable;Z)V", "Landroid/os/Handler;", "sMainHandler$delegate", "Lkotlin/Lazy;", "getSMainHandler", "()Landroid/os/Handler;", "sMainHandler", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniUiThreadUtil {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniUiThreadUtil.class), "sMainHandler", "getSMainHandler()Landroid/os/Handler;"))};
    public static final MiniUiThreadUtil INSTANCE = new MiniUiThreadUtil();
    public static final Lazy sMainHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.live.arch.utils.MiniUiThreadUtil$sMainHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    private final Handler getSMainHandler() {
        Lazy lazy = sMainHandler$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    public static /* synthetic */ void runOnUiThread$default(MiniUiThreadUtil miniUiThreadUtil, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        miniUiThreadUtil.runOnUiThread(runnable, z);
    }

    public final void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, false);
    }

    public final void runOnUiThread(Runnable runnable, boolean z) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        if (currentThread != mainLooper.getThread()) {
            if (z) {
                getSMainHandler().postAtFrontOfQueue(runnable);
                return;
            } else {
                getSMainHandler().post(runnable);
                return;
            }
        }
        runnable.run();
    }
}
