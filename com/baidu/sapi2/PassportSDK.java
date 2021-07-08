package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class PassportSDK {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PassportSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized PassportSDK getInstance() {
        InterceptResult invokeV;
        PassportSDK passportSDK;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (PassportSDK.class) {
                passportSDK = new PassportSDK();
            }
            return passportSDK;
        }
        return (PassportSDK) invokeV.objValue;
    }

    public void extendSysWebViewMethod(Activity activity, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, extendSysWebViewMethodCallback) == null) {
            CoreViewRouter.getInstance().extendSysWebViewMethod(activity, str, extendSysWebViewMethodCallback);
        }
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, str2, i2) == null) {
            CoreViewRouter.getInstance().handleWXLoginResp(activity, str, str2, i2);
        }
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, webAuthListener, storageModel) == null) {
            CoreViewRouter.getInstance().invokeV2ShareLogin(activity, storageModel, webAuthListener, "");
        }
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, accountCenterCallback, accountCenterDTO) == null) {
            CoreViewRouter.getInstance().loadAccountCenter(accountCenterCallback, accountCenterDTO);
        }
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, accountRealNameCallback, realNameDTO) == null) {
            CoreViewRouter.getInstance().loadAccountRealName(context, accountRealNameCallback, realNameDTO);
        }
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, accountToolsDTO, accountToolsCallback) == null) {
            CoreViewRouter.getInstance().loadAccountTools(accountToolsDTO, accountToolsCallback);
        }
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, addressManageDTO, addressManageCallback) == null) {
            EcommerceRouter.getInstance().loadAddressManage(context, addressManageDTO, addressManageCallback);
        }
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webBindWidgetCallback, webBindWidgetDTO) == null) {
            CoreViewRouter.getInstance().loadBindWidget(webBindWidgetCallback, webBindWidgetDTO);
        }
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, accountRealNameCallback) == null) {
            CoreViewRouter.getInstance().loadChildActivity(context, accountRealNameCallback);
        }
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, invoiceBuildDTO, invoiceBuildCallback) == null) {
            EcommerceRouter.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, invoiceBuildCallback);
        }
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, oneKeyLoginCallback) == null) {
            CoreViewRouter.getInstance().loadOneKeyLogin(context, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, qrLoginCallback, str) == null) {
            CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str);
        }
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, qrLoginCallback, str) == null) {
            CoreViewRouter.getInstance().loadQrLoginWithEncuid(qrLoginCallback, str);
        }
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, switchAccountDTO, webAuthListener) == null) {
            CoreViewRouter.getInstance().loadSwitchAccount(switchAccountDTO, webAuthListener);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, webAuthListener, socialType) == null) {
            CoreViewRouter.getInstance().loadThirdPartyLogin(webAuthListener, socialType);
        }
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, context, str, webAuthListener) == null) {
            CoreViewRouter.getInstance().loadYYSSOLogin(context, str, webAuthListener);
        }
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, activity, registerUserFaceIDCallback, faceIDRegDTO) == null) {
            CoreViewRouter.getInstance().registerUserFaceID(activity, registerUserFaceIDCallback, faceIDRegDTO);
        }
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, activityResultCallback) == null) {
            CoreViewRouter.getInstance().setActivityResultCallback(activityResultCallback);
        }
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, imageCropCallback) == null) {
            CoreViewRouter.getInstance().setImageCropCallback(imageCropCallback);
        }
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, authWidgetCallback, str) == null) {
            CoreViewRouter.getInstance().startAuth(authWidgetCallback, str);
        }
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, context, webAuthListener, webLoginDTO) == null) {
            CoreViewRouter.getInstance().startHorizontalScreenLogin(context, webAuthListener, webLoginDTO);
        }
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, webAuthListener, webLoginDTO) == null) {
            CoreViewRouter.getInstance().startLogin(webAuthListener, webLoginDTO);
        }
    }

    public void startLoginDeviceManager(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, context) == null) && SapiAccountManager.getInstance().isLogin()) {
            CoreViewRouter.getInstance().startLoginDeviceManager(context);
        }
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, context, normalizeGuestAccountCallback, normalizeGuestAccountDTO) == null) {
            CoreViewRouter.getInstance().startNormalizeGuestAccount(context, normalizeGuestAccountCallback, normalizeGuestAccountDTO);
        }
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, webAuthListener, webRegDTO) == null) {
            CoreViewRouter.getInstance().startRegister(webAuthListener, webRegDTO);
        }
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) {
            CoreViewRouter.getInstance().startSchemeLoginForQA(context, str);
        }
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, smsViewLoginCallback, str) == null) {
            CoreViewRouter.getInstance().startSmsViewLogin(smsViewLoginCallback, str);
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO) == null) {
            CoreViewRouter.getInstance().verifyUserFaceIDWithCertInfo(activity, passFaceRecogCallback, faceIDVerifyCertInfoDTO);
        }
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, activity, verifyUserFaceIDCallback, faceIDVerifyDTO) == null) {
            CoreViewRouter.getInstance().verifyUserFaceId(activity, verifyUserFaceIDCallback, faceIDVerifyDTO);
        }
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, ShareStorage.StorageModel storageModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, webAuthListener, storageModel, str) == null) {
            CoreViewRouter.getInstance().invokeV2ShareLogin(activity, storageModel, webAuthListener, str);
        }
    }

    @Deprecated
    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, str, oneKeyLoginCallback) == null) {
            CoreViewRouter.getInstance().loadOneKeyLogin(context, str, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, qrLoginCallback, str, str2) == null) {
            CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str, str2);
        }
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, webAuthListener, webSocialLoginDTO) == null) {
            CoreViewRouter.getInstance().loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, webAuthListener, webLoginDTO) == null) {
            CoreViewRouter.getInstance().startLogin(context, webAuthListener, webLoginDTO);
        }
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, context, str, webAuthListener) == null) {
            CoreViewRouter.getInstance().startSchemeLoginForQA(context, str, webAuthListener);
        }
    }

    public void loadOneKeyLogin(Context context, String str, boolean z, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, Boolean.valueOf(z), oneKeyLoginCallback}) == null) {
            CoreViewRouter.getInstance().loadOneKeyLogin(context, str, z, oneKeyLoginCallback);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{qrLoginCallback, str, str2, Boolean.valueOf(z)}) == null) {
            CoreViewRouter.getInstance().loadQrLogin(qrLoginCallback, str, str2, z);
        }
    }
}
