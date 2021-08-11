package com.baidu.searchbox.live.interfaces;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveBjhEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveMediaEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveYuYinEntry;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import java.util.Map;
/* loaded from: classes5.dex */
public interface ILiveNPSPlugin {
    public static final String PARAMS_ROOM_ID = "roomId";
    public static final String PARAMS_SCHEME = "scheme";
    public static final String PARAMS_SOURCE = "source";

    void clearLiveResourceSize(@NonNull Context context);

    void dispatchHostEvent(Context context, String str, Map<String, Object> map);

    @Deprecated
    ILiveBjhEntry getLiveBjhEntry();

    ILiveMediaEntry getLiveMediaEntry();

    void getLiveResourceSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback);

    void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback);

    void getLiveSdkSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback);

    @Deprecated
    ILiveShowEntry getLiveShowEntry();

    @Deprecated
    ILiveShowMasterEntry getLiveShowMasterEntry();

    @Deprecated
    ILiveYuYinEntry getLiveYuYinEntry();

    IYYLiveNPSPlugin getYYLiveEntry();

    void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback);

    void onDiskClearCacheChange(long j2, int i2, int i3, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void startMasterActivity(Context context, String str);

    void startMasterActivity(Context context, String str, @NonNull String str2);
}
