package com.baidu.mobstat;

import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes15.dex */
public class MtjConfig {
    public static final String BAIDU_MTJ_PUSH_CALL = "Baidu_mtj_push_call";
    public static final String BAIDU_MTJ_PUSH_MSG = "Baidu_mtj_push_msg";

    /* loaded from: classes15.dex */
    public enum FeedTrackStrategy {
        TRACK_ALL,
        TRACK_SINGLE,
        TRACK_NONE
    }

    /* loaded from: classes15.dex */
    public enum PushPlatform {
        BAIDUYUN("baiduyun", 0),
        JIGUANG("jiguang", 1),
        GETUI("getui", 2),
        HUAWEI(RomUtils.MANUFACTURER_HUAWEI, 3),
        XIAOMI(RomUtils.MANUFACTURER_XIAOMI, 4),
        UMENG("umeng", 5),
        XINGE("xinge", 6),
        ALIYUN("aliyun", 7),
        OPPO(RomUtils.MANUFACTURER_OPPO, 8),
        MEIZU(RomUtils.MANUFACTURER_MEIZU, 9);
        

        /* renamed from: a  reason: collision with root package name */
        private String f3660a;

        /* renamed from: b  reason: collision with root package name */
        private int f3661b;

        PushPlatform(String str, int i) {
            this.f3660a = str;
            this.f3661b = i;
        }

        public String value() {
            return "p" + this.f3661b;
        }

        public String showName() {
            return this.f3660a;
        }
    }
}
