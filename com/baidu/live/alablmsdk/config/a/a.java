package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes11.dex */
public class a {
    public BLMViewShapeType aCc;
    public int aCd;
    public c aCe;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, c cVar) {
        this.tag = str;
        this.aCd = i;
        this.aCe = cVar;
        this.aCc = bLMViewShapeType;
    }

    public String r(float f) {
        if (this.aCe == null) {
            return "";
        }
        if (this.aCd < 0) {
            this.aCd = 0;
        }
        int q = com.baidu.live.alablmsdk.a.b.q(this.aCe.x * f);
        int q2 = com.baidu.live.alablmsdk.a.b.q(this.aCe.y * f);
        int q3 = com.baidu.live.alablmsdk.a.b.q(this.aCe.width * f);
        int q4 = com.baidu.live.alablmsdk.a.b.q(this.aCe.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.aCc == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(q).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aCd).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(q3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(q4);
        } else {
            int q5 = com.baidu.live.alablmsdk.a.b.q(((Math.min(this.aCe.width, this.aCe.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(q + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(q2 + q5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.aCd).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(q5);
        }
        return sb.toString();
    }
}
