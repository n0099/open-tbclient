package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bDN;
    public int bDO;
    public long bDP;
    public int bDQ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bDN = bigdayInfo.jump_url;
                this.bDO = bigdayInfo.img_colour.intValue();
                this.bDP = bigdayInfo.id.longValue();
                this.bDQ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean acn() {
        return !StringUtils.isNULL(this.imgUrl) && this.bDP > 0 && (this.bDQ == 1 || this.bDQ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.acn() && acn() && this.bDP == aVar.bDP && aq.bV(this.imgUrl, aVar.imgUrl)) {
                return ((this.bDN == null && aVar.bDN == null) || aq.bV(this.bDN, aVar.bDN)) && this.bDO == aVar.bDO && this.bDQ == aVar.bDQ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
