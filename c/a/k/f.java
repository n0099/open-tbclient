package c.a.k;

import android.widget.RelativeLayout;
import c.a.q0.s.q.d2;
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
public class f extends c implements p<d2>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final CardForumHeadLayout f3510i;

    /* renamed from: j  reason: collision with root package name */
    public int f3511j;

    /* renamed from: k  reason: collision with root package name */
    public int f3512k;
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
        this.f3511j = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        this.f3512k = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.l = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        this.f3510i = new CardForumHeadLayout(tbPageContext.getPageActivity());
        g(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f3512k;
        layoutParams.topMargin = this.f3511j;
        layoutParams.bottomMargin = this.l;
        h(layoutParams);
        f(this.f3510i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.p
    /* renamed from: j */
    public void onBindDataToView(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (d2Var != null && d2Var.J() != null) {
                this.f3510i.setVisibility(0);
                this.f3510i.setData(d2Var);
                this.f3510i.setTag(d2Var);
                return;
            }
            this.f3510i.setVisibility(8);
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.f3510i.onChangeSkinType();
        }
    }
}
