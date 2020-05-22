package com.baidu.tbadk.BdToken.completeTask;

import android.util.Base64;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.t;
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
    private String mToken;

    public CompleteTaskReqMsg(int i) {
        super(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.mTaskType = i;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        if (z) {
            try {
                getHttpMessage().setUserAgent(ah.getUserAgent());
            } catch (Exception e) {
                return null;
            }
        }
        DataReq.Builder builder = new DataReq.Builder();
        builder.shoubaicuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
        if (this.completeId != null) {
            builder.compelete_id = Base64.encodeToString(this.completeId.getBytes(), 2);
        }
        if (this.mToken != null) {
            builder.token = Base64.encodeToString(this.mToken.getBytes(), 2);
        }
        t.a(builder, true, true, false);
        CompleteTaskReqIdl.Builder builder2 = new CompleteTaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getTaskType() {
        return this.mTaskType;
    }
}
