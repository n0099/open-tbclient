package c.a.v0.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.i.h;
import c.a.v0.r.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.v0.g.b a;

    /* renamed from: b  reason: collision with root package name */
    public int f21598b;

    /* renamed from: c  reason: collision with root package name */
    public int f21599c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21600d;

    public b() {
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
        this.f21600d = true;
    }

    @Override // c.a.v0.i.h
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            c.a.v0.g.b bVar = this.a;
            if (bVar == null || bArr == null) {
                return 0;
            }
            this.f21598b += bArr.length;
            bVar.putBytes(bArr, i);
            return this.f21598b;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.v0.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.f21600d && this.a.available() : invokeV.booleanValue;
    }

    @Override // c.a.v0.i.h
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (c.a.v0.g.b) s.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            c.a.v0.g.b bVar = this.a;
            if (bVar != null) {
                bVar.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // c.a.v0.i.h
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            c.a.v0.g.b bVar = this.a;
            if (bVar == null || bVar.availableBytes() <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[4096];
            int bytes = this.a.getBytes(bArr, 4096);
            this.f21599c += bytes;
            if (bytes == 0) {
                return null;
            }
            if (4096 == bytes) {
                return bArr;
            }
            byte[] bArr2 = new byte[bytes];
            System.arraycopy(bArr, 0, bArr2, 0, bytes);
            return bArr2;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(int[] iArr) {
        c.a.v0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.setVoiceChangeType(iArr);
    }

    @Override // c.a.v0.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // c.a.v0.i.h
    public void c() {
        c.a.v0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        c.a.v0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // c.a.v0.i.h
    public void d() {
        c.a.v0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.close();
        this.a = null;
    }

    @Override // c.a.v0.i.h
    public void e() {
        c.a.v0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.a) == null) {
            return;
        }
        bVar.clearQueues();
    }
}
