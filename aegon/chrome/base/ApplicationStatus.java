package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ApplicationStatus {
    public static final Map<Activity, Object> sActivityInfo;
    public static final ObserverList<ApplicationStateListener> sApplicationStateListeners;
    @SuppressLint({"SupportAnnotationUsage"})
    public static int sCurrentApplicationState;
    public static ApplicationStateListener sNativeApplicationStateListener;

    /* loaded from: classes.dex */
    public interface ApplicationStateListener {
    }

    static {
        ApplicationStatus.class.desiredAssertionStatus();
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
        new ObserverList();
        sApplicationStateListeners = new ObserverList<>();
        new ObserverList();
    }

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        int i;
        synchronized (sActivityInfo) {
            i = sCurrentApplicationState;
        }
        return i;
    }

    public static native void nativeOnApplicationStateChange(int i);

    @MainThread
    public static void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.addObserver(applicationStateListener);
    }

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        Runnable runnable = new Runnable() { // from class: aegon.chrome.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.sNativeApplicationStateListener != null) {
                    return;
                }
                ApplicationStateListener applicationStateListener = new ApplicationStateListener(this) { // from class: aegon.chrome.base.ApplicationStatus.3.1
                };
                ApplicationStatus.sNativeApplicationStateListener = applicationStateListener;
                ApplicationStatus.registerApplicationStateListener(applicationStateListener);
            }
        };
        if (ThreadUtils.runningOnUiThread()) {
            runnable.run();
        } else {
            ThreadUtils.getUiThreadHandler().post(runnable);
        }
    }
}
