package com.baidu.tbadk.core.message;

import com.google.protobuf.MessageLite;
import protobuf.CheckMaskUser.CheckMaskUserReq;
/* loaded from: classes.dex */
public final class b extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public b() {
        super(104104);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return CheckMaskUserReq.CheckMaskUserIdl.newBuilder().a(CheckMaskUserReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final void d(int i) {
        this.a = i;
    }
}
