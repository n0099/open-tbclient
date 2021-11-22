package b.a.p0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import b.a.p0.a.a1.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String[] f7146a;

    public c() {
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
        this.f7146a = new String[]{b.a.p0.a.a1.d.i(), b.a.p0.a.a1.d.l(), b.a.p0.a.a1.d.r(), d.b.f(), b.a.p0.a.e0.f.f.b.f(), b.a.p0.a.e0.f.f.b.d(), b.a.p0.a.e0.f.c.a.c(), d.f.f(), d.f.d(), b.a.p0.a.x0.a.d.a.f9282d};
    }

    @Override // b.a.p0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f7146a) {
                String K = b.a.p0.w.d.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            b.a.p0.a.e0.d.k("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
