package c.a.o0.q0;

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
    public int f10478b;

    /* renamed from: c  reason: collision with root package name */
    public String f10479c;

    /* renamed from: d  reason: collision with root package name */
    public Long f10480d;

    /* renamed from: e  reason: collision with root package name */
    public c f10481e;

    /* renamed from: f  reason: collision with root package name */
    public int f10482f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10483g;

    public g(Context context, int i, String str, Long l, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, l, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10483g = false;
        this.a = context;
        this.f10478b = i;
        this.f10479c = str;
        this.f10480d = l;
        this.f10481e = cVar;
    }
}
