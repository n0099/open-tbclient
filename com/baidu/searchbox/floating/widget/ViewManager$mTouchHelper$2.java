package com.baidu.searchbox.floating.widget;

import com.baidu.searchbox.floating.utils.TouchHelper;
import kotlin.h;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes9.dex */
public final class ViewManager$mTouchHelper$2 extends Lambda implements a<TouchHelper> {
    final /* synthetic */ ViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewManager$mTouchHelper$2(ViewManager viewManager) {
        super(0);
        this.this$0 = viewManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final TouchHelper invoke() {
        return new TouchHelper(this.this$0.getContext(), this.this$0.getConfig());
    }
}
