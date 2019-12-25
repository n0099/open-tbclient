package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String cHB;
    public int cHC;
    public long cHD;
    public int cHE;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.cHB = bigdayInfo.jump_url;
                this.cHC = bigdayInfo.img_colour.intValue();
                this.cHD = bigdayInfo.id.longValue();
                this.cHE = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean axm() {
        return !StringUtils.isNULL(this.imgUrl) && this.cHD > 0 && (this.cHE == 1 || this.cHE == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.axm() && axm() && this.cHD == aVar.cHD && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.cHB == null && aVar.cHB == null) || aq.equals(this.cHB, aVar.cHB)) && this.cHC == aVar.cHC && this.cHE == aVar.cHE && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
