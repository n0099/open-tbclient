package c.i.b.a.e0.q;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.e0.c;
import c.i.b.a.e0.e;
import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.charset.Charset;
import java.util.List;
/* loaded from: classes9.dex */
public final class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public final l n;
    public boolean o;
    public int p;
    public int q;
    public String r;
    public float s;
    public int t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190074045, "Lc/i/b/a/e0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190074045, "Lc/i/b/a/e0/q/a;");
                return;
            }
        }
        u = v.q("styl");
        v = v.q("tbox");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new l();
        E(list);
    }

    public static void A(boolean z) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65538, null, z) == null) && !z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void B(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || i2 == i3) {
            return;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
    }

    public static void C(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || i2 == i3) {
            return;
        }
        int i7 = i6 | 33;
        boolean z = (i2 & 1) != 0;
        boolean z2 = (i2 & 2) != 0;
        if (z) {
            if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
            } else {
                spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
            }
        } else if (z2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
        }
        boolean z3 = (i2 & 4) != 0;
        if (z3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
        }
        if (z3 || z || z2) {
            return;
        }
        spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
    }

    public static void D(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{spannableStringBuilder, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || str == str2) {
            return;
        }
        spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, i4 | 33);
    }

    public static String F(l lVar) throws SubtitleDecoderException {
        InterceptResult invokeL;
        char e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, lVar)) == null) {
            A(lVar.a() >= 2);
            int D = lVar.D();
            if (D == 0) {
                return "";
            }
            if (lVar.a() >= 2 && ((e2 = lVar.e()) == 65279 || e2 == 65534)) {
                return lVar.v(D, Charset.forName("UTF-16"));
            }
            return lVar.v(D, Charset.forName("UTF-8"));
        }
        return (String) invokeL.objValue;
    }

    public final void E(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            String str = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
            if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
                byte[] bArr = list.get(0);
                this.p = bArr[24];
                this.q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
                if ("Serif".equals(new String(bArr, 43, bArr.length - 43))) {
                    str = "serif";
                }
                this.r = str;
                this.t = bArr[25] * 20;
                boolean z = (bArr[0] & 32) != 0;
                this.o = z;
                if (z) {
                    float f2 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.t;
                    this.s = f2;
                    this.s = v.j(f2, 0.0f, 0.95f);
                    return;
                }
                this.s = 0.85f;
                return;
            }
            this.p = 0;
            this.q = -1;
            this.r = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
            this.o = false;
            this.s = 0.85f;
        }
    }

    @Override // c.i.b.a.e0.c
    public e w(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            this.n.H(bArr, i2);
            String F = F(this.n);
            if (F.isEmpty()) {
                return b.f29755f;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(F);
            C(spannableStringBuilder, this.p, 0, 0, spannableStringBuilder.length(), 16711680);
            B(spannableStringBuilder, this.q, -1, 0, spannableStringBuilder.length(), 16711680);
            D(spannableStringBuilder, this.r, TypefaceCompatApi28Impl.DEFAULT_FAMILY, 0, spannableStringBuilder.length(), 16711680);
            float f2 = this.s;
            while (this.n.a() >= 8) {
                int c2 = this.n.c();
                int i3 = this.n.i();
                int i4 = this.n.i();
                if (i4 == u) {
                    A(this.n.a() >= 2);
                    int D = this.n.D();
                    for (int i5 = 0; i5 < D; i5++) {
                        z(this.n, spannableStringBuilder);
                    }
                } else if (i4 == v && this.o) {
                    A(this.n.a() >= 2);
                    f2 = v.j(this.n.D() / this.t, 0.0f, 0.95f);
                }
                this.n.J(c2 + i3);
            }
            return new b(new c.i.b.a.e0.b(spannableStringBuilder, null, f2, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
        }
        return (e) invokeCommon.objValue;
    }

    public final void z(l lVar, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, lVar, spannableStringBuilder) == null) {
            A(lVar.a() >= 12);
            int D = lVar.D();
            int D2 = lVar.D();
            lVar.K(2);
            int x = lVar.x();
            lVar.K(1);
            int i2 = lVar.i();
            C(spannableStringBuilder, x, this.p, D, D2, 0);
            B(spannableStringBuilder, i2, this.q, D, D2, 0);
        }
    }
}
