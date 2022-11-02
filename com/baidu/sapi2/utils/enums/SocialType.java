package com.baidu.sapi2.utils.enums;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class SocialType {
    public static final /* synthetic */ SocialType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SocialType CFO;
    public static final SocialType FACEBOOK;
    public static final SocialType GOOGLE;
    public static final SocialType HONOR;
    public static final SocialType HUAWEI;
    public static final SocialType IQIYI;
    public static final SocialType MEIZU;
    public static final SocialType QQ_SSO;
    public static final SocialType QQ_SSO_BACKGROUND;
    public static final SocialType SINA_WEIBO_SSO;
    public static final SocialType TWITTER;
    public static final SocialType UNKNOWN;
    public static final SocialType WEIXIN;
    public static final SocialType WEIXIN_BACKGROUND;
    public static final SocialType XIAOMI;
    public static final SocialType YY;
    public transient /* synthetic */ FieldHolder $fh;
    public String name;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223756857, "Lcom/baidu/sapi2/utils/enums/SocialType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-223756857, "Lcom/baidu/sapi2/utils/enums/SocialType;");
                return;
            }
        }
        UNKNOWN = new SocialType(RomUtils.UNKNOWN, 0, 0, FileUtils.UNKNOW);
        SINA_WEIBO_SSO = new SocialType("SINA_WEIBO_SSO", 1, 2, "新浪微博SSO");
        QQ_SSO = new SocialType("QQ_SSO", 2, 15, "QQ_SSO");
        WEIXIN = new SocialType("WEIXIN", 3, 42, "微信");
        HUAWEI = new SocialType("HUAWEI", 4, 45, "华为");
        HONOR = new SocialType("HONOR", 5, 61, "荣耀");
        IQIYI = new SocialType("IQIYI", 6, 47, "爱奇艺");
        XIAOMI = new SocialType("XIAOMI", 7, 49, "小米");
        MEIZU = new SocialType("MEIZU", 8, 50, "魅族");
        FACEBOOK = new SocialType("FACEBOOK", 9, 55, "facebook");
        TWITTER = new SocialType("TWITTER", 10, 56, "twitter");
        GOOGLE = new SocialType("GOOGLE", 11, 57, "google");
        YY = new SocialType("YY", 12, 58, "YY");
        CFO = new SocialType("CFO", 13, 60, "CFO");
        QQ_SSO_BACKGROUND = new SocialType("QQ_SSO_BACKGROUND", 14, MemberPayActivityConfig.SCENE_FROM_FRS, "QQ_SSO_BACKGROUND");
        SocialType socialType = new SocialType("WEIXIN_BACKGROUND", 15, 100042, "微信");
        WEIXIN_BACKGROUND = socialType;
        $VALUES = new SocialType[]{UNKNOWN, SINA_WEIBO_SSO, QQ_SSO, WEIXIN, HUAWEI, HONOR, IQIYI, XIAOMI, MEIZU, FACEBOOK, TWITTER, GOOGLE, YY, CFO, QQ_SSO_BACKGROUND, socialType};
    }

    public SocialType(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
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
        this.type = i2;
        this.name = str2;
    }

    public static SocialType getSocialType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 2) {
                if (i != 15) {
                    if (i != 42) {
                        if (i != 45) {
                            if (i != 47) {
                                if (i != 55) {
                                    if (i != 49) {
                                        if (i != 50) {
                                            if (i != 60) {
                                                if (i != 61) {
                                                    return UNKNOWN;
                                                }
                                                return HONOR;
                                            }
                                            return CFO;
                                        }
                                        return MEIZU;
                                    }
                                    return XIAOMI;
                                }
                                return FACEBOOK;
                            }
                            return IQIYI;
                        }
                        return HUAWEI;
                    }
                    return WEIXIN;
                }
                return QQ_SSO;
            }
            return SINA_WEIBO_SSO;
        }
        return (SocialType) invokeI.objValue;
    }

    public static SocialType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (SocialType) Enum.valueOf(SocialType.class, str);
        }
        return (SocialType) invokeL.objValue;
    }

    public static SocialType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (SocialType[]) $VALUES.clone();
        }
        return (SocialType[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }
}
