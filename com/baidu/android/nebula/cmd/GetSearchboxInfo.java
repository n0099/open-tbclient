package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetSearchboxInfo implements NoProGuard, n {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 1;
    public static final String PKGNAME_PREFIX = "com.baidu.searchbox";
    private static final String TAG = "GetSearchboxInfo";
    private int mErrcode = -1;
    Context mContext = null;

    public GetSearchboxInfo() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() < 1) {
            a.a(-1);
            return;
        }
        String str = (String) a.get("callback");
        a.d((String) a.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        a.b(this.mContext.getPackageName());
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
            this.mErrcode = 4;
        }
        ArrayList<PackageInfo> arrayList = null;
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            arrayList = com.baidu.android.nebula.d.a.a.a(this.mContext).b(PKGNAME_PREFIX);
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
