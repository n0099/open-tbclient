package c.a.u0.e1.q1.a;

import c.a.d.f.p.n;
import c.a.t0.s.t.g;
import c.a.t0.s.t.j;
import c.a.u0.e1.c1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupDialog a;

    /* renamed from: b  reason: collision with root package name */
    public j f16916b;

    /* renamed from: c  reason: collision with root package name */
    public String f16917c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f16918d;

    /* renamed from: e  reason: collision with root package name */
    public String f16919e;

    /* renamed from: f  reason: collision with root package name */
    public j.e f16920f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.a.f f16921g;

    public f(c.a.d.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16921g = fVar;
    }

    public static f c(c.a.d.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) ? new f(fVar) : (f) invokeL.objValue;
    }

    public final List<g> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                g gVar = new g(i2, str, this.f16916b);
                if (!StringUtils.isNull(this.f16919e) && this.f16919e.equals(str)) {
                    gVar.p(c1.CAM_X0304);
                    gVar.o();
                }
                arrayList.add(gVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (popupDialog = this.a) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public f d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f16919e = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(j.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f16920f = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.f16918d = strArr;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f16917c = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j jVar = new j(this.f16921g.getPageActivity());
            this.f16916b = jVar;
            jVar.q(this.f16917c);
            this.f16916b.n(this.f16920f);
            this.f16916b.j(a(this.f16918d));
            this.f16916b.l(n.f(this.f16921g.getPageActivity(), R.dimen.tbds1248));
            PopupDialog popupDialog = new PopupDialog(this.f16921g, this.f16916b);
            this.a = popupDialog;
            popupDialog.showDialog();
        }
    }
}
