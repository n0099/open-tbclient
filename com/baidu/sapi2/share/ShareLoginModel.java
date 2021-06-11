package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ShareAccountAccessor;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareLoginModel {
    public static String AUTH_APP_PKG_NAME = "auth_app_pkg_name";
    public static String AUTH_PASS_SDK_VERSION = "auth_pass_sdk_version";
    public static String FACE_LOGIN_UIDS = "face_login_uids";
    public static final int REQUEST_CODE_SHARE_V4 = 100004;
    public static String SHARE_ACCOUNT_INFO = "share_account_info";
    public static final String SHARE_LOGIN_ACTIVITY = "com.baidu.sapi2.share.ShareActivity";
    public static final String SHARE_LOGIN_CALL_TYPE = "share_login_call_type";
    public static final String SHARE_LOGIN_FROM_TPL = "share_login_from_tpl";
    public static final String TAG = "sapi_ShareLoginModel";
    public static ShareLoginModel instance;

    public static ShareLoginModel getInstance() {
        if (instance == null) {
            synchronized (ShareLoginModel.class) {
                if (instance == null) {
                    instance = new ShareLoginModel();
                }
            }
        }
        return instance;
    }

    public void checkAuthAccountValid(final HashMap<String, String> hashMap, final ShareResultCallback shareResultCallback) {
        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        if (accountService != null && currentAccount != null && !TextUtils.isEmpty(currentAccount.bduss)) {
            accountService.getUserInfo(currentAccount.bduss, currentAccount.getPtoken(), new NetCallback() { // from class: com.baidu.sapi2.share.ShareLoginModel.1
                @Override // com.baidu.sapi2.callback.NetCallback
                public void onFailure(Throwable th, int i2, String str) {
                    Log.e(ShareLoginModel.TAG, "checkAuthAccountValid onFailure code=" + i2 + ", content=" + str);
                    HashMap hashMap2 = hashMap;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(i2);
                    hashMap2.put("code", sb.toString());
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_FAIL, hashMap);
                    shareResultCallback.onResultAccount(null);
                }

                @Override // com.baidu.sapi2.callback.NetCallback
                public void onSuccess(int i2, String str) {
                    JSONObject jSONObject;
                    Log.d(ShareLoginModel.TAG, "checkAuthAccountValid onSuccess code=" + i2 + ", content=" + str);
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (Exception e2) {
                        Log.e(ShareLoginModel.TAG, e2);
                        jSONObject = null;
                    }
                    if (jSONObject != null && jSONObject.optInt("errno", -100) == 0) {
                        StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_VALID, hashMap);
                        shareResultCallback.onResultAccount(currentAccount);
                        return;
                    }
                    hashMap.put("code", "" + i2);
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, hashMap);
                    shareResultCallback.onResultAccount(null);
                }
            });
            return;
        }
        if (currentAccount == null || TextUtils.isEmpty(currentAccount.bduss)) {
            StatService.onEventAutoStat(ShareStatKey.AUTH_APP_READ_ACCOUNT_ERROR, hashMap);
        } else if (accountService == null) {
            StatService.onEventAutoStat(ShareStatKey.AUTH_APP_INIT_PASS_ERROR, hashMap);
        }
        shareResultCallback.onResultAccount(null);
    }

    public void getShareModels(long j, ShareModelCallback shareModelCallback) {
        if (j <= 0) {
            throw new IllegalArgumentException("must timeoutMills > 0");
        }
        if (shareModelCallback == null) {
            return;
        }
        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_V3_EXTERNAL_RECOVERY).isMeetGray()) {
            shareModelCallback.onReceiveShareModels(getV2ShareModelList(null));
            return;
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration == null) {
            Log.d(ShareUtils.TAG, "getShareModels config is null");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (!SapiUtils.isOnline(sapiConfiguration.context)) {
            Log.d(ShareUtils.TAG, "getShareModels environment is not online");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(ShareUtils.TAG, "getShareModels config loginShareStrategy is not DISABLED");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else {
            ShareUtils.getShareModels(j, sapiConfiguration.context, sapiConfiguration.tpl, shareModelCallback);
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        Log.d(ShareUtils.TAG, "build version is " + Build.VERSION.SDK_INT);
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
        if (shareStorageModel != null && shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(shareStorageModel != null ? shareStorageModel.size() : 0);
        hashMap.put("shareModels", sb.toString());
        StatService.onEventAutoStat(ShareStatKey.CHECK_SHARE_V2_LOGIN_AVAILABLE, hashMap);
        return shareStorageModel;
    }

    public boolean isMeetShareV4(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(str, SHARE_LOGIN_ACTIVITY);
        if (context.getPackageManager().resolveActivity(intent, 131072) != null) {
            return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V4).isMeetGray();
        }
        return false;
    }

    public void openV4ShareLogin(Activity activity, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str2);
        StatService.onEventAutoStat(ShareStatKey.SHARE_INVOKE_NEW_SHARE_AUTH, hashMap);
        ComponentName componentName = new ComponentName(str, SHARE_LOGIN_ACTIVITY);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        String tpl = SapiAccountManager.getInstance().getTpl();
        if (TextUtils.isEmpty(tpl)) {
            tpl = "unknown";
        }
        intent.putExtra(SHARE_LOGIN_FROM_TPL, tpl);
        intent.putExtra(SHARE_LOGIN_CALL_TYPE, str2);
        activity.startActivityForResult(intent, 100004);
    }

    public void processShareResult(Context context, Intent intent, ShareResultCallback shareResultCallback) {
        Bundle extras;
        if (shareResultCallback == null || intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        SapiAccount sapiAccount = (SapiAccount) extras.getParcelable(SHARE_ACCOUNT_INFO);
        if (sapiAccount == null) {
            StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_FAIL);
            shareResultCallback.onResultAccount(null);
            return;
        }
        ShareAccountAccessor.getAccessor().setAccountPkg(sapiAccount, intent.getStringExtra(AUTH_APP_PKG_NAME));
        intent.getStringExtra(AUTH_PASS_SDK_VERSION);
        SapiContext sapiContext = SapiContext.getInstance();
        sapiContext.setCurrentAccount(sapiAccount);
        sapiContext.addLoginAccount(sapiAccount);
        new ShareCallPacking().asyncMarkLoginState(2);
        sapiContext.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
        if (sapiContext.shareLivingunameEnable()) {
            ArrayList arrayList = new ArrayList();
            String stringExtra = intent.getStringExtra(FACE_LOGIN_UIDS);
            if (!TextUtils.isEmpty(stringExtra)) {
                arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra));
            }
            if (!arrayList.isEmpty()) {
                new FaceLoginService().syncFaceLoginUidList(context, arrayList);
            }
        }
        StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_SUCCESS);
        shareResultCallback.onResultAccount(sapiAccount);
    }
}
