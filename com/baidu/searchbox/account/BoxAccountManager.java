package com.baidu.searchbox.account;

import android.app.Activity;
import android.content.Context;
import com.baidu.pyramid.runtime.service.d;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.params.LogoutParams;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public interface BoxAccountManager {
    public static final int BOX_GET_ACCOUNT_CACHE_MODE = 10;
    public static final int BOX_GET_ACCOUNT_FORCE_MODE = 12;
    public static final int BOX_GET_ACCOUNT_LAZY_MODE = 11;
    public static final int NO_SUPPORT_GUEST_LOGIN = 2;
    public static final d SERVICE_REFERENCE = new d("account", "login");
    public static final String SESSION_BDUSS = "BoxAccount_bduss";
    public static final String SESSION_DISPLAYNAME = "BoxAccount_displayname";
    public static final String SESSION_NICKNAME = "user_login_nickname_key";
    public static final String SESSION_PTOKEN = "BoxAccount_ptoken";
    public static final String SESSION_UID = "BoxAccount_uid";
    public static final int SUPPORT_GUEST_LOGIN = 0;

    void addLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener);

    void bindPhone(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener);

    String buildBDUSSCookie(String str, String str2);

    String buildPtokenCookie(String str, String str2);

    void checkBdussAndAlert(Activity activity, boolean z, String str, ICheckBdussAlertStatusCallback iCheckBdussAlertStatusCallback);

    void checkBdussAndAlert(Activity activity, boolean z, String str, ILoginResultListener iLoginResultListener);

    void combineLogin(Context context, LoginParams loginParams, int i, ILoginResultListener iLoginResultListener);

    List<String> getAuthorizedDomains(Context context);

    List<String> getAuthorizedDomainsForPtoken(Context context);

    BoxAccount getBoxAccount();

    @Deprecated
    BoxAccount getBoxAccount(int i, IGetBoxAccountListener iGetBoxAccountListener);

    @Deprecated
    String getSession(String str);

    @Deprecated
    String getSession(String str, String str2);

    void getTplStoken(IGetTplStokenCallback iGetTplStokenCallback, String str, List<String> list);

    boolean isGuestLogin();

    @Deprecated
    boolean isLogin();

    boolean isLogin(int i);

    boolean isShow(int i);

    boolean isWxAppInstalledAndSupported();

    void loadAccountRealName(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);

    void loadAddressManage(Context context, String str);

    void loadModifyPwd(IWebModifyPwdCallback iWebModifyPwdCallback);

    @Deprecated
    void login(Context context, LoginParams loginParams);

    @Deprecated
    void login(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener);

    void loginStatusCheck(UserAccountActionItem userAccountActionItem);

    void logout(LogoutParams logoutParams);

    void modifyUserInfo(long j, BoxAccount boxAccount, IAccountRequestListener iAccountRequestListener);

    void modifyUserInfo(JSONObject jSONObject, IAccountRequestListener iAccountRequestListener);

    void release();

    void removeLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener);

    void selectAddress(Context context, boolean z, String str, IAddressManageCallback iAddressManageCallback);

    void setThirdLoginSwitch(int i);

    void showNickNameGuideDialog(Activity activity, String str);

    void startAccountNickNameActivity(Activity activity, String str, String str2, int i);

    void verifyUserFaceId(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener);
}
