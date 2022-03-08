package c.a.r0.f0;

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
public class n implements c.a.l.p<c.a.r0.f0.d0.m>, c.a.l.q {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int[] u;
    public static final int[] v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17325e;

    /* renamed from: f  reason: collision with root package name */
    public View f17326f;

    /* renamed from: g  reason: collision with root package name */
    public View f17327g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f17328h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17329i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f17330j;
    public TbImageSwitch k;
    public TextView l;
    public TextView m;
    public TextView n;
    public int o;
    public List<String> p;
    public TbImageSwitch.b q;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) && (view instanceof HeadImageView)) {
                ((HeadImageView) view).startLoad((String) this.a.p.get(i2), 12, n.r, n.r, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.view.TbImageSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.f17325e.getPageActivity());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(n.r, n.r));
                headImageView.setBorderWidth(n.s);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.p.size() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1783806791, "Lc/a/r0/f0/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1783806791, "Lc/a/r0/f0/n;");
                return;
            }
        }
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        t = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        u = new int[]{-7433746, -10909978};
        v = new int[]{2005832174, 2002355942};
    }

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 3;
        this.p = new ArrayList();
        this.q = new a(this);
        this.f17325e = tbPageContext;
        f(e());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f17326f == null) {
                this.f17326f = LayoutInflater.from(this.f17325e.getPageActivity()).inflate(R.layout.card_voice_room_layout, (ViewGroup) null, false);
            }
            return this.f17326f;
        }
        return (View) invokeV.objValue;
    }

    public final void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f17327g = view.findViewById(R.id.voice_room_talking_layout);
            this.f17328h = (TBLottieAnimationView) view.findViewById(R.id.voice_room_talking_lottie);
            this.f17329i = (TextView) view.findViewById(R.id.voice_room_talking_text);
            this.f17330j = (TextView) view.findViewById(R.id.card_voice_room_title);
            TbImageSwitch tbImageSwitch = (TbImageSwitch) view.findViewById(R.id.card_voice_room_talking_user_portrait);
            this.k = tbImageSwitch;
            int i2 = r;
            tbImageSwitch.init(3, i2, i2, t);
            this.k.setAnimationDuration(1);
            this.k.setCarouselDelayPeriod(2);
            this.k.setCarouselPeriod(2);
            this.k.setAdapter(this.q);
            this.l = (TextView) view.findViewById(R.id.card_voice_room_talking_num);
            this.m = (TextView) view.findViewById(R.id.card_voice_room_online_num);
            this.n = (TextView) view.findViewById(R.id.card_voice_room_join);
            onChangeSkinType(this.f17325e, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: g */
    public void onBindDataToView(c.a.r0.f0.d0.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null) {
            return;
        }
        this.f17330j.setText(mVar.d0());
        this.l.setText(String.format(this.f17325e.getResources().getString(R.string.voice_room_talking_num), mVar.e0()));
        this.m.setText(String.format(this.f17325e.getResources().getString(R.string.voice_room_online_num), mVar.a0()));
        if (!ListUtils.isEmpty(mVar.b0())) {
            if (mVar.b0().size() > 10) {
                this.p = mVar.b0().subList(0, 10);
            } else {
                this.p = mVar.b0();
            }
        }
        this.k.requestViewUpdate();
        this.f17328h.setRepeatCount(Integer.MAX_VALUE);
        this.f17328h.setRepeatMode(1);
        this.f17328h.playAnimation();
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            if (this.o != i2) {
                if (i2 != 1 && i2 != 4) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, u);
                } else {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, v);
                }
                gradientDrawable.setCornerRadius(25.0f);
                e().setBackgroundDrawable(gradientDrawable);
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f17327g);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0605);
                SkinManager.setLottieAnimation(this.f17328h, R.raw.lottie_voice_room_voicing_icon);
                c.a.q0.r.v.c.d(this.f17329i).v(R.color.CAM_X0101);
                c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.m);
                d3.v(R.color.CAM_X0620);
                d3.A(R.string.F_X02);
                c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.f17330j);
                d4.A(R.string.F_X02);
                d4.v(R.color.CAM_X0101);
                c.a.q0.r.v.c d5 = c.a.q0.r.v.c.d(this.l);
                d5.v(R.color.CAM_X0620);
                d5.A(R.string.F_X02);
                c.a.q0.r.v.c d6 = c.a.q0.r.v.c.d(this.n);
                d6.n(R.string.J_X07);
                d6.v(R.color.CAM_X0326);
                d6.f(R.color.CAM_X0621);
                if (!ListUtils.isEmpty(this.k.getChildViews())) {
                    for (View view : this.k.getChildViews()) {
                        if (view instanceof HeadImageView) {
                            ((HeadImageView) view).setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                        }
                    }
                }
            }
            this.o = i2;
        }
    }
}
