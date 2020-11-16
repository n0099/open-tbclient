package com.baidu.searchbox.floating.widget;

import kotlin.h;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes9.dex */
public final class ViewManager$mContainer$2 extends Lambda implements a<FloatContainer> {
    final /* synthetic */ ViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewManager$mContainer$2(ViewManager viewManager) {
        super(0);
        this.this$0 = viewManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final FloatContainer invoke() {
        return new FloatContainer(this.this$0.getConfig(), this.this$0.getContext(), null, 0, 12, null);
    }
}
