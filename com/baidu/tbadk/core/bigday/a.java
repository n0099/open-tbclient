package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String awR;
    public int dFH;
    public long dFI;
    public int dFJ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.awR = bigdayInfo.jump_url;
                this.dFH = bigdayInfo.img_colour.intValue();
                this.dFI = bigdayInfo.id.longValue();
                this.dFJ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean aPH() {
        return !StringUtils.isNULL(this.imgUrl) && this.dFI > 0 && (this.dFJ == 1 || this.dFJ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.aPH() && aPH() && this.dFI == aVar.dFI && ar.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.awR == null && aVar.awR == null) || ar.equals(this.awR, aVar.awR)) && this.dFH == aVar.dFH && this.dFJ == aVar.dFJ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
