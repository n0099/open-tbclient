package a.a.a.a.y.f.g;

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
    public final /* synthetic */ long f1401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1402b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1403c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1404d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1405e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f1406f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f1407g;

    public b(long j, String str, String str2, String str3, Object obj, boolean z, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {Long.valueOf(j), str, str2, str3, obj, Boolean.valueOf(z), objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1401a = j;
        this.f1402b = str;
        this.f1403c = str2;
        this.f1404d = str3;
        this.f1405e = obj;
        this.f1406f = z;
        this.f1407g = objArr;
        put("lid", Long.valueOf(this.f1401a));
        put("sid", this.f1402b);
        put("type", this.f1403c);
        put("aid", this.f1404d);
        put("st", this.f1405e);
        put("dup", Integer.valueOf(this.f1406f ? 1 : 0));
        Object[] objArr3 = this.f1407g;
        if (objArr3 == null || objArr3.length <= 0) {
            return;
        }
        if (objArr3.length % 2 != 0) {
            throw new IllegalArgumentException("Length of argument 'appends' must be even.");
        }
        int i4 = 0;
        while (true) {
            Object[] objArr4 = this.f1407g;
            if (i4 >= objArr4.length) {
                return;
            }
            put(objArr4[i4].toString(), this.f1407g[i4 + 1]);
            i4 += 2;
        }
    }
}
