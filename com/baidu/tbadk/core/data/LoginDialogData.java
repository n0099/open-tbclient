package com.baidu.tbadk.core.data;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LoginDialogData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FIRST_LOGIN_ABTEST = "first_login_abtest";
    public static final String FIRST_START_1 = "new_start_1";
    public static final String FIRST_START_2 = "new_start_2";
    public static final String FRS_PUBLISH_RESULT_PAGE = "frs_fabu";
    public static final String HOME_PAGE_RESULT_PAGE = "new_shouye";
    public static final String INTEREST_FORUM_COMMIT = "index_interest";
    public static final String MINE_PAGE = "mine_page";
    public static final String PB_BOTTOM_REPLY_RESULT_PAGE = "pb_huitie";
    public static final String PB_COLLECT_RESULT_PAGE = "pb_shoucang";
    public static final String PB_MORE_REPLY_RESULT_PAGE = "pb_chakanhuifu";
    public static final String PB_REPLY_RESULT_PAGE = "pb_huifu_louzhonglou";
    public static final String SEARCH_RESULT_PAGE = "sousuo_dianji";
    public static final String SETTING_PAGE = "setting_page";
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public String locate;
    public ILoginListener loginListener;
    public String minePageKey;
    public String minePageLocate;
    public String url;

    public LoginDialogData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.url = null;
        this.locate = null;
        this.minePageKey = null;
        this.minePageLocate = null;
        this.context = context;
        this.locate = str;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public String getLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.locate : (String) invokeV.objValue;
    }

    public ILoginListener getLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loginListener : (ILoginListener) invokeV.objValue;
    }

    public String getMinePageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.minePageKey : (String) invokeV.objValue;
    }

    public String getMinePageLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.minePageLocate : (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public void setLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.locate = str;
        }
    }

    public void setLoginListener(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iLoginListener) == null) {
            this.loginListener = iLoginListener;
        }
    }

    public void setMinePageKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.minePageKey = str;
        }
    }

    public void setMinePageLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.minePageLocate = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.url = str;
        }
    }
}
