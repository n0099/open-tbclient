package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aEU;
    public int eHT;
    public long eHU;
    public int eHV;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aEU = bigdayInfo.jump_url;
                this.eHT = bigdayInfo.img_colour.intValue();
                this.eHU = bigdayInfo.id.longValue();
                this.eHV = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bkI() {
        return !StringUtils.isNULL(this.imgUrl) && this.eHU > 0 && (this.eHV == 1 || this.eHV == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bkI() && bkI() && this.eHU == aVar.eHU && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aEU == null && aVar.aEU == null) || at.equals(this.aEU, aVar.aEU)) && this.eHT == aVar.eHT && this.eHV == aVar.eHV && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
