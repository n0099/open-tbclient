package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.iu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LoginActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_ID = "activity_id";
    public static final String AUTO_LOGIN = "autoLogin";
    public static final String AUTO_LOGIN_URL = "http://bjhw-bac-orcp-baiduapp-core-134992.bjhw.baidu.com:8090/autologin/main.html?user=%s&password=%s&business=tieba&osName=android";
    public static final String CUSTOM_LOGIN_CSS_URL = "custom_login_css_url";
    public static final String IS_FROM_AIAPP = "is_from_aiapp";
    public static final String JUMP_AFTER_DESTROY = "jump_after_destroy";
    public static final int JUMP_TO_MAINTAB = 1;
    public static final String LOGIN_DIALOG_LOGIN_LISTENER = "login_dialog_login_listener";
    public static final String SCHEME = "scheme";
    public static final String SOCIAL_TYPE = "social_type";
    public static final String URL = "url";
    public static final String USER_INFO_CHANGED = "user_info_changed";
    public static long lastStartActivityTime;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2132507928, "Lcom/baidu/tbadk/core/atomData/LoginActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2132507928, "Lcom/baidu/tbadk/core/atomData/LoginActivityConfig;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginActivityConfig(Context context, int i) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public static boolean canStartActivity() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (System.currentTimeMillis() - lastStartActivityTime < 1000 || (runTask = MessageManager.getInstance().runTask(2921352, (Class) null)) == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void setAutoLogin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            getIntent().putExtra(AUTO_LOGIN, true);
            getIntent().putExtra("scheme", str);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            getIntent().putExtra("from", str);
        }
    }

    public void setFromDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            getIntent().putExtra("fromDialog", str);
        }
    }

    public void setIsFromAiapp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            getIntent().putExtra(IS_FROM_AIAPP, z);
        }
    }

    public void setJumpToAfterDestroy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            getIntent().putExtra(JUMP_AFTER_DESTROY, i);
        }
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        getIntent().putExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL, str);
        setRequestCode(25071);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setLoginListener(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, iLoginListener) == null) || iLoginListener == null) {
            return;
        }
        getIntent().putExtra("login_dialog_login_listener", iLoginListener);
    }

    public void setMinePageStatisticParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            getIntent().putExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_KEY, str);
            getIntent().putExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE, str2);
        }
    }

    public void setThirdPartyLoginForResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            getIntent().putExtra("social_type", i);
            getIntent().putExtra("activity_id", str);
            setRequestCode(11043);
            setIntentAction(IntentAction.ActivityForResult);
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            getIntent().putExtra("url", str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginActivityConfig(Context context, boolean z, int i) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("close", z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        iu4.a(DI.ACCOUNT, -1L, 0, context.getClass().toString(), 0, "", new Object[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginActivityConfig(Context context, boolean z) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("close", z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginActivityConfig(Context context, boolean z, String str, String str2) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        getIntent().putExtra("close", z);
        getIntent().putExtra("url", str);
        getIntent().putExtra(CUSTOM_LOGIN_CSS_URL, str2);
    }
}
