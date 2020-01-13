package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
public class a {
    private final InterfaceC0273a bKm;
    private final ViewGroup bKn;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0273a {
        a Eg();
    }

    public a(@NonNull InterfaceC0273a interfaceC0273a, @NonNull ViewGroup viewGroup, int i) {
        this.bKm = interfaceC0273a;
        this.bKn = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aac = aac();
        if (aac != null) {
            aac.setClickable(z);
        }
    }

    private Context getContext() {
        return this.bKn.getContext();
    }

    @Nullable
    private Container aac() {
        Container container;
        synchronized (this.bKn) {
            int i = 0;
            while (true) {
                if (i < this.bKn.getChildCount()) {
                    View childAt = this.bKn.getChildAt(i);
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
    private Container aad() {
        Container aac;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.bKn) {
            aac = aac();
            if (aac == null) {
                aac = new Container(getContext());
                int height = this.bKn.getHeight() - this.mMarginTop;
                if (this.bKn instanceof LinearLayout) {
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
                if ((this.bKn instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                aac.setLayoutParams(layoutParams);
                this.bKn.addView(aac);
            }
        }
        return aac;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.bKn) {
            Container aac = aac();
            if (!z || aac == null || aac.getChildCount() <= 0) {
                if (aac != null) {
                    this.bKn.removeView(aac);
                }
            }
        }
    }

    public View getView() {
        Container aac = aac();
        if (aac != null && aac.getChildCount() > 0) {
            return aac.getChildAt(0);
        }
        return null;
    }

    public void ap(@NonNull View view) {
        if (view != getView()) {
            reset();
            aad().addView(view);
        }
    }

    public boolean aae() {
        Container aac = aac();
        if (aac == null) {
            return false;
        }
        int childCount = aac.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aac.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
