package com.baidu.android.nebula.cmd;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendIntent implements NoProGuard, n {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 2;
    public static final int ERROR_PARSE_ERROR = 1;
    private static final String TAG = "SendIntent";
    private int mErrcode = 0;
    Context mContext = null;

    public SendIntent() {
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
        String str2 = (String) a.get("intent");
        if (TextUtils.isEmpty(str2)) {
            a.a(-1);
            return;
        }
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                Intent parseUri = Intent.parseUri(str2, 0);
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(parseUri, 0);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                    if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                        this.mErrcode = 2;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str2));
                        intent.addFlags(268435456);
                        try {
                            this.mContext.startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                        }
                    } else {
                        parseUri.addFlags(268435456);
                        this.mContext.startActivity(parseUri);
                        this.mErrcode = 0;
                    }
                } else {
                    this.mContext.sendBroadcast(parseUri);
                    this.mErrcode = 0;
                }
                a.c(str2);
                a.b(this.mContext.getPackageName());
            } catch (URISyntaxException e2) {
                this.mErrcode = 1;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e3) {
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
