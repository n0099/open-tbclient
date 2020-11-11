package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.b;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3519a = "share_account";
    private static final String b = "share_fail_reason";
    static final int c = 87;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Comparator<Map.Entry<Intent, Integer>> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
            return entry.getValue().compareTo(entry2.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SapiContext f3520a;

        b(SapiContext sapiContext) {
            this.f3520a = sapiContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3520a.getCurrentAccount() != null) {
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "slient_share");
                SapiAccountManager.getSilentShareListener().onSilentShare();
            }
        }
    }

    static List<Intent> a(Context context, List<ResolveInfo> list, String str) {
        String str2;
        ComponentInfo componentInfo;
        ArrayList arrayList = new ArrayList();
        if (context == null || list == null || list.size() == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance().getOrderAuthorizedPackages();
        try {
            for (ResolveInfo resolveInfo : list) {
                if ("baidu.intent.action.account.SHARE_SERVICE".equals(str)) {
                    str2 = resolveInfo.serviceInfo.permission;
                    componentInfo = resolveInfo.serviceInfo;
                } else {
                    str2 = resolveInfo.activityInfo.permission;
                    componentInfo = resolveInfo.activityInfo;
                }
                if (componentInfo != null) {
                    Intent intent = new Intent(str);
                    intent.setClassName(componentInfo.packageName, componentInfo.name);
                    if (Build.VERSION.SDK_INT > 11) {
                        intent.addFlags(32);
                    }
                    if (TextUtils.isEmpty(str2) || context.checkCallingOrSelfPermission(str2) == 0) {
                        if (a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
                            int i = Integer.MAX_VALUE;
                            for (String str3 : orderAuthorizedPackages.keySet()) {
                                if (intent.getComponent().getPackageName().matches(str3)) {
                                    i = orderAuthorizedPackages.get(str3).intValue();
                                }
                            }
                            hashMap.put(intent, Integer.valueOf(i));
                        }
                    }
                }
            }
            ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList2, new a());
            for (Map.Entry entry : arrayList2) {
                arrayList.add(entry.getKey());
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return arrayList;
    }

    public static List<Intent> c(Context context) {
        return a(context, context.getPackageManager().queryIntentActivities(new Intent("baidu.intent.action.account.SHARE_ACTIVITY"), 32), "baidu.intent.action.account.SHARE_ACTIVITY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Intent> d(Context context) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        int i = 0;
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(context) && !com.baidu.sapi2.utils.enums.a.b.equals(confignation.loginShareDirection())) {
            ArrayList arrayList = new ArrayList();
            List<Intent> c2 = c(context);
            if (c2.size() == 0) {
                SapiContext.getInstance().setShareStorage(null);
                SapiContext.getInstance().setBaiduAppPkgList(null);
                return;
            }
            ShareStorage shareStorage = new ShareStorage();
            HashSet hashSet = new HashSet();
            for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                hashSet.add(sapiAccount.displayname);
            }
            int size = c2.size();
            int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            for (Intent intent : c2) {
                String packageName = intent.getComponent().getPackageName();
                sb.append(packageName).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                ShareStorage.StorageModel a2 = shareStorage.a(packageName);
                if (a2 != null && a2.c != ordinal) {
                    size--;
                } else if (a2 == null) {
                    i3++;
                } else {
                    int i4 = a2.b;
                    if (i4 == 0) {
                        i2++;
                    } else if (i4 == 1) {
                        i++;
                    }
                    if (a2.flag == 0 && !hashSet.contains(a2.displayname)) {
                        arrayList.add(a2);
                        hashSet.add(a2.displayname);
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            SapiContext.getInstance().setBaiduAppPkgList(sb.toString());
            SapiContext.getInstance().setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
            SapiStatUtil.statShareV2OpenMax(context, i3, i2, i, size, shareStorage, arrayList);
        }
    }

    static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            return packagesForUid.length > 0 ? packagesForUid[0] : "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    static void b(SapiAccount sapiAccount) {
        if (SapiAccount.isValidAccount(sapiAccount)) {
            SapiContext sapiContext = SapiContext.getInstance();
            SapiAccount currentAccount = sapiContext.getCurrentAccount();
            if (currentAccount != null && sapiAccount.uid.equals(currentAccount.uid)) {
                com.baidu.sapi2.share.a.a().a(currentAccount, sapiAccount);
                sapiContext.setCurrentAccount(currentAccount);
                SapiAccountManager.getInstance().preFetchStoken(currentAccount, false);
            }
            for (SapiAccount sapiAccount2 : sapiContext.getLoginAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    com.baidu.sapi2.share.a.a().a(sapiAccount2, sapiAccount);
                    sapiContext.addLoginAccount(sapiAccount2);
                    new ShareStorage().a(2);
                }
            }
            for (SapiAccount sapiAccount3 : sapiContext.getShareAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    com.baidu.sapi2.share.a.a().a(sapiAccount3, sapiAccount);
                    sapiContext.addShareAccount(sapiAccount3);
                }
            }
        }
    }

    public static boolean b() {
        Context context = SapiAccountManager.getInstance().getConfignation().context;
        Map<String, String> vehicleSystemPackages = SapiContext.getInstance().getVehicleSystemPackages();
        String packageName = context.getPackageName();
        String packageSign = SapiUtils.getPackageSign(context, packageName);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str : vehicleSystemPackages.keySet()) {
                if (packageName.matches(str) && packageSign.equals(vehicleSystemPackages.get(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return a(context, b(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
        String packageSign = SapiUtils.getPackageSign(context, str);
        if (!TextUtils.isEmpty(packageSign)) {
            for (String str2 : authorizedPackages.keySet()) {
                if (str.matches(str2) && packageSign.equals(authorizedPackages.get(str2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel, int i, String str, boolean z, boolean z2, String str2) {
        synchronized (e.class) {
            if (z) {
                SapiAccountManager.getInstance().getAccountService().setIqiyiAccessToken(str);
            } else if (context != null && loginShareStrategy != null && shareModel != null) {
                shareModel.a(context);
                SapiContext sapiContext = SapiContext.getInstance();
                if ((loginShareStrategy == LoginShareStrategy.SILENT && !sapiContext.isLoginStatusChanged() && sapiContext.getCurrentAccount() == null && shareModel.c().size() > 0 && SapiAccount.isValidAccount(shareModel.c().get(0))) || z2) {
                    SapiAccount sapiAccount = shareModel.c().get(0);
                    com.baidu.sapi2.share.a.a().a(sapiAccount, str2);
                    sapiContext.setCurrentAccount(sapiAccount);
                    SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                    sapiContext.addLoginAccount(sapiAccount);
                    new ShareStorage().a(2);
                    sapiContext.removeShareAccount(sapiAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new b(sapiContext));
                    }
                    for (SapiAccount sapiAccount2 : shareModel.c()) {
                        if (a(sapiAccount2)) {
                            com.baidu.sapi2.share.a.a().a(sapiAccount2, str2);
                            sapiContext.addShareAccount(sapiAccount2);
                        }
                    }
                } else {
                    for (SapiAccount sapiAccount3 : shareModel.c()) {
                        if (a(sapiAccount3)) {
                            com.baidu.sapi2.share.a.a().a(sapiAccount3, str2);
                            sapiContext.addShareAccount(sapiAccount3);
                        }
                        if (i >= 87) {
                            b(sapiAccount3);
                        }
                    }
                }
            }
        }
    }

    static boolean a(SapiAccount sapiAccount) {
        SapiContext sapiContext = SapiContext.getInstance();
        return SapiAccount.isValidAccount(sapiAccount) && (sapiContext.getCurrentAccount() == null || !sapiContext.getCurrentAccount().uid.equals(sapiAccount.uid)) && !sapiContext.getLoginAccounts().contains(sapiAccount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.a(context);
            SapiContext sapiContext = SapiContext.getInstance();
            if (shareModel.c().size() > 0) {
                SapiAccount sapiAccount = shareModel.c().get(0);
                if (sapiContext.getCurrentAccount() == null || !sapiContext.getCurrentAccount().uid.equals(sapiAccount.uid)) {
                    sapiContext.removeShareAccount(sapiAccount);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, LoginShareStrategy loginShareStrategy, ShareModel shareModel) {
        if (context != null && loginShareStrategy != null && shareModel != null) {
            if (TextUtils.isEmpty(shareModel.b())) {
                shareModel.a(context.getPackageName());
            }
            shareModel.a(loginShareStrategy);
            shareModel.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ShareStorage.StorageModel> a() {
        List<ShareStorage.StorageModel> a2 = ShareStorage.StorageModel.a(SapiContext.getInstance().getShareStorage());
        String[] deleteShareLoginList = SapiContext.getInstance().getDeleteShareLoginList();
        Iterator<ShareStorage.StorageModel> it = a2.iterator();
        while (it.hasNext()) {
            ShareStorage.StorageModel next = it.next();
            for (String str : deleteShareLoginList) {
                if (!TextUtils.isEmpty(next.url) && next.url.contains(str)) {
                    try {
                        it.remove();
                    } catch (Exception e) {
                    }
                }
            }
        }
        return a2;
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5) {
        int i = 0;
        if (activity != null) {
            if (!TextUtils.isEmpty(str) && SapiUtils.isAppInstalled(activity, str)) {
                ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra(com.baidu.sapi2.share.b.b, str4);
                intent.putExtra(com.baidu.sapi2.share.b.f3514a, str3);
                intent.putExtra(com.baidu.sapi2.share.b.c, str5);
                intent.setComponent(componentName);
                activity.startActivityForResult(intent, com.baidu.sapi2.share.b.h);
            } else {
                Toast.makeText(activity, "登录失败", 0).show();
            }
            if (SapiShareClient.SHARE_ACCOUNT_NEW_VERSION.equals(str5)) {
                com.baidu.sapi2.share.b.l = new b.c();
                List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(activity);
                while (true) {
                    int i2 = i;
                    if (i2 < shareStorageModel.size()) {
                        if (shareStorageModel.get(i2).pkg.equals(str) && shareStorageModel.get(i2).url.equals(str2)) {
                            b.c cVar = com.baidu.sapi2.share.b.l;
                            cVar.f3516a = i2;
                            cVar.b = shareStorageModel.get(i2).tpl;
                            com.baidu.sapi2.share.b.l.c = shareStorageModel.get(i2).app;
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        break;
                    }
                }
                SapiStatUtil.statShareV2Click(com.baidu.sapi2.share.b.l, list);
                return;
            }
            SapiStatUtil.statInvokeCloudShareAccount(3);
            return;
        }
        throw new IllegalArgumentException("loginActivity can't be null");
    }

    public static void a(b.AbstractC0343b abstractC0343b, int i, int i2, Intent intent, com.baidu.sapi2.share.b bVar, List<PassNameValuePair> list) {
        String str;
        int i3;
        String str2;
        String str3;
        if (i == 20001) {
            if (abstractC0343b != null) {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                String stringExtra = intent != null ? intent.getStringExtra(com.baidu.sapi2.share.b.c) : "";
                if (i2 == -1 && intent != null) {
                    SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra(f3519a);
                    if (sapiAccount != null) {
                        if (intent.getIntExtra(com.baidu.sapi2.share.b.g, 0) >= 190) {
                            com.baidu.sapi2.share.a.a().a(sapiAccount, intent.getStringExtra("PKG"));
                        } else {
                            sapiAccount.app = "";
                        }
                        String str4 = sapiAccount.uid;
                        SapiContext sapiContext = SapiContext.getInstance();
                        sapiContext.setCurrentAccount(sapiAccount);
                        SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                        sapiContext.addLoginAccount(sapiAccount);
                        bVar.a(2);
                        sapiContext.removeShareAccount(sapiAccount);
                        sapiContext.setAccountActionType(com.baidu.sapi2.share.b.k);
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
                        sapiContext.put(SapiContext.KEY_PRE_LOGIN_TYPE, com.baidu.sapi2.share.b.k);
                        abstractC0343b.onSuccess();
                        str3 = str4;
                        str2 = "";
                        i3 = 0;
                    } else {
                        i3 = 1;
                        Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                        abstractC0343b.onFailed(-207, "互通登录失败,请稍后再试");
                        str2 = "互通登录失败,请稍后再试";
                        str3 = "";
                    }
                } else {
                    if (intent != null) {
                        str = intent.getStringExtra(b);
                        Toast.makeText(context, str, 0).show();
                    } else {
                        str = "result data is null";
                    }
                    abstractC0343b.onFailed(-207, "互通登录失败,请稍后再试");
                    i3 = 2;
                    str2 = str;
                    str3 = "";
                }
                if (!SapiShareClient.SHARE_ACCOUNT_CLOUND_VERSION.equals(stringExtra)) {
                    SapiStatUtil.statShareV2Result(com.baidu.sapi2.share.b.l, str2, i3, str3, list);
                    return;
                } else if (i3 == 0) {
                    SapiStatUtil.statInvokeCloudShareAccount(4);
                    return;
                } else {
                    SapiStatUtil.statInvokeCloudShareAccount(5);
                    return;
                }
            }
            throw new IllegalArgumentException("and shareLoginCallBack can't be null");
        }
    }
}
