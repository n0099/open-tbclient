package b.a.r0.w.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.j;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
import b.a.q0.s.q.d2;
import b.a.r0.w.d;
import b.a.r0.w.e;
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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26543e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f26544f;

    /* renamed from: g  reason: collision with root package name */
    public b f26545g;

    /* renamed from: h  reason: collision with root package name */
    public View f26546h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f26547i;
    public e j;
    public View.OnClickListener k;

    /* renamed from: b.a.r0.w.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1287a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26548e;

        public View$OnClickListenerC1287a(a aVar) {
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
            this.f26548e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26548e.f26547i == null || this.f26548e.f26547i.J() == null || StringUtils.isNull(this.f26548e.f26547i.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.f.m.b.g(this.f26548e.f26547i.J().getUserId(), 0L);
            boolean z = g2 == b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26548e.f26544f.getPageActivity()).createNormalConfig(g2, z, this.f26548e.f26547i.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26549a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26550b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26551c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26552d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26553e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26554f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26555g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f26556h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26557i;
        public TextView j;
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
            this.f26549a = view;
            this.f26550b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26551c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26552d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26553e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26554f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26555g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26557i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f26556h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f26556h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26550b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26553e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f26557i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f26553e.setLayoutParams(layoutParams);
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
        this.f26543e = 3;
        this.k = new View$OnClickListenerC1287a(this);
        this.f26544f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f26546h = inflate;
        this.f26545g = new b(inflate);
        c().setOnClickListener(this);
        this.f26544f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26546h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f26547i = d2Var;
            this.f26545g.f26550b.setDrawerType(0);
            this.f26545g.f26550b.setBorderSurroundContent(true);
            this.f26545g.f26550b.setDrawBorder(true);
            this.f26545g.f26550b.startLoad(this.f26547i.m1().cover, 10, false);
            this.f26545g.f26552d.setText(this.f26544f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f26547i.m1().audience_count)));
            this.f26545g.f26554f.setData(this.f26547i);
            this.f26545g.f26554f.setIsRound(true);
            this.f26545g.f26554f.setBorderSurroundContent(true);
            this.f26545g.j.setText(this.f26547i.getTitle());
            if (this.f26547i.J() != null) {
                String name_show = this.f26547i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f26545g.f26555g.setText(name_show);
            }
            this.f26545g.l.setVisibility(0);
            this.f26545g.f26551c.setBackgroundResource(R.drawable.transparent_bg);
            this.f26545g.f26551c.setText(this.f26547i.m1().label_name);
            this.f26545g.f26551c.setVisibility(0);
            if (this.f26547i.J() != null && this.f26547i.J().getAlaUserData() != null && !k.isEmpty(this.f26547i.J().getAlaUserData().great_anchor_icon)) {
                this.f26545g.f26556h.setVisibility(0);
                this.f26545g.f26556h.startLoad(this.f26547i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f26545g.f26556h.setVisibility(8);
            }
            this.f26545g.f26555g.setOnClickListener(this.k);
            e(this.f26544f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26543e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26545g.f26553e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26545g.f26551c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f26545g.f26552d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26545g.f26555g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f26545g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26545g.m, R.color.CAM_X0101);
        this.f26543e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f26544f.getPageActivity(), this.f26544f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f26547i;
            if (d2Var == null || d2Var.m1() == null) {
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.a(this.f26547i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f26547i.m1().live_id));
        }
    }
}
