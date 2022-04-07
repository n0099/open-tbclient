package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MainTabActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean ENTER_FORUM_DELEGATE_AVAILABLE = true;
    public static boolean ENTER_FORUM_TAB_AVAIBLE = true;
    public static final String EXIT_APP = "exit_app";
    public static boolean IMMESSAGE_CENTER_DELEGATE_AVAIBLE = true;
    public static boolean IS_BACK_CLOSE_ALL_ACTIVITY = false;
    public static boolean IS_INDICATOR_BOTTOM = true;
    public static boolean IS_MAIN_TAB_SPLASH_SHOW = false;
    public static final String IS_NEW_USER = "is_new_user";
    public static final String MAIN_TAB = "main_tab";
    public static boolean MEMBER_CENTER_TAB_AVAILABLE = true;
    public static final String NEED_CLOSE_MENU = "need_close_menu";
    public static boolean NEW_CATEGORY_TAB_AVAIBLE = true;
    public static boolean PERSON_TAB_AVAIBLE = true;
    public static final String PUSH_DES_PAGE = "des_page";
    public static final String PUSH_FOLLOW_UP_ACTION = "follow_up_action";
    public static final String TARGET_SCHEME = "target_scheme";
    public static final String TARGET_SCHEME_BAK = "target_scheme_bak";
    public static final String VIDEOTHREAD_ON_SQUARE_ID = "videothread_on_square_id";
    public static boolean VIDEO_CHANNEL_TAB_AVAILABLE = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(864484629, "Lcom/baidu/tbadk/core/atomData/MainTabActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(864484629, "Lcom/baidu/tbadk/core/atomData/MainTabActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainTabActivityConfig(Context context) {
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
    }

    public static void toExitApp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(context);
            mainTabActivityConfig.getIntent().putExtra(EXIT_APP, true);
            mainTabActivityConfig.start();
        }
    }

    public MainTabActivityConfig buildVideoThreadId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            getIntent().putExtra(VIDEOTHREAD_ON_SQUARE_ID, str);
            return this;
        }
        return (MainTabActivityConfig) invokeL.objValue;
    }

    public MainTabActivityConfig createNewUserCfg(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Intent intent = getIntent();
            intent.setFlags(603979776);
            if (!(getContext() instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            if (i >= 0) {
                intent.putExtra("locate_type", i);
            }
            intent.putExtra(IS_NEW_USER, z);
            intent.putExtra("close_dialog", true);
            intent.putExtra(NEED_CLOSE_MENU, z2);
            return this;
        }
        return (MainTabActivityConfig) invokeCommon.objValue;
    }

    public MainTabActivityConfig createNormalCfg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? createNewUserCfg(i, false, false) : (MainTabActivityConfig) invokeI.objValue;
    }

    public MainTabActivityConfig createRefreshCfg(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Intent intent = getIntent();
            intent.setFlags(603979776);
            if (i != 200 && i != 12) {
                intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
            } else {
                intent.putExtra(FrsActivityConfig.KEY_REFRESH, false);
            }
            if (i >= 0) {
                intent.putExtra("locate_type", i);
            }
            if (z) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra("close_dialog", true);
            return this;
        }
        return (MainTabActivityConfig) invokeCommon.objValue;
    }

    public MainTabActivityConfig createUriCfg(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uri)) == null) {
            getIntent().setData(uri);
            return this;
        }
        return (MainTabActivityConfig) invokeL.objValue;
    }

    public void setBottomTab(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || getIntent() == null || i < 0) {
            return;
        }
        getIntent().putExtra("locate_type", i);
    }

    public void setPushDesPage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(PUSH_DES_PAGE, str);
    }

    public void setPushFollowUpAction(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(PUSH_FOLLOW_UP_ACTION, i);
    }

    public void setSubTab(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) || getIntent() == null) {
            return;
        }
        if (str == null) {
            getIntent().putExtra("sub_locate_type", i);
        } else {
            getIntent().putExtra("sub_locate_type", str);
        }
    }

    public void setSubTabName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("sub_tab_name", str);
    }

    public void setTargetScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            getIntent().putExtra(TARGET_SCHEME, str);
        }
    }

    public MainTabActivityConfig createNormalCfg(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? createNewUserCfg(i, false, z) : (MainTabActivityConfig) invokeCommon.objValue;
    }

    public MainTabActivityConfig createNewUserCfg(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? createNewUserCfg(i, z, false) : (MainTabActivityConfig) invokeCommon.objValue;
    }
}
