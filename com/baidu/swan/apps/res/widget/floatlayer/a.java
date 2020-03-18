package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0283a bOE;
    private final ViewGroup bOF;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0283a {
        a GC();
    }

    public a(@NonNull InterfaceC0283a interfaceC0283a, @NonNull ViewGroup viewGroup, int i) {
        this.bOE = interfaceC0283a;
        this.bOF = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container acv = acv();
        if (acv != null) {
            acv.setClickable(z);
        }
    }

    private Context getContext() {
        return this.bOF.getContext();
    }

    @Nullable
    private Container acv() {
        Container container;
        synchronized (this.bOF) {
            int i = 0;
            while (true) {
                if (i < this.bOF.getChildCount()) {
                    View childAt = this.bOF.getChildAt(i);
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
    private Container acw() {
        Container acv;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.bOF) {
            acv = acv();
            if (acv == null) {
                acv = new Container(getContext());
                int height = this.bOF.getHeight() - this.mMarginTop;
                if (this.bOF instanceof LinearLayout) {
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
                if ((this.bOF instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                acv.setLayoutParams(layoutParams);
                this.bOF.addView(acv);
            }
        }
        return acv;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.bOF) {
            Container acv = acv();
            if (!z || acv == null || acv.getChildCount() <= 0) {
                if (acv != null) {
                    this.bOF.removeView(acv);
                }
            }
        }
    }

    public View getView() {
        Container acv = acv();
        if (acv != null && acv.getChildCount() > 0) {
            return acv.getChildAt(0);
        }
        return null;
    }

    public void ap(@NonNull View view) {
        if (view != getView()) {
            reset();
            acw().addView(view);
        }
    }

    public boolean acx() {
        Container acv = acv();
        if (acv == null) {
            return false;
        }
        int childCount = acv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = acv.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
