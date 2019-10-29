package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class a {
    private final InterfaceC0213a biR;
    private final ViewGroup biS;
    private int biT;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0213a {
        a AD();
    }

    public a(@NonNull InterfaceC0213a interfaceC0213a, @NonNull ViewGroup viewGroup, int i) {
        this.biR = interfaceC0213a;
        this.biS = viewGroup;
        this.biT = i;
    }

    public void setMask(boolean z) {
        Container Qy = Qy();
        if (Qy != null) {
            Qy.setClickable(z);
        }
    }

    private Context getContext() {
        return this.biS.getContext();
    }

    @Nullable
    private Container Qy() {
        Container container;
        synchronized (this.biS) {
            int i = 0;
            while (true) {
                if (i < this.biS.getChildCount()) {
                    View childAt = this.biS.getChildAt(i);
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
    private Container Qz() {
        Container Qy;
        int i;
        int i2;
        int i3 = -1;
        synchronized (this.biS) {
            Qy = Qy();
            if (Qy == null) {
                Qy = new Container(getContext());
                int height = this.biS.getHeight() - this.biT;
                if (this.biS instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.biT;
                }
                if (height <= 0) {
                    i = 0;
                    i2 = -1;
                } else {
                    i2 = height;
                }
                if ((this.biS instanceof LinearLayout) || this.biT != 0) {
                    i3 = i2;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
                layoutParams.setMargins(0, i, 0, 0);
                Qy.setLayoutParams(layoutParams);
                this.biS.addView(Qy);
            }
        }
        return Qy;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.biS) {
            Container Qy = Qy();
            if (!z || Qy == null || Qy.getChildCount() <= 0) {
                if (Qy != null) {
                    this.biS.removeView(Qy);
                }
            }
        }
    }

    public View getView() {
        Container Qy = Qy();
        if (Qy != null && Qy.getChildCount() > 0) {
            return Qy.getChildAt(0);
        }
        return null;
    }

    public void am(@NonNull View view) {
        if (view != getView()) {
            reset();
            Qz().addView(view);
        }
    }

    public boolean QA() {
        Container Qy = Qy();
        if (Qy == null) {
            return false;
        }
        int childCount = Qy.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = Qy.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
