package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public class a {
    private final InterfaceC0456a dAC;
    private final ViewGroup dAD;
    private boolean dAE;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0456a {
        a afu();
    }

    public a(@NonNull InterfaceC0456a interfaceC0456a, @NonNull ViewGroup viewGroup, int i) {
        this.dAC = interfaceC0456a;
        this.dAD = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aHL = aHL();
        if (aHL != null) {
            aHL.setClickable(z);
        }
    }

    public boolean aHK() {
        return this.dAE;
    }

    private Context getContext() {
        return this.dAD.getContext();
    }

    @Nullable
    private Container aHL() {
        Container container;
        synchronized (this.dAD) {
            int i = 0;
            while (true) {
                if (i < this.dAD.getChildCount()) {
                    View childAt = this.dAD.getChildAt(i);
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
    private Container aHM() {
        Container aHL;
        int i;
        int i2 = -1;
        int i3 = 0;
        synchronized (this.dAD) {
            aHL = aHL();
            if (aHL == null) {
                aHL = new Container(getContext());
                int height = this.dAD.getHeight() - this.mMarginTop;
                if (this.dAD instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dAD instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (!this.dAE) {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aHL.setLayoutParams(layoutParams);
                this.dAD.addView(aHL);
            }
        }
        return aHL;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dAD) {
            Container aHL = aHL();
            if (!z || aHL == null || aHL.getChildCount() <= 0) {
                if (aHL != null) {
                    this.dAD.removeView(aHL);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aHL = aHL();
        if (aHL != null && aHL.getChildCount() > 0) {
            return aHL.getChildAt(0);
        }
        return null;
    }

    public void aM(@NonNull View view) {
        if (view != getView()) {
            reset();
            aHM().addView(view);
        }
    }

    public void c(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aHM().addView(view, layoutParams);
        }
    }

    public boolean aHN() {
        Container aHL = aHL();
        if (aHL == null) {
            return false;
        }
        int childCount = aHL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aHL.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
