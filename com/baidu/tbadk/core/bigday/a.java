package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aoX;
    public int aoY;
    public long aoZ;
    public int apa;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aoX = bigdayInfo.jump_url;
                this.aoY = bigdayInfo.img_colour.intValue();
                this.aoZ = bigdayInfo.id.longValue();
                this.apa = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean ye() {
        return !StringUtils.isNULL(this.imgUrl) && this.aoZ > 0 && (this.apa == 1 || this.apa == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.ye() && ye() && this.aoZ == aVar.aoZ && ao.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aoX == null && aVar.aoX == null) || ao.equals(this.aoX, aVar.aoX)) && this.aoY == aVar.aoY && this.apa == aVar.apa && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
