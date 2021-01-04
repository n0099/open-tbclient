package com.baidu.platform.comapi.wnplatform.e;

import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class c implements f<List<MessageMicro>> {

    /* renamed from: a  reason: collision with root package name */
    private List<MessageMicro> f4622a;

    /* renamed from: b  reason: collision with root package name */
    private int f4623b;
    private int c;

    public c(int i, int i2, List<MessageMicro> list) {
        this.f4622a = new ArrayList();
        this.c = i;
        this.f4623b = i2;
        this.f4622a = list;
    }

    public List<MessageMicro> a() {
        return new ArrayList(this.f4622a);
    }
}
