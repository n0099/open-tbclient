package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.NoProGuard;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendIntent implements e, NoProGuard {
    private static final boolean DEBUG = false;
    public static final int ERROR_NOT_EXIST = 2;
    public static final int ERROR_PARSE_ERROR = 1;
    private static final String TAG = "SendIntent";
    private int mErrcode = 0;
    Context mContext = null;

    @Override // com.baidu.android.nebula.cmd.e
    public void execute(com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        String str;
        Map a = aVar.a();
        if (a == null || a.size() < 1 || (str = (String) a.get("callback")) == null) {
            return;
        }
        String str2 = (String) a.get("intent");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            str2 = URLDecoder.decode(str2, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
        }
        this.mContext = com.baidu.android.nebula.localserver.c.a().b();
        if (this.mContext != null) {
            if (!com.baidu.android.nebula.localserver.a.a(this.mContext).a(aVar.a("Referer"))) {
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
                        } else {
                            parseUri.addFlags(268435456);
                            this.mContext.startActivity(parseUri);
                            this.mErrcode = 0;
                        }
                    } else {
                        this.mContext.sendBroadcast(parseUri);
                        this.mErrcode = 0;
                    }
                } catch (URISyntaxException e2) {
                    this.mErrcode = 1;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", this.mErrcode);
            } catch (JSONException e3) {
            }
            bVar.a("text/javascript");
            bVar.a().put("Cache-Control", "no-cache");
            bVar.b(str + " && " + str + "(" + jSONObject.toString() + ");");
            bVar.a(200);
        }
    }
}
