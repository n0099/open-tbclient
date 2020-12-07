package com.baidu.platform.comapi.wnplatform.e;

import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class c implements f<List<MessageMicro>> {

    /* renamed from: a  reason: collision with root package name */
    private List<MessageMicro> f3110a;
    private int b;
    private int c;

    public c(int i, int i2, List<MessageMicro> list) {
        this.f3110a = new ArrayList();
        this.c = i;
        this.b = i2;
        this.f3110a = list;
    }

    public List<MessageMicro> a() {
        return new ArrayList(this.f3110a);
    }
}
