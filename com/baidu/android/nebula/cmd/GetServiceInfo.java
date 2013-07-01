package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetServiceInfo implements NoProGuard, e {
    private static final boolean DEBUG = false;
    private static final String TAG = "GetServiceInfo";
    private int mErrcode = -1;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        String str;
        Map a2 = dVar.a();
        if (a2 == null || a2.size() < 1 || (str = (String) a2.get("callback")) == null) {
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a(HttpUtils.HEADER_NAME_REFERER))) {
                this.mErrcode = 4;
            }
            long e = com.baidu.android.moplus.util.b.e(this.mContext);
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mErrcode != 4) {
                    jSONObject.put("error", 0);
                    jSONObject.put("version", String.valueOf(10));
                    jSONObject.put("priority", String.valueOf(e));
                    jSONObject.put("packagename", this.mContext.getPackageName());
                } else {
                    jSONObject.put("error", 4);
                }
            } catch (JSONException e2) {
            }
            aVar.a("text/javascript");
            aVar.a().put("Cache-Control", "no-cache");
            aVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            aVar.a(200);
        }
    }
}
