package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes7.dex */
public class a {
    private final InterfaceC0386a cGy;
    private final ViewGroup cGz;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0386a {
        a RX();
    }

    public a(@NonNull InterfaceC0386a interfaceC0386a, @NonNull ViewGroup viewGroup, int i) {
        this.cGy = interfaceC0386a;
        this.cGz = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container arg = arg();
        if (arg != null) {
            arg.setClickable(z);
        }
    }

    private Context getContext() {
        return this.cGz.getContext();
    }

    @Nullable
    private Container arg() {
        Container container;
        synchronized (this.cGz) {
            int i = 0;
            while (true) {
                if (i < this.cGz.getChildCount()) {
                    View childAt = this.cGz.getChildAt(i);
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
    private Container arh() {
        Container arg;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.cGz) {
            arg = arg();
            if (arg == null) {
                arg = new Container(getContext());
                int height = this.cGz.getHeight() - this.mMarginTop;
                if (this.cGz instanceof LinearLayout) {
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
                if ((this.cGz instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                arg.setLayoutParams(layoutParams);
                this.cGz.addView(arg);
            }
        }
        return arg;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cGz) {
            Container arg = arg();
            if (!z || arg == null || arg.getChildCount() <= 0) {
                if (arg != null) {
                    this.cGz.removeView(arg);
                }
            }
        }
    }

    public View getView() {
        Container arg = arg();
        if (arg != null && arg.getChildCount() > 0) {
            return arg.getChildAt(0);
        }
        return null;
    }

    public void at(@NonNull View view) {
        if (view != getView()) {
            reset();
            arh().addView(view);
        }
    }

    public boolean ari() {
        Container arg = arg();
        if (arg == null) {
            return false;
        }
        int childCount = arg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = arg.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
