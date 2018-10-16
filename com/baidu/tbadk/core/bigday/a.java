package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String akf;
    public int akg;
    public long akh;
    public int aki;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.akf = bigdayInfo.jump_url;
                this.akg = bigdayInfo.img_colour.intValue();
                this.akh = bigdayInfo.id.longValue();
                this.aki = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean wF() {
        return !StringUtils.isNULL(this.imgUrl) && this.akh > 0 && (this.aki == 1 || this.aki == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.wF() && wF() && this.akh == aVar.akh && ao.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.akf == null && aVar.akf == null) || ao.equals(this.akf, aVar.akf)) && this.akg == aVar.akg && this.aki == aVar.aki && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
