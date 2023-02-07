package com.baidu.sapi2.views.logindialog.enums;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class QuickLoginType {
    public static /* synthetic */ Interceptable $ic;
    public static final QuickLoginType FULL_SCREEN;
    public static final QuickLoginType HISTORY;
    public static final QuickLoginType HONOR;
    public static final QuickLoginType HUAWEI;
    public static final QuickLoginType MEIZU;
    public static final QuickLoginType ONEKEY;
    public static final QuickLoginType QQ;
    public static final QuickLoginType REGISTER;
    public static final QuickLoginType SHARE;
    public static final QuickLoginType SINA;
    public static final QuickLoginType SMS;
    public static final QuickLoginType WECHAT;
    public static final QuickLoginType XIAOMI;
    public static final QuickLoginType YY;
    public static final /* synthetic */ QuickLoginType[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1333029769, "Lcom/baidu/sapi2/views/logindialog/enums/QuickLoginType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1333029769, "Lcom/baidu/sapi2/views/logindialog/enums/QuickLoginType;");
                return;
            }
        }
        HISTORY = new QuickLoginType("HISTORY", 0, 0, "history");
        SHARE = new QuickLoginType("SHARE", 1, 1, "share");
        ONEKEY = new QuickLoginType("ONEKEY", 2, 2, "onekey");
        SMS = new QuickLoginType("SMS", 3, 3, LoginConstants.SMS_LOGIN);
        QQ = new QuickLoginType(Constants.SOURCE_QQ, 4, 4, LoginConstants.QQ_LOGIN);
        WECHAT = new QuickLoginType("WECHAT", 5, 5, "wechat");
        YY = new QuickLoginType("YY", 6, 6, "yy");
        SINA = new QuickLoginType("SINA", 7, 7, LoginConstants.SINA_LOGIN);
        HUAWEI = new QuickLoginType("HUAWEI", 8, 8, RomUtils.MANUFACTURER_HUAWEI);
        HONOR = new QuickLoginType("HONOR", 9, 9, "honor");
        XIAOMI = new QuickLoginType(RomUtils.ROM_XIAOMI, 10, 10, RomUtils.MANUFACTURER_XIAOMI);
        MEIZU = new QuickLoginType("MEIZU", 11, 11, "meizu");
        FULL_SCREEN = new QuickLoginType("FULL_SCREEN", 12, 12, "full_screen");
        QuickLoginType quickLoginType = new QuickLoginType("REGISTER", 13, 13, MiPushClient.COMMAND_REGISTER);
        REGISTER = quickLoginType;
        c = new QuickLoginType[]{HISTORY, SHARE, ONEKEY, SMS, QQ, WECHAT, YY, SINA, HUAWEI, HONOR, XIAOMI, MEIZU, FULL_SCREEN, quickLoginType};
    }

    public QuickLoginType(String str, int i, int i2, String str2) {
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
        this.a = i2;
        this.b = str2;
    }

    public static QuickLoginType getViewLoginTypeByValue(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1012429255) {
                if (hashCode != 109400031) {
                    if (hashCode == 926934164 && str.equals("history")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("share")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals("onekey")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return SMS;
                    }
                    return ONEKEY;
                }
                return SHARE;
            }
            return HISTORY;
        }
        return (QuickLoginType) invokeL.objValue;
    }

    public static QuickLoginType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (QuickLoginType) Enum.valueOf(QuickLoginType.class, str);
        }
        return (QuickLoginType) invokeL.objValue;
    }

    public static QuickLoginType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (QuickLoginType[]) c.clone();
        }
        return (QuickLoginType[]) invokeV.objValue;
    }

    public int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
