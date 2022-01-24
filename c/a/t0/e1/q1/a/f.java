package c.a.t0.e1.q1.a;

import c.a.d.f.p.n;
import c.a.s0.s.s.g;
import c.a.s0.s.s.j;
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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PopupDialog a;

    /* renamed from: b  reason: collision with root package name */
    public j f16732b;

    /* renamed from: c  reason: collision with root package name */
    public String f16733c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f16734d;

    /* renamed from: e  reason: collision with root package name */
    public j.e f16735e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.a.f f16736f;

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
        this.f16736f = fVar;
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
                arrayList.add(new g(i2, strArr[i2], this.f16732b));
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

    public f d(j.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.f16735e = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
            this.f16734d = strArr;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f16733c = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j jVar = new j(this.f16736f.getPageActivity());
            this.f16732b = jVar;
            jVar.q(this.f16733c);
            this.f16732b.n(this.f16735e);
            this.f16732b.j(a(this.f16734d));
            this.f16732b.l(n.f(this.f16736f.getPageActivity(), R.dimen.tbds1248));
            PopupDialog popupDialog = new PopupDialog(this.f16736f, this.f16732b);
            this.a = popupDialog;
            popupDialog.showDialog();
        }
    }
}
