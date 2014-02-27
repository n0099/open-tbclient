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
public class GetPackageInfo implements NoProGuard, n {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 1;
    private static final String TAG = "GetPackageInfo";
    private int mErrcode = -1;
    Context mContext = null;

    public GetPackageInfo() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        ArrayList<PackageInfo> arrayList;
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() <= 0) {
            a.a(-1);
            return;
        }
        String str = (String) a.get("callback");
        a.d((String) a.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return;
        }
        String str2 = (String) a.get("packagename");
        if (TextUtils.isEmpty(str2)) {
            a.a(-1);
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        a.b(this.mContext.getPackageName());
        a.c(str2);
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            arrayList = com.baidu.android.nebula.d.a.a.a(this.mContext).b(str2);
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
        aVar.a("text/javascript");
        aVar.a().put("Cache-Control", "no-cache");
        aVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
        aVar.a(200);
        a.a(this.mErrcode);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void writeToStatic() {
        m.a().a(this.mContext, a.toString());
    }
}
