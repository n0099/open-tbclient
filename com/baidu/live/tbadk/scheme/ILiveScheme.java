package com.baidu.live.tbadk.scheme;

import android.content.Context;
import java.util.Map;
/* loaded from: classes11.dex */
public interface ILiveScheme {
    public static final String LIVE_ROOM_TYPE_AUDIO = "1";
    public static final String LIVE_ROOM_TYPE_DEFAULT = "0";

    void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback);
}
