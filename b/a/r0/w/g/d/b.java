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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26558e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f26559f;

    /* renamed from: g  reason: collision with root package name */
    public C1288b f26560g;

    /* renamed from: h  reason: collision with root package name */
    public View f26561h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f26562i;
    public e j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26563e;

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
            this.f26563e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26563e.f26562i == null || this.f26563e.f26562i.J() == null || StringUtils.isNull(this.f26563e.f26562i.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.f.m.b.g(this.f26563e.f26562i.J().getUserId(), 0L);
            boolean z = g2 == b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26563e.f26559f.getPageActivity()).createNormalConfig(g2, z, this.f26563e.f26562i.J().isBigV())));
        }
    }

    /* renamed from: b.a.r0.w.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1288b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26564a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26565b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26566c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26567d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26568e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26569f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26570g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f26571h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26572i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1288b(View view) {
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
            this.f26564a = view;
            this.f26565b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26566c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26567d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26568e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26569f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26570g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26572i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f26571h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f26571h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26565b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26568e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f26572i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f26568e.setLayoutParams(layoutParams);
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
        this.f26558e = 3;
        this.k = new a(this);
        this.f26559f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f26561h = inflate;
        this.f26560g = new C1288b(inflate);
        c().setOnClickListener(this);
        this.f26559f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26561h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f26562i = d2Var;
            this.f26560g.f26565b.setDrawerType(0);
            this.f26560g.f26565b.setBorderSurroundContent(true);
            this.f26560g.f26565b.setDrawBorder(true);
            this.f26560g.f26565b.startLoad(this.f26562i.m1().cover, 10, false);
            this.f26560g.f26567d.setText(this.f26559f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f26562i.m1().audience_count)));
            this.f26560g.f26569f.setData(this.f26562i);
            this.f26560g.f26569f.setIsRound(true);
            this.f26560g.f26569f.setBorderSurroundContent(true);
            this.f26560g.j.setText(this.f26562i.getTitle());
            if (this.f26562i.J() != null) {
                String name_show = this.f26562i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f26560g.f26570g.setText(name_show);
            }
            this.f26560g.l.setVisibility(0);
            this.f26560g.f26566c.setBackgroundResource(R.drawable.transparent_bg);
            this.f26560g.f26566c.setText(this.f26562i.m1().label_name);
            this.f26560g.f26566c.setVisibility(0);
            if (this.f26562i.J() != null && this.f26562i.J().getAlaUserData() != null && !k.isEmpty(this.f26562i.J().getAlaUserData().great_anchor_icon)) {
                this.f26560g.f26571h.setVisibility(0);
                this.f26560g.f26571h.startLoad(this.f26562i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f26560g.f26571h.setVisibility(8);
            }
            this.f26560g.f26570g.setOnClickListener(this.k);
            e(this.f26559f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26558e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26560g.f26568e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26560g.f26566c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f26560g.f26567d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26560g.f26570g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f26560g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26560g.m, R.color.CAM_X0101);
        this.f26558e = i2;
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
                l.J(this.f26559f.getPageActivity(), this.f26559f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f26562i;
            if (d2Var == null || d2Var.m1() == null) {
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.a(this.f26562i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f26562i.m1().live_id));
        }
    }
}
