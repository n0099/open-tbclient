package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0170a aOA;
    private final ViewGroup aOB;
    private int aOC;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0170a {
        a ve();
    }

    public a(@NonNull InterfaceC0170a interfaceC0170a, @NonNull ViewGroup viewGroup, int i) {
        this.aOA = interfaceC0170a;
        this.aOB = viewGroup;
        this.aOC = i;
    }

    public void setMask(boolean z) {
        Container KO = KO();
        if (KO != null) {
            KO.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aOB.getContext();
    }

    @Nullable
    private Container KO() {
        Container container;
        synchronized (this.aOB) {
            int i = 0;
            while (true) {
                if (i < this.aOB.getChildCount()) {
                    View childAt = this.aOB.getChildAt(i);
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
    private Container KP() {
        Container KO;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.aOB) {
            KO = KO();
            if (KO == null) {
                KO = new Container(getContext());
                int height = this.aOB.getHeight() - this.aOC;
                if (this.aOB instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aOC;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aOB instanceof LinearLayout) || this.aOC != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                KO.setLayoutParams(layoutParams);
                this.aOB.addView(KO);
            }
        }
        return KO;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aOB) {
            Container KO = KO();
            if (!z || KO == null || KO.getChildCount() <= 0) {
                if (KO != null) {
                    this.aOB.removeView(KO);
                }
            }
        }
    }

    public View getView() {
        Container KO = KO();
        if (KO != null && KO.getChildCount() > 0) {
            return KO.getChildAt(0);
        }
        return null;
    }

    public void ae(@NonNull View view) {
        if (view != getView()) {
            reset();
            KP().addView(view);
        }
    }

    public boolean KQ() {
        Container KO = KO();
        if (KO == null) {
            return false;
        }
        int childCount = KO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = KO.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
