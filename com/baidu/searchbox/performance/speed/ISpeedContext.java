package com.baidu.searchbox.performance.speed;

import android.app.Activity;
import java.util.HashMap;
/* loaded from: classes2.dex */
public interface ISpeedContext {
    public static final ISpeedContext EMPTY = new ISpeedContext() { // from class: com.baidu.searchbox.performance.speed.ISpeedContext.1
        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void checkSendStatisticData() {
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public String getVersionName() {
            return null;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean hasSkin() {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isAdShowing() {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isAgreePrivacyPolicy() {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isMainActivity(Activity activity) {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isMainLine() {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isMainProcess() {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isPushDispatchActivity(Activity activity) {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isSchemeDispatchActivity(Activity activity) {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public boolean isSplashActivity(Activity activity) {
            return false;
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void launchData(HashMap<String, String> hashMap) {
        }

        @Override // com.baidu.searchbox.performance.speed.ISpeedContext
        public void launchTime(boolean z, long j) {
        }
    };

    void checkSendStatisticData();

    String getVersionName();

    boolean hasSkin();

    boolean isAdShowing();

    boolean isAgreePrivacyPolicy();

    boolean isMainActivity(Activity activity);

    boolean isMainLine();

    boolean isMainProcess();

    boolean isPushDispatchActivity(Activity activity);

    boolean isSchemeDispatchActivity(Activity activity);

    boolean isSplashActivity(Activity activity);

    void launchData(HashMap<String, String> hashMap);

    void launchTime(boolean z, long j);
}
