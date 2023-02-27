package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ht0;
import com.baidu.tieba.oy0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public ht0 b;
    public ArrayList<oy0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull oy0 oy0Var) {
        b(oy0Var, getContainerParams());
    }

    public void c(@NonNull oy0 oy0Var) {
        e(oy0Var);
        oy0Var.J(this);
        oy0Var.r(getBindPlayer().x());
        this.c.add(0, oy0Var);
        if (oy0Var.getContentView() != null) {
            addView(oy0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull ht0 ht0Var) {
        this.b = ht0Var;
    }

    public void e(@NonNull oy0 oy0Var) {
        f(oy0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull oy0 oy0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(oy0Var);
        oy0Var.D();
        if (oy0Var.getContentView() != null && (viewGroup = (ViewGroup) oy0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(oy0Var.getContentView());
        }
        if (z) {
            oy0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull oy0 oy0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(oy0Var)) {
            return;
        }
        oy0Var.J(this);
        oy0Var.B();
        oy0Var.r(getBindPlayer().x());
        this.c.add(oy0Var);
        if (oy0Var.getContentView() != null && oy0Var.getContentView() != this) {
            addView(oy0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public ht0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<oy0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<oy0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<oy0> it = arrayList.iterator();
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
