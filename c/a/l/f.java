package c.a.l;

import android.widget.RelativeLayout;
import c.a.t0.s.r.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends c implements p<e2>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final CardForumHeadLayout f4371i;

    /* renamed from: j  reason: collision with root package name */
    public int f4372j;
    public int k;
    public int l;

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4372j = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        this.k = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.l = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        this.f4371i = new CardForumHeadLayout(tbPageContext.getPageActivity());
        g(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.k;
        layoutParams.topMargin = this.f4372j;
        layoutParams.bottomMargin = this.l;
        h(layoutParams);
        f(this.f4371i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: j */
    public void onBindDataToView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
            if (e2Var != null && e2Var.J() != null) {
                this.f4371i.setVisibility(0);
                this.f4371i.setData(e2Var);
                this.f4371i.setTag(e2Var);
                return;
            }
            this.f4371i.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.f4371i.onChangeSkinType();
        }
    }
}
