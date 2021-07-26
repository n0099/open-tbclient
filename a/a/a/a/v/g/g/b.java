package a.a.a.a.v.g.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b extends HashMap<String, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1434c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1435d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1436e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Object f1437f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1438g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object[] f1439h;

    public b(long j, String str, int i2, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {Long.valueOf(j), str, Integer.valueOf(i2), str2, str3, obj, Boolean.valueOf(z), objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1432a = j;
        this.f1433b = str;
        this.f1434c = i2;
        this.f1435d = str2;
        this.f1436e = str3;
        this.f1437f = obj;
        this.f1438g = z;
        this.f1439h = objArr;
        put("lid", Long.valueOf(this.f1432a));
        put("sid", this.f1433b);
        put("sidv", Integer.valueOf(this.f1434c));
        put("type", this.f1435d);
        put("aid", this.f1436e);
        put("st", this.f1437f);
        put("dup", Integer.valueOf(this.f1438g ? 1 : 0));
        Object[] objArr3 = this.f1439h;
        if (objArr3 == null || objArr3.length <= 0) {
            return;
        }
        if (objArr3.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i5 = 0;
        while (true) {
            Object[] objArr4 = this.f1439h;
            if (i5 >= objArr4.length) {
                return;
            }
            put(objArr4[i5].toString(), this.f1439h[i5 + 1]);
            i5 += 2;
        }
    }
}
