package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetCuid implements NoProGuard, k {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "GetCuid";
    private int mErrcode = -1;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.k
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
            String str2 = null;
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                str2 = CommonParam.getCUID(this.mContext);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("cuid", str2);
                    this.mErrcode = 0;
                }
                jSONObject.put("error", this.mErrcode);
            } catch (JSONException e) {
            }
            aVar.a("text/javascript");
            aVar.a().put("Cache-Control", "no-cache");
            aVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            aVar.a(200);
        }
    }
}
