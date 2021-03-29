package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.g;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareStorage {
    public static final int SHARE_ACCOUNT_BACKGROUND_TO_FOREGROUND = 1;
    public static final int SHARE_ACCOUNT_GET_TPL_STOKEN = 5;
    public static final int SHARE_ACCOUNT_INIT = 0;
    public static final int SHARE_ACCOUNT_LOGIN = 2;
    public static final int SHARE_ACCOUNT_LOGOUT = 3;
    public static final int SHARE_ACCOUNT_RESET = 4;

    /* renamed from: b  reason: collision with root package name */
    public static final String f11326b = "sapi_share";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11327c = ".BD_SAPI_CACHE/.sapi_temp/";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11328d = ".BD_SAPI_CACHE/";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11329e = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + g.t;

    /* renamed from: f  reason: collision with root package name */
    public static final String f11330f = "w0d4o27mh3k1e461";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11331g = "2314906973403010";

    /* renamed from: h  reason: collision with root package name */
    public static int f11332h = 5;
    public boolean readSpFromChmodFile = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f11333a = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes2.dex */
    public static class StorageModel {

        /* renamed from: a  reason: collision with root package name */
        public String f11334a;
        public String app;

        /* renamed from: b  reason: collision with root package name */
        public int f11335b;

        /* renamed from: c  reason: collision with root package name */
        public int f11336c;
        public String displayname;
        public int flag;
        public String pkg;
        public String tpl;
        public String url;

        /* loaded from: classes2.dex */
        public static class a extends GetUserInfoCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f11337a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f11338b;

            public a(b bVar, Context context) {
                this.f11337a = bVar;
                this.f11338b = context;
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                StorageModel storageModel = new StorageModel(null);
                storageModel.flag = 1;
                this.f11337a.a(storageModel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                StorageModel storageModel = new StorageModel(null);
                storageModel.flag = 1;
                this.f11337a.a(storageModel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                StorageModel storageModel = new StorageModel(null);
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                    storageModel.url = ShareStorage.f11329e;
                } else {
                    storageModel.url = getUserInfoResult.portraitHttps;
                }
                SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
                storageModel.displayname = currentAccount.displayname;
                storageModel.app = SapiUtils.getAppName(this.f11338b);
                storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel.pkg = this.f11338b.getPackageName();
                storageModel.f11334a = UUID.randomUUID().toString();
                storageModel.flag = 0;
                storageModel.f11336c = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                this.f11337a.a(storageModel);
            }
        }

        public /* synthetic */ StorageModel(a aVar) {
            this();
        }

        public static List<StorageModel> a(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        StorageModel fromJSON = fromJSON(jSONArray.getJSONObject(i));
                        if (fromJSON != null && !TextUtils.isEmpty(fromJSON.displayname) && !TextUtils.isEmpty(fromJSON.url)) {
                            arrayList.add(fromJSON);
                        }
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                return arrayList;
            }
            return new ArrayList(0);
        }

        public static StorageModel fromJSON(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            String optString = jSONObject.optString("url");
            storageModel.url = optString;
            if (TextUtils.isEmpty(optString)) {
                storageModel.url = jSONObject.optString("portrait");
            }
            storageModel.displayname = jSONObject.optString("displayname");
            storageModel.app = jSONObject.optString("app");
            storageModel.tpl = jSONObject.optString("tpl");
            storageModel.f11334a = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString("pkg");
            storageModel.flag = jSONObject.optInt("flag", -1);
            storageModel.f11336c = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        public static JSONArray toJSONArray(List<StorageModel> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (StorageModel storageModel : list) {
                JSONObject a2 = storageModel.a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            return jSONArray;
        }

        public StorageModel() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("uid", this.f11334a);
                jSONObject.put("pkg", this.pkg);
                jSONObject.put("flag", this.flag);
                jSONObject.put("env", this.f11336c);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        public static void a(Context context, int i, b bVar) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null || currentAccount.isGuestAccount()) {
                StorageModel storageModel = new StorageModel();
                storageModel.flag = 1;
                bVar.a(storageModel);
            } else if (i != 0 && i != 1) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new a(bVar, context), SapiContext.getInstance().getCurrentAccount().bduss);
            } else {
                StorageModel storageModel2 = new StorageModel();
                storageModel2.displayname = currentAccount.displayname;
                storageModel2.url = SapiContext.getInstance().getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel2.app = SapiUtils.getAppName(context);
                storageModel2.pkg = context.getPackageName();
                storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel2.f11334a = UUID.randomUUID().toString();
                storageModel2.flag = 0;
                storageModel2.f11336c = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                bVar.a(storageModel2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11339a;

        /* renamed from: com.baidu.sapi2.share.ShareStorage$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0144a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ StorageModel f11341a;

            public RunnableC0144a(StorageModel storageModel) {
                this.f11341a = storageModel;
            }

            @Override // java.lang.Runnable
            @TargetApi(8)
            public void run() {
                String str;
                if (SapiAccountManager.getInstance().getConfignation().loginShareStrategy() == LoginShareStrategy.DISABLED) {
                    this.f11341a.flag = 1;
                }
                String md5 = SecurityUtil.md5(ShareStorage.this.f11333a.getPackageName().getBytes(), false);
                try {
                    str = new String(Base64.encode(SecurityUtil.aesEncrypt(this.f11341a.a().toString(), ShareStorage.f11331g, ShareStorage.f11330f), 0));
                } catch (Exception e2) {
                    Log.e(e2);
                    str = "";
                }
                ShareStorage.this.setSp(md5, str);
                ShareStorage.this.setSd(md5, str);
                int i = a.this.f11339a;
                if (i == 2 || i == 3 || i == 4) {
                    a aVar = a.this;
                    ShareStorage.this.a(aVar.f11339a, this.f11341a);
                }
            }
        }

        public a(int i) {
            this.f11339a = i;
        }

        @Override // com.baidu.sapi2.share.ShareStorage.b
        public void a(StorageModel storageModel) {
            ThreadPoolService.getInstance().run(new TPRunnable(new RunnableC0144a(storageModel)));
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(StorageModel storageModel);
    }

    public ShareStorage() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration == null || sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED) {
            return;
        }
        f11332h = 4;
    }

    private boolean b() {
        int i = SapiContext.getInstance().getInt(SapiContext.KEY_SHARE_INTERNAL_GRAY, -1);
        if (i == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i = random.nextInt(100);
            SapiContext.getInstance().put(SapiContext.KEY_SHARE_INTERNAL_GRAY, i);
        }
        return i <= SapiContext.getInstance().getShareInternalGray();
    }

    @TargetApi(8)
    public StorageModel getModelFromSd(String str) {
        try {
            String sd = getSd(SecurityUtil.md5(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from sd_card pkg=");
            sb.append(str);
            sb.append(" value is ");
            sb.append(TextUtils.isEmpty(sd) ? SchemeCollecter.CLASSIFY_EMPTY : "not empty");
            objArr[0] = sb.toString();
            Log.d(d.f11377a, objArr);
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sd, 0), f11331g, f11330f))));
            fromJSON.f11335b = 1;
            return fromJSON;
        } catch (Exception e2) {
            Log.e(d.f11377a, e2.getMessage());
            return null;
        }
    }

    public StorageModel getModelFromSp(String str) {
        try {
            String sp = getSp(str, SecurityUtil.md5(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from share_preferences pkg=");
            sb.append(str);
            sb.append(" value is ");
            sb.append(TextUtils.isEmpty(sp) ? SchemeCollecter.CLASSIFY_EMPTY : "not empty");
            objArr[0] = sb.toString();
            Log.d(d.f11377a, objArr);
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sp, 0), f11331g, f11330f))));
            fromJSON.f11335b = 0;
            return fromJSON;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSd(String str) {
        try {
        } catch (Exception e2) {
            Log.e(d.f11377a, e2.getMessage());
        }
        if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.f11333a)) {
            Log.d(d.f11377a, "getSd is not has READ_EXTERNAL_STORAGE permission");
            return null;
        }
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + f11327c + str;
        if (com.baidu.sapi2.utils.b.a(str2)) {
            Log.d(d.f11377a, "getSd filePath=" + str2);
            return com.baidu.sapi2.utils.b.b(str2);
        }
        return null;
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public void set(int i) {
        StorageModel.a(this.f11333a, i, new a(i));
    }

    public boolean setSd(String str, String str2) {
        try {
            if (SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.f11333a)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, f11327c + str);
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.sapi2.utils.b.a(file);
                    return true;
                }
                com.baidu.sapi2.utils.b.a(file, str2.getBytes(), false);
                return true;
            }
            return false;
        } catch (IOException unused) {
            return false;
        }
    }

    @TargetApi(4)
    public boolean setSp(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.f11333a.getSharedPreferences(f11326b, f11332h);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable unused) {
            if (Build.VERSION.SDK_INT >= 24 && this.f11333a.getApplicationInfo().targetSdkVersion >= 24 && b() && !SapiContext.getInstance().getResetFileExecPer()) {
                try {
                    File file = new File(this.f11333a.getApplicationInfo().dataDir + "/" + f11328d + str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        SapiContext.getInstance().setModifiedDirExecPer(e.a(this.f11333a, file));
                    }
                    if (!SapiContext.getInstance().getModifiedDirExecPer()) {
                        boolean a2 = e.a(this.f11333a, file);
                        Log.i(d.f11377a, "chmodFileSuc", Boolean.valueOf(a2));
                        SapiContext.getInstance().setModifiedDirExecPer(a2);
                    }
                    com.baidu.sapi2.utils.b.a(file, str2.getBytes(), false);
                    return true;
                } catch (Throwable th) {
                    Log.e(th);
                    return false;
                }
            }
            Log.i(d.f11377a, "meetShareInternalGray false");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        String string;
        if (Build.VERSION.SDK_INT < 24) {
            if (TextUtils.isEmpty(str)) {
                sharedPreferences = this.f11333a.getSharedPreferences(f11326b, f11332h);
            } else {
                try {
                    sharedPreferences = this.f11333a.createPackageContext(str, 2).getSharedPreferences(f11326b, f11332h);
                } catch (Exception e2) {
                    Log.e(d.f11377a, e2.getMessage());
                }
            }
            string = sharedPreferences != null ? sharedPreferences.getString(str2, "") : null;
            if (TextUtils.isEmpty(string)) {
                string = a(str, str2);
                if (!TextUtils.isEmpty(string)) {
                    this.readSpFromChmodFile = true;
                }
            }
            return string;
        }
        sharedPreferences = null;
        if (sharedPreferences != null) {
        }
        if (TextUtils.isEmpty(string)) {
        }
        return string;
    }

    public StorageModel a(String str) {
        StorageModel modelFromSp = getModelFromSp(str);
        return modelFromSp == null ? getModelFromSd(str) : modelFromSp;
    }

    @TargetApi(4)
    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = this.f11333a.getPackageName();
        }
        String str3 = this.f11333a.getApplicationInfo().dataDir;
        String str4 = (str3.replace(this.f11333a.getPackageName(), "") + str) + "/" + f11328d + str2;
        Log.e(d.f11377a, "getDataFromShareInternal", "fileName", str4);
        return com.baidu.sapi2.utils.b.b(str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, StorageModel storageModel) {
        SapiAccountManager.getInstance().getAccountService().setCloudShareAccount(i, storageModel);
    }
}
