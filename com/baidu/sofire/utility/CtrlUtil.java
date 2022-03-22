package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.config.ReportConfigInfo;
import com.baidu.sofire.rp.db.ReportDb;
import com.baidu.sofire.rp.info.ReportItemInfo;
import com.baidu.sofire.rp.service.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CtrlUtil {
    public static /* synthetic */ Interceptable $ic;
    public static CtrlUtil mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Service mService;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(846871196, "Lcom/baidu/sofire/utility/CtrlUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(846871196, "Lcom/baidu/sofire/utility/CtrlUtil;");
        }
    }

    public CtrlUtil(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mService = new Service(context);
    }

    public static synchronized CtrlUtil getInstance(Context context) {
        InterceptResult invokeL;
        CtrlUtil ctrlUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (CtrlUtil.class) {
                if (mInstance == null) {
                    mInstance = new CtrlUtil(context);
                }
                ctrlUtil = mInstance;
            }
            return ctrlUtil;
        }
        return (CtrlUtil) invokeL.objValue;
    }

    public void fr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Message message = new Message();
            message.what = 9;
            this.mService.sendMessage(message);
        }
    }

    public void initReport() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mService.initReport();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Message message = new Message();
            message.what = 6;
            this.mService.sendMessage(message);
        }
    }

    public void postEvent(ReportItemInfo reportItemInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, reportItemInfo, z) == null) {
            Message message = new Message();
            if (!z && !CommonMethods.isMainThread()) {
                ReportDb.getInstance(this.mContext).insertEvent(reportItemInfo);
                message.what = 10;
            } else {
                message.what = 1;
                message.obj = reportItemInfo;
            }
            this.mService.sendMessage(message);
        }
    }

    public void recordCommons(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Message message = new Message();
            message.what = 4;
            message.obj = str;
            this.mService.sendMessage(message);
        }
    }

    public void report() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Message message = new Message();
            message.what = 2;
            this.mService.sendMessage(message);
        }
    }

    public void reportDelay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message message = new Message();
            message.what = 8;
            this.mService.sendMessage(message);
        }
    }

    public void reportInstall(ReportConfigInfo reportConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, reportConfigInfo) == null) {
            this.mService.reportInstallInfo(reportConfigInfo);
            this.mService.reportAliveInfo(reportConfigInfo);
        }
    }

    public void reportRealTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            this.mService.sendMessage(message);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mService.start(z);
        }
    }
}
