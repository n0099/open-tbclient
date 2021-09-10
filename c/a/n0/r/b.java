package c.a.n0.r;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements c.a.n0.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4342a;

    /* renamed from: b  reason: collision with root package name */
    public a f4343b;

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

    @Override // c.a.n0.n.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.f4343b;
            return aVar.a(this.f4342a, aVar.f4341c);
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.n.a
    public void a(Context context, c.a.n0.n.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            this.f4342a = context;
            a aVar = new a();
            this.f4343b = aVar;
            aVar.f4341c = null;
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                aVar.f4340b = cls;
                aVar.f4339a = cls.newInstance();
            } catch (Throwable unused) {
            }
            try {
                aVar.f4341c = aVar.f4340b.getMethod("getOAID", Context.class);
            } catch (Throwable unused2) {
            }
            try {
                aVar.f4340b.getMethod("getVAID", Context.class);
            } catch (Throwable unused3) {
            }
            try {
                aVar.f4340b.getMethod("getAAID", Context.class);
            } catch (Throwable unused4) {
            }
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
