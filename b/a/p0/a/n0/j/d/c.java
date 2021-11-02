package b.a.p0.a.n0.j.d;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import b.a.p0.a.a1.e;
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
    public String[] f6817a;

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
        this.f6817a = new String[]{b.a.p0.a.a1.e.i(), b.a.p0.a.a1.e.l(), b.a.p0.a.a1.e.r(), e.b.f(), b.a.p0.a.e0.f.f.b.f(), b.a.p0.a.e0.f.f.b.d(), b.a.p0.a.e0.f.c.a.c(), e.f.f(), e.f.d(), b.a.p0.a.x0.a.d.a.f8938d};
    }

    @Override // b.a.p0.a.n0.j.d.a
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.f6817a) {
                String J = b.a.p0.t.d.J(str);
                if (!TextUtils.isEmpty(J)) {
                    arraySet.add(J);
                }
            }
            b.a.p0.a.e0.d.h("SwanSandboxFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }
}
