package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup$MarginLayoutParams;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadVideoRewardCountDownView$attachToViewGroup$1 extends Lambda implements Function0<ViewGroup.MarginLayoutParams> {
    public final /* synthetic */ NadVideoRewardCountDownView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoRewardCountDownView$attachToViewGroup$1(NadVideoRewardCountDownView nadVideoRewardCountDownView) {
        super(0);
        this.this$0 = nadVideoRewardCountDownView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup.MarginLayoutParams invoke() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        marginLayoutParams.leftMargin = ExtensionsKt.d(14, context);
        Context context2 = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        marginLayoutParams.topMargin = ExtensionsKt.d(6, context2);
        return marginLayoutParams;
    }
}
