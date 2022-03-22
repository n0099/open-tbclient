package com.baidu.sofire.rp;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.CtrlUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Report {
    public static /* synthetic */ Interceptable $ic;
    public static Report mReporter;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public Report(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        InterceptResult invokeL;
        Report report;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (Report.class) {
                if (mReporter == null) {
                    mReporter = new Report(context);
                }
                report = mReporter;
            }
            return report;
        }
        return (Report) invokeL.objValue;
    }

    public void fr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                CtrlUtil.getInstance(this.mContext).fr();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5) == null) {
            try {
                CommonMethods.i(this.mContext, str, str2, str3, str4, str5);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                CtrlUtil.getInstance(this.mContext).n();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                CtrlUtil.getInstance(this.mContext).s(z);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            s(str, CommonMethods.isMainThread());
        }
    }

    public void sr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                CtrlUtil.getInstance(this.mContext).reportRealTime(str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                CommonMethods.parserHostData(this.mContext, str);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void s(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            try {
                CommonMethods.s(this.mContext, str, z);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
