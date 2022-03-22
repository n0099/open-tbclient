package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public RecommendInfoLayout f3420h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int f2 = c.a.d.f.p.n.f(context, R.dimen.M_H_X003);
        int f3 = c.a.d.f.p.n.f(context, HomeGroupUbsUIHelper.handleDimen(R.dimen.tbds21, R.dimen.tbds0));
        r(f2);
        q(f3);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().s instanceof RecommendInfoLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().s.getParent() == null) {
            this.f3420h = (RecommendInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().s;
        } else {
            this.f3420h = new RecommendInfoLayout(context);
        }
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3420h : (View) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.f3420h.b();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (UbsABTestHelper.showNewUI()) {
                int f2 = c.a.d.f.p.n.f(this.f3392b, R.dimen.M_H_X003);
                int f3 = c.a.d.f.p.n.f(this.f3392b, HomeGroupUbsUIHelper.handleDimen(R.dimen.tbds21, R.dimen.tbds0));
                r(f2);
                q(f3);
                return;
            }
            int f4 = c.a.d.f.p.n.f(this.f3392b, R.dimen.tbds10);
            r(f4);
            q(0);
            u(this.f3420h, f4, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: t */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f3420h.setData(aVar);
        }
    }

    public void u(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048581, this, view, i, i2) == null) && view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin == i && marginLayoutParams.bottomMargin == i2) {
                return;
            }
            marginLayoutParams.topMargin = i;
            marginLayoutParams.bottomMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
