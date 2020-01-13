package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String cHN;
    public int cHO;
    public long cHP;
    public int cHQ;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.cHN = bigdayInfo.jump_url;
                this.cHO = bigdayInfo.img_colour.intValue();
                this.cHP = bigdayInfo.id.longValue();
                this.cHQ = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean axF() {
        return !StringUtils.isNULL(this.imgUrl) && this.cHP > 0 && (this.cHQ == 1 || this.cHQ == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.axF() && axF() && this.cHP == aVar.cHP && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.cHN == null && aVar.cHN == null) || aq.equals(this.cHN, aVar.cHN)) && this.cHO == aVar.cHO && this.cHQ == aVar.cHQ && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
