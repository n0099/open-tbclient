package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class Enums {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class FingerprintAuthType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOGIN = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public FingerprintAuthType() {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LastLoginType {
        public static final /* synthetic */ LastLoginType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LastLoginType CFO;
        public static final LastLoginType CHOICE_SHARE;
        public static final LastLoginType CHOICE_SHARE_V2;
        public static final LastLoginType FACE;
        public static final LastLoginType HISTORY;
        public static final LastLoginType HONOR;
        public static final LastLoginType HUAWEI;
        public static final LastLoginType IQIYI;
        public static final LastLoginType MEIZU;
        public static final LastLoginType NONE;
        public static final LastLoginType ONEKEYLOGIN_CM;
        public static final LastLoginType ONEKEYLOGIN_CT;
        public static final LastLoginType ONEKEYLOGIN_CU;
        public static final LastLoginType OTHER;
        public static final LastLoginType PWD;
        public static final LastLoginType QQ;
        public static final LastLoginType QR;
        public static final LastLoginType SLIENT_SHARE;
        public static final LastLoginType SMS;
        public static final LastLoginType SWITCH;
        public static final LastLoginType TOUCHID;
        public static final LastLoginType WECHAT;
        public static final LastLoginType WEIBO;
        public static final LastLoginType XIAOMI;
        public static final LastLoginType YY;
        public transient /* synthetic */ FieldHolder $fh;
        public String key;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1919469933, "Lcom/baidu/sapi2/utils/enums/Enums$LastLoginType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1919469933, "Lcom/baidu/sapi2/utils/enums/Enums$LastLoginType;");
                    return;
                }
            }
            NONE = new LastLoginType(HlsPlaylistParser.METHOD_NONE, 0, "none", 0);
            PWD = new LastLoginType("PWD", 1, "pwd", 1);
            SMS = new LastLoginType("SMS", 2, LoginConstants.SMS_LOGIN, 2);
            FACE = new LastLoginType("FACE", 3, "face", 3);
            TOUCHID = new LastLoginType("TOUCHID", 4, SapiOptions.Gray.FUN_NAME_GINGER, 15);
            WECHAT = new LastLoginType("WECHAT", 5, "wechat", 4);
            WEIBO = new LastLoginType("WEIBO", 6, "weibo", 5);
            QQ = new LastLoginType(Constants.SOURCE_QQ, 7, LoginConstants.QQ_LOGIN, 6);
            HUAWEI = new LastLoginType("HUAWEI", 8, RomUtils.MANUFACTURER_HUAWEI, 10);
            HONOR = new LastLoginType("HONOR", 9, "honor", 23);
            CFO = new LastLoginType("CFO", 10, "cfo", 60);
            YY = new LastLoginType("YY", 11, "yy", 100);
            XIAOMI = new LastLoginType("XIAOMI", 12, RomUtils.MANUFACTURER_XIAOMI, 13);
            MEIZU = new LastLoginType("MEIZU", 13, "meizu", 14);
            SLIENT_SHARE = new LastLoginType("SLIENT_SHARE", 14, "slient_share", 7);
            CHOICE_SHARE = new LastLoginType("CHOICE_SHARE", 15, ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE, 8);
            CHOICE_SHARE_V2 = new LastLoginType("CHOICE_SHARE_V2", 16, ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE, 9);
            ONEKEYLOGIN_CM = new LastLoginType("ONEKEYLOGIN_CM", 17, "onekeylogin_cm", 16);
            ONEKEYLOGIN_CU = new LastLoginType("ONEKEYLOGIN_CU", 18, "onekeylogin_cu", 17);
            ONEKEYLOGIN_CT = new LastLoginType("ONEKEYLOGIN_CT", 19, "onekeylogin_ct", 18);
            SWITCH = new LastLoginType("SWITCH", 20, SetImageWatermarkTypeReqMsg.SWITCH, 19);
            QR = new LastLoginType("QR", 21, "qr", 20);
            HISTORY = new LastLoginType("HISTORY", 22, "history", 21);
            IQIYI = new LastLoginType("IQIYI", 23, "iqiyi", 22);
            LastLoginType lastLoginType = new LastLoginType("OTHER", 24, ImageViewerConfig.FROM_OTHER, -1);
            OTHER = lastLoginType;
            $VALUES = new LastLoginType[]{NONE, PWD, SMS, FACE, TOUCHID, WECHAT, WEIBO, QQ, HUAWEI, HONOR, CFO, YY, XIAOMI, MEIZU, SLIENT_SHARE, CHOICE_SHARE, CHOICE_SHARE_V2, ONEKEYLOGIN_CM, ONEKEYLOGIN_CU, ONEKEYLOGIN_CT, SWITCH, QR, HISTORY, IQIYI, lastLoginType};
        }

        public LastLoginType(String str, int i, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
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
            this.key = str2;
            this.value = i2;
        }

        public static String getNameByValue(int i) {
            InterceptResult invokeI;
            LastLoginType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (LastLoginType lastLoginType : values()) {
                    if (lastLoginType.getValue() == i) {
                        return lastLoginType.getName();
                    }
                }
                return OTHER.getName();
            }
            return (String) invokeI.objValue;
        }

        public static int getValueByName(String str) {
            InterceptResult invokeL;
            LastLoginType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return NONE.getValue();
                }
                for (LastLoginType lastLoginType : values()) {
                    if (lastLoginType.getName().equals(str)) {
                        return lastLoginType.getValue();
                    }
                }
                return OTHER.getValue();
            }
            return invokeL.intValue;
        }

        public static LastLoginType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                return (LastLoginType) Enum.valueOf(LastLoginType.class, str);
            }
            return (LastLoginType) invokeL.objValue;
        }

        public static LastLoginType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return (LastLoginType[]) $VALUES.clone();
            }
            return (LastLoginType[]) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.key;
            }
            return (String) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.value;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class NormalizeWay {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NONE = 0;
        public static final int PWD = 3;
        public static final int SMS = 1;
        public static final int SMS_EXIST = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public NormalizeWay() {
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
    }

    /* loaded from: classes2.dex */
    public static class PreLoginType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CHINA_MOBILE_OAUTH = 12;
        public static final int CHOICE_SHARE = 8;
        public static final int CHOICE_SHARE_V2 = 9;
        public static final int CM = 16;
        public static final int CT = 18;
        public static final int CU = 17;
        public static final int FACE = 3;
        public static final int HISTORY = 21;
        public static final int HUAWEI = 10;
        public static final int IQIYI = 22;
        public static final int MEIZU = 14;
        public static final int NA_QR_LOGIN = 20;
        public static final int NONE = 0;
        public static final int OTHER = 11;
        public static final int PWD = 1;
        public static final int QQ = 6;
        public static final int SLIENT_SHARE = 7;
        public static final int SMS = 2;
        public static final int SWITCH = 19;
        public static final int TOUCHID = 15;
        public static final int WECHAT = 4;
        public static final int WEIBO = 5;
        public static final int XIAOMI = 13;
        public static final int YY = 100;
        public transient /* synthetic */ FieldHolder $fh;

        public PreLoginType() {
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
    }

    public Enums() {
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
}
