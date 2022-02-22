package c.a.u0.a0.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.d1.p0;
import c.a.t0.s.r.e2;
import c.a.u0.a0.d;
import c.a.u0.a0.e;
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
    public int f15219e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15220f;

    /* renamed from: g  reason: collision with root package name */
    public C0958b f15221g;

    /* renamed from: h  reason: collision with root package name */
    public View f15222h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f15223i;

    /* renamed from: j  reason: collision with root package name */
    public e f15224j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15225e;

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
            this.f15225e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15225e.f15223i == null || this.f15225e.f15223i.J() == null || StringUtils.isNull(this.f15225e.f15223i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f15225e.f15223i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15225e.f15220f.getPageActivity()).createNormalConfig(g2, z, this.f15225e.f15223i.J().isBigV())));
        }
    }

    /* renamed from: c.a.u0.a0.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0958b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15226b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15227c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15228d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f15229e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f15230f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15231g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f15232h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f15233i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f15234j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C0958b(View view) {
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
            this.f15226b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15227c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f15228d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f15229e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15230f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f15231g = (TextView) view.findViewById(R.id.tvUserName);
            this.f15233i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f15234j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f15232h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f15234j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f15232h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f15226b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15229e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f15234j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f15233i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.f15234j.setLayoutParams(this.n);
            this.f15229e.setLayoutParams(layoutParams);
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
        this.f15219e = 3;
        this.k = new a(this);
        this.f15220f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f15222h = inflate;
        this.f15221g = new C0958b(inflate);
        c().setOnClickListener(this);
        this.f15220f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15222h : (View) invokeV.objValue;
    }

    public void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            if (e2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f15223i = e2Var;
            this.f15221g.f15226b.setDrawerType(0);
            this.f15221g.f15226b.setBorderSurroundContent(true);
            this.f15221g.f15226b.setDrawBorder(true);
            this.f15221g.f15226b.startLoad(this.f15223i.p1().cover, 10, false);
            this.f15221g.f15228d.setText(this.f15220f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f15223i.p1().audience_count)));
            this.f15221g.f15230f.setData(this.f15223i);
            this.f15221g.f15230f.setIsRound(true);
            this.f15221g.f15230f.setBorderSurroundContent(true);
            this.f15221g.f15234j.setText(this.f15223i.getTitle());
            if (this.f15223i.J() != null) {
                String name_show = this.f15223i.J().getName_show();
                if (p0.d(name_show) > 10) {
                    name_show = p0.n(name_show, 10) + "...";
                }
                this.f15221g.f15231g.setText(name_show);
            }
            this.f15221g.l.setVisibility(0);
            this.f15221g.f15227c.setBackgroundResource(R.drawable.transparent_bg);
            this.f15221g.f15227c.setText(this.f15223i.p1().label_name);
            this.f15221g.f15227c.setVisibility(0);
            if (this.f15223i.J() != null && this.f15223i.J().getAlaUserData() != null && !m.isEmpty(this.f15223i.J().getAlaUserData().great_anchor_icon)) {
                this.f15221g.f15232h.setVisibility(0);
                this.f15221g.f15232h.startLoad(this.f15223i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f15221g.f15232h.setVisibility(8);
            }
            this.f15221g.f15231g.setOnClickListener(this.k);
            e(this.f15220f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f15219e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15221g.f15229e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f15221g.f15227c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f15221g.f15228d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15221g.f15231g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f15221g.f15234j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15221g.m, R.color.CAM_X0101);
        this.f15219e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f15224j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.K(this.f15220f.getPageActivity(), this.f15220f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            e2 e2Var = this.f15223i;
            if (e2Var == null || e2Var.p1() == null) {
                return;
            }
            e eVar = this.f15224j;
            if (eVar != null) {
                eVar.a(this.f15223i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f15223i.p1().live_id));
        }
    }
}
