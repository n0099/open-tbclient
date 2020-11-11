package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes4.dex */
public class a {
    public BLMViewShapeType aAS;
    public int aAT;
    public c aAU;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, c cVar) {
        this.tag = str;
        this.aAT = i;
        this.aAU = cVar;
        this.aAS = bLMViewShapeType;
    }

    public String t(float f) {
        if (this.aAU == null) {
            return "";
        }
        if (this.aAT < 0) {
            this.aAT = 0;
        }
        int s = com.baidu.live.alablmsdk.a.c.s(this.aAU.x * f);
        int s2 = com.baidu.live.alablmsdk.a.c.s(this.aAU.y * f);
        int s3 = com.baidu.live.alablmsdk.a.c.s(this.aAU.width * f);
        int s4 = com.baidu.live.alablmsdk.a.c.s(this.aAU.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.aAS == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(s).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(s2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aAT).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(s3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(s4);
        } else {
            int s5 = com.baidu.live.alablmsdk.a.c.s(((Math.min(this.aAU.width, this.aAU.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(s + s5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(s2 + s5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aAT).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(s5);
        }
        return sb.toString();
    }
}
