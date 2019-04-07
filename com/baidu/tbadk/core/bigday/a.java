package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bvL;
    public int bvM;
    public long bvN;
    public int bvO;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bvL = bigdayInfo.jump_url;
                this.bvM = bigdayInfo.img_colour.intValue();
                this.bvN = bigdayInfo.id.longValue();
                this.bvO = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean WI() {
        return !StringUtils.isNULL(this.imgUrl) && this.bvN > 0 && (this.bvO == 1 || this.bvO == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.WI() && WI() && this.bvN == aVar.bvN && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bvL == null && aVar.bvL == null) || ap.equals(this.bvL, aVar.bvL)) && this.bvM == aVar.bvM && this.bvO == aVar.bvO && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
