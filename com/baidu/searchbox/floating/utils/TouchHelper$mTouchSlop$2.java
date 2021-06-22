package com.baidu.searchbox.floating.utils;

import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TouchHelper$mTouchSlop$2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ TouchHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchHelper$mTouchSlop$2(TouchHelper touchHelper) {
        super(0);
        this.this$0 = touchHelper;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX DEBUG: Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, java.lang.Integer] */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.this$0.getContext());
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
        return viewConfiguration.getScaledTouchSlop();
    }
}
