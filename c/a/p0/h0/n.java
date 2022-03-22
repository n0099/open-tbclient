package c.a.p0.h0;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.TbImageSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n implements c.a.l.p<c.a.p0.h0.e0.m>, c.a.l.q {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int[] q;
    public static final int[] r;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f15360b;

    /* renamed from: c  reason: collision with root package name */
    public View f15361c;

    /* renamed from: d  reason: collision with root package name */
    public TBLottieAnimationView f15362d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15363e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15364f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageSwitch f15365g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15366h;
    public TextView i;
    public TextView j;
    public int k;
    public List<String> l;
    public TbImageSwitch.b m;

    /* loaded from: classes2.dex */
    public class a implements TbImageSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void a(View view, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) && (view instanceof HeadImageView)) {
                ((HeadImageView) view).G((String) this.a.l.get(i), 12, n.n, n.n, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.a.getPageActivity());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(n.n, n.n));
                headImageView.setBorderWidth(n.o);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.l.size() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699966837, "Lc/a/p0/h0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699966837, "Lc/a/p0/h0/n;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        q = new int[]{-7433746, -10909978};
        r = new int[]{2005832174, 2002355942};
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 3;
        this.l = new ArrayList();
        this.m = new a(this);
        this.a = tbPageContext;
        g(f());
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f15360b == null) {
                this.f15360b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01cb, (ViewGroup) null, false);
            }
            return this.f15360b;
        }
        return (View) invokeV.objValue;
    }

    public final void g(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f15361c = view.findViewById(R.id.obfuscated_res_0x7f092407);
            this.f15362d = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f092408);
            this.f15363e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09240b);
            this.f15364f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090592);
            TbImageSwitch tbImageSwitch = (TbImageSwitch) view.findViewById(R.id.obfuscated_res_0x7f090591);
            this.f15365g = tbImageSwitch;
            int i = n;
            tbImageSwitch.l(3, i, i, p);
            this.f15365g.setAnimationDuration(1);
            this.f15365g.setCarouselDelayPeriod(2);
            this.f15365g.setCarouselPeriod(2);
            this.f15365g.setAdapter(this.m);
            this.f15366h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090590);
            this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09058f);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09058e);
            onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: h */
    public void a(c.a.p0.h0.e0.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f15364f.setText(mVar.c0());
        this.f15366h.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f152a), mVar.d0()));
        this.i.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1528), mVar.Z()));
        if (!ListUtils.isEmpty(mVar.a0())) {
            if (mVar.a0().size() > 10) {
                this.l = mVar.a0().subList(0, 10);
            } else {
                this.l = mVar.a0();
            }
        }
        this.f15365g.p();
        this.f15362d.setRepeatCount(Integer.MAX_VALUE);
        this.f15362d.setRepeatMode(1);
        this.f15362d.playAnimation();
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.k != i) {
                if (i != 1 && i != 4) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, q);
                } else {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r);
                }
                gradientDrawable.setCornerRadius(25.0f);
                f().setBackgroundDrawable(gradientDrawable);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f15361c);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0605);
                SkinManager.setLottieAnimation(this.f15362d, R.raw.lottie_voice_room_voicing_icon);
                c.a.o0.r.v.c.d(this.f15363e).v(R.color.CAM_X0101);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.i);
                d3.v(R.color.CAM_X0620);
                d3.A(R.string.F_X02);
                c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f15364f);
                d4.A(R.string.F_X02);
                d4.v(R.color.CAM_X0101);
                c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.f15366h);
                d5.v(R.color.CAM_X0620);
                d5.A(R.string.F_X02);
                c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.j);
                d6.n(R.string.J_X07);
                d6.v(R.color.CAM_X0326);
                d6.f(R.color.CAM_X0621);
                if (!ListUtils.isEmpty(this.f15365g.getChildViews())) {
                    for (View view : this.f15365g.getChildViews()) {
                        if (view instanceof HeadImageView) {
                            ((HeadImageView) view).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                        }
                    }
                }
            }
            this.k = i;
        }
    }
}
