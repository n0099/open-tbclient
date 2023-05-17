package com.baidu.searchbox.account;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.account.address.BoxAddressBuildDTO;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.component.AccountLoginAgreeConfig;
import com.baidu.searchbox.account.component.AccountOperationConfig;
import com.baidu.searchbox.account.component.IAccountComponentCallback;
import com.baidu.searchbox.account.component.NicknamePortraitConfig;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.dto.BoxGetContactDTO;
import com.baidu.searchbox.account.dto.BoxSendSmsDTO;
import com.baidu.searchbox.account.invoicebuild.BoxInvoiceBuildCallback;
import com.baidu.searchbox.account.invoicebuild.BoxInvoiceBuildDTO;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.params.LogoutParams;
import com.baidu.searchbox.account.result.BoxOauthResult;
import com.baidu.searchbox.account.result.BoxOneKeyLoginResult;
import com.baidu.searchbox.account.result.BoxShareLoginResult;
import com.baidu.searchbox.account.view.IAccountSmsLoginView;
import com.baidu.searchbox.live.interfaces.DI;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface BoxAccountManager {
    public static final int ACCOUNT_DEFAULT_NICK_DEFAULT_PORTRAIT = 2;
    public static final int ACCOUNT_DEFAULT_NICK_REAL_PORTRAIT = 0;
    public static final int ACCOUNT_NICK_PORTRAIT_NO_LOGIN = -1;
    public static final int ACCOUNT_REAL_NICK_DEFAULT_PORTRAIT = 1;
    public static final int ACCOUNT_REAL_NICK_REAL_PORTRAIT = 3;
    public static final int BOX_GET_ACCOUNT_CACHE_MODE = 10;
    public static final int BOX_GET_ACCOUNT_FORCE_MODE = 12;
    public static final int BOX_GET_ACCOUNT_LAZY_MODE = 11;
    public static final long GET_SHARE_LOGIN_INFO_DEFAULT_TIMEOUT = 1500;
    public static final int NICKNAME_DIALOG_TYPE_DEFAULT = -1;
    public static final int NICKNAME_DIALOG_TYPE_DISTRIBUTE = 0;
    public static final int NICKNAME_DIALOG_TYPE_RECOMMEND = 1;
    public static final int NO_SUPPORT_GUEST_LOGIN = 2;
    public static final int QUICK_LOGIN_VIEW_FAV_HIS = 2;
    public static final int QUICK_LOGIN_VIEW_MENU = 1;
    public static final String SESSION_BDUSS = "BoxAccount_bduss";
    public static final String SESSION_DISPLAYNAME = "BoxAccount_displayname";
    public static final String SESSION_NICKNAME = "user_login_nickname_key";
    public static final String SESSION_PTOKEN = "BoxAccount_ptoken";
    public static final String SESSION_UID = "BoxAccount_uid";
    public static final int SUPPORT_GUEST_LOGIN = 0;
    public static final int TYPE_ACCOUNT_ACCOUNT_DETECT = 10;
    public static final int TYPE_ACCOUNT_APPEAL = 1;
    public static final int TYPE_ACCOUNT_AUTH_DETAIL = 4;
    public static final int TYPE_ACCOUNT_AUTH_WIDGET = 9;
    public static final int TYPE_ACCOUNT_CANCEL = 2;
    public static final int TYPE_ACCOUNT_MANAGE = 3;
    public static final int TYPE_ACCOUNT_MODIFY_PROFILE = 8;
    public static final int TYPE_ACCOUNT_REBIND_EMAIL = 6;
    public static final int TYPE_ACCOUNT_REBIND_MOBILE = 5;
    public static final int TYPE_ACCOUNT_TRUSTED_DEVICE = 7;
    public static final int TYPE_ACCOUNT_USER_NAME = 11;
    public static final HashMap<Integer, String> oneKeyErrors = new HashMap<>();
    public static final HashMap<Integer, String> webAuthErrors = new HashMap<>();
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(DI.ACCOUNT, "login");

    void addLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener);

    void bindPhone(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener);

    String buildBDUSSBFESSCookie(String str, String str2);

    String buildBDUSSCookie(String str, String str2);

    String buildPtokenCookie(String str, String str2);

    boolean canShowLoginComponent(String str);

    void checkBdussAndAlert(Activity activity, boolean z, String str, ICheckBdussAlertStatusCallback iCheckBdussAlertStatusCallback);

    void checkBdussAndAlert(Activity activity, boolean z, String str, ICheckBdussAlertStatusCallback iCheckBdussAlertStatusCallback, IAccountDialogContext iAccountDialogContext);

    void checkBind(IAccountQueryListener iAccountQueryListener);

    void checkUSerFaceId(Context context, ICheckUserFaceIdCallback iCheckUserFaceIdCallback);

    void combineLogin(Context context, LoginParams loginParams, int i, ILoginResultListener iLoginResultListener);

    void dismissNickNameGuideDialog();

    void dismissOperationView();

    void downloadLibMml(IDownloadLibMmlCallback iDownloadLibMmlCallback);

    void getAccessToken(String str, ISapiCallback<BoxOauthResult> iSapiCallback, boolean z);

    List<String> getAuthorizedDomains(Context context);

    List<String> getAuthorizedDomainsForPtoken(Context context);

    int getBdussState();

    BoxAccount getBoxAccount();

    BoxAccount getBoxAccount(int i, IGetBoxAccountListener iGetBoxAccountListener);

    @Nullable
    String getClientId(Context context);

    void getContacts(BoxGetContactDTO boxGetContactDTO, IGetContactsCallback iGetContactsCallback);

    void getFaceRecogBiometricInfo(Activity activity, int i, IAccountFaceRecogCallback iAccountFaceRecogCallback);

    int getHalfDialogUnLoginCount(String str);

    void getHistoryLoginInfo(IHistoryLoginCallback iHistoryLoginCallback);

    int getLastLoginType();

    BoxOneKeyLoginResult getLocalOneKeyInfo();

    void getLoginInfo(String str, boolean z, LoginInfoCallback loginInfoCallback);

    void getLoginInfo(boolean z, LoginInfoCallback loginInfoCallback);

    int getNickNamePortraitType();

    void getOneKeyLoginInfo(IOneKeyLoginCallback iOneKeyLoginCallback);

    void getOneKeyLoginInfo(boolean z, IOneKeyLoginCallback iOneKeyLoginCallback);

    void getOneKeyLoginToken(ITokenListener iTokenListener);

    void getOpenBduss(String str, List<String> list, IGetOpenBdussCallback iGetOpenBdussCallback);

    void getOperationView(Context context, AccountOperationConfig accountOperationConfig, IAccountComponentCallback iAccountComponentCallback);

    void getPersuadeView(Context context, AccountComponentConfig accountComponentConfig, IAccountComponentCallback iAccountComponentCallback);

    void getQuickLoginView(Context context, int i, AccountComponentConfig accountComponentConfig, IAccountComponentCallback iAccountComponentCallback);

    String getSession(String str);

    @Deprecated
    String getSession(String str, String str2);

    BoxShareLoginResult getShareLoginInfo();

    void getShareLoginInfo(IShareLoginInfoCallback iShareLoginInfoCallback, long j);

    void getTaskGuideView(Context context, int i, AccountComponentConfig accountComponentConfig, IAccountComponentCallback iAccountComponentCallback);

    void getTplStoken(IGetTplStokenCallback iGetTplStokenCallback, String str, List<String> list);

    void getUserCertInfo(IGetUserCertInfoListener iGetUserCertInfoListener);

    void getUserLevelInfo(IAccountQueryListener iAccountQueryListener);

    void hideLoginComponentDialog(Context context);

    boolean isGuestLogin();

    @Deprecated
    boolean isLogin();

    boolean isLogin(int i);

    boolean isShow(int i);

    void isShowSettingsRealNameGuide(@NonNull ISettingsRealNameGuidCallback iSettingsRealNameGuidCallback);

    boolean isWxAppInstalledAndSupported();

    void loadAccountPage(Context context, int i, String str, IAccountToolsCallback iAccountToolsCallback);

    void loadAccountPage(Context context, int i, String str, IAccountToolsCallback iAccountToolsCallback, IAuthWidgetCallback iAuthWidgetCallback, JSONObject jSONObject);

    void loadAccountRealName(Context context, String str, int i, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void loadAccountRealName(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void loadAccountRealNameForSwan(Context context, String str, int i, IVerifyUserFaceIDForSwanListener iVerifyUserFaceIDForSwanListener);

    void loadAddressManage(Context context, BoxAddressBuildDTO boxAddressBuildDTO);

    void loadBindWidget(String str, IWebBindWidgetCallback iWebBindWidgetCallback);

    void loadChildActivity(Context context, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void loadModifyPwd(IWebModifyPwdCallback iWebModifyPwdCallback);

    void loadSwitchAccountPage();

    @Deprecated
    void login(Context context, LoginParams loginParams);

    @Deprecated
    void login(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener);

    void loginStatusCheck(UserAccountActionItem userAccountActionItem);

    void logout(LogoutParams logoutParams);

    void modifyUserInfo(long j, BoxAccount boxAccount, IAccountRequestListener iAccountRequestListener);

    void modifyUserInfo(JSONObject jSONObject, IAccountRequestListener iAccountRequestListener);

    int nickGuideDialogShowStatus();

    int nickGuideDialogShowStatus(int i);

    void preGetPhoneInfo(Context context, String str, int i, boolean z, IOneKeyLoginOptCallback iOneKeyLoginOptCallback);

    void prefetchLocalOneKeyInfo();

    void release();

    void removeLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener);

    void selectAddress(Context context, boolean z, BoxAddressBuildDTO boxAddressBuildDTO, IAddressManageCallback iAddressManageCallback);

    void selectAddress(Context context, boolean z, boolean z2, BoxAddressBuildDTO boxAddressBuildDTO, IAddressManageCallback iAddressManageCallback);

    void sendContactsSms(BoxSendSmsDTO boxSendSmsDTO);

    void setThirdLoginSwitch(int i);

    boolean shouldShowFirstPopupDialog();

    void showFirstPopupDistributeDialog(Activity activity, String str, INickNamePortraitDialogCallback iNickNamePortraitDialogCallback);

    void showLoginAgreementDialog(Context context, AccountLoginAgreeConfig accountLoginAgreeConfig, ILoginAgreeDialogCallback iLoginAgreeDialogCallback);

    void showLoginComponentDialog(Context context, AccountComponentConfig accountComponentConfig, ILoginResultListener iLoginResultListener);

    boolean showLoginComponentWithCloudControl(Context context, AccountComponentConfig accountComponentConfig, ILoginResultListener iLoginResultListener, String str);

    void showNickNameGuideDialog(Activity activity, int i, String str, INickNameGuideDialogListener iNickNameGuideDialogListener);

    void showNickNameGuideDialog(Activity activity, String str);

    void showNickNameGuideDialog(Activity activity, String str, INickNameGuideDialogListener iNickNameGuideDialogListener);

    void showNickNameGuideDialogWithActivity(Activity activity, int i, String str, int i2);

    void showNickNameGuideDialogWithActivity(Activity activity, String str, int i);

    void showNicknamePortraitDialog(Activity activity, NicknamePortraitConfig nicknamePortraitConfig, INickNamePortraitDialogCallback iNickNamePortraitDialogCallback);

    void startAccountNickNameActivity(Activity activity, String str, String str2, int i);

    void startAccountUserInfoEditActivity(Activity activity, Bundle bundle, int i);

    @Deprecated
    IAccountSmsLoginView startBoxSmsLoginView(Context context, LoginParams loginParams, ISmsLoginViewListener iSmsLoginViewListener);

    IAccountSmsLoginView startBoxSmsLoginViewV2(Context context, LoginParams loginParams, ISmsLoginViewListener iSmsLoginViewListener);

    void startInvoiceManager(Context context, BoxInvoiceBuildDTO boxInvoiceBuildDTO);

    void startSelectInvoice(Context context, boolean z, BoxInvoiceBuildDTO boxInvoiceBuildDTO, BoxInvoiceBuildCallback boxInvoiceBuildCallback);

    void upLoadPortrait(int i, Bitmap bitmap, IUploadPortraitListener iUploadPortraitListener);

    void verifyUserFaceId(Activity activity, String str, String str2, String str3, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void verifyUserFaceId(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void web2NativeLogin(LoginParams loginParams, IWeb2NativeLoginCallback iWeb2NativeLoginCallback);
}
