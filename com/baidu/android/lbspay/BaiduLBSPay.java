package com.baidu.android.lbspay;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import java.util.Map;
/* loaded from: classes9.dex */
public class BaiduLBSPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.lbspay.BaiduLBSPay$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static BaiduLBSPay a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1522227886, "Lcom/baidu/android/lbspay/BaiduLBSPay$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1522227886, "Lcom/baidu/android/lbspay/BaiduLBSPay$a;");
                    return;
                }
            }
            a = new BaiduLBSPay(null);
        }
    }

    public /* synthetic */ BaiduLBSPay(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BaiduLBSPay getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (BaiduLBSPay) invokeV.objValue;
    }

    public void doCallFrontCashierPay(Activity activity, GetPayOrderListener getPayOrderListener, LBSPayBack lBSPayBack, Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048576, this, activity, getPayOrderListener, lBSPayBack, map, str) == null) || BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doCallFrontCashierPay(activity, getPayOrderListener, lBSPayBack, map, str);
    }

    public void doPolymerAuthorizeSign(Activity activity, LBSPayBack lBSPayBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, lBSPayBack, map) == null) || BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doPolymerAuthorizeSign(activity, lBSPayBack, map);
    }

    public void doPolymerPay(Context context, LBSPayBack lBSPayBack, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, lBSPayBack, map) == null) || BaiduWalletDelegate.getInstance().getAppContext() == null) {
            return;
        }
        LBSPayInner.getInstance().doPolymerPay(context, lBSPayBack, map);
    }

    public String getReqData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? BaiduWalletDelegate.getInstance().getAppContext() == null ? "" : LBSPayInner.getInstance().getReqData(context) : (String) invokeL.objValue;
    }

    public BaiduLBSPay() {
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
