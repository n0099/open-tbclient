package c.a.p0.q1.i.i;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.d.o.e.c;
import c.a.o0.r.l0.f;
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
/* loaded from: classes2.dex */
public class b extends c implements BigdaySwipeRefreshLayout.k, PersonalizePageView.m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17440g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f17441h;
    public ImageView i;
    public TextView j;
    public c.a.o0.r.o.a k;
    public String l;
    public String m;
    public String n;
    public String o;
    public f.g p;
    public f.InterfaceC0828f q;
    public f.h r;
    public f.e s;

    /* loaded from: classes2.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
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
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || this.a.f17440g.getBdImage() != null || this.a.k == null || m.isEmpty(this.a.k.a)) {
                return;
            }
            this.a.f17440g.J(this.a.k.a, 41, false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        if (context != null) {
            this.l = context.getText(R.string.obfuscated_res_0x7f0f00d6).toString();
            this.m = context.getText(R.string.obfuscated_res_0x7f0f02ff).toString();
            this.n = context.getText(R.string.obfuscated_res_0x7f0f0301).toString();
            this.o = context.getText(R.string.obfuscated_res_0x7f0f0300).toString();
        }
    }

    public c.a.o0.r.o.a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (c.a.o0.r.o.a) invokeV.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void H(float f2) {
        c.a.o0.r.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.j.setAlpha(f2);
            this.i.setAlpha(f2);
            if (this.i.getBackground() != null || (aVar = this.k) == null) {
                return;
            }
            if (aVar.f10760c == 1) {
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08030e);
            } else {
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08030f);
            }
        }
    }

    public void I(c.a.o0.r.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar.a()) {
                this.k = aVar;
            }
            if (aVar.f10760c == 1) {
                this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0101));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08030e);
                this.f17441h.setAnimation(R.raw.obfuscated_res_0x7f110033);
            } else {
                this.j.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
                this.i.setBackgroundResource(R.drawable.obfuscated_res_0x7f08030f);
                this.f17441h.setAnimation(R.raw.obfuscated_res_0x7f110032);
            }
            this.f17441h.setFrame(0);
            this.f17440g.J(aVar.a, 41, false);
            this.f17440g.setOnDrawListener(new a(this));
        }
    }

    @Override // c.a.d.o.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.c(f2, f3);
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
                this.f17441h.setProgress(f5);
                return;
            }
            this.f17441h.setAlpha(1.0f - ((f4 - dimension2) / (j() - dimension2)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.m0
    public void f(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.p = gVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.m0
    public void g(f.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            this.r = hVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.setText(this.o);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void i() {
        c.a.o0.r.o.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (aVar = this.k) != null && aVar.a()) {
            MessageManager messageManager = MessageManager.getInstance();
            Context context = getContext();
            c.a.o0.r.o.a aVar2 = this.k;
            messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(context, aVar2.a, aVar2.f10759b, aVar2.f10761d)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) (n.i(getContext()) * 0.3d) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.m0
    public void k(f.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.s = eVar;
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
            this.j.animate().alpha(0.0f).setDuration(200L).start();
            this.i.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.m0
    public void m(f.InterfaceC0828f interfaceC0828f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, interfaceC0828f) == null) {
            this.q = interfaceC0828f;
        }
    }

    @Override // c.a.d.o.e.c
    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d015a, (ViewGroup) null, false);
            this.f17440g = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091963);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09036d);
            this.f17441h = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f09036f);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091f3f);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091da3);
            if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f07027e));
            }
            this.f17440g.setAutoChangeStyle(false);
            this.j.setText(this.l);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.c
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            H(1.0f);
            this.f17441h.setAlpha(1.0f);
            this.j.setText(this.l);
            f.e eVar = this.s;
            if (eVar != null) {
                eVar.a();
            }
            f.InterfaceC0828f interfaceC0828f = this.q;
            if (interfaceC0828f != null) {
                interfaceC0828f.a(getView(), z);
            }
            this.f17441h.cancelAnimation();
        }
    }

    @Override // c.a.d.o.e.c
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.j.setText("");
            this.f17441h.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // c.a.d.o.e.c
    public void u(boolean z) {
        f.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.onListPullRefresh(z);
    }

    @Override // c.a.d.o.e.c
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            H(1.0f);
            this.j.setText(this.l);
            f.h hVar = this.r;
            if (hVar != null) {
                hVar.a(z);
            }
        }
    }

    @Override // c.a.d.o.e.c
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            H(1.0f);
            this.j.setText(this.m);
            this.f17441h.setAlpha(1.0f);
            this.f17441h.setMinAndMaxFrame(8, 58);
            this.f17441h.loop(true);
            this.f17441h.playAnimation();
        }
    }

    @Override // c.a.d.o.e.c
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.j.setText(this.n);
        }
    }
}
