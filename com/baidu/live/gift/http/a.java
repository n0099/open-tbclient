package com.baidu.live.gift.http;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public String aWl;
    public int count;
    public String itemId;
    public String thumbUrl;

    public a() {
        super(1021232);
    }

    public void a(String str, String str2, String str3, int i, long j) {
        this.itemId = str2;
        this.aWl = str3;
        this.count = i;
        addParam("platform", "2");
        addParam("scene_from", q.Vu());
        addParam("live_id", str);
        addParam(LegoListActivityConfig.ITEM_ID, str2);
        addParam("item_type", str3);
        addParam("synthesise_amount", i);
        addParam("pk_id", j);
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }
}
