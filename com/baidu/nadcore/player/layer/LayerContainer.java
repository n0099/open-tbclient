package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.qp0;
import com.baidu.tieba.wu0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public qp0 b;
    public ArrayList<wu0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull wu0 wu0Var) {
        b(wu0Var, getContainerParams());
    }

    public void c(@NonNull wu0 wu0Var) {
        e(wu0Var);
        wu0Var.M(this);
        wu0Var.s(getBindPlayer().y());
        this.c.add(0, wu0Var);
        if (wu0Var.getContentView() != null) {
            addView(wu0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull qp0 qp0Var) {
        this.b = qp0Var;
    }

    public void e(@NonNull wu0 wu0Var) {
        f(wu0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull wu0 wu0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(wu0Var);
        wu0Var.H();
        if (wu0Var.getContentView() != null && (viewGroup = (ViewGroup) wu0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(wu0Var.getContentView());
        }
        if (z) {
            wu0Var.t();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull wu0 wu0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(wu0Var)) {
            return;
        }
        wu0Var.M(this);
        wu0Var.F();
        wu0Var.s(getBindPlayer().y());
        this.c.add(wu0Var);
        if (wu0Var.getContentView() != null && wu0Var.getContentView() != this) {
            addView(wu0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public qp0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<wu0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<wu0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<wu0> it = arrayList.iterator();
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
