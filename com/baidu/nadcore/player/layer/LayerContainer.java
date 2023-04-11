package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.fx0;
import com.baidu.tieba.yr0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public yr0 b;
    public ArrayList<fx0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull fx0 fx0Var) {
        b(fx0Var, getContainerParams());
    }

    public void c(@NonNull fx0 fx0Var) {
        e(fx0Var);
        fx0Var.K(this);
        fx0Var.r(getBindPlayer().x());
        this.c.add(0, fx0Var);
        if (fx0Var.getContentView() != null) {
            addView(fx0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull yr0 yr0Var) {
        this.b = yr0Var;
    }

    public void e(@NonNull fx0 fx0Var) {
        f(fx0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull fx0 fx0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(fx0Var);
        fx0Var.F();
        if (fx0Var.getContentView() != null && (viewGroup = (ViewGroup) fx0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(fx0Var.getContentView());
        }
        if (z) {
            fx0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull fx0 fx0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(fx0Var)) {
            return;
        }
        fx0Var.K(this);
        fx0Var.D();
        fx0Var.r(getBindPlayer().x());
        this.c.add(fx0Var);
        if (fx0Var.getContentView() != null && fx0Var.getContentView() != this) {
            addView(fx0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public yr0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<fx0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<fx0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<fx0> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    public void i() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).onLayerRelease();
        }
        this.c.clear();
        removeAllViews();
    }
}
