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
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f25524e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f25525f;

    /* renamed from: g  reason: collision with root package name */
    public C1188b f25526g;

    /* renamed from: h  reason: collision with root package name */
    public View f25527h;

    /* renamed from: i  reason: collision with root package name */
    public c2 f25528i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.v.c f25529j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25530e;

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
            this.f25530e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25530e.f25528i == null || this.f25530e.f25528i.J() == null || StringUtils.isNull(this.f25530e.f25528i.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25530e.f25528i.J().getUserId(), 0L);
            boolean z = f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            c.a.q0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25530e.f25525f.getPageActivity()).createNormalConfig(f2, z, this.f25530e.f25528i.J().isBigV())));
        }
    }

    /* renamed from: c.a.q0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1188b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25531a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25532b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25533c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25534d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25535e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25536f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25537g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f25538h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f25539i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f25540j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1188b(View view) {
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
            this.f25531a = view;
            this.f25532b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25533c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25534d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25535e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25536f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25537g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25539i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.f25540j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f25538h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.f25540j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f25538h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25532b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25535e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.f25540j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f25539i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.f25540j.setLayoutParams(this.n);
            this.f25535e.setLayoutParams(layoutParams);
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
        this.f25524e = 3;
        this.k = new a(this);
        this.f25525f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f25527h = inflate;
        this.f25526g = new C1188b(inflate);
        c().setOnClickListener(this);
        this.f25525f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25527h : (View) invokeV.objValue;
    }

    public void d(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            if (c2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f25528i = c2Var;
            this.f25526g.f25532b.setDrawerType(0);
            this.f25526g.f25532b.setBorderSurroundContent(true);
            this.f25526g.f25532b.setDrawBorder(true);
            this.f25526g.f25532b.startLoad(this.f25528i.j1().cover, 10, false);
            this.f25526g.f25534d.setText(this.f25525f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f25528i.j1().audience_count)));
            this.f25526g.f25536f.setData(this.f25528i);
            this.f25526g.f25536f.setIsRound(true);
            this.f25526g.f25536f.setBorderSurroundContent(true);
            this.f25526g.f25540j.setText(this.f25528i.getTitle());
            if (this.f25528i.J() != null) {
                String name_show = this.f25528i.J().getName_show();
                if (l0.d(name_show) > 10) {
                    name_show = l0.m(name_show, 10) + "...";
                }
                this.f25526g.f25537g.setText(name_show);
            }
            this.f25526g.l.setVisibility(0);
            this.f25526g.f25533c.setBackgroundResource(R.drawable.transparent_bg);
            this.f25526g.f25533c.setText(this.f25528i.j1().label_name);
            this.f25526g.f25533c.setVisibility(0);
            if (this.f25528i.J() != null && this.f25528i.J().getAlaUserData() != null && !k.isEmpty(this.f25528i.J().getAlaUserData().great_anchor_icon)) {
                this.f25526g.f25538h.setVisibility(0);
                this.f25526g.f25538h.startLoad(this.f25528i.J().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f25526g.f25538h.setVisibility(8);
            }
            this.f25526g.f25537g.setOnClickListener(this.k);
            e(this.f25525f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25524e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25526g.f25535e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25526g.f25533c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f25526g.f25534d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25526g.f25537g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f25526g.f25540j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25526g.m, R.color.CAM_X0101);
        this.f25524e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(c.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25529j = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f25525f.getPageActivity(), this.f25525f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            c2 c2Var = this.f25528i;
            if (c2Var == null || c2Var.j1() == null) {
                return;
            }
            c.a.q0.v.c cVar = this.f25529j;
            if (cVar != null) {
                cVar.a(this.f25528i);
            }
            c.a.q0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f25528i.j1().live_id));
        }
    }
}
