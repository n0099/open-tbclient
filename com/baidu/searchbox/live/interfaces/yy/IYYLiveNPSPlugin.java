package com.baidu.searchbox.live.interfaces.yy;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import java.util.Map;
/* loaded from: classes3.dex */
public interface IYYLiveNPSPlugin {
    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map<String, Object> map);

    void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void startYYActivity(@NonNull Context context);

    void startYYCustomerServiceActivity(Context context, String str);

    void startYYFeedbackActivity(Context context, String str);

    void startYYLiveActivity(Context context, String str);
}
