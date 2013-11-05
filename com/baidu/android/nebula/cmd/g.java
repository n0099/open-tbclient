package com.baidu.android.nebula.cmd;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.List;
/* loaded from: classes.dex */
class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDownloadFile f661a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, ScanDownloadFile scanDownloadFile) {
        this.b = fVar;
        this.f661a = scanDownloadFile;
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
        String str4;
        str = this.b.f660a.mFilePackageName;
        if (TextUtils.equals(str, intent.getData().getSchemeSpecificPart())) {
            try {
                ScanDownloadFile scanDownloadFile = this.b.f660a;
                str4 = this.b.f660a.mIntentStr;
                scanDownloadFile.mIntentStr = URLDecoder.decode(str4, BdUtil.UTF8);
            } catch (UnsupportedEncodingException e) {
            }
            context2 = this.b.f660a.mContext;
            PackageManager packageManager = context2.getPackageManager();
            try {
                str2 = this.b.f660a.mIntentStr;
                Intent parseUri = Intent.parseUri(str2, 0);
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(parseUri, 0);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    context5 = this.b.f660a.mContext;
                    context5.sendBroadcast(parseUri);
                } else if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    str3 = this.b.f660a.mIntentStr;
                    intent2.setData(Uri.parse(str3));
                    intent2.addFlags(268435456);
                    try {
                        context3 = this.b.f660a.mContext;
                        context3.startActivity(intent2);
                    } catch (ActivityNotFoundException e2) {
                    }
                } else {
                    parseUri.addFlags(268435456);
                    context4 = this.b.f660a.mContext;
                    context4.startActivity(parseUri);
                }
            } catch (URISyntaxException e3) {
            }
        }
    }
}
