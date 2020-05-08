package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes11.dex */
public class a {
    private final InterfaceC0334a cnw;
    private final ViewGroup cnx;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0334a {
        a Oo();
    }

    public a(@NonNull InterfaceC0334a interfaceC0334a, @NonNull ViewGroup viewGroup, int i) {
        this.cnw = interfaceC0334a;
        this.cnx = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container akz = akz();
        if (akz != null) {
            akz.setClickable(z);
        }
    }

    private Context getContext() {
        return this.cnx.getContext();
    }

    @Nullable
    private Container akz() {
        Container container;
        synchronized (this.cnx) {
            int i = 0;
            while (true) {
                if (i < this.cnx.getChildCount()) {
                    View childAt = this.cnx.getChildAt(i);
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
    private Container akA() {
        Container akz;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.cnx) {
            akz = akz();
            if (akz == null) {
                akz = new Container(getContext());
                int height = this.cnx.getHeight() - this.mMarginTop;
                if (this.cnx instanceof LinearLayout) {
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
                if ((this.cnx instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                akz.setLayoutParams(layoutParams);
                this.cnx.addView(akz);
            }
        }
        return akz;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.cnx) {
            Container akz = akz();
            if (!z || akz == null || akz.getChildCount() <= 0) {
                if (akz != null) {
                    this.cnx.removeView(akz);
                }
            }
        }
    }

    public View getView() {
        Container akz = akz();
        if (akz != null && akz.getChildCount() > 0) {
            return akz.getChildAt(0);
        }
        return null;
    }

    public void aq(@NonNull View view) {
        if (view != getView()) {
            reset();
            akA().addView(view);
        }
    }

    public boolean akB() {
        Container akz = akz();
        if (akz == null) {
            return false;
        }
        int childCount = akz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = akz.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
