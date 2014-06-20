package com.baidu.android.nebula.cmd;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
class b extends BroadcastReceiver {
    final /* synthetic */ ScanDownloadFile a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScanDownloadFile scanDownloadFile) {
        this.a = scanDownloadFile;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Context context2;
        String str2;
        String str3;
        Context context3;
        Context context4;
        Context context5;
        str = this.a.mFilePackageName;
        if (TextUtils.equals(str, intent.getData().getSchemeSpecificPart())) {
            context2 = this.a.mContext;
            PackageManager packageManager = context2.getPackageManager();
            try {
                str2 = this.a.mIntentStr;
                Intent parseUri = Intent.parseUri(str2, 0);
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(parseUri, 0);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    parseUri.addFlags(32);
                    context5 = this.a.mContext;
                    context5.sendBroadcast(parseUri);
                } else if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    str3 = this.a.mIntentStr;
                    intent2.setData(Uri.parse(str3));
                    intent2.addFlags(32);
                    intent2.addFlags(268435456);
                    try {
                        context3 = this.a.mContext;
                        context3.startActivity(intent2);
                    } catch (ActivityNotFoundException e) {
                    }
                } else {
                    parseUri.addFlags(32);
                    parseUri.addFlags(268435456);
                    context4 = this.a.mContext;
                    context4.startActivity(parseUri);
                }
            } catch (Exception e2) {
            } finally {
                this.a.releaseReceiver();
            }
        }
    }
}
