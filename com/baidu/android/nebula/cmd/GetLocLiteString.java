package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.locMoplus.BDLocManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetLocLiteString implements NoProGuard, d {
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    public static final int ERROR_FAIL2 = 2;
    public static final int ERROR_FAIL3 = 3;
    public static final int ERROR_PERMISSION_DENY = 4;
    private static final String TAG = "GetLocLiteString";
    private int mErrcode = -1;
    Context mContext = null;

    public GetLocLiteString() {
        a.a();
        a.a(TAG);
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        String str;
        String str2;
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str3 = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str3 == null) {
            a.a(-1);
            return null;
        }
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        a.b(this.mContext.getPackageName());
        if (com.baidu.android.nebula.a.e.a(this.mContext).b(this.mContext)) {
            if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
                this.mErrcode = 4;
            }
            if (this.mErrcode != 4) {
                this.mErrcode = 1;
                str = com.baidu.android.nebula.a.e.a(this.mContext).b();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                String locString = new BDLocManager(this.mContext).getLocString();
                if (TextUtils.isEmpty(locString)) {
                    str2 = "{error:3}";
                    this.mErrcode = 3;
                } else {
                    str2 = "{error:2,msg:" + locString + "}";
                    this.mErrcode = 2;
                }
            } else {
                str2 = "{error:0," + str + "}";
                this.mErrcode = 0;
            }
        } else {
            this.mErrcode = 4;
            str2 = "{error:4}";
        }
        try {
            str2 = new JSONObject(str2).toString();
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str3 + " && " + str3 + "(" + str2 + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
