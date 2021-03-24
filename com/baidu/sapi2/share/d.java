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
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.e;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.a;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
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
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11376a = "pass_share_login";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11377b = "share_account";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11378c = "share_fail_code";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11379d = "share_fail_reason";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11380e = "SDK_VERSION";

    /* renamed from: f  reason: collision with root package name */
    public static final String f11381f = "V2_FACE_LOGIN_UIDS_TIMES";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11382g = "PKG";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11383h = "shareV2";
    public static final String i = "shareV3";
    public static final String j = "baidu.intent.action.account.SHARE_ACTIVITY";
    public static boolean k = false;
    public static List<ShareStorage.StorageModel> l;
    public static List<String> m;

    /* loaded from: classes2.dex */
    public static class a implements Comparator<Map.Entry<Intent, Integer>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
            return entry.getValue().compareTo(entry2.getValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareModelCallback f11384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, ShareModelCallback shareModelCallback) {
            super(looper);
            this.f11384a = shareModelCallback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean unused = d.k = true;
            this.f11384a.onReceiveShareModels(new ArrayList(0));
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements com.baidu.sapi2.callback.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f11385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShareModelCallback f11386b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f11387a;

            public a(List list) {
                this.f11387a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f11386b.onReceiveShareModels(this.f11387a);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f11386b.onReceiveShareModels(new ArrayList(0));
            }
        }

        public c(Handler handler, ShareModelCallback shareModelCallback) {
            this.f11385a = handler;
            this.f11386b = shareModelCallback;
        }

        @Override // com.baidu.sapi2.callback.a.b
        public void a(List<ShareStorage.StorageModel> list) {
            List unused = d.l = list;
            this.f11385a.removeCallbacksAndMessages(null);
            HashMap hashMap = new HashMap();
            hashMap.put(com.alipay.sdk.data.a.i, d.k ? "1" : "0");
            hashMap.put("status", "1");
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.s, hashMap);
            if (d.k) {
                boolean unused2 = d.k = false;
            } else {
                this.f11385a.post(new a(list));
            }
        }

        @Override // com.baidu.sapi2.callback.a.b
        public void onFailure() {
            this.f11385a.removeCallbacksAndMessages(null);
            HashMap hashMap = new HashMap();
            hashMap.put(com.alipay.sdk.data.a.i, d.k ? "1" : "0");
            hashMap.put("status", "0");
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.s, hashMap);
            if (d.k) {
                boolean unused = d.k = false;
            } else {
                this.f11385a.post(new b());
            }
        }
    }

    public static String[] b() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_DELETE_LIST);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(",");
    }

    public static List<ShareStorage.StorageModel> c() {
        JSONArray jSONArray;
        if ((System.currentTimeMillis() / 1000) - SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_TIME_SECOND <= 60) {
            String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE);
            Log.d(f11376a, "get share models from cloud cache, value=" + string);
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e2) {
                Log.e(f11376a, e2.getMessage());
                jSONArray = null;
            }
            if (jSONArray != null) {
                return ShareStorage.StorageModel.a(jSONArray);
            }
        }
        return null;
    }

    public static List<ShareStorage.StorageModel> d() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_SHARE_STORAGE);
        if (!TextUtils.isEmpty(string)) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(string, SapiContext.getInstance().getAccountEncryptKey());
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(decryptAccountInfo);
                } catch (Exception e2) {
                    Log.e(f11376a, e2.getMessage());
                }
                return ShareStorage.StorageModel.a(jSONArray);
            }
        }
        Log.e(f11376a, "getShareStorage result is null");
        return new ArrayList(0);
    }

    public static List<ShareStorage.StorageModel> e() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(f11376a, "config initialShareStrategy is DISABLED");
            return new ArrayList(0);
        }
        List<ShareStorage.StorageModel> d2 = d();
        String[] b2 = b();
        if (d2 != null && d2.size() > 0 && b2 != null && b2.length > 0) {
            Log.d(f11376a, "shareModels has value, deleteModels has value");
            Iterator<ShareStorage.StorageModel> it = d2.iterator();
            while (it.hasNext()) {
                ShareStorage.StorageModel next = it.next();
                for (String str : b2) {
                    if (!TextUtils.isEmpty(next.url) && next.url.contains(str)) {
                        try {
                            it.remove();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return d2;
    }

    public static void f() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        Context context = confignation.context;
        if (SapiUtils.isOnline(context) && confignation.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            ArrayList arrayList = new ArrayList();
            List<Intent> a2 = a(context);
            if (a2.size() == 0) {
                SapiContext.getInstance().setShareStorage(null);
                SapiContext.getInstance().setBaiduAppPkgList(null);
                return;
            }
            ShareStorage shareStorage = new ShareStorage();
            HashSet hashSet = new HashSet();
            for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getLoginAccounts()) {
                hashSet.add(sapiAccount.displayname);
            }
            int size = a2.size();
            int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
            int i2 = 1;
            Log.d(f11376a, "current login env is " + ordinal);
            StringBuilder sb = new StringBuilder();
            if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
                StatService.onEventAutoStat(com.baidu.sapi2.share.c.f11369b);
            }
            int i3 = size;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (Intent intent : a2) {
                String packageName = intent.getComponent().getPackageName();
                sb.append(packageName);
                sb.append(",");
                ShareStorage.StorageModel a3 = shareStorage.a(packageName);
                if (a3 == null) {
                    i4++;
                } else {
                    Object[] objArr = new Object[i2];
                    objArr[0] = packageName + " env=" + a3.f11335c + " flag=" + a3.flag + " displayName=" + a3.displayname;
                    Log.d(f11376a, objArr);
                    if (a3.f11335c != ordinal) {
                        i3--;
                    } else {
                        int i7 = a3.f11334b;
                        if (i7 == 0) {
                            i5++;
                        } else if (i7 == 1) {
                            i6++;
                        }
                        if (a3.flag == 0 && !hashSet.contains(a3.displayname)) {
                            arrayList.add(a3);
                            hashSet.add(a3.displayname);
                        }
                    }
                    i2 = 1;
                }
            }
            Object[] objArr2 = new Object[i2];
            objArr2[0] = "share storage model result size=" + arrayList.size();
            Log.d(f11376a, objArr2);
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            SapiContext.getInstance().setBaiduAppPkgList(sb.toString());
            SapiContext.getInstance().setShareStorage(ShareStorage.StorageModel.toJSONArray(arrayList));
            SapiStatUtil.statShareV2OpenMax(context, i4, i5, i6, i3, shareStorage, arrayList);
        }
    }

    public static List<Intent> a(Context context) {
        return a(context, context.getPackageManager().queryIntentActivities(new Intent(j), 32), j);
    }

    public static void b(SapiConfiguration sapiConfiguration) {
        if (!SapiContext.getInstance().isFirstLaunch() || sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return;
        }
        new com.baidu.sapi2.share.a().a(4);
    }

    public static List<Intent> a(Context context, List<ResolveInfo> list, String str) {
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
                            if (a(context, intent.getComponent().getPackageName()) && !context.getPackageName().equals(intent.getComponent().getPackageName())) {
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
                Collections.sort(arrayList2, new a());
                for (Map.Entry entry : arrayList2) {
                    arrayList.add(entry.getKey());
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
        return arrayList;
    }

    public static List<ShareStorage.StorageModel> b(int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ShareStorage shareStorage = new ShareStorage();
        for (String str : list) {
            ShareStorage.StorageModel modelFromSd = shareStorage.getModelFromSd(str);
            if (modelFromSd != null && !TextUtils.isEmpty(modelFromSd.displayname) && !TextUtils.isEmpty(modelFromSd.url) && i2 == modelFromSd.f11335c) {
                arrayList.add(modelFromSd);
            }
        }
        return arrayList;
    }

    public static boolean a(SapiConfiguration sapiConfiguration) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String str : arrayList) {
            if (sapiConfiguration.context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
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

    public static void a(String str) {
        String[] b2 = b();
        StringBuilder sb = new StringBuilder();
        for (int length = b2.length + 1 > 10 ? (b2.length + 1) - 10 : 0; length < b2.length; length++) {
            sb.append(b2[length]);
            sb.append(",");
        }
        sb.append(str);
        SapiContext.getInstance().put(SapiContext.KEY_SHARE_DELETE_LIST, sb.toString());
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        if (activity != null) {
            if (f11383h.equals(str5)) {
                com.baidu.sapi2.share.a.l = new a.c();
                List<ShareStorage.StorageModel> e2 = e();
                int i2 = 0;
                while (true) {
                    if (i2 < e2.size()) {
                        if (e2.get(i2).pkg.equals(str) && e2.get(i2).url.equals(str2)) {
                            a.c cVar = com.baidu.sapi2.share.a.l;
                            cVar.f11356a = i2;
                            cVar.f11357b = e2.get(i2).tpl;
                            com.baidu.sapi2.share.a.l.f11358c = e2.get(i2).app;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                SapiStatUtil.statShareV2Click(com.baidu.sapi2.share.a.l, list, str6);
            } else {
                SapiStatUtil.statInvokeCloudShareAccount(3);
            }
            if (!TextUtils.isEmpty(str) && SapiUtils.isAppInstalled(activity, str)) {
                ComponentName componentName = new ComponentName(str, "com.baidu.sapi2.activity.ShareActivity");
                Intent intent = new Intent();
                intent.putExtra("android.intent.extra.TEXT", str2);
                intent.putExtra(com.baidu.sapi2.share.a.f11343b, str4);
                intent.putExtra(com.baidu.sapi2.share.a.f11342a, str3);
                intent.putExtra(com.baidu.sapi2.share.a.f11344c, str5);
                intent.putExtra(com.baidu.sapi2.share.a.f11345d, str6);
                intent.setComponent(componentName);
                activity.startActivityForResult(intent, 20001);
                return;
            }
            Toast.makeText(activity, "登录失败", 0).show();
            return;
        }
        throw new IllegalArgumentException("loginActivity can't be null");
    }

    public static void a(a.b bVar, int i2, int i3, Intent intent, com.baidu.sapi2.share.a aVar, List<PassNameValuePair> list, String str) {
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
        if (bVar != null) {
            Context context = SapiAccountManager.getInstance().getConfignation().context;
            String str9 = "";
            String stringExtra = intent != null ? intent.getStringExtra(com.baidu.sapi2.share.a.f11344c) : "";
            char c2 = 2;
            if (i3 == -1 && intent != null) {
                SapiAccount sapiAccount = (SapiAccount) intent.getParcelableExtra("share_account");
                if (sapiAccount != null) {
                    if (intent.getIntExtra("SDK_VERSION", 0) >= 190) {
                        e.a().a(sapiAccount, intent.getStringExtra("PKG"));
                    } else {
                        sapiAccount.app = "";
                    }
                    str8 = sapiAccount.uid;
                    SapiContext sapiContext = SapiContext.getInstance();
                    sapiContext.setCurrentAccount(sapiAccount);
                    sapiContext.addLoginAccount(sapiAccount);
                    aVar.a(2);
                    sapiContext.setAccountActionType(com.baidu.sapi2.share.a.k);
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
                    sapiContext.put(SapiContext.KEY_PRE_LOGIN_TYPE, com.baidu.sapi2.share.a.k);
                    bVar.onSuccess();
                    str7 = "";
                    c2 = 0;
                } else {
                    Toast.makeText(context, "互通登录失败,请稍后再试", 0).show();
                    bVar.onFailed(-207, "互通登录失败,请稍后再试");
                    str7 = "-3007";
                    str8 = "";
                    c2 = 1;
                    str9 = com.baidu.sapi2.share.b.f11366g;
                }
                str6 = str7;
                str4 = str9;
                str5 = str8;
            } else {
                if (intent != null) {
                    str3 = intent.getStringExtra("share_fail_code");
                    str2 = intent.getStringExtra("share_fail_reason");
                    Toast.makeText(context, str2, 0).show();
                } else {
                    str2 = "result data is null";
                    str3 = "";
                }
                bVar.onFailed(-207, "互通登录失败,请稍后再试");
                str4 = str2;
                str5 = "";
                str6 = str3;
            }
            if (i.equals(stringExtra)) {
                if (c2 == 0) {
                    SapiStatUtil.statInvokeCloudShareAccount(4);
                    return;
                } else {
                    SapiStatUtil.statInvokeCloudShareAccount(5);
                    return;
                }
            } else if (c2 == 0) {
                SapiStatUtil.statShareV2Success(com.baidu.sapi2.share.a.l, str5, list, str);
                return;
            } else {
                SapiStatUtil.statShareV2Fail(com.baidu.sapi2.share.a.l, str6, str4, str5, list, str);
                return;
            }
        }
        throw new IllegalArgumentException("and shareLoginCallBack can't be null");
    }

    public static void a(long j2, Context context, String str, ShareModelCallback shareModelCallback) {
        List<ShareStorage.StorageModel> d2 = d();
        if (d2 != null && d2.size() > 0) {
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.n);
            shareModelCallback.onReceiveShareModels(d2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<Intent> a2 = a(context);
        if (a2 != null && a2.size() > 0) {
            for (Intent intent : a2) {
                arrayList.add(intent.getComponent().getPackageName());
            }
        }
        if (arrayList.size() <= 0) {
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.o);
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
            return;
        }
        int ordinal = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
        List<ShareStorage.StorageModel> a3 = a(ordinal, arrayList);
        if (a3 != null && a3.size() > 0) {
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.p);
            shareModelCallback.onReceiveShareModels(a3);
            return;
        }
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", context)) {
            List<ShareStorage.StorageModel> b2 = b(ordinal, arrayList);
            if (b2 != null && b2.size() > 0) {
                StatService.onEventAutoStat(com.baidu.sapi2.share.c.q);
                shareModelCallback.onReceiveShareModels(b2);
                return;
            }
        } else {
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.r);
        }
        if (l != null && m != null && arrayList.size() == m.size()) {
            shareModelCallback.onReceiveShareModels(l);
            StatService.onEventAutoStat(com.baidu.sapi2.share.c.t);
            return;
        }
        b bVar = new b(Looper.getMainLooper(), shareModelCallback);
        bVar.sendEmptyMessageDelayed(0, j2);
        String packageName = context.getPackageName();
        SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
        m = arrayList;
        if (gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_MODEL_FROM_SERVER).isMeetGray()) {
            SapiAccountManager.getInstance().getAccountService().getShareV3App(str, arrayList, packageName, new c(bVar, shareModelCallback));
        }
    }

    public static List<ShareStorage.StorageModel> a(int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ShareStorage shareStorage = new ShareStorage();
        for (String str : list) {
            ShareStorage.StorageModel modelFromSp = shareStorage.getModelFromSp(str);
            if (modelFromSp != null && !TextUtils.isEmpty(modelFromSp.displayname) && !TextUtils.isEmpty(modelFromSp.url) && i2 == modelFromSp.f11335c) {
                arrayList.add(modelFromSp);
            }
        }
        return arrayList;
    }
}
