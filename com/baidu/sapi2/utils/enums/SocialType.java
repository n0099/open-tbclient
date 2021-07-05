package com.baidu.sapi2.utils.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class SocialType {
    public static final /* synthetic */ SocialType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SocialType FACEBOOK;
    public static final SocialType GLORY;
    public static final SocialType GOOGLE;
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
        GLORY = new SocialType("GLORY", 5, 45, "荣耀");
        IQIYI = new SocialType("IQIYI", 6, 47, "爱奇艺");
        XIAOMI = new SocialType("XIAOMI", 7, 49, "小米");
        MEIZU = new SocialType("MEIZU", 8, 50, "魅族");
        FACEBOOK = new SocialType("FACEBOOK", 9, 55, "facebook");
        TWITTER = new SocialType("TWITTER", 10, 56, "twitter");
        GOOGLE = new SocialType("GOOGLE", 11, 57, "google");
        YY = new SocialType("YY", 12, 58, "YY");
        QQ_SSO_BACKGROUND = new SocialType("QQ_SSO_BACKGROUND", 13, 100015, "QQ_SSO_BACKGROUND");
        SocialType socialType = new SocialType("WEIXIN_BACKGROUND", 14, 100042, "微信");
        WEIXIN_BACKGROUND = socialType;
        $VALUES = new SocialType[]{UNKNOWN, SINA_WEIBO_SSO, QQ_SSO, WEIXIN, HUAWEI, GLORY, IQIYI, XIAOMI, MEIZU, FACEBOOK, TWITTER, GOOGLE, YY, QQ_SSO_BACKGROUND, socialType};
    }

    public SocialType(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i3;
        this.name = str2;
    }

    public static SocialType getSocialType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 2) {
                if (i2 != 15) {
                    if (i2 != 42) {
                        if (i2 != 45) {
                            if (i2 != 47) {
                                if (i2 != 55) {
                                    if (i2 != 49) {
                                        if (i2 != 50) {
                                            return UNKNOWN;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SocialType) Enum.valueOf(SocialType.class, str) : (SocialType) invokeL.objValue;
    }

    public static SocialType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (SocialType[]) $VALUES.clone() : (SocialType[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : invokeV.intValue;
    }
}
