package b.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
import b.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class b extends b.a.r0.b0.b<b.a.r0.w.f.a.e> {
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24912e;

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
            this.f24912e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f24912e.q == null || this.f24912e.q.l1() == null || this.f24912e.p == null) {
                        return;
                    }
                    this.f24912e.p.a(this.f24912e.r, this.f24912e.s, this.f24912e.q);
                    return;
                }
                l.J(this.f24912e.n.getPageActivity(), this.f24912e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: b.a.r0.w.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1216b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24913e;

        public View$OnClickListenerC1216b(b bVar) {
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
            this.f24913e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24913e.q == null || this.f24913e.q.J() == null || StringUtils.isNull(this.f24913e.q.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.e.m.b.g(this.f24913e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f24913e.n.getPageActivity()).createNormalConfig(g2, g2 == b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f24913e.q.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f24914a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f24915b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24916c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24917d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f24918e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f24919f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24920g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f24921h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f24922i;

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
            this.f24914a = view;
            this.f24915b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f24916c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f24917d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f24918e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f24919f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f24920g = (TextView) view.findViewById(R.id.tvUserName);
            this.f24921h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f24922i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f24915b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f24915b.setDrawerType(0);
            this.f24919f.setIsRound(true);
            this.f24919f.setDrawBorder(true);
            this.f24919f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f24919f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f24919f.setIsGod(false);
            this.f24919f.setIsBigV(false);
            this.f24919f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24918e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f24918e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1216b(this);
        this.n = tbPageContext;
        this.o = new c(this, i());
        this.t = z;
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f24918e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f24917d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f24920g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f24921h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f24922i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: v */
    public void j(b.a.r0.w.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f24510h) != null && d2Var.l1() != null) {
                i().setVisibility(0);
                this.q = eVar.f24510h;
                this.r = eVar.f24507e;
                this.s = !TextUtils.isEmpty(eVar.f24509g) ? eVar.f24509g : eVar.f24508f;
                this.o.f24915b.startLoad(this.q.l1().cover, 10, false);
                this.o.f24917d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.l1().audience_count)));
                this.o.f24919f.setData(this.q, false);
                this.o.f24921h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.o.f24920g.setText(name_show);
                }
                String str = this.q.l1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f24916c.setText(str);
                    this.o.f24916c.setVisibility(0);
                } else {
                    this.o.f24916c.setVisibility(8);
                }
                if (eVar.j) {
                    this.o.f24922i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.l1().distance / 1000.0d))));
                    this.o.f24922i.setVisibility(0);
                } else {
                    this.o.f24922i.setVisibility(8);
                }
                this.o.f24920g.setOnClickListener(this.v);
                k(this.n, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            i().setVisibility(4);
        }
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }
}
