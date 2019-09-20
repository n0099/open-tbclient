package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0181a aPI;
    private final ViewGroup aPJ;
    private int aPK;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0181a {
        a vJ();
    }

    public a(@NonNull InterfaceC0181a interfaceC0181a, @NonNull ViewGroup viewGroup, int i) {
        this.aPI = interfaceC0181a;
        this.aPJ = viewGroup;
        this.aPK = i;
    }

    public void setMask(boolean z) {
        Container LF = LF();
        if (LF != null) {
            LF.setClickable(z);
        }
    }

    private Context getContext() {
        return this.aPJ.getContext();
    }

    @Nullable
    private Container LF() {
        Container container;
        synchronized (this.aPJ) {
            int i = 0;
            while (true) {
                if (i < this.aPJ.getChildCount()) {
                    View childAt = this.aPJ.getChildAt(i);
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
    private Container LG() {
        Container LF;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.aPJ) {
            LF = LF();
            if (LF == null) {
                LF = new Container(getContext());
                int height = this.aPJ.getHeight() - this.aPK;
                if (this.aPJ instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.aPK;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.aPJ instanceof LinearLayout) || this.aPK != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                LF.setLayoutParams(layoutParams);
                this.aPJ.addView(LF);
            }
        }
        return LF;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.aPJ) {
            Container LF = LF();
            if (!z || LF == null || LF.getChildCount() <= 0) {
                if (LF != null) {
                    this.aPJ.removeView(LF);
                }
            }
        }
    }

    public View getView() {
        Container LF = LF();
        if (LF != null && LF.getChildCount() > 0) {
            return LF.getChildAt(0);
        }
        return null;
    }

    public void ag(@NonNull View view) {
        if (view != getView()) {
            reset();
            LG().addView(view);
        }
    }

    public boolean LH() {
        Container LF = LF();
        if (LF == null) {
            return false;
        }
        int childCount = LF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = LF.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
