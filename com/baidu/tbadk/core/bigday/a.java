package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String cLR;
    public int cLS;
    public long cLT;
    public int cLU;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.cLR = bigdayInfo.jump_url;
                this.cLS = bigdayInfo.img_colour.intValue();
                this.cLT = bigdayInfo.id.longValue();
                this.cLU = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean azV() {
        return !StringUtils.isNULL(this.imgUrl) && this.cLT > 0 && (this.cLU == 1 || this.cLU == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.azV() && azV() && this.cLT == aVar.cLT && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.cLR == null && aVar.cLR == null) || aq.equals(this.cLR, aVar.cLR)) && this.cLS == aVar.cLS && this.cLU == aVar.cLU && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
