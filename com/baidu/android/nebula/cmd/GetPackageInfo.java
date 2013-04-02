package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.NoProGuard;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetPackageInfo implements e, NoProGuard {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 1;
    private static final String TAG = "GetPackageInfo";
    private int mErrcode = -1;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        String str;
        ArrayList<PackageInfo> arrayList;
        Map a = aVar.a();
        if (a == null || a.size() < 1 || (str = (String) a.get("callback")) == null) {
            return;
        }
        String str2 = (String) a.get("packagename");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mContext = com.baidu.android.nebula.localserver.c.a().b();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.localserver.a.a(this.mContext).a(aVar.a("Referer"))) {
                this.mErrcode = 4;
            }
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                arrayList = com.baidu.android.nebula.localserver.util.e.a(this.mContext).b(str2);
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
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put("package_infos", jSONArray);
                        this.mErrcode = 0;
                    }
                } catch (JSONException e) {
                }
            }
            jSONObject.put("error", this.mErrcode);
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
