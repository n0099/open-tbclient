package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String acH;
    public int acI;
    public long acJ;
    public int acK;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.acH = bigdayInfo.jump_url;
                this.acI = bigdayInfo.img_colour.intValue();
                this.acJ = bigdayInfo.id.longValue();
                this.acK = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean tt() {
        return !StringUtils.isNULL(this.imgUrl) && this.acJ > 0 && (this.acK == 1 || this.acK == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.tt() && tt() && this.acJ == aVar.acJ && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.acH == null && aVar.acH == null) || ap.equals(this.acH, aVar.acH)) && this.acI == aVar.acI && this.acK == aVar.acK && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
