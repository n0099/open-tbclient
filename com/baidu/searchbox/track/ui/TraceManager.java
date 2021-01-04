package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class TraceManager {
    private static final String TO_BACKGROUND = "To background";
    private static final String TO_FOREGROUND = "To foreground";
    private static volatile TraceManager sInstance;
    private volatile boolean mIsRegistered = false;
    private OnFragmentTraceListener mOnFragmentListener;
    private TraceActivityCallbacks mTraceActivityCallbacks;

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

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean checkAPSActivity(Activity activity) {
        return activity.getClass().getName().startsWith("com.baidu.megapp.proxy.activity");
    }

    protected String getActivityToken(Activity activity) {
        WindowManager.LayoutParams attributes;
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
        if (window == null || (attributes = window.getAttributes()) == null || attributes.token == null) {
            return null;
        }
        return attributes.token.toString();
    }

    protected void release() {
        if (sInstance != null) {
            if (sInstance.mTraceActivityCallbacks != null) {
                BdBoxActivityManager.unregisterLifeCycle(sInstance.mTraceActivityCallbacks);
                sInstance.mTraceActivityCallbacks = null;
            }
            this.mIsRegistered = false;
            sInstance = null;
        }
    }

    public void register(Context context) {
        if (!this.mIsRegistered && context != null) {
            if (BdBoxActivityManager.getMainGlobalActivityLifecycle() == null) {
                BdBoxActivityManager.setMainGlobalActivityLifecycle(GlobalActivityLifecycle.getInstance());
            }
            this.mTraceActivityCallbacks = new TraceActivityCallbacks();
            BdBoxActivityManager.registerLifeCycle(this.mTraceActivityCallbacks);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    this.mIsRegistered = true;
                    if (this.mTraceActivityCallbacks != null) {
                        this.mTraceActivityCallbacks.registerTraceFragment(activity);
                    }
                    saveTraceInfo(activity, null, null, MiPushClient.COMMAND_REGISTER);
                    return;
                }
                return;
            }
            this.mIsRegistered = true;
        }
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
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

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveTraceInfo(@NonNull Activity activity, boolean z) {
        if (this.mIsRegistered) {
            TrackUI createTraceInfo = createTraceInfo(activity, null, null, z ? TO_FOREGROUND : TO_BACKGROUND);
            if (createTraceInfo != null) {
                Track.getInstance().addTrackUI(createTraceInfo);
                Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
                while (it.hasNext()) {
                    it.next().onAddTrackUI(createTraceInfo);
                }
            }
        }
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @NonNull String str2) {
        return createTraceInfo(activity, str, obj, null, null, "native", str2);
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5) {
        StringBuilder sb;
        String simpleName;
        Intent intent;
        if (activity == null || TextUtils.isEmpty(str5)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = activity.getClass().getName();
        StringBuilder sb2 = new StringBuilder("@" + Integer.toHexString(hashCode()));
        String activityToken = getActivityToken(activity);
        if (!TextUtils.isEmpty(activityToken)) {
            sb2.append("[token:").append(activityToken).append("]").toString();
        }
        if (AppConfig.isBeta() && (simpleName = activity.getClass().getSimpleName()) != null && simpleName.equals("BdBoxSchemeDispatchActivity") && (intent = activity.getIntent()) != null) {
            sb2.append("[intent:").append(intent.toString()).append("]");
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append("[").append(str).append("]");
        }
        String str6 = null;
        if (obj == null) {
            sb = null;
        } else {
            str6 = obj.getClass().getName();
            StringBuilder sb3 = new StringBuilder("@" + Integer.toHexString(obj.hashCode()));
            if (this.mOnFragmentListener != null) {
                String onTrace = this.mOnFragmentListener.onTrace(obj);
                if (!TextUtils.isEmpty(onTrace)) {
                    sb3.append(",extra=").append(onTrace);
                }
            }
            sb = sb3;
        }
        return new TrackUI(name, sb2.toString(), str6, sb == null ? null : sb.toString(), str2, str3, str4, currentTimeMillis, str5);
    }

    public void setOnFragmentListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        this.mOnFragmentListener = onFragmentTraceListener;
    }
}
