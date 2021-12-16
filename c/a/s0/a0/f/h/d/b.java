package c.a.s0.a0.f.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.d1.o0;
import c.a.r0.s.r.d2;
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
public class b extends c.a.s0.g0.b<c.a.s0.a0.f.a.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext<?> n;
    public c o;
    public f p;
    public d2 q;
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
        public final /* synthetic */ b f14549e;

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
            this.f14549e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    if (this.f14549e.q == null || this.f14549e.q.o1() == null || this.f14549e.p == null) {
                        return;
                    }
                    this.f14549e.p.a(this.f14549e.r, this.f14549e.s, this.f14549e.q);
                    return;
                }
                m.J(this.f14549e.n.getPageActivity(), this.f14549e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: c.a.s0.a0.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0896b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14550e;

        public View$OnClickListenerC0896b(b bVar) {
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
            this.f14550e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14550e.q == null || this.f14550e.q.J() == null || StringUtils.isNull(this.f14550e.q.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14550e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14550e.n.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14550e.q.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14551b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14552c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14553d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14554e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14555f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14556g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14557h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14558i;

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
            this.f14551b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14552c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14553d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14554e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14555f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14556g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14557h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14558i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f14551b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14551b.setDrawerType(0);
            this.f14555f.setIsRound(true);
            this.f14555f.setDrawBorder(true);
            this.f14555f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14555f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14555f.setIsGod(false);
            this.f14555f.setIsBigV(false);
            this.f14555f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14554e.getLayoutParams();
            int k2 = (m.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k2;
            layoutParams.height = (k2 * 9) / 16;
            this.f14554e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC0896b(this);
        this.n = tbPageContext;
        this.o = new c(this, j());
        this.t = z;
    }

    @Override // c.a.s0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // c.a.s0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f14554e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f14553d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f14556g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f14557h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f14558i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.g0.b
    /* renamed from: w */
    public void k(c.a.s0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f14193h) != null && d2Var.o1() != null) {
                j().setVisibility(0);
                this.q = eVar.f14193h;
                this.r = eVar.f14190e;
                this.s = !TextUtils.isEmpty(eVar.f14192g) ? eVar.f14192g : eVar.f14191f;
                this.o.f14551b.startLoad(this.q.o1().cover, 10, false);
                this.o.f14553d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.o1().audience_count)));
                this.o.f14555f.setData(this.q, false);
                this.o.f14557h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.m(name_show, 10) + "...";
                    }
                    this.o.f14556g.setText(name_show);
                }
                String str = this.q.o1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f14552c.setText(str);
                    this.o.f14552c.setVisibility(0);
                } else {
                    this.o.f14552c.setVisibility(8);
                }
                if (eVar.f14195j) {
                    this.o.f14558i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.o1().distance / 1000.0d))));
                    this.o.f14558i.setVisibility(0);
                } else {
                    this.o.f14558i.setVisibility(8);
                }
                this.o.f14556g.setOnClickListener(this.v);
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
