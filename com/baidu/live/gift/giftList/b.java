package com.baidu.live.gift.giftList;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes6.dex */
public class b {
    public static long ach = 604800000;

    public static String h(String str, long j) {
        return "cache_key_gift_list_json_array" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j;
    }
}
