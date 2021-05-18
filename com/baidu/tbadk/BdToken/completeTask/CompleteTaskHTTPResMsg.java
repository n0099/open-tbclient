package com.baidu.tbadk.BdToken.completeTask;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.j0.a.d0.a;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class CompleteTaskHTTPResMsg extends HttpResponsedMessage {
    public a mData;

    public CompleteTaskHTTPResMsg() {
        super(CmdConfigHttp.CMD_COMPLETE_TASK);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CompleteTaskResIdl completeTaskResIdl = (CompleteTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, CompleteTaskResIdl.class);
        if (completeTaskResIdl != null) {
            Error error = completeTaskResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(completeTaskResIdl.error.usermsg);
            }
            if (completeTaskResIdl.data != null) {
                a aVar = new a();
                this.mData = aVar;
                aVar.f48661c = completeTaskResIdl.data.show_type.intValue();
                this.mData.f48662d = completeTaskResIdl.data.ahead_type.intValue();
                a aVar2 = this.mData;
                DataRes dataRes = completeTaskResIdl.data;
                aVar2.f48663e = dataRes.message;
                aVar2.f48664f = dataRes.btn_text;
                aVar2.f48665g = dataRes.btn_confirm;
                aVar2.f48666h = dataRes.btn_cancel;
                aVar2.f48667i = dataRes.toast_duration.intValue();
                a aVar3 = this.mData;
                DataRes dataRes2 = completeTaskResIdl.data;
                aVar3.j = dataRes2.img_url;
                aVar3.k = dataRes2.url;
                aVar3.l = dataRes2.schema;
                aVar3.m = dataRes2.token;
                aVar3.f48659a = dataRes2.activity_id.intValue();
                this.mData.f48660b = completeTaskResIdl.data.mission_id.intValue();
                a aVar4 = this.mData;
                DataRes dataRes3 = completeTaskResIdl.data;
                aVar4.o = dataRes3.btn_color;
                aVar4.p = dataRes3.message_color;
                aVar4.q = dataRes3.btn_text_color;
                aVar4.r = dataRes3.interface_type.intValue();
                this.mData.n = completeTaskResIdl.data.opacity.doubleValue();
                this.mData.x = completeTaskResIdl.data.is_not_complete.intValue();
            }
        }
    }
}
