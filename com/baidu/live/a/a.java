package com.baidu.live.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.im.n;
/* loaded from: classes3.dex */
public class a {
    private static Application.ActivityLifecycleCallbacks VK;

    public static void d(Application application) {
        if (VK == null) {
            VK = new C0079a();
        }
        application.registerActivityLifecycleCallbacks(VK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(Activity activity) {
        String className = activity.getComponentName().getClassName();
        if (className.contains("AlaMasterLiveRoomActivity") || className.contains("LivePlayerActivity") || className.contains("AlaLiveEndActivity")) {
            return true;
        }
        if (className.equals("com.baidu.megapp.proxy.activity.ActivityProxy")) {
            String stringExtra = activity.getIntent().getStringExtra("megapp_extra_target_activity");
            if (!TextUtils.isEmpty(stringExtra) && (stringExtra.contains("AlaMasterLiveRoomActivity") || stringExtra.contains("LivePlayerActivity") || stringExtra.contains("AlaLiveEndActivity"))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.baidu.live.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0079a implements Application.ActivityLifecycleCallbacks {
        private n VL;

        private C0079a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (a.s(activity)) {
                if (this.VL == null) {
                    this.VL = new n();
                }
                this.VL.init(String.valueOf(activity.hashCode()));
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (a.s(activity) && this.VL != null) {
                this.VL.destroy(String.valueOf(activity.hashCode()));
            }
        }
    }
}
