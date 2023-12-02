package com.baidu.nadcore.widget.optimize;

import android.view.View;
import com.baidu.tieba.s81;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final /* synthetic */ class NadViewOptStubWrapper$setVisibility$1 extends MutablePropertyReference0Impl {
    public NadViewOptStubWrapper$setVisibility$1(s81 s81Var) {
        super(s81Var, s81.class, "theRealView", "getTheRealView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return s81.a((s81) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((s81) this.receiver).b = (View) obj;
    }
}
