package com.baidu.tbadk.core.bigday;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import tbclient.GetBigday.BigdayInfo;
/* loaded from: classes.dex */
public class a {
    public String bVl;
    public int bVm;
    public long bVn;
    public int bVo;
    public long endTime;
    public String imgUrl;
    public long startTime;

    public void a(BigdayInfo bigdayInfo) {
        if (bigdayInfo != null && !StringUtils.isNULL(bigdayInfo.img_url) && bigdayInfo.id.longValue() > 0) {
            if ((bigdayInfo.position.intValue() == 1 || bigdayInfo.position.intValue() == 3) && bigdayInfo.start_time.longValue() > 0 && bigdayInfo.end_time.longValue() > 0 && bigdayInfo.end_time.longValue() > bigdayInfo.start_time.longValue()) {
                this.imgUrl = bigdayInfo.img_url;
                this.bVl = bigdayInfo.jump_url;
                this.bVm = bigdayInfo.img_colour.intValue();
                this.bVn = bigdayInfo.id.longValue();
                this.bVo = bigdayInfo.position.intValue();
                this.startTime = bigdayInfo.start_time.longValue();
                this.endTime = bigdayInfo.end_time.longValue();
            }
        }
    }

    public boolean agv() {
        return !StringUtils.isNULL(this.imgUrl) && this.bVn > 0 && (this.bVo == 1 || this.bVo == 3) && this.startTime > 0 && this.endTime > 0 && this.endTime > this.startTime;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.agv() && agv() && this.bVn == aVar.bVn && aq.equals(this.imgUrl, aVar.imgUrl)) {
                return ((this.bVl == null && aVar.bVl == null) || aq.equals(this.bVl, aVar.bVl)) && this.bVm == aVar.bVm && this.bVo == aVar.bVo && this.startTime == aVar.startTime && this.endTime == aVar.endTime;
            }
            return false;
        }
        return false;
    }
}
