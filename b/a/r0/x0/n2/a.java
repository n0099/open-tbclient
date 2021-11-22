package b.a.r0.x0.n2;

import android.view.View;
import android.view.ViewGroup;
import b.a.r0.q1.o.b;
import b.a.r0.q1.o.l.e;
import b.a.r0.x0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.lego.LegoItemHolder;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends k<ICardInfo, LegoItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ICardInfo x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: t0 */
    public View L(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, iCardInfo})) == null) {
            this.x = iCardInfo;
            return super.L(i2, view, viewGroup, iCardInfo);
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: u0 */
    public LegoItemHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            e a2 = b.h().a(this.o, this.x, 1);
            if (a2 == null) {
                return null;
            }
            a2.registerListener(this.f2425i);
            return new LegoItemHolder(a2);
        }
        return (LegoItemHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.m.e.a
    /* renamed from: v0 */
    public View Z(int i2, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoItemHolder legoItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, iCardInfo, legoItemHolder})) == null) {
            super.Z(i2, view, viewGroup, iCardInfo, legoItemHolder);
            View view2 = legoItemHolder.getView();
            if (view2 != null && iCardInfo != null) {
                ((e) view2).update(iCardInfo);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
