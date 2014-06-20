package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetServiceInfo implements NoProGuard, d {
    private static final boolean DEBUG = false;
    private static final String TAG = "GetServiceInfo";
    private int mErrcode = -1;
    Context mContext = null;

    public GetServiceInfo() {
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
        long e = com.baidu.android.moplus.util.a.e(this.mContext);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mErrcode != 4) {
                jSONObject.put("error", 0);
                jSONObject.put("version", String.valueOf(20));
                jSONObject.put("priority", String.valueOf(e));
                jSONObject.put("packagename", this.mContext.getPackageName());
                this.mErrcode = 0;
            } else {
                jSONObject.put("error", 4);
                this.mErrcode = 4;
            }
        } catch (JSONException e2) {
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
