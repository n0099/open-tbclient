package c.a.p0.a.d0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import c.a.p0.a.p2.l;
import c.a.p0.a.q0.d;
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
    public final String[] a;

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
        this.a = new String[]{c.a.p0.a.e2.b.w(), c.a.p0.a.e2.b.y(), c.a.p0.a.x.o.g.c.a.c()};
    }

    @Override // c.a.p0.a.d0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = c.a.p0.w.d.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            if (c.a.p0.a.a.a) {
                b(arraySet);
            }
            c.a.p0.a.u.d.k("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final void b(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) || arraySet == null) {
            return;
        }
        String[] strArr = {c.a.p0.a.f0.f.d.b().getAbsolutePath(), c.a.p0.a.g2.d.a.c().getAbsolutePath(), d.b.d(), l.b(), c.a.p0.a.q0.g.a.k(), c.a.p0.a.k1.l.a.b()};
        for (int i2 = 0; i2 < 6; i2++) {
            String K = c.a.p0.w.d.K(strArr[i2]);
            if (!TextUtils.isEmpty(K)) {
                arraySet.add(K);
            }
        }
    }
}
