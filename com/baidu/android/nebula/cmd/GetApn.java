package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetApn implements NoProGuard, n {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "GetApn";
    private int mErrcode = -1;
    Context mContext = null;

    public GetApn() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() <= 0) {
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
        String str2 = null;
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            str2 = new ConnectManager(this.mContext).getNetType();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("apn", str2);
                this.mErrcode = 0;
            }
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e) {
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
