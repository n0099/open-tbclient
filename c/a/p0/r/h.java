package c.a.p0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f12279a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12280b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12281c;

    /* renamed from: d  reason: collision with root package name */
    public long f12282d;

    /* renamed from: e  reason: collision with root package name */
    public int f12283e;

    public h(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12279a = str;
        this.f12280b = i2;
        this.f12281c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12279a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f12280b != 0 && this.f12281c != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.f12282d;
                if (j2 != 0 && (currentTimeMillis - j2) / 1000 <= this.f12280b && this.f12283e >= this.f12281c) {
                    return true;
                }
                long j3 = this.f12282d;
                if (j3 == 0) {
                    this.f12282d = currentTimeMillis;
                } else if ((currentTimeMillis - j3) / 1000 > this.f12280b) {
                    this.f12282d = currentTimeMillis;
                    this.f12283e = 0;
                }
                this.f12283e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f12283e;
            return i2 != 0 && i2 == this.f12281c;
        }
        return invokeV.booleanValue;
    }
}
