package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SyncAccountUtils implements NoProguard {
    public static final String KEY_DISPLAYNAME = "displayname";
    public static final String KEY_DISPLAYNAME_TO_NA = "displayname_to_na";
    public static final String KEY_PORTRAIT_SIGN = "portraitSign";
    public static final String KEY_USERNAME = "username";
    public static final String TAG = "SyncAccountUtils";

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079 A[Catch: JSONException -> 0x0081, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0081, blocks: (B:6:0x0010, B:8:0x0021, B:20:0x0047, B:22:0x0054, B:26:0x005f, B:28:0x006c, B:33:0x0079, B:14:0x0030, B:16:0x003c), top: B:38:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean syncAccount(String str, SapiAccount sapiAccount) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        String optString3;
        boolean z = false;
        if (str == null) {
            Log.e(TAG, "data is null, please check FE sync data is OK");
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString(KEY_DISPLAYNAME_TO_NA);
        } catch (JSONException e) {
            e = e;
        }
        try {
        } catch (JSONException e2) {
            e = e2;
            z = true;
            e.printStackTrace();
            return z;
        }
        if (!TextUtils.isEmpty(optString) && !optString.equals(sapiAccount.displayname)) {
            sapiAccount.displayname = optString;
        } else {
            String optString4 = jSONObject.optString("displayname");
            if (!TextUtils.isEmpty(optString4) && !optString4.equals(sapiAccount.displayname)) {
                sapiAccount.displayname = optString4;
            }
            optString2 = jSONObject.optString("username");
            if (!TextUtils.isEmpty(optString2) && !optString2.equals(sapiAccount.username)) {
                sapiAccount.username = optString2;
                z = true;
            }
            optString3 = jSONObject.optString(KEY_PORTRAIT_SIGN);
            if (!TextUtils.isEmpty(optString3) && !optString3.equals(sapiAccount.portrait)) {
                sapiAccount.portrait = optString3;
                z = true;
            }
            if (z) {
                SapiAccountManager.getInstance().validate(sapiAccount);
            }
            return z;
        }
        z = true;
        optString2 = jSONObject.optString("username");
        if (!TextUtils.isEmpty(optString2)) {
            sapiAccount.username = optString2;
            z = true;
        }
        optString3 = jSONObject.optString(KEY_PORTRAIT_SIGN);
        if (!TextUtils.isEmpty(optString3)) {
            sapiAccount.portrait = optString3;
            z = true;
        }
        if (z) {
        }
        return z;
    }
}
