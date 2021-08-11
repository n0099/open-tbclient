package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RequiresApi(21)
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

    public GhostViewPlatform(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGhostView = view;
    }

    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view, viewGroup, matrix)) == null) {
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
        return (GhostView) invokeLLL.objValue;
    }

    public static void fetchAddGhostMethod() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || sAddGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            sAddGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sAddGhostMethodFetched = true;
    }

    public static void fetchGhostViewClass() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || sGhostViewClassFetched) {
            return;
        }
        try {
            sGhostViewClass = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException unused) {
        }
        sGhostViewClassFetched = true;
    }

    public static void fetchRemoveGhostMethod() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || sRemoveGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
            sRemoveGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sRemoveGhostMethodFetched = true;
    }

    public static void removeGhost(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, view) == null) {
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
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewGroup, view) == null) {
        }
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mGhostView.setVisibility(i2);
        }
    }
}
