package com.baidu.tbadk.core.account.helper;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class AccountLoginCoreHelper {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AccountLoginCoreHelper mAccountLoginCoreHelper;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface IReLoginCallback {
        void onBeforeLogin(String str);

        void onFailure(String str, int i, String str2);

        void onSuccess(AccountData accountData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1345088640, "Lcom/baidu/tbadk/core/account/helper/AccountLoginCoreHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1345088640, "Lcom/baidu/tbadk/core/account/helper/AccountLoginCoreHelper;");
        }
    }

    public abstract BdAsyncTask<?, ?, ?> asyncReLogin(String str, String str2, String str3, String str4, IReLoginCallback iReLoginCallback);

    public abstract a parseBDUSS(String str);

    public abstract void reLoginByCacheAccount();

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
        }
    }

    public AccountLoginCoreHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AccountLoginCoreHelper getInstance() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mAccountLoginCoreHelper == null) {
                synchronized (AccountLoginCoreHelper.class) {
                    if (mAccountLoginCoreHelper == null && (runTask = MessageManager.getInstance().runTask(2001293, AccountLoginCoreHelper.class)) != null && runTask.getData() != null) {
                        mAccountLoginCoreHelper = (AccountLoginCoreHelper) runTask.getData();
                    }
                }
            }
            return mAccountLoginCoreHelper;
        }
        return (AccountLoginCoreHelper) invokeV.objValue;
    }
}
