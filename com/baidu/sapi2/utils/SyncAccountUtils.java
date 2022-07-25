package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SyncAccountUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DISPLAYNAME = "displayname";
    public static final String KEY_DISPLAYNAME_TO_NA = "displayname_to_na";
    public static final String KEY_PORTRAIT_SIGN = "portraitSign";
    public static final String KEY_USERNAME = "username";
    public static final String TAG = "SyncAccountUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public SyncAccountUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b A[Catch: JSONException -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0083, blocks: (B:8:0x0014, B:10:0x0025, B:22:0x004b, B:24:0x0057, B:28:0x0062, B:30:0x006e, B:35:0x007b, B:16:0x0034, B:18:0x0040), top: B:46:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean syncAccount(String str, SapiAccount sapiAccount) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        String optString;
        String optString2;
        String optString3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, sapiAccount)) == null) {
            boolean z = false;
            if (str == null) {
                Log.e(TAG, "data is null, please check FE sync data is OK");
                return false;
            }
            try {
                jSONObject = new JSONObject(str);
                optString = jSONObject.optString(KEY_DISPLAYNAME_TO_NA);
                try {
                } catch (JSONException e) {
                    e = e;
                    z = true;
                    e.printStackTrace();
                    return z;
                }
            } catch (JSONException e2) {
                e = e2;
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
        return invokeLL.booleanValue;
    }
}
