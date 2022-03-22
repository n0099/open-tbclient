package c.a.p0.h.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.h.e.f;
import c.a.p0.l3.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(v vVar, BdUniqueId bdUniqueId) {
        super(vVar.j().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = vVar;
    }

    @Override // c.a.p0.h.e.f, c.a.d.o.e.a
    public View E(int i, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view, viewGroup, obj})) == null) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                c.a.p0.h.e.a injectPlugin = ((c.a.p0.h.e.b) this.i).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).k(i, view, viewGroup, bVar.a());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.d.o.e.a
    public TypeAdapter.ViewHolder N(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b.g(getType()) != -1 && (obj instanceof b)) {
                c.a.p0.h.e.a injectPlugin = ((c.a.p0.h.e.b) this.i).getInjectPlugin(1);
                if (injectPlugin instanceof d) {
                    return ((d) injectPlugin).e(viewGroup, ((b) obj).a());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // c.a.d.o.e.a
    public void T(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof b)) {
            c.a.p0.h.e.a injectPlugin = ((c.a.p0.h.e.b) this.i).getInjectPlugin(1);
            if (injectPlugin instanceof d) {
                ((d) injectPlugin).l(i, viewGroup, viewHolder, ((b) obj).a());
            }
        }
    }
}
