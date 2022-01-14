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
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14789e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14790f;

    /* renamed from: g  reason: collision with root package name */
    public b f14791g;

    /* renamed from: h  reason: collision with root package name */
    public View f14792h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f14793i;

    /* renamed from: j  reason: collision with root package name */
    public e f14794j;
    public View.OnClickListener k;

    /* renamed from: c.a.t0.a0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0937a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14795e;

        public View$OnClickListenerC0937a(a aVar) {
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
            this.f14795e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14795e.f14793i == null || this.f14795e.f14793i.J() == null || StringUtils.isNull(this.f14795e.f14793i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14795e.f14793i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14795e.f14790f.getPageActivity()).createNormalConfig(g2, z, this.f14795e.f14793i.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14796b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14797c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14798d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14799e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14800f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14801g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f14802h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f14803i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f14804j;
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
            this.a = view;
            this.f14796b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14797c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14798d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14799e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14800f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14801g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14803i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f14804j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f14802h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f14804j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f14802h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14796b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14799e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f14804j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f14803i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.f14804j.setLayoutParams(this.n);
            this.f14799e.setLayoutParams(layoutParams);
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
        this.f14789e = 3;
        this.k = new View$OnClickListenerC0937a(this);
        this.f14790f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f14792h = inflate;
        this.f14791g = new b(inflate);
        c().setOnClickListener(this);
        this.f14790f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14792h : (View) invokeV.objValue;
    }

    public void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            if (e2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f14793i = e2Var;
            this.f14791g.f14796b.setDrawerType(0);
            this.f14791g.f14796b.setBorderSurroundContent(true);
            this.f14791g.f14796b.setDrawBorder(true);
            this.f14791g.f14796b.startLoad(this.f14793i.o1().cover, 10, false);
            this.f14791g.f14798d.setText(this.f14790f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f14793i.o1().audience_count)));
            this.f14791g.f14800f.setData(this.f14793i);
            this.f14791g.f14800f.setIsRound(true);
            this.f14791g.f14800f.setBorderSurroundContent(true);
            this.f14791g.f14804j.setText(this.f14793i.getTitle());
            if (this.f14793i.J() != null) {
                String name_show = this.f14793i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.m(name_show, 10) + "...";
                }
                this.f14791g.f14801g.setText(name_show);
            }
            this.f14791g.l.setVisibility(0);
            this.f14791g.f14797c.setBackgroundResource(R.drawable.transparent_bg);
            this.f14791g.f14797c.setText(this.f14793i.o1().label_name);
            this.f14791g.f14797c.setVisibility(0);
            if (this.f14793i.J() != null && this.f14793i.J().getAlaUserData() != null && !m.isEmpty(this.f14793i.J().getAlaUserData().great_anchor_icon)) {
                this.f14791g.f14802h.setVisibility(0);
                this.f14791g.f14802h.startLoad(this.f14793i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f14791g.f14802h.setVisibility(8);
            }
            this.f14791g.f14801g.setOnClickListener(this.k);
            e(this.f14790f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f14789e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14791g.f14799e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14791g.f14797c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f14791g.f14798d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14791g.f14801g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14791g.f14804j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14791g.m, R.color.CAM_X0101);
        this.f14789e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f14794j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.K(this.f14790f.getPageActivity(), this.f14790f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            e2 e2Var = this.f14793i;
            if (e2Var == null || e2Var.o1() == null) {
                return;
            }
            e eVar = this.f14794j;
            if (eVar != null) {
                eVar.a(this.f14793i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f14793i.o1().live_id));
        }
    }
}
