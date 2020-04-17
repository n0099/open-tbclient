package com.baidu.tbadk.BdToken.completeTask;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.CompleteTask.CompleteTaskResIdl;
/* loaded from: classes.dex */
public class CompleteTaskHTTPResMsg extends HttpResponsedMessage {
    public a mData;

    public CompleteTaskHTTPResMsg() {
        super(CmdConfigHttp.CMD_COMPLETE_TASK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CompleteTaskResIdl completeTaskResIdl = (CompleteTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, CompleteTaskResIdl.class);
        if (completeTaskResIdl != null) {
            if (completeTaskResIdl.error != null) {
                setError(completeTaskResIdl.error.errorno.intValue());
                setErrorString(completeTaskResIdl.error.usermsg);
            }
            if (completeTaskResIdl.data != null) {
                this.mData = new a();
                this.mData.showType = completeTaskResIdl.data.show_type.intValue();
                this.mData.diH = completeTaskResIdl.data.ahead_type.intValue();
                this.mData.message = completeTaskResIdl.data.message;
                this.mData.btnText = completeTaskResIdl.data.btn_text;
                this.mData.dhN = completeTaskResIdl.data.btn_confirm;
                this.mData.dhO = completeTaskResIdl.data.btn_cancel;
                this.mData.duration = completeTaskResIdl.data.toast_duration.intValue();
                this.mData.imgUrl = completeTaskResIdl.data.img_url;
                this.mData.url = completeTaskResIdl.data.url;
                this.mData.schema = completeTaskResIdl.data.schema;
                this.mData.token = completeTaskResIdl.data.token;
                this.mData.activityId = completeTaskResIdl.data.activity_id.intValue();
                this.mData.missionId = completeTaskResIdl.data.mission_id.intValue();
                this.mData.btn_color = completeTaskResIdl.data.btn_color;
                this.mData.message_color = completeTaskResIdl.data.message_color;
                this.mData.btn_text_color = completeTaskResIdl.data.btn_text_color;
                this.mData.diI = completeTaskResIdl.data.interface_type.intValue();
                this.mData.opacity = completeTaskResIdl.data.opacity.doubleValue();
                this.mData.diN = completeTaskResIdl.data.is_not_complete.intValue();
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
