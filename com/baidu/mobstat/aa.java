package com.baidu.mobstat;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.ActivityChooserView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
/* loaded from: classes3.dex */
public enum aa {
    SERVICE(1) { // from class: com.baidu.mobstat.aa.1
        @Override // com.baidu.mobstat.aa
        public void a(Context context) {
            if (aa.d(context) && ab.a(context).b(context)) {
                try {
                    Intent intent = new Intent(context, Class.forName("com.baidu.bottom.service.BottomService"));
                    intent.putExtra("SDK_PRODUCT_LY", "MS");
                    context.startService(intent);
                } catch (Throwable th) {
                    bi.c().b(th);
                }
            }
        }
    },
    NO_SERVICE(2) { // from class: com.baidu.mobstat.aa.2
        @Override // com.baidu.mobstat.aa
        public void a(Context context) {
            if (aa.d(context)) {
                Context applicationContext = context.getApplicationContext();
                h a = ab.a(context);
                aj ajVar = new aj();
                ajVar.a = false;
                ajVar.b = "M";
                ajVar.c = false;
                a.a(applicationContext, ajVar.a());
            }
        }
    },
    RECEIVER(3) { // from class: com.baidu.mobstat.aa.3
        @Override // com.baidu.mobstat.aa
        public void a(Context context) {
            if (aa.d(context)) {
                Context applicationContext = context.getApplicationContext();
                h a = ab.a(context);
                aj ajVar = new aj();
                ajVar.a = false;
                ajVar.b = "R";
                ajVar.c = false;
                a.a(applicationContext, ajVar.a());
            }
        }
    },
    ERISED(4) { // from class: com.baidu.mobstat.aa.4
        @Override // com.baidu.mobstat.aa
        public void a(Context context) {
            if (aa.d(context)) {
                Context applicationContext = context.getApplicationContext();
                h a = ab.a(context);
                aj ajVar = new aj();
                ajVar.a = false;
                ajVar.b = "E";
                ajVar.c = false;
                a.a(applicationContext, ajVar.a());
            }
        }
    };
    
    private int e;

    public abstract void a(Context context);

    aa(int i) {
        this.e = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.e);
    }

    public static aa a(int i) {
        aa[] values;
        for (aa aaVar : values()) {
            if (aaVar.e == i) {
                return aaVar;
            }
        }
        return NO_SERVICE;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
                bi.c().a(e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        return bv.e(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
