package com.baidu.searchbox.floating.widget;

import com.baidu.searchbox.floating.utils.TouchHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/floating/utils/TouchHelper;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ViewManager$mTouchHelper$2 extends Lambda implements Function0<TouchHelper> {
    public final /* synthetic */ ViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewManager$mTouchHelper$2(ViewManager viewManager) {
        super(0);
        this.this$0 = viewManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TouchHelper invoke() {
        return new TouchHelper(this.this$0.getContext(), this.this$0.getConfig());
    }
}
