package com.baidu.live.tieba.a;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends CustomMessage<List<Long>> {
    private List<Long> mIds;
    private List<Object> mOriginData;

    public b(List<Long> list) {
        super(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY_RESPONSED);
        this.mIds = new ArrayList();
        this.mOriginData = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            this.mIds.addAll(list);
        }
    }
}
