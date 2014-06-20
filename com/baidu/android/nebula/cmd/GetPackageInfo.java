package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetPackageInfo implements NoProGuard, d {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 1;
    private static final String TAG = "GetPackageInfo";
    private int mErrcode = -1;
    Context mContext = null;

    public GetPackageInfo() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        ArrayList<PackageInfo> arrayList;
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return null;
        }
        String str2 = (String) map2.get("packagename");
        if (TextUtils.isEmpty(str2)) {
            a.a(-1);
            return null;
        }
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        a.b(this.mContext.getPackageName());
        a.c(str2);
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            arrayList = com.baidu.android.nebula.d.a.a.a(this.mContext).a(str2, true);
        } else {
            arrayList = null;
        }
        JSONObject jSONObject = new JSONObject();
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (PackageInfo packageInfo : arrayList) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("version_name", packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put("package_state", packageInfo.applicationInfo.enabled ? 1 : 0);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("package_infos", jSONArray);
                    this.mErrcode = 0;
                }
            } catch (JSONException e) {
            }
        }
        jSONObject.put("error", this.mErrcode);
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str + " && " + str + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
