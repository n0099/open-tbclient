package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ViewGroupUtilsApi14 {
    public static final int LAYOUT_TRANSITION_CHANGING = 4;
    public static final String TAG = "ViewGroupUtilsApi14";
    public static Method sCancelMethod;
    public static boolean sCancelMethodFetched;
    public static LayoutTransition sEmptyLayoutTransition;
    public static Field sLayoutSuppressedField;
    public static boolean sLayoutSuppressedFieldFetched;

    public static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            }
            sCancelMethodFetched = true;
        }
        Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(TAG, "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        boolean z2 = false;
        if (sEmptyLayoutTransition == null) {
            LayoutTransition layoutTransition2 = new LayoutTransition() { // from class: androidx.transition.ViewGroupUtilsApi14.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            sEmptyLayoutTransition = layoutTransition2;
            layoutTransition2.setAnimator(2, null);
            sEmptyLayoutTransition.setAnimator(0, null);
            sEmptyLayoutTransition.setAnimator(1, null);
            sEmptyLayoutTransition.setAnimator(3, null);
            sEmptyLayoutTransition.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition3 = viewGroup.getLayoutTransition();
            if (layoutTransition3 != null) {
                if (layoutTransition3.isRunning()) {
                    cancelLayoutTransition(layoutTransition3);
                }
                if (layoutTransition3 != sEmptyLayoutTransition) {
                    viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0925d4, layoutTransition3);
                }
            }
            viewGroup.setLayoutTransition(sEmptyLayoutTransition);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!sLayoutSuppressedFieldFetched) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                sLayoutSuppressedField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
            }
            sLayoutSuppressedFieldFetched = true;
        }
        Field field = sLayoutSuppressedField;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        sLayoutSuppressedField.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
                        if (z2) {
                        }
                        layoutTransition = (LayoutTransition) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0925d4);
                        if (layoutTransition == null) {
                        }
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0925d4);
        if (layoutTransition == null) {
            viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0925d4, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
