package c.a.q0.v.d.g.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.v.d.g.c.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.ConcernTabLiveItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.e.l.e.a<f, ConcernTabLiveItemView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public String n;
    public String o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), f.f25317h);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.n = "";
        this.o = "";
        this.m = tbPageContext;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public ConcernTabLiveItemView.ViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ConcernTabLiveItemView concernTabLiveItemView = new ConcernTabLiveItemView(this.m, viewGroup);
            concernTabLiveItemView.t(this.n);
            concernTabLiveItemView.a(this.o);
            concernTabLiveItemView.getClass();
            return new ConcernTabLiveItemView.ViewHolder(concernTabLiveItemView, concernTabLiveItemView);
        }
        return (ConcernTabLiveItemView.ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, f fVar, ConcernTabLiveItemView.ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, viewHolder})) == null) {
            if (viewHolder == null || fVar == null) {
                return null;
            }
            viewHolder.concernTabLiveItemView.k(fVar);
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.n = str;
        }
    }
}
