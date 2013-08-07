package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import com.baidu.loc.strWebApp.BDLocManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetLocString implements NoProGuard, e {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "getLocString";
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
            String str2 = null;
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                str2 = new BDLocManager(this.mContext).getLocString();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("locstring", str2);
                    this.mErrcode = 0;
                }
                jSONObject.put("error", this.mErrcode);
            } catch (JSONException e) {
            }
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
