package com.baidu.tbadk.core.util.deeplink;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface DeepLinkCallback {

    /* loaded from: classes8.dex */
    public static class DeepLinkResponse {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAppResultCode;
        public int mMarketResultCode;
        public String mOpenSource;
        public int mWebResultCode;

        public DeepLinkResponse() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOpenSource = "default";
            this.mAppResultCode = 0;
            this.mMarketResultCode = 0;
            this.mWebResultCode = 0;
        }

        public int getAppResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppResultCode : invokeV.intValue;
        }

        public int getMarketResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMarketResultCode : invokeV.intValue;
        }

        public String getOpenSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOpenSource : (String) invokeV.objValue;
        }

        public int getWebResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWebResultCode : invokeV.intValue;
        }

        public boolean isOpenSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAppResultCode == 1 || this.mMarketResultCode == 1 || this.mWebResultCode == 1 : invokeV.booleanValue;
        }

        public void onFailed(String str, int i2) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
                int hashCode = str.hashCode();
                if (hashCode == -1081306052) {
                    if (str.equals("market")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 96801) {
                    if (hashCode == 117588 && str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("app")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.mAppResultCode = i2;
                } else if (c2 == 1) {
                    this.mMarketResultCode = i2;
                } else if (c2 != 2) {
                    if (TbadkApplication.getInst().isDebugMode()) {
                        throw new IllegalArgumentException("invalid source code");
                    }
                } else {
                    this.mWebResultCode = i2;
                }
                DeepLinkParser.printLog(str + " open onFailed-->errorCode=" + i2 + ":" + toString());
            }
        }

        public void onSucceed(String str) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mOpenSource = str;
                int hashCode = str.hashCode();
                if (hashCode == -1081306052) {
                    if (str.equals("market")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 96801) {
                    if (hashCode == 117588 && str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("app")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.mAppResultCode = 1;
                } else if (c2 == 1) {
                    this.mMarketResultCode = 1;
                } else if (c2 != 2) {
                    if (TbadkApplication.getInst().isDebugMode()) {
                        throw new IllegalArgumentException("invalid source code");
                    }
                } else {
                    this.mWebResultCode = 1;
                }
                DeepLinkParser.printLog(str + " open onSucceed-->:" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "DeepLinkResponse:[OpenSource=" + this.mOpenSource + ",AppResultCode=" + this.mAppResultCode + ",MarketResultCode=" + this.mMarketResultCode + ",WebResultCode=" + this.mWebResultCode + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    void onFailed(int i2, String str, DeepLinkResponse deepLinkResponse);

    void onSuccess(String str, DeepLinkResponse deepLinkResponse);
}
