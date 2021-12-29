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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15177e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15178f;

    /* renamed from: g  reason: collision with root package name */
    public C0925b f15179g;

    /* renamed from: h  reason: collision with root package name */
    public View f15180h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f15181i;

    /* renamed from: j  reason: collision with root package name */
    public e f15182j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f15183k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15184e;

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
            this.f15184e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15184e.f15181i == null || this.f15184e.f15181i.J() == null || StringUtils.isNull(this.f15184e.f15181i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f15184e.f15181i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15184e.f15178f.getPageActivity()).createNormalConfig(g2, z, this.f15184e.f15181i.J().isBigV())));
        }
    }

    /* renamed from: c.a.t0.a0.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0925b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15185b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15186c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15187d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f15188e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f15189f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15190g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f15191h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f15192i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f15193j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f15194k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C0925b(View view) {
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
            this.f15185b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15186c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f15187d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f15188e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15189f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f15190g = (TextView) view.findViewById(R.id.tvUserName);
            this.f15192i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f15193j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f15194k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f15191h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f15193j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.f15194k.getLayoutParams();
            this.f15191h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f15185b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15188e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f15193j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f15192i.setVisibility(8);
            this.f15194k.setLayoutParams(this.o);
            this.f15193j.setLayoutParams(this.n);
            this.f15188e.setLayoutParams(layoutParams);
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
        this.f15177e = 3;
        this.f15183k = new a(this);
        this.f15178f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f15180h = inflate;
        this.f15179g = new C0925b(inflate);
        c().setOnClickListener(this);
        this.f15178f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15180h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f15181i = d2Var;
            this.f15179g.f15185b.setDrawerType(0);
            this.f15179g.f15185b.setBorderSurroundContent(true);
            this.f15179g.f15185b.setDrawBorder(true);
            this.f15179g.f15185b.startLoad(this.f15181i.o1().cover, 10, false);
            this.f15179g.f15187d.setText(this.f15178f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f15181i.o1().audience_count)));
            this.f15179g.f15189f.setData(this.f15181i);
            this.f15179g.f15189f.setIsRound(true);
            this.f15179g.f15189f.setBorderSurroundContent(true);
            this.f15179g.f15193j.setText(this.f15181i.getTitle());
            if (this.f15181i.J() != null) {
                String name_show = this.f15181i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.m(name_show, 10) + "...";
                }
                this.f15179g.f15190g.setText(name_show);
            }
            this.f15179g.l.setVisibility(0);
            this.f15179g.f15186c.setBackgroundResource(R.drawable.transparent_bg);
            this.f15179g.f15186c.setText(this.f15181i.o1().label_name);
            this.f15179g.f15186c.setVisibility(0);
            if (this.f15181i.J() != null && this.f15181i.J().getAlaUserData() != null && !m.isEmpty(this.f15181i.J().getAlaUserData().great_anchor_icon)) {
                this.f15179g.f15191h.setVisibility(0);
                this.f15179g.f15191h.startLoad(this.f15181i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f15179g.f15191h.setVisibility(8);
            }
            this.f15179g.f15190g.setOnClickListener(this.f15183k);
            e(this.f15178f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f15177e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15179g.f15188e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f15179g.f15186c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f15179g.f15187d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15179g.f15190g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15179g.f15193j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15179g.m, R.color.CAM_X0101);
        this.f15177e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f15182j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.J(this.f15178f.getPageActivity(), this.f15178f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f15181i;
            if (d2Var == null || d2Var.o1() == null) {
                return;
            }
            e eVar = this.f15182j;
            if (eVar != null) {
                eVar.a(this.f15181i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f15181i.o1().live_id));
        }
    }
}
