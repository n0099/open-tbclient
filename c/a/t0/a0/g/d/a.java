package c.a.t0.a0.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.e1.o0;
import c.a.s0.s.q.d2;
import c.a.t0.a0.d;
import c.a.t0.a0.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15159e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15160f;

    /* renamed from: g  reason: collision with root package name */
    public b f15161g;

    /* renamed from: h  reason: collision with root package name */
    public View f15162h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f15163i;

    /* renamed from: j  reason: collision with root package name */
    public e f15164j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f15165k;

    /* renamed from: c.a.t0.a0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0924a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15166e;

        public View$OnClickListenerC0924a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15166e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15166e.f15163i == null || this.f15166e.f15163i.J() == null || StringUtils.isNull(this.f15166e.f15163i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f15166e.f15163i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15166e.f15160f.getPageActivity()).createNormalConfig(g2, z, this.f15166e.f15163i.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15167b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15168c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15169d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f15170e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f15171f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15172g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f15173h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f15174i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f15175j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f15176k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f15167b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15168c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f15169d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f15170e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15171f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f15172g = (TextView) view.findViewById(R.id.tvUserName);
            this.f15174i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f15175j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f15176k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f15173h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f15175j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.f15176k.getLayoutParams();
            this.f15173h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f15167b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15170e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f15175j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f15174i.setVisibility(0);
            this.f15176k.setLayoutParams(this.o);
            this.f15175j.setLayoutParams(this.n);
            this.f15170e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15159e = 3;
        this.f15165k = new View$OnClickListenerC0924a(this);
        this.f15160f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f15162h = inflate;
        this.f15161g = new b(inflate);
        c().setOnClickListener(this);
        this.f15160f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15162h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f15163i = d2Var;
            this.f15161g.f15167b.setDrawerType(0);
            this.f15161g.f15167b.setBorderSurroundContent(true);
            this.f15161g.f15167b.setDrawBorder(true);
            this.f15161g.f15167b.startLoad(this.f15163i.o1().cover, 10, false);
            this.f15161g.f15169d.setText(this.f15160f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f15163i.o1().audience_count)));
            this.f15161g.f15171f.setData(this.f15163i);
            this.f15161g.f15171f.setIsRound(true);
            this.f15161g.f15171f.setBorderSurroundContent(true);
            this.f15161g.f15175j.setText(this.f15163i.getTitle());
            if (this.f15163i.J() != null) {
                String name_show = this.f15163i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.m(name_show, 10) + "...";
                }
                this.f15161g.f15172g.setText(name_show);
            }
            this.f15161g.l.setVisibility(0);
            this.f15161g.f15168c.setBackgroundResource(R.drawable.transparent_bg);
            this.f15161g.f15168c.setText(this.f15163i.o1().label_name);
            this.f15161g.f15168c.setVisibility(0);
            if (this.f15163i.J() != null && this.f15163i.J().getAlaUserData() != null && !m.isEmpty(this.f15163i.J().getAlaUserData().great_anchor_icon)) {
                this.f15161g.f15173h.setVisibility(0);
                this.f15161g.f15173h.startLoad(this.f15163i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f15161g.f15173h.setVisibility(8);
            }
            this.f15161g.f15172g.setOnClickListener(this.f15165k);
            e(this.f15160f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f15159e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15161g.f15170e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f15161g.f15168c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f15161g.f15169d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15161g.f15172g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15161g.f15175j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15161g.m, R.color.CAM_X0101);
        this.f15159e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f15164j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.J(this.f15160f.getPageActivity(), this.f15160f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f15163i;
            if (d2Var == null || d2Var.o1() == null) {
                return;
            }
            e eVar = this.f15164j;
            if (eVar != null) {
                eVar.a(this.f15163i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f15163i.o1().live_id));
        }
    }
}
