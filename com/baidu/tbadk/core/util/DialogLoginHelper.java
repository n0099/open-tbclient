package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tieba.x9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DialogLoginHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIALOG_TYPE_ONE_KEY = "yijiandenglu";
    public static final String DIALOG_TYPE_SHARE = "hutongdenglu";
    public static final String FULL_SCREEN_TYPE_ONE_KEY = "yijiandenglu_2";
    public static final String FULL_SCREEN_TYPE_SHARE = "hutongdenglu_2";
    public transient /* synthetic */ FieldHolder $fh;

    public DialogLoginHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getOneKeyLoginActivityLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (UbsABTestHelper.isFirstLoginTestA()) {
                return LoginDialogData.FIRST_START_1;
            }
            if (UbsABTestHelper.isFirstLoginTestB()) {
                return LoginDialogData.FIRST_START_2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void addLoginDialogInvokeLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOGIN_DIALOG_INVOKE);
            statisticItem.param("obj_locate", str);
            statisticItem.param("obj_type", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void addMinePageLoginDialogSuccessLog(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_locate", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void addLoginDialogSuccessLog(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOGIN_DIALOG_SUCCESS);
            statisticItem.param("obj_locate", str);
            statisticItem.param("obj_type", str2);
            statisticItem.param("obj_source", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean checkUpIsLogin(LoginDialogData loginDialogData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, loginDialogData)) == null) {
            if (loginDialogData != null && FullBrowseHelper.checkAndShowFullBrowseModeDialog(x9.a(loginDialogData.getContext()))) {
                return false;
            }
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                skipToLoginDialogActivity(loginDialogData);
            }
            return isLogin;
        }
        return invokeL.booleanValue;
    }

    public static void skipToLoginDialogActivity(LoginDialogData loginDialogData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, loginDialogData) == null) && loginDialogData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921530, loginDialogData));
        }
    }
}
