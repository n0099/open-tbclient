package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String adc;
    public int ade;
    public long adf;
    public int adg;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.adc = bigdayInfo.jump_url;
                this.ade = bigdayInfo.img_colour.intValue();
                this.adf = bigdayInfo.id.longValue();
                this.adg = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean tI() {
        return !StringUtils.isNULL(this.imgUrl) && this.adf > 0 && (this.adg == 1 || this.adg == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.tI() && tI() && this.adf == aVar.adf && ap.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.adc == null && aVar.adc == null) || ap.equals(this.adc, aVar.adc)) && this.ade == aVar.ade && this.adg == aVar.adg && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
