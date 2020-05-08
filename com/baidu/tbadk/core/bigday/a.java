package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String arb;
    public int dlo;
    public long dlp;
    public int dlq;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.arb = bigdayInfo.jump_url;
                this.dlo = bigdayInfo.img_colour.intValue();
                this.dlp = bigdayInfo.id.longValue();
                this.dlq = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean aIj() {
        return !StringUtils.isNULL(this.imgUrl) && this.dlp > 0 && (this.dlq == 1 || this.dlq == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.aIj() && aIj() && this.dlp == aVar.dlp && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.arb == null && aVar.arb == null) || aq.equals(this.arb, aVar.arb)) && this.dlo == aVar.dlo && this.dlq == aVar.dlq && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
