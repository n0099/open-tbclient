package c.a.s0.a0.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.d1.o0;
import c.a.r0.s.r.d2;
import c.a.s0.a0.d;
import c.a.s0.a0.e;
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
    public int f14661e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14662f;

    /* renamed from: g  reason: collision with root package name */
    public b f14663g;

    /* renamed from: h  reason: collision with root package name */
    public View f14664h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f14665i;

    /* renamed from: j  reason: collision with root package name */
    public e f14666j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f14667k;

    /* renamed from: c.a.s0.a0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0899a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14668e;

        public View$OnClickListenerC0899a(a aVar) {
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
            this.f14668e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14668e.f14665i == null || this.f14668e.f14665i.J() == null || StringUtils.isNull(this.f14668e.f14665i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14668e.f14665i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14668e.f14662f.getPageActivity()).createNormalConfig(g2, z, this.f14668e.f14665i.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14669b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14670c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14671d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14672e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14673f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14674g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f14675h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f14676i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f14677j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f14678k;
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
            this.f14669b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14670c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14671d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14672e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14673f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14674g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14676i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f14677j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14678k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f14675h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f14677j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.f14678k.getLayoutParams();
            this.f14675h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14669b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14672e.getLayoutParams();
            layoutParams.width = (m.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f14677j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f14676i.setVisibility(0);
            this.f14678k.setLayoutParams(this.o);
            this.f14677j.setLayoutParams(this.n);
            this.f14672e.setLayoutParams(layoutParams);
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
        this.f14661e = 3;
        this.f14667k = new View$OnClickListenerC0899a(this);
        this.f14662f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f14664h = inflate;
        this.f14663g = new b(inflate);
        c().setOnClickListener(this);
        this.f14662f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14664h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f14665i = d2Var;
            this.f14663g.f14669b.setDrawerType(0);
            this.f14663g.f14669b.setBorderSurroundContent(true);
            this.f14663g.f14669b.setDrawBorder(true);
            this.f14663g.f14669b.startLoad(this.f14665i.o1().cover, 10, false);
            this.f14663g.f14671d.setText(this.f14662f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f14665i.o1().audience_count)));
            this.f14663g.f14673f.setData(this.f14665i);
            this.f14663g.f14673f.setIsRound(true);
            this.f14663g.f14673f.setBorderSurroundContent(true);
            this.f14663g.f14677j.setText(this.f14665i.getTitle());
            if (this.f14665i.J() != null) {
                String name_show = this.f14665i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.m(name_show, 10) + "...";
                }
                this.f14663g.f14674g.setText(name_show);
            }
            this.f14663g.l.setVisibility(0);
            this.f14663g.f14670c.setBackgroundResource(R.drawable.transparent_bg);
            this.f14663g.f14670c.setText(this.f14665i.o1().label_name);
            this.f14663g.f14670c.setVisibility(0);
            if (this.f14665i.J() != null && this.f14665i.J().getAlaUserData() != null && !l.isEmpty(this.f14665i.J().getAlaUserData().great_anchor_icon)) {
                this.f14663g.f14675h.setVisibility(0);
                this.f14663g.f14675h.startLoad(this.f14665i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f14663g.f14675h.setVisibility(8);
            }
            this.f14663g.f14674g.setOnClickListener(this.f14667k);
            e(this.f14662f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f14661e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14663g.f14672e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14663g.f14670c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f14663g.f14671d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14663g.f14674g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14663g.f14677j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14663g.m, R.color.CAM_X0101);
        this.f14661e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f14666j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!k.z()) {
                m.J(this.f14662f.getPageActivity(), this.f14662f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f14665i;
            if (d2Var == null || d2Var.o1() == null) {
                return;
            }
            e eVar = this.f14666j;
            if (eVar != null) {
                eVar.a(this.f14665i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f14665i.o1().live_id));
        }
    }
}
