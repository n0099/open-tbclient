package com.baidu.sapi2.result;

import android.util.Pair;
/* loaded from: classes.dex */
public class SafeFacadeResult extends SofireResult {
    public static final int ERROR_CODE_BIND_DEVICES_FAILED = -3;
    public static final String ERROR_MSG_BIND_DEVICES_FAILED = "获取关联设备唯一值失败";
    public Pair<Integer, Object> safeItems;
    public Pair<Integer, Object> safeToken = null;

    public SafeFacadeResult() {
        this.msgMap.put(-3, ERROR_MSG_BIND_DEVICES_FAILED);
    }
}
