package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String acG;
    public int acH;
    public long acI;
    public int acJ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.acG = bigdayInfo.jump_url;
                this.acH = bigdayInfo.img_colour.intValue();
                this.acI = bigdayInfo.id.longValue();
                this.acJ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean tu() {
        return !StringUtils.isNULL(this.imgUrl) && this.acI > 0 && (this.acJ == 1 || this.acJ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.tu() && tu() && this.acI == aVar.acI && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.acG == null && aVar.acG == null) || ap.equals(this.acG, aVar.acG)) && this.acH == aVar.acH && this.acJ == aVar.acJ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
