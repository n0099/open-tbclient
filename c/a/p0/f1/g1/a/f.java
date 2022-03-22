package c.a.p0.f1.g1.a;

import c.a.d.f.p.n;
import c.a.o0.r.t.h;
import c.a.o0.r.t.j;
import c.a.o0.r.t.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j a;

    /* renamed from: b  reason: collision with root package name */
    public l f13966b;

    /* renamed from: c  reason: collision with root package name */
    public String f13967c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f13968d;

    /* renamed from: e  reason: collision with root package name */
    public String f13969e;

    /* renamed from: f  reason: collision with root package name */
    public l.e f13970f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.a.f f13971g;

    public f(c.a.d.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13971g = fVar;
    }

    public static f c(c.a.d.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) ? new f(fVar) : (f) invokeL.objValue;
    }

    public final List<h> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                h hVar = new h(i, str, this.f13966b);
                if (!StringUtils.isNull(this.f13969e) && this.f13969e.equals(str)) {
                    hVar.q(R.color.CAM_X0304);
                    hVar.p();
                }
                arrayList.add(hVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jVar = this.a) == null) {
            return;
        }
        jVar.dismiss();
    }

    public f d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f13969e = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f13970f = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.f13968d = strArr;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f13967c = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l lVar = new l(this.f13971g.getPageActivity());
            this.f13966b = lVar;
            lVar.q(this.f13967c);
            this.f13966b.n(this.f13970f);
            this.f13966b.j(a(this.f13968d));
            this.f13966b.l(n.f(this.f13971g.getPageActivity(), R.dimen.obfuscated_res_0x7f070705));
            j jVar = new j(this.f13971g, this.f13966b);
            this.a = jVar;
            jVar.m();
        }
    }
}
