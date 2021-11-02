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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f25041e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25042f;

    /* renamed from: g  reason: collision with root package name */
    public C1220b f25043g;

    /* renamed from: h  reason: collision with root package name */
    public View f25044h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f25045i;
    public e j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25046e;

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
            this.f25046e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25046e.f25045i == null || this.f25046e.f25045i.J() == null || StringUtils.isNull(this.f25046e.f25045i.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.e.m.b.g(this.f25046e.f25045i.J().getUserId(), 0L);
            boolean z = g2 == b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25046e.f25042f.getPageActivity()).createNormalConfig(g2, z, this.f25046e.f25045i.J().isBigV())));
        }
    }

    /* renamed from: b.a.r0.w.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1220b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25047a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25048b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25049c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25050d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25051e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25052f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25053g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25054h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25055i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1220b(View view) {
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
            this.f25047a = view;
            this.f25048b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25049c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25050d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25051e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25052f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25053g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25055i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25054h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25054h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25048b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25051e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f25055i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f25051e.setLayoutParams(layoutParams);
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
        this.f25041e = 3;
        this.k = new a(this);
        this.f25042f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25044h = inflate;
        this.f25043g = new C1220b(inflate);
        c().setOnClickListener(this);
        this.f25042f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25044h : (View) invokeV.objValue;
    }

    public void d(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            if (d2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25045i = d2Var;
            this.f25043g.f25048b.setDrawerType(0);
            this.f25043g.f25048b.setBorderSurroundContent(true);
            this.f25043g.f25048b.setDrawBorder(true);
            this.f25043g.f25048b.startLoad(this.f25045i.l1().cover, 10, false);
            this.f25043g.f25050d.setText(this.f25042f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25045i.l1().audience_count)));
            this.f25043g.f25052f.setData(this.f25045i);
            this.f25043g.f25052f.setIsRound(true);
            this.f25043g.f25052f.setBorderSurroundContent(true);
            this.f25043g.j.setText(this.f25045i.getTitle());
            if (this.f25045i.J() != null) {
                String name_show = this.f25045i.J().getName_show();
                if (m0.d(name_show) > 10) {
                    name_show = m0.m(name_show, 10) + "...";
                }
                this.f25043g.f25053g.setText(name_show);
            }
            this.f25043g.l.setVisibility(0);
            this.f25043g.f25049c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25043g.f25049c.setText(this.f25045i.l1().label_name);
            this.f25043g.f25049c.setVisibility(0);
            if (this.f25045i.J() != null && this.f25045i.J().getAlaUserData() != null && !k.isEmpty(this.f25045i.J().getAlaUserData().great_anchor_icon)) {
                this.f25043g.f25054h.setVisibility(0);
                this.f25043g.f25054h.startLoad(this.f25045i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25043g.f25054h.setVisibility(8);
            }
            this.f25043g.f25053g.setOnClickListener(this.k);
            e(this.f25042f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25041e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25043g.f25051e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25043g.f25049c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25043g.f25050d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25043g.f25053g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25043g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25043g.m, R.color.CAM_X0101);
        this.f25041e = i2;
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
                l.J(this.f25042f.getPageActivity(), this.f25042f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            d2 d2Var = this.f25045i;
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.a(this.f25045i);
            }
            d.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25045i.l1().live_id));
        }
    }
}
