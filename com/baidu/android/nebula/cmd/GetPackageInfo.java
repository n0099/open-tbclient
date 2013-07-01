package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetPackageInfo implements NoProGuard, e {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 1;
    private static final String TAG = "GetPackageInfo";
    private int mErrcode = -1;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        String str;
        ArrayList<PackageInfo> arrayList;
        Map a2 = dVar.a();
        if (a2 == null || a2.size() < 1 || (str = (String) a2.get("callback")) == null) {
            return;
        }
        String str2 = (String) a2.get("packagename");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a(HttpUtils.HEADER_NAME_REFERER))) {
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
        }
    }
}
