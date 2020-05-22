package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0377a czb;
    private final ViewGroup czc;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0377a {
        a QC();
    }

    public a(@NonNull InterfaceC0377a interfaceC0377a, @NonNull ViewGroup viewGroup, int i) {
        this.czb = interfaceC0377a;
        this.czc = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aoq = aoq();
        if (aoq != null) {
            aoq.setClickable(z);
        }
    }

    private Context getContext() {
        return this.czc.getContext();
    }

    @Nullable
    private Container aoq() {
        Container container;
        synchronized (this.czc) {
            int i = 0;
            while (true) {
                if (i < this.czc.getChildCount()) {
                    View childAt = this.czc.getChildAt(i);
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
    private Container aor() {
        Container aoq;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.czc) {
            aoq = aoq();
            if (aoq == null) {
                aoq = new Container(getContext());
                int height = this.czc.getHeight() - this.mMarginTop;
                if (this.czc instanceof LinearLayout) {
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
                if ((this.czc instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                aoq.setLayoutParams(layoutParams);
                this.czc.addView(aoq);
            }
        }
        return aoq;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.czc) {
            Container aoq = aoq();
            if (!z || aoq == null || aoq.getChildCount() <= 0) {
                if (aoq != null) {
                    this.czc.removeView(aoq);
                }
            }
        }
    }

    public View getView() {
        Container aoq = aoq();
        if (aoq != null && aoq.getChildCount() > 0) {
            return aoq.getChildAt(0);
        }
        return null;
    }

    public void aq(@NonNull View view) {
        if (view != getView()) {
            reset();
            aor().addView(view);
        }
    }

    public boolean aos() {
        Container aoq = aoq();
        if (aoq == null) {
            return false;
        }
        int childCount = aoq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aoq.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
