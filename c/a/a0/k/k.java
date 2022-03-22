package c.a.a0.k;

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
    public final Class<?> f1297b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1298c;

    /* renamed from: d  reason: collision with root package name */
    public final i<?> f1299d;

    public k(int i, Object obj, Class<?> cls, i<?> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), obj, cls, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1298c = i;
        this.a = obj;
        this.f1297b = cls;
        this.f1299d = iVar;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SubscribeInfo:{\n    threadMode:" + this.f1298c + "\n    tag:" + this.a + "\n    eventClass:" + this.f1297b + "\n    subscriber:" + this.f1299d + "\n}";
        }
        return (String) invokeV.objValue;
    }
}
