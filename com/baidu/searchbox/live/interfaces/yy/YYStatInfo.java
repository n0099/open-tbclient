package com.baidu.searchbox.live.interfaces.yy;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class YYStatInfo {
    public static final String LOAD_TYPE_LOADED = "launch";
    public static final String LOAD_TYPE_NOT_DOWNLOAD = "download";
    public static final String LOAD_TYPE_NOT_INSTALL = "install";
    public static final String LOAD_TYPE_NOT_LOAD = "load";
    public Object flowObj;
    @Deprecated
    public boolean isColdLaunch;
    public String loadType;
    public HashMap<String, Object> statInfo;
}
