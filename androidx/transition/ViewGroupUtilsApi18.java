package androidx.transition;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(18)
/* loaded from: classes.dex */
public class ViewGroupUtilsApi18 {
    public static final String TAG = "ViewUtilsApi18";
    public static Method sSuppressLayoutMethod;
    public static boolean sSuppressLayoutMethodFetched;

    public static void fetchSuppressLayoutMethod() {
        if (sSuppressLayoutMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            sSuppressLayoutMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve suppressLayout method", e2);
        }
        sSuppressLayoutMethodFetched = true;
    }

    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        fetchSuppressLayoutMethod();
        Method method = sSuppressLayoutMethod;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i(TAG, "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i(TAG, "Error invoking suppressLayout method", e3);
            }
        }
    }
}
