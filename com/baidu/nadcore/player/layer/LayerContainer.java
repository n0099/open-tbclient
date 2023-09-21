package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.bu0;
import com.baidu.tieba.iz0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public bu0 b;
    public ArrayList<iz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull iz0 iz0Var) {
        b(iz0Var, getContainerParams());
    }

    public void c(@NonNull iz0 iz0Var) {
        e(iz0Var);
        iz0Var.K(this);
        iz0Var.r(getBindPlayer().x());
        this.c.add(0, iz0Var);
        if (iz0Var.getContentView() != null) {
            addView(iz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull bu0 bu0Var) {
        this.b = bu0Var;
    }

    public void e(@NonNull iz0 iz0Var) {
        f(iz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull iz0 iz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(iz0Var);
        iz0Var.F();
        if (iz0Var.getContentView() != null && (viewGroup = (ViewGroup) iz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(iz0Var.getContentView());
        }
        if (z) {
            iz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull iz0 iz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(iz0Var)) {
            return;
        }
        iz0Var.K(this);
        iz0Var.D();
        iz0Var.r(getBindPlayer().x());
        this.c.add(iz0Var);
        if (iz0Var.getContentView() != null && iz0Var.getContentView() != this) {
            addView(iz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public bu0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<iz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<iz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<iz0> it = arrayList.iterator();
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
