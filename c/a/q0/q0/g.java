package c.a.q0.q0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f12799b;

    /* renamed from: c  reason: collision with root package name */
    public String f12800c;

    /* renamed from: d  reason: collision with root package name */
    public Long f12801d;

    /* renamed from: e  reason: collision with root package name */
    public c f12802e;

    /* renamed from: f  reason: collision with root package name */
    public int f12803f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12804g;

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
        this.f12804g = false;
        this.a = context;
        this.f12799b = i2;
        this.f12800c = str;
        this.f12801d = l;
        this.f12802e = cVar;
    }
}
