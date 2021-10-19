package c.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends c.a.r0.b0.b<c.a.r0.w.f.a.c> {
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26080e;

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
            this.f26080e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26080e.q == null || this.f26080e.q.l1() == null || this.f26080e.p == null) {
                        return;
                    }
                    this.f26080e.p.a(this.f26080e.r, this.f26080e.s, this.f26080e.q);
                    return;
                }
                l.J(this.f26080e.n.getPageActivity(), this.f26080e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: c.a.r0.w.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1215b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26081e;

        public View$OnClickListenerC1215b(b bVar) {
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
            this.f26081e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26081e.q == null || this.f26081e.q.J() == null || StringUtils.isNull(this.f26081e.q.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f26081e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26081e.n.getPageActivity()).createNormalConfig(g2, g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f26081e.q.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26082a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26083b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26084c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26085d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26086e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26087f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26088g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26089h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f26090i;

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
            this.f26082a = view;
            this.f26083b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26084c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26085d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26086e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26087f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26088g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26089h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f26090i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f26083b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26083b.setDrawerType(0);
            this.f26087f.setIsRound(true);
            this.f26087f.setDrawBorder(true);
            this.f26087f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f26087f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f26087f.setIsGod(false);
            this.f26087f.setIsBigV(false);
            this.f26087f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26086e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f26086e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1215b(this);
        this.n = tbPageContext;
        this.o = new c(this, j());
        this.t = z;
    }

    @Override // c.a.r0.b0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // c.a.r0.b0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f26086e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f26085d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f26088g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f26089h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f26090i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.b0.b
    /* renamed from: w */
    public void k(c.a.r0.w.f.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25667h) != null && d2Var.l1() != null) {
                j().setVisibility(0);
                this.q = cVar.f25667h;
                this.r = cVar.f25664e;
                this.s = !TextUtils.isEmpty(cVar.f25666g) ? cVar.f25666g : cVar.f25665f;
                this.o.f26083b.startLoad(this.q.l1().cover, 10, false);
                this.o.f26085d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.l1().audience_count)));
                this.o.f26087f.setData(this.q, false);
                this.o.f26089h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.o.f26088g.setText(name_show);
                }
                String str = this.q.l1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f26084c.setText(str);
                    this.o.f26084c.setVisibility(0);
                } else {
                    this.o.f26084c.setVisibility(8);
                }
                if (cVar.f25668i) {
                    this.o.f26090i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.l1().distance / 1000.0d))));
                    this.o.f26090i.setVisibility(0);
                } else {
                    this.o.f26090i.setVisibility(8);
                }
                this.o.f26088g.setOnClickListener(this.v);
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
