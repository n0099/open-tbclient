package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.FileUtil;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareStorage {
    private static final String a = "sapi_share";
    private static final String b = ".BD_SAPI_CACHE/.sapi_temp/";
    private static final String c = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
    private static final String d = "w0d4o27mh3k1e461";
    private static final String e = "2314906973403010";
    private static final int f = 5;
    private Context g = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes.dex */
    public interface a {
        void a(StorageModel storageModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        StorageModel.a(this.g, z, new a() { // from class: com.baidu.sapi2.share.ShareStorage.1
            @Override // com.baidu.sapi2.share.ShareStorage.a
            public void a(final StorageModel storageModel) {
                ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.ShareStorage.1.1
                    @Override // java.lang.Runnable
                    @TargetApi(8)
                    public void run() {
                        String str;
                        if (SapiAccountManager.getInstance().getConfignation().loginShareStrategy() == LoginShareStrategy.DISABLED) {
                            storageModel.b = 1;
                        }
                        String md5 = MD5Util.toMd5(ShareStorage.this.g.getPackageName().getBytes(), false);
                        try {
                            str = new String(Base64.encode(new AES().encrypt(storageModel.a().toString(), ShareStorage.e, ShareStorage.d), 0));
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

    public void setSp(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.g.getSharedPreferences(a, 5);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public String getSp(String str) {
        try {
            return this.g.getSharedPreferences(a, 5).getString(str, "");
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    public String getSp(String str, String str2) {
        try {
            return this.g.createPackageContext(str, 2).getSharedPreferences(a, 5).getString(str2, "");
        } catch (Exception e2) {
            Log.e(e2);
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
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sp, 0), e, d))));
            a2.c = 0;
            return a2;
        } catch (Exception e2) {
            Log.e(e2);
            return null;
        }
    }

    public void setSd(String str, String str2) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.g)) {
                File file = new File(Environment.getExternalStorageDirectory(), b + str);
                if (TextUtils.isEmpty(str2)) {
                    FileUtil.deleteFile(file);
                } else {
                    FileUtil.write(file, str2.getBytes(), false);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public String getSd(String str) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.g)) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + b + str;
                if (FileUtil.isFileExist(str2)) {
                    return FileUtil.read(str2);
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            Log.e(e2);
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
            StorageModel a2 = StorageModel.a(new JSONObject(new String(new AES().decrypt(Base64.decode(sd, 0), e, d))));
            a2.c = 1;
            return a2;
        } catch (Exception e2) {
            Log.e(e2);
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
        public String url;

        private StorageModel() {
        }

        static StorageModel a(JSONObject jSONObject) {
            StorageModel storageModel = new StorageModel();
            storageModel.url = jSONObject.optString("url");
            storageModel.displayname = jSONObject.optString("displayname");
            storageModel.app = jSONObject.optString("app");
            storageModel.a = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString("pkg");
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
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("uid", this.a);
                jSONObject.put("pkg", this.pkg);
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
                            storageModel2.url = ShareStorage.c;
                        } else {
                            storageModel2.url = getUserInfoResult.portraitHttps;
                        }
                        SapiContext.getInstance(context).put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel2.url);
                        storageModel2.displayname = session2.displayname;
                        storageModel2.app = SapiUtils.getAppName(context);
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
