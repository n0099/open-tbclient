package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aqV;
    public int dlk;
    public long dll;
    public int dlm;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aqV = bigdayInfo.jump_url;
                this.dlk = bigdayInfo.img_colour.intValue();
                this.dll = bigdayInfo.id.longValue();
                this.dlm = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean aIl() {
        return !StringUtils.isNULL(this.imgUrl) && this.dll > 0 && (this.dlm == 1 || this.dlm == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.aIl() && aIl() && this.dll == aVar.dll && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aqV == null && aVar.aqV == null) || aq.equals(this.aqV, aVar.aqV)) && this.dlk == aVar.dlk && this.dlm == aVar.dlm && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
