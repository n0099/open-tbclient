package c.a.d.o.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h<V extends TypeAdapter.ViewHolder> extends a<g, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a<n, V> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.d.o.e.a
    public V M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) ? N(viewGroup, new g()) : (V) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public V N(ViewGroup viewGroup, g gVar) {
        InterceptResult invokeLL;
        V M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, gVar)) == null) {
            a<n, V> aVar = this.i;
            if (aVar == null) {
                return null;
            }
            if (this.f2570d == aVar.y()) {
                M = this.i.L(viewGroup, gVar.e());
            } else if (this.f2570d == this.i.w()) {
                M = this.i.J(viewGroup, gVar.e());
            } else if (this.f2570d == this.i.x()) {
                M = this.i.K(viewGroup, gVar.e());
            } else if (this.f2570d == this.i.v()) {
                M = this.i.I(viewGroup, gVar.e());
            } else {
                M = this.i.M(viewGroup);
            }
            if (M != null) {
                V(this.i.A());
                return M;
            }
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i, View view, ViewGroup viewGroup, g gVar, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, gVar, v})) == null) {
            a<n, V> aVar = this.i;
            if (aVar == null) {
                return null;
            }
            if (this.f2570d == aVar.y()) {
                return this.i.R(i, view, viewGroup, gVar.e(), v);
            }
            if (this.f2570d == this.i.w()) {
                return this.i.P(i, view, viewGroup, gVar.e(), v);
            }
            if (this.f2570d == this.i.x()) {
                return this.i.Q(i, view, viewGroup, gVar.e(), v);
            }
            if (this.f2570d == this.i.v()) {
                return this.i.O(i, view, viewGroup, gVar.e(), v);
            }
            return this.i.S(i, view, viewGroup, gVar.e(), v);
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.i = aVar;
        }
    }
}
