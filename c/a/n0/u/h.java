package c.a.n0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9448b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9449c;

    /* renamed from: d  reason: collision with root package name */
    public long f9450d;

    /* renamed from: e  reason: collision with root package name */
    public int f9451e;

    public h(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f9448b = i;
        this.f9449c = i2;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f9448b != 0 && this.f9449c != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.f9450d;
                if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f9448b && this.f9451e >= this.f9449c) {
                    return true;
                }
                long j2 = this.f9450d;
                if (j2 == 0) {
                    this.f9450d = currentTimeMillis;
                } else if ((currentTimeMillis - j2) / 1000 > this.f9448b) {
                    this.f9450d = currentTimeMillis;
                    this.f9451e = 0;
                }
                this.f9451e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.f9451e;
            return i != 0 && i == this.f9449c;
        }
        return invokeV.booleanValue;
    }
}
