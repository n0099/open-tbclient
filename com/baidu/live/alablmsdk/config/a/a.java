package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class a {
    public BLMViewShapeType axp;
    public int axq;
    public c axr;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, c cVar) {
        this.tag = str;
        this.axq = i;
        this.axr = cVar;
        this.axp = bLMViewShapeType;
    }

    public String r(float f) {
        if (this.axr == null) {
            return "";
        }
        if (this.axq < 0) {
            this.axq = 0;
        }
        int q = com.baidu.live.alablmsdk.a.b.q(this.axr.x * f);
        int q2 = com.baidu.live.alablmsdk.a.b.q(this.axr.y * f);
        int q3 = com.baidu.live.alablmsdk.a.b.q(this.axr.width * f);
        int q4 = com.baidu.live.alablmsdk.a.b.q(this.axr.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.axp == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(q).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.axq).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(q3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(q4);
        } else {
            int q5 = com.baidu.live.alablmsdk.a.b.q(((Math.min(this.axr.width, this.axr.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(q + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2 + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.axq).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(q5);
        }
        return sb.toString();
    }
}
