package com.baidu.android.lbspay.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanManager;
/* loaded from: classes10.dex */
public final class LbsPayBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_AUTHORIZE_SIGN = 3;
    public static final int BEAN_ID_GET_PAY = 2;
    public static final int BEAN_ID_NEW_CASHIER = 1;
    public static final int BEAN_ID_SIGN_RESULT = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.lbspay.beans.LbsPayBeanFactory$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static LbsPayBeanFactory a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-72177679, "Lcom/baidu/android/lbspay/beans/LbsPayBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-72177679, "Lcom/baidu/android/lbspay/beans/LbsPayBeanFactory$a;");
                    return;
                }
            }
            a = new LbsPayBeanFactory(null);
        }
    }

    public /* synthetic */ LbsPayBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static LbsPayBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (LbsPayBeanFactory) invokeV.objValue;
    }

    public LbsPayBeanFactory() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    @Override // com.dxmpay.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        BaseBean<?> newCashierBean;
        BaseBean<?> baseBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            if (i2 == 1) {
                newCashierBean = new NewCashierBean(context);
            } else if (i2 == 2) {
                newCashierBean = new GetPayBean(context);
            } else if (i2 == 3) {
                newCashierBean = new AuthorizeSignBean(context);
            } else if (i2 != 4) {
                baseBean = null;
                if (baseBean != null) {
                    BeanManager.getInstance().addBean(str, baseBean);
                }
                return baseBean;
            } else {
                newCashierBean = new SignResultBean(context);
            }
            baseBean = newCashierBean;
            if (baseBean != null) {
            }
            return baseBean;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
