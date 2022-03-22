package c.a.o0.a1.g;

import android.text.TextUtils;
import android.view.ViewGroup;
import c.a.o0.a1.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f extends d<c.a.o0.f0.h, h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f9808e;

    public f(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9808e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a1.g.d
    /* renamed from: g */
    public void d(ViewType viewType, c.a.o0.f0.h hVar, h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, hVar, bVar) == null) {
            hVar.m((!bVar.f9819b || TextUtils.isEmpty(bVar.a)) ? bVar.f9824g : bVar.a);
            hVar.k(bVar.f9821d);
            hVar.i(bVar.f9820c);
            hVar.n(bVar.f9823f);
            hVar.g(bVar.f9822e);
            hVar.p();
            hVar.onChangeSkinType();
            hVar.c().setOnClickListener(bVar.f9825h);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a1.g.d
    /* renamed from: h */
    public c.a.o0.f0.h f(ViewType viewType, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewType, viewGroup)) == null) ? new c.a.o0.f0.h(this.f9808e.getPageActivity(), null) : (c.a.o0.f0.h) invokeLL.objValue;
    }
}
