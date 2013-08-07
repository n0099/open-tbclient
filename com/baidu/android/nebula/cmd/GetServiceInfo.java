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
    public void execute(com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        String str;
        Map a2 = aVar.a();
        if (a2 == null || a2.size() < 1 || (str = (String) a2.get("callback")) == null) {
            return;
        }
        this.mContext = com.baidu.android.nebula.c.c.a().c();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.c.a.a(this.mContext).a(aVar.a(HttpUtils.HEADER_NAME_REFERER))) {
                this.mErrcode = 4;
            }
            long e = com.baidu.android.moplus.util.b.e(this.mContext);
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mErrcode != 4) {
                    jSONObject.put("error", 0);
                    jSONObject.put("version", String.valueOf(12));
                    jSONObject.put("priority", String.valueOf(e));
                    jSONObject.put("packagename", this.mContext.getPackageName());
                } else {
                    jSONObject.put("error", 4);
                }
            } catch (JSONException e2) {
            }
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
