package b.a.r0.w.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
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
    public int f25026e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25027f;

    /* renamed from: g  reason: collision with root package name */
    public b f25028g;

    /* renamed from: h  reason: collision with root package name */
    public View f25029h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f25030i;
    public e j;
    public View.OnClickListener k;

    /* renamed from: b.a.r0.w.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1219a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25031e;

        public View$OnClickListenerC1219a(a aVar) {
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
            this.f25031e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25031e.f25030i == null || this.f25031e.f25030i.J() == null || StringUtils.isNull(this.f25031e.f25030i.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.e.m.b.g(this.f25031e.f25030i.J().getUserId(), 0L);
            boolean z = g2 == b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25031e.f25027f.getPageActivity()).createNormalConfig(g2, z, this.f25031e.f25030i.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25032a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25033b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25034c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25035d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25036e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25037f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25038g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25039h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25040i;
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
            this.f25032a = view;
            this.f25033b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25034c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25035d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25036e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25037f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25038g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25040i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25039h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25039h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25033b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25036e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f25040i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f25036e.setLayoutParams(layoutParams);
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
        this.f25026e = 3;
        this.k = new View$OnClickListenerC1219a(this);
        this.f25027f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25029h = inflate;
        this.f25028g = new b(inflate);
        c().setOnClickListener(this);
        this.f25027f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25029h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25030i = d2Var;
            this.f25028g.f25033b.setDrawerType(0);
            this.f25028g.f25033b.setBorderSurroundContent(true);
            this.f25028g.f25033b.setDrawBorder(true);
            this.f25028g.f25033b.startLoad(this.f25030i.l1().cover, 10, false);
            this.f25028g.f25035d.setText(this.f25027f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25030i.l1().audience_count)));
            this.f25028g.f25037f.setData(this.f25030i);
            this.f25028g.f25037f.setIsRound(true);
            this.f25028g.f25037f.setBorderSurroundContent(true);
            this.f25028g.j.setText(this.f25030i.getTitle());
            if (this.f25030i.J() != null) {
                String name_show = this.f25030i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f25028g.f25038g.setText(name_show);
            }
            this.f25028g.l.setVisibility(0);
            this.f25028g.f25034c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25028g.f25034c.setText(this.f25030i.l1().label_name);
            this.f25028g.f25034c.setVisibility(0);
            if (this.f25030i.J() != null && this.f25030i.J().getAlaUserData() != null && !k.isEmpty(this.f25030i.J().getAlaUserData().great_anchor_icon)) {
                this.f25028g.f25039h.setVisibility(0);
                this.f25028g.f25039h.startLoad(this.f25030i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25028g.f25039h.setVisibility(8);
            }
            this.f25028g.f25038g.setOnClickListener(this.k);
            e(this.f25027f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25026e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25028g.f25036e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25028g.f25034c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25028g.f25035d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25028g.f25038g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25028g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25028g.m, R.color.CAM_X0101);
        this.f25026e = i2;
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
                l.J(this.f25027f.getPageActivity(), this.f25027f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f25030i;
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.a(this.f25030i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25030i.l1().live_id));
        }
    }
}
