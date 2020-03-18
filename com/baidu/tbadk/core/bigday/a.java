package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String cMd;
    public int cMe;
    public long cMf;
    public int cMg;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.cMd = bigdayInfo.jump_url;
                this.cMe = bigdayInfo.img_colour.intValue();
                this.cMf = bigdayInfo.id.longValue();
                this.cMg = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean azY() {
        return !StringUtils.isNULL(this.imgUrl) && this.cMf > 0 && (this.cMg == 1 || this.cMg == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.azY() && azY() && this.cMf == aVar.cMf && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.cMd == null && aVar.cMd == null) || aq.equals(this.cMd, aVar.cMd)) && this.cMe == aVar.cMe && this.cMg == aVar.cMg && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
