package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aJH;
    public int eME;
    public long eMF;
    public int eMG;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aJH = bigdayInfo.jump_url;
                this.eME = bigdayInfo.img_colour.intValue();
                this.eMF = bigdayInfo.id.longValue();
                this.eMG = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean boC() {
        return !StringUtils.isNULL(this.imgUrl) && this.eMF > 0 && (this.eMG == 1 || this.eMG == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.boC() && boC() && this.eMF == aVar.eMF && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aJH == null && aVar.aJH == null) || at.equals(this.aJH, aVar.aJH)) && this.eME == aVar.eME && this.eMG == aVar.eMG && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
