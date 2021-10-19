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
public class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.x0.g.b f30875a;

    /* renamed from: b  reason: collision with root package name */
    public int f30876b;

    /* renamed from: c  reason: collision with root package name */
    public int f30877c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30878d;

    public b() {
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
        this.f30878d = true;
    }

    @Override // c.a.x0.i.h
    public int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) {
            c.a.x0.g.b bVar = this.f30875a;
            if (bVar == null || bArr == null) {
                return 0;
            }
            this.f30876b += bArr.length;
            bVar.putBytes(bArr, i2);
            return this.f30876b;
        }
        return invokeLI.intValue;
    }

    @Override // c.a.x0.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.f30878d && this.f30875a.available() : invokeV.booleanValue;
    }

    @Override // c.a.x0.i.h
    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            if (this.f30875a == null) {
                this.f30875a = (c.a.x0.g.b) s.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            c.a.x0.g.b bVar = this.f30875a;
            if (bVar != null) {
                bVar.initVoiceChanger(i2, i3, i4, i5);
            }
            return this.f30875a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // c.a.x0.i.h
    public byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c.a.x0.g.b bVar = this.f30875a;
            if (bVar == null || bVar.availableBytes() <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[4096];
            int bytes = this.f30875a.getBytes(bArr, 4096);
            this.f30877c += bytes;
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
        c.a.x0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (bVar = this.f30875a) == null) {
            return;
        }
        bVar.setVoiceChangeType(iArr);
    }

    @Override // c.a.x0.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30875a != null : invokeV.booleanValue;
    }

    @Override // c.a.x0.i.h
    public void c() {
        c.a.x0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bVar = this.f30875a) == null) {
            return;
        }
        bVar.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        c.a.x0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (bVar = this.f30875a) == null) {
            return;
        }
        bVar.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // c.a.x0.i.h
    public void d() {
        c.a.x0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.f30875a) == null) {
            return;
        }
        bVar.close();
        this.f30875a = null;
    }

    @Override // c.a.x0.i.h
    public void e() {
        c.a.x0.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f30875a) == null) {
            return;
        }
        bVar.clearQueues();
    }
}
