package com.baidu.searchbox.floating.utils;

import android.view.View;
import kotlin.h;
import kotlin.jvm.a.b;
@h
/* loaded from: classes9.dex */
public final class FloatingViewClickUtilKt$click$1 implements View.OnClickListener {
    final /* synthetic */ b $block;
    final /* synthetic */ long $time;
    final /* synthetic */ View receiver$0;

    public FloatingViewClickUtilKt$click$1(View view, long j, b bVar) {
        this.receiver$0 = view;
        this.$time = j;
        this.$block = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(this.receiver$0) > this.$time) {
            FloatingViewClickUtilKt.setLastClickTime(this.receiver$0, currentTimeMillis);
            this.$block.invoke(this.receiver$0);
        }
    }
}
