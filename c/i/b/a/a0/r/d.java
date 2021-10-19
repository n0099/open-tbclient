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
    public final e f32723a;

    /* renamed from: b  reason: collision with root package name */
    public final l f32724b;

    /* renamed from: c  reason: collision with root package name */
    public int f32725c;

    /* renamed from: d  reason: collision with root package name */
    public int f32726d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32727e;

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
        this.f32723a = new e();
        this.f32724b = new l(new byte[65025], 0);
        this.f32725c = -1;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i4 = 0;
            this.f32726d = 0;
            do {
                int i5 = this.f32726d;
                int i6 = i2 + i5;
                e eVar = this.f32723a;
                if (i6 >= eVar.f32732d) {
                    break;
                }
                int[] iArr = eVar.f32735g;
                this.f32726d = i5 + 1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32723a : (e) invokeV.objValue;
    }

    public l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32724b : (l) invokeV.objValue;
    }

    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            c.i.b.a.i0.a.f(fVar != null);
            if (this.f32727e) {
                this.f32727e = false;
                this.f32724b.F();
            }
            while (!this.f32727e) {
                if (this.f32725c < 0) {
                    if (!this.f32723a.a(fVar, true)) {
                        return false;
                    }
                    e eVar = this.f32723a;
                    int i3 = eVar.f32733e;
                    if ((eVar.f32730b & 1) == 1 && this.f32724b.d() == 0) {
                        i3 += a(0);
                        i2 = this.f32726d + 0;
                    } else {
                        i2 = 0;
                    }
                    fVar.h(i3);
                    this.f32725c = i2;
                }
                int a2 = a(this.f32725c);
                int i4 = this.f32725c + this.f32726d;
                if (a2 > 0) {
                    if (this.f32724b.b() < this.f32724b.d() + a2) {
                        l lVar = this.f32724b;
                        lVar.f33839a = Arrays.copyOf(lVar.f33839a, lVar.d() + a2);
                    }
                    l lVar2 = this.f32724b;
                    fVar.readFully(lVar2.f33839a, lVar2.d(), a2);
                    l lVar3 = this.f32724b;
                    lVar3.I(lVar3.d() + a2);
                    this.f32727e = this.f32723a.f32735g[i4 + (-1)] != 255;
                }
                if (i4 == this.f32723a.f32732d) {
                    i4 = -1;
                }
                this.f32725c = i4;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32723a.b();
            this.f32724b.F();
            this.f32725c = -1;
            this.f32727e = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = this.f32724b;
            byte[] bArr = lVar.f33839a;
            if (bArr.length == 65025) {
                return;
            }
            lVar.f33839a = Arrays.copyOf(bArr, Math.max(65025, lVar.d()));
        }
    }
}
