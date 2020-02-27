package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String cLQ;
    public int cLR;
    public long cLS;
    public int cLT;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.cLQ = bigdayInfo.jump_url;
                this.cLR = bigdayInfo.img_colour.intValue();
                this.cLS = bigdayInfo.id.longValue();
                this.cLT = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean azT() {
        return !StringUtils.isNULL(this.imgUrl) && this.cLS > 0 && (this.cLT == 1 || this.cLT == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.azT() && azT() && this.cLS == aVar.cLS && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.cLQ == null && aVar.cLQ == null) || aq.equals(this.cLQ, aVar.cLQ)) && this.cLR == aVar.cLR && this.cLT == aVar.cLT && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
