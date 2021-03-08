package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aIQ;
    public int eLA;
    public long eLB;
    public int eLC;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aIQ = bigdayInfo.jump_url;
                this.eLA = bigdayInfo.img_colour.intValue();
                this.eLB = bigdayInfo.id.longValue();
                this.eLC = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean blc() {
        return !StringUtils.isNULL(this.imgUrl) && this.eLB > 0 && (this.eLC == 1 || this.eLC == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.blc() && blc() && this.eLB == aVar.eLB && au.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aIQ == null && aVar.aIQ == null) || au.equals(this.aIQ, aVar.aIQ)) && this.eLA == aVar.eLA && this.eLC == aVar.eLC && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
