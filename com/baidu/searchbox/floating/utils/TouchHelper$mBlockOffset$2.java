package com.baidu.searchbox.floating.utils;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Rect;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TouchHelper$mBlockOffset$2 extends Lambda implements Function0<Rect> {
    public final /* synthetic */ TouchHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchHelper$mBlockOffset$2(TouchHelper touchHelper) {
        super(0);
        this.this$0 = touchHelper;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Rect invoke() {
        return new Rect(UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().left), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().top), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().right), UtilsKt.dpToPxByScale(this.this$0.getContext(), this.this$0.getConfig().getBlockOffset().bottom));
    }
}
