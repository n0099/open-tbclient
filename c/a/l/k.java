package c.a.l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class k extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.s.q.a l;
    public ForumEnterLayout m;
    public final View.OnClickListener n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f3814e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3814e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3814e.c() == null) {
                return;
            }
            this.f3814e.c().a(view, this.f3814e.l);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context) {
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
        this.n = new a(this);
        int g2 = c.a.e.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = c.a.e.e.p.l.g(context, c.a.q0.b.g.b.e(R.dimen.tbds21, R.dimen.tbds0));
        q(g2);
        p(g3);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f14257e instanceof ForumEnterLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f14257e.getParent() == null) {
            this.m = (ForumEnterLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f14257e;
        } else {
            this.m = new ForumEnterLayout(context);
        }
        this.m.setOnAfterClickListener(this.n);
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.m.onChangeSkinType(tbPageContext, i2);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.a.q0.b.d.k0()) {
                int g2 = c.a.e.e.p.l.g(this.f3783f, R.dimen.M_H_X003);
                int g3 = c.a.e.e.p.l.g(this.f3783f, c.a.q0.b.g.b.e(R.dimen.tbds21, R.dimen.tbds0));
                q(g2);
                p(g3);
                return;
            }
            int g4 = c.a.e.e.p.l.g(this.f3783f, R.dimen.tbds10);
            q(g4);
            p(0);
            u(this.m, g4, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: t */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.l = aVar;
            this.m.setSourceForPb(this.f3782e.i());
            this.m.setData(aVar);
        }
    }

    public void u(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048581, this, view, i2, i3) == null) && view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i3) {
                return;
            }
            marginLayoutParams.topMargin = i2;
            marginLayoutParams.bottomMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
