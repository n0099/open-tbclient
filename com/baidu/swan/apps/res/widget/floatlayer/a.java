package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes7.dex */
public class a {
    private final InterfaceC0468a dqv;
    private final ViewGroup dqw;
    private boolean dqx;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0468a {
        a aeZ();
    }

    public a(@NonNull InterfaceC0468a interfaceC0468a, @NonNull ViewGroup viewGroup, int i) {
        this.dqv = interfaceC0468a;
        this.dqw = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aGx = aGx();
        if (aGx != null) {
            aGx.setClickable(z);
        }
    }

    public boolean aGw() {
        return this.dqx;
    }

    private Context getContext() {
        return this.dqw.getContext();
    }

    @Nullable
    private Container aGx() {
        Container container;
        synchronized (this.dqw) {
            int i = 0;
            while (true) {
                if (i < this.dqw.getChildCount()) {
                    View childAt = this.dqw.getChildAt(i);
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
    private Container aGy() {
        Container aGx;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.dqw) {
            aGx = aGx();
            if (aGx == null) {
                aGx = new Container(getContext());
                int height = this.dqw.getHeight() - this.mMarginTop;
                if (this.dqw instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dqw instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.dqx) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aGx.setLayoutParams(layoutParams);
                this.dqw.addView(aGx);
            }
        }
        return aGx;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dqw) {
            Container aGx = aGx();
            if (!z || aGx == null || aGx.getChildCount() <= 0) {
                if (aGx != null) {
                    this.dqw.removeView(aGx);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aGx = aGx();
        if (aGx != null && aGx.getChildCount() > 0) {
            return aGx.getChildAt(0);
        }
        return null;
    }

    public void aC(@NonNull View view) {
        if (view != getView()) {
            reset();
            aGy().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aGy().addView(view, layoutParams);
        }
    }

    public boolean aGz() {
        Container aGx = aGx();
        if (aGx == null) {
            return false;
        }
        int childCount = aGx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aGx.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
