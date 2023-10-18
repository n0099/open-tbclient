package com.baidu.mobads.sdk.api;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ActionBarColorTheme {
    public static final /* synthetic */ ActionBarColorTheme[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME;
    public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME;
    public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME;
    public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME;
    public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME;
    public static final ActionBarColorTheme ACTION_BAR_RED_THEME;
    public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBackgroundColor;
    public int mCloseColor;
    public int mProgressColor;
    public int mTitleColor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1224327693, "Lcom/baidu/mobads/sdk/api/ActionBarColorTheme;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1224327693, "Lcom/baidu/mobads/sdk/api/ActionBarColorTheme;");
                return;
            }
        }
        ACTION_BAR_WHITE_THEME = new ActionBarColorTheme("ACTION_BAR_WHITE_THEME", 0, -5987164, -6842473, -11113262, SwipeRefreshLayout.CIRCLE_BG_LIGHT);
        ACTION_BAR_RED_THEME = new ActionBarColorTheme("ACTION_BAR_RED_THEME", 1, -1, -1, -12510, -1294276);
        ACTION_BAR_GREEN_THEME = new ActionBarColorTheme("ACTION_BAR_GREEN_THEME", 2, -1, -1, -11113262, -14303071);
        ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme("ACTION_BAR_NAVYBLUE_THEME", 3, -1, -1, 16764706, -14210226);
        ACTION_BAR_BLUE_THEME = new ActionBarColorTheme("ACTION_BAR_BLUE_THEME", 4, -1, -1, -12510, -13870424);
        ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme("ACTION_BAR_COFFEE_THEME", 5, -1, -1, -12510, -11255230);
        ActionBarColorTheme actionBarColorTheme = new ActionBarColorTheme("ACTION_BAR_BLACK_THEME", 6, -1, -1, -12510, -13749450);
        ACTION_BAR_BLACK_THEME = actionBarColorTheme;
        $VALUES = new ActionBarColorTheme[]{ACTION_BAR_WHITE_THEME, ACTION_BAR_RED_THEME, ACTION_BAR_GREEN_THEME, ACTION_BAR_NAVYBLUE_THEME, ACTION_BAR_BLUE_THEME, ACTION_BAR_COFFEE_THEME, actionBarColorTheme};
    }

    public ActionBarColorTheme(String str, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCloseColor = i2;
        this.mTitleColor = i3;
        this.mProgressColor = i4;
        this.mBackgroundColor = i5;
    }

    public static ActionBarColorTheme valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ActionBarColorTheme) Enum.valueOf(ActionBarColorTheme.class, str);
        }
        return (ActionBarColorTheme) invokeL.objValue;
    }

    public static ActionBarColorTheme[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ActionBarColorTheme[]) $VALUES.clone();
        }
        return (ActionBarColorTheme[]) invokeV.objValue;
    }
}
