package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class a {
    private final InterfaceC0427a cRA;
    private final ViewGroup cRB;
    private boolean cRC;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0427a {
        a YB();
    }

    public a(@NonNull InterfaceC0427a interfaceC0427a, @NonNull ViewGroup viewGroup, int i) {
        this.cRA = interfaceC0427a;
        this.cRB = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aAc = aAc();
        if (aAc != null) {
            aAc.setClickable(z);
        }
    }

    public boolean aAb() {
        return this.cRC;
    }

    private Context getContext() {
        return this.cRB.getContext();
    }

    @Nullable
    private Container aAc() {
        Container container;
        synchronized (this.cRB) {
            int i = 0;
            while (true) {
                if (i < this.cRB.getChildCount()) {
                    View childAt = this.cRB.getChildAt(i);
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
    private Container aAd() {
        Container aAc;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.cRB) {
            aAc = aAc();
            if (aAc == null) {
                aAc = new Container(getContext());
                int height = this.cRB.getHeight() - this.mMarginTop;
                if (this.cRB instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.cRB instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.cRC) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aAc.setLayoutParams(layoutParams);
                this.cRB.addView(aAc);
            }
        }
        return aAc;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cRB) {
            Container aAc = aAc();
            if (!z || aAc == null || aAc.getChildCount() <= 0) {
                if (aAc != null) {
                    this.cRB.removeView(aAc);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aAc = aAc();
        if (aAc != null && aAc.getChildCount() > 0) {
            return aAc.getChildAt(0);
        }
        return null;
    }

    public void aw(@NonNull View view) {
        if (view != getView()) {
            reset();
            aAd().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aAd().addView(view, layoutParams);
        }
    }

    public boolean aAe() {
        Container aAc = aAc();
        if (aAc == null) {
            return false;
        }
        int childCount = aAc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aAc.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
