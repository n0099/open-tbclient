package com.baidu.live.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.im.n;
/* loaded from: classes7.dex */
public class a {
    private static Application.ActivityLifecycleCallbacks ayM;

    public static void d(Application application) {
        if (ayM == null) {
            ayM = new C0163a();
        }
        application.registerActivityLifecycleCallbacks(ayM);
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
    /* renamed from: com.baidu.live.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0163a implements Application.ActivityLifecycleCallbacks {
        private n ayN;
        private CustomMessageListener ayO;

        private C0163a() {
            this.ayO = new CustomMessageListener(2913191) { // from class: com.baidu.live.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (C0163a.this.ayN != null) {
                        C0163a.this.ayN.Js();
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
                if (this.ayN == null) {
                    this.ayN = new n();
                }
                this.ayN.init(String.valueOf(activity.hashCode()));
                MessageManager.getInstance().registerListener(this.ayO);
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
                if (this.ayN != null) {
                    this.ayN.destroy(String.valueOf(activity.hashCode()));
                }
                MessageManager.getInstance().unRegisterListener(this.ayO);
            }
        }
    }
}
