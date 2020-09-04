package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aDi;
    public int dVf;
    public long dVg;
    public int dVh;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aDi = bigdayInfo.jump_url;
                this.dVf = bigdayInfo.img_colour.intValue();
                this.dVg = bigdayInfo.id.longValue();
                this.dVh = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bbT() {
        return !StringUtils.isNULL(this.imgUrl) && this.dVg > 0 && (this.dVh == 1 || this.dVh == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bbT() && bbT() && this.dVg == aVar.dVg && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aDi == null && aVar.aDi == null) || at.equals(this.aDi, aVar.aDi)) && this.dVf == aVar.dVf && this.dVh == aVar.dVh && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
