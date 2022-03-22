package c.a.l;

import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends c implements p<ThreadData>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final CardForumHeadLayout f3416e;

    /* renamed from: f  reason: collision with root package name */
    public int f3417f;

    /* renamed from: g  reason: collision with root package name */
    public int f3418g;

    /* renamed from: h  reason: collision with root package name */
    public int f3419h;

    public f(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3417f = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        this.f3418g = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.f3419h = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        this.f3416e = new CardForumHeadLayout(tbPageContext.getPageActivity());
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f3418g;
        layoutParams.topMargin = this.f3417f;
        layoutParams.bottomMargin = this.f3419h;
        i(layoutParams);
        g(this.f3416e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: k */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                this.f3416e.setVisibility(0);
                this.f3416e.setData(threadData);
                this.f3416e.setTag(threadData);
                return;
            }
            this.f3416e.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.f3416e.d();
        }
    }
}
