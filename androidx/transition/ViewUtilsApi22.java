package androidx.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(22)
/* loaded from: classes.dex */
public class ViewUtilsApi22 extends ViewUtilsApi21 {
    public static final String TAG = "ViewUtilsApi22";
    public static Method sSetLeftTopRightBottomMethod;
    public static boolean sSetLeftTopRightBottomMethodFetched;

    @SuppressLint({"PrivateApi"})
    private void fetchSetLeftTopRightBottomMethod() {
        if (sSetLeftTopRightBottomMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            sSetLeftTopRightBottomMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve setLeftTopRightBottom method", e2);
        }
        sSetLeftTopRightBottomMethodFetched = true;
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        fetchSetLeftTopRightBottomMethod();
        Method method = sSetLeftTopRightBottomMethod;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
