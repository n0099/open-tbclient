package com.baidu.searchbox.live.interfaces.yy;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class YYStatInfo {
    public static final String LOAD_TYPE_LOADED = "launch";
    public static final String LOAD_TYPE_NOT_DOWNLOAD = "download";
    public static final String LOAD_TYPE_NOT_INSTALL = "install";
    public static final String LOAD_TYPE_NOT_LOAD = "load";
    public Object flowAudioObj;
    public Object flowAudioRtcObj;
    public Object flowObj;
    @Deprecated
    public boolean isColdLaunch;
    public String loadType;
    public String roomId;
    public HashMap<String, Object> statInfo;
}
