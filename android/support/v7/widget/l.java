package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
class l extends ListViewCompat {
    private boolean OI;
    private boolean OJ;
    private boolean OL;
    private ViewPropertyAnimatorCompat OM;
    private ListViewAutoScrollHelper OO;

    public l(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.OJ = z;
        setCacheColorHint(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        int findPointerIndex;
        boolean z2;
        boolean z3;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        switch (actionMasked) {
            case 1:
                z = false;
                findPointerIndex = motionEvent.findPointerIndex(i);
                if (findPointerIndex < 0) {
                    int x = (int) motionEvent.getX(findPointerIndex);
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                        a(childAt, pointToPosition, x, y);
                        if (actionMasked == 1) {
                            i(childAt, pointToPosition);
                        }
                        z3 = false;
                        z2 = true;
                        break;
                    } else {
                        z2 = z;
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    z2 = false;
                    break;
                }
            case 2:
                z = true;
                findPointerIndex = motionEvent.findPointerIndex(i);
                if (findPointerIndex < 0) {
                }
                break;
            case 3:
                z3 = false;
                z2 = false;
                break;
            default:
                z3 = false;
                z2 = true;
                break;
        }
        if (!z2 || z3) {
            fW();
        }
        if (z2) {
            if (this.OO == null) {
                this.OO = new ListViewAutoScrollHelper(this);
            }
            this.OO.setEnabled(true);
            this.OO.onTouch(this, motionEvent);
        } else if (this.OO != null) {
            this.OO.setEnabled(false);
        }
        return z2;
    }

    private void i(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.OI = z;
    }

    private void fW() {
        this.OL = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.OM != null) {
            this.OM.cancel();
            this.OM = null;
        }
    }

    private void a(View view, int i, float f, float f2) {
        View childAt;
        this.OL = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.mMotionPosition != -1 && (childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.ListViewCompat
    public boolean touchModeDrawsInPressedStateCompat() {
        return this.OL || super.touchModeDrawsInPressedStateCompat();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.OJ && this.OI) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.OJ || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.OJ || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.OJ || super.hasFocus();
    }
}
