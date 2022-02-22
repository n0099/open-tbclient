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
/* loaded from: classes11.dex */
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<V> wrf;

    public BasePresenter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void attachView(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
            this.wrf = new WeakReference<>(v);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IPresenter
    public void destroy() {
        WeakReference<V> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.wrf) == null) {
            return;
        }
        weakReference.clear();
        this.wrf = null;
    }

    public void doFailure(int i2, String str) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (view = getView()) == null) {
            return;
        }
        view.doFailure(i2, str);
    }

    public void doResult(Object obj) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, obj) == null) || (view = getView()) == null) {
            return;
        }
        view.doResult(obj);
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

    public void showLoading(int i2) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (view = getView()) == null) {
            return;
        }
        view.showLoading(i2);
    }

    public void doFailure(int i2, int i3, String str) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) || (view = getView()) == null) {
            return;
        }
        view.doFailure(i2, i3, str);
    }

    public void doResult(int i2, Object obj) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, obj) == null) || (view = getView()) == null) {
            return;
        }
        view.doResult(i2, obj);
    }

    public void doResult(int i2, Object obj, String str) {
        V view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) || (view = getView()) == null) {
            return;
        }
        view.doResult(i2, obj, str);
    }
}
