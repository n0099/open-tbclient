package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aHf;
    public int ejr;
    public long ejs;
    public int ejt;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aHf = bigdayInfo.jump_url;
                this.ejr = bigdayInfo.img_colour.intValue();
                this.ejs = bigdayInfo.id.longValue();
                this.ejt = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bfv() {
        return !StringUtils.isNULL(this.imgUrl) && this.ejs > 0 && (this.ejt == 1 || this.ejt == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bfv() && bfv() && this.ejs == aVar.ejs && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aHf == null && aVar.aHf == null) || at.equals(this.aHf, aVar.aHf)) && this.ejr == aVar.ejr && this.ejt == aVar.ejt && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
