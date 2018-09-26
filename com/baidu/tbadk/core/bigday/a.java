package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String afi;
    public int afj;
    public long afk;
    public int afl;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.afi = bigdayInfo.jump_url;
                this.afj = bigdayInfo.img_colour.intValue();
                this.afk = bigdayInfo.id.longValue();
                this.afl = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean uw() {
        return !StringUtils.isNULL(this.imgUrl) && this.afk > 0 && (this.afl == 1 || this.afl == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.uw() && uw() && this.afk == aVar.afk && ao.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.afi == null && aVar.afi == null) || ao.equals(this.afi, aVar.afi)) && this.afj == aVar.afj && this.afl == aVar.afl && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
