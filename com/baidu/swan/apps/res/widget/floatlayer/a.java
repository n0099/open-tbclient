package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final ViewGroup aMA;
    private int aMB;
    private final InterfaceC0164a aMz;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0164a {
        a uv();
    }

    public a(@NonNull InterfaceC0164a interfaceC0164a, @NonNull ViewGroup viewGroup, int i) {
        this.aMz = interfaceC0164a;
        this.aMA = viewGroup;
        this.aMB = i;
    }

    public void setMask(boolean z) {
        Container Iy = Iy();
        if (Iy != null) {
            Iy.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aMA.getContext();
    }

    @Nullable
    private Container Iy() {
        Container container;
        synchronized (this.aMA) {
            int i = 0;
            while (true) {
                if (i < this.aMA.getChildCount()) {
                    View childAt = this.aMA.getChildAt(i);
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
    private Container Iz() {
        Container Iy;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.aMA) {
            Iy = Iy();
            if (Iy == null) {
                Iy = new Container(getContext());
                int height = this.aMA.getHeight() - this.aMB;
                if (this.aMA instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aMB;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aMA instanceof LinearLayout) || this.aMB != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                Iy.setLayoutParams(layoutParams);
                this.aMA.addView(Iy);
            }
        }
        return Iy;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aMA) {
            Container Iy = Iy();
            if (!z || Iy == null || Iy.getChildCount() <= 0) {
                if (Iy != null) {
                    this.aMA.removeView(Iy);
                }
            }
        }
    }

    public View getView() {
        Container Iy = Iy();
        if (Iy != null && Iy.getChildCount() > 0) {
            return Iy.getChildAt(0);
        }
        return null;
    }

    public void ae(@NonNull View view) {
        if (view != getView()) {
            reset();
            Iz().addView(view);
        }
    }
}
