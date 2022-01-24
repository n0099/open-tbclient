package c.a.t0.a0.f.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.d1.o0;
import c.a.s0.s.q.e2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends c.a.t0.g0.b<c.a.t0.a0.f.a.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext<?> n;
    public c o;
    public f p;
    public e2 q;
    public int r;
    public String s;
    public boolean t;
    public View.OnClickListener u;
    public View.OnClickListener v;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14823e;

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
            this.f14823e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f14823e.q == null || this.f14823e.q.p1() == null || this.f14823e.p == null) {
                        return;
                    }
                    this.f14823e.p.a(this.f14823e.r, this.f14823e.s, this.f14823e.q);
                    return;
                }
                n.K(this.f14823e.n.getPageActivity(), this.f14823e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: c.a.t0.a0.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0944b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14824e;

        public View$OnClickListenerC0944b(b bVar) {
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
            this.f14824e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14824e.q == null || this.f14824e.q.J() == null || StringUtils.isNull(this.f14824e.q.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14824e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14824e.n.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14824e.q.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14825b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14826c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14827d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14828e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14829f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14830g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14831h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14832i;

        public c(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
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
            this.f14825b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14826c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14827d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14828e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14829f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14830g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14831h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14832i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f14825b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14825b.setDrawerType(0);
            this.f14829f.setIsRound(true);
            this.f14829f.setDrawBorder(true);
            this.f14829f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14829f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14829f.setIsGod(false);
            this.f14829f.setIsBigV(false);
            this.f14829f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14828e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f14828e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.t = false;
        this.u = new a(this);
        this.v = new View$OnClickListenerC0944b(this);
        this.n = tbPageContext;
        this.o = new c(this, j());
        this.t = z;
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f14828e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f14827d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f14830g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f14831h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f14832i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: w */
    public void k(c.a.t0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14484h) != null && e2Var.p1() != null) {
                j().setVisibility(0);
                this.q = eVar.f14484h;
                this.r = eVar.f14481e;
                this.s = !TextUtils.isEmpty(eVar.f14483g) ? eVar.f14483g : eVar.f14482f;
                this.o.f14825b.startLoad(this.q.p1().cover, 10, false);
                this.o.f14827d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.p1().audience_count)));
                this.o.f14829f.setData(this.q, false);
                this.o.f14831h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + "...";
                    }
                    this.o.f14830g.setText(name_show);
                }
                String str = this.q.p1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f14826c.setText(str);
                    this.o.f14826c.setVisibility(0);
                } else {
                    this.o.f14826c.setVisibility(8);
                }
                if (eVar.f14486j) {
                    this.o.f14832i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.p1().distance / 1000.0d))));
                    this.o.f14832i.setVisibility(0);
                } else {
                    this.o.f14832i.setVisibility(8);
                }
                this.o.f14830g.setOnClickListener(this.v);
                l(this.n, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            j().setVisibility(4);
        }
    }

    public void x(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }
}
