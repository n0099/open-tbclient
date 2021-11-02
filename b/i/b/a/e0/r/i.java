package b.i.b.a.e0.r;

import android.text.SpannableStringBuilder;
import b.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public final class i implements b.i.b.a.e0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<e> f32447e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32448f;

    /* renamed from: g  reason: collision with root package name */
    public final long[] f32449g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f32450h;

    public i(List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32447e = list;
        int size = list.size();
        this.f32448f = size;
        this.f32449g = new long[size * 2];
        for (int i4 = 0; i4 < this.f32448f; i4++) {
            e eVar = list.get(i4);
            int i5 = i4 * 2;
            long[] jArr = this.f32449g;
            jArr[i5] = eVar.q;
            jArr[i5 + 1] = eVar.r;
        }
        long[] jArr2 = this.f32449g;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f32450h = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // b.i.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            b.i.b.a.i0.a.a(i2 >= 0);
            b.i.b.a.i0.a.a(i2 < this.f32450h.length);
            return this.f32450h[i2];
        }
        return invokeI.longValue;
    }

    @Override // b.i.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32450h.length : invokeV.intValue;
    }

    @Override // b.i.b.a.e0.e
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int b2 = v.b(this.f32450h, j, false, false);
            if (b2 < this.f32450h.length) {
                return b2;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    @Override // b.i.b.a.e0.e
    public List<b.i.b.a.e0.b> d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SpannableStringBuilder spannableStringBuilder = null;
            e eVar = null;
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < this.f32448f; i2++) {
                long[] jArr = this.f32449g;
                int i3 = i2 * 2;
                if (jArr[i3] <= j && j < jArr[i3 + 1]) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    e eVar2 = this.f32447e.get(i2);
                    if (!eVar2.a()) {
                        arrayList.add(eVar2);
                    } else if (eVar == null) {
                        eVar = eVar2;
                    } else if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(eVar.f32279e).append((CharSequence) StringUtils.LF).append(eVar2.f32279e);
                    } else {
                        spannableStringBuilder.append((CharSequence) StringUtils.LF).append(eVar2.f32279e);
                    }
                }
            }
            if (spannableStringBuilder != null) {
                arrayList.add(new e(spannableStringBuilder));
            } else if (eVar != null) {
                arrayList.add(eVar);
            }
            return arrayList != null ? arrayList : Collections.emptyList();
        }
        return (List) invokeJ.objValue;
    }
}
