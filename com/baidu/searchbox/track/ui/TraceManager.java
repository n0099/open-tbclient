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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TraceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TO_BACKGROUND = "To background";
    public static final String TO_FOREGROUND = "To foreground";
    public static volatile TraceManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean mIsRegistered;
    public OnFragmentTraceListener mOnFragmentListener;
    public TraceActivityCallbacks mTraceActivityCallbacks;

    public TraceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsRegistered = false;
    }

    public static TraceManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sInstance == null) {
                synchronized (TraceManager.class) {
                    if (sInstance == null) {
                        sInstance = new TraceManager();
                    }
                }
            }
            return sInstance;
        }
        return (TraceManager) invokeV.objValue;
    }

    public boolean isRegistered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIsRegistered;
        }
        return invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && sInstance != null) {
            if (sInstance.mTraceActivityCallbacks != null) {
                BdBoxActivityManager.unregisterLifeCycle(sInstance.mTraceActivityCallbacks);
                sInstance.mTraceActivityCallbacks = null;
            }
            this.mIsRegistered = false;
            sInstance = null;
        }
    }

    public static boolean checkAPSActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            return activity.getClass().getName().startsWith("com.baidu.megapp.proxy.activity");
        }
        return invokeL.booleanValue;
    }

    public void setOnFragmentListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onFragmentTraceListener) == null) {
            this.mOnFragmentListener = onFragmentTraceListener;
        }
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, activity, str, obj, str2)) == null) {
            return createTraceInfo(activity, str, obj, null, null, "native", str2);
        }
        return (TrackUI) invokeLLLL.objValue;
    }

    private TrackUI createTraceInfo(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5) {
        InterceptResult invokeCommon;
        StringBuilder sb;
        String str6;
        String simpleName;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{activity, str, obj, str2, str3, str4, str5})) == null) {
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
        return (TrackUI) invokeCommon.objValue;
    }

    public String getActivityToken(Activity activity) {
        InterceptResult invokeL;
        WindowManager.LayoutParams attributes;
        IBinder iBinder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
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
        return (String) invokeL.objValue;
    }

    public void register(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && !this.mIsRegistered && context != null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, obj, str, str2, str3, str4}) == null) && this.mIsRegistered && (createTraceInfo = createTraceInfo(activity, null, obj, str, str2, str3, str4)) != null) {
            Track.getInstance().addTrackUI(createTraceInfo);
            Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
            while (it.hasNext()) {
                it.next().onAddTrackUI(createTraceInfo);
            }
        }
    }

    public void saveTraceInfo(Activity activity, String str, Object obj, String str2) {
        TrackUI createTraceInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048581, this, activity, str, obj, str2) == null) && this.mIsRegistered && (createTraceInfo = createTraceInfo(activity, str, obj, str2)) != null) {
            Track.getInstance().addTrackUI(createTraceInfo);
            Iterator<Track.OnTrackUIListener> it = Track.getInstance().getTrackUIListeners().iterator();
            while (it.hasNext()) {
                it.next().onAddTrackUI(createTraceInfo);
            }
        }
    }

    public void saveTraceInfo(@NonNull Activity activity, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048582, this, activity, z) != null) || !this.mIsRegistered) {
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
