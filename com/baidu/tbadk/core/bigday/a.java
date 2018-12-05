package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aou;
    public int aov;
    public long aow;
    public int aox;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aou = bigdayInfo.jump_url;
                this.aov = bigdayInfo.img_colour.intValue();
                this.aow = bigdayInfo.id.longValue();
                this.aox = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean xR() {
        return !StringUtils.isNULL(this.imgUrl) && this.aow > 0 && (this.aox == 1 || this.aox == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.xR() && xR() && this.aow == aVar.aow && ao.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aou == null && aVar.aou == null) || ao.equals(this.aou, aVar.aou)) && this.aov == aVar.aov && this.aox == aVar.aox && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
