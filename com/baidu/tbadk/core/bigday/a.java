package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bEl;
    public int bEm;
    public long bEn;
    public int bEo;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bEl = bigdayInfo.jump_url;
                this.bEm = bigdayInfo.img_colour.intValue();
                this.bEn = bigdayInfo.id.longValue();
                this.bEo = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean acr() {
        return !StringUtils.isNULL(this.imgUrl) && this.bEn > 0 && (this.bEo == 1 || this.bEo == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.acr() && acr() && this.bEn == aVar.bEn && aq.bV(this.imgUrl, aVar.imgUrl)) {
                return ((this.bEl == null && aVar.bEl == null) || aq.bV(this.bEl, aVar.bEl)) && this.bEm == aVar.bEm && this.bEo == aVar.bEo && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
