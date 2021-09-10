package c.a.r0.v.e.d;

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
    public int f25985e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25986f;

    /* renamed from: g  reason: collision with root package name */
    public b f25987g;

    /* renamed from: h  reason: collision with root package name */
    public View f25988h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f25989i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.v.c f25990j;
    public View.OnClickListener k;

    /* renamed from: c.a.r0.v.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1211a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25991e;

        public View$OnClickListenerC1211a(a aVar) {
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
            this.f25991e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25991e.f25989i == null || this.f25991e.f25989i.J() == null || StringUtils.isNull(this.f25991e.f25989i.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f25991e.f25989i.J().getUserId(), 0L);
            boolean z = g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            c.a.r0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25991e.f25986f.getPageActivity()).createNormalConfig(g2, z, this.f25991e.f25989i.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25992a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25993b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25994c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25995d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25996e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25997f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25998g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25999h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26000i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f26001j;
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
            this.f25992a = view;
            this.f25993b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25994c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25995d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25996e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25997f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25998g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26000i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f26001j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25999h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f26001j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25999h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25993b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25996e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f26001j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f26000i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.f26001j.setLayoutParams(this.n);
            this.f25996e.setLayoutParams(layoutParams);
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
        this.f25985e = 3;
        this.k = new View$OnClickListenerC1211a(this);
        this.f25986f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25988h = inflate;
        this.f25987g = new b(inflate);
        c().setOnClickListener(this);
        this.f25986f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25988h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25989i = d2Var;
            this.f25987g.f25993b.setDrawerType(0);
            this.f25987g.f25993b.setBorderSurroundContent(true);
            this.f25987g.f25993b.setDrawBorder(true);
            this.f25987g.f25993b.startLoad(this.f25989i.l1().cover, 10, false);
            this.f25987g.f25995d.setText(this.f25986f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25989i.l1().audience_count)));
            this.f25987g.f25997f.setData(this.f25989i);
            this.f25987g.f25997f.setIsRound(true);
            this.f25987g.f25997f.setBorderSurroundContent(true);
            this.f25987g.f26001j.setText(this.f25989i.getTitle());
            if (this.f25989i.J() != null) {
                String name_show = this.f25989i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f25987g.f25998g.setText(name_show);
            }
            this.f25987g.l.setVisibility(0);
            this.f25987g.f25994c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25987g.f25994c.setText(this.f25989i.l1().label_name);
            this.f25987g.f25994c.setVisibility(0);
            if (this.f25989i.J() != null && this.f25989i.J().getAlaUserData() != null && !k.isEmpty(this.f25989i.J().getAlaUserData().great_anchor_icon)) {
                this.f25987g.f25999h.setVisibility(0);
                this.f25987g.f25999h.startLoad(this.f25989i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25987g.f25999h.setVisibility(8);
            }
            this.f25987g.f25998g.setOnClickListener(this.k);
            e(this.f25986f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25985e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25987g.f25996e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25987g.f25994c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25987g.f25995d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25987g.f25998g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25987g.f26001j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25987g.m, R.color.CAM_X0101);
        this.f25985e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(c.a.r0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25990j = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f25986f.getPageActivity(), this.f25986f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f25989i;
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            c.a.r0.v.c cVar = this.f25990j;
            if (cVar != null) {
                cVar.a(this.f25989i);
            }
            c.a.r0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25989i.l1().live_id));
        }
    }
}
