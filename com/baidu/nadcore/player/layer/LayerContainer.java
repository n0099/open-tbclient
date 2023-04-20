package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.gx0;
import com.baidu.tieba.zr0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public zr0 b;
    public ArrayList<gx0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull gx0 gx0Var) {
        b(gx0Var, getContainerParams());
    }

    public void c(@NonNull gx0 gx0Var) {
        e(gx0Var);
        gx0Var.K(this);
        gx0Var.r(getBindPlayer().x());
        this.c.add(0, gx0Var);
        if (gx0Var.getContentView() != null) {
            addView(gx0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull zr0 zr0Var) {
        this.b = zr0Var;
    }

    public void e(@NonNull gx0 gx0Var) {
        f(gx0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull gx0 gx0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(gx0Var);
        gx0Var.F();
        if (gx0Var.getContentView() != null && (viewGroup = (ViewGroup) gx0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(gx0Var.getContentView());
        }
        if (z) {
            gx0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull gx0 gx0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(gx0Var)) {
            return;
        }
        gx0Var.K(this);
        gx0Var.D();
        gx0Var.r(getBindPlayer().x());
        this.c.add(gx0Var);
        if (gx0Var.getContentView() != null && gx0Var.getContentView() != this) {
            addView(gx0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public zr0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<gx0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<gx0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<gx0> it = arrayList.iterator();
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
