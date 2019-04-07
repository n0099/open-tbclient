package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0164a aMC;
    private final ViewGroup aMD;
    private int aME;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0164a {
        a uu();
    }

    public a(@NonNull InterfaceC0164a interfaceC0164a, @NonNull ViewGroup viewGroup, int i) {
        this.aMC = interfaceC0164a;
        this.aMD = viewGroup;
        this.aME = i;
    }

    public void setMask(boolean z) {
        Container Iw = Iw();
        if (Iw != null) {
            Iw.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aMD.getContext();
    }

    @Nullable
    private Container Iw() {
        Container container;
        synchronized (this.aMD) {
            int i = 0;
            while (true) {
                if (i < this.aMD.getChildCount()) {
                    View childAt = this.aMD.getChildAt(i);
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
        synchronized (this.aMD) {
            Iw = Iw();
            if (Iw == null) {
                Iw = new Container(getContext());
                int height = this.aMD.getHeight() - this.aME;
                if (this.aMD instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aME;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aMD instanceof LinearLayout) || this.aME != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                Iw.setLayoutParams(layoutParams);
                this.aMD.addView(Iw);
            }
        }
        return Iw;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aMD) {
            Container Iw = Iw();
            if (!z || Iw == null || Iw.getChildCount() <= 0) {
                if (Iw != null) {
                    this.aMD.removeView(Iw);
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
