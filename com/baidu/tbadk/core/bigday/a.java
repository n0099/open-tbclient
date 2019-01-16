package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aoW;
    public int aoX;
    public long aoY;
    public int aoZ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aoW = bigdayInfo.jump_url;
                this.aoX = bigdayInfo.img_colour.intValue();
                this.aoY = bigdayInfo.id.longValue();
                this.aoZ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean ye() {
        return !StringUtils.isNULL(this.imgUrl) && this.aoY > 0 && (this.aoZ == 1 || this.aoZ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.ye() && ye() && this.aoY == aVar.aoY && ao.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aoW == null && aVar.aoW == null) || ao.equals(this.aoW, aVar.aoW)) && this.aoX == aVar.aoX && this.aoZ == aVar.aoZ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
