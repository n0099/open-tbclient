package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class SapiShareClient {
    public static final String EXTRA_APP_PKG = "PKG";
    public static final String EXTRA_FACE_LOGIN_MODEL = "FACE_LOGIN_MODEL";
    public static final String EXTRA_V2_FACE_LOGIN_UIDS = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final int MAX_SHARE_ACCOUNTS = 5;
    static final String a = "LOGIN_SHARE_MODEL";
    static final String b = "RUNTIME_ENVIRONMENT";
    static final String c = "SDK_VERSION";
    static final String d = "EXTRA_OTHER_INFO";
    static final String e = "IQIYI_TOKEN";
    static final String f = "VEHICLE_SYSTEM";
    static final String g = "baidu.intent.action.account.SHARE_SERVICE";
    static final String h = "baidu.intent.action.account.SHARE_ACTIVITY";
    private volatile int l = 0;
    private volatile boolean m = true;
    private static final SapiShareClient k = new SapiShareClient();
    private static SapiConfiguration i = SapiAccountManager.getInstance().getSapiConfiguration();
    private static SapiContext j = SapiContext.getInstance(i.context);

    private SapiShareClient() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(SapiShareClient sapiShareClient) {
        int i2 = sapiShareClient.l;
        sapiShareClient.l = i2 - 1;
        return i2;
    }

    public static SapiShareClient getInstance() {
        return k;
    }

    public static boolean isInReceiveOtherInfoWhiteList(String str) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.sapi2.(.*)");
        for (String str2 : arrayList) {
            if (str.matches(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInShareBlackList() {
        if (i.enableShare) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        return arrayList.contains(i.context.getPackageName());
    }

    public static boolean isInShareOtherInfoWhiteList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tv.pps.mobile");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.baidu.sapi2.demo.standard");
        return arrayList.contains(i.context.getPackageName());
    }

    public static boolean isInV2ShareDisableWhiteList() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        for (String str : arrayList) {
            if (i.context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static void syncShareAccounts() {
        if (j.isFirstLaunch()) {
            if (i.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                d();
            }
        } else if (j.isLoginStatusChanged() || i.loginShareStrategy() != LoginShareStrategy.SILENT) {
        } else {
            d();
        }
    }

    public List<ShareStorage.StorageModel> getShareStorageModel(Context context) {
        if (i.loginShareStrategy() != LoginShareStrategy.DISABLED && !com.baidu.sapi2.utils.enums.a.b.equals(i.loginShareDirection())) {
            return x.c(context);
        }
        return new ArrayList(0);
    }

    @TargetApi(5)
    public void invalidate(SapiAccount sapiAccount) {
        if (sapiAccount != null && !sapiAccount.isGuestAccount() && i.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            j.removeShareAccount(sapiAccount);
            if (!isInShareBlackList() && !c() && !com.baidu.sapi2.utils.enums.a.a.equals(i.loginShareDirection())) {
                HandlerThread handlerThread = new HandlerThread("InvalidateThread");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                handler.post(new f(this, x.e(i.context), handler, sapiAccount, handlerThread));
            }
        }
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        Application application;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                application = (Application) context;
            } catch (Exception e2) {
                Log.e(e2);
                application = null;
            }
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new j(this));
            }
        }
    }

    public void validate(SapiAccount sapiAccount) {
        if (SapiUtils.isValidAccount(sapiAccount)) {
            k.a().d(sapiAccount);
            j.setCurrentAccount(sapiAccount);
            SapiAccountManager.getInstance().preFetchStoken(sapiAccount, false);
            j.addLoginAccount(sapiAccount);
            new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.h);
            new ShareStorage().a(false);
            j.removeShareAccount(sapiAccount);
            if (i.loginShareStrategy() == LoginShareStrategy.DISABLED || sapiAccount.getAccountType() == AccountType.INCOMPLETE_USER || isInShareBlackList() || c()) {
                return;
            }
            a(sapiAccount, x.e(i.context), false);
        }
    }

    public void validateOtherInfo() {
        List<Intent> e2 = x.e(i.context);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= e2.size()) {
                break;
            }
            Intent intent = e2.get(i3);
            if (isInReceiveOtherInfoWhiteList(intent.getComponent().getPackageName())) {
                arrayList.add(intent);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() == 0) {
            return;
        }
        a(null, arrayList, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(SapiShareClient sapiShareClient) {
        int i2 = sapiShareClient.l;
        sapiShareClient.l = i2 + 1;
        return i2;
    }

    static boolean c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.input_huawei");
        arrayList.add("com.baidu.input_yijia");
        arrayList.add("com.baidu.browser.apps");
        return arrayList.contains(i.context.getPackageName());
    }

    @TargetApi(5)
    private static void d() {
        if (!c() && !com.baidu.sapi2.utils.enums.a.b.equals(i.loginShareDirection())) {
            HandlerThread handlerThread = new HandlerThread("SyncThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new i(x.e(i.context), (i.loginShareStrategy() == LoginShareStrategy.DISABLED || i.loginShareStrategy() == LoginShareStrategy.CHOICE) ? false : true, handler, handlerThread));
        }
    }

    @TargetApi(5)
    void a(SapiAccount sapiAccount, List<Intent> list, boolean z) {
        if (!com.baidu.sapi2.utils.enums.a.a.equals(i.loginShareDirection()) && !sapiAccount.isGuestAccount()) {
            HandlerThread handlerThread = new HandlerThread("ValidateThread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new c(this, list, handler, sapiAccount, z, handlerThread));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Parcel a(ShareModel shareModel, boolean z) {
        Parcel obtain = Parcel.obtain();
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putBoolean(d, true);
            bundle.putString(e, SapiContext.getInstance(i.context).getIqiyiAccesstoken());
        } else if (x.a()) {
            bundle.putBoolean(f, true);
        }
        if (SapiContext.getInstance(i.context).shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance(i.context).getV2FaceLivingUnames());
        }
        SapiConfiguration sapiConfiguration = i;
        x.a(sapiConfiguration.context, sapiConfiguration.loginShareStrategy(), shareModel);
        bundle.putString("PKG", i.context.getPackageName());
        bundle.putParcelable(a, shareModel);
        bundle.putSerializable(b, i.environment);
        bundle.putInt("SDK_VERSION", SapiAccountManager.VERSION_CODE);
        obtain.writeBundle(bundle);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Parcel parcel) {
        if (parcel != null) {
            try {
                Bundle readBundle = parcel.readBundle(ShareModel.class.getClassLoader());
                if (readBundle != null) {
                    ShareModel shareModel = (ShareModel) readBundle.getParcelable(a);
                    boolean z = readBundle.getBoolean(f, false);
                    String string = readBundle.getString("PKG");
                    x.a(i.context, i.loginShareStrategy(), shareModel, readBundle.getInt("SDK_VERSION"), null, false, z, string);
                    if (SapiContext.getInstance(i.context).shareLivingunameEnable()) {
                        ArrayList arrayList = new ArrayList();
                        String string2 = readBundle.getString("V2_FACE_LOGIN_UIDS_TIMES");
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.addAll(new FaceLoginService().str2ShareModelV2List(string2));
                        }
                        if (!arrayList.isEmpty()) {
                            new FaceLoginService().syncFaceLoginUidList(i.context, arrayList);
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
