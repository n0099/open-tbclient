package b.a.l;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().n instanceof SingleLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().n.getParent() == null) {
            this.l = (SingleLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().n;
        } else {
            this.l = new SingleLinkCardView(context);
        }
        q(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.l.onChangeSkinType();
        }
    }

    public final boolean r(b.a.q0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().G2() || aVar.getThreadData().r1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean s(b.a.q0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().I0() == null || aVar.getThreadData().I0().getOptions() == null || aVar.getThreadData().I0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: t */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (!s(aVar) && aVar != null && aVar.getThreadData() != null && !r(aVar) && ((!ListUtils.isEmpty(aVar.getThreadData().A0()) || ListUtils.getCount(aVar.getThreadData().c0()) == 1) && ((!ListUtils.isEmpty(aVar.getThreadData().c0()) || ListUtils.getCount(aVar.getThreadData().A0()) == 1) && ListUtils.getCount(aVar.getThreadData().A0()) + ListUtils.getCount(aVar.getThreadData().c0()) == 1))) {
                if (aVar.getThreadData().A0().size() >= 1) {
                    this.l.bindData((b.a.r0.b0.f0.c) ListUtils.getItem(aVar.getThreadData().A0(), 0));
                } else if (aVar.getThreadData().c0().size() >= 1) {
                    this.l.bindData((b.a.r0.b0.f0.c) ListUtils.getItem(aVar.getThreadData().c0(), 0));
                }
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
