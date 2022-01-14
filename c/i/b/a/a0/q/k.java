package c.i.b.a.a0.q;

import androidx.annotation.Nullable;
import c.i.b.a.a0.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final m.a f28729b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28730c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f28731d;

    public k(boolean z, @Nullable String str, int i2, byte[] bArr, int i3, int i4, @Nullable byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4), bArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.a((bArr2 == null) ^ (i2 == 0));
        this.a = str;
        this.f28730c = i2;
        this.f28731d = bArr2;
        this.f28729b = new m.a(a(str), bArr, i3, i4);
    }

    public static int a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return 1;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals("cenc")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                return 1;
            }
            if (c2 == 2 || c2 == 3) {
                return 2;
            }
            String str2 = "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.";
            return 1;
        }
        return invokeL.intValue;
    }
}
