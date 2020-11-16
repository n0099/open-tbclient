package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aGz;
    public long endTime;
    public int evZ;
    public long ewa;
    public int ewb;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aGz = bigdayInfo.jump_url;
                this.evZ = bigdayInfo.img_colour.intValue();
                this.ewa = bigdayInfo.id.longValue();
                this.ewb = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean biS() {
        return !StringUtils.isNULL(this.imgUrl) && this.ewa > 0 && (this.ewb == 1 || this.ewb == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.biS() && biS() && this.ewa == aVar.ewa && au.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aGz == null && aVar.aGz == null) || au.equals(this.aGz, aVar.aGz)) && this.evZ == aVar.evZ && this.ewb == aVar.ewb && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
