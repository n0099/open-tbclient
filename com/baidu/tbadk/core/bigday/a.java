package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bCP;
    public int bCQ;
    public long bCR;
    public int bCS;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bCP = bigdayInfo.jump_url;
                this.bCQ = bigdayInfo.img_colour.intValue();
                this.bCR = bigdayInfo.id.longValue();
                this.bCS = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean abo() {
        return !StringUtils.isNULL(this.imgUrl) && this.bCR > 0 && (this.bCS == 1 || this.bCS == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.abo() && abo() && this.bCR == aVar.bCR && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bCP == null && aVar.bCP == null) || ap.equals(this.bCP, aVar.bCP)) && this.bCQ == aVar.bCQ && this.bCS == aVar.bCS && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
