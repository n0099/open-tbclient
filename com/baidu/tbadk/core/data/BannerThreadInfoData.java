package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.FrsPage.BannerThreadInfo;
/* loaded from: classes.dex */
public class BannerThreadInfoData implements Serializable {
    public static final int FORUM_FROM_MISS = 1;
    public static final int FORUM_FROM_NORMAL = 0;
    private static final long serialVersionUID = -5446966999595522426L;
    public int from = 0;
    public bl threadData;

    public void parserProtobuf(BannerThreadInfo bannerThreadInfo) {
        if (bannerThreadInfo != null) {
            if (this.threadData == null) {
                this.threadData = new bl();
            }
            this.threadData.a(bannerThreadInfo.thread_info);
            if (bannerThreadInfo.from instanceof Integer) {
                this.from = bannerThreadInfo.from.intValue();
            }
        }
    }
}
