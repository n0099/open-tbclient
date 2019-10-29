package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bWc;
    public int bWd;
    public long bWe;
    public int bWf;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bWc = bigdayInfo.jump_url;
                this.bWd = bigdayInfo.img_colour.intValue();
                this.bWe = bigdayInfo.id.longValue();
                this.bWf = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean agx() {
        return !StringUtils.isNULL(this.imgUrl) && this.bWe > 0 && (this.bWf == 1 || this.bWf == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.agx() && agx() && this.bWe == aVar.bWe && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bWc == null && aVar.bWc == null) || aq.equals(this.bWc, aVar.bWc)) && this.bWd == aVar.bWd && this.bWf == aVar.bWf && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
