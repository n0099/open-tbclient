package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String auL;
    public int dzo;
    public long dzp;
    public int dzq;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.auL = bigdayInfo.jump_url;
                this.dzo = bigdayInfo.img_colour.intValue();
                this.dzp = bigdayInfo.id.longValue();
                this.dzq = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean aNX() {
        return !StringUtils.isNULL(this.imgUrl) && this.dzp > 0 && (this.dzq == 1 || this.dzq == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.aNX() && aNX() && this.dzp == aVar.dzp && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.auL == null && aVar.auL == null) || aq.equals(this.auL, aVar.auL)) && this.dzo == aVar.dzo && this.dzq == aVar.dzq && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
