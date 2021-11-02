package b.a.w.e.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f29291a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f29292b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<a> f29293c;

    /* renamed from: d  reason: collision with root package name */
    public c f29294d;

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
        this.f29291a = i2;
        this.f29292b = cls;
        this.f29293c = new WeakReference<>(aVar);
        this.f29294d = cVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29291a = 1;
            WeakReference<a> weakReference = this.f29293c;
            if (weakReference != null) {
                weakReference.clear();
                this.f29293c = null;
            }
        }
    }

    public boolean b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj.getClass() == this.f29292b : invokeL.booleanValue;
    }

    public void call(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f29293c.get() == null) {
            return;
        }
        this.f29294d.a(this.f29291a, obj, this.f29293c.get());
    }
}
