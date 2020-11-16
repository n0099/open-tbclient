package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes4.dex */
public class a {
    public BLMViewShapeType azh;
    public int azi;
    public c azj;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, c cVar) {
        this.tag = str;
        this.azi = i;
        this.azj = cVar;
        this.azh = bLMViewShapeType;
    }

    public String s(float f) {
        if (this.azj == null) {
            return "";
        }
        if (this.azi < 0) {
            this.azi = 0;
        }
        int r = com.baidu.live.alablmsdk.a.c.r(this.azj.x * f);
        int r2 = com.baidu.live.alablmsdk.a.c.r(this.azj.y * f);
        int r3 = com.baidu.live.alablmsdk.a.c.r(this.azj.width * f);
        int r4 = com.baidu.live.alablmsdk.a.c.r(this.azj.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.azh == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(r).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(r2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.azi).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(r3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(r4);
        } else {
            int r5 = com.baidu.live.alablmsdk.a.c.r(((Math.min(this.azj.width, this.azj.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(r + r5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(r2 + r5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.azi).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(r5);
        }
        return sb.toString();
    }
}
