package com.baidu.searchbox.live.interfaces.yy;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback;
import java.util.Map;
/* loaded from: classes9.dex */
public interface IYYLiveNPSPlugin {
    public static final String YY_ENV_CREATE_LIVE = "create_live";
    public static final String YY_ENV_ENTRANCE_PRE_INSTALL = "entrance_pre_install";

    void cancelLoad();

    void cancelStartYYLiveActivity();

    @Deprecated
    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map<String, Object> map);

    void dispatchYYLiveRouter(Context context, String str);

    void dispatchYYRawLiveRouter(Context context, String str);

    @Deprecated
    void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    boolean isAvailable();

    boolean isEnvReady(String str);

    boolean isLoaded();

    void loadPlugin(@NonNull Context context, LiveLoadStatusCallback liveLoadStatusCallback);

    void onDiskClearCacheChange(long j2, int i2, int i3, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void prepareYYEnv(String str, YYEnvResultCallback yYEnvResultCallback);

    void startYYActivity(@NonNull Context context);

    void startYYCustomerServiceActivity(Context context, String str);

    void startYYFeedbackActivity(Context context, String str);

    void startYYLiveActivity(Context context, String str);

    void updateStatInfo(YYStatInfo yYStatInfo);
}
