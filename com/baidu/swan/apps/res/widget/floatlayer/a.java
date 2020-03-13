package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0283a bOt;
    private final ViewGroup bOu;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0283a {
        a Gx();
    }

    public a(@NonNull InterfaceC0283a interfaceC0283a, @NonNull ViewGroup viewGroup, int i) {
        this.bOt = interfaceC0283a;
        this.bOu = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container acs = acs();
        if (acs != null) {
            acs.setClickable(z);
        }
    }

    private Context getContext() {
        return this.bOu.getContext();
    }

    @Nullable
    private Container acs() {
        Container container;
        synchronized (this.bOu) {
            int i = 0;
            while (true) {
                if (i < this.bOu.getChildCount()) {
                    View childAt = this.bOu.getChildAt(i);
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
    private Container act() {
        Container acs;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.bOu) {
            acs = acs();
            if (acs == null) {
                acs = new Container(getContext());
                int height = this.bOu.getHeight() - this.mMarginTop;
                if (this.bOu instanceof LinearLayout) {
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
                if ((this.bOu instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                acs.setLayoutParams(layoutParams);
                this.bOu.addView(acs);
            }
        }
        return acs;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.bOu) {
            Container acs = acs();
            if (!z || acs == null || acs.getChildCount() <= 0) {
                if (acs != null) {
                    this.bOu.removeView(acs);
                }
            }
        }
    }

    public View getView() {
        Container acs = acs();
        if (acs != null && acs.getChildCount() > 0) {
            return acs.getChildAt(0);
        }
        return null;
    }

    public void ap(@NonNull View view) {
        if (view != getView()) {
            reset();
            act().addView(view);
        }
    }

    public boolean acu() {
        Container acs = acs();
        if (acs == null) {
            return false;
        }
        int childCount = acs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = acs.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
