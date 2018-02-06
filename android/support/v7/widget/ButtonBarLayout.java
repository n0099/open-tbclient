package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
@RestrictTo
/* loaded from: classes2.dex */
public class ButtonBarLayout extends LinearLayout {
    private boolean NL;
    private int NM;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NM = -1;
        boolean z = ConfigurationHelper.getScreenHeightDp(getResources()) >= 320;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        this.NL = obtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, z);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.NL != z) {
            this.NL = z;
            if (!this.NL && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i);
        if (this.NL) {
            if (size > this.NM && fR()) {
                setStacked(false);
            }
            this.NM = size;
        }
        if (fR() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.NL && !fR()) {
            if (Build.VERSION.SDK_INT >= 11) {
                if ((ViewCompat.getMeasuredWidthAndState(this) & ViewCompat.MEASURED_STATE_MASK) == 16777216) {
                    z2 = true;
                }
            } else {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    i4 += getChildAt(i5).getMeasuredWidth();
                }
                if (getPaddingLeft() + i4 + getPaddingRight() > size) {
                    z2 = true;
                }
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean fR() {
        return getOrientation() == 1;
    }
}
