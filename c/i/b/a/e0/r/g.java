package c.i.b.a.e0.r;

import android.text.TextUtils;
import c.i.b.a.e0.r.e;
import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class g extends c.i.b.a.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f n;
    public final l o;
    public final e.b p;
    public final a q;
    public final List<d> r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g() {
        super("WebvttDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new f();
        this.o = new l();
        this.p = new e.b();
        this.q = new a();
        this.r = new ArrayList();
    }

    public static int A(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) {
            int i2 = -1;
            int i3 = 0;
            while (i2 == -1) {
                i3 = lVar.c();
                String k2 = lVar.k();
                if (k2 == null) {
                    i2 = 0;
                } else if ("STYLE".equals(k2)) {
                    i2 = 2;
                } else {
                    i2 = "NOTE".startsWith(k2) ? 1 : 3;
                }
            }
            lVar.J(i3);
            return i2;
        }
        return invokeL.intValue;
    }

    public static void B(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, lVar) == null) {
            do {
            } while (!TextUtils.isEmpty(lVar.k()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.e0.c
    /* renamed from: z */
    public i w(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return (i) invokeCommon.objValue;
        }
        this.o.H(bArr, i2);
        this.p.c();
        this.r.clear();
        h.d(this.o);
        do {
        } while (!TextUtils.isEmpty(this.o.k()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int A = A(this.o);
            if (A == 0) {
                return new i(arrayList);
            }
            if (A == 1) {
                B(this.o);
            } else if (A == 2) {
                if (arrayList.isEmpty()) {
                    this.o.k();
                    d d2 = this.q.d(this.o);
                    if (d2 != null) {
                        this.r.add(d2);
                    }
                } else {
                    throw new SubtitleDecoderException("A style block was found after the first cue.");
                }
            } else if (A == 3 && this.n.h(this.o, this.p, this.r)) {
                arrayList.add(this.p.a());
                this.p.c();
            }
        }
    }
}
