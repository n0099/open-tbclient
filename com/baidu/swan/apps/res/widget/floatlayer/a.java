package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
public class a {
    private final InterfaceC0458a dmh;
    private final ViewGroup dmi;
    private boolean dmj;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0458a {
        a adh();
    }

    public a(@NonNull InterfaceC0458a interfaceC0458a, @NonNull ViewGroup viewGroup, int i) {
        this.dmh = interfaceC0458a;
        this.dmi = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aEF = aEF();
        if (aEF != null) {
            aEF.setClickable(z);
        }
    }

    public boolean aEE() {
        return this.dmj;
    }

    private Context getContext() {
        return this.dmi.getContext();
    }

    @Nullable
    private Container aEF() {
        Container container;
        synchronized (this.dmi) {
            int i = 0;
            while (true) {
                if (i < this.dmi.getChildCount()) {
                    View childAt = this.dmi.getChildAt(i);
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
    private Container aEG() {
        Container aEF;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.dmi) {
            aEF = aEF();
            if (aEF == null) {
                aEF = new Container(getContext());
                int height = this.dmi.getHeight() - this.mMarginTop;
                if (this.dmi instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dmi instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.dmj) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aEF.setLayoutParams(layoutParams);
                this.dmi.addView(aEF);
            }
        }
        return aEF;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dmi) {
            Container aEF = aEF();
            if (!z || aEF == null || aEF.getChildCount() <= 0) {
                if (aEF != null) {
                    this.dmi.removeView(aEF);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aEF = aEF();
        if (aEF != null && aEF.getChildCount() > 0) {
            return aEF.getChildAt(0);
        }
        return null;
    }

    public void ay(@NonNull View view) {
        if (view != getView()) {
            reset();
            aEG().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aEG().addView(view, layoutParams);
        }
    }

    public boolean aEH() {
        Container aEF = aEF();
        if (aEF == null) {
            return false;
        }
        int childCount = aEF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aEF.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
