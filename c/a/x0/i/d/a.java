package c.a.x0.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.x0.i.h;
import c.a.x0.t.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.x0.g.a f30872a;

    /* renamed from: b  reason: collision with root package name */
    public float f30873b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30874c;

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
        this.f30873b = 1.0f;
        this.f30874c = true;
    }

    @Override // c.a.x0.i.h
    public int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) {
            c.a.x0.g.a aVar = this.f30872a;
            if (aVar == null || !aVar.putBytes(bArr, i2)) {
                return 0;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.x0.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.f30874c && this.f30873b != 1.0f : invokeV.booleanValue;
    }

    @Override // c.a.x0.i.h
    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            if (this.f30872a == null) {
                this.f30872a = (c.a.x0.g.a) s.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
            }
            c.a.x0.g.a aVar = this.f30872a;
            if (aVar != null) {
                aVar.init(i4, i3);
                this.f30872a.setSpeed(1.0f);
                return false;
            }
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // c.a.x0.i.h
    public byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.x0.g.a aVar = this.f30872a;
            return aVar != null ? aVar.getOutPutBytes() : new byte[0];
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f30873b = f2;
            c.a.x0.g.a aVar = this.f30872a;
            if (aVar != null) {
                aVar.setSpeed(f2);
            }
        }
    }

    @Override // c.a.x0.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30872a != null : invokeV.booleanValue;
    }

    @Override // c.a.x0.i.h
    public void c() {
        c.a.x0.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f30872a) == null) {
            return;
        }
        aVar.flush();
    }

    @Override // c.a.x0.i.h
    public void d() {
        c.a.x0.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f30872a) == null) {
            return;
        }
        aVar.close();
        this.f30872a = null;
    }

    @Override // c.a.x0.i.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
