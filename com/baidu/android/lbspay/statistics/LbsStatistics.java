package com.baidu.android.lbspay.statistics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class LbsStatistics {
    public static /* synthetic */ Interceptable $ic = null;
    public static String LBS_ALIPAY = "lbsAliPayRet";
    public static String LBS_API_GET_CASHIER = "lbsApiGetCashier";
    public static String LBS_API_GET_PAY = "lbsApiGetPay";
    public static String LBS_BAIDU_PAY = "lbsBaiduPayRet";
    public static String LBS_DO_PAY_CLICK = "lbsDoPayClick";
    public static String LBS_FAST_PAY = "lbsFastPayRet";
    public static String LBS_IPAY_PAY = "lbsIpayPayRet";
    public static String LBS_MORE_CHANNELS = "lbsMoreChannels";
    public static String LBS_PAY = "lbsPay";
    public static String LBS_PAY_AMOUNT = "lbsPayAmount";
    public static String LBS_UINON_PAY = "lbsUinonPayRet";
    public static String LBS_WXPAY = "lbsWXPayRet";
    public static final String QUIT_CASHDESK = "quitCashDesk";
    public static String RECEIVE_ALIPAY_SMS = "receiveAlipaySms";
    public static String WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CANCEL = "lbsAliFailGuideDxmPayCancel";
    public static String WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_CONFIRM = "lbsAliFailGuideDxmPayConfirm";
    public static String WALLET_LBS_ALI_FAIL_GUIDE_DXM_PAY_INSTALL_ALI_PAY_PKG = "lbsAliFailGuideDxmPayInstallAliPay";
    public static String WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CANCEL = "lbsAliFailGuideInstallCancel";
    public static String WALLET_LBS_ALI_FAIL_GUIDE_INSTALL_CONFIRM = "lbsAliFailGuideInstallAliPayConfirm";
    public static String WALLET_LBS_BANNER_CLICK = "lbsBannerClick";
    public static String WALLET_LBS_BANNER_CLICK_PAY = "lbsBannerClickPay";
    public static String WALLET_LBS_BANNER_HIDE = "lbsBannerHide";
    public static String WALLET_LBS_BANNER_SHOW = "lbsBannerShow";
    public static String WALLET_LBS_FRONT_CASHIER_ALI_AUTHORIZE_PAY_CANCEL = "lbsFrontCashierAliAuthorizePayCancel";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(936959345, "Lcom/baidu/android/lbspay/statistics/LbsStatistics;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(936959345, "Lcom/baidu/android/lbspay/statistics/LbsStatistics;");
        }
    }

    public LbsStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
