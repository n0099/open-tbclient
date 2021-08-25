package c.a.l;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b0 extends c implements p<x0>, q {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView f3796i;

    /* renamed from: j  reason: collision with root package name */
    public Align f3797j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343534628, "Lc/a/l/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343534628, "Lc/a/l/b0;");
                return;
            }
        }
        l = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (Align) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = g3;
            layoutParams.topMargin = g4;
            h(layoutParams);
            this.f3796i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3796i.setPadding(0, 0, 0, 0);
            this.f3796i.setLayoutParams(layoutParams);
        }
    }

    public void k(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, align) == null) || this.f3797j == align) {
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
            this.f3796i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3796i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f3796i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            h(layoutParams2);
            this.f3796i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3796i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f3796i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = l;
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            h(layoutParams3);
            this.f3796i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f3796i.setPadding(g2, g2, g2, g2);
            this.f3796i.setLayoutParams(layoutParams3);
        }
        this.f3797j = align;
    }

    public void l(c.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || aVar.getNegFeedBackData() == null) {
            return;
        }
        if (aVar.getNegFeedBackData().h() <= 0 && aVar.getThreadData() != null) {
            if (!aVar.showCardBottomOpWeight() && !aVar.isFromFrs()) {
                k(Align.ALIGN_RIGHT_BOTTOM);
            } else if (aVar.isSupportTop()) {
                u((!o(aVar) || c.a.p0.b.d.w0()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : n(R.dimen.tbds64));
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f3801h;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                k(Align.ALIGN_RIGHT_TOP);
            }
        } else if (this.k) {
            j();
        } else {
            q(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.c
    /* renamed from: m */
    public NEGFeedBackView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3796i : (NEGFeedBackView) invokeV.objValue;
    }

    public final int n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public final boolean o(c.a.p0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) ? (aVar instanceof c.a.q0.a0.d0.k) && ((c.a.q0.a0.d0.k) aVar).s : invokeL.booleanValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            this.f3796i.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: p */
    public void onBindDataToView(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, x0Var) == null) {
            if (x0Var == null) {
                this.f3796i.setVisibility(8);
                return;
            }
            this.f3796i.setData(x0Var);
            this.f3796i.setFirstRowSingleColumn(true);
            this.f3796i.setVisibility(0);
        }
    }

    public final void q(c.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (aVar.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                h(layoutParams);
                this.f3796i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f3796i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f3796i.setLayoutParams(layoutParams);
                return;
            }
            int i2 = l;
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = g3;
            layoutParams2.topMargin = g4;
            h(layoutParams2);
            this.f3796i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f3796i.setPadding(g2, g2, g2, g2);
            this.f3796i.setLayoutParams(layoutParams2);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f3796i.setAutoProcess(z);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f3796i.setHeadText(str);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f3796i.setEventCallback(bVar);
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3796i.getLayoutParams();
            if (this.f3796i.getParent() == null || layoutParams == null || layoutParams.topMargin != i2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.topMargin = i2;
                h(layoutParams2);
                this.f3796i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f3796i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f3796i.setLayoutParams(layoutParams2);
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f3796i.showWithNone(z);
        }
    }

    public b0(TbPageContext tbPageContext, Align align) {
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
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.f3796i = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.decor_item_right_id);
        f(this.f3796i);
        k(align);
    }
}
