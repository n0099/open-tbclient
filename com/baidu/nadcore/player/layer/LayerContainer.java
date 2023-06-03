package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.au0;
import com.baidu.tieba.hz0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public au0 b;
    public ArrayList<hz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull hz0 hz0Var) {
        b(hz0Var, getContainerParams());
    }

    public void c(@NonNull hz0 hz0Var) {
        e(hz0Var);
        hz0Var.K(this);
        hz0Var.r(getBindPlayer().x());
        this.c.add(0, hz0Var);
        if (hz0Var.getContentView() != null) {
            addView(hz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull au0 au0Var) {
        this.b = au0Var;
    }

    public void e(@NonNull hz0 hz0Var) {
        f(hz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull hz0 hz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(hz0Var);
        hz0Var.F();
        if (hz0Var.getContentView() != null && (viewGroup = (ViewGroup) hz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(hz0Var.getContentView());
        }
        if (z) {
            hz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull hz0 hz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(hz0Var)) {
            return;
        }
        hz0Var.K(this);
        hz0Var.D();
        hz0Var.r(getBindPlayer().x());
        this.c.add(hz0Var);
        if (hz0Var.getContentView() != null && hz0Var.getContentView() != this) {
            addView(hz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public au0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<hz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<hz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<hz0> it = arrayList.iterator();
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
