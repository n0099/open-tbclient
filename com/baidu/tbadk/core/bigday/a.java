package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String aHs;
    public long endTime;
    public int erQ;
    public long erR;
    public int erS;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.aHs = bigdayInfo.jump_url;
                this.erQ = bigdayInfo.img_colour.intValue();
                this.erR = bigdayInfo.id.longValue();
                this.erS = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean bho() {
        return !StringUtils.isNULL(this.imgUrl) && this.erR > 0 && (this.erS == 1 || this.erS == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.bho() && bho() && this.erR == aVar.erR && at.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.aHs == null && aVar.aHs == null) || at.equals(this.aHs, aVar.aHs)) && this.erQ == aVar.erQ && this.erS == aVar.erS && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
