package b.a.r0.h1.h.i;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.e.l.e.c;
import b.a.q0.s.g0.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends c implements BigdaySwipeRefreshLayout.k, PersonalizePageView.h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView k;
    public LottieAnimationView l;
    public ImageView m;
    public TextView n;
    public b.a.q0.s.n.a o;
    public String p;
    public String q;
    public String r;
    public String s;
    public f.g t;
    public f.InterfaceC0677f u;
    public f.h v;
    public f.e w;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17449a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17449a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || this.f17449a.k.getBdImage() != null || this.f17449a.o == null || k.isEmpty(this.f17449a.o.f13162a)) {
                return;
            }
            this.f17449a.k.startLoad(this.f17449a.o.f13162a, 41, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
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
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        if (context != null) {
            this.p = context.getText(R.string.adp_pull_to_refresh).toString();
            this.q = context.getText(R.string.bigday_refreshing).toString();
            this.r = context.getText(R.string.bigday_release_to_refresh).toString();
            this.s = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    public b.a.q0.s.n.a A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (b.a.q0.s.n.a) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void C(float f2) {
        b.a.q0.s.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.n.setAlpha(f2);
            this.m.setAlpha(f2);
            if (this.m.getBackground() != null || (aVar = this.o) == null) {
                return;
            }
            if (aVar.f13164c == 1) {
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }

    public void D(b.a.q0.s.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar.a()) {
                this.o = aVar;
            }
            if (aVar.f13164c == 1) {
                this.n.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
                this.l.setAnimation(R.raw.lottie_refresh_light);
            } else {
                this.n.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
                this.l.setAnimation(R.raw.lottie_refresh_dark);
            }
            this.l.setFrame(0);
            this.k.startLoad(aVar.f13162a, 41, false);
            this.k.setOnDrawListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.h0
    public void a(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.t = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.h0
    public void b(f.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.v = hVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n.setText(this.s);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void d() {
        b.a.q0.s.n.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (aVar = this.o) != null && aVar.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context context = getContext();
            b.a.q0.s.n.a aVar2 = this.o;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(context, aVar2.f13162a, aVar2.f13163b, aVar2.f13165d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) (l.i(getContext()) * 0.3d) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.h0
    public void f(f.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.w = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.n.animate().alpha(0.0f).setDuration(200L).start();
            this.m.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.h0
    public void h(f.InterfaceC0677f interfaceC0677f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0677f) == null) {
            this.u = interfaceC0677f;
        }
    }

    @Override // b.a.e.l.e.c
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
            this.k = (TbImageView) inflate.findViewById(R.id.pull_image);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
            this.l = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
            this.m = (ImageView) inflate.findViewById(R.id.text_mask);
            this.n = (TextView) inflate.findViewById(R.id.state_text);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
            }
            this.k.setAutoChangeStyle(false);
            this.n.setText(this.p);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.e.l.e.c
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            C(1.0f);
            this.l.setAlpha(1.0f);
            this.n.setText(this.p);
            f.e eVar = this.w;
            if (eVar != null) {
                eVar.a();
            }
            f.InterfaceC0677f interfaceC0677f = this.u;
            if (interfaceC0677f != null) {
                interfaceC0677f.a(getView(), z);
            }
            this.l.cancelAnimation();
        }
    }

    @Override // b.a.e.l.e.c
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.n.setText("");
            this.l.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // b.a.e.l.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.onPullPercentChange(f2, f3);
            float dimension = getView().getResources().getDimension(R.dimen.tbds120);
            float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
            float f4 = f2 * dimension2;
            if (f4 < dimension2) {
                float f5 = 0.09090909f;
                float f6 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
                if (f6 < 0.0f) {
                    f5 = 0.0f;
                } else if (f6 <= 0.09090909f) {
                    f5 = f6;
                }
                this.l.setProgress(f5);
                return;
            }
            this.l.setAlpha(1.0f - ((f4 - dimension2) / (e() - dimension2)));
        }
    }

    @Override // b.a.e.l.e.c
    public void p(boolean z) {
        f.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (gVar = this.t) == null) {
            return;
        }
        gVar.onListPullRefresh(z);
    }

    @Override // b.a.e.l.e.c
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            C(1.0f);
            this.n.setText(this.p);
            f.h hVar = this.v;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    @Override // b.a.e.l.e.c
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            C(1.0f);
            this.n.setText(this.q);
            this.l.setAlpha(1.0f);
            this.l.setMinAndMaxFrame(8, 58);
            this.l.loop(true);
            this.l.playAnimation();
        }
    }

    @Override // b.a.e.l.e.c
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n.setText(this.r);
        }
    }
}
