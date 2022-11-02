package com.baidu.sapi2;

import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CertGuardianResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiJsCallBacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface BdOauthCallback {
        void onCallback(String str);
    }

    /* loaded from: classes2.dex */
    public interface BiometricsIdentificationLiveCallBack {
        void getLiveImage(int i, PassFaceRecogCallback passFaceRecogCallback);
    }

    /* loaded from: classes2.dex */
    public interface CertGuardianRusultCallback {
        void onFinish(CertGuardianResult certGuardianResult);
    }

    /* loaded from: classes2.dex */
    public interface CurrentAccountBdussExpiredCallback {
        void onBdussExpired();
    }

    /* loaded from: classes2.dex */
    public interface GetCurrentPageNameCallback {
        void getCurrentPageName(String str);
    }

    /* loaded from: classes2.dex */
    public interface GrantWebCallback {
        public static final int backWap = 0;
        public static final int remainNa = 1;

        void onGrant(int i);
    }

    /* loaded from: classes2.dex */
    public interface IdcardOcrImageCallBack {
        void getIdcardImage(String str, String str2, IdcardOcrImageCallback idcardOcrImageCallback);
    }

    /* loaded from: classes2.dex */
    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    /* loaded from: classes2.dex */
    public interface IsForbidRecordCallBack {
        void onForbidRecord(Boolean bool);
    }

    /* loaded from: classes2.dex */
    public interface JumpToUriCallBack {
        void onJumpTo(String str);
    }

    /* loaded from: classes2.dex */
    public interface LoginStatusChangeCallback {
        void onChange();
    }

    /* loaded from: classes2.dex */
    public interface MakeVibrateCallBack {
        void presetVibrate(String str);

        void vibrate(long[] jArr, int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i, String str);

        void onSuccess(boolean z, String str);
    }

    /* loaded from: classes2.dex */
    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i);
    }

    /* loaded from: classes2.dex */
    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    /* loaded from: classes2.dex */
    public interface SpeechRecognitionCallback {
        void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult);
    }

    /* loaded from: classes2.dex */
    public interface StopSlideWebviewCallback {
        void onStopSlide(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface SwitchStyleForCloseBtnAndStatusBarCallBack {
        public static final String mBlack = "0";
        public static final String mWhite = "1";

        void switchStyle(String str);
    }

    /* loaded from: classes2.dex */
    public interface SyncAccountCallBack {
        void onSyncAccount(SapiAccount sapiAccount);
    }

    /* loaded from: classes2.dex */
    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public static class BdOauthLoginParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;

        public BdOauthLoginParams() {
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
    public static class CallBacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SapiWebView.AccountDestoryCallback accountDestoryCallback;
        public SapiWebView.AccountFreezeCallback accountFreezeCallback;
        public AuthorizationListener authorizationListener;
        public BdOauthLoginParams bdOauthLoginParams;
        public SapiWebView.BdussChangeCallback bdussChangeCallback;
        public SapiWebView.BindWidgetCallback bindWidgetCallback;
        public SapiWebView.BioScanFaceCallback bioScanFaceCallback;
        public BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack;
        public SapiWebView.BiometricsIdentifyCallback biometricsIdentifyCallback;
        public CertGuardianRusultCallback certGuardianRusultCallback;
        public SapiWebView.CoverWebBdussCallback coverWebBdussCallback;
        public CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback;
        public DirectedLoginParams directedLoginParams;
        public FingerprintCallback fingerprintCallback;
        public boolean finishPage;
        public FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack;
        public GetCurrentPageNameCallback getCurrentPageNameCallback;
        public GrantWebCallback grantWebCallback;
        public boolean hideSuccessTip;
        public SapiWebView.HistoryLoginCallback historyLoginCallback;
        public IdcardOcrImageCallBack idcardOcrImageCallBack;
        public InvoiceBuildCallback invoiceBuildCallback;
        public SapiWebView.InvokeScAppCallback invokeScAppCallback;
        public IsForbidRecordCallBack isForbidRecordCallBack;
        public JoinLoginParams joinLoginParams;
        public JumpToUriCallBack jumpToUriCallBack;
        public int leftBtnIsVisible;
        public SapiWebView.LeftBtnVisibleCallback leftBtnVisibleCallback;
        public SapiWebView.LoadExternalWebViewCallback loadExternalWebViewCallback;
        public SapiWebView.LoadSlideWebViewCallback loadSlideWebViewCallback;
        public SapiWebView.LocalConfigCallback localConfigCallback;
        public LoginStatusChangeCallback loginStatusChangeCallback;
        public SwitchStyleForCloseBtnAndStatusBarCallBack mSwitchStyleForCloseBtnAndStatusBarCallBack;
        public SyncAccountCallBack mSyncAccountCallBack;
        public MakeVibrateCallBack makeVibrateCallBack;
        public NormalizeGuestAccountCallback normalizeGuestAccountCallback;
        public String normalizeGuestAccountDesc;
        public SapiWebView.OnSlidePageFinishCallback onSlidePageFinishCallback;
        public PageStateCallback pageStateCallback;
        public SapiWebView.PickPhotoCallback pickPhotoCallback;
        public SapiWebView.PreFillUserNameCallback prefillUserNameCallback;
        public JsPromptResult promptResult;
        public SapiWebView.QrLoginCallback qrLoginCallback;
        public SapiWebView.QuickLoginHandler quickLoginHandler;
        public RealNameStatusCallback realNameStatusCallback;
        public SapiWebView.RealnameAuthenticateCallback realnameAuthenticateCallback;
        public SocialResponse rrLoginResponse;
        public SapiWebView.ShareAccountClickCallback shareAccountClickCallback;
        public ShareV2LoginParams shareV2LoginParams;
        public Handler socialLoginHandler;
        public Handler socialVerificationHandler;
        public SpeechRecognitionCallback speechRecognitionCallback;
        public StopSlideWebviewCallback stopSlideWebviewCallback;
        public SapiWebView.SwitchAccountCallback switchAccountCallback;
        public String[] touchidPortraitAndSign;
        public SapiWebView.UniteVerifyCallback uniteVerifyCallback;
        public SapiWebView.WebViewTitleCallback webViewTitleCallback;
        public WebviewPageFinishCallback webviewPageFinishCallback;
        public String weixinBindUrl;

        public CallBacks() {
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
            this.touchidPortraitAndSign = new String[2];
            this.leftBtnIsVisible = 1;
        }

        public JsPromptResult getPromptResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.promptResult;
            }
            return (JsPromptResult) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class DirectedLoginParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String displayname;
        public String encryptedId;
        public String uid;

        public DirectedLoginParams() {
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
    public static abstract class FingerprintCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void onCallback(FingerprintResult fingerprintResult);

        public FingerprintCallback() {
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
    public static abstract class FingerprintResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int authType;
        public String portrait;

        public abstract void setResult(int i);

        public FingerprintResult() {
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
    public static abstract class FocusEdittextCoordinateYCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void onCallback(int i);

        public FocusEdittextCoordinateYCallBack() {
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
    public static class JoinLoginParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;

        public JoinLoginParams() {
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
    public static abstract class ShareV2LoginParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();

        public ShareV2LoginParams() {
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
    public static abstract class SpeechRecognitionResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void setSpeechData(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public SpeechRecognitionResult() {
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

    public SapiJsCallBacks() {
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
