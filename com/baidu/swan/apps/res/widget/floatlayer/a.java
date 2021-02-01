package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class a {
    private final InterfaceC0453a dCH;
    private final ViewGroup dCI;
    private boolean dCJ;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0453a {
        a afS();
    }

    public a(@NonNull InterfaceC0453a interfaceC0453a, @NonNull ViewGroup viewGroup, int i) {
        this.dCH = interfaceC0453a;
        this.dCI = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aIe = aIe();
        if (aIe != null) {
            aIe.setClickable(z);
        }
    }

    public boolean aId() {
        return this.dCJ;
    }

    private Context getContext() {
        return this.dCI.getContext();
    }

    @Nullable
    private Container aIe() {
        Container container;
        synchronized (this.dCI) {
            int i = 0;
            while (true) {
                if (i < this.dCI.getChildCount()) {
                    View childAt = this.dCI.getChildAt(i);
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
    private Container aIf() {
        Container aIe;
        int i;
        int i2 = -1;
        int i3 = 0;
        synchronized (this.dCI) {
            aIe = aIe();
            if (aIe == null) {
                aIe = new Container(getContext());
                int height = this.dCI.getHeight() - this.mMarginTop;
                if (this.dCI instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dCI instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (!this.dCJ) {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aIe.setLayoutParams(layoutParams);
                this.dCI.addView(aIe);
            }
        }
        return aIe;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dCI) {
            Container aIe = aIe();
            if (!z || aIe == null || aIe.getChildCount() <= 0) {
                if (aIe != null) {
                    this.dCI.removeView(aIe);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aIe = aIe();
        if (aIe != null && aIe.getChildCount() > 0) {
            return aIe.getChildAt(0);
        }
        return null;
    }

    public void aI(@NonNull View view) {
        if (view != getView()) {
            reset();
            aIf().addView(view);
        }
    }

    public void c(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aIf().addView(view, layoutParams);
        }
    }

    public boolean aIg() {
        Container aIe = aIe();
        if (aIe == null) {
            return false;
        }
        int childCount = aIe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aIe.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
