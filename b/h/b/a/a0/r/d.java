package b.h.b.a.a0.r;

import b.h.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f32448a;

    /* renamed from: b  reason: collision with root package name */
    public final l f32449b;

    /* renamed from: c  reason: collision with root package name */
    public int f32450c;

    /* renamed from: d  reason: collision with root package name */
    public int f32451d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32452e;

    public d() {
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
        this.f32448a = new e();
        this.f32449b = new l(new byte[65025], 0);
        this.f32450c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f32451d = 0;
            do {
                int i5 = this.f32451d;
                int i6 = i2 + i5;
                e eVar = this.f32448a;
                if (i6 >= eVar.f32457d) {
                    break;
                }
                int[] iArr = eVar.f32460g;
                this.f32451d = i5 + 1;
                i3 = iArr[i5 + i2];
                i4 += i3;
            } while (i3 == 255);
            return i4;
        }
        return invokeI.intValue;
    }

    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32448a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32449b : (l) invokeV.objValue;
    }

    public boolean d(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            b.h.b.a.i0.a.f(fVar != null);
            if (this.f32452e) {
                this.f32452e = false;
                this.f32449b.F();
            }
            while (!this.f32452e) {
                if (this.f32450c < 0) {
                    if (!this.f32448a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f32448a;
                    int i3 = eVar.f32458e;
                    if ((eVar.f32455b & 1) == 1 && this.f32449b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f32451d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f32450c = i2;
                }
                int a2 = a(this.f32450c);
                int i4 = this.f32450c + this.f32451d;
                if (a2 > 0) {
                    if (this.f32449b.b() < this.f32449b.d() + a2) {
                        l lVar = this.f32449b;
                        lVar.f33493a = Arrays.copyOf(lVar.f33493a, lVar.d() + a2);
                    }
                    l lVar2 = this.f32449b;
                    fVar.readFully(lVar2.f33493a, lVar2.d(), a2);
                    l lVar3 = this.f32449b;
                    lVar3.I(lVar3.d() + a2);
                    this.f32452e = this.f32448a.f32460g[i4 + (-1)] != 255;
                }
                if (i4 == this.f32448a.f32457d) {
                    i4 = -1;
                }
                this.f32450c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32448a.b();
            this.f32449b.F();
            this.f32450c = -1;
            this.f32452e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f32449b;
            byte[] bArr = lVar.f33493a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f33493a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
