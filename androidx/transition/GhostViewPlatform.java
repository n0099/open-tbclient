package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(21)
/* loaded from: classes.dex */
public class GhostViewPlatform implements GhostView {
    public static final String TAG = "GhostViewApi21";
    public static Method sAddGhostMethod;
    public static boolean sAddGhostMethodFetched;
    public static Class<?> sGhostViewClass;
    public static boolean sGhostViewClassFetched;
    public static Method sRemoveGhostMethod;
    public static boolean sRemoveGhostMethodFetched;
    public final View mGhostView;

    public GhostViewPlatform(@NonNull View view) {
        this.mGhostView = view;
    }

    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        fetchAddGhostMethod();
        Method method = sAddGhostMethod;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    public static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            sAddGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve addGhost method", e2);
        }
        sAddGhostMethodFetched = true;
    }

    public static void fetchGhostViewClass() {
        if (sGhostViewClassFetched) {
            return;
        }
        try {
            sGhostViewClass = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i(TAG, "Failed to retrieve GhostView class", e2);
        }
        sGhostViewClassFetched = true;
    }

    public static void fetchRemoveGhostMethod() {
        if (sRemoveGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
            sRemoveGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve removeGhost method", e2);
        }
        sRemoveGhostMethodFetched = true;
    }

    public static void removeGhost(View view) {
        fetchRemoveGhostMethod();
        Method method = sRemoveGhostMethod;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i2) {
        this.mGhostView.setVisibility(i2);
    }
}
