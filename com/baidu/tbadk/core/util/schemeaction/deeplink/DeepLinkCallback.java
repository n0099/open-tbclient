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
/* loaded from: classes3.dex */
public interface DeepLinkCallback {
    void onFailed(int i, String str, DeepLinkResponse deepLinkResponse);

    void onSuccess(String str, DeepLinkResponse deepLinkResponse);

    /* loaded from: classes3.dex */
    public class DeepLinkResponse {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mAppResultCode;
            }
            return invokeV.intValue;
        }

        public int getInnerResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mInnerResultCode;
            }
            return invokeV.intValue;
        }

        public int getMarketResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mMarketResultCode;
            }
            return invokeV.intValue;
        }

        public String getOpenSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mOpenSource;
            }
            return (String) invokeV.objValue;
        }

        public int getWebResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mWebResultCode;
            }
            return invokeV.intValue;
        }

        public boolean isOpenSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.mInnerResultCode == 1 || this.mAppResultCode == 1 || this.mMarketResultCode == 1 || this.mWebResultCode == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void onFailed(String str, int i) {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
                switch (str.hashCode()) {
                    case -1081306052:
                        if (str.equals("market")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 96801:
                        if (str.equals("app")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 117588:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 100355670:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (TbadkApplication.getInst().isDebugMode()) {
                                    throw new IllegalArgumentException("invalid source code");
                                }
                            } else {
                                this.mWebResultCode = i;
                            }
                        } else {
                            this.mMarketResultCode = i;
                        }
                    } else {
                        this.mAppResultCode = i;
                    }
                } else {
                    this.mInnerResultCode = i;
                }
                SchemeActionHelper.printLog(str + " open onFailed-->errorCode=" + i + ":" + toString());
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void onSucceed(String str) {
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.mOpenSource = str;
                switch (str.hashCode()) {
                    case -1081306052:
                        if (str.equals("market")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 96801:
                        if (str.equals("app")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 117588:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 100355670:
                        if (str.equals(DeepLinkCode.OpenAppSource.OPEN_SOURCE_INNER)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (TbadkApplication.getInst().isDebugMode()) {
                                    throw new IllegalArgumentException("invalid source code");
                                }
                            } else {
                                this.mWebResultCode = 1;
                            }
                        } else {
                            this.mMarketResultCode = 1;
                        }
                    } else {
                        this.mAppResultCode = 1;
                    }
                } else {
                    this.mInnerResultCode = 1;
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
}
