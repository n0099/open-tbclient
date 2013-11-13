package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.android.common.util.Util;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.zeus.Headers;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class b {
    public static void a(Context context) {
        Intent intent = new Intent("com.baidu.pushservice.action.START");
        intent.setClass(context, PushService.class);
        context.startService(intent);
    }

    private static void a(Context context, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        synchronized (arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.android.pushservice.d dVar = (com.baidu.android.pushservice.d) it.next();
                PackageInfo packageInfo = null;
                try {
                    packageInfo = packageManager.getPackageInfo(dVar.f707a, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("ApiUtils", Log.getStackTraceString(e));
                }
                if (packageInfo == null) {
                    Intent intent = new Intent(PushConstants.ACTION_METHOD);
                    intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
                    intent.putExtra("package_name", dVar.f707a);
                    com.baidu.android.pushservice.b.a(context, intent);
                }
            }
        }
    }

    public static void a(List list) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        list.add(new BasicNameValuePair("timestamp", currentTimeMillis + ""));
        list.add(new BasicNameValuePair(Headers.EXPIRES, (86400 + currentTimeMillis) + ""));
        list.add(new BasicNameValuePair("v", SocialConstants.TRUE));
        try {
            list.add(new BasicNameValuePair("vcode", Util.toMd5(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context) {
        a(context, com.baidu.android.pushservice.a.a(context).f687a);
        a(context, com.baidu.android.pushservice.a.a(context).b);
    }
}
