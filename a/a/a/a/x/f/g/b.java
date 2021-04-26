package a.a.a.a.x.f.g;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class b extends HashMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1385a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1386b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1387c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1388d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1389e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f1390f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f1391g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        this.f1385a = j;
        this.f1386b = str;
        this.f1387c = str2;
        this.f1388d = str3;
        this.f1389e = obj;
        this.f1390f = z;
        this.f1391g = objArr;
        put("lid", Long.valueOf(this.f1385a));
        put("sid", this.f1386b);
        put("type", this.f1387c);
        put("aid", this.f1388d);
        put("st", this.f1389e);
        put("dup", Integer.valueOf(this.f1390f ? 1 : 0));
        Object[] objArr2 = this.f1391g;
        if (objArr2 == null || objArr2.length <= 0) {
            return;
        }
        if (objArr2.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i2 = 0;
        while (true) {
            Object[] objArr3 = this.f1391g;
            if (i2 >= objArr3.length) {
                return;
            }
            put(objArr3[i2].toString(), this.f1391g[i2 + 1]);
            i2 += 2;
        }
    }
}
