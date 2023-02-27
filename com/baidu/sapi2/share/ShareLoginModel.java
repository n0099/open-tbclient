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
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareLoginModel {
    public static String AUTH_APP_PKG_NAME = "auth_app_pkg_name";
    public static String AUTH_PASS_SDK_VERSION = "auth_pass_sdk_version";
    public static String FACE_LOGIN_UIDS = "face_login_uids";
    public static final String INVALIDATE_BDUSS = "invalidate_bduss";
    public static final String INVALID_BDUSS_LIST = "invalid_bduss_list";
    public static final int MAX_LENGTH_INVALID_BDUSS_SET = 16;
    public static final int REQUEST_CODE_SHARE_V4 = 100004;
    public static String SHARE_ACCOUNT_INFO = "share_account_info";
    public static final String SHARE_LOGIN_ACTIVITY = "com.baidu.sapi2.share.ShareActivity";
    public static final String SHARE_LOGIN_CALL_TYPE = "share_login_call_type";
    public static final String SHARE_LOGIN_FROM_TPL = "share_login_from_tpl";
    public static final String TAG = "sapi_ShareLoginModel";
    public static ShareLoginModel instance;
    public LinkedList<String> invalidBdussList;

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

    public LinkedList<String> getInvalidBdussList() {
        if (this.invalidBdussList == null) {
            this.invalidBdussList = initInvalidStringList();
        }
        return this.invalidBdussList;
    }

    private LinkedList<String> initInvalidStringList() {
        LinkedList<String> linkedList = new LinkedList<>();
        String string = SapiContext.getInstance().getString(INVALID_BDUSS_LIST);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        linkedList.addLast(jSONArray.optString(i));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    public void checkAuthAccountValid(final HashMap<String, String> hashMap, final BdussStatusCallback bdussStatusCallback) {
        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        if (accountService != null && currentAccount != null && !TextUtils.isEmpty(currentAccount.bduss)) {
            accountService.getUserInfo(currentAccount.bduss, currentAccount.getPtoken(), new NetCallback() { // from class: com.baidu.sapi2.share.ShareLoginModel.1
                @Override // com.baidu.sapi2.callback.NetCallback
                public void onFailure(Throwable th, int i, String str) {
                    Log.e(ShareLoginModel.TAG, "checkAuthAccountValid onFailure code=" + i + ", content=" + str);
                    HashMap hashMap2 = hashMap;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(i);
                    hashMap2.put("code", sb.toString());
                    StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_FAIL, hashMap);
                    bdussStatusCallback.onResultAccount(null);
                }

                @Override // com.baidu.sapi2.callback.NetCallback
                public void onSuccess(int i, String str) {
                    JSONObject jSONObject;
                    Log.d(ShareLoginModel.TAG, "checkAuthAccountValid onSuccess code=" + i + ", content=" + str);
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (Exception e) {
                        Log.e(ShareLoginModel.TAG, e);
                        jSONObject = null;
                    }
                    int i2 = -100;
                    if (jSONObject != null) {
                        i2 = jSONObject.optInt("errno", -100);
                    }
                    if (i2 == 0) {
                        StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_VALID, hashMap);
                        bdussStatusCallback.onResultAccount(currentAccount);
                    } else if (400021 == i2) {
                        StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, hashMap);
                        bdussStatusCallback.onBdussInvalidate(currentAccount.bduss);
                    } else {
                        hashMap.put("code", "" + i);
                        StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, hashMap);
                        bdussStatusCallback.onResultAccount(null);
                    }
                }
            });
            return;
        }
        if (currentAccount != null && !TextUtils.isEmpty(currentAccount.bduss)) {
            if (accountService == null) {
                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_INIT_PASS_ERROR, hashMap);
            }
        } else {
            StatService.onEventAutoStat(ShareStatKey.AUTH_APP_READ_ACCOUNT_ERROR, hashMap);
        }
        bdussStatusCallback.onResultAccount(null);
    }

    public void getShareModels(long j, ShareModelWithCheckCallback shareModelWithCheckCallback) {
        if (j > 0) {
            if (shareModelWithCheckCallback == null) {
                return;
            }
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_V3_DEMOTION, "0");
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration == null) {
                Log.d(ShareUtils.TAG, "getShareModels config is null");
                shareModelWithCheckCallback.onFailure(-101, ShareStorage.MSG_PASS_HAS_NOT_INIT, ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
                return;
            } else if (!SapiUtils.isOnline(sapiConfiguration)) {
                Log.d(ShareUtils.TAG, "getShareModels environment is not online and is not config debugSupportShare");
                shareModelWithCheckCallback.onFailure(-102, ShareStorage.MSG_APP_IS_NOT_ONLINE, ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_DEBUG, "1");
                return;
            } else {
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_DEBUG, "0");
                if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
                    Log.d(ShareUtils.TAG, "getShareModels config loginShareStrategy is not DISABLED");
                    shareModelWithCheckCallback.onFailure(-103, ShareStorage.MSG_APP_SHARE_IS_DISABLED, ShareUtils.S_SHARE_MODEL_FROM_WITH_ERROR);
                    ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_ABLE, "0");
                    return;
                }
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_ABLE, "1");
                ShareUtils.getShareModels(j, sapiConfiguration.context, sapiConfiguration.tpl, shareModelWithCheckCallback);
                return;
            }
        }
        throw new IllegalArgumentException("must timeoutMills > 0");
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        int i = 0;
        Log.d(ShareUtils.TAG, "build version is " + Build.VERSION.SDK_INT);
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
        if (shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("shareModels", "" + shareStorageModel.size());
        StatService.onEventAutoStat(ShareStatKey.CHECK_SHARE_V2_LOGIN_AVAILABLE, hashMap);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (ShareStorage.StorageModel storageModel : shareStorageModel) {
            if (storageModel != null) {
                jSONArray.put(storageModel.tpl);
                jSONArray2.put(storageModel.app);
                i++;
            }
        }
        ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_APPS, jSONArray2);
        ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_TPLS, jSONArray);
        ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_SIZE, Integer.valueOf(i));
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
        try {
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
            if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                activity.startActivityForResult(intent, REQUEST_CODE_SHARE_V4);
            }
        } catch (Exception e) {
            Log.e("openV4ShareLogin", e.getMessage());
        }
    }

    public void processShareResult(Context context, Intent intent, ShareResultCallback shareResultCallback) {
        Bundle extras;
        if (shareResultCallback == null) {
            return;
        }
        if (intent != null && (extras = intent.getExtras()) != null) {
            updateInvalidBdussList(extras.getString(INVALIDATE_BDUSS));
            SapiAccount sapiAccount = (SapiAccount) extras.getParcelable(SHARE_ACCOUNT_INFO);
            if (sapiAccount == null) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_FAIL);
                shareResultCallback.onResultAccount(null);
                ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "0");
                ShareLoginStat.MakeShareLoginStat.statExtMap.put("errorMsg", ShareStatKey.SHARE_NEW_AUTH_LOGIN_FAIL);
                ShareLoginStat.MakeShareLoginStat.upload();
                return;
            }
            String stringExtra = intent.getStringExtra(AUTH_APP_PKG_NAME);
            String stringExtra2 = intent.getStringExtra(SHARE_LOGIN_FROM_TPL);
            ShareAccountAccessor.getAccessor().setAccountPkg(sapiAccount, stringExtra);
            intent.getStringExtra(AUTH_PASS_SDK_VERSION);
            SapiContext sapiContext = SapiContext.getInstance();
            sapiContext.setCurrentAccount(sapiAccount);
            sapiContext.addLoginAccount(sapiAccount);
            new ShareCallPacking().asyncMarkLoginState(2);
            sapiContext.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
            JSONObject jSONObject = new JSONObject();
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            try {
                jSONObject.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_TPL, stringExtra2);
                jSONObject.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_PKG, stringExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SapiAccountManager.getInstance().getUserInfoAndRefershAccount(sapiAccount, Enums.LastLoginType.CHOICE_SHARE_V2.getValue(), jSONObject.toString());
            if (sapiContext.shareLivingunameEnable()) {
                ArrayList arrayList = new ArrayList();
                String stringExtra3 = intent.getStringExtra(FACE_LOGIN_UIDS);
                if (!TextUtils.isEmpty(stringExtra3)) {
                    arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra3));
                }
                if (!arrayList.isEmpty()) {
                    new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                }
            }
            StatService.onEventAutoStat(ShareStatKey.SHARE_NEW_AUTH_LOGIN_SUCCESS);
            shareResultCallback.onResultAccount(sapiAccount);
            ShareLoginStat.MakeShareLoginStat.statExtMap.put("errorMsg", ShareStatKey.SHARE_NEW_AUTH_LOGIN_SUCCESS);
            ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "1");
            ShareLoginStat.MakeShareLoginStat.upload();
            return;
        }
        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "0");
        ShareLoginStat.MakeShareLoginStat.statExtMap.put("errorMsg", ShareStatKey.SHARE_NEW_AUTH_LOGIN_FAIL);
        shareResultCallback.onResultAccount(null);
    }

    public void updateInvalidBdussList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.invalidBdussList == null) {
            this.invalidBdussList = initInvalidStringList();
        }
        int size = this.invalidBdussList.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (TextUtils.equals(this.invalidBdussList.get(i), str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            this.invalidBdussList.addFirst(str);
        }
        while (this.invalidBdussList.size() > 16) {
            this.invalidBdussList.removeLast();
        }
        SapiContext.getInstance().put(INVALID_BDUSS_LIST, new JSONArray((Collection) this.invalidBdussList).toString());
    }
}
