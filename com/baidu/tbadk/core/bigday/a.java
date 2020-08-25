package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes2.dex */
public class a {
    public String aDg;
    public int dVb;
    public long dVc;
    public int dVd;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aDg = bigdayInfo.jump_url;
                this.dVb = bigdayInfo.img_colour.intValue();
                this.dVc = bigdayInfo.id.longValue();
                this.dVd = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bbT() {
        return !StringUtils.isNULL(this.imgUrl) && this.dVc > 0 && (this.dVd == 1 || this.dVd == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bbT() && bbT() && this.dVc == aVar.dVc && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aDg == null && aVar.aDg == null) || at.equals(this.aDg, aVar.aDg)) && this.dVb == aVar.dVb && this.dVd == aVar.dVd && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
