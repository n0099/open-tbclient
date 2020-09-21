package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class ShareStorage {
    public static final int SHARE_ACCOUNT_BACKGROUND_TO_FOREGROUND = 1;
    public static final int SHARE_ACCOUNT_GET_TPL_STOKEN = 5;
    public static final int SHARE_ACCOUNT_INIT = 0;
    public static final int SHARE_ACCOUNT_LOGIN = 2;
    public static final int SHARE_ACCOUNT_LOGOUT = 3;
    public static final int SHARE_ACCOUNT_RESET = 4;
    public static final String TAG = "ShareStorage";
    private static final String b = "sapi_share";
    private static final String c = ".BD_SAPI_CACHE/.sapi_temp/";
    private static final String d = ".BD_SAPI_CACHE/";
    private static final String e = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.e.A;
    private static final String f = "w0d4o27mh3k1e461";
    private static final String g = "2314906973403010";
    private static final int h = 5;
    public boolean readSpFromChmodFile = false;
    private Context a = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes25.dex */
    public static class StorageModel {
        String a;
        public String app;
        int b;
        int c;
        public String displayname;
        public int flag;
        public String pkg;
        public String tpl;
        public String url;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes25.dex */
        public static class a extends GetUserInfoCallback {
            final /* synthetic */ b a;
            final /* synthetic */ Context b;

            a(b bVar, Context context) {
                this.a = bVar;
                this.b = context;
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
                this.a.a(storageModel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                StorageModel storageModel = new StorageModel(null);
                storageModel.flag = 1;
                this.a.a(storageModel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                StorageModel storageModel = new StorageModel(null);
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                    storageModel.url = ShareStorage.e;
                } else {
                    storageModel.url = getUserInfoResult.portraitHttps;
                }
                SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
                storageModel.displayname = currentAccount.displayname;
                storageModel.app = SapiUtils.getAppName(this.b);
                storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel.pkg = this.b.getPackageName();
                storageModel.a = UUID.randomUUID().toString();
                storageModel.flag = 0;
                storageModel.c = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                this.a.a(storageModel);
            }
        }

        /* synthetic */ StorageModel(a aVar) {
            this();
        }

        static StorageModel a(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            storageModel.url = jSONObject.optString("url");
            storageModel.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
            storageModel.app = jSONObject.optString("app");
            storageModel.tpl = jSONObject.optString("tpl");
            storageModel.a = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString(Config.INPUT_DEF_PKG);
            storageModel.flag = jSONObject.optInt(FrsActivityConfig.FLAG, -1);
            storageModel.c = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        private StorageModel() {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public static List<StorageModel> a(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        StorageModel a2 = a(jSONArray.getJSONObject(i));
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                }
                return arrayList;
            }
            return new ArrayList(0);
        }

        JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("uid", this.a);
                jSONObject.put(Config.INPUT_DEF_PKG, this.pkg);
                jSONObject.put(FrsActivityConfig.FLAG, this.flag);
                jSONObject.put("env", this.c);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        static void a(Context context, int i, b bVar) {
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
                storageModel2.a = UUID.randomUUID().toString();
                storageModel2.flag = 0;
                storageModel2.c = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                bVar.a(storageModel2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a implements b {
        final /* synthetic */ int a;

        /* renamed from: com.baidu.sapi2.share.ShareStorage$a$a  reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        class RunnableC0299a implements Runnable {
            final /* synthetic */ StorageModel a;

            RunnableC0299a(StorageModel storageModel) {
                this.a = storageModel;
            }

            @Override // java.lang.Runnable
            @TargetApi(8)
            public void run() {
                String str;
                LoginShareStrategy loginShareStrategy = SapiAccountManager.getInstance().getConfignation().loginShareStrategy();
                String loginShareDirection = SapiAccountManager.getInstance().getConfignation().loginShareDirection();
                if (loginShareStrategy == LoginShareStrategy.DISABLED || com.baidu.sapi2.utils.enums.a.a.equals(loginShareDirection)) {
                    this.a.flag = 1;
                }
                String md5 = SecurityUtil.md5(ShareStorage.this.a.getPackageName().getBytes(), false);
                try {
                    str = new String(Base64.encode(new AES().encrypt(this.a.a().toString(), ShareStorage.g, ShareStorage.f), 0));
                } catch (Exception e) {
                    Log.e(e);
                    str = "";
                }
                ShareStorage.this.setSp(md5, str);
                ShareStorage.this.setSd(md5, str);
                int i = a.this.a;
                if (i == 2 || i == 3 || i == 4) {
                    a aVar = a.this;
                    ShareStorage.this.a(aVar.a, this.a);
                }
            }
        }

        a(int i) {
            this.a = i;
        }

        @Override // com.baidu.sapi2.share.ShareStorage.b
        public void a(StorageModel storageModel) {
            ThreadPoolService.getInstance().run(new TPRunnable(new RunnableC0299a(storageModel)));
        }
    }

    /* loaded from: classes25.dex */
    public interface b {
        void a(StorageModel storageModel);
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
    private StorageModel c(String str) {
        try {
            String sp = getSp(str, SecurityUtil.md5(str.getBytes(), false));
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sp, 0), g, f))));
            a2.b = 0;
            return a2;
        } catch (Exception e2) {
            return null;
        }
    }

    public String getSd(String str) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.a)) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + c + str;
                if (com.baidu.sapi2.utils.a.a(str2)) {
                    return com.baidu.sapi2.utils.a.b(str2);
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public boolean setSd(String str, String str2) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.a)) {
                File file = new File(Environment.getExternalStorageDirectory(), c + str);
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.sapi2.utils.a.a(file);
                } else {
                    com.baidu.sapi2.utils.a.a(file, str2.getBytes(), false);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    @TargetApi(4)
    public boolean setSp(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences(b, 5);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 24 && this.a.getApplicationInfo().targetSdkVersion >= 24 && b() && !SapiContext.getInstance().getResetFileExecPer()) {
                try {
                    File file = new File(this.a.getApplicationInfo().dataDir + "/" + d + str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        SapiContext.getInstance().setModifiedDirExecPer(com.baidu.sapi2.utils.d.a(this.a, file));
                    }
                    if (!SapiContext.getInstance().getModifiedDirExecPer()) {
                        boolean a2 = com.baidu.sapi2.utils.d.a(this.a, file);
                        Log.i(TAG, "chmodFileSuc", Boolean.valueOf(a2));
                        SapiContext.getInstance().setModifiedDirExecPer(a2);
                    }
                    com.baidu.sapi2.utils.a.a(file, str2.getBytes(), false);
                    return true;
                } catch (Throwable th2) {
                    Log.e(th2);
                    return false;
                }
            }
            Log.i(TAG, "meetShareInternalGray false");
            return false;
        }
    }

    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            if (TextUtils.isEmpty(str)) {
                sharedPreferences = this.a.getSharedPreferences(b, 5);
            } else {
                sharedPreferences = this.a.createPackageContext(str, 2).getSharedPreferences(b, 5);
            }
            return sharedPreferences.getString(str2, "");
        } catch (Throwable th) {
            String a2 = a(str, str2);
            if (!TextUtils.isEmpty(a2)) {
                this.readSpFromChmodFile = true;
                return a2;
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        StorageModel.a(this.a, i, new a(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageModel a(String str) {
        StorageModel c2 = c(str);
        return c2 == null ? b(str) : c2;
    }

    @TargetApi(4)
    private String a(String str, String str2) {
        Log.e(TAG, "getDataFromShareInternal");
        if (TextUtils.isEmpty(str)) {
            str = this.a.getPackageName();
        }
        String str3 = (this.a.getApplicationInfo().dataDir.replace(this.a.getPackageName(), "") + str) + "/" + d + str2;
        Log.e(TAG, "getDataFromShareInternal", "fileName", str3);
        try {
            return com.baidu.sapi2.utils.a.b(str3);
        } catch (Throwable th) {
            Log.e(th);
            return null;
        }
    }

    @TargetApi(8)
    private StorageModel b(String str) {
        try {
            String sd = getSd(SecurityUtil.md5(str.getBytes(), false));
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sd, 0), g, f))));
            a2.b = 1;
            return a2;
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, StorageModel storageModel) {
        SapiAccountManager.getInstance().getAccountService().setCloudShareAccount(i, storageModel);
    }
}
