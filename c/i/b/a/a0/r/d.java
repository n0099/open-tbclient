package c.i.b.a.a0.r;

import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28761b;

    /* renamed from: c  reason: collision with root package name */
    public int f28762c;

    /* renamed from: d  reason: collision with root package name */
    public int f28763d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28764e;

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
        this.a = new e();
        this.f28761b = new l(new byte[65025], 0);
        this.f28762c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f28763d = 0;
            do {
                int i5 = this.f28763d;
                int i6 = i2 + i5;
                e eVar = this.a;
                if (i6 >= eVar.f28768d) {
                    break;
                }
                int[] iArr = eVar.f28771g;
                this.f28763d = i5 + 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28761b : (l) invokeV.objValue;
    }

    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            c.i.b.a.i0.a.f(fVar != null);
            if (this.f28764e) {
                this.f28764e = false;
                this.f28761b.F();
            }
            while (!this.f28764e) {
                if (this.f28762c < 0) {
                    if (!this.a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.a;
                    int i3 = eVar.f28769e;
                    if ((eVar.f28766b & 1) == 1 && this.f28761b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f28763d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f28762c = i2;
                }
                int a = a(this.f28762c);
                int i4 = this.f28762c + this.f28763d;
                if (a > 0) {
                    if (this.f28761b.b() < this.f28761b.d() + a) {
                        l lVar = this.f28761b;
                        lVar.a = Arrays.copyOf(lVar.a, lVar.d() + a);
                    }
                    l lVar2 = this.f28761b;
                    fVar.readFully(lVar2.a, lVar2.d(), a);
                    l lVar3 = this.f28761b;
                    lVar3.I(lVar3.d() + a);
                    this.f28764e = this.a.f28771g[i4 + (-1)] != 255;
                }
                if (i4 == this.a.f28768d) {
                    i4 = -1;
                }
                this.f28762c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.b();
            this.f28761b.F();
            this.f28762c = -1;
            this.f28764e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f28761b;
            byte[] bArr = lVar.a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
