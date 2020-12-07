package com.baidu.searchbox.floating.utils;

import kotlin.e;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
@e
/* loaded from: classes16.dex */
final class TouchHelper$mScreenHeight$2 extends Lambda implements a<Integer> {
    final /* synthetic */ TouchHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchHelper$mScreenHeight$2(TouchHelper touchHelper) {
        super(0);
        this.this$0 = touchHelper;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX DEBUG: Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [int, java.lang.Integer] */
    @Override // kotlin.jvm.a.a
    public final Integer invoke() {
        return UtilsKt.getScreenHeight(this.this$0.getContext());
    }
}
