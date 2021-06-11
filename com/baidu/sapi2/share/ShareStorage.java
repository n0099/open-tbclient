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
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
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
    public static final String DEFAULT_PORTRAIT = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
    public static final String KEY_SHARE_MODELS_AES_IV = "key_pass_share_models_iv";
    public static final String KEY_SHARE_MODELS_AES_KEY = "key_pass_hare_models_key";
    public static int MODE = 5;
    public static final String SD_FILE_NAME = ".BD_SAPI_CACHE/.sapi_temp/";
    public static final int SHARE_ACCOUNT_BACKGROUND_TO_FOREGROUND = 1;
    public static final int SHARE_ACCOUNT_GET_TPL_STOKEN = 5;
    public static final int SHARE_ACCOUNT_INIT = 0;
    public static final int SHARE_ACCOUNT_LOGIN = 2;
    public static final int SHARE_ACCOUNT_LOGOUT = 3;
    public static final int SHARE_ACCOUNT_RESET = 4;
    public static final String SP_FILE_NAME = "sapi_share";
    public static final String SP_FILE_PATH = ".BD_SAPI_CACHE/";
    public String mAesIv;
    public String mAesKey;
    public boolean readSpFromChmodFile = false;
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes2.dex */
    public interface CallBack {
        void call(StorageModel storageModel);
    }

    /* loaded from: classes2.dex */
    public static class StorageModel {
        public String app;
        public String displayname;
        public int env;
        public int flag;
        public String pkg;
        public String tpl;
        public String url;
        public String uuid;
        public int where;

        public static void buildFromSystem(final Context context, int i2, final CallBack callBack) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null || currentAccount.isGuestAccount()) {
                StorageModel storageModel = new StorageModel();
                storageModel.flag = 1;
                callBack.call(storageModel);
            } else if (i2 != 0 && i2 != 1) {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.share.ShareStorage.StorageModel.1
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        storageModel2.flag = 1;
                        CallBack.this.call(storageModel2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        storageModel2.flag = 1;
                        CallBack.this.call(storageModel2);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        StorageModel storageModel2 = new StorageModel();
                        SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
                        if (TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                            storageModel2.url = ShareStorage.DEFAULT_PORTRAIT;
                        } else {
                            storageModel2.url = getUserInfoResult.portraitHttps;
                        }
                        SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel2.url);
                        storageModel2.displayname = currentAccount2.displayname;
                        storageModel2.app = SapiUtils.getAppName(context);
                        storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                        storageModel2.pkg = context.getPackageName();
                        storageModel2.uuid = UUID.randomUUID().toString();
                        storageModel2.flag = 0;
                        storageModel2.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                        CallBack.this.call(storageModel2);
                    }
                }, SapiContext.getInstance().getCurrentAccount().bduss);
            } else {
                StorageModel storageModel2 = new StorageModel();
                storageModel2.displayname = currentAccount.displayname;
                storageModel2.url = SapiContext.getInstance().getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel2.app = SapiUtils.getAppName(context);
                storageModel2.pkg = context.getPackageName();
                storageModel2.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel2.uuid = UUID.randomUUID().toString();
                storageModel2.flag = 0;
                storageModel2.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                callBack.call(storageModel2);
            }
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
            storageModel.uuid = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString("pkg");
            storageModel.flag = jSONObject.optInt("flag", -1);
            storageModel.env = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        public static List<StorageModel> fromJSONArray(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        StorageModel fromJSON = fromJSON(jSONArray.getJSONObject(i2));
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

        public static JSONArray toJSONArray(List<StorageModel> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (StorageModel storageModel : list) {
                JSONObject json = storageModel.toJSON();
                if (json != null) {
                    jSONArray.put(json);
                }
            }
            return jSONArray;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("uid", this.uuid);
                jSONObject.put("pkg", this.pkg);
                jSONObject.put("flag", this.flag);
                jSONObject.put("env", this.env);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }

        public StorageModel() {
        }
    }

    public ShareStorage() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            MODE = 4;
        }
        SapiContext.getInstance().put(KEY_SHARE_MODELS_AES_KEY, "w0d4o27mh3k1e461");
        SapiContext.getInstance().put(KEY_SHARE_MODELS_AES_IV, "2314906973403010");
        this.mAesKey = SapiContext.getInstance().getString(KEY_SHARE_MODELS_AES_KEY);
        this.mAesIv = SapiContext.getInstance().getString(KEY_SHARE_MODELS_AES_IV);
    }

    @TargetApi(4)
    private String getDataFromShareInternal(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = this.context.getPackageName();
        }
        String str3 = this.context.getApplicationInfo().dataDir;
        String str4 = (str3.replace(this.context.getPackageName(), "") + str) + "/" + SP_FILE_PATH + str2;
        Log.e(ShareUtils.TAG, "getDataFromShareInternal", "fileName", str4);
        return FileUtil.read(str4);
    }

    private boolean meetShareInternalGray() {
        int i2 = SapiContext.getInstance().getInt(SapiContext.KEY_SHARE_INTERNAL_GRAY, -1);
        if (i2 == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i2 = random.nextInt(100);
            SapiContext.getInstance().put(SapiContext.KEY_SHARE_INTERNAL_GRAY, i2);
        }
        return i2 <= SapiContext.getInstance().getShareInternalGray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCloud(int i2, StorageModel storageModel) {
        SapiAccountManager.getInstance().getAccountService().setCloudShareAccount(i2, storageModel);
    }

    public void asyncSet(final int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.ShareStorage.1
            @Override // java.lang.Runnable
            public void run() {
                ShareStorage.this.syncSet(i2);
            }
        }));
    }

    public StorageModel get(String str) {
        StorageModel modelFromSp = getModelFromSp(str);
        return modelFromSp == null ? getModelFromSd(str) : modelFromSp;
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
            sb.append(TextUtils.isEmpty(sd) ? "empty" : "not empty");
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (TextUtils.isEmpty(sd)) {
                return null;
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sd, 0), this.mAesIv, this.mAesKey))));
            fromJSON.where = 1;
            return fromJSON;
        } catch (Exception e2) {
            Log.e(ShareUtils.TAG, e2.getMessage());
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
            sb.append(TextUtils.isEmpty(sp) ? "empty" : "not empty");
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (TextUtils.isEmpty(sp)) {
                return null;
            }
            StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sp, 0), this.mAesIv, this.mAesKey))));
            fromJSON.where = 0;
            return fromJSON;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSd(String str) {
        try {
        } catch (Exception e2) {
            Log.e(ShareUtils.TAG, e2.getMessage());
        }
        if (!SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this.context)) {
            Log.d(ShareUtils.TAG, "getSd is not has READ_EXTERNAL_STORAGE permission");
            return null;
        }
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + File.separator + SD_FILE_NAME + str;
        if (FileUtil.isFileExist(str2)) {
            Log.d(ShareUtils.TAG, "getSd filePath=" + str2);
            return FileUtil.read(str2);
        }
        return null;
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public boolean setSd(String str, String str2) {
        try {
            if (SapiUtils.checkRequestPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, this.context)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, SD_FILE_NAME + str);
                if (TextUtils.isEmpty(str2)) {
                    FileUtil.deleteFile(file);
                    return true;
                }
                FileUtil.write(file, str2.getBytes(), false);
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
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(SP_FILE_NAME, MODE);
            if (Build.VERSION.SDK_INT > 8) {
                sharedPreferences.edit().putString(str, str2).apply();
            } else {
                sharedPreferences.edit().putString(str, str2).commit();
            }
            return true;
        } catch (Throwable unused) {
            if (Build.VERSION.SDK_INT >= 24 && this.context.getApplicationInfo().targetSdkVersion >= 24 && meetShareInternalGray() && !SapiContext.getInstance().getResetFileExecPer()) {
                try {
                    File file = new File(this.context.getApplicationInfo().dataDir + "/" + SP_FILE_PATH + str);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        SapiContext.getInstance().setModifiedDirExecPer(SapiCoreUtil.chmodFile(this.context, file));
                    }
                    if (!SapiContext.getInstance().getModifiedDirExecPer()) {
                        boolean chmodFile = SapiCoreUtil.chmodFile(this.context, file);
                        Log.i(ShareUtils.TAG, "chmodFileSuc", Boolean.valueOf(chmodFile));
                        SapiContext.getInstance().setModifiedDirExecPer(chmodFile);
                    }
                    FileUtil.write(file, str2.getBytes(), false);
                    return true;
                } catch (Throwable th) {
                    Log.e(th);
                    return false;
                }
            }
            Log.i(ShareUtils.TAG, "meetShareInternalGray false");
            return false;
        }
    }

    public void syncSet(final int i2) {
        StorageModel.buildFromSystem(this.context, i2, new CallBack() { // from class: com.baidu.sapi2.share.ShareStorage.2
            @Override // com.baidu.sapi2.share.ShareStorage.CallBack
            public void call(StorageModel storageModel) {
                String str;
                if (SapiAccountManager.getInstance().getConfignation().loginShareStrategy() == LoginShareStrategy.DISABLED) {
                    storageModel.flag = 1;
                }
                String md5 = SecurityUtil.md5(ShareStorage.this.context.getPackageName().getBytes(), false);
                try {
                    str = new String(Base64.encode(SecurityUtil.aesEncrypt(storageModel.toJSON().toString(), ShareStorage.this.mAesIv, ShareStorage.this.mAesKey), 0));
                } catch (Exception e2) {
                    Log.e(e2);
                    str = "";
                }
                ShareStorage.this.setSp(md5, str);
                ShareStorage.this.setSd(md5, str);
                int i3 = i2;
                if (i3 == 2 || i3 == 3 || i3 == 4) {
                    ShareStorage.this.setCloud(i2, storageModel);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        String string;
        if (Build.VERSION.SDK_INT < 24) {
            if (TextUtils.isEmpty(str)) {
                sharedPreferences = this.context.getSharedPreferences(SP_FILE_NAME, MODE);
            } else {
                try {
                    sharedPreferences = this.context.createPackageContext(str, 2).getSharedPreferences(SP_FILE_NAME, MODE);
                } catch (Exception e2) {
                    Log.e(ShareUtils.TAG, e2.getMessage());
                }
            }
            string = sharedPreferences != null ? sharedPreferences.getString(str2, "") : null;
            if (TextUtils.isEmpty(string)) {
                string = getDataFromShareInternal(str, str2);
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
}
