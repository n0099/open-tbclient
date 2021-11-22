package b.a.p0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import b.a.p0.a.a1.d;
import b.a.p0.a.k;
import b.a.p0.a.z2.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f7147a;

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
        this.f7147a = new String[]{b.a.p0.a.o2.b.w(), b.a.p0.a.o2.b.y(), b.a.p0.a.h0.o.g.c.a.c()};
    }

    @Override // b.a.p0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f7147a) {
                String K = b.a.p0.w.d.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            if (k.f6863a) {
                b(arraySet);
            }
            b.a.p0.a.e0.d.k("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final void b(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) || arraySet == null) {
            return;
        }
        String[] strArr = {b.a.p0.a.p0.f.d.b().getAbsolutePath(), b.a.p0.a.q2.d.a.c().getAbsolutePath(), d.b.d(), l.b(), b.a.p0.a.a1.g.a.k(), b.a.p0.a.u1.l.a.b()};
        for (int i2 = 0; i2 < 6; i2++) {
            String K = b.a.p0.w.d.K(strArr[i2]);
            if (!TextUtils.isEmpty(K)) {
                arraySet.add(K);
            }
        }
    }
}
