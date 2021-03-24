package com.baidu.tbadk.BdToken.completeTask;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.h0.a.b0.a;
import tbclient.CompleteTask.CompleteTaskResIdl;
import tbclient.CompleteTask.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class CompleteTaskSocketResMsg extends SocketResponsedMessage {
    public a mData;

    public CompleteTaskSocketResMsg() {
        super(309627);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
                aVar.f49512c = completeTaskResIdl.data.show_type.intValue();
                this.mData.f49513d = completeTaskResIdl.data.ahead_type.intValue();
                a aVar2 = this.mData;
                DataRes dataRes = completeTaskResIdl.data;
                aVar2.f49514e = dataRes.message;
                aVar2.f49515f = dataRes.btn_text;
                aVar2.f49516g = dataRes.btn_confirm;
                aVar2.f49517h = dataRes.btn_cancel;
                aVar2.i = dataRes.toast_duration.intValue();
                a aVar3 = this.mData;
                DataRes dataRes2 = completeTaskResIdl.data;
                aVar3.j = dataRes2.img_url;
                aVar3.k = dataRes2.url;
                aVar3.l = dataRes2.schema;
                aVar3.m = dataRes2.token;
                aVar3.f49510a = dataRes2.activity_id.intValue();
                this.mData.f49511b = completeTaskResIdl.data.mission_id.intValue();
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
