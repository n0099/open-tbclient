package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
public class a {
    private final InterfaceC0470a dsd;
    private final ViewGroup dse;
    private boolean dsf;
    private int mMarginTop;

    /* renamed from: com.baidu.swan.apps.res.widget.floatlayer.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0470a {
        a afH();
    }

    public a(@NonNull InterfaceC0470a interfaceC0470a, @NonNull ViewGroup viewGroup, int i) {
        this.dsd = interfaceC0470a;
        this.dse = viewGroup;
        this.mMarginTop = i;
    }

    public void setMask(boolean z) {
        Container aHf = aHf();
        if (aHf != null) {
            aHf.setClickable(z);
        }
    }

    public boolean aHe() {
        return this.dsf;
    }

    private Context getContext() {
        return this.dse.getContext();
    }

    @Nullable
    private Container aHf() {
        Container container;
        synchronized (this.dse) {
            int i = 0;
            while (true) {
                if (i < this.dse.getChildCount()) {
                    View childAt = this.dse.getChildAt(i);
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
    private Container aHg() {
        Container aHf;
        int i;
        int i2;
        int i3 = 0;
        synchronized (this.dse) {
            aHf = aHf();
            if (aHf == null) {
                aHf = new Container(getContext());
                int height = this.dse.getHeight() - this.mMarginTop;
                if (this.dse instanceof LinearLayout) {
                    i = -height;
                } else {
                    i = this.mMarginTop;
                }
                if (height <= 0) {
                    i = 0;
                    height = -1;
                }
                if (!(this.dse instanceof LinearLayout) && this.mMarginTop == 0) {
                    height = -1;
                }
                if (this.dsf) {
                    i2 = -1;
                } else {
                    i3 = i;
                    i2 = height;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.setMargins(0, i3, 0, 0);
                aHf.setLayoutParams(layoutParams);
                this.dse.addView(aHf);
            }
        }
        return aHf;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        synchronized (this.dse) {
            Container aHf = aHf();
            if (!z || aHf == null || aHf.getChildCount() <= 0) {
                if (aHf != null) {
                    this.dse.removeView(aHf);
                }
            }
        }
    }

    @Nullable
    public View getView() {
        Container aHf = aHf();
        if (aHf != null && aHf.getChildCount() > 0) {
            return aHf.getChildAt(0);
        }
        return null;
    }

    public void aC(@NonNull View view) {
        if (view != getView()) {
            reset();
            aHg().addView(view);
        }
    }

    public void a(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        if (view != getView()) {
            reset();
            aHg().addView(view, layoutParams);
        }
    }

    public boolean aHh() {
        Container aHf = aHf();
        if (aHf == null) {
            return false;
        }
        int childCount = aHf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aHf.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
}
