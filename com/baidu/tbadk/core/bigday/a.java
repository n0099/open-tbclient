package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aHq;
    public int eJZ;
    public long eKa;
    public int eKb;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aHq = bigdayInfo.jump_url;
                this.eJZ = bigdayInfo.img_colour.intValue();
                this.eKa = bigdayInfo.id.longValue();
                this.eKb = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bla() {
        return !StringUtils.isNULL(this.imgUrl) && this.eKa > 0 && (this.eKb == 1 || this.eKb == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bla() && bla() && this.eKa == aVar.eKa && au.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aHq == null && aVar.aHq == null) || au.equals(this.aHq, aVar.aHq)) && this.eJZ == aVar.eJZ && this.eKb == aVar.eKb && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
