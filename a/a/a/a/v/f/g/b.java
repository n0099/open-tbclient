package a.a.a.a.v.f.g;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class b extends HashMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1371c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1372d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1373e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f1374f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f1375g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        this.f1369a = j;
        this.f1370b = str;
        this.f1371c = str2;
        this.f1372d = str3;
        this.f1373e = obj;
        this.f1374f = z;
        this.f1375g = objArr;
        put("lid", Long.valueOf(this.f1369a));
        put("sid", this.f1370b);
        put("type", this.f1371c);
        put("aid", this.f1372d);
        put("st", this.f1373e);
        put("dup", Integer.valueOf(this.f1374f ? 1 : 0));
        Object[] objArr2 = this.f1375g;
        if (objArr2 == null || objArr2.length <= 0) {
            return;
        }
        if (objArr2.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i = 0;
        while (true) {
            Object[] objArr3 = this.f1375g;
            if (i >= objArr3.length) {
                return;
            }
            put(objArr3[i].toString(), this.f1375g[i + 1]);
            i += 2;
        }
    }
}
