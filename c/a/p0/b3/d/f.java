package c.a.p0.b3.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends c.a.p0.b3.d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f12643b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f12644c;

    /* renamed from: d  reason: collision with root package name */
    public View f12645d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.f0.h f12646e;

    /* renamed from: f  reason: collision with root package name */
    public e f12647f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f12648g;

    /* renamed from: h  reason: collision with root package name */
    public NoNetworkView f12649h;
    public PluginErrorTipView i;
    public ImageView j;
    public c.a.o0.f0.g k;
    public int l;
    public LinearLayout m;
    public FrameLayout n;
    public NoNetworkView o;
    public RelativeLayout p;
    public c.a.p0.b3.k.k q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.a.f12643b.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.a.f12643b.getPageActivity());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A()) {
                this.a.o();
                this.a.B(true);
                if (this.a.f12647f != null) {
                    this.a.f12647f.a(view);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.f12643b.getPageActivity(), null, c.a.p0.w2.c.a(), true)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.b3.f.b a;

        /* renamed from: b  reason: collision with root package name */
        public UserData f12650b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.p0.q4.f f12651c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c.a.p0.b3.f.b();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UserData userData = this.f12650b;
                if (userData == null || !userData.isBaijiahaoUser()) {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                    c.a.p0.b3.f.b bVar = this.a;
                    bVar.a = 10;
                    bVar.f20640b = new Bundle();
                    this.a.f20640b.putSerializable(UserData.TYPE_USER, this.f12650b);
                    c.a.p0.q4.f fVar = this.f12651c;
                    if (fVar != null) {
                        fVar.a(view, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new d();
        this.l = 3;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f12643b = tbPageContext;
        this.f12645d = view;
        this.f12649h = (NoNetworkView) view.findViewById(R.id.obfuscated_res_0x7f091796);
        this.i = (PluginErrorTipView) this.f12645d.findViewById(R.id.obfuscated_res_0x7f091799);
        this.m = (LinearLayout) this.f12645d.findViewById(R.id.obfuscated_res_0x7f091776);
        c.a.p0.b3.k.k kVar = new c.a.p0.b3.k.k(this.f12643b, this.f12645d.findViewById(R.id.obfuscated_res_0x7f091778), this.f12645d.findViewById(R.id.obfuscated_res_0x7f09177a), z);
        this.q = kVar;
        kVar.k(PersonStatus.GUEST_DEFAULT);
        this.n = (FrameLayout) this.f12645d.findViewById(R.id.obfuscated_res_0x7f091777);
        this.o = (NoNetworkView) this.f12645d.findViewById(R.id.obfuscated_res_0x7f091779);
        this.p = (RelativeLayout) this.f12645d.findViewById(R.id.obfuscated_res_0x7f091797);
        PbListView pbListView = new PbListView(this.f12643b.getPageActivity());
        this.f12648g = pbListView;
        pbListView.b();
        this.f12648g.F(SkinManager.getColor(R.color.CAM_X0109));
        this.f12648g.B(R.color.CAM_X0110);
        this.f12648g.p(R.color.CAM_X0201);
        this.f12648g.t(n.f(this.f12643b.getPageActivity(), R.dimen.obfuscated_res_0x7f070240));
        this.f12648g.r(n.f(this.f12643b.getPageActivity(), R.dimen.obfuscated_res_0x7f070234));
        this.f12648g.A();
        this.f12648g.x(R.color.CAM_X0205);
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n == null) {
            return;
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.m.setVisibility(0);
        int dimensionPixelSize = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070271);
        int dimensionPixelSize2 = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702c5);
        int dimensionPixelSize3 = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a3);
        int dimensionPixelSize4 = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
        int dimensionPixelSize5 = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        NoDataView a2 = NoDataViewFactory.a(this.f12643b.getPageActivity(), this.n, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.obfuscated_res_0x7f0f1482, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.f12643b.getString(R.string.obfuscated_res_0x7f0f1481), new a(this)), dimensionPixelSize5));
        this.f12644c = a2;
        a2.setVisibility(0);
        this.f12644c.f(this.f12643b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            y();
        }
    }

    public void k(c.a.p0.b3.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.o0.f0.g gVar = this.k;
            if (gVar != null) {
                gVar.dettachView(this.f12645d);
                this.k = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void o() {
        c.a.o0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.f12646e) == null) {
            return;
        }
        hVar.dettachView(this.n);
        this.f12646e = null;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.o0.f0.h hVar = this.f12646e;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || this.l == i) {
            return;
        }
        NoDataView noDataView = this.f12644c;
        if (noDataView != null) {
            noDataView.f(this.f12643b, i);
        }
        NoNetworkView noNetworkView = this.o;
        if (noNetworkView != null) {
            noNetworkView.c(this.f12643b, i);
        }
        c.a.p0.b3.k.k kVar = this.q;
        if (kVar != null) {
            kVar.g(i);
        }
        SkinManager.setBackgroundResource(this.f12645d, R.color.CAM_X0201);
        c.a.o0.f0.h hVar = this.f12646e;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        this.l = i;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.p.setVisibility(i);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f12647f = eVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p.setVisibility(8);
            int dimensionPixelSize = this.f12643b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a);
            if (this.f12644c == null) {
                this.f12644c = NoDataViewFactory.a(this.f12643b.getPageActivity(), this.f12645d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.f12643b.getString(R.string.obfuscated_res_0x7f0f14af)), null);
            }
            SkinManager.setViewTextColor(this.f12644c.getSuTextView(), (int) R.color.CAM_X0106);
            this.f12644c.f(this.f12643b, TbadkCoreApplication.getInst().getSkinType());
            this.f12644c.setVisibility(0);
        }
    }

    public void v(List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.k == null) {
                if (i < 0) {
                    this.k = new c.a.o0.f0.g(this.f12643b.getContext());
                } else {
                    this.k = new c.a.o0.f0.g(this.f12643b.getContext(), i);
                }
                this.k.onChangeSkinType();
            }
            this.k.attachView(this.f12645d, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) || q()) {
            return;
        }
        this.m.setVisibility(0);
        if (this.f12646e == null) {
            this.f12646e = new c.a.o0.f0.h(this.f12643b.getPageActivity(), new b(this));
        }
        this.f12646e.h(R.drawable.new_pic_emotion_08);
        this.f12646e.attachView(this.n, z);
        this.f12646e.p();
        this.f12646e.onChangeSkinType();
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.j == null) {
                    ImageView imageView = new ImageView(this.f12643b.getPageActivity());
                    this.j = imageView;
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080874);
                    this.j.setOnClickListener(new c(this));
                }
                if (this.j.getParent() != null) {
                    ((ViewGroup) this.j.getParent()).removeView(this.j);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = n.f(this.f12643b.getPageActivity(), R.dimen.obfuscated_res_0x7f0702cd);
                layoutParams.rightMargin = n.f(this.f12643b.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
                View view = this.f12645d;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).addView(this.j, layoutParams);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.j;
            if (imageView2 == null || imageView2.getParent() == null) {
                return;
            }
            ViewParent parent = this.j.getParent();
            View view2 = this.f12645d;
            if (parent == view2) {
                ((RelativeLayout) view2).removeView(this.j);
            }
        }
    }

    public void z(boolean z, List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, list) == null) {
        }
    }
}
