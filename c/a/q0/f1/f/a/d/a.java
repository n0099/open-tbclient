package c.a.q0.f1.f.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.s;
import c.a.p0.s.q.c2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends c.a.e.l.e.a<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean m;
    public TbPageContext<?> n;
    public s o;
    public c.a.p0.n.f p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = true;
        o(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    @Override // c.a.e.l.e.a
    public View a0(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? view : (View) invokeCommon.objValue;
    }

    @Override // c.a.e.l.e.a
    public void f0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.f2970i = bdUniqueId;
        }
    }

    public void h0(View view, c2 c2Var) {
        c.a.p0.n.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, c2Var) == null) || (fVar = this.p) == null) {
            return;
        }
        int i2 = c2Var.position;
        fVar.a(view, c2Var, i2, i2);
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void j0(c.a.p0.n.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void k0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.o = sVar;
        }
    }

    public void l0(View view, c2 c2Var, int i2, long j2) {
        c.a.p0.n.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, c2Var, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (fVar = this.p) == null) {
            return;
        }
        fVar.c(view, c2Var, i2, j2);
    }

    public void o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, tbPageContext, bdUniqueId) == null) || tbPageContext == null) {
            return;
        }
        this.f2966e = tbPageContext.getPageActivity();
        this.n = tbPageContext;
        this.f2970i = bdUniqueId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        TbPageContext pageContext = ((TbPageContextSupport) context).getPageContext();
        this.n = pageContext;
        o(pageContext, pageContext == null ? null : pageContext.getUniqueId());
    }
}
