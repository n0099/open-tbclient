package com.baidu.android.nebula.cmd;

import android.content.Context;
import com.baidu.android.pushservice.util.NoProGuard;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetServiceInfo implements e, NoProGuard {
    private static final boolean DEBUG = false;
    private static final String TAG = "GetServiceInfo";
    private int mErrcode = -1;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        String str;
        Map a = aVar.a();
        if (a == null || a.size() < 1 || (str = (String) a.get("callback")) == null) {
            return;
        }
        this.mContext = com.baidu.android.nebula.localserver.c.a().b();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.localserver.a.a(this.mContext).a(aVar.a(HttpUtils.HEADER_NAME_REFERER))) {
                this.mErrcode = 4;
            }
            long i = com.baidu.android.pushservice.util.d.i(this.mContext);
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.mErrcode != 4) {
                    jSONObject.put("error", 0);
                    jSONObject.put("version", String.valueOf(5));
                    jSONObject.put("priority", String.valueOf(i));
                } else {
                    jSONObject.put("error", 4);
                }
            } catch (JSONException e) {
            }
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
