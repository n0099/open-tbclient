package c.a.m0.r;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c.a.m0.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4322a;

    /* renamed from: b  reason: collision with root package name */
    public a f4323b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.m0.n.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.f4323b;
            return aVar.a(this.f4322a, aVar.f4321c);
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.m0.n.a
    public void a(Context context, c.a.m0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            this.f4322a = context;
            a aVar = new a();
            this.f4323b = aVar;
            aVar.f4321c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f4320b = cls;
                aVar.f4319a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                aVar.f4321c = aVar.f4320b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                aVar.f4320b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                aVar.f4320b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
