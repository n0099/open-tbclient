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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26200e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f26201f;

    /* renamed from: g  reason: collision with root package name */
    public C1219b f26202g;

    /* renamed from: h  reason: collision with root package name */
    public View f26203h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f26204i;

    /* renamed from: j  reason: collision with root package name */
    public e f26205j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26206e;

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
            this.f26206e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26206e.f26204i == null || this.f26206e.f26204i.J() == null || StringUtils.isNull(this.f26206e.f26204i.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f26206e.f26204i.J().getUserId(), 0L);
            boolean z = g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26206e.f26201f.getPageActivity()).createNormalConfig(g2, z, this.f26206e.f26204i.J().isBigV())));
        }
    }

    /* renamed from: c.a.r0.w.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1219b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26207a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26208b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26209c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26210d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26211e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26212f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26213g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f26214h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26215i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f26216j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1219b(View view) {
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
            this.f26207a = view;
            this.f26208b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26209c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26210d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26211e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26212f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26213g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26215i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f26216j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f26214h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f26216j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f26214h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26208b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26211e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f26216j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f26215i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.f26216j.setLayoutParams(this.n);
            this.f26211e.setLayoutParams(layoutParams);
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
        this.f26200e = 3;
        this.k = new a(this);
        this.f26201f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f26203h = inflate;
        this.f26202g = new C1219b(inflate);
        c().setOnClickListener(this);
        this.f26201f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26203h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f26204i = d2Var;
            this.f26202g.f26208b.setDrawerType(0);
            this.f26202g.f26208b.setBorderSurroundContent(true);
            this.f26202g.f26208b.setDrawBorder(true);
            this.f26202g.f26208b.startLoad(this.f26204i.l1().cover, 10, false);
            this.f26202g.f26210d.setText(this.f26201f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f26204i.l1().audience_count)));
            this.f26202g.f26212f.setData(this.f26204i);
            this.f26202g.f26212f.setIsRound(true);
            this.f26202g.f26212f.setBorderSurroundContent(true);
            this.f26202g.f26216j.setText(this.f26204i.getTitle());
            if (this.f26204i.J() != null) {
                String name_show = this.f26204i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f26202g.f26213g.setText(name_show);
            }
            this.f26202g.l.setVisibility(0);
            this.f26202g.f26209c.setBackgroundResource(R.drawable.transparent_bg);
            this.f26202g.f26209c.setText(this.f26204i.l1().label_name);
            this.f26202g.f26209c.setVisibility(0);
            if (this.f26204i.J() != null && this.f26204i.J().getAlaUserData() != null && !k.isEmpty(this.f26204i.J().getAlaUserData().great_anchor_icon)) {
                this.f26202g.f26214h.setVisibility(0);
                this.f26202g.f26214h.startLoad(this.f26204i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f26202g.f26214h.setVisibility(8);
            }
            this.f26202g.f26213g.setOnClickListener(this.k);
            e(this.f26201f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26200e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26202g.f26211e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26202g.f26209c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f26202g.f26210d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26202g.f26213g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f26202g.f26216j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26202g.m, R.color.CAM_X0101);
        this.f26200e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f26205j = eVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f26201f.getPageActivity(), this.f26201f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f26204i;
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            e eVar = this.f26205j;
            if (eVar != null) {
                eVar.a(this.f26204i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f26204i.l1().live_id));
        }
    }
}
