package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.cz0;
import com.baidu.tieba.vt0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public vt0 b;
    public ArrayList<cz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull cz0 cz0Var) {
        b(cz0Var, getContainerParams());
    }

    public void c(@NonNull cz0 cz0Var) {
        e(cz0Var);
        cz0Var.K(this);
        cz0Var.r(getBindPlayer().x());
        this.c.add(0, cz0Var);
        if (cz0Var.getContentView() != null) {
            addView(cz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull vt0 vt0Var) {
        this.b = vt0Var;
    }

    public void e(@NonNull cz0 cz0Var) {
        f(cz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull cz0 cz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(cz0Var);
        cz0Var.F();
        if (cz0Var.getContentView() != null && (viewGroup = (ViewGroup) cz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(cz0Var.getContentView());
        }
        if (z) {
            cz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull cz0 cz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(cz0Var)) {
            return;
        }
        cz0Var.K(this);
        cz0Var.D();
        cz0Var.r(getBindPlayer().x());
        this.c.add(cz0Var);
        if (cz0Var.getContentView() != null && cz0Var.getContentView() != this) {
            addView(cz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public vt0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<cz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<cz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<cz0> it = arrayList.iterator();
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
