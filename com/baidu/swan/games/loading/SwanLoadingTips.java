package com.baidu.swan.games.loading;

import android.annotation.SuppressLint;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R%\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/swan/games/loading/SwanLoadingTips;", "", "getNextLoadingTips", "()Ljava/lang/String;", "", "currentTipsPosition", "I", "", "loadingTips$delegate", "Lkotlin/Lazy;", "getLoadingTips", "()[Ljava/lang/String;", "loadingTips", "<init>", "()V", "lib-swan-core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes3.dex */
public final class SwanLoadingTips {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f12518c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SwanLoadingTips.class), "loadingTips", "getLoadingTips()[Ljava/lang/String;"))};

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f12519a = LazyKt__LazyJVMKt.lazy(SwanLoadingTips$loadingTips$2.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    public int f12520b;

    public final String[] a() {
        Lazy lazy = this.f12519a;
        KProperty kProperty = f12518c[0];
        return (String[]) lazy.getValue();
    }

    public final String b() {
        String[] a2 = a();
        if (a2 != null) {
            if (a2.length == 0) {
                return "";
            }
            int i = this.f12520b;
            String str = a2[i % a2.length];
            this.f12520b = i + 1;
            return str;
        }
        return "";
    }
}
