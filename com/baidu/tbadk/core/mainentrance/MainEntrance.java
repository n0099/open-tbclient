package com.baidu.tbadk.core.mainentrance;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.x85;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MainEntrance {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ENTER_BAR_DEFAULT_INDEX = 0;
    public static int ENTER_BAR_DEFAULT_INDEX_BAR_SQUARE = 1;
    public static int ENTER_BAR_DEFAULT_INDEX_MY_BAR = 0;
    public static final int FLUTTER_PRIORITY_PERSON_INFO = 8;
    public static final int GOTO_ADDRESSLIST = 4;
    public static final int GOTO_CLOSE = 200;
    public static final int GOTO_DISCOVER = 10;
    public static final int GOTO_ENTER_FORUM = 1;
    public static final int GOTO_GROUP = 2;
    public static final int GOTO_HOME = 0;
    public static final int GOTO_HOME_PAGE = 2;
    public static final int GOTO_INTEREST_GUIDE = 20;
    public static final int GOTO_LIVETAB_REC = 17;
    public static final int GOTO_LIVETAB_YANZHI = 18;
    public static final int GOTO_MAINBOTTOM_LIVE = 20;
    public static final int GOTO_MEMBER_CENTER = 14;
    public static final int GOTO_MESSAGE = 3;
    public static final int GOTO_MOVE_TO_BACK = 12;
    public static final int GOTO_NEW_CATEGORY = 21;
    @Deprecated
    public static final int GOTO_NOT_LOGIN_GUIDE = 11;
    public static final int GOTO_PERSON = 8;
    public static final String GOTO_RECOMMEND_FORUM = "1_recommend";
    public static final int GOTO_RECOMMEND_VIDEO = 15;
    public static final int GOTO_TOPIC = 16;
    public static final String GOTO_TYPE = "locate_type";
    public static final int GOTO_VIDEO_CHANNEL = 22;
    public static final String GOTO_VIDEO_CHANNEL_RECOMMEND = "22_recommend";
    public static final int GOTO_WRITE = 9;
    public static final String GO_SUB_TAB_CODE = "sub_tab_code";
    public static final String GO_SUB_TAB_NAME = "sub_tab_name";
    public static final String GO_SUB_TYPE = "sub_locate_type";
    public static final String GO_TO_FORUM_SQUARE = "ForumSquare";
    public static final String KEY_CLOSE_DIALOG = "close_dialog";
    public static final String KEY_IS_FROM_SCHEME = "is_from_scheme";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String LIVETAB_SUBTAB_INDEX = "subTabIndex";
    public static final int LIVETAB_SUBTAB_INDEX_REC = 0;
    public static final int LIVETAB_SUBTAB_INDEX_YANZHI = 1;
    public static final int PRIORITY_BASE = 0;
    public static final int PRIORITY_ENTER_FORUM = 3;
    public static final int PRIORITY_ENTER_GROUP = 1;
    public static final int PRIORITY_ENTER_LIVE = 6;
    public static final int PRIORITY_ENTER_MESSAGE = 7;
    public static final int PRIORITY_FLUTTER_ENTER_FORUM = 2;
    public static final int PRIORITY_MAINTAB = 100;
    public static final int PRIORITY_PERSON_INFO = 9;
    public static final int PRIORITY_VIDEO_CHANNEL = 5;
    public static final int PRIORITY_WRITE_THREAD = 4;
    public static int initMainTabType;
    public static x85 sMainTabInst;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1194923865, "Lcom/baidu/tbadk/core/mainentrance/MainEntrance;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1194923865, "Lcom/baidu/tbadk/core/mainentrance/MainEntrance;");
        }
    }

    public MainEntrance() {
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

    public static int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            x85 x85Var = sMainTabInst;
            if (x85Var == null) {
                return -1;
            }
            return x85Var.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public static Class<?> getMainTabClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            x85 x85Var = sMainTabInst;
            if (x85Var == null) {
                return null;
            }
            return x85Var.d();
        }
        return (Class) invokeV.objValue;
    }

    public static String getMainTabClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            x85 x85Var = sMainTabInst;
            if (x85Var == null) {
                return null;
            }
            return x85Var.f();
        }
        return (String) invokeV.objValue;
    }

    public boolean isMainTabAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (sMainTabInst != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void goToMainTab(Context context) {
        x85 x85Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, context) != null) || (x85Var = sMainTabInst) == null) {
            return;
        }
        x85Var.a(context);
    }

    public static void setMainTabInst(x85 x85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, x85Var) == null) {
            sMainTabInst = x85Var;
        }
    }

    public static void goToMainTab(Context context, int i) {
        x85 x85Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65542, null, context, i) != null) || (x85Var = sMainTabInst) == null) {
            return;
        }
        x85Var.b(context, i);
    }

    public static void goToMainTab(Context context, int i, boolean z) {
        x85 x85Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (x85Var = sMainTabInst) == null) {
            return;
        }
        x85Var.c(context, i, z);
    }

    public static void goToMainTabRefresh(Context context, int i, boolean z) {
        x85 x85Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (x85Var = sMainTabInst) == null) {
            return;
        }
        x85Var.e(context, i, z);
    }
}
