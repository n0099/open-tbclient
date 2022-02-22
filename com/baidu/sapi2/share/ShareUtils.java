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
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ShareAccountAccessor;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes11.dex */
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
    public static final String S_SHARE_MODEL_FROM_APP_SP = "SHARE_MODEL_FROM_APP_SP";
    public static final String S_SHARE_MODEL_FROM_CLOUD = "SHARE_MODEL_FROM_CLOUD";
    public static final String S_SHARE_MODEL_FROM_SD = "SHARE_MODEL_FROM_SD";
    public static final String S_SHARE_MODEL_FROM_SP = "SHARE_MODEL_FROM_OVERALL_SP";
    public static final String S_SHARE_MODEL_FROM_V2 = "SHARE_MODEL_FROM_V2";
    public static final String S_SHARE_MODEL_FROM_WITH_ERROR = "SHARE_MODEL_FROM_WITH_ERROR";
    public static final String TAG = "pass_share_login";
    public static boolean isRequestShareFromCloudTimeOut;
    public static boolean mIsCheckShareOnlineTimeOut;
    public static List<ShareStorage.StorageModel> mShareModelsMemoryCache;
    public static String mShareModelsMemoryCacheFrom;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
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

    public static void cacheShareModels(List<ShareStorage.StorageModel> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, list, str) == null) {
            mShareModelsMemoryCache = list;
            mShareModelsMemoryCacheFrom = str;
        }
    }

    public static void callbackShareModels(ShareModelWithCheckCallback shareModelWithCheckCallback, List<ShareStorage.StorageModel> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, shareModelWithCheckCallback, list, str) == null) || shareModelWithCheckCallback == null) {
            return;
        }
        shareModelWithCheckCallback.onReceiveShareModels(buildExpiredShareModels(list), str);
    }

    public static boolean checkCalleeIdentity(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, list, list2)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
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

    public static void getOnlineAppShareModel(List<ShareStorage.StorageModel> list, String str, ShareModelCallback shareModelCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, list, str, shareModelCallback) == null) {
            if (SapiContext.getInstance() == null) {
                shareModelCallback.onReceiveShareModels(list);
                ShareLoginStat.GetShareListStat.upload();
                return;
            }
            if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_SHARE_CHECK_ONLINE_SWITCH).isMeetGray()) {
                shareModelCallback.onReceiveShareModels(list);
                ShareLoginStat.GetShareListStat.statExtMap.put("gray", "1");
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_CHECK_BDUSS, "0");
                ShareLoginStat.GetShareListStat.upload();
                return;
            }
            ShareLoginStat.GetShareListStat.statExtMap.put("gray", "0");
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_CHECK_BDUSS, "1");
            String str2 = S_SHARE_MODEL_FROM_CLOUD.equals(str) ? "1" : "0";
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (S_SHARE_MODEL_FROM_CLOUD.equals(str)) {
                for (ShareStorage.StorageModel storageModel : list) {
                    arrayList.add(new GetOnlineRequestShareModel(storageModel));
                }
            } else {
                for (ShareStorage.StorageModel storageModel2 : list) {
                    if (TextUtils.isEmpty(storageModel2.bduss)) {
                        arrayList2.add(storageModel2);
                    } else {
                        arrayList.add(new GetOnlineRequestShareModel(storageModel2));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                shareModelCallback.onReceiveShareModels(list);
                ShareLoginStat.GetShareListStat.upload();
                return;
            }
            int i2 = SapiContext.getInstance().getSapiOptions().shareCheckOnlineTimeOut;
            Handler handler = new Handler(Looper.getMainLooper(), shareModelCallback, list) { // from class: com.baidu.sapi2.share.ShareUtils.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareModelCallback val$callback;
                public final /* synthetic */ List val$shareModelList;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, shareModelCallback, list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callback = shareModelCallback;
                    this.val$shareModelList = list;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = true;
                        this.val$callback.onReceiveShareModels(this.val$shareModelList);
                        ShareLoginStat.GetShareListStat.upload();
                    }
                }
            };
            handler.removeCallbacksAndMessages(null);
            handler.sendEmptyMessageDelayed(0, i2);
            SapiAccountManager.getInstance().getAccountService().getOnlineAppShareModel(arrayList, str2, new GetOnlineAppCallback(shareModelCallback, list, str, arrayList2, handler) { // from class: com.baidu.sapi2.share.ShareUtils.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareModelCallback val$callback;
                public final /* synthetic */ String val$from;
                public final /* synthetic */ Handler val$handler;
                public final /* synthetic */ List val$nilBdussShareModelList;
                public final /* synthetic */ List val$shareModelList;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {shareModelCallback, list, str, arrayList2, handler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callback = shareModelCallback;
                    this.val$shareModelList = list;
                    this.val$from = str;
                    this.val$nilBdussShareModelList = arrayList2;
                    this.val$handler = handler;
                }

                @Override // com.baidu.sapi2.callback.inner.GetOnlineAppCallback
                public void onFailure() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (ShareUtils.mIsCheckShareOnlineTimeOut) {
                            boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = false;
                        } else {
                            this.val$handler.post(new Runnable(this) { // from class: com.baidu.sapi2.share.ShareUtils.6.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass6 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
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
                                        AnonymousClass6 anonymousClass6 = this.this$0;
                                        anonymousClass6.val$callback.onReceiveShareModels(anonymousClass6.val$shareModelList);
                                        ShareLoginStat.GetShareListStat.upload();
                                    }
                                }
                            });
                        }
                    }
                }

                @Override // com.baidu.sapi2.callback.inner.GetOnlineAppCallback
                public void onSuccess(JSONArray jSONArray) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
                        if (ShareUtils.mIsCheckShareOnlineTimeOut) {
                            boolean unused = ShareUtils.mIsCheckShareOnlineTimeOut = false;
                        } else if (jSONArray != null && jSONArray.length() != 0 && jSONArray.length() >= 3) {
                            try {
                                ArrayList<ShareStorage.StorageModel> arrayList3 = new ArrayList();
                                for (ShareStorage.StorageModel storageModel3 : this.val$shareModelList) {
                                    if (storageModel3 != null) {
                                        String str4 = storageModel3.app + storageModel3.pkg + storageModel3.bduss;
                                        for (int i3 = 0; i3 < jSONArray.length() && ((str3 = (String) jSONArray.get(i3)) == null || !str3.equals(str4)); i3++) {
                                        }
                                        arrayList3.add(storageModel3);
                                    }
                                }
                                if (!ShareUtils.S_SHARE_MODEL_FROM_CLOUD.equals(this.val$from) && !this.val$nilBdussShareModelList.isEmpty()) {
                                    arrayList3.addAll(this.val$nilBdussShareModelList);
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                for (ShareStorage.StorageModel storageModel4 : arrayList3) {
                                    if (storageModel4 != null) {
                                        jSONArray2.put(storageModel4.app);
                                    }
                                }
                                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_CHECK_BDUSS_APP, jSONArray2);
                                this.val$callback.onReceiveShareModels(arrayList3);
                                ShareLoginStat.GetShareListStat.upload();
                            } catch (Exception e2) {
                                this.val$callback.onReceiveShareModels(this.val$shareModelList);
                                ShareLoginStat.GetShareListStat.upload();
                                e2.printStackTrace();
                            }
                        } else {
                            this.val$callback.onReceiveShareModels(this.val$shareModelList);
                            ShareLoginStat.GetShareListStat.upload();
                        }
                    }
                }
            });
        }
    }

    public static void getShareModels(long j2, Context context, String str, ShareModelWithCheckCallback shareModelWithCheckCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), context, str, shareModelWithCheckCallback}) == null) {
            List<String> installedApps = getInstalledApps(context);
            if (installedApps != null && installedApps.size() > 0) {
                List<ShareStorage.StorageModel> shareModelsFromQuickCache = getShareModelsFromQuickCache(installedApps);
                if (shareModelsFromQuickCache != null && shareModelsFromQuickCache.size() > 0) {
                    ShareLoginStat.GetShareListStat.statExtMap.put("from", "cache");
                    callbackShareModels(shareModelWithCheckCallback, shareModelsFromQuickCache, mShareModelsMemoryCacheFrom);
                    return;
                }
                List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage(installedApps);
                if (shareModelsFromShareStorage != null && shareModelsFromShareStorage.size() > 0) {
                    ShareLoginStat.GetShareListStat.statExtMap.put("from", ShareLoginStat.GetShareListStat.VALUE_FROM_SP);
                    cacheShareModels(shareModelsFromShareStorage, S_SHARE_MODEL_FROM_APP_SP);
                    callbackShareModels(shareModelWithCheckCallback, shareModelsFromShareStorage, S_SHARE_MODEL_FROM_APP_SP);
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_INIT_SP);
                    return;
                }
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                List<ShareStorage.StorageModel> shareModelsFromSP = getShareModelsFromSP(ordinal, installedApps);
                if (shareModelsFromSP.size() > 0) {
                    ShareLoginStat.GetShareListStat.statExtMap.put("from", ShareLoginStat.GetShareListStat.VALUE_FROM_SP);
                    cacheShareModels(shareModelsFromSP, S_SHARE_MODEL_FROM_SP);
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SP);
                    callbackShareModels(shareModelWithCheckCallback, shareModelsFromSP, S_SHARE_MODEL_FROM_SP);
                    return;
                }
                if (SapiUtils.checkRequestPermission(s.f55460i, context)) {
                    List<ShareStorage.StorageModel> shareModelsFromSdCard = getShareModelsFromSdCard(ordinal, installedApps);
                    if (shareModelsFromSdCard.size() > 0) {
                        ShareLoginStat.GetShareListStat.statExtMap.put("from", "sd");
                        cacheShareModels(shareModelsFromSdCard, S_SHARE_MODEL_FROM_SD);
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SDCARD);
                        callbackShareModels(shareModelWithCheckCallback, shareModelsFromSdCard, S_SHARE_MODEL_FROM_SD);
                        return;
                    }
                } else {
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_NO_SDCARD_PERM);
                }
                ShareLoginStat.GetShareListStat.statExtMap.put("from", "net");
                Handler handler = new Handler(Looper.getMainLooper(), shareModelWithCheckCallback) { // from class: com.baidu.sapi2.share.ShareUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShareModelWithCheckCallback val$callback;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, shareModelWithCheckCallback};
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
                        this.val$callback = shareModelWithCheckCallback;
                    }

                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                            boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = true;
                            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_TIMEOUT_FROM_NET, "1");
                            ShareUtils.callbackShareModels(this.val$callback, new ArrayList(0), ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
                        }
                    }
                };
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_TIMEOUT_FROM_NET, "0");
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(0, j2);
                getShareV3App(context, str, installedApps, new GetShareV3AppCallback(handler, shareModelWithCheckCallback) { // from class: com.baidu.sapi2.share.ShareUtils.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShareModelWithCheckCallback val$callback;
                    public final /* synthetic */ Handler val$handler;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {handler, shareModelWithCheckCallback};
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
                        this.val$callback = shareModelWithCheckCallback;
                    }

                    @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                    public void onFailure() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$handler.removeCallbacksAndMessages(null);
                            HashMap hashMap = new HashMap();
                            hashMap.put(a.O, ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
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
                                            ShareUtils.callbackShareModels(this.this$0.val$callback, new ArrayList(0), ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
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
                            ShareUtils.cacheShareModels(list, ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
                            HashMap hashMap = new HashMap();
                            hashMap.put(a.O, ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
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
                                            ShareUtils.callbackShareModels(this.this$0.val$callback, this.val$shareModels, ShareUtils.S_SHARE_MODEL_FROM_CLOUD);
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
            callbackShareModels(shareModelWithCheckCallback, new ArrayList(0), mShareModelsMemoryCacheFrom);
        }
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromQuickCache(List<String> list) {
        InterceptResult invokeL;
        List<ShareStorage.StorageModel> checkShareAppInstalled;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, list)) == null) {
            if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_CACHE_ABILITY).isMeetGray() && (checkShareAppInstalled = checkShareAppInstalled(mShareModelsMemoryCache, list)) != null && checkShareAppInstalled.size() > 0) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65554, null, i2, list)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65555, null, i2, list)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, list)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_ABLE, "1");
                List<String> installedApps = getInstalledApps(sapiConfiguration.context);
                if (installedApps != null && installedApps.size() != 0) {
                    List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage(installedApps);
                    ShareLoginStat.GetShareListStat.statExtMap.put("from", ShareLoginStat.GetShareListStat.VALUE_FROM_SP);
                    if (shareModelsFromShareStorage != null) {
                        ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_V2_INITIAL_SIZE, String.valueOf(shareModelsFromShareStorage.size()));
                    }
                    List<ShareStorage.StorageModel> buildExpiredShareModels = buildExpiredShareModels(shareModelsFromShareStorage);
                    String[] deletedShareModels = getDeletedShareModels();
                    if (buildExpiredShareModels.size() > 0 && deletedShareModels != null && deletedShareModels.length > 0) {
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
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_IS_ABLE, "0");
            return new ArrayList(0);
        }
        return (List) invokeV.objValue;
    }

    public static void getShareV3App(Context context, String str, List<String> list, GetShareV3AppCallback getShareV3AppCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65558, null, context, str, list, getShareV3AppCallback) == null) {
            if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_MODEL_FROM_SERVER).isMeetGray()) {
                if (getShareV3AppCallback != null) {
                    getShareV3AppCallback.onFailure();
                }
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_GRAY, "0");
                return;
            }
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_GRAY, "1");
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
        }
    }

    public static boolean isInV2ShareDisableWhiteList(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, sapiConfiguration)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            String[] deletedShareModels = getDeletedShareModels();
            StringBuilder sb = new StringBuilder();
            if (deletedShareModels != null) {
                for (int length = deletedShareModels.length + 1 > 10 ? (deletedShareModels.length + 1) - 10 : 0; length < deletedShareModels.length; length++) {
                    sb.append(deletedShareModels[length]);
                    sb.append(",");
                }
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
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{shareLoginCallBack, Integer.valueOf(i2), Integer.valueOf(i3), intent, shareCallPacking, list, str}) == null) {
            if (i2 != 20001) {
                ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "0");
            } else if (shareLoginCallBack != null) {
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
                        String str11 = sapiAccount.uid;
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
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.CHOICE_SHARE_V2.getName());
                        shareLoginCallBack.onSuccess();
                        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "1");
                        str9 = str11;
                        str8 = "";
                        c2 = 0;
                    } else {
                        Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                        shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "0");
                        str8 = ShareResult.ERROR_MSG_ACCOUNT_NULL;
                        c2 = 1;
                        str10 = "-3007";
                        str9 = "";
                    }
                    str6 = str9;
                    str5 = str8;
                    str7 = str10;
                } else {
                    if (intent != null) {
                        str4 = intent.getStringExtra("share_fail_code");
                        str3 = intent.getStringExtra("share_fail_reason");
                        Toast.makeText(context, str3, 0).show();
                    } else {
                        str3 = "result data is null";
                        str4 = "";
                    }
                    shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                    ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_SUCCESS, "0");
                    str5 = str3;
                    str6 = "";
                    str7 = str4;
                }
                ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, str7);
                ShareLoginStat.MakeShareLoginStat.statExtMap.put("errorMsg", str5);
                ShareLoginStat.MakeShareLoginStat.upload();
                if (SHARE_ACCOUNT_CLOUND_VERSION.equals(str2)) {
                    if (c2 == 0) {
                        SapiStatUtil.statInvokeCloudShareAccount(4);
                    } else {
                        SapiStatUtil.statInvokeCloudShareAccount(5);
                    }
                } else if (c2 == 0) {
                    SapiStatUtil.statShareV2Success(ShareCallPacking.statModel, str6, list, str);
                } else {
                    SapiStatUtil.statShareV2Fail(ShareCallPacking.statModel, str7, str5, str6, list, str);
                }
            } else {
                throw new IllegalArgumentException("and shareLoginCallBack can't be null");
            }
        }
    }

    public static List<Intent> queryShareActivitys(Context context) {
        InterceptResult invokeL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
                list = context.getPackageManager().queryIntentActivities(new Intent(ACTION_SHARE_ACTIVITY), 32);
            } catch (Exception e2) {
                Log.e(e2);
                list = null;
            }
            return queryShareIntent(context, list, ACTION_SHARE_ACTIVITY);
        }
        return (List) invokeL.objValue;
    }

    public static List<Intent> queryShareIntent(Context context, List<ResolveInfo> list, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, context, list, str)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            Context context = confignation.context;
            if (SapiUtils.isOnline(confignation) && confignation.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                List<Intent> queryShareActivitys = queryShareActivitys(context);
                if (queryShareActivitys.size() == 0) {
                    SapiContext.getInstance().setShareStorage(null);
                    return;
                }
                ShareStorage shareStorage = new ShareStorage();
                int size = queryShareActivitys.size();
                int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                int i2 = 1;
                Log.d(TAG, "current login env is " + ordinal);
                if (!SapiUtils.checkRequestPermission(s.f55460i, context)) {
                    StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_NOT_STORAGE_PERM);
                }
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                int i3 = size;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                for (Intent intent : queryShareActivitys) {
                    if (intent.getComponent() != null) {
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
                                if (storageModel.flag == 0) {
                                    arrayList.add(storageModel);
                                }
                            }
                        }
                        i2 = 1;
                    }
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
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{activity, str, str2, str3, str4, list, str5, str6}) == null) {
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
                    activity.startActivityForResult(intent, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                    return;
                }
                Toast.makeText(activity, "登录失败", 0).show();
                return;
            }
            throw new IllegalArgumentException("loginActivity can't be null");
        }
    }
}
