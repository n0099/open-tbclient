package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class LayoutInflaterCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LayoutInflaterCompatHC";
    public static boolean sCheckedField;
    public static Field sLayoutInflaterFactory2Field;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Factory2Wrapper implements LayoutInflater.Factory2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LayoutInflaterFactory mDelegateFactory;

        public Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutInflaterFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDelegateFactory = layoutInflaterFactory;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, view2, str, context, attributeSet)) == null) {
                return this.mDelegateFactory.onCreateView(view2, str, context, attributeSet);
            }
            return (View) invokeLLLL.objValue;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, context, attributeSet)) == null) {
                return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
            }
            return (View) invokeLLL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return Factory2Wrapper.class.getName() + "{" + this.mDelegateFactory + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    public LayoutInflaterCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, layoutInflater, factory2) == null) {
            if (!sCheckedField) {
                try {
                    Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                    sLayoutInflaterFactory2Field = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
                }
                sCheckedField = true;
            }
            Field field = sLayoutInflaterFactory2Field;
            if (field != null) {
                try {
                    field.set(layoutInflater, factory2);
                } catch (IllegalAccessException e2) {
                    Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
                }
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, layoutInflater)) == null) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2Wrapper) {
                return ((Factory2Wrapper) factory).mDelegateFactory;
            }
            return null;
        }
        return (LayoutInflaterFactory) invokeL.objValue;
    }

    @Deprecated
    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, layoutInflater, layoutInflaterFactory) == null) {
            Factory2Wrapper factory2Wrapper = null;
            if (Build.VERSION.SDK_INT >= 21) {
                if (layoutInflaterFactory != null) {
                    factory2Wrapper = new Factory2Wrapper(layoutInflaterFactory);
                }
                layoutInflater.setFactory2(factory2Wrapper);
                return;
            }
            if (layoutInflaterFactory != null) {
                factory2Wrapper = new Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2(factory2Wrapper);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                forceSetFactory2(layoutInflater, factory2Wrapper);
            }
        }
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutInflater, factory2) == null) {
            layoutInflater.setFactory2(factory2);
            if (Build.VERSION.SDK_INT < 21) {
                LayoutInflater.Factory factory = layoutInflater.getFactory();
                if (factory instanceof LayoutInflater.Factory2) {
                    forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
                } else {
                    forceSetFactory2(layoutInflater, factory2);
                }
            }
        }
    }
}
