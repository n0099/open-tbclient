package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0283a bOr;
    private final ViewGroup bOs;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0283a {
        a Gv();
    }

    public a(@NonNull InterfaceC0283a interfaceC0283a, @NonNull ViewGroup viewGroup, int i) {
        this.bOr = interfaceC0283a;
        this.bOs = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container acq = acq();
        if (acq != null) {
            acq.setClickable(z);
        }
    }

    private Context getContext() {
        return this.bOs.getContext();
    }

    @Nullable
    private Container acq() {
        Container container;
        synchronized (this.bOs) {
            int i = 0;
            while (true) {
                if (i < this.bOs.getChildCount()) {
                    View childAt = this.bOs.getChildAt(i);
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
    private Container acr() {
        Container acq;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.bOs) {
            acq = acq();
            if (acq == null) {
                acq = new Container(getContext());
                int height = this.bOs.getHeight() - this.mMarginTop;
                if (this.bOs instanceof LinearLayout) {
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
                if ((this.bOs instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                acq.setLayoutParams(layoutParams);
                this.bOs.addView(acq);
            }
        }
        return acq;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.bOs) {
            Container acq = acq();
            if (!z || acq == null || acq.getChildCount() <= 0) {
                if (acq != null) {
                    this.bOs.removeView(acq);
                }
            }
        }
    }

    public View getView() {
        Container acq = acq();
        if (acq != null && acq.getChildCount() > 0) {
            return acq.getChildAt(0);
        }
        return null;
    }

    public void ap(@NonNull View view) {
        if (view != getView()) {
            reset();
            acr().addView(view);
        }
    }

    public boolean acs() {
        Container acq = acq();
        if (acq == null) {
            return false;
        }
        int childCount = acq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = acq.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
