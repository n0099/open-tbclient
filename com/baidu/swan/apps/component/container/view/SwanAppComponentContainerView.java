package com.baidu.swan.apps.component.container.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import d.b.g0.a.a0.b.b;
import d.b.g0.a.a0.g.a;
import d.b.g0.a.c0.c;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    public static final boolean i = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public View f12126e;

    /* renamed from: f  reason: collision with root package name */
    public b f12127f;

    /* renamed from: g  reason: collision with root package name */
    public Path f12128g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f12129h;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    public final void a(Canvas canvas) {
        Path path;
        if (Build.VERSION.SDK_INT < 21 || (path = this.f12128g) == null || this.f12126e == null) {
            return;
        }
        b bVar = this.f12127f;
        if (bVar instanceof d.b.g0.a.a0.c.e.c.b) {
            d.b.g0.a.a0.c.e.c.b bVar2 = (d.b.g0.a.a0.c.e.c.b) bVar;
            if (bVar2.r > 0) {
                path.reset();
                Path path2 = this.f12128g;
                float left = this.f12126e.getLeft();
                float top = this.f12126e.getTop();
                float right = this.f12126e.getRight();
                float bottom = this.f12126e.getBottom();
                int i2 = bVar2.r;
                path2.addRoundRect(left, top, right, bottom, i2, i2, Path.Direction.CW);
                if (i) {
                    Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar2.r);
                }
                canvas.save();
                canvas.clipPath(this.f12128g);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        return this.f12129h;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void setHidden(boolean z) {
        View view = this.f12129h;
        if (view == null) {
            view = this;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public void setModel(@NonNull b bVar) {
        this.f12127f = bVar;
    }

    public void setScrollView(ScrollView scrollView) {
        this.f12129h = scrollView;
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i2) {
        if (this.f12126e == view) {
            c.l("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.f12128g == null) {
            this.f12128g = new Path();
        }
        if (this.f12126e != null) {
            a.a("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.f12126e);
        }
        this.f12126e = view;
        addView(view, i2, generateDefaultLayoutParams());
    }
}
