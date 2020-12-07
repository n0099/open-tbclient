package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes4.dex */
public class a {
    public BLMViewShapeType aBL;
    public int aBM;
    public c aBN;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, c cVar) {
        this.tag = str;
        this.aBM = i;
        this.aBN = cVar;
        this.aBL = bLMViewShapeType;
    }

    public String r(float f) {
        if (this.aBN == null) {
            return "";
        }
        if (this.aBM < 0) {
            this.aBM = 0;
        }
        int q = com.baidu.live.alablmsdk.a.b.q(this.aBN.x * f);
        int q2 = com.baidu.live.alablmsdk.a.b.q(this.aBN.y * f);
        int q3 = com.baidu.live.alablmsdk.a.b.q(this.aBN.width * f);
        int q4 = com.baidu.live.alablmsdk.a.b.q(this.aBN.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.aBL == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(q).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aBM).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(q3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(q4);
        } else {
            int q5 = com.baidu.live.alablmsdk.a.b.q(((Math.min(this.aBN.width, this.aBN.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(q + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2 + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aBM).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(q5);
        }
        return sb.toString();
    }
}
