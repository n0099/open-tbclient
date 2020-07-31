package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aye;
    public int dLS;
    public long dLT;
    public int dLU;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aye = bigdayInfo.jump_url;
                this.dLS = bigdayInfo.img_colour.intValue();
                this.dLT = bigdayInfo.id.longValue();
                this.dLU = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean aTC() {
        return !StringUtils.isNULL(this.imgUrl) && this.dLT > 0 && (this.dLU == 1 || this.dLU == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.aTC() && aTC() && this.dLT == aVar.dLT && as.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aye == null && aVar.aye == null) || as.equals(this.aye, aVar.aye)) && this.dLS == aVar.dLS && this.dLU == aVar.dLU && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
