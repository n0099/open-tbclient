package com.baidu.live.tbadk.statics;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class HKStaticManager {
    public static String LIVE_ID = "";
    public static String ROOM_ID = "";
    public static String FEED_ID = "";

    public static void staticStartPlayTime(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        LIVE_ID = str;
        ROOM_ID = str2;
        FEED_ID = str5;
        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_PLAYTIME_START);
        alaStaticItem.addParams("live_id", str);
        alaStaticItem.addParams("room_id", str2);
        alaStaticItem.addParams("feed_id", str5);
        alaStaticItem.addParams("author_id", str3);
        alaStaticItem.addParams("author", str4);
        alaStaticItem.addParams("other_params", str6);
        alaStaticItem.addParams("start_time", j + "");
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    public static void staticEndPlayTime(String str, String str2, String str3, String str4, long j, String str5, String str6) {
        if (TextUtils.isEmpty(str)) {
            str = LIVE_ID;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ROOM_ID;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = FEED_ID;
        }
        LIVE_ID = "";
        ROOM_ID = "";
        FEED_ID = "";
        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_PLAYTIME_END);
        alaStaticItem.addParams("live_id", str);
        alaStaticItem.addParams("room_id", str2);
        alaStaticItem.addParams("feed_id", str5);
        alaStaticItem.addParams("author_id", str3);
        alaStaticItem.addParams("author", str4);
        alaStaticItem.addParams("other_params", str6);
        alaStaticItem.addParams("end_time", j + "");
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }
}
