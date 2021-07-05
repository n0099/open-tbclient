package com.baidu.pass.ecommerce.common.mvp;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.mvp.IPresenter;
import com.baidu.sapi2.activity.BaseOptionActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseOptionActivity implements IBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public P presenter;

    public BaseMvpActivity() {
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

    public abstract P createPresenter();

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            doFailure(Integer.MIN_VALUE, i2, str);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            doResult(Integer.MIN_VALUE, obj);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseOptionActivity, com.baidu.sapi2.activity.NaSlideActiviy, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            P createPresenter = createPresenter();
            this.presenter = createPresenter;
            createPresenter.attachView(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            P p = this.presenter;
            if (p != null) {
                p.destroy();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            doFailure(i2, i3, str, null);
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public final void doResult(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, obj) == null) {
            doResult(i2, obj, null);
        }
    }
}
