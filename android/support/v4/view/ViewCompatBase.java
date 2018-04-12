package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
class ViewCompatBase {
    private static final String TAG = "ViewCompatBase";
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;

    ViewCompatBase() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ColorStateList getBackgroundTintList(View view2) {
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintList(View view2, ColorStateList colorStateList) {
        if (view2 instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view2).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PorterDuff.Mode getBackgroundTintMode(View view2) {
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintMode(View view2, PorterDuff.Mode mode) {
        if (view2 instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view2).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLaidOut(View view2) {
        return view2.getWidth() > 0 && view2.getHeight() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMinimumWidth(View view2) {
        if (!sMinWidthFieldFetched) {
            try {
                sMinWidthField = View.class.getDeclaredField("mMinWidth");
                sMinWidthField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            sMinWidthFieldFetched = true;
        }
        if (sMinWidthField != null) {
            try {
                return ((Integer) sMinWidthField.get(view2)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMinimumHeight(View view2) {
        if (!sMinHeightFieldFetched) {
            try {
                sMinHeightField = View.class.getDeclaredField("mMinHeight");
                sMinHeightField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            sMinHeightFieldFetched = true;
        }
        if (sMinHeightField != null) {
            try {
                return ((Integer) sMinHeightField.get(view2)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAttachedToWindow(View view2) {
        return view2.getWindowToken() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view2, int i) {
        int top = view2.getTop();
        view2.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view2.getLeft(), top - abs, view2.getRight(), top + view2.getHeight() + abs);
                return;
            }
            view2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view2, int i) {
        int left = view2.getLeft();
        view2.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view2.getTop(), left + view2.getWidth() + abs, view2.getBottom());
                return;
            }
            view2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Display getDisplay(View view2) {
        if (isAttachedToWindow(view2)) {
            return ((WindowManager) view2.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }
}
