package c.a.p0.i3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20029a;

    /* renamed from: b  reason: collision with root package name */
    public String f20030b;

    /* renamed from: c  reason: collision with root package name */
    public String f20031c;

    /* renamed from: d  reason: collision with root package name */
    public d f20032d;

    /* renamed from: e  reason: collision with root package name */
    public d f20033e;

    /* renamed from: f  reason: collision with root package name */
    public d f20034f;

    public e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20029a = false;
        this.f20030b = null;
        this.f20031c = null;
        this.f20032d = new d();
        this.f20033e = new d();
        this.f20034f = new d();
        this.f20031c = str;
        this.f20030b = str2;
        this.f20029a = z;
    }
}
