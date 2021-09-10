package c.a.r0.f.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.f.e.f;
import c.a.r0.y2.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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

    @Override // c.a.e.l.e.a
    public View L(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                c.a.r0.f.e.a injectPlugin = ((c.a.r0.f.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).l(i2, view, viewGroup, bVar.b());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.e.l.e.a
    public TypeAdapter.ViewHolder V(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b.h(K()) != -1 && (obj instanceof b)) {
                c.a.r0.f.e.a injectPlugin = ((c.a.r0.f.e.b) this.m).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).f(viewGroup, ((b) obj).b());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // c.a.e.l.e.a
    public void b0(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof b)) {
            c.a.r0.f.e.a injectPlugin = ((c.a.r0.f.e.b) this.m).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).m(i2, viewGroup, viewHolder, ((b) obj).b());
            }
        }
    }
}
