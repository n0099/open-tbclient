package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes11.dex */
public class a {
    public BLMViewShapeType axC;
    public int axD;
    public d axE;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, d dVar) {
        this.tag = str;
        this.axD = i;
        this.axE = dVar;
        this.axC = bLMViewShapeType;
    }

    public String r(float f) {
        if (this.axE == null) {
            return "";
        }
        if (this.axD < 0) {
            this.axD = 0;
        }
        int q = com.baidu.live.alablmsdk.a.b.q(this.axE.x * f);
        int q2 = com.baidu.live.alablmsdk.a.b.q(this.axE.y * f);
        int q3 = com.baidu.live.alablmsdk.a.b.q(this.axE.width * f);
        int q4 = com.baidu.live.alablmsdk.a.b.q(this.axE.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.axC == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(q).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.axD).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(q3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(q4);
        } else {
            int q5 = com.baidu.live.alablmsdk.a.b.q(((Math.min(this.axE.width, this.axE.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(q + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2 + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.axD).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(q5);
        }
        return sb.toString();
    }
}
