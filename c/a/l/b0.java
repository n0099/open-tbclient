package c.a.l;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
public class b0 extends c implements p<c.a.o0.r.r.v0>, q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f3400h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView f3401e;

    /* renamed from: f  reason: collision with root package name */
    public Align f3402f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3403g;

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
        f3400h = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds124);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (Align) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = f3;
            layoutParams.topMargin = f4;
            i(layoutParams);
            this.f3401e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3401e.setPadding(0, 0, 0, 0);
            this.f3401e.setLayoutParams(layoutParams);
        }
    }

    public void l(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, align) == null) || this.f3402f == align) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize3;
            layoutParams.topMargin = dimenPixelSize4;
            i(layoutParams);
            this.f3401e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3401e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f3401e.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize5;
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.f3401e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f3401e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f3401e.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i = f3400h;
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = f3;
            layoutParams3.bottomMargin = f4;
            i(layoutParams3);
            this.f3401e.setWebPResId(R.drawable.obfuscated_res_0x7f0808ea, R.color.CAM_X0111);
            this.f3401e.setPadding(f2, f2, f2, f2);
            this.f3401e.setLayoutParams(layoutParams3);
        }
        this.f3402f = align;
    }

    public void m(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.getNegFeedBackData() == null) {
            return;
        }
        if (aVar.getNegFeedBackData().h() <= 0 && aVar.getThreadData() != null) {
            if (!aVar.showCardBottomOpWeight() && !aVar.isFromFrs()) {
                l(Align.ALIGN_RIGHT_BOTTOM);
            } else if (aVar.isSupportTop()) {
                v((!p(aVar) || UbsABTestHelper.showNewUI()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds50) : o(R.dimen.tbds64));
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f3406d;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                l(Align.ALIGN_RIGHT_TOP);
            }
        } else if (this.f3403g) {
            k();
        } else {
            r(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.c
    /* renamed from: n */
    public NEGFeedBackView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3401e : (NEGFeedBackView) invokeV.objValue;
    }

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.f3401e.q();
        }
    }

    public final boolean p(c.a.o0.r.r.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) ? (aVar instanceof c.a.p0.h0.e0.k) && ((c.a.p0.h0.e0.k) aVar).n : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: q */
    public void a(c.a.o0.r.r.v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v0Var) == null) {
            if (v0Var == null) {
                this.f3401e.setVisibility(8);
                return;
            }
            this.f3401e.setData(v0Var);
            this.f3401e.setFirstRowSingleColumn(true);
            this.f3401e.setVisibility(0);
        }
    }

    public final void r(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (aVar.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize3;
                layoutParams.topMargin = dimenPixelSize4;
                i(layoutParams);
                this.f3401e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f3401e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f3401e.setLayoutParams(layoutParams);
                return;
            }
            int i = f3400h;
            int f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int f3 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = f3;
            layoutParams2.topMargin = f4;
            i(layoutParams2);
            this.f3401e.setWebPResId(R.drawable.obfuscated_res_0x7f0808ea, R.color.CAM_X0111);
            this.f3401e.setPadding(f2, f2, f2, f2);
            this.f3401e.setLayoutParams(layoutParams2);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f3401e.setAutoProcess(z);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f3401e.setHeadText(str);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f3401e.setEventCallback(bVar);
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3401e.getLayoutParams();
            if (this.f3401e.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize3;
                layoutParams2.topMargin = i;
                i(layoutParams2);
                this.f3401e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f3401e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f3401e.setLayoutParams(layoutParams2);
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f3401e.s(z);
        }
    }

    public b0(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.f3401e = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.obfuscated_res_0x7f090764);
        g(this.f3401e);
        l(align);
    }
}
