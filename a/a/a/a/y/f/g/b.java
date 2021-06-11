package a.a.a.a.y.f.g;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b extends HashMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1400c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1401d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1402e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f1403f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f1404g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        this.f1398a = j;
        this.f1399b = str;
        this.f1400c = str2;
        this.f1401d = str3;
        this.f1402e = obj;
        this.f1403f = z;
        this.f1404g = objArr;
        put("lid", Long.valueOf(this.f1398a));
        put("sid", this.f1399b);
        put("type", this.f1400c);
        put("aid", this.f1401d);
        put("st", this.f1402e);
        put("dup", Integer.valueOf(this.f1403f ? 1 : 0));
        Object[] objArr2 = this.f1404g;
        if (objArr2 == null || objArr2.length <= 0) {
            return;
        }
        if (objArr2.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i2 = 0;
        while (true) {
            Object[] objArr3 = this.f1404g;
            if (i2 >= objArr3.length) {
                return;
            }
            put(objArr3[i2].toString(), this.f1404g[i2 + 1]);
            i2 += 2;
        }
    }
}
