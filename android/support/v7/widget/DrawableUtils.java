package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.Log;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.lang.reflect.Field;
@RestrictTo
/* loaded from: classes2.dex */
public class DrawableUtils {
    public static final Rect INSETS_NONE = new Rect();
    private static Class<?> OI;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                OI = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    private DrawableUtils() {
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        Field[] fields;
        if (OI != null) {
            try {
                Drawable unwrap = DrawableCompat.unwrap(drawable);
                Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(unwrap, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : OI.getFields()) {
                        String name = field.getName();
                        char c = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals(CustomDialogData.POS_LEFT)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                rect.left = field.getInt(invoke);
                                continue;
                            case 1:
                                rect.top = field.getInt(invoke);
                                continue;
                            case 2:
                                rect.right = field.getInt(invoke);
                                continue;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                continue;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return INSETS_NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            h(drawable);
        }
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof InsetDrawable)) {
            if (Build.VERSION.SDK_INT >= 15 || !(drawable instanceof GradientDrawable)) {
                if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                    if (drawable instanceof DrawableContainer) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState instanceof DrawableContainer.DrawableContainerState) {
                            Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
                            for (Drawable drawable2 : children) {
                                if (!canSafelyMutateDrawable(drawable2)) {
                                    return false;
                                }
                            }
                        }
                    } else if (drawable instanceof DrawableWrapper) {
                        return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
                    } else {
                        if (drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper) {
                            return canSafelyMutateDrawable(((android.support.v7.graphics.drawable.DrawableWrapper) drawable).getWrappedDrawable());
                        }
                        if (drawable instanceof ScaleDrawable) {
                            return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static void h(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(s.jn);
        } else {
            drawable.setState(s.EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                if (Build.VERSION.SDK_INT >= 11) {
                    return PorterDuff.Mode.valueOf("ADD");
                }
                return mode;
        }
    }
}
