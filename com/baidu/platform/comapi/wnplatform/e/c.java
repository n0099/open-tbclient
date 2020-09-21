package com.baidu.platform.comapi.wnplatform.e;

import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements f<List<MessageMicro>> {
    private List<MessageMicro> a;
    private int b;
    private int c;

    public c(int i, int i2, List<MessageMicro> list) {
        this.a = new ArrayList();
        this.c = i;
        this.b = i2;
        this.a = list;
    }

    public List<MessageMicro> a() {
        return new ArrayList(this.a);
    }
}
