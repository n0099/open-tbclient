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
    public int f12972b;

    /* renamed from: c  reason: collision with root package name */
    public String f12973c;

    /* renamed from: d  reason: collision with root package name */
    public Long f12974d;

    /* renamed from: e  reason: collision with root package name */
    public c f12975e;

    /* renamed from: f  reason: collision with root package name */
    public int f12976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12977g;

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
        this.f12977g = false;
        this.a = context;
        this.f12972b = i2;
        this.f12973c = str;
        this.f12974d = l;
        this.f12975e = cVar;
    }
}
