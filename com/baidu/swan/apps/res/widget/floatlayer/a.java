package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes25.dex */
public class a {
    private final InterfaceC0480a dxw;
    private final ViewGroup dxx;
    private boolean dxy;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0480a {
        a aih();
    }

    public a(@NonNull InterfaceC0480a interfaceC0480a, @NonNull ViewGroup viewGroup, int i) {
        this.dxw = interfaceC0480a;
        this.dxx = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aJF = aJF();
        if (aJF != null) {
            aJF.setClickable(z);
        }
    }

    public boolean aJE() {
        return this.dxy;
    }

    private Context getContext() {
        return this.dxx.getContext();
    }

    @Nullable
    private Container aJF() {
        Container container;
        synchronized (this.dxx) {
            int i = 0;
            while (true) {
                if (i < this.dxx.getChildCount()) {
                    View childAt = this.dxx.getChildAt(i);
                    if (!(childAt instanceof Container)) {
                        i++;
                    } else {
                        container = (Container) childAt;
                        break;
                    }
                } else {
                    container = null;
                    break;
                }
            }
        }
        return container;
    }

    @NonNull
    private Container aJG() {
        Container aJF;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.dxx) {
            aJF = aJF();
            if (aJF == null) {
                aJF = new Container(getContext());
                int height = this.dxx.getHeight() - this.mMarginTop;
                if (this.dxx instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dxx instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.dxy) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aJF.setLayoutParams(layoutParams);
                this.dxx.addView(aJF);
            }
        }
        return aJF;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dxx) {
            Container aJF = aJF();
            if (!z || aJF == null || aJF.getChildCount() <= 0) {
                if (aJF != null) {
                    this.dxx.removeView(aJF);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aJF = aJF();
        if (aJF != null && aJF.getChildCount() > 0) {
            return aJF.getChildAt(0);
        }
        return null;
    }

    public void aE(@NonNull View view) {
        if (view != getView()) {
            reset();
            aJG().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aJG().addView(view, layoutParams);
        }
    }

    public boolean aJH() {
        Container aJF = aJF();
        if (aJF == null) {
            return false;
        }
        int childCount = aJF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aJF.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
