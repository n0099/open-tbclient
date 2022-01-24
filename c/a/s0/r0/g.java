package c.a.s0.r0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f13116b;

    /* renamed from: c  reason: collision with root package name */
    public String f13117c;

    /* renamed from: d  reason: collision with root package name */
    public Long f13118d;

    /* renamed from: e  reason: collision with root package name */
    public c f13119e;

    /* renamed from: f  reason: collision with root package name */
    public int f13120f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13121g;

    public g(Context context, int i2, String str, Long l, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, l, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13121g = false;
        this.a = context;
        this.f13116b = i2;
        this.f13117c = str;
        this.f13118d = l;
        this.f13119e = cVar;
    }
}
