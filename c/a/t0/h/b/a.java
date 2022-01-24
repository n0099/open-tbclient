package c.a.t0.h.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.h.e.f;
import c.a.t0.k3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.getTbPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, bdUniqueId};
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
        this.m = uVar;
    }

    @Override // c.a.t0.h.e.f, c.a.d.n.e.a
    public View E(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                c.a.t0.h.e.a injectPlugin = ((c.a.t0.h.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).k(i2, view, viewGroup, bVar.a());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.d.n.e.a
    public TypeAdapter.ViewHolder N(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b.h(getType()) != -1 && (obj instanceof b)) {
                c.a.t0.h.e.a injectPlugin = ((c.a.t0.h.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).e(viewGroup, ((b) obj).a());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // c.a.d.n.e.a
    public void T(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof b)) {
            c.a.t0.h.e.a injectPlugin = ((c.a.t0.h.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).l(i2, viewGroup, viewHolder, ((b) obj).a());
            }
        }
    }
}
