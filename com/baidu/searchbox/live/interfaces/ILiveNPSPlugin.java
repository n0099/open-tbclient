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
/* loaded from: classes2.dex */
public interface ILiveNPSPlugin {
    public static final String PARAMS_ROOM_ID = "roomId";
    public static final String PARAMS_SCHEME = "scheme";
    public static final String PARAMS_SOURCE = "source";

    void clearLiveResourceSize(@NonNull Context context);

    ILiveBjhEntry getLiveBjhEntry();

    ILiveMediaEntry getLiveMediaEntry();

    void getLiveResourceSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback);

    void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback);

    void getLiveSdkSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback);

    ILiveShowEntry getLiveShowEntry();

    ILiveShowMasterEntry getLiveShowMasterEntry();

    ILiveYuYinEntry getLiveYuYinEntry();

    void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);
}
