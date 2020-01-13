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
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
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
/* loaded from: classes5.dex */
public class ShareStorage {
    public static final String TAG = "ShareStorage";
    private static final String a = "sapi_share";
    private static final String b = ".BD_SAPI_CACHE/.sapi_temp/";
    private static final String c = ".BD_SAPI_CACHE/";
    private static final String d = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + com.baidu.sapi2.utils.f.D;
    private static final String e = "w0d4o27mh3k1e461";
    private static final String f = "2314906973403010";
    private static final int g = 5;
    public boolean readSpFromChmodFile = false;
    private Context h = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes5.dex */
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

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ StorageModel(t tVar) {
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
            storageModel.b = jSONObject.optInt(FrsActivityConfig.FLAG, -1);
            storageModel.d = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
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
                JSONObject a = storageModel.a();
                if (a != null) {
                    jSONArray.put(a);
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
            return new ArrayList(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public JSONObject a() {
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

        static void a(Context context, boolean z, a aVar) {
            SapiAccount currentAccount = SapiContext.getInstance(context).getCurrentAccount();
            if (currentAccount == null || currentAccount.isGuestAccount()) {
                StorageModel storageModel = new StorageModel();
                storageModel.b = 1;
                aVar.a(storageModel);
            } else if (z) {
                StorageModel storageModel2 = new StorageModel();
                storageModel2.displayname = currentAccount.displayname;
                storageModel2.url = SapiContext.getInstance(context).getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel2.app = SapiUtils.getAppName(context);
                storageModel2.pkg = context.getPackageName();
                storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel2.a = UUID.randomUUID().toString();
                storageModel2.b = 0;
                storageModel2.d = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                aVar.a(storageModel2);
            } else {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new u(aVar, context), SapiContext.getInstance(context).getCurrentAccount().bduss);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(StorageModel storageModel);
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

    @TargetApi(8)
    private StorageModel c(String str) {
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

    public String getSd(String str) {
        try {
            if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.h)) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + b + str;
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
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.h)) {
                File file = new File(Environment.getExternalStorageDirectory(), b + str);
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
            SharedPreferences sharedPreferences = this.h.getSharedPreferences(a, 5);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 24 && this.h.getApplicationInfo().targetSdkVersion >= 24 && b() && !SapiContext.getInstance(this.h).getResetFileExecPer()) {
                try {
                    File file = new File(this.h.getApplicationInfo().dataDir + "/" + c + str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        SapiContext.getInstance(this.h).setModifiedDirExecPer(com.baidu.sapi2.utils.e.a(this.h, file));
                    }
                    if (!SapiContext.getInstance(this.h).getModifiedDirExecPer()) {
                        boolean a2 = com.baidu.sapi2.utils.e.a(this.h, file);
                        String str3 = TAG;
                        Object[] objArr = new Object[2];
                        objArr[0] = "chmodFileSuc";
                        objArr[1] = Boolean.valueOf(a2);
                        Log.i(str3, objArr);
                        SapiContext.getInstance(this.h).setModifiedDirExecPer(a2);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        StorageModel.a(this.h, z, new t(this));
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
            str = this.h.getPackageName();
        }
        String str3 = (this.h.getApplicationInfo().dataDir.replace(this.h.getPackageName(), "") + str) + "/" + c + str2;
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
}
