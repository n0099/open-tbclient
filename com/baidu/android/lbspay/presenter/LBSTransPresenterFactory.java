package com.baidu.android.lbspay.presenter;

import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LBSTransPresenterFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TRANS_AUTH_PRESENTER = "LBSTransAuthPresenter";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.lbspay.presenter.LBSTransPresenterFactory$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LBSTransPresenterFactory f2667a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668930836, "Lcom/baidu/android/lbspay/presenter/LBSTransPresenterFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1668930836, "Lcom/baidu/android/lbspay/presenter/LBSTransPresenterFactory$a;");
                    return;
                }
            }
            f2667a = new LBSTransPresenterFactory(null);
        }
    }

    public /* synthetic */ LBSTransPresenterFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static LBSTransPresenterFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f2667a : (LBSTransPresenterFactory) invokeV.objValue;
    }

    public LBSTransPresenter getTransPresenter(LBSTransActivity lBSTransActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lBSTransActivity, str)) == null) {
            if (((str.hashCode() == 595313813 && str.equals(TRANS_AUTH_PRESENTER)) ? (char) 0 : (char) 65535) != 0) {
                return null;
            }
            return new LBSTransAuthPresenter(lBSTransActivity);
        }
        return (LBSTransPresenter) invokeLL.objValue;
    }

    public LBSTransPresenterFactory() {
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
}
