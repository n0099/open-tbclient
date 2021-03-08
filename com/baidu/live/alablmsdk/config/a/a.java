package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.alablmsdk.config.enums.BLMViewShapeType;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class a {
    public BLMViewShapeType azc;
    public int azd;
    public d aze;
    public String tag;

    public a(String str, int i, BLMViewShapeType bLMViewShapeType, d dVar) {
        this.tag = str;
        this.azd = i;
        this.aze = dVar;
        this.azc = bLMViewShapeType;
    }

    public String v(float f) {
        if (this.aze == null) {
            return "";
        }
        if (this.azd < 0) {
            this.azd = 0;
        }
        int u = com.baidu.live.alablmsdk.a.b.u(this.aze.x * f);
        int u2 = com.baidu.live.alablmsdk.a.b.u(this.aze.y * f);
        int u3 = com.baidu.live.alablmsdk.a.b.u(this.aze.width * f);
        int u4 = com.baidu.live.alablmsdk.a.b.u(this.aze.height * f);
        StringBuilder sb = new StringBuilder();
        if (this.azc == BLMViewShapeType.RECTANGLE) {
            sb.append("x:").append(u).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(u2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.azd).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("w:").append(u3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("h:").append(u4);
        } else {
            int u5 = com.baidu.live.alablmsdk.a.b.u(((Math.min(this.aze.width, this.aze.height) * 1.0f) / 2.0f) * f);
            sb.append("x:").append(u + u5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("y:").append(u2 + u5).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("z:").append(this.azd).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append("r:").append(u5);
        }
        return sb.toString();
    }
}
