package c.a.t0.r0;

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
    public int f13383b;

    /* renamed from: c  reason: collision with root package name */
    public String f13384c;

    /* renamed from: d  reason: collision with root package name */
    public Long f13385d;

    /* renamed from: e  reason: collision with root package name */
    public c f13386e;

    /* renamed from: f  reason: collision with root package name */
    public int f13387f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13388g;

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
        this.f13388g = false;
        this.a = context;
        this.f13383b = i2;
        this.f13384c = str;
        this.f13385d = l;
        this.f13386e = cVar;
    }
}
