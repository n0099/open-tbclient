package c.a.p0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import c.a.p0.a.a1.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.l;
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
    public final String[] f7505a;

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
        this.f7505a = new String[]{c.a.p0.a.k2.b.w(), c.a.p0.a.k2.b.y(), c.a.p0.a.h0.o.h.d.a.c()};
    }

    @Override // c.a.p0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f7505a) {
                String J = c.a.p0.t.d.J(str);
                if (!TextUtils.isEmpty(J)) {
                    arraySet.add(J);
                }
            }
            if (k.f7077a) {
                b(arraySet);
            }
            c.a.p0.a.e0.d.h("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final void b(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) || arraySet == null) {
            return;
        }
        String[] strArr = {c.a.p0.a.p0.f.c.b().getAbsolutePath(), c.a.p0.a.m2.d.a.c().getAbsolutePath(), e.b.d(), l.b(), c.a.p0.a.a1.h.a.j(), c.a.p0.a.r1.l.a.b()};
        for (int i2 = 0; i2 < 6; i2++) {
            String J = c.a.p0.t.d.J(strArr[i2]);
            if (!TextUtils.isEmpty(J)) {
                arraySet.add(J);
            }
        }
    }
}
