package com.baidu.tbadk.BdToken.completeTask;

import android.util.Base64;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.CompleteTask.CompleteTaskReqIdl;
import tbclient.CompleteTask.DataReq;
/* loaded from: classes.dex */
public class CompleteTaskReqMsg extends NetMessage {
    public static final int TASK_TYPE_DEFAULT = 0;
    public static final int TASK_TYPE_SHARE = 2;
    public static final int TASK_TYPE_TIMER = 1;
    public String completeId;
    public Object extra;
    private int mTaskType;

    public CompleteTaskReqMsg(int i) {
        super(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.mTaskType = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.shoubaicuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
            builder.compelete_id = Base64.encodeToString(this.completeId.getBytes(), 2);
            s.bindCommonParamsToProtobufData(builder, true, true, false);
            CompleteTaskReqIdl.Builder builder2 = new CompleteTaskReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public int getTaskType() {
        return this.mTaskType;
    }
}
