package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.android.common.util.Util;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.zeus.Headers;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        Intent intent = new Intent("com.baidu.pushservice.action.START");
        intent.setClass(context, PushService.class);
        context.startService(intent);
    }

    public static void a(List list) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        list.add(new BasicNameValuePair("timestamp", currentTimeMillis + ""));
        list.add(new BasicNameValuePair(Headers.EXPIRES, (86400 + currentTimeMillis) + ""));
        list.add(new BasicNameValuePair("v", "1"));
        try {
            list.add(new BasicNameValuePair("vcode", Util.toMd5(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false)));
        } catch (UnsupportedEncodingException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = com.baidu.android.pushservice.a.a(context).a;
        synchronized (arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.android.pushservice.c cVar = (com.baidu.android.pushservice.c) it.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = packageManager.getPackageInfo(cVar.a, 0);
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (packageInfo == null) {
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
                    intent.putExtra("package_name", cVar.a);
                    intent.setClass(context, PushService.class);
                    context.startService(intent);
                }
            }
        }
    }
}
