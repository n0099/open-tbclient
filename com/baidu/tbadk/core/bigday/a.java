package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.au;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aJj;
    public int eDa;
    public long eDb;
    public int eDc;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aJj = bigdayInfo.jump_url;
                this.eDa = bigdayInfo.img_colour.intValue();
                this.eDb = bigdayInfo.id.longValue();
                this.eDc = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bmc() {
        return !StringUtils.isNULL(this.imgUrl) && this.eDb > 0 && (this.eDc == 1 || this.eDc == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bmc() && bmc() && this.eDb == aVar.eDb && au.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aJj == null && aVar.aJj == null) || au.equals(this.aJj, aVar.aJj)) && this.eDa == aVar.eDa && this.eDc == aVar.eDc && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
