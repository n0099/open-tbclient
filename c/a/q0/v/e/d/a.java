package c.a.q0.v.e.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.b1.l0;
import c.a.p0.s.q.c2;
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
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f25507e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25508f;

    /* renamed from: g  reason: collision with root package name */
    public b f25509g;

    /* renamed from: h  reason: collision with root package name */
    public View f25510h;

    /* renamed from: i  reason: collision with root package name */
    public c2 f25511i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.v.c f25512j;
    public View.OnClickListener k;

    /* renamed from: c.a.q0.v.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1187a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25513e;

        public View$OnClickListenerC1187a(a aVar) {
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
            this.f25513e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25513e.f25511i == null || this.f25513e.f25511i.J() == null || StringUtils.isNull(this.f25513e.f25511i.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25513e.f25511i.J().getUserId(), 0L);
            boolean z = f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            c.a.q0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25513e.f25508f.getPageActivity()).createNormalConfig(f2, z, this.f25513e.f25511i.J().isBigV())));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25514a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25515b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25516c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25517d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25518e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25519f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25520g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25521h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25522i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f25523j;
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
            this.f25514a = view;
            this.f25515b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25516c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25517d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25518e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25519f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25520g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25522i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f25523j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25521h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f25523j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25521h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25515b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25518e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f25523j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f25522i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.f25523j.setLayoutParams(this.n);
            this.f25518e.setLayoutParams(layoutParams);
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
        this.f25507e = 3;
        this.k = new View$OnClickListenerC1187a(this);
        this.f25508f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25510h = inflate;
        this.f25509g = new b(inflate);
        c().setOnClickListener(this);
        this.f25508f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25510h : (View) invokeV.objValue;
    }

    public void d(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            if (c2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25511i = c2Var;
            this.f25509g.f25515b.setDrawerType(0);
            this.f25509g.f25515b.setBorderSurroundContent(true);
            this.f25509g.f25515b.setDrawBorder(true);
            this.f25509g.f25515b.startLoad(this.f25511i.j1().cover, 10, false);
            this.f25509g.f25517d.setText(this.f25508f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25511i.j1().audience_count)));
            this.f25509g.f25519f.setData(this.f25511i);
            this.f25509g.f25519f.setIsRound(true);
            this.f25509g.f25519f.setBorderSurroundContent(true);
            this.f25509g.f25523j.setText(this.f25511i.getTitle());
            if (this.f25511i.J() != null) {
                String name_show = this.f25511i.J().getName_show();
                if (l0.d(name_show) > 10) {
                    name_show = l0.m(name_show, 10) + "...";
                }
                this.f25509g.f25520g.setText(name_show);
            }
            this.f25509g.l.setVisibility(0);
            this.f25509g.f25516c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25509g.f25516c.setText(this.f25511i.j1().label_name);
            this.f25509g.f25516c.setVisibility(0);
            if (this.f25511i.J() != null && this.f25511i.J().getAlaUserData() != null && !k.isEmpty(this.f25511i.J().getAlaUserData().great_anchor_icon)) {
                this.f25509g.f25521h.setVisibility(0);
                this.f25509g.f25521h.startLoad(this.f25511i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25509g.f25521h.setVisibility(8);
            }
            this.f25509g.f25520g.setOnClickListener(this.k);
            e(this.f25508f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25507e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25509g.f25518e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25509g.f25516c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25509g.f25517d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25509g.f25520g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25509g.f25523j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25509g.m, R.color.CAM_X0101);
        this.f25507e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(c.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25512j = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f25508f.getPageActivity(), this.f25508f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            c2 c2Var = this.f25511i;
            if (c2Var == null || c2Var.j1() == null) {
                return;
            }
            c.a.q0.v.c cVar = this.f25512j;
            if (cVar != null) {
                cVar.a(this.f25511i);
            }
            c.a.q0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25511i.j1().live_id));
        }
    }
}
