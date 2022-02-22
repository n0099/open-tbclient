package c.a.t0.b1.g;

import android.text.TextUtils;
import android.view.ViewGroup;
import c.a.t0.b1.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f extends d<c.a.t0.g0.h, h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f12614e;

    public f(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12614e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.b1.g.d
    /* renamed from: g */
    public void d(ViewType viewType, c.a.t0.g0.h hVar, h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, hVar, bVar) == null) {
            hVar.m((!bVar.f12625b || TextUtils.isEmpty(bVar.a)) ? bVar.f12630g : bVar.a);
            hVar.k(bVar.f12627d);
            hVar.i(bVar.f12626c);
            hVar.n(bVar.f12629f);
            hVar.g(bVar.f12628e);
            hVar.p();
            hVar.onChangeSkinType();
            hVar.c().setOnClickListener(bVar.f12631h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.b1.g.d
    /* renamed from: h */
    public c.a.t0.g0.h f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new c.a.t0.g0.h(this.f12614e.getPageActivity(), null) : (c.a.t0.g0.h) invokeLL.objValue;
    }
}
