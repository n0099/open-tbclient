package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.media.ExifInterface;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes11.dex */
public enum t {
    SERVICE(1) { // from class: com.baidu.mobstat.t.1
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context) && u.a(context).b(context)) {
                try {
                    Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                    intent.putExtra("SDK_PRODUCT_LY", "MS");
                    context.startService(intent);
                } catch (Throwable th) {
                    bb.c().b(th);
                }
            }
        }
    },
    NO_SERVICE(2) { // from class: com.baidu.mobstat.t.2
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a = u.a(context);
                ac acVar = new ac();
                acVar.a = false;
                acVar.b = "M";
                acVar.c = false;
                a.a(applicationContext, acVar.a());
            }
        }
    },
    RECEIVER(3) { // from class: com.baidu.mobstat.t.3
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a = u.a(context);
                ac acVar = new ac();
                acVar.a = false;
                acVar.b = "R";
                acVar.c = false;
                a.a(applicationContext, acVar.a());
            }
        }
    },
    ERISED(4) { // from class: com.baidu.mobstat.t.4
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a = u.a(context);
                ac acVar = new ac();
                acVar.a = false;
                acVar.b = ExifInterface.LONGITUDE_EAST;
                acVar.c = false;
                a.a(applicationContext, acVar.a());
            }
        }
    };
    
    private int e;

    public abstract void a(Context context);

    t(int i) {
        this.e = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.e);
    }

    public static t a(int i) {
        t[] values;
        for (t tVar : values()) {
            if (tVar.e == i) {
                return tVar;
            }
        }
        return NO_SERVICE;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                int i = 0;
                while (runningServices != null) {
                    if (i >= runningServices.size()) {
                        break;
                    } else if (!"com.baidu.bottom.service.BottomService".equals(runningServices.get(i).service.getClassName())) {
                        i++;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                bb.c().a(e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        return bo.e(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
