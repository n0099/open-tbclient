package com.baidu.live.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.im.n;
/* loaded from: classes4.dex */
public class a {
    private static Application.ActivityLifecycleCallbacks aAe;

    public static void d(Application application) {
        if (aAe == null) {
            aAe = new C0170a();
        }
        application.registerActivityLifecycleCallbacks(aAe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(Activity activity) {
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
    /* renamed from: com.baidu.live.activity.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0170a implements Application.ActivityLifecycleCallbacks {
        private n aAf;
        private CustomMessageListener aAg;

        private C0170a() {
            this.aAg = new CustomMessageListener(2913191) { // from class: com.baidu.live.activity.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (C0170a.this.aAf != null) {
                        C0170a.this.aAf.LW();
                    }
                }
            };
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (a.p(activity)) {
                if (this.aAf == null) {
                    this.aAf = new n();
                }
                this.aAf.init(String.valueOf(activity.hashCode()));
                MessageManager.getInstance().registerListener(this.aAg);
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
            if (a.p(activity)) {
                if (this.aAf != null) {
                    this.aAf.hK(String.valueOf(activity.hashCode()));
                }
                MessageManager.getInstance().unRegisterListener(this.aAg);
            }
        }
    }
}
