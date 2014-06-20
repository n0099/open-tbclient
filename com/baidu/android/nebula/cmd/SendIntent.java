package com.baidu.android.nebula.cmd;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.a.l;
import com.baidu.android.moplus.util.NoProGuard;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SendIntent implements NoProGuard, d {
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

    private boolean canExecute(Intent intent) {
        String action = intent.getAction();
        String str = "";
        try {
            str = intent.getComponent().getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (l.a(this.mContext).a().contains(action) || l.a(this.mContext).a().contains(str)) ? false : true;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        String str = null;
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
        String str3 = (String) map2.get("intent");
        if (TextUtils.isEmpty(str3)) {
            a.a(-1);
            return null;
        }
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                Intent parseUri = Intent.parseUri(str3, 0);
                if (!canExecute(parseUri)) {
                    return null;
                }
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(parseUri, 0);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                    if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                        this.mErrcode = 2;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str3));
                        intent.addFlags(268435456);
                        try {
                            intent.addFlags(32);
                            this.mContext.startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                        }
                    } else {
                        ActivityManager.RunningTaskInfo b = com.baidu.android.systemmonitor.freqstatistic.b.b(this.mContext);
                        if (b != null && b.topActivity != null) {
                            str = b.topActivity.getPackageName();
                            try {
                                PackageInfo packageInfo = packageManager.getPackageInfo(str, 128);
                                if (packageInfo != null && packageInfo.applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.getBoolean("com.baidu.android.GB2L.launcher")) {
                                    parseUri.putExtra("com.baidu.android.GB2L", true);
                                    parseUri.putExtra("com.baidu.android.GB2L.pkgname", str);
                                    parseUri.putExtra("com.baidu.android.GB2L.label", (String) packageManager.getActivityInfo(b.topActivity, 0).loadLabel(packageManager));
                                }
                            } catch (PackageManager.NameNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        }
                        parseUri.addFlags(32);
                        parseUri.addFlags(268435456);
                        this.mContext.startActivity(parseUri);
                        this.mErrcode = 0;
                    }
                } else {
                    parseUri.addFlags(32);
                    this.mContext.sendBroadcast(parseUri);
                    this.mErrcode = 0;
                }
                if (TextUtils.isEmpty(str)) {
                    a.c(str3);
                } else {
                    a.c(str);
                }
                a.e((String) map2.get("searchid"));
                a.b(this.mContext.getPackageName());
            } catch (URISyntaxException e3) {
                this.mErrcode = 1;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e4) {
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
