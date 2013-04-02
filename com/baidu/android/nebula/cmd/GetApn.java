package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.pushservice.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetApn implements e, NoProGuard {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "GetApn";
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
            if (!com.baidu.android.nebula.localserver.a.a(this.mContext).a(aVar.a("Referer"))) {
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
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
