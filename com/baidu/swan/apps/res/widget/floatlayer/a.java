package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class a {
    private final InterfaceC0473a dFo;
    private final ViewGroup dFp;
    private boolean dFq;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0473a {
        a ajo();
    }

    public a(@NonNull InterfaceC0473a interfaceC0473a, @NonNull ViewGroup viewGroup, int i) {
        this.dFo = interfaceC0473a;
        this.dFp = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aLF = aLF();
        if (aLF != null) {
            aLF.setClickable(z);
        }
    }

    public boolean aLE() {
        return this.dFq;
    }

    private Context getContext() {
        return this.dFp.getContext();
    }

    @Nullable
    private Container aLF() {
        Container container;
        synchronized (this.dFp) {
            int i = 0;
            while (true) {
                if (i < this.dFp.getChildCount()) {
                    View childAt = this.dFp.getChildAt(i);
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
    private Container aLG() {
        Container aLF;
        int i;
        int i2 = -1;
        int i3 = 0;
        synchronized (this.dFp) {
            aLF = aLF();
            if (aLF == null) {
                aLF = new Container(getContext());
                int height = this.dFp.getHeight() - this.mMarginTop;
                if (this.dFp instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dFp instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (!this.dFq) {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aLF.setLayoutParams(layoutParams);
                this.dFp.addView(aLF);
            }
        }
        return aLF;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dFp) {
            Container aLF = aLF();
            if (!z || aLF == null || aLF.getChildCount() <= 0) {
                if (aLF != null) {
                    this.dFp.removeView(aLF);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aLF = aLF();
        if (aLF != null && aLF.getChildCount() > 0) {
            return aLF.getChildAt(0);
        }
        return null;
    }

    public void aM(@NonNull View view) {
        if (view != getView()) {
            reset();
            aLG().addView(view);
        }
    }

    public void c(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aLG().addView(view, layoutParams);
        }
    }

    public boolean aLH() {
        Container aLF = aLF();
        if (aLF == null) {
            return false;
        }
        int childCount = aLF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aLF.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
