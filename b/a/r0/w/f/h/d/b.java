package b.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
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
        public final /* synthetic */ b f26429e;

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
            this.f26429e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26429e.q == null || this.f26429e.q.m1() == null || this.f26429e.p == null) {
                        return;
                    }
                    this.f26429e.p.a(this.f26429e.r, this.f26429e.s, this.f26429e.q);
                    return;
                }
                l.J(this.f26429e.n.getPageActivity(), this.f26429e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: b.a.r0.w.f.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1284b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26430e;

        public View$OnClickListenerC1284b(b bVar) {
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
            this.f26430e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26430e.q == null || this.f26430e.q.J() == null || StringUtils.isNull(this.f26430e.q.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.f.m.b.g(this.f26430e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26430e.n.getPageActivity()).createNormalConfig(g2, g2 == b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f26430e.q.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26431a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26432b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26433c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26434d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26435e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26436f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26437g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26438h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f26439i;

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
            this.f26431a = view;
            this.f26432b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26433c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26434d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26435e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26436f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26437g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26438h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f26439i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f26432b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26432b.setDrawerType(0);
            this.f26436f.setIsRound(true);
            this.f26436f.setDrawBorder(true);
            this.f26436f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f26436f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f26436f.setIsGod(false);
            this.f26436f.setIsBigV(false);
            this.f26436f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26435e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f26435e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1284b(this);
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
        SkinManager.setBackgroundResource(this.o.f26435e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f26434d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f26437g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f26438h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f26439i, R.color.CAM_X0109);
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
            if (eVar != null && (d2Var = eVar.f26027h) != null && d2Var.m1() != null) {
                i().setVisibility(0);
                this.q = eVar.f26027h;
                this.r = eVar.f26024e;
                this.s = !TextUtils.isEmpty(eVar.f26026g) ? eVar.f26026g : eVar.f26025f;
                this.o.f26432b.startLoad(this.q.m1().cover, 10, false);
                this.o.f26434d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.m1().audience_count)));
                this.o.f26436f.setData(this.q, false);
                this.o.f26438h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.o.f26437g.setText(name_show);
                }
                String str = this.q.m1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f26433c.setText(str);
                    this.o.f26433c.setVisibility(0);
                } else {
                    this.o.f26433c.setVisibility(8);
                }
                if (eVar.j) {
                    this.o.f26439i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.m1().distance / 1000.0d))));
                    this.o.f26439i.setVisibility(0);
                } else {
                    this.o.f26439i.setVisibility(8);
                }
                this.o.f26437g.setOnClickListener(this.v);
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
