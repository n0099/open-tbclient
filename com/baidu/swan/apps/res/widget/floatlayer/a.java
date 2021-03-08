package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public class a {
    private final InterfaceC0459a dEi;
    private final ViewGroup dEj;
    private boolean dEk;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0459a {
        a afV();
    }

    public a(@NonNull InterfaceC0459a interfaceC0459a, @NonNull ViewGroup viewGroup, int i) {
        this.dEi = interfaceC0459a;
        this.dEj = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aIh = aIh();
        if (aIh != null) {
            aIh.setClickable(z);
        }
    }

    public boolean aIg() {
        return this.dEk;
    }

    private Context getContext() {
        return this.dEj.getContext();
    }

    @Nullable
    private Container aIh() {
        Container container;
        synchronized (this.dEj) {
            int i = 0;
            while (true) {
                if (i < this.dEj.getChildCount()) {
                    View childAt = this.dEj.getChildAt(i);
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
    private Container aIi() {
        Container aIh;
        int i;
        int i2 = -1;
        int i3 = 0;
        synchronized (this.dEj) {
            aIh = aIh();
            if (aIh == null) {
                aIh = new Container(getContext());
                int height = this.dEj.getHeight() - this.mMarginTop;
                if (this.dEj instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dEj instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (!this.dEk) {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aIh.setLayoutParams(layoutParams);
                this.dEj.addView(aIh);
            }
        }
        return aIh;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dEj) {
            Container aIh = aIh();
            if (!z || aIh == null || aIh.getChildCount() <= 0) {
                if (aIh != null) {
                    this.dEj.removeView(aIh);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aIh = aIh();
        if (aIh != null && aIh.getChildCount() > 0) {
            return aIh.getChildAt(0);
        }
        return null;
    }

    public void aI(@NonNull View view) {
        if (view != getView()) {
            reset();
            aIi().addView(view);
        }
    }

    public void c(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aIi().addView(view, layoutParams);
        }
    }

    public boolean aIj() {
        Container aIh = aIh();
        if (aIh == null) {
            return false;
        }
        int childCount = aIh.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aIh.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
