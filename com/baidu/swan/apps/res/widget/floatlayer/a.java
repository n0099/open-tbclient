package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes8.dex */
public class a {
    private final InterfaceC0432a cPw;
    private final ViewGroup cPx;
    private boolean cPy;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0432a {
        a XS();
    }

    public a(@NonNull InterfaceC0432a interfaceC0432a, @NonNull ViewGroup viewGroup, int i) {
        this.cPw = interfaceC0432a;
        this.cPx = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container azt = azt();
        if (azt != null) {
            azt.setClickable(z);
        }
    }

    public boolean azs() {
        return this.cPy;
    }

    private Context getContext() {
        return this.cPx.getContext();
    }

    @Nullable
    private Container azt() {
        Container container;
        synchronized (this.cPx) {
            int i = 0;
            while (true) {
                if (i < this.cPx.getChildCount()) {
                    View childAt = this.cPx.getChildAt(i);
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
    private Container azu() {
        Container azt;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.cPx) {
            azt = azt();
            if (azt == null) {
                azt = new Container(getContext());
                int height = this.cPx.getHeight() - this.mMarginTop;
                if (this.cPx instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.cPx instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.cPy) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                azt.setLayoutParams(layoutParams);
                this.cPx.addView(azt);
            }
        }
        return azt;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cPx) {
            Container azt = azt();
            if (!z || azt == null || azt.getChildCount() <= 0) {
                if (azt != null) {
                    this.cPx.removeView(azt);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container azt = azt();
        if (azt != null && azt.getChildCount() > 0) {
            return azt.getChildAt(0);
        }
        return null;
    }

    public void au(@NonNull View view) {
        if (view != getView()) {
            reset();
            azu().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            azu().addView(view, layoutParams);
        }
    }

    public boolean azv() {
        Container azt = azt();
        if (azt == null) {
            return false;
        }
        int childCount = azt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = azt.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
