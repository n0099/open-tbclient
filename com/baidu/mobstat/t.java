package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.List;
/* loaded from: classes2.dex */
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
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f8879a = false;
                acVar.f8880b = "M";
                acVar.f8881c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    },
    RECEIVER(3) { // from class: com.baidu.mobstat.t.3
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f8879a = false;
                acVar.f8880b = "R";
                acVar.f8881c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    },
    ERISED(4) { // from class: com.baidu.mobstat.t.4
        @Override // com.baidu.mobstat.t
        public void a(Context context) {
            if (t.d(context)) {
                Context applicationContext = context.getApplicationContext();
                a a2 = u.a(context);
                ac acVar = new ac();
                acVar.f8879a = false;
                acVar.f8880b = ExifInterface.LONGITUDE_EAST;
                acVar.f8881c = false;
                a2.a(applicationContext, acVar.a());
            }
        }
    };
    

    /* renamed from: e  reason: collision with root package name */
    public int f9257e;

    public static t a(int i) {
        t[] values;
        for (t tVar : values()) {
            if (tVar.f9257e == i) {
                return tVar;
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
            } catch (Exception e2) {
                bb.c().a(e2);
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        return bo.e(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
    }

    public abstract void a(Context context);

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.f9257e);
    }

    t(int i) {
        this.f9257e = i;
    }
}
