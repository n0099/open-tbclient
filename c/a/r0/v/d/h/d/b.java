package c.a.r0.v.d.h.d;

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
public class b extends c.a.r0.a0.b<c.a.r0.v.d.a.c> {
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
        public final /* synthetic */ b f25882e;

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
            this.f25882e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25882e.q == null || this.f25882e.q.l1() == null || this.f25882e.p == null) {
                        return;
                    }
                    this.f25882e.p.a(this.f25882e.r, this.f25882e.s, this.f25882e.q);
                    return;
                }
                l.J(this.f25882e.n.getPageActivity(), this.f25882e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: c.a.r0.v.d.h.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1208b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25883e;

        public View$OnClickListenerC1208b(b bVar) {
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
            this.f25883e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25883e.q == null || this.f25883e.q.J() == null || StringUtils.isNull(this.f25883e.q.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f25883e.q.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25883e.n.getPageActivity()).createNormalConfig(g2, g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25883e.q.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25884a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25885b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25886c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25887d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25888e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25889f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25890g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25891h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25892i;

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
            this.f25884a = view;
            this.f25885b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25886c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25887d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25888e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25889f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25890g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25891h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25892i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f25885b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25885b.setDrawerType(0);
            this.f25889f.setIsRound(true);
            this.f25889f.setDrawBorder(true);
            this.f25889f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25889f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25889f.setIsGod(false);
            this.f25889f.setIsBigV(false);
            this.f25889f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25888e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f25888e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1208b(this);
        this.n = tbPageContext;
        this.o = new c(this, j());
        this.t = z;
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f25888e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f25887d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f25890g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f25891h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f25892i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: w */
    public void k(c.a.r0.v.d.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25469h) != null && d2Var.l1() != null) {
                j().setVisibility(0);
                this.q = cVar.f25469h;
                this.r = cVar.f25466e;
                this.s = !TextUtils.isEmpty(cVar.f25468g) ? cVar.f25468g : cVar.f25467f;
                this.o.f25885b.startLoad(this.q.l1().cover, 10, false);
                this.o.f25887d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.l1().audience_count)));
                this.o.f25889f.setData(this.q, false);
                this.o.f25891h.setText(this.q.getTitle());
                if (this.q.J() != null) {
                    String name_show = this.q.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.o.f25890g.setText(name_show);
                }
                String str = this.q.l1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f25886c.setText(str);
                    this.o.f25886c.setVisibility(0);
                } else {
                    this.o.f25886c.setVisibility(8);
                }
                if (cVar.f25470i) {
                    this.o.f25892i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.l1().distance / 1000.0d))));
                    this.o.f25892i.setVisibility(0);
                } else {
                    this.o.f25892i.setVisibility(8);
                }
                this.o.f25890g.setOnClickListener(this.v);
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
