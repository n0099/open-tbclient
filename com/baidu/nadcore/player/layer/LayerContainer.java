package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ex0;
import com.baidu.tieba.xr0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public xr0 b;
    public ArrayList<ex0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull ex0 ex0Var) {
        b(ex0Var, getContainerParams());
    }

    public void c(@NonNull ex0 ex0Var) {
        e(ex0Var);
        ex0Var.L(this);
        ex0Var.r(getBindPlayer().x());
        this.c.add(0, ex0Var);
        if (ex0Var.getContentView() != null) {
            addView(ex0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull xr0 xr0Var) {
        this.b = xr0Var;
    }

    public void e(@NonNull ex0 ex0Var) {
        f(ex0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull ex0 ex0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(ex0Var);
        ex0Var.F();
        if (ex0Var.getContentView() != null && (viewGroup = (ViewGroup) ex0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(ex0Var.getContentView());
        }
        if (z) {
            ex0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull ex0 ex0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(ex0Var)) {
            return;
        }
        ex0Var.L(this);
        ex0Var.D();
        ex0Var.r(getBindPlayer().x());
        this.c.add(ex0Var);
        if (ex0Var.getContentView() != null && ex0Var.getContentView() != this) {
            addView(ex0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public xr0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<ex0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<ex0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<ex0> it = arrayList.iterator();
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
