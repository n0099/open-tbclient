package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes9.dex */
public class a {
    private final InterfaceC0271a bJC;
    private final ViewGroup bJD;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0271a {
        a DK();
    }

    public a(@NonNull InterfaceC0271a interfaceC0271a, @NonNull ViewGroup viewGroup, int i) {
        this.bJC = interfaceC0271a;
        this.bJD = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container ZF = ZF();
        if (ZF != null) {
            ZF.setClickable(z);
        }
    }

    private Context getContext() {
        return this.bJD.getContext();
    }

    @Nullable
    private Container ZF() {
        Container container;
        synchronized (this.bJD) {
            int i = 0;
            while (true) {
                if (i < this.bJD.getChildCount()) {
                    View childAt = this.bJD.getChildAt(i);
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
    private Container ZG() {
        Container ZF;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.bJD) {
            ZF = ZF();
            if (ZF == null) {
                ZF = new Container(getContext());
                int height = this.bJD.getHeight() - this.mMarginTop;
                if (this.bJD instanceof LinearLayout) {
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
                if ((this.bJD instanceof LinearLayout) || this.mMarginTop != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                ZF.setLayoutParams(layoutParams);
                this.bJD.addView(ZF);
            }
        }
        return ZF;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.bJD) {
            Container ZF = ZF();
            if (!z || ZF == null || ZF.getChildCount() <= 0) {
                if (ZF != null) {
                    this.bJD.removeView(ZF);
                }
            }
        }
    }

    public View getView() {
        Container ZF = ZF();
        if (ZF != null && ZF.getChildCount() > 0) {
            return ZF.getChildAt(0);
        }
        return null;
    }

    public void al(@NonNull View view) {
        if (view != getView()) {
            reset();
            ZG().addView(view);
        }
    }

    public boolean ZH() {
        Container ZF = ZF();
        if (ZF == null) {
            return false;
        }
        int childCount = ZF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ZF.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
