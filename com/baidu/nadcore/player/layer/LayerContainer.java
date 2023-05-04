package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.bs0;
import com.baidu.tieba.ix0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public bs0 b;
    public ArrayList<ix0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull ix0 ix0Var) {
        b(ix0Var, getContainerParams());
    }

    public void c(@NonNull ix0 ix0Var) {
        e(ix0Var);
        ix0Var.K(this);
        ix0Var.r(getBindPlayer().x());
        this.c.add(0, ix0Var);
        if (ix0Var.getContentView() != null) {
            addView(ix0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull bs0 bs0Var) {
        this.b = bs0Var;
    }

    public void e(@NonNull ix0 ix0Var) {
        f(ix0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull ix0 ix0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(ix0Var);
        ix0Var.F();
        if (ix0Var.getContentView() != null && (viewGroup = (ViewGroup) ix0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(ix0Var.getContentView());
        }
        if (z) {
            ix0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull ix0 ix0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(ix0Var)) {
            return;
        }
        ix0Var.K(this);
        ix0Var.D();
        ix0Var.r(getBindPlayer().x());
        this.c.add(ix0Var);
        if (ix0Var.getContentView() != null && ix0Var.getContentView() != this) {
            addView(ix0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public bs0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<ix0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<ix0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<ix0> it = arrayList.iterator();
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
