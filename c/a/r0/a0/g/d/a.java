package c.a.r0.a0.g.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.c1.o0;
import c.a.q0.r.r.e2;
import c.a.r0.a0.d;
import c.a.r0.a0.e;
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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14618e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14619f;

    /* renamed from: g  reason: collision with root package name */
    public b f14620g;

    /* renamed from: h  reason: collision with root package name */
    public View f14621h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f14622i;

    /* renamed from: j  reason: collision with root package name */
    public e f14623j;
    public View.OnClickListener k;

    /* renamed from: c.a.r0.a0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0934a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14624e;

        public View$OnClickListenerC0934a(a aVar) {
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
            this.f14624e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14624e.f14622i == null || this.f14624e.f14622i.J() == null || StringUtils.isNull(this.f14624e.f14622i.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14624e.f14622i.J().getUserId(), 0L);
            boolean z = g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14624e.f14619f.getPageActivity()).createNormalConfig(g2, z, this.f14624e.f14622i.J().isBigV())));
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14625b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14626c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14627d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14628e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14629f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14630g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f14631h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f14632i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f14633j;
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
            this.f14625b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14626c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14627d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14628e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14629f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14630g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14632i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f14633j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f14631h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f14633j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f14631h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14625b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14628e.getLayoutParams();
            layoutParams.width = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f14633j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f14632i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.f14633j.setLayoutParams(this.n);
            this.f14628e.setLayoutParams(layoutParams);
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
        this.f14618e = 3;
        this.k = new View$OnClickListenerC0934a(this);
        this.f14619f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f14621h = inflate;
        this.f14620g = new b(inflate);
        c().setOnClickListener(this);
        this.f14619f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14621h : (View) invokeV.objValue;
    }

    public void d(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var) == null) {
            if (e2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f14622i = e2Var;
            this.f14620g.f14625b.setDrawerType(0);
            this.f14620g.f14625b.setBorderSurroundContent(true);
            this.f14620g.f14625b.setDrawBorder(true);
            this.f14620g.f14625b.startLoad(this.f14622i.p1().cover, 10, false);
            this.f14620g.f14627d.setText(this.f14619f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f14622i.p1().audience_count)));
            this.f14620g.f14629f.setData(this.f14622i);
            this.f14620g.f14629f.setIsRound(true);
            this.f14620g.f14629f.setBorderSurroundContent(true);
            this.f14620g.f14633j.setText(this.f14622i.getTitle());
            if (this.f14622i.J() != null) {
                String name_show = this.f14622i.J().getName_show();
                if (o0.d(name_show) > 10) {
                    name_show = o0.n(name_show, 10) + "...";
                }
                this.f14620g.f14630g.setText(name_show);
            }
            this.f14620g.l.setVisibility(0);
            this.f14620g.f14626c.setBackgroundResource(R.drawable.transparent_bg);
            this.f14620g.f14626c.setText(this.f14622i.p1().label_name);
            this.f14620g.f14626c.setVisibility(0);
            if (this.f14622i.J() != null && this.f14622i.J().getAlaUserData() != null && !m.isEmpty(this.f14622i.J().getAlaUserData().great_anchor_icon)) {
                this.f14620g.f14631h.setVisibility(0);
                this.f14620g.f14631h.startLoad(this.f14622i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f14620g.f14631h.setVisibility(8);
            }
            this.f14620g.f14630g.setOnClickListener(this.k);
            e(this.f14619f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f14618e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14620g.f14628e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14620g.f14626c, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f14620g.f14627d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14620g.f14630g, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f14620g.f14633j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14620g.m, (int) R.color.CAM_X0101);
        this.f14618e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f14623j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!l.z()) {
                n.K(this.f14619f.getPageActivity(), this.f14619f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            e2 e2Var = this.f14622i;
            if (e2Var == null || e2Var.p1() == null) {
                return;
            }
            e eVar = this.f14623j;
            if (eVar != null) {
                eVar.a(this.f14622i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f14622i.p1().live_id));
        }
    }
}
