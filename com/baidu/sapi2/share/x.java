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
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class x {
    private static final String a = "share_account";
    private static final String b = "share_fail_reason";
    static final int c = 87;

    static List<Intent> a(Context context, List<ResolveInfo> list, String str) {
        String str2;
        ComponentInfo componentInfo;
        ArrayList arrayList = new ArrayList();
        if (context == null || list == null || list.size() == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        Map<String, Integer> orderAuthorizedPackages = SapiContext.getInstance(context).getOrderAuthorizedPackages();
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
            Collections.sort(arrayList2, new v());
            for (Map.Entry entry : arrayList2) {
                arrayList.add(entry.getKey());
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ShareStorage.StorageModel> c(Context context) {
        List<ShareStorage.StorageModel> a2 = ShareStorage.StorageModel.a(SapiContext.getInstance(context).getShareStorage());
        String[] deleteShareLoginList = SapiContext.getInstance(context).getDeleteShareLoginList();
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

    public static List<Intent> d(Context context) {
        return a(context, context.getPackageManager().queryIntentActivities(new Intent("baidu.intent.action.account.SHARE_ACTIVITY"), 32), "baidu.intent.action.account.SHARE_ACTIVITY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Intent> e(Context context) {
        return a(context, context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32), "baidu.intent.action.account.SHARE_SERVICE");
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

    static void b(Context context, SapiAccount sapiAccount) {
        if (context != null && SapiUtils.isValidAccount(sapiAccount)) {
            SapiContext sapiContext = SapiContext.getInstance(context);
            SapiAccount currentAccount = sapiContext.getCurrentAccount();
            if (currentAccount != null && sapiAccount.uid.equals(currentAccount.uid)) {
                k.a().a(currentAccount, sapiAccount);
                sapiContext.setCurrentAccount(currentAccount);
                SapiAccountManager.getInstance().preFetchStoken(currentAccount, false);
            }
            for (SapiAccount sapiAccount2 : sapiContext.getLoginAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount2.uid)) {
                    k.a().a(sapiAccount2, sapiAccount);
                    sapiContext.addLoginAccount(sapiAccount2);
                    new ShareStorage().a(false);
                }
            }
            for (SapiAccount sapiAccount3 : sapiContext.getShareAccounts()) {
                if (sapiAccount.uid.equals(sapiAccount3.uid)) {
                    k.a().a(sapiAccount3, sapiAccount);
                    sapiContext.addShareAccount(sapiAccount3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        int i = 0;
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(context) && !com.baidu.sapi2.utils.enums.a.b.equals(confignation.loginShareDirection())) {
            ArrayList arrayList = new ArrayList();
            List<Intent> d = d(context);
            if (d.size() == 0) {
                SapiContext.getInstance(context).setShareStorage(null);
                return;
            }
            ShareStorage shareStorage = new ShareStorage();
            HashSet hashSet = new HashSet();
            for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                hashSet.add(sapiAccount.displayname);
            }
            int size = d.size();
            int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
            int i2 = 0;
            int i3 = 0;
            for (Intent intent : d) {
                ShareStorage.StorageModel a2 = shareStorage.a(intent.getComponent().getPackageName());
                if (a2 != null && a2.d != ordinal) {
                    size--;
                } else if (a2 == null) {
                    i3++;
                } else {
                    int i4 = a2.c;
                    if (i4 == 0) {
                        i2++;
                    } else if (i4 == 1) {
                        i++;
                    }
                    if (a2.b == 0 && !hashSet.contains(a2.displayname)) {
                        arrayList.add(a2);
                        hashSet.add(a2.displayname);
                    }
                }
            }
            SapiContext.getInstance(context).setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
            SapiStatUtil.statShareV2OpenMax(context, i3, i2, i, size, shareStorage, arrayList);
        }
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
        Map<String, String> authorizedPackages = SapiContext.getInstance(context).getAuthorizedPackages();
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
        synchronized (x.class) {
            if (z) {
                SapiAccountManager.getInstance().getAccountService().setIqiyiAccessToken(str);
            } else if (context != null && loginShareStrategy != null && shareModel != null) {
                shareModel.a(context);
                SapiContext sapiContext = SapiContext.getInstance(context);
                if ((loginShareStrategy == LoginShareStrategy.SILENT && !sapiContext.isLoginStatusChanged() && sapiContext.getCurrentAccount() == null && shareModel.c().size() > 0 && SapiUtils.isValidAccount(shareModel.c().get(0))) || z2) {
                    SapiAccount sapiAccount = shareModel.c().get(0);
                    k.a().a(sapiAccount, str2);
                    sapiContext.setCurrentAccount(sapiAccount);
                    SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                    sapiContext.addLoginAccount(sapiAccount);
                    new ShareStorage().a(false);
                    sapiContext.removeShareAccount(sapiAccount);
                    if (SapiAccountManager.getSilentShareListener() != null) {
                        new Handler(Looper.getMainLooper()).post(new w(sapiContext, context));
                    }
                    for (SapiAccount sapiAccount2 : shareModel.c()) {
                        if (a(context, sapiAccount2)) {
                            k.a().a(sapiAccount2, str2);
                            sapiContext.addShareAccount(sapiAccount2);
                        }
                    }
                } else {
                    for (SapiAccount sapiAccount3 : shareModel.c()) {
                        if (a(context, sapiAccount3)) {
                            k.a().a(sapiAccount3, str2);
                            sapiContext.addShareAccount(sapiAccount3);
                        }
                        if (i >= 87) {
                            b(context, sapiAccount3);
                        }
                    }
                }
            }
        }
    }

    static boolean a(Context context, SapiAccount sapiAccount) {
        if (context == null) {
            return false;
        }
        SapiContext sapiContext = SapiContext.getInstance(context);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return (sapiContext.getCurrentAccount() == null || !sapiContext.getCurrentAccount().uid.equals(sapiAccount.uid)) && !sapiContext.getLoginAccounts().contains(sapiAccount);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, ShareModel shareModel) {
        if (context != null && shareModel != null) {
            shareModel.a(context);
            SapiContext sapiContext = SapiContext.getInstance(context);
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

    public static void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list) {
        int i = 0;
        if (activity != null) {
            if (!TextUtils.isEmpty(str) && SapiUtils.isAppInstalled(activity, str)) {
                ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra(m.b, str4);
                intent.putExtra(m.a, str3);
                intent.setComponent(componentName);
                activity.startActivityForResult(intent, 20001);
            } else {
                Toast.makeText(activity, "登录失败", 0).show();
            }
            m.k = new m.b();
            List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(activity);
            while (true) {
                int i2 = i;
                if (i2 < shareStorageModel.size()) {
                    if (shareStorageModel.get(i2).pkg.equals(str) && shareStorageModel.get(i2).url.equals(str2)) {
                        m.b bVar = m.k;
                        bVar.d = i2;
                        bVar.e = shareStorageModel.get(i2).tpl;
                        m.k.f = shareStorageModel.get(i2).app;
                        break;
                    }
                    i = i2 + 1;
                } else {
                    break;
                }
            }
            SapiStatUtil.statShareV2Click(m.k, list);
            return;
        }
        throw new IllegalArgumentException("loginActivity can't be null");
    }

    public static void a(m.a aVar, int i, int i2, Intent intent, m mVar, List<PassNameValuePair> list) {
        int i3;
        String str;
        String str2;
        String str3;
        if (i == 20001) {
            if (aVar != null) {
                Context context = SapiAccountManager.getInstance().getConfignation().context;
                if (i2 == -1) {
                    SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra(a);
                    if (sapiAccount != null) {
                        if (intent.getIntExtra(m.f, 0) >= 190) {
                            k.a().a(sapiAccount, intent.getStringExtra("PKG"));
                        } else {
                            sapiAccount.app = "";
                        }
                        String str4 = sapiAccount.uid;
                        SapiContext sapiContext = SapiContext.getInstance(context);
                        sapiContext.setCurrentAccount(sapiAccount);
                        SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
                        sapiContext.addLoginAccount(sapiAccount);
                        mVar.a(false);
                        sapiContext.removeShareAccount(sapiAccount);
                        SapiContext.getInstance(context).setAccountActionType(m.j);
                        if (SapiContext.getInstance(context).shareLivingunameEnable()) {
                            ArrayList arrayList = new ArrayList();
                            String stringExtra = intent.getStringExtra("V2_FACE_LOGIN_UIDS_TIMES");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                arrayList.addAll(new FaceLoginService().str2ShareModelV2List(stringExtra));
                            }
                            if (!arrayList.isEmpty()) {
                                new FaceLoginService().syncFaceLoginUidList(context, arrayList);
                            }
                        }
                        SapiContext.getInstance(context).put(SapiContext.KEY_PRE_LOGIN_TYPE, m.j);
                        aVar.onSuccess();
                        str3 = str4;
                        str2 = "";
                        i3 = 0;
                        SapiStatUtil.statShareV2Result(m.k, str2, i3, str3, list);
                        return;
                    }
                    i3 = 1;
                    str = "互通登录失败,请稍后再试";
                    Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                    aVar.onFailed(-207, "互通登录失败,请稍后再试");
                } else {
                    i3 = 2;
                    if (intent != null) {
                        str = intent.getStringExtra(b);
                        Toast.makeText(context, str, 0).show();
                    } else {
                        str = "result data is null";
                    }
                    aVar.onFailed(-207, "互通登录失败,请稍后再试");
                }
                str2 = str;
                str3 = "";
                SapiStatUtil.statShareV2Result(m.k, str2, i3, str3, list);
                return;
            }
            throw new IllegalArgumentException("and shareLoginCallBack can't be null");
        }
    }

    public static boolean a() {
        Context context = SapiAccountManager.getInstance().getConfignation().context;
        Map<String, String> vehicleSystemPackages = SapiContext.getInstance(context).getVehicleSystemPackages();
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
}
