package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DownloadFile implements NoProGuard, d {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "DownloadFile";
    private int mErrcode = -1;
    Context mContext = null;

    public DownloadFile() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
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
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        a.b(this.mContext.getPackageName());
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        String str2 = (String) map2.get("querydown");
        long parseLong = Long.parseLong((String) map2.get("filesize"));
        com.baidu.android.defense.a.a aVar = new com.baidu.android.defense.a.a();
        aVar.a = (String) map2.get("downloadurl");
        aVar.b = (String) map2.get("savepath");
        aVar.c = parseLong;
        if (TextUtils.equals(str2, "download")) {
            a.a("DownloadFile_download");
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                com.baidu.android.defense.a.d.a().a(new com.baidu.android.defense.a.b(this.mContext, aVar));
                this.mErrcode = 0;
            }
        } else if (!TextUtils.equals(str2, "query")) {
            return null;
        } else {
            a.a("DownloadFile_query");
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                aVar.c = new File(aVar.a()).length();
                this.mErrcode = 0;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.equals(str2, "query")) {
                jSONObject.put("currentsize", aVar.c);
            }
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str + " && " + str + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
