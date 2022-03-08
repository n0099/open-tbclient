package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OfficalBarChatActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean IS_SUPPORT_OFFICIAL_CHAT = false;
    public static final String USER_TYPE = "user_type";
    public transient /* synthetic */ FieldHolder $fh;
    public UserData mUserData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1884751084, "Lcom/baidu/tbadk/core/atomData/OfficalBarChatActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1884751084, "Lcom/baidu/tbadk/core/atomData/OfficalBarChatActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficalBarChatActivityConfig(Context context, long j2, String str, String str2, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUserData = null;
        UserData userData = new UserData(j2, str, str2, i2);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("user", userData);
        intent.putExtra("user_type", 1);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUserData : (UserData) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficalBarChatActivityConfig(Context context, long j2, String str, String str2, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUserData = null;
        UserData userData = new UserData(j2, str, str2, i2);
        this.mUserData = userData;
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        intent.putExtra("user", userData);
        intent.putExtra("user_type", i3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
    }
}
