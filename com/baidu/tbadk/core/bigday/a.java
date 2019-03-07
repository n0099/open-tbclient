package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bvG;
    public int bvH;
    public long bvI;
    public int bvJ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bvG = bigdayInfo.jump_url;
                this.bvH = bigdayInfo.img_colour.intValue();
                this.bvI = bigdayInfo.id.longValue();
                this.bvJ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean WL() {
        return !StringUtils.isNULL(this.imgUrl) && this.bvI > 0 && (this.bvJ == 1 || this.bvJ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.WL() && WL() && this.bvI == aVar.bvI && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bvG == null && aVar.bvG == null) || ap.equals(this.bvG, aVar.bvG)) && this.bvH == aVar.bvH && this.bvJ == aVar.bvJ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
