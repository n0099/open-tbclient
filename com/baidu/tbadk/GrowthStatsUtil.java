package com.baidu.tbadk;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a0.a;
import com.baidu.searchbox.datacollector.growth.GrowthCollectManager;
import com.baidu.searchbox.datacollector.growth.model.ActiveData;
import com.baidu.searchbox.datacollector.growth.model.ChannelData;
import com.baidu.searchbox.datacollector.growth.model.ClipBoardData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GrowthStatsUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class SPLASH_SOURCE {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String PUSH = "push";
        public static final String THIRD_PARTY = "third_party";
        public transient /* synthetic */ FieldHolder $fh;

        public SPLASH_SOURCE() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class SPLASH_TYPE {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLD = "cold_start";
        public static final String WARM = "warm_start";
        public transient /* synthetic */ FieldHolder $fh;

        public SPLASH_TYPE() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public GrowthStatsUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getDownChannelFromSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : getValue(new String[]{"source", "downchannel", "channel"}, Uri.parse(str)) : (String) invokeL.objValue;
    }

    public static String getLaunchChannelFromSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : getValue(new String[]{"activitysource", "obj_source"}, Uri.parse(str)) : (String) invokeL.objValue;
    }

    public static String getSplashType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TbadkCoreApplication.getInst().getStartType() == 2 ? "cold_start" : "warm_start" : (String) invokeV.objValue;
    }

    public static String getValue(String[] strArr, Uri uri) {
        InterceptResult invokeLL;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, uri)) == null) {
            String valueFromSchema = getValueFromSchema(strArr, uri);
            if (!TextUtils.isEmpty(valueFromSchema) || (queryParameter = uri.getQueryParameter("extdata")) == null) {
                return valueFromSchema;
            }
            try {
                return getValueFromJson(strArr, new JSONObject(queryParameter));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return valueFromSchema;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getValueFromJson(String[] strArr, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, strArr, jSONObject)) == null) {
            if (strArr == null || jSONObject == null) {
                return "";
            }
            for (String str : strArr) {
                String optString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String getValueFromSchema(String[] strArr, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, strArr, uri)) == null) {
            if (strArr == null || uri == null) {
                return "";
            }
            for (String str : strArr) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static void statisticActivity() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            GrowthCollectManager.statisticActiveData(new ActiveData.Builder(TbadkCoreApplication.getFrom()).build(), TbadkCoreApplication.getInst());
            a.a();
        }
    }

    public static void statisticChannel(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            String splashType = getSplashType();
            String launchChannelFromSchema = getLaunchChannelFromSchema(str2);
            GrowthCollectManager.statisticChannelData(new ChannelData.Builder(splashType).setSource(str).setLaunchChannel(launchChannelFromSchema).setDownChannel(getDownChannelFromSchema(str2)).setSchema(str2).build());
        }
    }

    public static void statisticClipBoard(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            String launchChannelFromSchema = getLaunchChannelFromSchema(str);
            GrowthCollectManager.statisticClipBoardData(new ClipBoardData.Builder().setLaunchChannel(launchChannelFromSchema).setDownChannel(getDownChannelFromSchema(str)).setSchema(str).build());
        }
    }

    public static void statisticDeviceInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            GrowthCollectManager.init();
        }
    }
}
