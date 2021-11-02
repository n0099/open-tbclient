package com.baidu.mobads.container.dex;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.sdk.internal.ISecurityInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class SkyDexFeedNetworkResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class<?> class1;
    public Object mAdInstanceInfo;
    public Object response;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class MaterialType {
        public static final /* synthetic */ MaterialType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaterialType GIF;
        public static final MaterialType HTML;
        public static final MaterialType NORMAL;
        public static final MaterialType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1978933914, "Lcom/baidu/mobads/container/dex/SkyDexFeedNetworkResponse$MaterialType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1978933914, "Lcom/baidu/mobads/container/dex/SkyDexFeedNetworkResponse$MaterialType;");
                    return;
                }
            }
            NORMAL = new MaterialType("NORMAL", 0, "normal");
            VIDEO = new MaterialType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 1, "video");
            HTML = new MaterialType("HTML", 2, "html");
            MaterialType materialType = new MaterialType("GIF", 3, "gif");
            GIF = materialType;
            $VALUES = new MaterialType[]{NORMAL, VIDEO, HTML, materialType};
        }

        public MaterialType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static MaterialType parse(String str) {
            InterceptResult invokeL;
            MaterialType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (MaterialType materialType : values()) {
                    if (materialType.value.equalsIgnoreCase(str)) {
                        return materialType;
                    }
                }
                return null;
            }
            return (MaterialType) invokeL.objValue;
        }

        public static MaterialType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (MaterialType) Enum.valueOf(MaterialType.class, str) : (MaterialType) invokeL.objValue;
        }

        public static MaterialType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (MaterialType[]) $VALUES.clone() : (MaterialType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    public SkyDexFeedNetworkResponse(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.class1 = null;
        this.response = null;
        this.mAdInstanceInfo = null;
        this.class1 = obj.getClass();
        this.response = obj;
    }

    private int getIntegerByReflect(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, objArr)) == null) {
            try {
                return ((Integer) SkyReflectionUtil.invoke(this.response, str, objArr)).intValue();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    private long getLongByReflect(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, objArr)) == null) {
            try {
                return ((Long) SkyReflectionUtil.invoke(this.response, str, objArr)).longValue();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    private String getStringByReflect(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, objArr)) == null) {
            try {
                return (String) SkyReflectionUtil.invoke(this.response, str, objArr);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String getActionText(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            String appPackage = getAppPackage();
            if (isDownloadApp()) {
                return (TextUtils.isEmpty(appPackage) || RemoteReflectInterface.getDownloadStatus(appPackage) != 101) ? "立即下载" : "点击安装";
            }
            IXAdInstanceInfo adInstanceInfo = getAdInstanceInfo();
            if (adInstanceInfo != null) {
                int actionType = adInstanceInfo.getActionType();
                return ((actionType == 2 || actionType == 512) && AdDownloadApkUtils.isInstalled(context, appPackage)) ? "去看看" : "查看详情";
            }
            return "查看详情";
        }
        return (String) invokeL.objValue;
    }

    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getIntegerByReflect("getActionType", new Object[0]) : invokeV.intValue;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        Field[] declaredFields;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.mAdInstanceInfo == null) {
                    for (Field field : this.response.getClass().getDeclaredFields()) {
                        if (field.getType() == IXAdInstanceInfo.class) {
                            field.setAccessible(true);
                            this.mAdInstanceInfo = field.get(this.response);
                        }
                    }
                }
                if (this.mAdInstanceInfo instanceof IXAdInstanceInfo) {
                    return (IXAdInstanceInfo) this.mAdInstanceInfo;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (IXAdInstanceInfo) invokeV.objValue;
    }

    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getStringByReflect("getAdLogoUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public String getAppPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getStringByReflect("getAppPackage", new Object[0]) : (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getLongByReflect("getAppSize", new Object[0]) : invokeV.longValue;
    }

    public String getBrandName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getStringByReflect("getBrandName", new Object[0]) : (String) invokeV.objValue;
    }

    public int getContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getIntegerByReflect("getContainerHeight", new Object[0]) : invokeV.intValue;
    }

    public int getContainerSizeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getIntegerByReflect("getContainerSizeType", new Object[0]) : invokeV.intValue;
    }

    public int getContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getIntegerByReflect("getContainerWidth", new Object[0]) : invokeV.intValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getStringByReflect("getDesc", new Object[0]) : (String) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getIntegerByReflect("getDuration", new Object[0]) : invokeV.intValue;
    }

    public Map<String, String> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                return (Map) SkyReflectionUtil.invoke(this.response, "getExtras", new Object[0]);
            } catch (Exception unused) {
                return new HashMap();
            }
        }
        return (Map) invokeV.objValue;
    }

    public String getHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getStringByReflect("getHtmlSnippet", new Object[0]) : (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getStringByReflect("getIconUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getStringByReflect("getImageUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public String getLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? getStringByReflect("getLogoUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public int getMainPicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getIntegerByReflect("getMainPicHeight", new Object[0]) : invokeV.intValue;
    }

    public int getMainPicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getIntegerByReflect("getMainPicWidth", new Object[0]) : invokeV.intValue;
    }

    public String getMarketingDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getStringByReflect("getMarketingDesc", new Object[0]) : (String) invokeV.objValue;
    }

    public String getMarketingICONUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getStringByReflect("getMarketingICONUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public MaterialType getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.response != null) {
                    return MaterialType.parse((String) SkyReflectionUtil.invoke(this.response, SkyDex.getMaterialType, new Object[0]));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (MaterialType) invokeV.objValue;
    }

    public List<String> getMultiPicUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            try {
                return (List) SkyReflectionUtil.invoke(this.response, "getMultiPicUrls", new Object[0]);
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return (List) invokeV.objValue;
    }

    public boolean getMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String stringByReflect = getStringByReflect("getMute", new Object[0]);
            return TextUtils.isEmpty(stringByReflect) || "true".equalsIgnoreCase(stringByReflect);
        }
        return invokeV.booleanValue;
    }

    public Object getNativeResonse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.response : invokeV.objValue;
    }

    public String getPowerUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? getStringByReflect("getAppPermissionLink", new Object[0]) : (String) invokeV.objValue;
    }

    public String getPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? getStringByReflect("getAppPrivacyLink", new Object[0]) : (String) invokeV.objValue;
    }

    public String getPublisher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getStringByReflect("getPublisher", new Object[0]) : (String) invokeV.objValue;
    }

    public int getStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getIntegerByReflect("getStyleType", new Object[0]) : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getStringByReflect("getTitle", new Object[0]) : (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getStringByReflect("getAppVersion", new Object[0]) : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? getStringByReflect("getVideoUrl", new Object[0]) : (String) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            try {
                return (WebView) SkyReflectionUtil.invoke(this.response, "getWebView", new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return (WebView) invokeV.objValue;
    }

    public void handleClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            try {
                SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class}, new Object[]{view});
            } catch (Exception unused) {
            }
        }
    }

    public Object invoke(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, str, objArr)) == null) ? SkyReflectionUtil.invoke(this.response, str, objArr) : invokeLL.objValue;
    }

    public boolean isAdAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, context)) == null) {
            try {
                return ((Boolean) SkyReflectionUtil.invoke(this.response, "isAdAvailable", new Class[]{Context.class}, new Object[]{context})).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            try {
                Object invoke = SkyReflectionUtil.invoke(this.response, "isAutoPlay", new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isDownloadApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? ((Boolean) SkyReflectionUtil.invoke(this.response, "isNeedDownloadApp", new Object[0])).booleanValue() : invokeV.booleanValue;
    }

    public boolean isNonWifiAutoPlay() {
        InterceptResult invokeV;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            try {
                if (this.mAdInstanceInfo == null) {
                    for (Field field : this.response.getClass().getDeclaredFields()) {
                        if (field.getType() == IXAdInstanceInfo.class) {
                            field.setAccessible(true);
                            this.mAdInstanceInfo = field.get(this.response);
                        }
                    }
                }
                if (this.mAdInstanceInfo instanceof IXAdInstanceInfo) {
                    return ((IXAdInstanceInfo) this.mAdInstanceInfo).getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
                }
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoMuted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            try {
                Object invoke = SkyReflectionUtil.invoke(this.response, "isVideoMuted", new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void onClickAd(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, context) == null) {
            SkyReflectionUtil.invoke(this.response, "onClickAd", new Class[]{Context.class}, new Object[]{context});
        }
    }

    public void onClose(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048619, this, context, i2) == null) {
            SkyReflectionUtil.invoke(this.response, "onClose", new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i2)});
        }
    }

    public void onComplete(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, context) == null) {
            SkyReflectionUtil.invoke(this.response, "onComplete", new Class[]{Context.class}, new Object[]{context});
        }
    }

    public void onError(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, context, i2, i3) == null) {
            SkyReflectionUtil.invoke(this.response, "onError", new Class[]{Context.class}, new Object[]{context});
        }
    }

    public void onFullScreen(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, context, i2) == null) {
            SkyReflectionUtil.invoke(this.response, "onFullScreen", new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i2)});
        }
    }

    public void onStart(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, context) == null) {
            SkyReflectionUtil.invoke(this.response, "onStart", new Class[]{Context.class}, new Object[]{context});
        }
    }

    public void recordImpression(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, view) == null) {
            SkyReflectionUtil.invoke(this.response, "recordImpression", new Class[]{View.class}, new Object[]{view});
        }
    }

    public void unionLogoClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            try {
                SkyReflectionUtil.invoke(this.response, ISecurityInfo.UNION_LOGO_CLICK, new Class[0], new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void handleClick(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048611, this, view, z) == null) {
            try {
                SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class, Boolean.TYPE}, new Object[]{view, Boolean.valueOf(z)});
            } catch (Exception unused) {
            }
        }
    }

    public void handleClick(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, view, i2) == null) {
            try {
                SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class, Integer.TYPE}, new Object[]{view, Integer.valueOf(i2)});
            } catch (Exception unused) {
            }
        }
    }
}
