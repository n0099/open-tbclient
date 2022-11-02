package com.baidu.pass.ecommerce.common.mvp;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<V> wrf;

    public BasePresenter() {
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

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void destroy() {
        WeakReference<V> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (weakReference = this.wrf) != null) {
            weakReference.clear();
            this.wrf = null;
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public V getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WeakReference<V> weakReference = this.wrf;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (V) invokeV.objValue;
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void attachView(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
            this.wrf = new WeakReference<>(v);
        }
    }

    public void doResult(Object obj) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, obj) == null) && (view2 = getView()) != null) {
            view2.doResult(obj);
        }
    }

    public void showLoading(int i) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (view2 = getView()) != null) {
            view2.showLoading(i);
        }
    }

    public void doFailure(int i, int i2, String str) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) && (view2 = getView()) != null) {
            view2.doFailure(i, i2, str);
        }
    }

    public void doResult(int i, Object obj, String str) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048581, this, i, obj, str) == null) && (view2 = getView()) != null) {
            view2.doResult(i, obj, str);
        }
    }

    public void doFailure(int i, String str) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (view2 = getView()) != null) {
            view2.doFailure(i, str);
        }
    }

    public void doResult(int i, Object obj) {
        V view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, obj) == null) && (view2 = getView()) != null) {
            view2.doResult(i, obj);
        }
    }
}
