package com.baidu.live.alablmsdk.config.a;

import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes11.dex */
public class d {
    public int height;
    public int width;
    public int x;
    public int y;

    public d(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }

    public String xR() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.x).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.y).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.width).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.height);
        return sb.toString();
    }
}
