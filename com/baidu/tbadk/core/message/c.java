package com.baidu.tbadk.core.message;

import com.google.protobuf.MessageLite;
import protobuf.GetMaskInfo.GetMaskInfoReq;
/* loaded from: classes.dex */
public final class c extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public c() {
        super(104103);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return GetMaskInfoReq.GetMaskInfoReqIdl.newBuilder().a(GetMaskInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final int i() {
        return this.a;
    }

    public final void d(int i) {
        this.a = i;
    }
}
