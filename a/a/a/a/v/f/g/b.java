package a.a.a.a.v.f.g;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class b extends HashMap<String, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1013a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Object[] g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        this.f1013a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = obj;
        this.f = z;
        this.g = objArr;
        put("lid", Long.valueOf(this.f1013a));
        put(UbcStatConstant.KEY_CONTENT_EXT_SID, this.b);
        put("type", this.c);
        put("aid", this.d);
        put("st", this.e);
        put("dup", Integer.valueOf(this.f ? 1 : 0));
        Object[] objArr2 = this.g;
        if (objArr2 == null || objArr2.length <= 0) {
            return;
        }
        if (objArr2.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i = 0;
        while (true) {
            Object[] objArr3 = this.g;
            if (i >= objArr3.length) {
                return;
            }
            put(objArr3[i].toString(), this.g[i + 1]);
            i += 2;
        }
    }
}
