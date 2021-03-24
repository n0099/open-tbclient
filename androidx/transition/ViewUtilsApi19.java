package androidx.transition;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(19)
/* loaded from: classes.dex */
public class ViewUtilsApi19 extends ViewUtilsBase {
    public static final String TAG = "ViewUtilsApi19";
    public static Method sGetTransitionAlphaMethod;
    public static boolean sGetTransitionAlphaMethodFetched;
    public static Method sSetTransitionAlphaMethod;
    public static boolean sSetTransitionAlphaMethodFetched;

    private void fetchGetTransitionAlphaMethod() {
        if (sGetTransitionAlphaMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            sGetTransitionAlphaMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve getTransitionAlpha method", e2);
        }
        sGetTransitionAlphaMethodFetched = true;
    }

    private void fetchSetTransitionAlphaMethod() {
        if (sSetTransitionAlphaMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            sSetTransitionAlphaMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve setTransitionAlpha method", e2);
        }
        sSetTransitionAlphaMethodFetched = true;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(@NonNull View view) {
        fetchGetTransitionAlphaMethod();
        Method method = sGetTransitionAlphaMethod;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.getTransitionAlpha(view);
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(@NonNull View view, float f2) {
        fetchSetTransitionAlphaMethod();
        Method method = sSetTransitionAlphaMethod;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f2));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f2);
    }
}
