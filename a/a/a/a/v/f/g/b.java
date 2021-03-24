package a.a.a.a.v.f.g;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class b extends HashMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1383a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1384b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1385c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1386d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1387e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f1388f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f1389g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        this.f1383a = j;
        this.f1384b = str;
        this.f1385c = str2;
        this.f1386d = str3;
        this.f1387e = obj;
        this.f1388f = z;
        this.f1389g = objArr;
        put("lid", Long.valueOf(this.f1383a));
        put("sid", this.f1384b);
        put("type", this.f1385c);
        put("aid", this.f1386d);
        put("st", this.f1387e);
        put("dup", Integer.valueOf(this.f1388f ? 1 : 0));
        Object[] objArr2 = this.f1389g;
        if (objArr2 == null || objArr2.length <= 0) {
            return;
        }
        if (objArr2.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i = 0;
        while (true) {
            Object[] objArr3 = this.f1389g;
            if (i >= objArr3.length) {
                return;
            }
            put(objArr3[i].toString(), this.f1389g[i + 1]);
            i += 2;
        }
    }
}
