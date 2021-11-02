package b.a.r0.w.f.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.w.f.c.e.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.SdkDoubleLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends b.a.e.l.e.a<e, SdkDoubleLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public b.a.r0.w.f.c.h.e n;
    public int o;
    public boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, int i2, boolean z) {
        super(tbPageContext.getPageActivity(), z ? e.f24603h : e.f24602g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        this.o = i2;
        this.p = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public SdkDoubleLiveViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.n = new b.a.r0.w.f.c.h.e(this.m, viewGroup, this.o, this.p);
            return new SdkDoubleLiveViewHolder(this.n);
        }
        return (SdkDoubleLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, e eVar, SdkDoubleLiveViewHolder sdkDoubleLiveViewHolder) {
        InterceptResult invokeCommon;
        b.a.r0.w.f.c.h.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, sdkDoubleLiveViewHolder})) == null) {
            if (sdkDoubleLiveViewHolder == null || (eVar2 = sdkDoubleLiveViewHolder.mView) == null) {
                return null;
            }
            eVar2.j(eVar);
            sdkDoubleLiveViewHolder.mView.k(this.m, TbadkCoreApplication.getInst().getSkinType());
            return sdkDoubleLiveViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
