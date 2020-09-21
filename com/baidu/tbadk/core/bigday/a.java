package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aEb;
    public int dXp;
    public long dXq;
    public int dXr;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aEb = bigdayInfo.jump_url;
                this.dXp = bigdayInfo.img_colour.intValue();
                this.dXq = bigdayInfo.id.longValue();
                this.dXr = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bcN() {
        return !StringUtils.isNULL(this.imgUrl) && this.dXq > 0 && (this.dXr == 1 || this.dXr == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bcN() && bcN() && this.dXq == aVar.dXq && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aEb == null && aVar.aEb == null) || at.equals(this.aEb, aVar.aEb)) && this.dXp == aVar.dXp && this.dXr == aVar.dXr && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
