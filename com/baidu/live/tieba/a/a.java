package com.baidu.live.tieba.a;

import com.baidu.live.adp.framework.message.CustomMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends CustomMessage<List<Object>> {
    private List<Long> mIds;
    private List<Object> mOriginData;

    public List<Long> getIds() {
        return this.mIds;
    }

    public List<Object> getOriginData() {
        return this.mOriginData;
    }
}
