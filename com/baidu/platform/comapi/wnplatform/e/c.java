package com.baidu.platform.comapi.wnplatform.e;

import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements f<List<MessageMicro>> {

    /* renamed from: a  reason: collision with root package name */
    private List<MessageMicro> f4623a;

    /* renamed from: b  reason: collision with root package name */
    private int f4624b;
    private int c;

    public c(int i, int i2, List<MessageMicro> list) {
        this.f4623a = new ArrayList();
        this.c = i;
        this.f4624b = i2;
        this.f4623a = list;
    }

    public List<MessageMicro> a() {
        return new ArrayList(this.f4623a);
    }
}
