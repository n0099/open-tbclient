package c.a.d.m.e;

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
    public a<n, V> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.d.m.e.a
    public V S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) ? T(viewGroup, new g()) : (V) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: g0 */
    public V T(ViewGroup viewGroup, g gVar) {
        InterceptResult invokeLL;
        V S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, gVar)) == null) {
            a<n, V> aVar = this.m;
            if (aVar == null) {
                return null;
            }
            if (this.f2874h == aVar.y()) {
                S = this.m.Q(viewGroup, gVar.g());
            } else if (this.f2874h == this.m.w()) {
                S = this.m.M(viewGroup, gVar.g());
            } else if (this.f2874h == this.m.x()) {
                S = this.m.O(viewGroup, gVar.g());
            } else if (this.f2874h == this.m.v()) {
                S = this.m.L(viewGroup, gVar.g());
            } else {
                S = this.m.S(viewGroup);
            }
            if (S != null) {
                c0(this.m.A());
                return S;
            }
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, g gVar, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, v})) == null) {
            a<n, V> aVar = this.m;
            if (aVar == null) {
                return null;
            }
            if (this.f2874h == aVar.y()) {
                return this.m.Y(i2, view, viewGroup, gVar.g(), v);
            }
            if (this.f2874h == this.m.w()) {
                return this.m.W(i2, view, viewGroup, gVar.g(), v);
            }
            if (this.f2874h == this.m.x()) {
                return this.m.X(i2, view, viewGroup, gVar.g(), v);
            }
            if (this.f2874h == this.m.v()) {
                return this.m.V(i2, view, viewGroup, gVar.g(), v);
            }
            return this.m.Z(i2, view, viewGroup, gVar.g(), v);
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.m = aVar;
        }
    }
}
