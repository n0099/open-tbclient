package com.baidu.location.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41227a;

    /* renamed from: b  reason: collision with root package name */
    public int f41228b;

    /* renamed from: c  reason: collision with root package name */
    public int f41229c;

    /* renamed from: d  reason: collision with root package name */
    public int f41230d;

    /* renamed from: e  reason: collision with root package name */
    public int f41231e;

    /* renamed from: f  reason: collision with root package name */
    public int f41232f;

    /* renamed from: g  reason: collision with root package name */
    public long f41233g;

    /* renamed from: h  reason: collision with root package name */
    public int f41234h;

    /* renamed from: i  reason: collision with root package name */
    public char f41235i;

    /* renamed from: j  reason: collision with root package name */
    public int f41236j;
    public String k;
    public boolean l;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41227a = -1;
        this.f41228b = -1;
        this.f41229c = -1;
        this.f41230d = -1;
        this.f41231e = Integer.MAX_VALUE;
        this.f41232f = Integer.MAX_VALUE;
        this.f41233g = 0L;
        this.f41234h = -1;
        this.f41235i = '0';
        this.f41236j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f41233g = System.currentTimeMillis();
    }

    public a(int i2, int i3, int i4, int i5, int i6, char c2, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Character.valueOf(c2), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41227a = -1;
        this.f41228b = -1;
        this.f41229c = -1;
        this.f41230d = -1;
        this.f41231e = Integer.MAX_VALUE;
        this.f41232f = Integer.MAX_VALUE;
        this.f41233g = 0L;
        this.f41234h = -1;
        this.f41235i = '0';
        this.f41236j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f41227a = i2;
        this.f41228b = i3;
        this.f41229c = i4;
        this.f41230d = i5;
        this.f41234h = i6;
        this.f41235i = c2;
        this.f41233g = System.currentTimeMillis();
        this.f41236j = i7;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this(aVar.f41227a, aVar.f41228b, aVar.f41229c, aVar.f41230d, aVar.f41234h, aVar.f41235i, aVar.f41236j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Character) objArr2[5]).charValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41233g = aVar.f41233g;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f41233g;
            return currentTimeMillis - j2 > 0 && currentTimeMillis - j2 < 3000;
        }
        return invokeV.booleanValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f41227a == aVar.f41227a && this.f41228b == aVar.f41228b && this.f41230d == aVar.f41230d && this.f41229c == aVar.f41229c : invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41227a > -1 && this.f41228b > 0 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41227a == -1 && this.f41228b == -1 && this.f41230d == -1 && this.f41229c == -1 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41227a > -1 && this.f41228b > -1 && this.f41230d == -1 && this.f41229c == -1 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41227a > -1 && this.f41228b > -1 && this.f41230d > -1 && this.f41229c > -1 : invokeV.booleanValue;
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
            stringBuffer.append(this.f41235i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f41229c), Integer.valueOf(this.f41230d), Integer.valueOf(this.f41227a), Integer.valueOf(this.f41228b), Integer.valueOf(this.f41234h)));
            if (this.f41236j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs=");
                stringBuffer.append(this.f41236j);
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
            stringBuffer.append(this.f41235i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f41229c), Integer.valueOf(this.f41230d), Integer.valueOf(this.f41227a), Integer.valueOf(this.f41228b), Integer.valueOf(this.f41234h)));
            if (this.f41236j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs2=");
                stringBuffer.append(this.f41236j);
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
