package com.baidu.live.framework.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.tieba.xb0;
/* loaded from: classes3.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public xb0 a;
    public int b;
    public int c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.c = 0;
    }

    public int E() {
        xb0 xb0Var = this.a;
        if (xb0Var != null) {
            return xb0Var.a();
        }
        return 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }

    public void F(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.C(v, i);
    }

    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        F(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new xb0(v);
        }
        this.a.b();
        int i2 = this.b;
        if (i2 != 0) {
            this.a.d(i2);
            this.b = 0;
        }
        int i3 = this.c;
        if (i3 != 0) {
            this.a.c(i3);
            this.c = 0;
            return true;
        }
        return true;
    }

    public boolean G(int i) {
        xb0 xb0Var = this.a;
        if (xb0Var != null) {
            return xb0Var.d(i);
        }
        this.b = i;
        return false;
    }
}
