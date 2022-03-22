package com.baidu.tbadk.core.util.schemeaction.deeplink;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface DeepLinkCallback {

    /* loaded from: classes5.dex */
    public static class DeepLinkResponse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAppResultCode;
        public int mInnerResultCode;
        public int mMarketResultCode;
        public String mOpenSource;
        public int mWebResultCode;

        public DeepLinkResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOpenSource = "default";
            this.mInnerResultCode = 0;
            this.mAppResultCode = 0;
            this.mMarketResultCode = 0;
            this.mWebResultCode = 0;
        }

        public int getAppResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppResultCode : invokeV.intValue;
        }

        public int getInnerResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInnerResultCode : invokeV.intValue;
        }

        public int getMarketResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMarketResultCode : invokeV.intValue;
        }

        public String getOpenSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOpenSource : (String) invokeV.objValue;
        }

        public int getWebResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWebResultCode : invokeV.intValue;
        }

        public boolean isOpenSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mInnerResultCode == 1 || this.mAppResultCode == 1 || this.mMarketResultCode == 1 || this.mWebResultCode == 1 : invokeV.booleanValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void onFailed(String str, int i) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
                switch (str.hashCode()) {
                    case -1081306052:
                        if (str.equals("market")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 96801:
                        if (str.equals("app")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 117588:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 100355670:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    this.mInnerResultCode = i;
                } else if (c2 == 1) {
                    this.mAppResultCode = i;
                } else if (c2 == 2) {
                    this.mMarketResultCode = i;
                } else if (c2 != 3) {
                    if (TbadkApplication.getInst().isDebugMode()) {
                        throw new IllegalArgumentException("invalid source code");
                    }
                } else {
                    this.mWebResultCode = i;
                }
                SchemeActionHelper.printLog(str + " open onFailed-->errorCode=" + i + ":" + toString());
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void onSucceed(String str) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.mOpenSource = str;
                switch (str.hashCode()) {
                    case -1081306052:
                        if (str.equals("market")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 96801:
                        if (str.equals("app")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 117588:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 100355670:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    this.mInnerResultCode = 1;
                } else if (c2 == 1) {
                    this.mAppResultCode = 1;
                } else if (c2 == 2) {
                    this.mMarketResultCode = 1;
                } else if (c2 != 3) {
                    if (TbadkApplication.getInst().isDebugMode()) {
                        throw new IllegalArgumentException("invalid source code");
                    }
                } else {
                    this.mWebResultCode = 1;
                }
                SchemeActionHelper.printLog(str + " open onSucceed-->:" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return "DeepLinkResponse:[InnerResultCode=" + this.mInnerResultCode + ",AppResultCode=" + this.mAppResultCode + ",MarketResultCode=" + this.mMarketResultCode + ",WebResultCode=" + this.mWebResultCode + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    void onFailed(int i, String str, DeepLinkResponse deepLinkResponse);

    void onSuccess(String str, DeepLinkResponse deepLinkResponse);
}
