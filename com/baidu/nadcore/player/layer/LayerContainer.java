package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.su0;
import com.baidu.tieba.zz0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public su0 b;
    public ArrayList<zz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull zz0 zz0Var) {
        b(zz0Var, getContainerParams());
    }

    public void c(@NonNull zz0 zz0Var) {
        e(zz0Var);
        zz0Var.L(this);
        zz0Var.r(getBindPlayer().x());
        this.c.add(0, zz0Var);
        if (zz0Var.getContentView() != null) {
            addView(zz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull su0 su0Var) {
        this.b = su0Var;
    }

    public void e(@NonNull zz0 zz0Var) {
        f(zz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull zz0 zz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(zz0Var);
        zz0Var.F();
        if (zz0Var.getContentView() != null && (viewGroup = (ViewGroup) zz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(zz0Var.getContentView());
        }
        if (z) {
            zz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull zz0 zz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(zz0Var)) {
            return;
        }
        zz0Var.L(this);
        zz0Var.D();
        zz0Var.r(getBindPlayer().x());
        this.c.add(zz0Var);
        if (zz0Var.getContentView() != null && zz0Var.getContentView() != this) {
            addView(zz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public su0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<zz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<zz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<zz0> it = arrayList.iterator();
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
