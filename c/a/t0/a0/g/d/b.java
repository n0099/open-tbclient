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
import c.a.s0.s.q.e2;
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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14805e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14806f;

    /* renamed from: g  reason: collision with root package name */
    public C0938b f14807g;

    /* renamed from: h  reason: collision with root package name */
    public View f14808h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f14809i;

    /* renamed from: j  reason: collision with root package name */
    public e f14810j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14811e;

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
            this.f14811e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14811e.f14809i == null || this.f14811e.f14809i.J() == null || StringUtils.isNull(this.f14811e.f14809i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14811e.f14809i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14811e.f14806f.getPageActivity()).createNormalConfig(g2, z, this.f14811e.f14809i.J().isBigV())));
        }
    }

    /* renamed from: c.a.t0.a0.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0938b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14812b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14813c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14814d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14815e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14816f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14817g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f14818h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f14819i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f14820j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C0938b(View view) {
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
            this.f14812b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14813c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14814d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14815e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14816f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14817g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14819i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f14820j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f14818h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f14820j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f14818h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14812b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14815e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f14820j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f14819i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.f14820j.setLayoutParams(this.n);
            this.f14815e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
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
        this.f14805e = 3;
        this.k = new a(this);
        this.f14806f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f14808h = inflate;
        this.f14807g = new C0938b(inflate);
        c().setOnClickListener(this);
        this.f14806f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14808h : (View) invokeV.objValue;
    }

    public void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            if (e2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f14809i = e2Var;
            this.f14807g.f14812b.setDrawerType(0);
            this.f14807g.f14812b.setBorderSurroundContent(true);
            this.f14807g.f14812b.setDrawBorder(true);
            this.f14807g.f14812b.startLoad(this.f14809i.o1().cover, 10, false);
            this.f14807g.f14814d.setText(this.f14806f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f14809i.o1().audience_count)));
            this.f14807g.f14816f.setData(this.f14809i);
            this.f14807g.f14816f.setIsRound(true);
            this.f14807g.f14816f.setBorderSurroundContent(true);
            this.f14807g.f14820j.setText(this.f14809i.getTitle());
            if (this.f14809i.J() != null) {
                String name_show = this.f14809i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.m(name_show, 10) + "...";
                }
                this.f14807g.f14817g.setText(name_show);
            }
            this.f14807g.l.setVisibility(0);
            this.f14807g.f14813c.setBackgroundResource(R.drawable.transparent_bg);
            this.f14807g.f14813c.setText(this.f14809i.o1().label_name);
            this.f14807g.f14813c.setVisibility(0);
            if (this.f14809i.J() != null && this.f14809i.J().getAlaUserData() != null && !m.isEmpty(this.f14809i.J().getAlaUserData().great_anchor_icon)) {
                this.f14807g.f14818h.setVisibility(0);
                this.f14807g.f14818h.startLoad(this.f14809i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f14807g.f14818h.setVisibility(8);
            }
            this.f14807g.f14817g.setOnClickListener(this.k);
            e(this.f14806f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f14805e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14807g.f14815e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14807g.f14813c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f14807g.f14814d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14807g.f14817g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14807g.f14820j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14807g.m, R.color.CAM_X0101);
        this.f14805e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f14810j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.K(this.f14806f.getPageActivity(), this.f14806f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            e2 e2Var = this.f14809i;
            if (e2Var == null || e2Var.o1() == null) {
                return;
            }
            e eVar = this.f14810j;
            if (eVar != null) {
                eVar.a(this.f14809i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f14809i.o1().live_id));
        }
    }
}
