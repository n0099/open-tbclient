package c.a.r0.a0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14237b;

    /* renamed from: c  reason: collision with root package name */
    public c f14238c;

    /* renamed from: d  reason: collision with root package name */
    public View f14239d;

    /* renamed from: e  reason: collision with root package name */
    public int f14240e;

    /* renamed from: f  reason: collision with root package name */
    public String f14241f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f14242g;

    /* renamed from: h  reason: collision with root package name */
    public f f14243h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14244i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f14245j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f14246k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14247e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14247e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f14247e.f14242g == null || this.f14247e.f14242g.o1() == null || this.f14247e.f14243h == null) {
                        return;
                    }
                    this.f14247e.f14243h.a(this.f14247e.f14240e, this.f14247e.f14241f, this.f14247e.f14242g);
                    return;
                }
                l.J(this.f14247e.f14237b.getPageActivity(), this.f14247e.f14237b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14248e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14248e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14248e.f14242g == null || this.f14248e.f14242g.J() == null || StringUtils.isNull(this.f14248e.f14242g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14248e.f14242g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14248e.f14237b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14248e.f14242g.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14249b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14250c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14251d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14252e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14253f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14254g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14255h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14256i;

        public c(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
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
            this.f14249b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14250c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14251d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14252e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14253f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14254g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14255h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14256i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f14245j);
            this.f14249b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14249b.setDrawerType(0);
            this.f14253f.setIsRound(true);
            this.f14253f.setDrawBorder(true);
            this.f14253f.setBorderColor(eVar.f14237b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14253f.setBorderWidth(eVar.f14237b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14253f.setIsGod(false);
            this.f14253f.setIsBigV(false);
            this.f14253f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14252e.getLayoutParams();
            int k2 = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k2;
            layoutParams.height = k2;
            this.f14252e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f14245j = new a(this);
        this.f14246k = new b(this);
        this.f14237b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f14239d = inflate;
        this.f14238c = new c(this, inflate);
        this.f14244i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14239d : (View) invokeV.objValue;
    }

    public void h(c.a.r0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f13853h) != null && d2Var.o1() != null) {
                g().setVisibility(0);
                this.f14242g = eVar.f13853h;
                this.f14240e = eVar.f13850e;
                this.f14241f = !TextUtils.isEmpty(eVar.f13852g) ? eVar.f13852g : eVar.f13851f;
                this.f14238c.f14249b.setDrawerType(0);
                this.f14238c.f14249b.setBorderSurroundContent(true);
                this.f14238c.f14249b.setDrawBorder(true);
                this.f14238c.f14249b.startLoad(this.f14242g.o1().cover, 10, false);
                this.f14238c.f14251d.setText(this.f14237b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f14242g.o1().audience_count)));
                this.f14238c.f14253f.setData(this.f14242g, false);
                this.f14238c.f14255h.setText(this.f14242g.getTitle());
                if (this.f14242g.J() != null) {
                    String name_show = this.f14242g.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f14238c.f14254g.setText(name_show);
                }
                String str = this.f14242g.o1().label_name;
                if (this.f14244i && !StringUtils.isNull(str)) {
                    this.f14238c.f14250c.setText(str);
                    this.f14238c.f14250c.setVisibility(0);
                } else {
                    this.f14238c.f14250c.setVisibility(8);
                }
                if (eVar.f13855j) {
                    this.f14238c.f14256i.setText(this.f14237b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f14242g.o1().distance / 1000.0d))));
                    this.f14238c.f14256i.setVisibility(0);
                } else {
                    this.f14238c.f14256i.setVisibility(8);
                }
                this.f14238c.f14254g.setOnClickListener(this.f14246k);
                i(this.f14237b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f14238c.f14252e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14238c.f14251d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14238c.f14254g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14238c.f14255h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14238c.f14256i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14243h = fVar;
        }
    }
}
