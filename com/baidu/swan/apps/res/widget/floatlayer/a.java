package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0313a cnp;
    private final ViewGroup cnq;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0313a {
        a Op();
    }

    public a(@NonNull InterfaceC0313a interfaceC0313a, @NonNull ViewGroup viewGroup, int i) {
        this.cnp = interfaceC0313a;
        this.cnq = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container akA = akA();
        if (akA != null) {
            akA.setClickable(z);
        }
    }

    private Context getContext() {
        return this.cnq.getContext();
    }

    @Nullable
    private Container akA() {
        Container container;
        synchronized (this.cnq) {
            int i = 0;
            while (true) {
                if (i < this.cnq.getChildCount()) {
                    View childAt = this.cnq.getChildAt(i);
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
    private Container akB() {
        Container akA;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.cnq) {
            akA = akA();
            if (akA == null) {
                akA = new Container(getContext());
                int height = this.cnq.getHeight() - this.mMarginTop;
                if (this.cnq instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.cnq instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                akA.setLayoutParams(layoutParams);
                this.cnq.addView(akA);
            }
        }
        return akA;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cnq) {
            Container akA = akA();
            if (!z || akA == null || akA.getChildCount() <= 0) {
                if (akA != null) {
                    this.cnq.removeView(akA);
                }
            }
        }
    }

    public View getView() {
        Container akA = akA();
        if (akA != null && akA.getChildCount() > 0) {
            return akA.getChildAt(0);
        }
        return null;
    }

    public void aq(@NonNull View view) {
        if (view != getView()) {
            reset();
            akB().addView(view);
        }
    }

    public boolean akC() {
        Container akA = akA();
        if (akA == null) {
            return false;
        }
        int childCount = akA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = akA.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
