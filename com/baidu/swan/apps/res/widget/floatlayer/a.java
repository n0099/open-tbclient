package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0164a aMD;
    private final ViewGroup aME;
    private int aMF;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0164a {
        a uu();
    }

    public a(@NonNull InterfaceC0164a interfaceC0164a, @NonNull ViewGroup viewGroup, int i) {
        this.aMD = interfaceC0164a;
        this.aME = viewGroup;
        this.aMF = i;
    }

    public void setMask(boolean z) {
        Container Iw = Iw();
        if (Iw != null) {
            Iw.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aME.getContext();
    }

    @Nullable
    private Container Iw() {
        Container container;
        synchronized (this.aME) {
            int i = 0;
            while (true) {
                if (i < this.aME.getChildCount()) {
                    View childAt = this.aME.getChildAt(i);
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
    private Container Ix() {
        Container Iw;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.aME) {
            Iw = Iw();
            if (Iw == null) {
                Iw = new Container(getContext());
                int height = this.aME.getHeight() - this.aMF;
                if (this.aME instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aMF;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aME instanceof LinearLayout) || this.aMF != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                Iw.setLayoutParams(layoutParams);
                this.aME.addView(Iw);
            }
        }
        return Iw;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aME) {
            Container Iw = Iw();
            if (!z || Iw == null || Iw.getChildCount() <= 0) {
                if (Iw != null) {
                    this.aME.removeView(Iw);
                }
            }
        }
    }

    public View getView() {
        Container Iw = Iw();
        if (Iw != null && Iw.getChildCount() > 0) {
            return Iw.getChildAt(0);
        }
        return null;
    }

    public void ae(@NonNull View view) {
        if (view != getView()) {
            reset();
            Ix().addView(view);
        }
    }
}
