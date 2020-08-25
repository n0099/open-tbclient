package com.baidu.live.sdk.goods.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class b extends HttpMessage {
    public String aNZ;
    public String gid;
    public long liveId;

    public b() {
        super(1021201);
        this.liveId = 0L;
    }

    public void c(long j, String str, String str2) {
        this.aNZ = str;
        this.liveId = j;
        this.gid = str2;
        addParam("feed_id", str);
        addParam("gid", str2);
        addParam("live_id", j);
    }
}
