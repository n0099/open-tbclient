package com.baidu.tbadk.BdToken.completeTask;

import android.util.Base64;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.n0;
import d.b.h0.z0.w;
import tbclient.CompleteTask.CompleteTaskReqIdl;
import tbclient.CompleteTask.DataReq;
/* loaded from: classes3.dex */
public class CompleteTaskReqMsg extends NetMessage {
    public static final int TASK_TYPE_DEFAULT = 0;
    public static final int TASK_TYPE_SHARE = 2;
    public static final int TASK_TYPE_TIMER = 1;
    public String completeId;
    public Object extra;
    public int mTaskType;
    public String mToken;

    public CompleteTaskReqMsg(int i) {
        super(CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.mTaskType = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        if (z) {
            try {
                getHttpMessage().setUserAgent(n0.e());
            } catch (Exception unused) {
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
        w.c(builder, true, true, false);
        CompleteTaskReqIdl.Builder builder2 = new CompleteTaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
