package c.a.q0.v.d.c.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.v.d.c.e.k;
import c.a.q0.v.d.c.f.d.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends c.a.e.l.e.a<k, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public c.a.q0.v.d.c.f.d.d n;
    public i o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.f25097h);
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
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: h0 */
    public LiveTabConcernItemViewLineHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.q0.v.d.c.f.d.d dVar = new c.a.q0.v.d.c.f.d.d(this.m, viewGroup);
            this.n = dVar;
            i iVar = this.o;
            if (iVar != null) {
                dVar.q(iVar);
            }
            return new LiveTabConcernItemViewLineHolder(this.n);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public View a0(int i2, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        c.a.q0.v.d.c.f.d.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder == null || (dVar = liveTabConcernItemViewLineHolder.mView) == null) {
                return null;
            }
            dVar.k(kVar);
            return liveTabConcernItemViewLineHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.o = iVar;
            c.a.q0.v.d.c.f.d.d dVar = this.n;
            if (dVar != null) {
                dVar.q(iVar);
            }
        }
    }
}
