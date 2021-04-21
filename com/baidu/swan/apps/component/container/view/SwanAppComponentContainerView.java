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
import d.b.h0.a.a0.b.b;
import d.b.h0.a.a0.g.a;
import d.b.h0.a.c0.c;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    public static final boolean i = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public View f11795e;

    /* renamed from: f  reason: collision with root package name */
    public b f11796f;

    /* renamed from: g  reason: collision with root package name */
    public Path f11797g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f11798h;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    public final void a(Canvas canvas) {
        Path path;
        if (Build.VERSION.SDK_INT < 21 || (path = this.f11797g) == null || this.f11795e == null) {
            return;
        }
        b bVar = this.f11796f;
        if (bVar instanceof d.b.h0.a.a0.c.e.c.b) {
            d.b.h0.a.a0.c.e.c.b bVar2 = (d.b.h0.a.a0.c.e.c.b) bVar;
            if (bVar2.r > 0) {
                path.reset();
                Path path2 = this.f11797g;
                float left = this.f11795e.getLeft();
                float top = this.f11795e.getTop();
                float right = this.f11795e.getRight();
                float bottom = this.f11795e.getBottom();
                int i2 = bVar2.r;
                path2.addRoundRect(left, top, right, bottom, i2, i2, Path.Direction.CW);
                if (i) {
                    Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar2.r);
                }
                canvas.save();
                canvas.clipPath(this.f11797g);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        return this.f11798h;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void setHidden(boolean z) {
        View view = this.f11798h;
        if (view == null) {
            view = this;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public void setModel(@NonNull b bVar) {
        this.f11796f = bVar;
    }

    public void setScrollView(ScrollView scrollView) {
        this.f11798h = scrollView;
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i2) {
        if (this.f11795e == view) {
            c.l("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.f11797g == null) {
            this.f11797g = new Path();
        }
        if (this.f11795e != null) {
            a.a("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.f11795e);
        }
        this.f11795e = view;
        addView(view, i2, generateDefaultLayoutParams());
    }
}
