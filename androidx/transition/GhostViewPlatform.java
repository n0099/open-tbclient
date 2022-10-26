package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class GhostViewPlatform implements GhostView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GhostViewApi21";
    public static Method sAddGhostMethod;
    public static boolean sAddGhostMethodFetched;
    public static Class<?> sGhostViewClass;
    public static boolean sGhostViewClassFetched;
    public static Method sRemoveGhostMethod;
    public static boolean sRemoveGhostMethodFetched;
    public transient /* synthetic */ FieldHolder $fh;
    public final View mGhostView;

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewGroup, view2) == null) {
        }
    }

    public GhostViewPlatform(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGhostView = view2;
    }

    public static void removeGhost(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, view2) == null) {
            fetchRemoveGhostMethod();
            Method method = sRemoveGhostMethod;
            if (method != null) {
                try {
                    method.invoke(null, view2);
                } catch (IllegalAccessException unused) {
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mGhostView.setVisibility(i);
        }
    }

    public static GhostView addGhost(View view2, ViewGroup viewGroup, Matrix matrix) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view2, viewGroup, matrix)) == null) {
            fetchAddGhostMethod();
            Method method = sAddGhostMethod;
            if (method != null) {
                try {
                    return new GhostViewPlatform((View) method.invoke(null, view2, viewGroup, matrix));
                } catch (IllegalAccessException unused) {
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
            return null;
        }
        return (GhostView) invokeLLL.objValue;
    }

    public static void fetchAddGhostMethod() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !sAddGhostMethodFetched) {
            try {
                fetchGhostViewClass();
                Method declaredMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                sAddGhostMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve addGhost method", e);
            }
            sAddGhostMethodFetched = true;
        }
    }

    public static void fetchRemoveGhostMethod() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && !sRemoveGhostMethodFetched) {
            try {
                fetchGhostViewClass();
                Method declaredMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
                sRemoveGhostMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve removeGhost method", e);
            }
            sRemoveGhostMethodFetched = true;
        }
    }

    public static void fetchGhostViewClass() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && !sGhostViewClassFetched) {
            try {
                sGhostViewClass = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e) {
                Log.i(TAG, "Failed to retrieve GhostView class", e);
            }
            sGhostViewClassFetched = true;
        }
    }
}
