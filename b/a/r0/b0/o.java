package b.a.r0.b0;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class o implements b.a.l.p<b.a.r0.b0.f0.m>, b.a.l.q {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int[] s;
    public static final int[] t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16319e;

    /* renamed from: f  reason: collision with root package name */
    public View f16320f;

    /* renamed from: g  reason: collision with root package name */
    public View f16321g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f16322h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16323i;
    public TextView j;
    public ImageOverlayView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1651030019, "Lb/a/r0/b0/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1651030019, "Lb/a/r0/b0/o;");
                return;
            }
        }
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds94);
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        s = new int[]{-7433746, -10909978};
        t = new int[]{2005832174, 2002355942};
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f16319e = tbPageContext;
        b(a());
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f16320f == null) {
                this.f16320f = LayoutInflater.from(this.f16319e.getPageActivity()).inflate(R.layout.card_voice_room_layout, (ViewGroup) null, false);
            }
            return this.f16320f;
        }
        return (View) invokeV.objValue;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f16321g = view.findViewById(R.id.voice_room_talking_layout);
            this.f16322h = (TBLottieAnimationView) view.findViewById(R.id.voice_room_talking_lottie);
            this.f16323i = (TextView) view.findViewById(R.id.voice_room_talking_text);
            this.j = (TextView) view.findViewById(R.id.card_voice_room_title);
            ImageOverlayView imageOverlayView = (ImageOverlayView) view.findViewById(R.id.card_voice_room_talking_user_portrait);
            this.k = imageOverlayView;
            int i2 = p;
            imageOverlayView.init(3, i2, i2, q, R.color.CAM_X0402, r);
            this.k.setStrokeStyle(1);
            this.k.setLoadImageType(12);
            this.l = (TextView) view.findViewById(R.id.card_voice_room_talking_num);
            this.m = (TextView) view.findViewById(R.id.card_voice_room_online_num);
            this.n = (TextView) view.findViewById(R.id.card_voice_room_join);
            onChangeSkinType(this.f16319e, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: c */
    public void onBindDataToView(b.a.r0.b0.f0.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null) {
            return;
        }
        this.j.setText(mVar.e0());
        this.l.setText(String.format(this.f16319e.getResources().getString(R.string.voice_room_talking_num), mVar.f0()));
        this.m.setText(String.format(this.f16319e.getResources().getString(R.string.voice_room_online_num), mVar.b0()));
        this.k.setData(mVar.c0());
        this.f16322h.setRepeatCount(Integer.MAX_VALUE);
        this.f16322h.setRepeatMode(1);
        this.f16322h.playAnimation();
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            if (this.o != i2) {
                if (i2 != 1 && i2 != 4) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, s);
                } else {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, t);
                }
                gradientDrawable.setCornerRadius(25.0f);
                a().setBackgroundDrawable(gradientDrawable);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f16321g);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0605);
                SkinManager.setLottieAnimation(this.f16322h, R.raw.lottie_voice_room_voicing_icon);
                b.a.q0.s.u.c.d(this.f16323i).v(R.color.CAM_X0101);
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.m);
                d3.v(R.color.CAM_X0620);
                d3.A(R.string.F_X02);
                b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.j);
                d4.A(R.string.F_X02);
                d4.v(R.color.CAM_X0101);
                b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.l);
                d5.v(R.color.CAM_X0620);
                d5.A(R.string.F_X02);
                b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.n);
                d6.n(R.string.J_X07);
                d6.v(R.color.CAM_X0326);
                d6.f(R.color.CAM_X0621);
            }
            this.o = i2;
        }
    }
}
