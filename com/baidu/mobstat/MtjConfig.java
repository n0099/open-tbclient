package com.baidu.mobstat;

import com.baidu.android.util.devices.RomUtils;
import com.ss.android.download.api.constant.BaseConstants;
/* loaded from: classes2.dex */
public class MtjConfig {
    public static final String BAIDU_MTJ_PUSH_CALL = "Baidu_mtj_push_call";
    public static final String BAIDU_MTJ_PUSH_MSG = "Baidu_mtj_push_msg";

    /* loaded from: classes2.dex */
    public enum FeedTrackStrategy {
        TRACK_ALL,
        TRACK_SINGLE,
        TRACK_NONE
    }

    /* loaded from: classes2.dex */
    public enum PushPlatform {
        BAIDUYUN("baiduyun", 0),
        JIGUANG("jiguang", 1),
        GETUI("getui", 2),
        HUAWEI(RomUtils.MANUFACTURER_HUAWEI, 3),
        XIAOMI(RomUtils.MANUFACTURER_XIAOMI, 4),
        UMENG(BaseConstants.CATEGORY_UMENG, 5),
        XINGE("xinge", 6),
        ALIYUN("aliyun", 7),
        OPPO("oppo", 8),
        MEIZU("meizu", 9);
        
        public String a;
        public int b;

        PushPlatform(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public String showName() {
            return this.a;
        }

        public String value() {
            return "p" + this.b;
        }
    }
}
