package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
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
/* loaded from: classes.dex */
public class ShareStorage {
    private static final String a = "sapi_share";
    private static final String b = ".BD_SAPI_CACHE/.sapi_temp/";
    private static final String c = ".BD_SAPI_CACHE/";
    private static final String e = "w0d4o27mh3k1e461";
    private static final String f = "2314906973403010";
    private static final int g = 5;
    public static final String TAG = ShareStorage.class.getSimpleName();
    private static final String d = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
    public boolean readSpFromChmodFile = false;
    private Context h = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes.dex */
    public interface a {
        void a(StorageModel storageModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        StorageModel.a(this.h, z, new a() { // from class: com.baidu.sapi2.share.ShareStorage.1
            @Override // com.baidu.sapi2.share.ShareStorage.a
            public void a(final StorageModel storageModel) {
                ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.ShareStorage.1.1
                    @Override // java.lang.Runnable
                    @TargetApi(8)
                    public void run() {
                        String str;
                        LoginShareStrategy loginShareStrategy = SapiAccountManager.getInstance().getConfignation().loginShareStrategy();
                        String loginShareDirection = SapiAccountManager.getInstance().getConfignation().loginShareDirection();
                        if (loginShareStrategy == LoginShareStrategy.DISABLED || ShareDirectionType.IMPORT.equals(loginShareDirection)) {
                            storageModel.b = 1;
                        }
                        String md5 = MD5Util.toMd5(ShareStorage.this.h.getPackageName().getBytes(), false);
                        try {
                            str = new String(Base64.encode(new AES().encrypt(storageModel.a().toString(), ShareStorage.f, ShareStorage.e), 0));
                        } catch (Exception e2) {
                            Log.e(e2);
                            str = "";
                        }
                        ShareStorage.this.setSp(md5, str);
                        ShareStorage.this.setSd(md5, str);
                    }
                }));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageModel a(String str) {
        StorageModel b2 = b(str);
        if (b2 == null) {
            return c(str);
        }
        return b2;
    }

    @TargetApi(4)
    public boolean setSp(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.h.getSharedPreferences(a, 5);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT < 24 || this.h.getApplicationInfo().targetSdkVersion < 24 || !b() || SapiContext.getInstance(this.h).getResetFileExecPer()) {
                Log.i(TAG, "meetShareInternalGray false");
                return false;
            }
            try {
                File file = new File(this.h.getApplicationInfo().dataDir + "/" + c + str);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                    SapiContext.getInstance(this.h).setModifiedDirExecPer(SapiCoreUtil.chmodFile(this.h, file));
                }
                if (!SapiContext.getInstance(this.h).getModifiedDirExecPer()) {
                    boolean chmodFile = SapiCoreUtil.chmodFile(this.h, file);
                    Log.i(TAG, "chmodFileSuc", Boolean.valueOf(chmodFile));
                    SapiContext.getInstance(this.h).setModifiedDirExecPer(chmodFile);
                }
                FileUtil.write(file, str2.getBytes(), false);
                return true;
            } catch (Throwable th2) {
                Log.e(th2);
                return false;
            }
        }
    }

    private boolean b() {
        int i = SapiContext.getInstance(this.h).getInt(SapiContext.KEY_SHARE_INTERNAL_GRAY, -1);
        if (i == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i = random.nextInt(100);
            SapiContext.getInstance(this.h).put(SapiContext.KEY_SHARE_INTERNAL_GRAY, i);
        }
        return i <= SapiContext.getInstance(this.h).getShareInternalGray();
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        try {
            if (TextUtils.isEmpty(str)) {
                sharedPreferences = this.h.getSharedPreferences(a, 5);
            } else {
                sharedPreferences = this.h.createPackageContext(str, 2).getSharedPreferences(a, 5);
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

    @TargetApi(4)
    private String a(String str, String str2) {
        Log.e(TAG, "getDataFromShareInternal");
        if (TextUtils.isEmpty(str)) {
            str = this.h.getPackageName();
        }
        String str3 = (this.h.getApplicationInfo().dataDir.replace(this.h.getPackageName(), "") + str) + "/" + c + str2;
        Log.e(TAG, "getDataFromShareInternal", "fileName", str3);
        try {
            return FileUtil.read(str3);
        } catch (Throwable th) {
            Log.e(th);
            return null;
        }
    }

    @TargetApi(8)
    private StorageModel b(String str) {
        try {
            String sp = getSp(str, MD5Util.toMd5(str.getBytes(), false));
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sp, 0), f, e))));
            a2.c = 0;
            return a2;
        } catch (Exception e2) {
            return null;
        }
    }

    public boolean setSd(String str, String str2) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.h)) {
                File file = new File(Environment.getExternalStorageDirectory(), b + str);
                if (TextUtils.isEmpty(str2)) {
                    FileUtil.deleteFile(file);
                } else {
                    FileUtil.write(file, str2.getBytes(), false);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public String getSd(String str) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.h)) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + b + str;
                if (FileUtil.isFileExist(str2)) {
                    return FileUtil.read(str2);
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    @TargetApi(8)
    private StorageModel c(String str) {
        try {
            String sd = getSd(MD5Util.toMd5(str.getBytes(), false));
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sd, 0), f, e))));
            a2.c = 1;
            return a2;
        } catch (Exception e2) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class StorageModel {
        String a;
        public String app;
        int b;
        int c;
        int d;
        public String displayname;
        public String pkg;
        public String tpl;
        public String url;

        private StorageModel() {
        }

        static StorageModel a(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            storageModel.url = jSONObject.optString("url");
            storageModel.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
            storageModel.app = jSONObject.optString("app");
            storageModel.tpl = jSONObject.optString("tpl");
            storageModel.a = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString(Config.INPUT_DEF_PKG);
            storageModel.b = jSONObject.optInt(FrsActivityConfig.FLAG, -1);
            storageModel.d = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static List<StorageModel> a(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return new ArrayList(0);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    StorageModel a = a(jSONArray.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return arrayList;
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
                jSONObject.put(FrsActivityConfig.FLAG, this.b);
                jSONObject.put("env", this.d);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        public static JSONArray toJSONArray(List<StorageModel> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (StorageModel storageModel : list) {
                JSONObject a = storageModel.a();
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            return jSONArray;
        }

        static void a(final Context context, boolean z, final a aVar) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null && !session.isGuestAccount()) {
                if (z) {
                    StorageModel storageModel = new StorageModel();
                    storageModel.displayname = session.displayname;
                    storageModel.url = SapiContext.getInstance(context).getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                    storageModel.app = SapiUtils.getAppName(context);
                    storageModel.pkg = context.getPackageName();
                    storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                    storageModel.a = UUID.randomUUID().toString();
                    storageModel.b = 0;
                    storageModel.d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                    aVar.a(storageModel);
                    return;
                }
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.share.ShareStorage.StorageModel.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        storageModel2.b = 1;
                        a.this.a(storageModel2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        SapiAccount session2 = SapiAccountManager.getInstance().getSession();
                        if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                            storageModel2.url = ShareStorage.d;
                        } else {
                            storageModel2.url = getUserInfoResult.portraitHttps;
                        }
                        SapiContext.getInstance(context).put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel2.url);
                        storageModel2.displayname = session2.displayname;
                        storageModel2.app = SapiUtils.getAppName(context);
                        storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                        storageModel2.pkg = context.getPackageName();
                        storageModel2.a = UUID.randomUUID().toString();
                        storageModel2.b = 0;
                        storageModel2.d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                        a.this.a(storageModel2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        storageModel2.b = 1;
                        a.this.a(storageModel2);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, SapiAccountManager.getInstance().getSession().bduss);
                return;
            }
            StorageModel storageModel2 = new StorageModel();
            storageModel2.b = 1;
            aVar.a(storageModel2);
        }
    }
}
