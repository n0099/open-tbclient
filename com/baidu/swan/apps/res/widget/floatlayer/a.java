package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
public class a {
    private final InterfaceC0444a ddH;
    private final ViewGroup ddI;
    private boolean ddJ;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0444a {
        a abn();
    }

    public a(@NonNull InterfaceC0444a interfaceC0444a, @NonNull ViewGroup viewGroup, int i) {
        this.ddH = interfaceC0444a;
        this.ddI = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aCL = aCL();
        if (aCL != null) {
            aCL.setClickable(z);
        }
    }

    public boolean aCK() {
        return this.ddJ;
    }

    private Context getContext() {
        return this.ddI.getContext();
    }

    @Nullable
    private Container aCL() {
        Container container;
        synchronized (this.ddI) {
            int i = 0;
            while (true) {
                if (i < this.ddI.getChildCount()) {
                    View childAt = this.ddI.getChildAt(i);
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
    private Container aCM() {
        Container aCL;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.ddI) {
            aCL = aCL();
            if (aCL == null) {
                aCL = new Container(getContext());
                int height = this.ddI.getHeight() - this.mMarginTop;
                if (this.ddI instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.ddI instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.ddJ) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aCL.setLayoutParams(layoutParams);
                this.ddI.addView(aCL);
            }
        }
        return aCL;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.ddI) {
            Container aCL = aCL();
            if (!z || aCL == null || aCL.getChildCount() <= 0) {
                if (aCL != null) {
                    this.ddI.removeView(aCL);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aCL = aCL();
        if (aCL != null && aCL.getChildCount() > 0) {
            return aCL.getChildAt(0);
        }
        return null;
    }

    public void ax(@NonNull View view) {
        if (view != getView()) {
            reset();
            aCM().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aCM().addView(view, layoutParams);
        }
    }

    public boolean aCN() {
        Container aCL = aCL();
        if (aCL == null) {
            return false;
        }
        int childCount = aCL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aCL.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
