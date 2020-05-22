package com.baidu.live.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.im.p;
/* loaded from: classes3.dex */
public class a {
    private static Application.ActivityLifecycleCallbacks asw;

    public static void d(Application application) {
        if (asw == null) {
            asw = new C0154a();
        }
        application.registerActivityLifecycleCallbacks(asw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Activity activity) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0154a implements Application.ActivityLifecycleCallbacks {
        private p asx;
        private CustomMessageListener asy;

        private C0154a() {
            this.asy = new CustomMessageListener(2913191) { // from class: com.baidu.live.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (C0154a.this.asx != null) {
                        C0154a.this.asx.CV();
                    }
                }
            };
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (a.o(activity)) {
                if (this.asx == null) {
                    this.asx = new p();
                }
                this.asx.init(String.valueOf(activity.hashCode()));
                MessageManager.getInstance().registerListener(this.asy);
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
            if (a.o(activity)) {
                if (this.asx != null) {
                    this.asx.destroy(String.valueOf(activity.hashCode()));
                }
                MessageManager.getInstance().unRegisterListener(this.asy);
            }
        }
    }
}
