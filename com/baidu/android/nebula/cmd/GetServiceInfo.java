package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetServiceInfo implements NoProGuard, n {
    private static final boolean DEBUG = false;
    private static final String TAG = "GetServiceInfo";
    private int mErrcode = -1;
    Context mContext = null;

    public GetServiceInfo() {
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
        long e = com.baidu.android.moplus.util.b.e(this.mContext);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mErrcode != 4) {
                jSONObject.put("error", 0);
                jSONObject.put("version", String.valueOf(16));
                jSONObject.put("priority", String.valueOf(e));
                jSONObject.put("packagename", this.mContext.getPackageName());
                this.mErrcode = 0;
            } else {
                jSONObject.put("error", 4);
                this.mErrcode = 4;
            }
        } catch (JSONException e2) {
        }
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
