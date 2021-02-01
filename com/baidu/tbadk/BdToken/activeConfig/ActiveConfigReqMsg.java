package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.ActiveConfig.ActiveConfigReqIdl;
import tbclient.ActiveConfig.DataReq;
/* loaded from: classes.dex */
public class ActiveConfigReqMsg extends NetMessage {
    public static final int LAUNTCH_FROM_HOME_PAGE = 1;
    public static final int LAUNTCH_FROM_START = 0;
    private boolean isFirstUp;
    private boolean isSchemaUp;
    public int launtchType;

    public ActiveConfigReqMsg() {
        super(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);
        this.launtchType = 0;
    }

    public void setFirstUp(boolean z) {
        this.isFirstUp = z;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (this.isFirstUp) {
                builder.is_first_up = 1;
            } else {
                builder.is_first_up = 0;
            }
            if (this.isSchemaUp) {
                builder.is_schema_up = 1;
            } else {
                builder.is_schema_up = 0;
            }
            v.a(builder, true, true, false);
            ActiveConfigReqIdl.Builder builder2 = new ActiveConfigReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
