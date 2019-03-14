package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bvI;
    public int bvJ;
    public long bvK;
    public int bvL;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bvI = bigdayInfo.jump_url;
                this.bvJ = bigdayInfo.img_colour.intValue();
                this.bvK = bigdayInfo.id.longValue();
                this.bvL = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean WL() {
        return !StringUtils.isNULL(this.imgUrl) && this.bvK > 0 && (this.bvL == 1 || this.bvL == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.WL() && WL() && this.bvK == aVar.bvK && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bvI == null && aVar.bvI == null) || ap.equals(this.bvI, aVar.bvI)) && this.bvJ == aVar.bvJ && this.bvL == aVar.bvL && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
