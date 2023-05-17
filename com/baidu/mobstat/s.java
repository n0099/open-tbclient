package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
/* loaded from: classes3.dex */
public enum s {
    SERVICE(1) { // from class: com.baidu.mobstat.s.1
        @Override // com.baidu.mobstat.s
        public void a(Context context) {
            if (!t.a(context).b(context)) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                intent.putExtra("SDK_PRODUCT_LY", "MS");
                context.startService(intent);
            } catch (Throwable th) {
                ba.c().b(th);
            }
        }
    },
    NO_SERVICE(2) { // from class: com.baidu.mobstat.s.2
        @Override // com.baidu.mobstat.s
        public void a(Context context) {
            Context applicationContext = context.getApplicationContext();
            a a = t.a(context);
            aa aaVar = new aa();
            aaVar.a = false;
            aaVar.b = "M";
            aaVar.c = false;
            a.a(applicationContext, aaVar.a());
        }
    },
    RECEIVER(3) { // from class: com.baidu.mobstat.s.3
        @Override // com.baidu.mobstat.s
        public void a(Context context) {
            Context applicationContext = context.getApplicationContext();
            a a = t.a(context);
            aa aaVar = new aa();
            aaVar.a = false;
            aaVar.b = "R";
            aaVar.c = false;
            a.a(applicationContext, aaVar.a());
        }
    },
    ERISED(4) { // from class: com.baidu.mobstat.s.4
        @Override // com.baidu.mobstat.s
        public void a(Context context) {
            Context applicationContext = context.getApplicationContext();
            a a = t.a(context);
            aa aaVar = new aa();
            aaVar.a = false;
            aaVar.b = ExifInterface.LONGITUDE_EAST;
            aaVar.c = false;
            a.a(applicationContext, aaVar.a());
        }
    };
    
    public int e;

    public abstract void a(Context context);

    s(int i) {
        this.e = i;
    }

    public static s a(int i) {
        s[] values;
        for (s sVar : values()) {
            if (sVar.e == i) {
                return sVar;
            }
        }
        return NO_SERVICE;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
                int i = 0;
                while (runningServices != null) {
                    if (i >= runningServices.size()) {
                        break;
                    } else if ("com.baidu.bottom.service.BottomService".equals(runningServices.get(i).service.getClassName())) {
                        return true;
                    } else {
                        i++;
                    }
                }
            } catch (Exception e) {
                ba.c().a(e);
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.e);
    }
}
