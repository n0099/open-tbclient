package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaStaticHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> mActivityNames;
    public static String mCurrentActivityAllName;
    public static String mCurrentActivityName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(253321808, "Lcom/baidu/tbadk/core/util/TiebaStaticHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(253321808, "Lcom/baidu/tbadk/core/util/TiebaStaticHelper;");
                return;
            }
        }
        mActivityNames = new HashMap<>();
    }

    public TiebaStaticHelper() {
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

    public static String getCurrentActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return mCurrentActivityName;
        }
        return (String) invokeV.objValue;
    }

    public static String getCurrentActivityAllName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return mCurrentActivityAllName;
        }
        return (String) invokeV.objValue;
    }

    public static void addYYParam(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, statisticItem) != null) || !TbSingleton.getInstance().isYYSwitchStatusIsOn()) {
            return;
        }
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
    }

    public static void addYYParam(StatisticItem statisticItem, YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, statisticItem, yyExtData) != null) || yyExtData == null) {
            return;
        }
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param("template_id", yyExtData.mTemplateId);
        if (!statisticItem.hasParam("liveid")) {
            statisticItem.param("liveid", yyExtData.liveId);
        }
    }

    public static String getShortName(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, i);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void setCurrentActivity(String str) {
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            mCurrentActivityAllName = str;
            if (TextUtils.isEmpty(str)) {
                mCurrentActivityName = str;
                return;
            }
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf != -1 && (i = lastIndexOf + 1) < str.length()) {
                str = str.substring(i, str.length());
            }
            HashMap<String, String> hashMap = mActivityNames;
            if (hashMap != null) {
                str2 = hashMap.get(str);
            } else {
                str2 = "";
            }
            if (str2 == null) {
                str2 = getShortName(str);
                HashMap<String, String> hashMap2 = mActivityNames;
                if (hashMap2 != null) {
                    hashMap2.put(str, str2);
                }
            }
            if (str2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                mCurrentActivityName = str2 + currentTimeMillis;
            }
        }
    }
}
