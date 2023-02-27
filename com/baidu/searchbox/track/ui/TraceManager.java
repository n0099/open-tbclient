package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TraceManager {
    public static final String TO_BACKGROUND = "To background";
    public static final String TO_FOREGROUND = "To foreground";
    public static volatile TraceManager sInstance;
    public volatile boolean mIsRegistered = false;
    public OnFragmentTraceListener mOnFragmentListener;
    public TraceActivityCallbacks mTraceActivityCallbacks;

    public static TraceManager getInstance() {
        if (sInstance == null) {
            synchronized (TraceManager.class) {
                if (sInstance == null) {
                    sInstance = new TraceManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public void release() {
        if (sInstance != null) {
            if (sInstance.mTraceActivityCallbacks != null) {
                BdBoxActivityManager.unregisterLifeCycle(sInstance.mTraceActivityCallbacks);
                sInstance.mTraceActivityCallbacks = null;
            }
            this.mIsRegistered = false;
            sInstance = null;
        }
    }

    public static boolean checkAPSActivity(Activity activity) {
        return activity.getClass().getName().startsWith("com.baidu.megapp.proxy.activity");
    }

    public void setOnFragmentListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        this.mOnFragmentListener = onFragmentTraceListener;
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @NonNull String str2) {
        return createTraceInfo(activity, str, obj, null, null, "native", str2);
    }

    public void saveTraceInfo(Activity activity, String str, Object obj, String str2) {
        TrackUI createTraceInfo;
        if (this.mIsRegistered && (createTraceInfo = createTraceInfo(activity, str, obj, str2)) != null) {
            Track.getInstance().addTrackUI(createTraceInfo);
            Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
            while (it.hasNext()) {
                it.next().onAddTrackUI(createTraceInfo);
            }
        }
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5) {
        StringBuilder sb;
        String str6;
        String simpleName;
        Intent intent;
        String str7 = null;
        if (activity == null || TextUtils.isEmpty(str5)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = activity.getClass().getName();
        StringBuilder sb2 = new StringBuilder("@" + Integer.toHexString(hashCode()));
        String activityToken = getActivityToken(activity);
        if (!TextUtils.isEmpty(activityToken)) {
            sb2.append("[token:");
            sb2.append(activityToken);
            sb2.append(PreferencesUtil.RIGHT_MOUNT);
            sb2.toString();
        }
        if (AppConfig.isBeta() && (simpleName = activity.getClass().getSimpleName()) != null && simpleName.equals("BdBoxSchemeDispatchActivity") && (intent = activity.getIntent()) != null) {
            sb2.append("[intent:");
            sb2.append(intent.toString());
            sb2.append(PreferencesUtil.RIGHT_MOUNT);
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(PreferencesUtil.LEFT_MOUNT);
            sb2.append(str);
            sb2.append(PreferencesUtil.RIGHT_MOUNT);
        }
        if (obj != null) {
            String name2 = obj.getClass().getName();
            StringBuilder sb3 = new StringBuilder("@" + Integer.toHexString(obj.hashCode()));
            OnFragmentTraceListener onFragmentTraceListener = this.mOnFragmentListener;
            if (onFragmentTraceListener != null) {
                String onTrace = onFragmentTraceListener.onTrace(obj);
                if (!TextUtils.isEmpty(onTrace)) {
                    sb3.append(",extra=");
                    sb3.append(onTrace);
                }
            }
            sb = sb3;
            str6 = name2;
        } else {
            sb = null;
            str6 = null;
        }
        String sb4 = sb2.toString();
        if (sb != null) {
            str7 = sb.toString();
        }
        return new TrackUI(name, sb4, str6, str7, str2, str3, str4, currentTimeMillis, str5);
    }

    public String getActivityToken(Activity activity) {
        WindowManager.LayoutParams attributes;
        IBinder iBinder;
        if (activity == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT <= 26) {
            try {
                Object invoke = Activity.class.getDeclaredMethod("getActivityToken", new Class[0]).invoke(activity, new Object[0]);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (Throwable th) {
                if (AppConfig.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        Window window = activity.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null || (iBinder = attributes.token) == null) {
            return null;
        }
        return iBinder.toString();
    }

    public void register(Context context) {
        if (!this.mIsRegistered && context != null) {
            if (BdBoxActivityManager.getMainGlobalActivityLifecycle() == null) {
                BdBoxActivityManager.setMainGlobalActivityLifecycle(GlobalActivityLifecycle.getInstance());
            }
            TraceActivityCallbacks traceActivityCallbacks = new TraceActivityCallbacks();
            this.mTraceActivityCallbacks = traceActivityCallbacks;
            BdBoxActivityManager.registerLifeCycle(traceActivityCallbacks);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                this.mIsRegistered = true;
                TraceActivityCallbacks traceActivityCallbacks2 = this.mTraceActivityCallbacks;
                if (traceActivityCallbacks2 != null) {
                    traceActivityCallbacks2.registerTraceFragment(activity);
                }
                saveTraceInfo(activity, null, null, MiPushClient.COMMAND_REGISTER);
                return;
            }
            this.mIsRegistered = true;
        }
    }

    public void saveTraceInfo(@NonNull Activity activity, @Nullable Object obj, @Nullable String str, @Nullable String str2, @Nullable String str3, @NonNull String str4) {
        TrackUI createTraceInfo;
        if (this.mIsRegistered && (createTraceInfo = createTraceInfo(activity, null, obj, str, str2, str3, str4)) != null) {
            Track.getInstance().addTrackUI(createTraceInfo);
            Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
            while (it.hasNext()) {
                it.next().onAddTrackUI(createTraceInfo);
            }
        }
    }

    public void saveTraceInfo(@NonNull Activity activity, boolean z) {
        String str;
        if (!this.mIsRegistered) {
            return;
        }
        if (z) {
            str = TO_FOREGROUND;
        } else {
            str = TO_BACKGROUND;
        }
        TrackUI createTraceInfo = createTraceInfo(activity, null, null, str);
        if (createTraceInfo != null) {
            Track.getInstance().addTrackUI(createTraceInfo);
            Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
            while (it.hasNext()) {
                it.next().onAddTrackUI(createTraceInfo);
            }
        }
    }
}
