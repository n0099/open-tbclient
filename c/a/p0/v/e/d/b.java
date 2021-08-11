package c.a.p0.v.e.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.b1.l0;
import c.a.o0.s.q.c2;
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
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f25191e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25192f;

    /* renamed from: g  reason: collision with root package name */
    public C1177b f25193g;

    /* renamed from: h  reason: collision with root package name */
    public View f25194h;

    /* renamed from: i  reason: collision with root package name */
    public c2 f25195i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.v.c f25196j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25197e;

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
            this.f25197e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25197e.f25195i == null || this.f25197e.f25195i.J() == null || StringUtils.isNull(this.f25197e.f25195i.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25197e.f25195i.J().getUserId(), 0L);
            boolean z = f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            c.a.p0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25197e.f25192f.getPageActivity()).createNormalConfig(f2, z, this.f25197e.f25195i.J().isBigV())));
        }
    }

    /* renamed from: c.a.p0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1177b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25198a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25199b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25200c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25201d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25202e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25203f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25204g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25205h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25206i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f25207j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1177b(View view) {
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
            this.f25198a = view;
            this.f25199b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25200c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25201d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25202e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25203f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25204g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25206i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f25207j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25205h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f25207j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25205h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25199b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25202e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f25207j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f25206i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.f25207j.setLayoutParams(this.n);
            this.f25202e.setLayoutParams(layoutParams);
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
        this.f25191e = 3;
        this.k = new a(this);
        this.f25192f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25194h = inflate;
        this.f25193g = new C1177b(inflate);
        c().setOnClickListener(this);
        this.f25192f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25194h : (View) invokeV.objValue;
    }

    public void d(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            if (c2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25195i = c2Var;
            this.f25193g.f25199b.setDrawerType(0);
            this.f25193g.f25199b.setBorderSurroundContent(true);
            this.f25193g.f25199b.setDrawBorder(true);
            this.f25193g.f25199b.startLoad(this.f25195i.j1().cover, 10, false);
            this.f25193g.f25201d.setText(this.f25192f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25195i.j1().audience_count)));
            this.f25193g.f25203f.setData(this.f25195i);
            this.f25193g.f25203f.setIsRound(true);
            this.f25193g.f25203f.setBorderSurroundContent(true);
            this.f25193g.f25207j.setText(this.f25195i.getTitle());
            if (this.f25195i.J() != null) {
                String name_show = this.f25195i.J().getName_show();
                if (l0.d(name_show) > 10) {
                    name_show = l0.m(name_show, 10) + "...";
                }
                this.f25193g.f25204g.setText(name_show);
            }
            this.f25193g.l.setVisibility(0);
            this.f25193g.f25200c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25193g.f25200c.setText(this.f25195i.j1().label_name);
            this.f25193g.f25200c.setVisibility(0);
            if (this.f25195i.J() != null && this.f25195i.J().getAlaUserData() != null && !k.isEmpty(this.f25195i.J().getAlaUserData().great_anchor_icon)) {
                this.f25193g.f25205h.setVisibility(0);
                this.f25193g.f25205h.startLoad(this.f25195i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25193g.f25205h.setVisibility(8);
            }
            this.f25193g.f25204g.setOnClickListener(this.k);
            e(this.f25192f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25191e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25193g.f25202e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25193g.f25200c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25193g.f25201d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25193g.f25204g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25193g.f25207j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25193g.m, R.color.CAM_X0101);
        this.f25191e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(c.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25196j = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f25192f.getPageActivity(), this.f25192f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            c2 c2Var = this.f25195i;
            if (c2Var == null || c2Var.j1() == null) {
                return;
            }
            c.a.p0.v.c cVar = this.f25196j;
            if (cVar != null) {
                cVar.a(this.f25195i);
            }
            c.a.p0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25195i.j1().live_id));
        }
    }
}
