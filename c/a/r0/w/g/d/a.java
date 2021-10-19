package c.a.r0.w.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.q.d2;
import c.a.r0.w.d;
import c.a.r0.w.e;
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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26183e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f26184f;

    /* renamed from: g  reason: collision with root package name */
    public b f26185g;

    /* renamed from: h  reason: collision with root package name */
    public View f26186h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f26187i;

    /* renamed from: j  reason: collision with root package name */
    public e f26188j;
    public View.OnClickListener k;

    /* renamed from: c.a.r0.w.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1218a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26189e;

        public View$OnClickListenerC1218a(a aVar) {
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
            this.f26189e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26189e.f26187i == null || this.f26189e.f26187i.J() == null || StringUtils.isNull(this.f26189e.f26187i.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f26189e.f26187i.J().getUserId(), 0L);
            boolean z = g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26189e.f26184f.getPageActivity()).createNormalConfig(g2, z, this.f26189e.f26187i.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26190a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26191b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26192c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26193d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26194e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26195f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26196g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f26197h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26198i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f26199j;
        public LinearLayout k;
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
            this.f26190a = view;
            this.f26191b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26192c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26193d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26194e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26195f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26196g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26198i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f26199j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f26197h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f26199j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f26197h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26191b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26194e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f26199j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f26198i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.f26199j.setLayoutParams(this.n);
            this.f26194e.setLayoutParams(layoutParams);
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
        this.f26183e = 3;
        this.k = new View$OnClickListenerC1218a(this);
        this.f26184f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f26186h = inflate;
        this.f26185g = new b(inflate);
        c().setOnClickListener(this);
        this.f26184f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26186h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f26187i = d2Var;
            this.f26185g.f26191b.setDrawerType(0);
            this.f26185g.f26191b.setBorderSurroundContent(true);
            this.f26185g.f26191b.setDrawBorder(true);
            this.f26185g.f26191b.startLoad(this.f26187i.l1().cover, 10, false);
            this.f26185g.f26193d.setText(this.f26184f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f26187i.l1().audience_count)));
            this.f26185g.f26195f.setData(this.f26187i);
            this.f26185g.f26195f.setIsRound(true);
            this.f26185g.f26195f.setBorderSurroundContent(true);
            this.f26185g.f26199j.setText(this.f26187i.getTitle());
            if (this.f26187i.J() != null) {
                String name_show = this.f26187i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f26185g.f26196g.setText(name_show);
            }
            this.f26185g.l.setVisibility(0);
            this.f26185g.f26192c.setBackgroundResource(R.drawable.transparent_bg);
            this.f26185g.f26192c.setText(this.f26187i.l1().label_name);
            this.f26185g.f26192c.setVisibility(0);
            if (this.f26187i.J() != null && this.f26187i.J().getAlaUserData() != null && !k.isEmpty(this.f26187i.J().getAlaUserData().great_anchor_icon)) {
                this.f26185g.f26197h.setVisibility(0);
                this.f26185g.f26197h.startLoad(this.f26187i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f26185g.f26197h.setVisibility(8);
            }
            this.f26185g.f26196g.setOnClickListener(this.k);
            e(this.f26184f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26183e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26185g.f26194e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26185g.f26192c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f26185g.f26193d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26185g.f26196g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f26185g.f26199j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26185g.m, R.color.CAM_X0101);
        this.f26183e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f26188j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f26184f.getPageActivity(), this.f26184f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f26187i;
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            e eVar = this.f26188j;
            if (eVar != null) {
                eVar.a(this.f26187i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f26187i.l1().live_id));
        }
    }
}
