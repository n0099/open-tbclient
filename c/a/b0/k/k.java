package c.a.b0.k;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f1676b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1677c;

    /* renamed from: d  reason: collision with root package name */
    public final i<?> f1678d;

    public k(int i2, Object obj, Class<?> cls, i<?> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), obj, cls, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1677c = i2;
        this.a = obj;
        this.f1676b = cls;
        this.f1678d = iVar;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SubscribeInfo:{\n    threadMode:" + this.f1677c + "\n    tag:" + this.a + "\n    eventClass:" + this.f1676b + "\n    subscriber:" + this.f1678d + "\n}";
        }
        return (String) invokeV.objValue;
    }
}
