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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public final class ShareUtils {
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
    public static boolean isRequestShareFromCloudTimeOut = false;
    public static List<ShareStorage.StorageModel> shareModelsMemoryCache;

    public static void cacheShareModels(List<ShareStorage.StorageModel> list) {
        shareModelsMemoryCache = list;
        SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODEL_CACHE, ShareStorage.StorageModel.toJSONArray(list).toString());
        SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODEL_CACHE_TIME, System.currentTimeMillis());
    }

    public static boolean checkCalleeIdentity(Context context, String str) {
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

    public static List<ShareStorage.StorageModel> checkShareAppInstalled(Context context, List<ShareStorage.StorageModel> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        Iterator<ShareStorage.StorageModel> it = list.iterator();
        while (it.hasNext()) {
            if (!SapiUtils.isAppInstalled(context, it.next().pkg)) {
                it.remove();
            }
        }
        return list;
    }

    public static String[] getDeletedShareModels() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_DELETE_LIST);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(",");
    }

    public static void getShareModels(long j, Context context, String str, final ShareModelCallback shareModelCallback) {
        List<ShareStorage.StorageModel> shareModelsFromQuickCache = getShareModelsFromQuickCache(context);
        if (shareModelsFromQuickCache != null && shareModelsFromQuickCache.size() > 0) {
            shareModelCallback.onReceiveShareModels(shareModelsFromQuickCache);
            return;
        }
        List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage();
        if (shareModelsFromShareStorage != null && shareModelsFromShareStorage.size() > 0) {
            shareModelCallback.onReceiveShareModels(shareModelsFromShareStorage);
            cacheShareModels(shareModelsFromShareStorage);
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_INIT_SP);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<Intent> queryShareActivitys = queryShareActivitys(context);
        if (queryShareActivitys != null && queryShareActivitys.size() > 0) {
            for (Intent intent : queryShareActivitys) {
                arrayList.add(intent.getComponent().getPackageName());
            }
        }
        if (arrayList.size() <= 0) {
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_BUT_NONE_APP);
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
            return;
        }
        int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
        List<ShareStorage.StorageModel> shareModelsFromSP = getShareModelsFromSP(ordinal, arrayList);
        if (shareModelsFromSP != null && shareModelsFromSP.size() > 0) {
            shareModelCallback.onReceiveShareModels(shareModelsFromSP);
            cacheShareModels(shareModelsFromSP);
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SP);
            return;
        }
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
            List<ShareStorage.StorageModel> shareModelsFromSdCard = getShareModelsFromSdCard(ordinal, arrayList);
            if (shareModelsFromSdCard != null && shareModelsFromSdCard.size() > 0) {
                shareModelCallback.onReceiveShareModels(shareModelsFromSdCard);
                cacheShareModels(shareModelsFromSdCard);
                StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_DYNAMIC_SDCARD);
                return;
            }
        } else {
            StatService.onEventAutoStat(ShareStatKey.GET_SHARE_NO_SDCARD_PERM);
        }
        final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.share.ShareUtils.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = true;
                shareModelCallback.onReceiveShareModels(new ArrayList(0));
            }
        };
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(0, j);
        String packageName = context.getPackageName();
        if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_MODEL_FROM_SERVER).isMeetGray()) {
            SapiAccountManager.getInstance().getAccountService().getShareV3App(str, arrayList, packageName, new GetShareV3AppCallback() { // from class: com.baidu.sapi2.share.ShareUtils.3
                @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                public void onFailure() {
                    handler.removeCallbacksAndMessages(null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeout", ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                    hashMap.put("status", "0");
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                    if (ShareUtils.isRequestShareFromCloudTimeOut) {
                        boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                    } else {
                        handler.post(new Runnable() { // from class: com.baidu.sapi2.share.ShareUtils.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                shareModelCallback.onReceiveShareModels(new ArrayList(0));
                            }
                        });
                    }
                }

                @Override // com.baidu.sapi2.callback.inner.GetShareV3AppCallback
                public void onSuccess(final List<ShareStorage.StorageModel> list) {
                    ShareUtils.cacheShareModels(list);
                    handler.removeCallbacksAndMessages(null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeout", ShareUtils.isRequestShareFromCloudTimeOut ? "1" : "0");
                    hashMap.put("status", "1");
                    StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_CLOUD, hashMap);
                    if (ShareUtils.isRequestShareFromCloudTimeOut) {
                        boolean unused = ShareUtils.isRequestShareFromCloudTimeOut = false;
                    } else {
                        handler.post(new Runnable() { // from class: com.baidu.sapi2.share.ShareUtils.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                shareModelCallback.onReceiveShareModels(list);
                            }
                        });
                    }
                }
            });
        }
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromCloudCache() {
        JSONArray jSONArray;
        if ((System.currentTimeMillis() / 1000) - SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_TIME_SECOND <= 60) {
            String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE);
            Log.d(TAG, "get share models from cloud cache, value=" + string);
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e2) {
                Log.e(TAG, e2.getMessage());
                jSONArray = null;
            }
            if (jSONArray != null) {
                return ShareStorage.StorageModel.fromJSONArray(jSONArray);
            }
        }
        return null;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromQuickCache(Context context) {
        if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_CACHE_ABILITY).isMeetGray()) {
            List<ShareStorage.StorageModel> checkShareAppInstalled = checkShareAppInstalled(context, shareModelsMemoryCache);
            if (checkShareAppInstalled != null && checkShareAppInstalled.size() > 0) {
                Log.d(TAG, "get share model from modelsFromMemoryCache, size=" + checkShareAppInstalled.size());
                StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_MEMORY_CACHE);
                return checkShareAppInstalled;
            }
            if (System.currentTimeMillis() < SapiContext.getInstance().getLong(SapiContext.KEY_SHARE_MODEL_CACHE_TIME, 0L) + SapiContext.getInstance().getShareCacheValidTime()) {
                try {
                    List<ShareStorage.StorageModel> checkShareAppInstalled2 = checkShareAppInstalled(context, ShareStorage.StorageModel.fromJSONArray(new JSONArray(SapiContext.getInstance().getString(SapiContext.KEY_SHARE_MODEL_CACHE))));
                    if (checkShareAppInstalled2 != null && checkShareAppInstalled2.size() > 0) {
                        shareModelsMemoryCache = checkShareAppInstalled2;
                        Log.d(TAG, "get share model from modelsFromSPCache, size=" + checkShareAppInstalled2.size());
                        StatService.onEventAutoStat(ShareStatKey.GET_SHARE_FROM_SP_CACHE);
                    }
                    return checkShareAppInstalled2;
                } catch (Exception e2) {
                    Log.e(TAG, e2.getMessage());
                }
            }
            return null;
        }
        return null;
    }

    public static List<ShareStorage.StorageModel> getShareModelsFromSP(int i2, List<String> list) {
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

    public static List<ShareStorage.StorageModel> getShareModelsFromSdCard(int i2, List<String> list) {
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

    public static List<ShareStorage.StorageModel> getShareModelsFromShareStorage() {
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
                return ShareStorage.StorageModel.fromJSONArray(jSONArray);
            }
        }
        Log.e(TAG, "getShareStorage result is null");
        return new ArrayList(0);
    }

    public static List<ShareStorage.StorageModel> getShareStorageModel() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(TAG, "config initialShareStrategy is DISABLED");
            return new ArrayList(0);
        }
        List<ShareStorage.StorageModel> shareModelsFromShareStorage = getShareModelsFromShareStorage();
        String[] deletedShareModels = getDeletedShareModels();
        if (shareModelsFromShareStorage != null && shareModelsFromShareStorage.size() > 0 && deletedShareModels != null && deletedShareModels.length > 0) {
            Log.d(TAG, "shareModels has value, deleteModels has value");
            Iterator<ShareStorage.StorageModel> it = shareModelsFromShareStorage.iterator();
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
        return shareModelsFromShareStorage;
    }

    public static boolean isInV2ShareDisableWhiteList(SapiConfiguration sapiConfiguration) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String str : arrayList) {
            if (sapiConfiguration.context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static void markAsDeleteShareLogin(String str) {
        String[] deletedShareModels = getDeletedShareModels();
        StringBuilder sb = new StringBuilder();
        for (int length = deletedShareModels.length + 1 > 10 ? (deletedShareModels.length + 1) - 10 : 0; length < deletedShareModels.length; length++) {
            sb.append(deletedShareModels[length]);
            sb.append(",");
        }
        sb.append(str);
        SapiContext.getInstance().put(SapiContext.KEY_SHARE_DELETE_LIST, sb.toString());
    }

    public static void onLoginActivityActivityResult(ShareCallPacking.ShareLoginCallBack shareLoginCallBack, int i2, int i3, Intent intent, ShareCallPacking shareCallPacking, List<PassNameValuePair> list, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (i2 != 20001) {
            return;
        }
        if (shareLoginCallBack != null) {
            Context context = SapiAccountManager.getInstance().getConfignation().context;
            String str9 = "";
            String stringExtra = intent != null ? intent.getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE) : "";
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
                    str8 = sapiAccount.uid;
                    SapiContext sapiContext = SapiContext.getInstance();
                    sapiContext.setCurrentAccount(sapiAccount);
                    sapiContext.addLoginAccount(sapiAccount);
                    shareCallPacking.asyncMarkLoginState(2);
                    sapiContext.setAccountActionType(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
                    if (sapiContext.shareLivingunameEnable()) {
                        ArrayList arrayList = new ArrayList();
                        String stringExtra2 = intent.getStringExtra("V2_FACE_LOGIN_UIDS_TIMES");
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra2));
                        }
                        if (!arrayList.isEmpty()) {
                            new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                        }
                    }
                    sapiContext.put(SapiContext.KEY_PRE_LOGIN_TYPE, ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
                    shareLoginCallBack.onSuccess();
                    str7 = "";
                    c2 = 0;
                } else {
                    Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                    shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                    str7 = ShareResult.ERROR_MSG_ACCOUNT_NULL;
                    str8 = "";
                    c2 = 1;
                    str9 = "-3007";
                }
                str4 = str7;
                str6 = str9;
                str5 = str8;
            } else {
                if (intent != null) {
                    str3 = intent.getStringExtra("share_fail_code");
                    String stringExtra3 = intent.getStringExtra("share_fail_reason");
                    Toast.makeText(context, stringExtra3, 0).show();
                    str2 = stringExtra3;
                } else {
                    str2 = "result data is null";
                    str3 = "";
                }
                shareLoginCallBack.onFailed(-207, "互通登录失败,请稍后再试");
                str4 = str2;
                str5 = "";
                str6 = str3;
            }
            if (SHARE_ACCOUNT_CLOUND_VERSION.equals(stringExtra)) {
                if (c2 == 0) {
                    SapiStatUtil.statInvokeCloudShareAccount(4);
                    return;
                } else {
                    SapiStatUtil.statInvokeCloudShareAccount(5);
                    return;
                }
            } else if (c2 == 0) {
                SapiStatUtil.statShareV2Success(ShareCallPacking.statModel, str5, list, str);
                return;
            } else {
                SapiStatUtil.statShareV2Fail(ShareCallPacking.statModel, str6, str4, str5, list, str);
                return;
            }
        }
        throw new IllegalArgumentException("and shareLoginCallBack can't be null");
    }

    public static List<Intent> queryShareActivitys(Context context) {
        return queryShareIntent(context, context.getPackageManager().queryIntentActivities(new Intent(ACTION_SHARE_ACTIVITY), 32), ACTION_SHARE_ACTIVITY);
    }

    public static List<Intent> queryShareIntent(Context context, List<ResolveInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (context != null && list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance().getOrderAuthorizedPackages();
            try {
                for (ResolveInfo resolveInfo : list) {
                    String str2 = resolveInfo.activityInfo.permission;
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null) {
                        Intent intent = new Intent(str);
                        intent.setClassName(((ComponentInfo) activityInfo).packageName, ((ComponentInfo) activityInfo).name);
                        if (Build.VERSION.SDK_INT > 11) {
                            intent.addFlags(32);
                        }
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
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
                        return entry.getValue().compareTo(entry2.getValue());
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

    public static void setShareStorageModel() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(context) && confignation.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            ArrayList arrayList = new ArrayList();
            List<Intent> queryShareActivitys = queryShareActivitys(context);
            if (queryShareActivitys.size() == 0) {
                SapiContext.getInstance().setShareStorage(null);
                SapiContext.getInstance().setBaiduAppPkgList(null);
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
            SapiContext.getInstance().setBaiduAppPkgList(sb.toString());
            SapiContext.getInstance().setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
            SapiStatUtil.statShareV2OpenMax(context, i4, i5, i6, i3, shareStorage, arrayList);
        }
    }

    public static void startLoginShareActivityForResult(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
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
