package com.baidu.tbadk.core.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReq;
/* loaded from: classes.dex */
public final class d extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;
    private String c;

    public d() {
        super(104102);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return UpdateMaskInfoReq.UpdateMaskInfoReqIdl.newBuilder().a(UpdateMaskInfoReq.DataReq.newBuilder().a(this.a).b(this.b).a(this.c).build()).build();
    }

    public final int i() {
        return this.a;
    }

    public final void d(int i) {
        this.a = i;
    }

    public final int j() {
        return this.b;
    }

    public final void e(int i) {
        this.b = i;
    }

    public final void a(boolean z) {
        this.b = z ? 1 : 0;
    }

    public final void a(String str) {
        this.c = str;
    }
}
