package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class ViewUtils {
    public static final Property<View, Rect> CLIP_BOUNDS;
    public static final ViewUtilsBase IMPL;
    public static final String TAG = "ViewUtils";
    public static final Property<View, Float> TRANSITION_ALPHA;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (i >= 23) {
            IMPL = new ViewUtilsApi23();
        } else if (i >= 22) {
            IMPL = new ViewUtilsApi22();
        } else if (i >= 21) {
            IMPL = new ViewUtilsApi21();
        } else if (i >= 19) {
            IMPL = new ViewUtilsApi19();
        } else {
            IMPL = new ViewUtilsBase();
        }
        TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view2, Float f) {
                ViewUtils.setTransitionAlpha(view2, f.floatValue());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Float get(View view2) {
                return Float.valueOf(ViewUtils.getTransitionAlpha(view2));
            }
        };
        CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(View view2, Rect rect) {
                ViewCompat.setClipBounds(view2, rect);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Rect get(View view2) {
                return ViewCompat.getClipBounds(view2);
            }
        };
    }

    public static void clearNonTransitionAlpha(@NonNull View view2) {
        IMPL.clearNonTransitionAlpha(view2);
    }

    public static ViewOverlayImpl getOverlay(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view2);
        }
        return ViewOverlayApi14.createFrom(view2);
    }

    public static float getTransitionAlpha(@NonNull View view2) {
        return IMPL.getTransitionAlpha(view2);
    }

    public static WindowIdImpl getWindowId(@NonNull View view2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new WindowIdApi18(view2);
        }
        return new WindowIdApi14(view2.getWindowToken());
    }

    public static void saveNonTransitionAlpha(@NonNull View view2) {
        IMPL.saveNonTransitionAlpha(view2);
    }

    public static void setAnimationMatrix(@NonNull View view2, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view2, matrix);
    }

    public static void setTransitionAlpha(@NonNull View view2, float f) {
        IMPL.setTransitionAlpha(view2, f);
    }

    public static void setTransitionVisibility(@NonNull View view2, int i) {
        IMPL.setTransitionVisibility(view2, i);
    }

    public static void transformMatrixToGlobal(@NonNull View view2, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view2, matrix);
    }

    public static void transformMatrixToLocal(@NonNull View view2, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view2, matrix);
    }

    public static void setLeftTopRightBottom(@NonNull View view2, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view2, i, i2, i3, i4);
    }
}
