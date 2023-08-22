package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.fz0;
import com.baidu.tieba.yt0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public yt0 b;
    public ArrayList<fz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull fz0 fz0Var) {
        b(fz0Var, getContainerParams());
    }

    public void c(@NonNull fz0 fz0Var) {
        e(fz0Var);
        fz0Var.K(this);
        fz0Var.r(getBindPlayer().x());
        this.c.add(0, fz0Var);
        if (fz0Var.getContentView() != null) {
            addView(fz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull yt0 yt0Var) {
        this.b = yt0Var;
    }

    public void e(@NonNull fz0 fz0Var) {
        f(fz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull fz0 fz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(fz0Var);
        fz0Var.F();
        if (fz0Var.getContentView() != null && (viewGroup = (ViewGroup) fz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(fz0Var.getContentView());
        }
        if (z) {
            fz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull fz0 fz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(fz0Var)) {
            return;
        }
        fz0Var.K(this);
        fz0Var.D();
        fz0Var.r(getBindPlayer().x());
        this.c.add(fz0Var);
        if (fz0Var.getContentView() != null && fz0Var.getContentView() != this) {
            addView(fz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public yt0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<fz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<fz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<fz0> it = arrayList.iterator();
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
