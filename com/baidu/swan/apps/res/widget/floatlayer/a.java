package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final ViewGroup biA;
    private int biB;
    private final InterfaceC0213a biz;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0213a {
        a AE();
    }

    public a(@NonNull InterfaceC0213a interfaceC0213a, @NonNull ViewGroup viewGroup, int i) {
        this.biz = interfaceC0213a;
        this.biA = viewGroup;
        this.biB = i;
    }

    public void setMask(boolean z) {
        Container Qz = Qz();
        if (Qz != null) {
            Qz.setClickable(z);
        }
    }

    private Context getContext() {
        return this.biA.getContext();
    }

    @Nullable
    private Container Qz() {
        Container container;
        synchronized (this.biA) {
            int i = 0;
            while (true) {
                if (i < this.biA.getChildCount()) {
                    View childAt = this.biA.getChildAt(i);
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
    private Container QA() {
        Container Qz;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.biA) {
            Qz = Qz();
            if (Qz == null) {
                Qz = new Container(getContext());
                int height = this.biA.getHeight() - this.biB;
                if (this.biA instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.biB;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.biA instanceof LinearLayout) || this.biB != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                Qz.setLayoutParams(layoutParams);
                this.biA.addView(Qz);
            }
        }
        return Qz;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.biA) {
            Container Qz = Qz();
            if (!z || Qz == null || Qz.getChildCount() <= 0) {
                if (Qz != null) {
                    this.biA.removeView(Qz);
                }
            }
        }
    }

    public View getView() {
        Container Qz = Qz();
        if (Qz != null && Qz.getChildCount() > 0) {
            return Qz.getChildAt(0);
        }
        return null;
    }

    public void am(@NonNull View view) {
        if (view != getView()) {
            reset();
            QA().addView(view);
        }
    }

    public boolean QB() {
        Container Qz = Qz();
        if (Qz == null) {
            return false;
        }
        int childCount = Qz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = Qz.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
