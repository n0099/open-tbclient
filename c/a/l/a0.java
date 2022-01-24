package c.a.l;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().o instanceof MultiLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().o.getParent() == null) {
            this.l = (MultiLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().o;
        } else {
            this.l = new MultiLinkCardView(context);
        }
        q(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.l.onChangeSkinType();
        }
    }

    public final boolean r(c.a.s0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || !aVar.getThreadData().I2() || aVar.getThreadData().u1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean s(c.a.s0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) ? (aVar == null || aVar.getThreadData() == null || aVar.getThreadData().K0() == null || aVar.getThreadData().K0().getOptions() == null || aVar.getThreadData().K0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: t */
    public void onBindDataToView(c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (!s(aVar) && !r(aVar) && aVar != null && aVar.getThreadData() != null && ((!ListUtils.isEmpty(aVar.getThreadData().C0()) || ListUtils.getCount(aVar.getThreadData().e0()) > 1) && ((!ListUtils.isEmpty(aVar.getThreadData().e0()) || ListUtils.getCount(aVar.getThreadData().C0()) > 1) && ListUtils.getCount(aVar.getThreadData().C0()) + ListUtils.getCount(aVar.getThreadData().e0()) > 1))) {
                this.l.bindData(aVar.getThreadData().C0(), aVar.getThreadData().e0());
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }
}
