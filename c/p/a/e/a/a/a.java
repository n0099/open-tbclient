package c.p.a.e.a.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f34935a;

    /* renamed from: b  reason: collision with root package name */
    public final c.p.a.e.b.j.a f34936b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34937c;

    public a(Context context, c.p.a.e.b.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34935a = context;
        this.f34936b = aVar;
        this.f34937c = str;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f34935a == null) {
                return false;
            }
            try {
            } catch (Throwable unused) {
                c.p.a.e.b.c.a.e();
            }
            return b().resolveActivity(this.f34935a.getPackageManager()) != null;
        }
        return invokeV.booleanValue;
    }
}
