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
    public final String f12287a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12288b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12289c;

    /* renamed from: d  reason: collision with root package name */
    public long f12290d;

    /* renamed from: e  reason: collision with root package name */
    public int f12291e;

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
        this.f12287a = str;
        this.f12288b = i2;
        this.f12289c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12287a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f12288b != 0 && this.f12289c != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.f12290d;
                if (j2 != 0 && (currentTimeMillis - j2) / 1000 <= this.f12288b && this.f12291e >= this.f12289c) {
                    return true;
                }
                long j3 = this.f12290d;
                if (j3 == 0) {
                    this.f12290d = currentTimeMillis;
                } else if ((currentTimeMillis - j3) / 1000 > this.f12288b) {
                    this.f12290d = currentTimeMillis;
                    this.f12291e = 0;
                }
                this.f12291e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f12291e;
            return i2 != 0 && i2 == this.f12289c;
        }
        return invokeV.booleanValue;
    }
}
