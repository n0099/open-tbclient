package com.baidu.fsg.base.activity;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39219a = "BaseActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f39220b;
    public BeanActivity mAct;

    public BeanActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39220b = null;
    }

    private Handler a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.f39220b == null) {
                this.f39220b = new Handler(getMainLooper());
            }
            return this.f39220b;
        }
        return (Handler) invokeV.objValue;
    }

    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            if (i3 == -2 || i3 == -3 || i3 == -4) {
                RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
            } else if (i3 == -8) {
                RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base__no_network"));
            } else {
                RimGlobalUtils.toastWithText(getActivity(), str);
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    public void handleResponse(int i2, Object obj, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), obj, str, str2}) == null) {
        }
    }

    public void initActionBar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str);
            a().post(new Runnable(this, i2, i3, str) { // from class: com.baidu.fsg.base.activity.BeanActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f39226a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f39227b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f39228c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ BeanActivity f39229d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39229d = this;
                    this.f39226a = i2;
                    this.f39227b = i3;
                    this.f39228c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BeanActivity beanActivity = this.f39229d;
                        if (beanActivity.mAct != null) {
                            beanActivity.handleFailure(this.f39226a, this.f39227b, this.f39228c);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), obj, str, str2}) == null) {
            a().post(new Runnable(this, i2, obj, str, str2) { // from class: com.baidu.fsg.base.activity.BeanActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f39221a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f39222b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f39223c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f39224d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ BeanActivity f39225e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), obj, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39225e = this;
                    this.f39221a = i2;
                    this.f39222b = obj;
                    this.f39223c = str;
                    this.f39224d = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BeanActivity beanActivity = this.f39225e;
                        if (beanActivity.mAct != null) {
                            beanActivity.handleResponse(this.f39221a, this.f39222b, this.f39223c);
                            this.f39225e.handleResponse(this.f39221a, this.f39222b, this.f39223c, this.f39224d);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAct = this;
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }
}
