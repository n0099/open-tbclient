package a.a.a.a.w.g.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class b extends HashMap<String, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1028d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1029e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Object f1030f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1031g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object[] f1032h;

    public b(long j2, String str, int i2, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {Long.valueOf(j2), str, Integer.valueOf(i2), str2, str3, obj, Boolean.valueOf(z), objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1025a = j2;
        this.f1026b = str;
        this.f1027c = i2;
        this.f1028d = str2;
        this.f1029e = str3;
        this.f1030f = obj;
        this.f1031g = z;
        this.f1032h = objArr;
        put("lid", Long.valueOf(this.f1025a));
        put("sid", this.f1026b);
        put("sidv", Integer.valueOf(this.f1027c));
        put("type", this.f1028d);
        put("aid", this.f1029e);
        put("st", this.f1030f);
        put("dup", Integer.valueOf(this.f1031g ? 1 : 0));
        Object[] objArr3 = this.f1032h;
        if (objArr3 == null || objArr3.length <= 0) {
            return;
        }
        if (objArr3.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i5 = 0;
        while (true) {
            Object[] objArr4 = this.f1032h;
            if (i5 >= objArr4.length) {
                return;
            }
            put(objArr4[i5].toString(), this.f1032h[i5 + 1]);
            i5 += 2;
        }
    }
}
