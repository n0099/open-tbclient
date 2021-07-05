package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ShareAccountAccessor;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public final class ShareUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_SHARE_ACTIVITY = "baidu.intent.action.account.SHARE_ACTIVITY";
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_SDK_VERSION = "SDK_VERSION";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String SHARE_ACCOUNT = "share_account";
    public static final String SHARE_ACCOUNT_CLOUND_VERSION = "shareV3";
    public static final String SHARE_ACCOUNT_NEW_VERSION = "shareV2";
    public static final String SHARE_FAIL_CODE = "share_fail_code";
    public static final String SHARE_FAIL_REASON = "share_fail_reason";
    public static final String TAG = "pass_share_login";
    public static boolean isRequestShareFromCloudTimeOut;
    public static List<ShareStorage.StorageModel> shareModelsMemoryCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1587415175, "Lcom/baidu/sapi2/share/ShareUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1587415175, "Lcom/baidu/sapi2/share/ShareUtils;");
        }
    }

    public ShareUtils() {
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

    public static List<ShareStorage.StorageModel> buildExpiredShareModels(List<ShareStorage.StorageModel> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            if (list == null) {
                return new ArrayList(0);
            }
            LinkedList<String> invalidBdussList = ShareLoginModel.getInstance().getInvalidBdussList();
            int size = invalidBdussList == null ? 0 : invalidBdussList.size();
            Iterator<ShareStorage.StorageModel> it = list.iterator();
            while (it.hasNext()) {
                ShareStorage.StorageModel next = it.next();
                if (next != null && !TextUtils.isEmpty(next.bduss)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (TextUtils.equals(invalidBdussList.get(i2), next.bduss)) {
                            it.remove();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static void cacheShareModels(List<ShareStorage.StorageModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, list) == null) {
            shareModelsMemoryCache = list;
        }
    }

    public static void callbackShareModels(ShareModelCallback shareModelCallback, List<ShareStorage.StorageModel> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, shareModelCallback, list) == null) || shareModelCallback == null) {
            return;
        }
        shareModelCallback.onReceiveShareModels(buildExpiredShareModels(list));
    }

    public static boolean checkCalleeIdentity(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
                String packageSign = SapiUtils.getPackageSign(context, str);
                if (!TextUtils.isEmpty(packageSign)) {
                    for (String str2 : authorizedPackages.keySet()) {
                        if (str.matches(str2) && packageSign.equals(authorizedPackages.get(str2))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<ShareStorage.StorageModel> checkShareAppInstalled(List<ShareStorage.StorageModel> list, List<String> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, list, list2)) == null) {
            if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
                return null;
            }
            Iterator<ShareStorage.StorageModel> it = list.iterator();
            while (it.hasNext()) {
                ShareStorage.StorageModel next = it.next();
                boolean z = false;
                Iterator<String> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (TextUtils.equals(it2.next(), next.pkg)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                return null;
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    public static String[] getDeletedShareModels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_DELETE_LIST);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split(",");
        }
        return (String[]) invokeV.objValue;
    }

    public static List<String> getInstalledApps(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            List<Intent> queryShareActivitys = queryShareActivitys(context);
            if (queryShareActivitys == null || queryShareActivitys.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Intent intent : queryShareActivitys) {
                arrayList.add(intent.getComponent().getPackageName());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void getShareModels(long j, Context context, String str, ShareModelCallback shareModelCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Long.valueOf(j), context, str, shareModelCallback}) == null) {
            List<String> installedApps = getInstalledApps(context);
            if (installedApps != null && installedApps.size() > 0) {
                List<ShareStorage.StorageModel> shareModelsFromQuickCache = getShareModelsFromQuickCache(installedApps);
                if (shareModelsFromQuickCache != null && shareModelsFromQuickCache.size() > 0) {
                    callbackShareModels(shareModelCallback, shareModelsFromQuickCache);
                    return;
                }
                List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage(installedApps);
                if (shareModelsFromShareStorage != null && shareModelsFromShareStorage.size() > 0) {
                    cacheShareModels(shareModelsFromShareStorage);
                    callbackShareModels(shareModelCallback, shareModelsFromShareStorage);
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_INIT_SP);
                    return;
                }
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                List<ShareStorage.StorageModel> shareModelsFromSP = getShareModelsFromSP(ordinal, installedApps);
                if (shareModelsFromSP != null && shareModelsFromSP.size() > 0) {
                    cacheShareModels(shareModelsFromSP);
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SP);
                    callbackShareModels(shareModelCallback, shareModelsFromSP);
                    return;
                }
                if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
                    List<ShareStorage.StorageModel> shareModelsFromSdCard = getShareModelsFromSdCard(ordinal, installedApps);
                    if (shareModelsFromSdCard != null && shareModelsFromSdCard.size() > 0) {
                        cacheShareModels(shareModelsFromSdCard);
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SDCARD);
                        callbackShareModels(shareModelCallback, shareModelsFromSdCard);
                        return;
                    }
                } else {
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_NO_SDCARD_PERM);
                }
                Handler handler = new Handler(Looper.getMainLooper(), shareModelCallback) { // from class: com.baidu.sapi2.share.ShareUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShareModelCallback val$callback;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, shareModelCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = shareModelCallback;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = true;
                            ShareUtils.callbackShareModels(this.val$callback, new ArrayList(0));
                        }
                    }
                };
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(0, j);
                getShareV3App(context, str, installedApps, new GetShareV3AppCallback(handler, shareModelCallback) { // from class: com.baidu.sapi2.share.ShareUtils.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShareModelCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {handler, shareModelCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$handler = handler;
                        this.val$callback = shareModelCallback;
                    }

                    @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                    public void onFailure() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$handler.removeCallbacksAndMessages(null);
                            HashMap hashMap = new HashMap();
                            hashMap.put("timeout", ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                            hashMap.put("status", "0");
                            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                            if (ShareUtils.isRequestShareFromCloudTimeOut) {
                                boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                            } else {
                                this.val$handler.post(new Runnable(this) { // from class: com.baidu.sapi2.share.ShareUtils.3.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            ShareUtils.callbackShareModels(this.this$0.val$callback, new ArrayList(0));
                                        }
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                    public void onSuccess(List<ShareStorage.StorageModel> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                            this.val$handler.removeCallbacksAndMessages(null);
                            ShareUtils.cacheShareModels(list);
                            HashMap hashMap = new HashMap();
                            hashMap.put("timeout", ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                            hashMap.put("status", "1");
                            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                            if (ShareUtils.isRequestShareFromCloudTimeOut) {
                                boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                            } else {
                                this.val$handler.post(new Runnable(this, list) { // from class: com.baidu.sapi2.share.ShareUtils.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$0;
                                    public final /* synthetic */ List val$shareModels;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, list};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$shareModels = list;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            ShareUtils.callbackShareModels(this.this$0.val$callback, this.val$shareModels);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
                return;
            }
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_BUT_NONE_APP);
            callbackShareModels(shareModelCallback, new ArrayList(0));
        }
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromQuickCache(List<String> list) {
        InterceptResult invokeL;
        List<ShareStorage.StorageModel> checkShareAppInstalled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_CACHE_ABILITY).isMeetGray() && (checkShareAppInstalled = checkShareAppInstalled(shareModelsMemoryCache, list)) != null && checkShareAppInstalled.size() > 0) {
                Log.d(TAG, "get share model from modelsFromMemoryCache, size=" + checkShareAppInstalled.size());
                StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_MEMORY_CACHE);
                return checkShareAppInstalled;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromSP(int i2, List<String> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            ShareStorage shareStorage = new ShareStorage();
            for (String str : list) {
                ShareStorage.StorageModel modelFromSp = shareStorage.getModelFromSp(str);
                if (modelFromSp != null && !TextUtils.isEmpty(modelFromSp.displayname) && !TextUtils.isEmpty(modelFromSp.url) && i2 == modelFromSp.env) {
                    arrayList.add(modelFromSp);
                }
            }
            return arrayList;
        }
        return (List) invokeIL.objValue;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromSdCard(int i2, List<String> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i2, list)) == null) {
            ArrayList arrayList = new ArrayList();
            ShareStorage shareStorage = new ShareStorage();
            for (String str : list) {
                ShareStorage.StorageModel modelFromSd = shareStorage.getModelFromSd(str);
                if (modelFromSd != null && !TextUtils.isEmpty(modelFromSd.displayname) && !TextUtils.isEmpty(modelFromSd.url) && i2 == modelFromSd.env) {
                    arrayList.add(modelFromSd);
                }
            }
            return arrayList;
        }
        return (List) invokeIL.objValue;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromShareStorage(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, list)) == null) {
            String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_STORAGE);
            if (!TextUtils.isEmpty(string)) {
                String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(string, SapiContext.getInstance().getAccountEncryptKey());
                if (!TextUtils.isEmpty(decryptAccountInfo)) {
                    JSONArray jSONArray = null;
                    try {
                        jSONArray = new JSONArray(decryptAccountInfo);
                    } catch (Exception e2) {
                        Log.e(TAG, e2.getMessage());
                    }
                    return checkShareAppInstalled(ShareStorage.StorageModel.fromJSONArray(jSONArray), list);
                }
            }
            Log.e(TAG, "getShareStorage result is null");
            return new ArrayList(0);
        }
        return (List) invokeL.objValue;
    }

    public static List<ShareStorage.StorageModel> getShareStorageModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                List<String> installedApps = getInstalledApps(sapiConfiguration.context);
                if (installedApps != null && installedApps.size() != 0) {
                    List<ShareStorage.StorageModel> buildExpiredShareModels = buildExpiredShareModels(getShareModelsFromShareStorage(installedApps));
                    String[] deletedShareModels = getDeletedShareModels();
                    if (buildExpiredShareModels != null && buildExpiredShareModels.size() > 0 && deletedShareModels != null && deletedShareModels.length > 0) {
                        Log.d(TAG, "shareModels has value, deleteModels has value");
                        Iterator<ShareStorage.StorageModel> it = buildExpiredShareModels.iterator();
                        while (it.hasNext()) {
                            ShareStorage.StorageModel next = it.next();
                            for (String str : deletedShareModels) {
                                if (!TextUtils.isEmpty(next.url) && next.url.contains(str)) {
                                    try {
                                        it.remove();
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                    return buildExpiredShareModels;
                }
                return new ArrayList(0);
            }
            Log.d(TAG, "config initialShareStrategy is DISABLED");
            return new ArrayList(0);
        }
        return (List) invokeV.objValue;
    }

    public static void getShareV3App(Context context, String str, List<String> list, GetShareV3AppCallback getShareV3AppCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, context, str, list, getShareV3AppCallback) == null) {
            if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_MODEL_FROM_SERVER).isMeetGray()) {
                SapiAccountManager.getInstance().getAccountService().getShareV3App(str, list, context.getPackageName(), new GetShareV3AppCallback(getShareV3AppCallback) { // from class: com.baidu.sapi2.share.ShareUtils.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GetShareV3AppCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {getShareV3AppCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = getShareV3AppCallback;
                    }

                    @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                    public void onFailure() {
                        GetShareV3AppCallback getShareV3AppCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (getShareV3AppCallback2 = this.val$callback) == null) {
                            return;
                        }
                        getShareV3AppCallback2.onFailure();
                    }

                    @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                    public void onSuccess(List<ShareStorage.StorageModel> list2) {
                        GetShareV3AppCallback getShareV3AppCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list2) == null) || (getShareV3AppCallback2 = this.val$callback) == null) {
                            return;
                        }
                        getShareV3AppCallback2.onSuccess(list2);
                    }
                });
            } else if (getShareV3AppCallback != null) {
                getShareV3AppCallback.onFailure();
            }
        }
    }

    public static boolean isInV2ShareDisableWhiteList(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, sapiConfiguration)) == null) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("com.baidu.searchbox(.*)");
            for (String str : arrayList) {
                if (sapiConfiguration.context.getPackageName().matches(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void markAsDeleteShareLogin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            String[] deletedShareModels = getDeletedShareModels();
            StringBuilder sb = new StringBuilder();
            for (int length = deletedShareModels.length + 1 > 10 ? (deletedShareModels.length + 1) - 10 : 0; length < deletedShareModels.length; length++) {
                sb.append(deletedShareModels[length]);
                sb.append(",");
            }
            sb.append(str);
            SapiContext.getInstance().put(SapiContext.KEY_SHARE_DELETE_LIST, sb.toString());
        }
    }

    public static void onLoginActivityActivityResult(ShareCallPacking.ShareLoginCallBack shareLoginCallBack, int i2, int i3, Intent intent, ShareCallPacking shareCallPacking, List<PassNameValuePair> list, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{shareLoginCallBack, Integer.valueOf(i2), Integer.valueOf(i3), intent, shareCallPacking, list, str}) == null) && i2 == 20001) {
            if (shareLoginCallBack != null) {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                String str10 = "";
                if (intent != null) {
                    str2 = intent.getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
                    ShareLoginModel.getInstance().updateInvalidBdussList(intent.getStringExtra(ShareLoginModel.INVALIDATE_BDUSS));
                } else {
                    str2 = "";
                }
                char c2 = 2;
                if (i3 == -1 && intent != null) {
                    SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra("share_account");
                    if (sapiAccount != null) {
                        sapiAccount.fromType = FromType.LOGIN.getValue();
                        if (intent.getIntExtra("SDK_VERSION", 0) >= 190) {
                            ShareAccountAccessor.getAccessor().setAccountPkg(sapiAccount, intent.getStringExtra("PKG"));
                        } else {
                            sapiAccount.app = "";
                        }
                        str9 = sapiAccount.uid;
                        SapiContext sapiContext = SapiContext.getInstance();
                        sapiContext.setCurrentAccount(sapiAccount);
                        sapiContext.addLoginAccount(sapiAccount);
                        shareCallPacking.asyncMarkLoginState(2);
                        sapiContext.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
                        if (sapiContext.shareLivingunameEnable()) {
                            ArrayList arrayList = new ArrayList();
                            String stringExtra = intent.getStringExtra("V2_FACE_LOGIN_UIDS_TIMES");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra));
                            }
                            if (!arrayList.isEmpty()) {
                                new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                            }
                        }
                        sapiContext.put(SapiContext.KEY_PRE_LOGIN_TYPE, ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
                        shareLoginCallBack.onSuccess();
                        str8 = "";
                        c2 = 0;
                    } else {
                        Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                        shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                        str8 = ShareResult.ERROR_MSG_ACCOUNT_NULL;
                        str9 = "";
                        c2 = 1;
                        str10 = "-3007";
                    }
                    str5 = str8;
                    str7 = str10;
                    str6 = str9;
                } else {
                    if (intent != null) {
                        str4 = intent.getStringExtra("share_fail_code");
                        String stringExtra2 = intent.getStringExtra("share_fail_reason");
                        Toast.makeText(context, stringExtra2, 0).show();
                        str3 = stringExtra2;
                    } else {
                        str3 = "result data is null";
                        str4 = "";
                    }
                    shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                    str5 = str3;
                    str6 = "";
                    str7 = str4;
                }
                if (SHARE_ACCOUNT_CLOUND_VERSION.equals(str2)) {
                    if (c2 == 0) {
                        SapiStatUtil.statInvokeCloudShareAccount(4);
                        return;
                    } else {
                        SapiStatUtil.statInvokeCloudShareAccount(5);
                        return;
                    }
                } else if (c2 == 0) {
                    SapiStatUtil.statShareV2Success(ShareCallPacking.statModel, str6, list, str);
                    return;
                } else {
                    SapiStatUtil.statShareV2Fail(ShareCallPacking.statModel, str7, str5, str6, list, str);
                    return;
                }
            }
            throw new IllegalArgumentException("and shareLoginCallBack can't be null");
        }
    }

    public static List<Intent> queryShareActivitys(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? queryShareIntent(context, context.getPackageManager().queryIntentActivities(new Intent(ACTION_SHARE_ACTIVITY), 32), ACTION_SHARE_ACTIVITY) : (List) invokeL.objValue;
    }

    public static List<Intent> queryShareIntent(Context context, List<ResolveInfo> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, context, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context != null && list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance().getOrderAuthorizedPackages();
                try {
                    for (ResolveInfo resolveInfo : list) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo != null) {
                            Intent intent = new Intent(str);
                            intent.setClassName(((ComponentInfo) activityInfo).packageName, ((ComponentInfo) activityInfo).name);
                            if (Build.VERSION.SDK_INT > 11) {
                                intent.addFlags(32);
                            }
                            String str2 = resolveInfo.activityInfo.permission;
                            if (TextUtils.isEmpty(str2) || context.checkCallingOrSelfPermission(str2) == 0) {
                                if (checkCalleeIdentity(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                                    int i2 = Integer.MAX_VALUE;
                                    for (String str3 : orderAuthorizedPackages.keySet()) {
                                        if (intent.getComponent().getPackageName().matches(str3)) {
                                            i2 = orderAuthorizedPackages.get(str3).intValue();
                                        }
                                    }
                                    hashMap.put(intent, Integer.valueOf(i2));
                                }
                            }
                        }
                    }
                    ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
                    Collections.sort(arrayList2, new Comparator<Map.Entry<Intent, Integer>>() { // from class: com.baidu.sapi2.share.ShareUtils.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry, entry2)) == null) ? entry.getValue().compareTo(entry2.getValue()) : invokeLL.intValue;
                        }
                    });
                    for (Map.Entry entry : arrayList2) {
                        arrayList.add(entry.getKey());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static void setShareStorageModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            Context context = confignation.context;
            if (SapiUtils.isOnline(context) && confignation.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                ArrayList arrayList = new ArrayList();
                List<Intent> queryShareActivitys = queryShareActivitys(context);
                if (queryShareActivitys.size() == 0) {
                    SapiContext.getInstance().setShareStorage(null);
                    return;
                }
                ShareStorage shareStorage = new ShareStorage();
                HashSet hashSet = new HashSet();
                for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                    hashSet.add(sapiAccount.displayname);
                }
                int size = queryShareActivitys.size();
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                int i2 = 1;
                Log.d(TAG, "current login env is " + ordinal);
                StringBuilder sb = new StringBuilder();
                if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
                    StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_NOT_STORAGE_PERM);
                }
                int i3 = size;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                for (Intent intent : queryShareActivitys) {
                    String packageName = intent.getComponent().getPackageName();
                    sb.append(packageName);
                    sb.append(",");
                    ShareStorage.StorageModel storageModel = shareStorage.get(packageName);
                    if (storageModel == null) {
                        i4++;
                    } else {
                        Object[] objArr = new Object[i2];
                        objArr[0] = packageName + " env=" + storageModel.env + " flag=" + storageModel.flag + " displayName=" + storageModel.displayname;
                        Log.d(TAG, objArr);
                        if (storageModel.env != ordinal) {
                            i3--;
                        } else {
                            int i7 = storageModel.where;
                            if (i7 == 0) {
                                i5++;
                            } else if (i7 == 1) {
                                i6++;
                            }
                            if (storageModel.flag == 0 && !hashSet.contains(storageModel.displayname)) {
                                arrayList.add(storageModel);
                                hashSet.add(storageModel.displayname);
                            }
                        }
                    }
                    i2 = 1;
                }
                Object[] objArr2 = new Object[i2];
                objArr2[0] = "share storage model result size=" + arrayList.size();
                Log.d(TAG, objArr2);
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                SapiContext.getInstance().setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
                SapiStatUtil.statShareV2OpenMax(context, i4, i5, i6, i3, shareStorage, arrayList);
            }
        }
    }

    public static void startLoginShareActivityForResult(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{activity, str, str2, str3, str4, list, str5, str6}) == null) {
            if (activity != null) {
                if (SHARE_ACCOUNT_NEW_VERSION.equals(str5)) {
                    ShareCallPacking.statModel = new ShareCallPacking.StatModel();
                    List<ShareStorage.StorageModel> shareStorageModel = getShareStorageModel();
                    int i2 = 0;
                    while (true) {
                        if (i2 < shareStorageModel.size()) {
                            if (shareStorageModel.get(i2).pkg.equals(str) && shareStorageModel.get(i2).url.equals(str2)) {
                                ShareCallPacking.StatModel statModel = ShareCallPacking.statModel;
                                statModel.index = i2;
                                statModel.accountTpl = shareStorageModel.get(i2).tpl;
                                ShareCallPacking.statModel.appName = shareStorageModel.get(i2).app;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    SapiStatUtil.statShareV2Click(ShareCallPacking.statModel, list, str6);
                } else {
                    SapiStatUtil.statInvokeCloudShareAccount(3);
                }
                if (!TextUtils.isEmpty(str) && SapiUtils.isAppInstalled(activity, str)) {
                    ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
                    Intent intent = new Intent();
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    intent.putExtra(ShareCallPacking.EXTRA_SESSION_ID, str4);
                    intent.putExtra(ShareCallPacking.EXTRA_TRACE_ID, str3);
                    intent.putExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, str5);
                    intent.putExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE, str6);
                    SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                    if (sapiConfiguration != null) {
                        intent.putExtra(ShareCallPacking.EXTRA_FROM_APP_TPL, sapiConfiguration.tpl);
                    } else {
                        intent.putExtra(ShareCallPacking.EXTRA_FROM_APP_TPL, "unknown");
                    }
                    intent.setComponent(componentName);
                    activity.startActivityForResult(intent, 20001);
                    return;
                }
                Toast.makeText(activity, "登录失败", 0).show();
                return;
            }
            throw new IllegalArgumentException("loginActivity can't be null");
        }
    }
}
