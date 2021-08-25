package com.baidu.android.lbspay.channelpay.alipay;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LBSPayAli implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALI_AUTH_PAY = "authorize_pay";
    public static final String ALI_AUTH_SIGN = "authorize_sign";
    public static final String ALI_DEFAULT = "authorize_default";
    public static final String AUTHPAY_CANCEL_HOST = "BdwPolymerCancelPayNotifyHost";
    public static final String AUTHPAY_SUCCESS_HOST = "BdwPolymerSuccessPayNotifyHost";
    public transient /* synthetic */ FieldHolder $fh;
    public IChannelPay mChannelPay;
    public String mServiceType;

    /* renamed from: com.baidu.android.lbspay.channelpay.alipay.LBSPayAli$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface INoSupportAliAuthorizePay {
        void onNoSupportAliAuthorizePay();
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LBSPayAli f36669a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62391964, "Lcom/baidu/android/lbspay/channelpay/alipay/LBSPayAli$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(62391964, "Lcom/baidu/android/lbspay/channelpay/alipay/LBSPayAli$a;");
                    return;
                }
            }
            f36669a = new LBSPayAli(null);
        }
    }

    public /* synthetic */ LBSPayAli(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static LBSPayAli getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f36669a : (LBSPayAli) invokeV.objValue;
    }

    private void handleError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (ALI_AUTH_PAY.equals(this.mServiceType)) {
                IChannelPay iChannelPay = this.mChannelPay;
                if (iChannelPay != null) {
                    iChannelPay.payCancel();
                } else {
                    LBSPayResult.payResult(null, 2, "");
                }
            } else if (ALI_AUTH_SIGN.equals(this.mServiceType)) {
                LBSPayResult.payResult(null, 2, "");
            }
            setServiceType(ALI_DEFAULT);
        }
    }

    private void setServiceType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            this.mServiceType = str;
        }
    }

    public boolean aliAuthorizePay(Activity activity, String str, IChannelPay iChannelPay) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, iChannelPay)) == null) {
            boolean startAliActicity = startAliActicity(activity, ALI_AUTH_PAY, str);
            if (startAliActicity) {
                this.mChannelPay = iChannelPay;
            }
            return startAliActicity;
        }
        return invokeLLL.booleanValue;
    }

    public boolean aliAuthorizeSign(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str)) == null) ? startAliActicity(activity, ALI_AUTH_SIGN, str) : invokeLL.booleanValue;
    }

    public void clearChannelPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mChannelPay = null;
        }
    }

    public boolean finishAuthPay(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
            if (intent == null) {
                handleError();
                return false;
            }
            Uri data = intent.getData();
            if (data == null) {
                handleError();
                return false;
            }
            String host = data.getHost();
            if (host == null) {
                handleError();
                return false;
            }
            if (ALI_AUTH_PAY.equals(this.mServiceType)) {
                if (this.mChannelPay != null) {
                    if (AUTHPAY_SUCCESS_HOST.equals(host)) {
                        if ("T".equals(data.getQueryParameter("is_success")) && "TRADE_SUCCESS".equals(data.getQueryParameter("trade_status"))) {
                            this.mChannelPay.paySuccess(data.getQuery());
                        } else {
                            this.mChannelPay.payError(Result.RESULT_FAILED, EventAlias.PayEventAlias.PAY_FAIL);
                        }
                    } else if (AUTHPAY_CANCEL_HOST.equals(host)) {
                        this.mChannelPay.payCancel();
                    } else {
                        this.mChannelPay.payCancel();
                    }
                } else {
                    handleError();
                    return false;
                }
            } else if (ALI_AUTH_SIGN.equals(this.mServiceType)) {
                if (AUTHPAY_SUCCESS_HOST.equals(host)) {
                    if ("T".equals(data.getQueryParameter("is_success"))) {
                        LBSPayResult.payResult(null, 0, data.getQuery());
                    } else {
                        LBSPayResult.payResult(null, 2, data.getQuery());
                    }
                } else if (AUTHPAY_CANCEL_HOST.equals(host)) {
                    LBSPayResult.payResult(null, 2, "");
                } else {
                    LBSPayResult.payResult(null, 2, "");
                }
            }
            setServiceType(ALI_DEFAULT);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isAppInstalled(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, str)) == null) {
            List<PackageInfo> installedPackages = activity.getPackageManager().getInstalledPackages(0);
            ArrayList arrayList = new ArrayList();
            if (installedPackages != null) {
                for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                    arrayList.add(installedPackages.get(i2).packageName);
                }
            }
            return arrayList.contains(str);
        }
        return invokeLL.booleanValue;
    }

    public boolean startAliActicity(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, str, str2)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                return false;
            }
            setServiceType(str);
            activity.startActivity(intent);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public LBSPayAli() {
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
        this.mChannelPay = null;
        this.mServiceType = ALI_DEFAULT;
    }
}
