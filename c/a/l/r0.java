package c.a.l;

import android.widget.RelativeLayout;
import c.a.s0.s.q.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r0 extends c implements p<e2>, q {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public UnfollowedDecorView f4352i;

    /* renamed from: j  reason: collision with root package name */
    public Align f4353j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343550004, "Lc/a/l/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343550004, "Lc/a/l/r0;");
                return;
            }
        }
        k = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    public r0(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g(-1);
        UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.f4352i = unfollowedDecorView;
        unfollowedDecorView.setId(R.id.decor_item_right_id);
        f(this.f4352i);
        j(align);
    }

    public void j(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, align) == null) || align == this.f4353j) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            h(layoutParams);
            this.f4352i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f4352i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f4352i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            h(layoutParams2);
            this.f4352i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f4352i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f4352i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = k;
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = f3;
            layoutParams3.bottomMargin = f4;
            h(layoutParams3);
            this.f4352i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f4352i.setPadding(f2, f2, f2, f2);
            this.f4352i.setLayoutParams(layoutParams3);
        }
        this.f4353j = align;
    }

    public void k(c.a.s0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar.isSupportTop()) {
                j(Align.ALIGN_RIGHT_TOP);
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f4297h;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                j(Align.ALIGN_RIGHT_TOP);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: l */
    public void onBindDataToView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            this.f4352i.bindData(e2Var);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            this.f4352i.onChangeSkinType();
        }
    }
}
