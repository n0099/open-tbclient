package com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class FloatLayer {
    private final Holder mHolder;
    private int mMarginTop;
    private final ViewGroup mTarget;

    /* loaded from: classes2.dex */
    public interface Holder {
        @NonNull
        FloatLayer getFloatLayer();
    }

    public FloatLayer(@NonNull Holder holder, @NonNull ViewGroup viewGroup, int i) {
        this.mHolder = holder;
        this.mTarget = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container findContainer = findContainer();
        if (findContainer != null) {
            findContainer.setClickable(z);
        }
    }

    private Context getContext() {
        return this.mTarget.getContext();
    }

    @Nullable
    private Container findContainer() {
        Container container;
        synchronized (this.mTarget) {
            int i = 0;
            while (true) {
                if (i < this.mTarget.getChildCount()) {
                    View childAt = this.mTarget.getChildAt(i);
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
    private Container getContainer() {
        Container findContainer;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.mTarget) {
            findContainer = findContainer();
            if (findContainer == null) {
                findContainer = new Container(getContext());
                int height = this.mTarget.getHeight() - this.mMarginTop;
                if (this.mTarget instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                findContainer.setLayoutParams(layoutParams);
                this.mTarget.addView(findContainer);
            }
        }
        return findContainer;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.mTarget) {
            Container findContainer = findContainer();
            if (!z || findContainer == null || findContainer.getChildCount() <= 0) {
                if (findContainer != null) {
                    this.mTarget.removeView(findContainer);
                }
            }
        }
    }

    public View getView() {
        Container findContainer = findContainer();
        if (findContainer != null && findContainer.getChildCount() > 0) {
            return findContainer.getChildAt(0);
        }
        return null;
    }

    public void show(@NonNull View view) {
        if (view != getView()) {
            reset();
            getContainer().addView(view);
        }
    }

    public void show(@NonNull View view, int i, int i2) {
        if (view != getView()) {
            reset();
            getContainer().addView(view, i, i2);
        }
    }

    public void show(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view == getView()) {
            reset();
            getContainer().addView(view, layoutParams);
        }
    }
}
