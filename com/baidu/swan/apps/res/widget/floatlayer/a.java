package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0167a aPk;
    private final ViewGroup aPl;
    private int aPm;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0167a {
        a vF();
    }

    public a(@NonNull InterfaceC0167a interfaceC0167a, @NonNull ViewGroup viewGroup, int i) {
        this.aPk = interfaceC0167a;
        this.aPl = viewGroup;
        this.aPm = i;
    }

    public void setMask(boolean z) {
        Container LB = LB();
        if (LB != null) {
            LB.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aPl.getContext();
    }

    @Nullable
    private Container LB() {
        Container container;
        synchronized (this.aPl) {
            int i = 0;
            while (true) {
                if (i < this.aPl.getChildCount()) {
                    View childAt = this.aPl.getChildAt(i);
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
    private Container LC() {
        Container LB;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.aPl) {
            LB = LB();
            if (LB == null) {
                LB = new Container(getContext());
                int height = this.aPl.getHeight() - this.aPm;
                if (this.aPl instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aPm;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aPl instanceof LinearLayout) || this.aPm != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                LB.setLayoutParams(layoutParams);
                this.aPl.addView(LB);
            }
        }
        return LB;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aPl) {
            Container LB = LB();
            if (!z || LB == null || LB.getChildCount() <= 0) {
                if (LB != null) {
                    this.aPl.removeView(LB);
                }
            }
        }
    }

    public View getView() {
        Container LB = LB();
        if (LB != null && LB.getChildCount() > 0) {
            return LB.getChildAt(0);
        }
        return null;
    }

    public void ag(@NonNull View view) {
        if (view != getView()) {
            reset();
            LC().addView(view);
        }
    }

    public boolean LD() {
        Container LB = LB();
        if (LB == null) {
            return false;
        }
        int childCount = LB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = LB.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
