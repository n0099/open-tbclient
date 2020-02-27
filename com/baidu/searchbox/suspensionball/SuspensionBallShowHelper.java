package com.baidu.searchbox.suspensionball;

import android.app.Activity;
import android.app.KeyguardManager;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.suspensionball.ioc.SuspensionBallRuntime;
import com.baidu.ubc.Flow;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class SuspensionBallShowHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_STRATEGY = 1;
    public static final int HIDE_ON_PAGE_SHOW_STRATEGY = 2;
    private static final String TAG = "SuspensionBallHelper";
    private static volatile SuspensionBallShowHelper instance;
    private String key;
    private Flow mFlow;
    private int mStrategyType = 1;
    private boolean mDefaultStrategyValid = true;
    private Map<Activity, Object> mHideAllMark = new HashMap();
    private Object mObject = new Object();

    private SuspensionBallShowHelper() {
    }

    public static SuspensionBallShowHelper getInstance() {
        if (instance == null) {
            synchronized (SuspensionBallShowHelper.class) {
                if (instance == null) {
                    instance = new SuspensionBallShowHelper();
                }
            }
        }
        return instance;
    }

    void release() {
        this.mHideAllMark.clear();
        this.mFlow = null;
    }

    public static synchronized void releaseInstance() {
        synchronized (SuspensionBallShowHelper.class) {
            if (instance != null) {
                instance.release();
            }
            instance = null;
        }
    }

    public void setDefaultStrategyValid(boolean z) {
        this.mDefaultStrategyValid = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    private void setStrategy(int i) {
        this.mStrategyType = i;
    }

    public void onResume(final Activity activity) {
        if (this.mDefaultStrategyValid && activity != null && SuspensionBallManager.getInstance().isSuspensionBallSwitchOn() && SuspensionBallManager.getInstance().hasSuspensionBall()) {
            if (((KeyguardManager) AppRuntime.getAppContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallShowHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SuspensionBallShowHelper.this.doOnResume(activity);
                    }
                }, 150L);
            } else {
                doOnResume(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnResume(Activity activity) {
        if (!((KeyguardManager) AppRuntime.getAppContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (isMarkedHideAll(activity)) {
                SuspensionBallManager.getInstance().hideAllSuspensionBall();
                return;
            }
            String stringExtra = activity.getIntent().getStringExtra(SuspensionSchemeUtil.SUSPENSION_KEY);
            setKey(stringExtra);
            switch (this.mStrategyType) {
                case 1:
                    if (SuspensionBallManager.getInstance().isInSuspensionBall(stringExtra)) {
                        SuspensionBallEntity entityByKey = SuspensionBallManager.getInstance().getEntityByKey(stringExtra);
                        if (entityByKey != null) {
                            this.mFlow = SuspensionBallUbc.startPageShow(entityByKey.page);
                        }
                        SuspensionBallManager.getInstance().hideSuspensionBall(stringExtra);
                        return;
                    } else if (SuspensionBallRuntime.getShieldImpl().isShieldPage(activity.getClass().getName())) {
                        SuspensionBallManager.getInstance().hideAllSuspensionBall();
                        return;
                    } else {
                        SuspensionBallManager.getInstance().showAllSuspensionBall();
                        return;
                    }
                default:
                    if (DEBUG) {
                        Log.e(TAG, "unknown suspension ball show strategy type");
                        return;
                    }
                    return;
            }
        }
    }

    public void onPause(Activity activity) {
        if (this.mDefaultStrategyValid && activity != null && SuspensionBallManager.getInstance().isSuspensionBallSwitchOn() && SuspensionBallManager.getInstance().hasSuspensionBall()) {
            switch (this.mStrategyType) {
                case 1:
                    if (SuspensionBallManager.getInstance().isInSuspensionBall(this.key) && this.mFlow != null) {
                        SuspensionBallUbc.endUbcFlow(this.mFlow);
                        break;
                    }
                    break;
                default:
                    if (DEBUG) {
                        Log.e(TAG, "unknown suspension ball show strategy type");
                        break;
                    }
                    break;
            }
            this.mFlow = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivityHideAllMark(Activity activity) {
        if (DEBUG) {
            Log.i(TAG, "setActivityHideAllMark activity = " + activity);
        }
        if (activity != null) {
            this.mHideAllMark.put(activity, this.mObject);
        }
    }

    public void removeActivityHideAllMark(Activity activity) {
        if (DEBUG) {
            Log.i(TAG, "removeActivityHideAllMark activity = " + activity);
        }
        this.mHideAllMark.remove(activity);
    }

    private boolean isMarkedHideAll(Activity activity) {
        if (DEBUG) {
            Log.i(TAG, "isMarkedHideAll activity = " + activity);
        }
        return this.mHideAllMark.get(activity) != null;
    }
}
