package com.baidu.location.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25997b;

    /* renamed from: c  reason: collision with root package name */
    public int f25998c;

    /* renamed from: d  reason: collision with root package name */
    public int f25999d;

    /* renamed from: e  reason: collision with root package name */
    public int f26000e;

    /* renamed from: f  reason: collision with root package name */
    public int f26001f;

    /* renamed from: g  reason: collision with root package name */
    public long f26002g;

    /* renamed from: h  reason: collision with root package name */
    public int f26003h;
    public char i;
    public int j;
    public String k;
    public boolean l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f25997b = -1;
        this.f25998c = -1;
        this.f25999d = -1;
        this.f26000e = Integer.MAX_VALUE;
        this.f26001f = Integer.MAX_VALUE;
        this.f26002g = 0L;
        this.f26003h = -1;
        this.i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f26002g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c2, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Character.valueOf(c2), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f25997b = -1;
        this.f25998c = -1;
        this.f25999d = -1;
        this.f26000e = Integer.MAX_VALUE;
        this.f26001f = Integer.MAX_VALUE;
        this.f26002g = 0L;
        this.f26003h = -1;
        this.i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.a = i;
        this.f25997b = i2;
        this.f25998c = i3;
        this.f25999d = i4;
        this.f26003h = i5;
        this.i = c2;
        this.f26002g = System.currentTimeMillis();
        this.j = i6;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this(aVar.a, aVar.f25997b, aVar.f25998c, aVar.f25999d, aVar.f26003h, aVar.i, aVar.j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Character) objArr2[5]).charValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f26002g = aVar.f26002g;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f26002g;
            return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
        }
        return invokeV.booleanValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.a == aVar.a && this.f25997b == aVar.f25997b && this.f25999d == aVar.f25999d && this.f25998c == aVar.f25998c : invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a > -1 && this.f25997b > 0 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a == -1 && this.f25997b == -1 && this.f25999d == -1 && this.f25998c == -1 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a > -1 && this.f25997b > -1 && this.f25999d == -1 && this.f25998c == -1 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a > -1 && this.f25997b > -1 && this.f25999d > -1 && this.f25998c > -1 : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = true;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(this.i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f25998c), Integer.valueOf(this.f25999d), Integer.valueOf(this.a), Integer.valueOf(this.f25997b), Integer.valueOf(this.f26003h)));
            if (this.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(this.j);
            }
            if (this.l) {
                stringBuffer.append("&newcl=1");
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw2=");
            stringBuffer.append(this.i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f25998c), Integer.valueOf(this.f25999d), Integer.valueOf(this.a), Integer.valueOf(this.f25997b), Integer.valueOf(this.f26003h)));
            if (this.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs2=");
                stringBuffer.append(this.j);
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
