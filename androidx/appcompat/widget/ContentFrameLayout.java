package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public OnAttachListener mAttachListener;
    public final Rect mDecorPadding;
    public TypedValue mFixedHeightMajor;
    public TypedValue mFixedHeightMinor;
    public TypedValue mFixedWidthMajor;
    public TypedValue mFixedWidthMinor;
    public TypedValue mMinWidthMajor;
    public TypedValue mMinWidthMinor;

    /* loaded from: classes.dex */
    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int measuredWidth;
        TypedValue typedValue;
        int i4;
        int i5;
        float fraction;
        int i6;
        int i7;
        float fraction2;
        int i8;
        int i9;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if (typedValue2 != null && (i8 = typedValue2.type) != 0) {
                if (i8 == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (i8 == 6) {
                    int i10 = displayMetrics.widthPixels;
                    fraction3 = typedValue2.getFraction(i10, i10);
                } else {
                    i9 = 0;
                    if (i9 > 0) {
                        Rect rect = this.mDecorPadding;
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z3 ? this.mFixedHeightMajor : this.mFixedHeightMinor;
                            if (typedValue3 != null && (i6 = typedValue3.type) != 0) {
                                if (i6 == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (i6 == 6) {
                                    int i11 = displayMetrics.heightPixels;
                                    fraction2 = typedValue3.getFraction(i11, i11);
                                } else {
                                    i7 = 0;
                                    if (i7 > 0) {
                                        Rect rect2 = this.mDecorPadding;
                                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i7 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i3)), 1073741824);
                                    }
                                }
                                i7 = (int) fraction2;
                                if (i7 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i2, i3);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z && mode == Integer.MIN_VALUE) {
                            typedValue = !z3 ? this.mMinWidthMinor : this.mMinWidthMajor;
                            if (typedValue != null && (i4 = typedValue.type) != 0) {
                                if (i4 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i4 == 6) {
                                    int i12 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i12, i12);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        Rect rect3 = this.mDecorPadding;
                                        i5 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i5) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                                        if (z2) {
                                            super.onMeasure(makeMeasureSpec, i3);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i5 = (int) fraction;
                                if (i5 > 0) {
                                }
                                if (measuredWidth < i5) {
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                i9 = (int) fraction3;
                if (i9 > 0) {
                }
            }
        }
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i2, i3);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z) {
            if (!z3) {
            }
            if (typedValue != null) {
                if (i4 != 5) {
                }
                i5 = (int) fraction;
                if (i5 > 0) {
                }
                if (measuredWidth < i5) {
                }
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDecorPadding(int i2, int i3, int i4, int i5) {
        this.mDecorPadding.set(i2, i3, i4, i5);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDecorPadding = new Rect();
    }
}
