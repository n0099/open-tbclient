package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0383a cDL;
    private final ViewGroup cDM;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0383a {
        a RI();
    }

    public a(@NonNull InterfaceC0383a interfaceC0383a, @NonNull ViewGroup viewGroup, int i) {
        this.cDL = interfaceC0383a;
        this.cDM = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container apx = apx();
        if (apx != null) {
            apx.setClickable(z);
        }
    }

    private Context getContext() {
        return this.cDM.getContext();
    }

    @Nullable
    private Container apx() {
        Container container;
        synchronized (this.cDM) {
            int i = 0;
            while (true) {
                if (i < this.cDM.getChildCount()) {
                    View childAt = this.cDM.getChildAt(i);
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
    private Container apy() {
        Container apx;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.cDM) {
            apx = apx();
            if (apx == null) {
                apx = new Container(getContext());
                int height = this.cDM.getHeight() - this.mMarginTop;
                if (this.cDM instanceof LinearLayout) {
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
                if ((this.cDM instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                apx.setLayoutParams(layoutParams);
                this.cDM.addView(apx);
            }
        }
        return apx;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cDM) {
            Container apx = apx();
            if (!z || apx == null || apx.getChildCount() <= 0) {
                if (apx != null) {
                    this.cDM.removeView(apx);
                }
            }
        }
    }

    public View getView() {
        Container apx = apx();
        if (apx != null && apx.getChildCount() > 0) {
            return apx.getChildAt(0);
        }
        return null;
    }

    public void aq(@NonNull View view) {
        if (view != getView()) {
            reset();
            apy().addView(view);
        }
    }

    public boolean apz() {
        Container apx = apx();
        if (apx == null) {
            return false;
        }
        int childCount = apx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = apx.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
