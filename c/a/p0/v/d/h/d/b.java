package c.a.p0.v.d.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.o0.b1.l0;
import c.a.o0.s.q.c2;
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
/* loaded from: classes3.dex */
public class b extends c.a.p0.a0.b<c.a.p0.v.d.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext<?> n;
    public c o;
    public f p;
    public c2 q;
    public int r;
    public String s;
    public boolean t;
    public View.OnClickListener u;
    public View.OnClickListener v;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25071e;

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
            this.f25071e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25071e.q == null || this.f25071e.q.j1() == null || this.f25071e.p == null) {
                        return;
                    }
                    this.f25071e.p.a(this.f25071e.r, this.f25071e.s, this.f25071e.q);
                    return;
                }
                l.J(this.f25071e.n.getPageActivity(), this.f25071e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: c.a.p0.v.d.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1173b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25072e;

        public View$OnClickListenerC1173b(b bVar) {
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
            this.f25072e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25072e.q == null || this.f25072e.q.J() == null || StringUtils.isNull(this.f25072e.q.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25072e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25072e.n.getPageActivity()).createNormalConfig(f2, f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25072e.q.J().isBigV())));
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25073a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25074b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25075c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25076d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25077e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25078f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25079g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25080h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25081i;

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
            this.f25073a = view;
            this.f25074b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25075c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25076d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25077e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25078f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25079g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25080h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25081i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f25074b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25074b.setDrawerType(0);
            this.f25078f.setIsRound(true);
            this.f25078f.setDrawBorder(true);
            this.f25078f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25078f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25078f.setIsGod(false);
            this.f25078f.setIsBigV(false);
            this.f25078f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25077e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f25077e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1173b(this);
        this.n = tbPageContext;
        this.o = new c(this, j());
        this.t = z;
    }

    @Override // c.a.p0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f25077e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f25076d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f25079g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f25080h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f25081i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: w */
    public void k(c.a.p0.v.d.a.c cVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (c2Var = cVar.f24658h) != null && c2Var.j1() != null) {
                j().setVisibility(0);
                this.q = cVar.f24658h;
                this.r = cVar.f24655e;
                this.s = !TextUtils.isEmpty(cVar.f24657g) ? cVar.f24657g : cVar.f24656f;
                this.o.f25074b.startLoad(this.q.j1().cover, 10, false);
                this.o.f25076d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.j1().audience_count)));
                this.o.f25078f.setData(this.q, false);
                this.o.f25080h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (l0.d(name_show) > 10) {
                        name_show = l0.m(name_show, 10) + "...";
                    }
                    this.o.f25079g.setText(name_show);
                }
                String str = this.q.j1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f25075c.setText(str);
                    this.o.f25075c.setVisibility(0);
                } else {
                    this.o.f25075c.setVisibility(8);
                }
                if (cVar.f24659i) {
                    this.o.f25081i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.j1().distance / 1000.0d))));
                    this.o.f25081i.setVisibility(0);
                } else {
                    this.o.f25081i.setVisibility(8);
                }
                this.o.f25079g.setOnClickListener(this.v);
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
