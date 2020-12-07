package com.baidu.searchbox.floating.utils;

import android.graphics.Rect;
import kotlin.e;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
@e
/* loaded from: classes16.dex */
final class TouchHelper$mBlockOffset$2 extends Lambda implements a<Rect> {
    final /* synthetic */ TouchHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchHelper$mBlockOffset$2(TouchHelper touchHelper) {
        super(0);
        this.this$0 = touchHelper;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final Rect invoke() {
        return new Rect(UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().left), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().top), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().right), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().bottom));
    }
}
