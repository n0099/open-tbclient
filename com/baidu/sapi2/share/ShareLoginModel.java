package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList invalidBdussList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1545769534, "Lcom/baidu/sapi2/share/ShareLoginModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1545769534, "Lcom/baidu/sapi2/share/ShareLoginModel;");
        }
    }

    public ShareLoginModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ShareLoginModel getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                synchronized (ShareLoginModel.class) {
                    if (instance == null) {
                        instance = new ShareLoginModel();
                    }
                }
            }
            return instance;
        }
        return (ShareLoginModel) invokeV.objValue;
    }

    public LinkedList getInvalidBdussList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.invalidBdussList == null) {
                this.invalidBdussList = initInvalidStringList();
            }
            return this.invalidBdussList;
        }
        return (LinkedList) invokeV.objValue;
    }

    private LinkedList initInvalidStringList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            LinkedList linkedList = new LinkedList();
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
        return (LinkedList) invokeV.objValue;
    }

    public void checkAuthAccountValid(HashMap hashMap, BdussStatusCallback bdussStatusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, bdussStatusCallback) == null) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            if (accountService != null && currentAccount != null && !TextUtils.isEmpty(currentAccount.bduss)) {
                accountService.getUserInfo(currentAccount.bduss, currentAccount.getPtoken(), new NetCallback(this, hashMap, bdussStatusCallback, currentAccount) { // from class: com.baidu.sapi2.share.ShareLoginModel.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShareLoginModel this$0;
                    public final /* synthetic */ SapiAccount val$account;
                    public final /* synthetic */ BdussStatusCallback val$callback;
                    public final /* synthetic */ HashMap val$statParams;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, hashMap, bdussStatusCallback, currentAccount};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$statParams = hashMap;
                        this.val$callback = bdussStatusCallback;
                        this.val$account = currentAccount;
                    }

                    @Override // com.baidu.sapi2.callback.NetCallback
                    public void onFailure(Throwable th, int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str) == null) {
                            Log.e(ShareLoginModel.TAG, "checkAuthAccountValid onFailure code=" + i + ", content=" + str);
                            HashMap hashMap2 = this.val$statParams;
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append(i);
                            hashMap2.put("code", sb.toString());
                            StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_FAIL, this.val$statParams);
                            this.val$callback.onResultAccount(null);
                        }
                    }

                    @Override // com.baidu.sapi2.callback.NetCallback
                    public void onSuccess(int i, String str) {
                        JSONObject jSONObject;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
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
                                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_VALID, this.val$statParams);
                                this.val$callback.onResultAccount(this.val$account);
                            } else if (400021 == i2) {
                                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, this.val$statParams);
                                this.val$callback.onBdussInvalidate(this.val$account.bduss);
                            } else {
                                this.val$statParams.put("code", "" + i);
                                StatService.onEventAutoStat(ShareStatKey.AUTH_APP_LOGIN_STATUS_INVALID, this.val$statParams);
                                this.val$callback.onResultAccount(null);
                            }
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
    }

    public void getShareModels(long j, ShareModelWithCheckCallback shareModelWithCheckCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, shareModelWithCheckCallback) == null) {
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
    }

    public List getV2ShareModelList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public boolean isMeetShareV4(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            Intent intent = new Intent();
            intent.setClassName(str, SHARE_LOGIN_ACTIVITY);
            if (context.getPackageManager().resolveActivity(intent, 131072) != null) {
                return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V4).isMeetGray();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void openV4ShareLogin(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, str2) == null) {
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
            activity.startActivityForResult(intent, REQUEST_CODE_SHARE_V4);
        }
    }

    public void processShareResult(Context context, Intent intent, ShareResultCallback shareResultCallback) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, context, intent, shareResultCallback) != null) || shareResultCallback == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || TextUtils.isEmpty(str)) {
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
            } else if (TextUtils.equals((String) this.invalidBdussList.get(i), str)) {
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
