package com.baidu.live.gift;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes4.dex */
public class h {
    public static long aIq = 604800000;

    public static String f(String str, long j) {
        return "cache_key_gift_list_json_array" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j;
    }
}
