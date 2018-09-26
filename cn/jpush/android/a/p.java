package cn.jpush.android.a;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p {
    public int a;
    public int b;
    public long c;
    public ArrayList<String> d;
    public String e;
    public int f = -1;
    public int g = -1;
    public int h = 0;
    public int i;
    final /* synthetic */ o j;

    public p(o oVar, int i, int i2, long j, ArrayList<String> arrayList, String str) {
        this.j = oVar;
        this.i = 0;
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = arrayList;
        if (i == 1 && this.d == null) {
            this.d = new ArrayList<>();
        }
        this.e = str;
        this.i = 1;
    }

    public final String toString() {
        return "TagAliasCacheBean{protoType=" + this.a + ", actionType=" + this.b + ", seqID=" + this.c + ", tags=" + this.d + ", alias='" + this.e + "', totalPage=" + this.f + ", currPage=" + this.g + ", retryCount=" + this.h + '}';
    }
}
