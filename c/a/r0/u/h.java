package c.a.r0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11975b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11976c;

    /* renamed from: d  reason: collision with root package name */
    public long f11977d;

    /* renamed from: e  reason: collision with root package name */
    public int f11978e;

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
        this.a = str;
        this.f11975b = i2;
        this.f11976c = i3;
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
            if (this.f11975b != 0 && this.f11976c != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.f11977d;
                if (j2 != 0 && (currentTimeMillis - j2) / 1000 <= this.f11975b && this.f11978e >= this.f11976c) {
                    return true;
                }
                long j3 = this.f11977d;
                if (j3 == 0) {
                    this.f11977d = currentTimeMillis;
                } else if ((currentTimeMillis - j3) / 1000 > this.f11975b) {
                    this.f11977d = currentTimeMillis;
                    this.f11978e = 0;
                }
                this.f11978e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f11978e;
            return i2 != 0 && i2 == this.f11976c;
        }
        return invokeV.booleanValue;
    }
}
