package com.baidu.pano.platform.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.baidu.pano.platform.a.p;
import java.io.File;
/* loaded from: classes2.dex */
public class n {
    public static p a(Context context, i iVar, int i2) {
        String str;
        p pVar;
        com.baidu.pano.platform.c.b.a().a(context);
        File file = new File(com.baidu.pano.platform.c.b.b());
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            str = packageName + "/" + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "baidu_pano/0";
        }
        if (iVar == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                iVar = new j();
            } else {
                iVar = new g(AndroidHttpClient.newInstance(str));
            }
        }
        a aVar = new a(iVar);
        if (i2 <= -1) {
            pVar = new p(new e(file), aVar);
        } else {
            pVar = new p(new e(file, i2), aVar);
        }
        pVar.a();
        return pVar;
    }

    public static p a(Context context, i iVar) {
        return a(context, iVar, -1);
    }

    public static p a(Context context) {
        return a(context, null);
    }
}
