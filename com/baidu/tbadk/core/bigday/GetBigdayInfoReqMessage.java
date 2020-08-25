package com.baidu.tbadk.core.bigday;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.GetBigday.DataReq;
import tbclient.GetBigday.GetBigdayReqIdl;
/* loaded from: classes2.dex */
public class GetBigdayInfoReqMessage extends NetMessage {
    public GetBigdayInfoReqMessage() {
        super(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                t.a(builder, true);
            }
            builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()));
            builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
            GetBigdayReqIdl.Builder builder2 = new GetBigdayReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
