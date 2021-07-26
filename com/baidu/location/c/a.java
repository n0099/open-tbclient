package com.baidu.location.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6715a;

    /* renamed from: b  reason: collision with root package name */
    public int f6716b;

    /* renamed from: c  reason: collision with root package name */
    public int f6717c;

    /* renamed from: d  reason: collision with root package name */
    public int f6718d;

    /* renamed from: e  reason: collision with root package name */
    public int f6719e;

    /* renamed from: f  reason: collision with root package name */
    public int f6720f;

    /* renamed from: g  reason: collision with root package name */
    public long f6721g;

    /* renamed from: h  reason: collision with root package name */
    public int f6722h;

    /* renamed from: i  reason: collision with root package name */
    public char f6723i;
    public int j;
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
        this.f6715a = -1;
        this.f6716b = -1;
        this.f6717c = -1;
        this.f6718d = -1;
        this.f6719e = Integer.MAX_VALUE;
        this.f6720f = Integer.MAX_VALUE;
        this.f6721g = 0L;
        this.f6722h = -1;
        this.f6723i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6721g = System.currentTimeMillis();
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
        this.f6715a = -1;
        this.f6716b = -1;
        this.f6717c = -1;
        this.f6718d = -1;
        this.f6719e = Integer.MAX_VALUE;
        this.f6720f = Integer.MAX_VALUE;
        this.f6721g = 0L;
        this.f6722h = -1;
        this.f6723i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6715a = i2;
        this.f6716b = i3;
        this.f6717c = i4;
        this.f6718d = i5;
        this.f6722h = i6;
        this.f6723i = c2;
        this.f6721g = System.currentTimeMillis();
        this.j = i7;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this(aVar.f6715a, aVar.f6716b, aVar.f6717c, aVar.f6718d, aVar.f6722h, aVar.f6723i, aVar.j);
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
        this.f6721g = aVar.f6721g;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f6721g;
            return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
        }
        return invokeV.booleanValue;
    }

    public boolean a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f6715a == aVar.f6715a && this.f6716b == aVar.f6716b && this.f6718d == aVar.f6718d && this.f6717c == aVar.f6717c : invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6715a > -1 && this.f6716b > 0 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6715a == -1 && this.f6716b == -1 && this.f6718d == -1 && this.f6717c == -1 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6715a > -1 && this.f6716b > -1 && this.f6718d == -1 && this.f6717c == -1 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6715a > -1 && this.f6716b > -1 && this.f6718d > -1 && this.f6717c > -1 : invokeV.booleanValue;
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
            stringBuffer.append(this.f6723i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6717c), Integer.valueOf(this.f6718d), Integer.valueOf(this.f6715a), Integer.valueOf(this.f6716b), Integer.valueOf(this.f6722h)));
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
            stringBuffer.append(this.f6723i);
            stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6717c), Integer.valueOf(this.f6718d), Integer.valueOf(this.f6715a), Integer.valueOf(this.f6716b), Integer.valueOf(this.f6722h)));
            if (this.j != Integer.MAX_VALUE) {
                stringBuffer.append("&cl_cs2=");
                stringBuffer.append(this.j);
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
