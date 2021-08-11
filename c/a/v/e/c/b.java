package c.a.v.e.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f30080a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f30081b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<a> f30082c;

    /* renamed from: d  reason: collision with root package name */
    public c f30083d;

    public b(int i2, Class<?> cls, a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), cls, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30080a = i2;
        this.f30081b = cls;
        this.f30082c = new WeakReference<>(aVar);
        this.f30083d = cVar;
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f30082c.get() == null) {
            return;
        }
        this.f30083d.a(this.f30080a, obj, this.f30082c.get());
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30080a = 1;
            WeakReference<a> weakReference = this.f30082c;
            if (weakReference != null) {
                weakReference.clear();
                this.f30082c = null;
            }
        }
    }

    public boolean c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? obj.getClass() == this.f30081b : invokeL.booleanValue;
    }
}
