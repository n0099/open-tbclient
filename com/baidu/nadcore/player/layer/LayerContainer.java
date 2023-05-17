package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.rs0;
import com.baidu.tieba.yx0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public rs0 b;
    public ArrayList<yx0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull yx0 yx0Var) {
        b(yx0Var, getContainerParams());
    }

    public void c(@NonNull yx0 yx0Var) {
        e(yx0Var);
        yx0Var.K(this);
        yx0Var.r(getBindPlayer().x());
        this.c.add(0, yx0Var);
        if (yx0Var.getContentView() != null) {
            addView(yx0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull rs0 rs0Var) {
        this.b = rs0Var;
    }

    public void e(@NonNull yx0 yx0Var) {
        f(yx0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull yx0 yx0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(yx0Var);
        yx0Var.F();
        if (yx0Var.getContentView() != null && (viewGroup = (ViewGroup) yx0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(yx0Var.getContentView());
        }
        if (z) {
            yx0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull yx0 yx0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(yx0Var)) {
            return;
        }
        yx0Var.K(this);
        yx0Var.D();
        yx0Var.r(getBindPlayer().x());
        this.c.add(yx0Var);
        if (yx0Var.getContentView() != null && yx0Var.getContentView() != this) {
            addView(yx0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public rs0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<yx0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<yx0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<yx0> it = arrayList.iterator();
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
