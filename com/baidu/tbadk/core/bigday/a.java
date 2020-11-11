package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aIk;
    public long endTime;
    public int exJ;
    public long exK;
    public int exL;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aIk = bigdayInfo.jump_url;
                this.exJ = bigdayInfo.img_colour.intValue();
                this.exK = bigdayInfo.id.longValue();
                this.exL = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bjO() {
        return !StringUtils.isNULL(this.imgUrl) && this.exK > 0 && (this.exL == 1 || this.exL == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bjO() && bjO() && this.exK == aVar.exK && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aIk == null && aVar.aIk == null) || at.equals(this.aIk, aVar.aIk)) && this.exJ == aVar.exJ && this.exL == aVar.exL && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
