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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.kuaishou.weapon.p0.h;
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
    public static final int CODE_APP_IS_NOT_ONLINE = -102;
    public static final int CODE_APP_SHARE_IS_DISABLED = -103;
    public static final int CODE_DEVICE_DO_NOT_FIND_OTHER_BAIDU_APP = -104;
    public static final int CODE_DEVICE_DO_NOT_FIND_SHARE_DATA = -105;
    public static final int CODE_GET_DATA_FROM_CLOUD_TIMEOUT = -106;
    public static final int CODE_PASS_HAS_NOT_INIT = -101;
    public static final String DEFAULT_PORTRAIT = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
    public static final String KEY_SHARE_MODELS_AES_IV = "key_pass_share_models_iv";
    public static final String KEY_SHARE_MODELS_AES_KEY = "key_pass_hare_models_key";
    public static int MODE = 5;
    public static final String MSG_APP_IS_NOT_ONLINE = "当前APP不是Release线上";
    public static final String MSG_APP_SHARE_IS_DISABLED = "当前APP配置不支持互通";
    public static final String MSG_DEVICE_DO_NOT_FIND_OTHER_BAIDU_APP = "当前设备未安装其他支持互通的百度产品";
    public static final String MSG_DEVICE_DO_NOT_FIND_SHARE_DATA = "当前设备存在互通产品但是获取不到互通信息(1、互通APP未登录 2、互通APP 或 当前APP未打开文件权限)";
    public static final String MSG_GET_DATA_FROM_CLOUD_TIMEOUT = "云端互通获取超时";
    public static final String MSG_PASS_HAS_NOT_INIT = "Pass SDK未初始化";
    public static final String SD_FILE_NAME = ".BD_SAPI_CACHE/.sapi_temp/";
    public static final int SHARE_ACCOUNT_BACKGROUND_TO_FOREGROUND = 1;
    public static final int SHARE_ACCOUNT_GET_TPL_STOKEN = 5;
    public static final int SHARE_ACCOUNT_INIT = 0;
    public static final int SHARE_ACCOUNT_LOGIN = 2;
    public static final int SHARE_ACCOUNT_LOGOUT = 3;
    public static final int SHARE_ACCOUNT_RESET = 4;
    public static final String SP_FILE_NAME = "sapi_share";
    public static final String SP_FILE_PATH = ".BD_SAPI_CACHE/";
    public String[] mSmaks = {"w", "0", "d", "4", "o", "2", "7", "m", "h", "3", "k", "1", "e", "4", "6", "1"};
    public String[] mSmais = {"2", "3", "1", "4", "9", "0", "6", "9", "7", "3", "4", "0", "3", "0", "1", "0"};
    public boolean readSpFromChmodFile = false;
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    /* loaded from: classes2.dex */
    public interface CallBack {
        void call(StorageModel storageModel);
    }

    /* loaded from: classes2.dex */
    public static class StorageModel {
        public String app;
        public String bduss;
        public String displayname;
        public int env;
        public int flag;
        public String pkg;
        public String tpl;
        public String url;
        public String uuid;
        public int where;

        public StorageModel() {
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

        public static void buildFromSystem(final Context context, int i, final CallBack callBack) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null && !currentAccount.isGuestAccount()) {
                if (i != 0 && i != 1) {
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
                            StorageModel storageModel = new StorageModel();
                            storageModel.flag = 1;
                            CallBack.this.call(storageModel);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFailure(GetUserInfoResult getUserInfoResult) {
                            StorageModel storageModel = new StorageModel();
                            storageModel.flag = 1;
                            CallBack.this.call(storageModel);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onSuccess(GetUserInfoResult getUserInfoResult) {
                            StorageModel storageModel = new StorageModel();
                            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
                            if (!TextUtils.isEmpty(getUserInfoResult.portraitHttps)) {
                                storageModel.url = getUserInfoResult.portraitHttps;
                            } else {
                                storageModel.url = ShareStorage.DEFAULT_PORTRAIT;
                            }
                            SapiContext.getInstance().put(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT, storageModel.url);
                            storageModel.displayname = currentAccount2.displayname;
                            storageModel.app = SapiUtils.getAppName(context);
                            storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                            storageModel.bduss = currentAccount2.bduss;
                            storageModel.pkg = context.getPackageName();
                            storageModel.uuid = UUID.randomUUID().toString();
                            storageModel.flag = 0;
                            storageModel.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                            CallBack.this.call(storageModel);
                        }
                    }, SapiContext.getInstance().getCurrentAccount().bduss);
                    return;
                }
                StorageModel storageModel = new StorageModel();
                storageModel.displayname = currentAccount.displayname;
                storageModel.url = SapiContext.getInstance().getString(SapiContext.KEY_LAST_LOGIN_USER_PORTRAIT);
                storageModel.app = SapiUtils.getAppName(context);
                storageModel.pkg = context.getPackageName();
                storageModel.tpl = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
                storageModel.bduss = currentAccount.bduss;
                storageModel.uuid = UUID.randomUUID().toString();
                storageModel.flag = 0;
                storageModel.env = SapiAccountManager.getInstance().getConfignation().environment.ordinal();
                callBack.call(storageModel);
                return;
            }
            StorageModel storageModel2 = new StorageModel();
            storageModel2.flag = 1;
            callBack.call(storageModel2);
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
            storageModel.bduss = jSONObject.optString("bduss");
            storageModel.uuid = jSONObject.optString("uid");
            storageModel.pkg = jSONObject.optString("pkg");
            storageModel.flag = jSONObject.optInt("flag", -1);
            storageModel.env = jSONObject.optInt("env", Domain.DOMAIN_ONLINE.ordinal());
            return storageModel;
        }

        public static List<StorageModel> fromJSONArray(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        StorageModel fromJSON = fromJSON(jSONArray.getJSONObject(i));
                        if (fromJSON != null && !TextUtils.isEmpty(fromJSON.displayname) && !TextUtils.isEmpty(fromJSON.url)) {
                            arrayList.add(fromJSON);
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                }
                return arrayList;
            }
            return new ArrayList(0);
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("app", this.app);
                jSONObject.put("tpl", this.tpl);
                jSONObject.put("bduss", this.bduss);
                jSONObject.put("uid", this.uuid);
                jSONObject.put("pkg", this.pkg);
                jSONObject.put("flag", this.flag);
                jSONObject.put("env", this.env);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    public ShareStorage() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            MODE = 4;
        }
    }

    public void asyncSet(final int i) {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.ShareStorage.1
            @Override // java.lang.Runnable
            public void run() {
                ShareStorage.this.syncSet(i);
            }
        }));
    }

    public StorageModel get(String str) {
        StorageModel modelFromSp = getModelFromSp(str);
        if (modelFromSp == null) {
            return getModelFromSd(str);
        }
        return modelFromSp;
    }

    public String getSp(String str) {
        return getSp(null, str);
    }

    public void syncSet(final int i) {
        StorageModel.buildFromSystem(this.context, i, new CallBack() { // from class: com.baidu.sapi2.share.ShareStorage.2
            @Override // com.baidu.sapi2.share.ShareStorage.CallBack
            public void call(StorageModel storageModel) {
                String str;
                if (SapiAccountManager.getInstance().getConfignation().loginShareStrategy() == LoginShareStrategy.DISABLED) {
                    storageModel.flag = 1;
                }
                String md5 = SecurityUtil.md5(ShareStorage.this.context.getPackageName().getBytes(), false);
                try {
                    StringBuilder sb = new StringBuilder();
                    if (ShareStorage.this.mSmais != null) {
                        for (String str2 : ShareStorage.this.mSmais) {
                            sb.append(str2);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    if (ShareStorage.this.mSmaks != null) {
                        for (String str3 : ShareStorage.this.mSmaks) {
                            sb2.append(str3);
                        }
                    }
                    str = new String(Base64.encode(SecurityUtil.aesEncrypt(storageModel.toJSON().toString(), sb.toString(), sb2.toString()), 0));
                } catch (Exception e) {
                    Log.e(e);
                    str = "";
                }
                ShareStorage.this.setSp(md5, str);
                ShareStorage.this.setSd(md5, str);
                int i2 = i;
                if (i2 != 2 && i2 != 3 && i2 != 4) {
                    return;
                }
                ShareStorage.this.setCloud(i, storageModel);
            }
        });
    }

    @TargetApi(4)
    private String getDataFromShareInternal(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = this.context.getPackageName();
        }
        String str3 = this.context.getApplicationInfo().dataDir;
        String str4 = (str3.replace(this.context.getPackageName(), "") + str) + "/" + SP_FILE_PATH + str2;
        Log.e(ShareUtils.TAG, "getDataFromShareInternal", CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME, str4);
        return FileUtil.read(str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSp(String str, String str2) {
        SharedPreferences sharedPreferences;
        String str3 = null;
        if (Build.VERSION.SDK_INT < 24) {
            if (TextUtils.isEmpty(str)) {
                sharedPreferences = this.context.getSharedPreferences(SP_FILE_NAME, MODE);
            } else {
                try {
                    sharedPreferences = this.context.createPackageContext(str, 2).getSharedPreferences(SP_FILE_NAME, MODE);
                } catch (Exception e) {
                    Log.e(ShareUtils.TAG, e.getMessage());
                }
            }
            if (sharedPreferences != null) {
                str3 = sharedPreferences.getString(str2, "");
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = getDataFromShareInternal(str, str2);
                if (!TextUtils.isEmpty(str3)) {
                    this.readSpFromChmodFile = true;
                }
            }
            return str3;
        }
        sharedPreferences = null;
        if (sharedPreferences != null) {
        }
        if (TextUtils.isEmpty(str3)) {
        }
        return str3;
    }

    public boolean setSd(String str, String str2) {
        File file;
        try {
            if (!SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.context)) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                File externalCacheDir = this.context.getExternalCacheDir();
                file = new File(externalCacheDir, SD_FILE_NAME + str);
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                file = new File(externalStorageDirectory, SD_FILE_NAME + str);
            }
            if (TextUtils.isEmpty(str2)) {
                FileUtil.deleteFile(file);
                return true;
            }
            FileUtil.write(file, str2.getBytes(), false);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean meetShareInternalGray() {
        int i = SapiContext.getInstance().getInt(SapiContext.KEY_SHARE_INTERNAL_GRAY, -1);
        if (i == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            i = random.nextInt(100);
            SapiContext.getInstance().put(SapiContext.KEY_SHARE_INTERNAL_GRAY, i);
        }
        if (i <= SapiContext.getInstance().getShareInternalGray()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCloud(int i, StorageModel storageModel) {
        SapiAccountManager.getInstance().getAccountService().setCloudShareAccount(i, storageModel);
    }

    @TargetApi(8)
    public StorageModel getModelFromSd(String str) {
        String str2;
        try {
            String sd = getSd(SecurityUtil.md5(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from sd_card pkg=");
            sb.append(str);
            sb.append(" value is ");
            if (TextUtils.isEmpty(sd)) {
                str2 = SchemeCollecter.CLASSIFY_EMPTY;
            } else {
                str2 = "not empty";
            }
            sb.append(str2);
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (!TextUtils.isEmpty(sd)) {
                StringBuilder sb2 = new StringBuilder();
                if (this.mSmais != null) {
                    for (String str3 : this.mSmais) {
                        sb2.append(str3);
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                if (this.mSmaks != null) {
                    for (String str4 : this.mSmaks) {
                        sb3.append(str4);
                    }
                }
                StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sd, 0), sb2.toString(), sb3.toString()))));
                fromJSON.where = 1;
                return fromJSON;
            }
            return null;
        } catch (Exception e) {
            Log.e(ShareUtils.TAG, e.getMessage());
            return null;
        }
    }

    public StorageModel getModelFromSp(String str) {
        String str2;
        try {
            String sp = getSp(str, SecurityUtil.md5(str.getBytes(), false));
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("get share model from share_preferences pkg=");
            sb.append(str);
            sb.append(" value is ");
            if (TextUtils.isEmpty(sp)) {
                str2 = SchemeCollecter.CLASSIFY_EMPTY;
            } else {
                str2 = "not empty";
            }
            sb.append(str2);
            objArr[0] = sb.toString();
            Log.d(ShareUtils.TAG, objArr);
            if (!TextUtils.isEmpty(sp)) {
                StringBuilder sb2 = new StringBuilder();
                if (this.mSmais != null) {
                    for (String str3 : this.mSmais) {
                        sb2.append(str3);
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                if (this.mSmaks != null) {
                    for (String str4 : this.mSmaks) {
                        sb3.append(str4);
                    }
                }
                StorageModel fromJSON = StorageModel.fromJSON(new JSONObject(new String(SecurityUtil.aesDecrypt(Base64.decode(sp, 0), sb2.toString(), sb3.toString()))));
                fromJSON.where = 0;
                return fromJSON;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getSd(String str) {
        String str2;
        try {
        } catch (Exception e) {
            Log.e(ShareUtils.TAG, e.getMessage());
        }
        if (!SapiUtils.checkRequestPermission(h.i, this.context)) {
            Log.d(ShareUtils.TAG, "getSd is not has READ_EXTERNAL_STORAGE permission");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            str2 = this.context.getExternalCacheDir().getAbsolutePath() + File.separator + SD_FILE_NAME + str;
        } else {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + SD_FILE_NAME + str;
        }
        if (FileUtil.isFileExist(str2)) {
            Log.d(ShareUtils.TAG, "getSd filePath=" + str2);
            return FileUtil.read(str2);
        }
        return null;
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
}
