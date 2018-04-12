package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
/* loaded from: classes2.dex */
class ViewCompatLollipop {
    private static ThreadLocal<Rect> sThreadLocalRect;

    /* loaded from: classes2.dex */
    public interface OnApplyWindowInsetsListenerBridge {
        Object onApplyWindowInsets(View view2, Object obj);
    }

    ViewCompatLollipop() {
    }

    public static void setTransitionName(View view2, String str) {
        view2.setTransitionName(str);
    }

    public static String getTransitionName(View view2) {
        return view2.getTransitionName();
    }

    public static void requestApplyInsets(View view2) {
        view2.requestApplyInsets();
    }

    public static void setElevation(View view2, float f) {
        view2.setElevation(f);
    }

    public static float getElevation(View view2) {
        return view2.getElevation();
    }

    public static void setTranslationZ(View view2, float f) {
        view2.setTranslationZ(f);
    }

    public static float getTranslationZ(View view2) {
        return view2.getTranslationZ();
    }

    public static void setOnApplyWindowInsetsListener(View view2, final OnApplyWindowInsetsListenerBridge onApplyWindowInsetsListenerBridge) {
        if (onApplyWindowInsetsListenerBridge == null) {
            view2.setOnApplyWindowInsetsListener(null);
        } else {
            view2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompatLollipop.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                    return (WindowInsets) OnApplyWindowInsetsListenerBridge.this.onApplyWindowInsets(view3, windowInsets);
                }
            });
        }
    }

    public static boolean isImportantForAccessibility(View view2) {
        return view2.isImportantForAccessibility();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ColorStateList getBackgroundTintList(View view2) {
        return view2.getBackgroundTintList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintList(View view2, ColorStateList colorStateList) {
        view2.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view2.getBackground();
            boolean z = (view2.getBackgroundTintList() == null || view2.getBackgroundTintMode() == null) ? false : true;
            if (background != null && z) {
                if (background.isStateful()) {
                    background.setState(view2.getDrawableState());
                }
                view2.setBackground(background);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PorterDuff.Mode getBackgroundTintMode(View view2) {
        return view2.getBackgroundTintMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintMode(View view2, PorterDuff.Mode mode) {
        view2.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view2.getBackground();
            boolean z = (view2.getBackgroundTintList() == null || view2.getBackgroundTintMode() == null) ? false : true;
            if (background != null && z) {
                if (background.isStateful()) {
                    background.setState(view2.getDrawableState());
                }
                view2.setBackground(background);
            }
        }
    }

    public static Object onApplyWindowInsets(View view2, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets onApplyWindowInsets = view2.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            return new WindowInsets(onApplyWindowInsets);
        }
        return obj;
    }

    public static Object dispatchApplyWindowInsets(View view2, Object obj) {
        WindowInsets windowInsets = (WindowInsets) obj;
        WindowInsets dispatchApplyWindowInsets = view2.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            return new WindowInsets(dispatchApplyWindowInsets);
        }
        return obj;
    }

    public static void setNestedScrollingEnabled(View view2, boolean z) {
        view2.setNestedScrollingEnabled(z);
    }

    public static boolean isNestedScrollingEnabled(View view2) {
        return view2.isNestedScrollingEnabled();
    }

    public static boolean startNestedScroll(View view2, int i) {
        return view2.startNestedScroll(i);
    }

    public static void stopNestedScroll(View view2) {
        view2.stopNestedScroll();
    }

    public static boolean hasNestedScrollingParent(View view2) {
        return view2.hasNestedScrollingParent();
    }

    public static boolean dispatchNestedScroll(View view2, int i, int i2, int i3, int i4, int[] iArr) {
        return view2.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public static boolean dispatchNestedPreScroll(View view2, int i, int i2, int[] iArr, int[] iArr2) {
        return view2.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedFling(View view2, float f, float f2, boolean z) {
        return view2.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view2, float f, float f2) {
        return view2.dispatchNestedPreFling(f, f2);
    }

    public static float getZ(View view2) {
        return view2.getZ();
    }

    public static void setZ(View view2, float f) {
        view2.setZ(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view2, int i) {
        boolean z;
        Rect emptyTempRect = getEmptyTempRect();
        ViewParent parent = view2.getParent();
        if (parent instanceof View) {
            View view3 = (View) parent;
            emptyTempRect.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
            z = !emptyTempRect.intersects(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        } else {
            z = false;
        }
        ViewCompatHC.offsetTopAndBottom(view2, i);
        if (z && emptyTempRect.intersect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view2, int i) {
        boolean z;
        Rect emptyTempRect = getEmptyTempRect();
        ViewParent parent = view2.getParent();
        if (parent instanceof View) {
            View view3 = (View) parent;
            emptyTempRect.set(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
            z = !emptyTempRect.intersects(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        } else {
            z = false;
        }
        ViewCompatHC.offsetLeftAndRight(view2, i);
        if (z && emptyTempRect.intersect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom())) {
            ((View) parent).invalidate(emptyTempRect);
        }
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
