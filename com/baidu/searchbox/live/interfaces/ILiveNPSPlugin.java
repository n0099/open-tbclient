package com.baidu.searchbox.live.interfaces;

import android.content.Context;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveBjhEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveMediaEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYCashierEntry;
import com.baidu.searchbox.live.interfaces.entry.ILiveYuYinEntry;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import java.util.Map;
/* loaded from: classes2.dex */
public interface ILiveNPSPlugin {
    public static final String PARAMS_ROOM_ID = "roomId";
    public static final String PARAMS_SCHEME = "scheme";
    public static final String PARAMS_SOURCE = "source";

    void clearLiveResourceSize(Context context);

    void dispatchHostEvent(Context context, String str, Map map);

    @Deprecated
    ILiveBjhEntry getLiveBjhEntry();

    ILiveMediaEntry getLiveMediaEntry();

    void getLiveResourceSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    void getLiveRoomStatus(String str, LiveStatusDataCallback liveStatusDataCallback);

    void getLiveSdkSize(Context context, ILiveFileSizeCallback iLiveFileSizeCallback);

    @Deprecated
    ILiveShowEntry getLiveShowEntry();

    @Deprecated
    ILiveShowMasterEntry getLiveShowMasterEntry();

    @Deprecated
    ILiveYuYinEntry getLiveYuYinEntry();

    Map getPlayConfig(String str, Map map);

    ILiveYYCashierEntry getYYCashierEntry();

    @Deprecated
    IYYLiveNPSPlugin getYYLiveEntry();

    void isInHistory(String str, LiveStatusDataCallback liveStatusDataCallback);

    void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback);

    void startMasterActivity(Context context, String str);

    void startMasterActivity(Context context, String str, String str2);
}
