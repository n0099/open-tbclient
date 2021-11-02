package b.i.b.a.a0.r;

import b.i.b.a.i0.l;
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
    public final e f31590a;

    /* renamed from: b  reason: collision with root package name */
    public final l f31591b;

    /* renamed from: c  reason: collision with root package name */
    public int f31592c;

    /* renamed from: d  reason: collision with root package name */
    public int f31593d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31594e;

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
        this.f31590a = new e();
        this.f31591b = new l(new byte[65025], 0);
        this.f31592c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f31593d = 0;
            do {
                int i5 = this.f31593d;
                int i6 = i2 + i5;
                e eVar = this.f31590a;
                if (i6 >= eVar.f31599d) {
                    break;
                }
                int[] iArr = eVar.f31602g;
                this.f31593d = i5 + 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31590a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31591b : (l) invokeV.objValue;
    }

    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            b.i.b.a.i0.a.f(fVar != null);
            if (this.f31594e) {
                this.f31594e = false;
                this.f31591b.F();
            }
            while (!this.f31594e) {
                if (this.f31592c < 0) {
                    if (!this.f31590a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f31590a;
                    int i3 = eVar.f31600e;
                    if ((eVar.f31597b & 1) == 1 && this.f31591b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f31593d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f31592c = i2;
                }
                int a2 = a(this.f31592c);
                int i4 = this.f31592c + this.f31593d;
                if (a2 > 0) {
                    if (this.f31591b.b() < this.f31591b.d() + a2) {
                        l lVar = this.f31591b;
                        lVar.f32635a = Arrays.copyOf(lVar.f32635a, lVar.d() + a2);
                    }
                    l lVar2 = this.f31591b;
                    fVar.readFully(lVar2.f32635a, lVar2.d(), a2);
                    l lVar3 = this.f31591b;
                    lVar3.I(lVar3.d() + a2);
                    this.f31594e = this.f31590a.f31602g[i4 + (-1)] != 255;
                }
                if (i4 == this.f31590a.f31599d) {
                    i4 = -1;
                }
                this.f31592c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f31590a.b();
            this.f31591b.F();
            this.f31592c = -1;
            this.f31594e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f31591b;
            byte[] bArr = lVar.f32635a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f32635a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
