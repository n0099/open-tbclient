package com.baidu.searchbox.schemeauthenticate;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.common.util.crypto.rsa.EncryptTool;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.codec.binary4util.bdapp.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = "public_scheme", module = "scheme")
/* loaded from: classes4.dex */
public class SchemeWhiteListListener extends JSONObjectCommandListener {
    public static final String ACTION = "public_scheme";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_SCHEME_WHITE_LIST_ARRAY = "white_list_array";
    public static final String KEY_SCHEME_WHITE_LIST_PREFIX_ARRAY = "white_list_prefix_array";
    public static final String PUBLIC_SCHEME_ASSET_PATH = "scheme/public_scheme";
    public static final String PUBLIC_SCHEME_VERSION = "public_scheme_v";
    public static final String TAG = "public_scheme";

    public static String bdsDecrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(NativeBds.dae(str2, Base64.decode(str, 11)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String bdsEncrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(NativeBds.ae(str2, str), 11));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Set<String> getSchemeWhiteListSet(Context context) {
        String bdsDecrypt;
        if (!TextUtils.equals(DefaultSharedPrefsWrapper.getInstance().getString(PUBLIC_SCHEME_VERSION, "0"), "0")) {
            String readCacheData = FileUtils.readCacheData(context, KEY_SCHEME_WHITE_LIST_ARRAY);
            bdsDecrypt = null;
            if (!TextUtils.isEmpty(readCacheData)) {
                EncryptTool.getInstance().init(context);
                try {
                    EncryptTool.CryptResult decrypt = EncryptTool.getInstance().decrypt(Base64.decode(readCacheData, 11));
                    if (decrypt.getStatusCode() == 0) {
                        bdsDecrypt = new String(decrypt.getResult(), "UTF-8");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bdsDecrypt == null) {
                FileUtils.deleteCache(context, KEY_SCHEME_WHITE_LIST_ARRAY);
                DefaultSharedPrefsWrapper.getInstance().remove(PUBLIC_SCHEME_VERSION);
            }
        } else {
            bdsDecrypt = bdsDecrypt(FileUtils.readAssetData(context, PUBLIC_SCHEME_ASSET_PATH), "public_scheme");
        }
        if (!TextUtils.isEmpty(bdsDecrypt)) {
            try {
                JSONArray jSONArray = new JSONArray(bdsDecrypt);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(removeSchemeVersion(jSONArray.getString(i)));
                }
                return hashSet;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new HashSet();
    }

    public static ArrayList<String> getSchemeWhitePrefixList(Context context) {
        String str = null;
        if (!TextUtils.equals(DefaultSharedPrefsWrapper.getInstance().getString(PUBLIC_SCHEME_VERSION, "0"), "0")) {
            String readCacheData = FileUtils.readCacheData(context, KEY_SCHEME_WHITE_LIST_PREFIX_ARRAY);
            if (!TextUtils.isEmpty(readCacheData)) {
                EncryptTool.getInstance().init(context);
                try {
                    EncryptTool.CryptResult decrypt = EncryptTool.getInstance().decrypt(Base64.decode(readCacheData, 11));
                    if (decrypt.getStatusCode() == 0) {
                        str = new String(decrypt.getResult(), "UTF-8");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (str == null) {
                FileUtils.deleteCache(context, KEY_SCHEME_WHITE_LIST_PREFIX_ARRAY);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(removeSchemeVersion(jSONArray.getString(i)));
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static String removeSchemeVersion(String str) {
        String[] split = str.split("/");
        if (split.length > 0 && split[0].startsWith("v") && UnitedSchemeUtility.isContainNumber(split[0])) {
            return str.substring(split[0].length() + 1);
        }
        return str;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put("public_scheme", getLocalVersion(context, str, str2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        JSONObject jSONObject;
        String str3;
        EncryptTool.CryptResult encrypt;
        if (actionData != null && TextUtils.equals(str2, "public_scheme") && !TextUtils.isEmpty(actionData.version) && (jSONObject = actionData.data) != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SCHEME_WHITE_LIST_ARRAY);
            String str4 = null;
            if (optJSONArray != null) {
                String jSONArray = optJSONArray.toString();
                EncryptTool.getInstance().init(context);
                try {
                    encrypt = EncryptTool.getInstance().encrypt(jSONArray.getBytes("UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (encrypt.getStatusCode() == 0) {
                    str3 = new String(Base64.encode(encrypt.getResult(), 11), "UTF-8");
                    if (str3 != null) {
                        FileUtils.cache(context, KEY_SCHEME_WHITE_LIST_ARRAY, str3, 0);
                    }
                }
                str3 = null;
                if (str3 != null) {
                }
            } else {
                str3 = null;
            }
            JSONArray optJSONArray2 = actionData.data.optJSONArray(KEY_SCHEME_WHITE_LIST_PREFIX_ARRAY);
            if (optJSONArray2 != null) {
                String jSONArray2 = optJSONArray2.toString();
                EncryptTool.getInstance().init(context);
                try {
                    EncryptTool.CryptResult encrypt2 = EncryptTool.getInstance().encrypt(jSONArray2.getBytes("UTF-8"));
                    if (encrypt2.getStatusCode() == 0) {
                        str4 = new String(Base64.encode(encrypt2.getResult(), 11), "UTF-8");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (str4 != null) {
                    FileUtils.cache(context, KEY_SCHEME_WHITE_LIST_PREFIX_ARRAY, str4, 0);
                }
            }
            if (str3 != null || str4 != null) {
                DefaultSharedPrefsWrapper.getInstance().putString(PUBLIC_SCHEME_VERSION, actionData.version);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(PUBLIC_SCHEME_VERSION, "0");
    }
}
