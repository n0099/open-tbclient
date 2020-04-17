package com.baidu.swan.bdprivate.c.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.b;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cCq = {"BLA-AL00", "R7Plus"};

    /* loaded from: classes11.dex */
    public interface a {
        void onResult(boolean z);
    }

    public static boolean cA(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }

    public static void a(Context context, a aVar) {
        if (!(context instanceof Activity)) {
            if (DEBUG) {
                throw new IllegalArgumentException("context must be activity.");
            }
        } else if (aVar != null) {
            DialogInterface.OnClickListener a2 = a(aVar);
            g.a aVar2 = new g.a(context);
            aVar2.a(new com.baidu.swan.apps.view.c.a());
            g WU = aVar2.WU();
            aVar2.eI(b.g.swan_app_guide_notify_title).lV(context.getString(b.g.swan_app_guide_notify_msg)).aku().eB(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()).c(b.g.swan_app_guide_positive_btn, a2).d(b.g.swan_app_guide_negative_btn, a2).akt();
            WU.setCancelable(false);
            WU.show();
        }
    }

    private static DialogInterface.OnClickListener a(final a aVar) {
        return new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.c.e.b.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this != null) {
                    a.this.onResult(i == -1);
                }
            }
        };
    }

    public static void cW(Context context) {
        if (!Arrays.asList(cCq).contains(Build.MODEL)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.setFlags(268435456);
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
            try {
                context.startActivity(intent);
                return;
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e);
                }
                cX(context);
                return;
            }
        }
        cX(context);
    }

    private static void cX(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
