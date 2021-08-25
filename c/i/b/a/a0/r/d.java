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
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f32587a;

    /* renamed from: b  reason: collision with root package name */
    public final l f32588b;

    /* renamed from: c  reason: collision with root package name */
    public int f32589c;

    /* renamed from: d  reason: collision with root package name */
    public int f32590d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32591e;

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
        this.f32587a = new e();
        this.f32588b = new l(new byte[65025], 0);
        this.f32589c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f32590d = 0;
            do {
                int i5 = this.f32590d;
                int i6 = i2 + i5;
                e eVar = this.f32587a;
                if (i6 >= eVar.f32596d) {
                    break;
                }
                int[] iArr = eVar.f32599g;
                this.f32590d = i5 + 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32587a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32588b : (l) invokeV.objValue;
    }

    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            c.i.b.a.i0.a.f(fVar != null);
            if (this.f32591e) {
                this.f32591e = false;
                this.f32588b.F();
            }
            while (!this.f32591e) {
                if (this.f32589c < 0) {
                    if (!this.f32587a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f32587a;
                    int i3 = eVar.f32597e;
                    if ((eVar.f32594b & 1) == 1 && this.f32588b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f32590d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f32589c = i2;
                }
                int a2 = a(this.f32589c);
                int i4 = this.f32589c + this.f32590d;
                if (a2 > 0) {
                    if (this.f32588b.b() < this.f32588b.d() + a2) {
                        l lVar = this.f32588b;
                        lVar.f33703a = Arrays.copyOf(lVar.f33703a, lVar.d() + a2);
                    }
                    l lVar2 = this.f32588b;
                    fVar.readFully(lVar2.f33703a, lVar2.d(), a2);
                    l lVar3 = this.f32588b;
                    lVar3.I(lVar3.d() + a2);
                    this.f32591e = this.f32587a.f32599g[i4 + (-1)] != 255;
                }
                if (i4 == this.f32587a.f32596d) {
                    i4 = -1;
                }
                this.f32589c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32587a.b();
            this.f32588b.F();
            this.f32589c = -1;
            this.f32591e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f32588b;
            byte[] bArr = lVar.f33703a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f33703a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
