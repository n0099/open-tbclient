package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetApn implements NoProGuard, d {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    private static final String TAG = "GetApn";
    private int mErrcode = -1;
    Context mContext = null;

    public GetApn() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        String str;
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str2 = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str2 == null) {
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
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            str = new com.baidu.android.nebula.a.h(this.mContext).d();
        } else {
            str = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("apn", str);
                this.mErrcode = 0;
            }
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str2 + " && " + str2 + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
