package c.a.t0.a0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.e1.o0;
import c.a.s0.s.q.d2;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f15075b;

    /* renamed from: c  reason: collision with root package name */
    public c f15076c;

    /* renamed from: d  reason: collision with root package name */
    public View f15077d;

    /* renamed from: e  reason: collision with root package name */
    public int f15078e;

    /* renamed from: f  reason: collision with root package name */
    public String f15079f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f15080g;

    /* renamed from: h  reason: collision with root package name */
    public f f15081h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15082i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f15083j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f15084k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15085e;

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
            this.f15085e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f15085e.f15080g == null || this.f15085e.f15080g.o1() == null || this.f15085e.f15081h == null) {
                        return;
                    }
                    this.f15085e.f15081h.a(this.f15085e.f15078e, this.f15085e.f15079f, this.f15085e.f15080g);
                    return;
                }
                n.J(this.f15085e.f15075b.getPageActivity(), this.f15085e.f15075b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15086e;

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
            this.f15086e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15086e.f15080g == null || this.f15086e.f15080g.J() == null || StringUtils.isNull(this.f15086e.f15080g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f15086e.f15080g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15086e.f15075b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f15086e.f15080g.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15087b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15088c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15089d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f15090e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f15091f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15092g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15093h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f15094i;

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
            this.f15087b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15088c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f15089d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f15090e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15091f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f15092g = (TextView) view.findViewById(R.id.tvUserName);
            this.f15093h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f15094i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f15083j);
            this.f15087b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f15087b.setDrawerType(0);
            this.f15091f.setIsRound(true);
            this.f15091f.setDrawBorder(true);
            this.f15091f.setBorderColor(eVar.f15075b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f15091f.setBorderWidth(eVar.f15075b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f15091f.setIsGod(false);
            this.f15091f.setIsBigV(false);
            this.f15091f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15090e.getLayoutParams();
            int k2 = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k2;
            layoutParams.height = k2;
            this.f15090e.setLayoutParams(layoutParams);
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
        this.f15083j = new a(this);
        this.f15084k = new b(this);
        this.f15075b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f15077d = inflate;
        this.f15076c = new c(this, inflate);
        this.f15082i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15077d : (View) invokeV.objValue;
    }

    public void h(c.a.t0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f14693h) != null && d2Var.o1() != null) {
                g().setVisibility(0);
                this.f15080g = eVar.f14693h;
                this.f15078e = eVar.f14690e;
                this.f15079f = !TextUtils.isEmpty(eVar.f14692g) ? eVar.f14692g : eVar.f14691f;
                this.f15076c.f15087b.setDrawerType(0);
                this.f15076c.f15087b.setBorderSurroundContent(true);
                this.f15076c.f15087b.setDrawBorder(true);
                this.f15076c.f15087b.startLoad(this.f15080g.o1().cover, 10, false);
                this.f15076c.f15089d.setText(this.f15075b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f15080g.o1().audience_count)));
                this.f15076c.f15091f.setData(this.f15080g, false);
                this.f15076c.f15093h.setText(this.f15080g.getTitle());
                if (this.f15080g.J() != null) {
                    String name_show = this.f15080g.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.m(name_show, 10) + "...";
                    }
                    this.f15076c.f15092g.setText(name_show);
                }
                String str = this.f15080g.o1().label_name;
                if (this.f15082i && !StringUtils.isNull(str)) {
                    this.f15076c.f15088c.setText(str);
                    this.f15076c.f15088c.setVisibility(0);
                } else {
                    this.f15076c.f15088c.setVisibility(8);
                }
                if (eVar.f14695j) {
                    this.f15076c.f15094i.setText(this.f15075b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f15080g.o1().distance / 1000.0d))));
                    this.f15076c.f15094i.setVisibility(0);
                } else {
                    this.f15076c.f15094i.setVisibility(8);
                }
                this.f15076c.f15092g.setOnClickListener(this.f15084k);
                i(this.f15075b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f15076c.f15090e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f15076c.f15089d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15076c.f15092g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15076c.f15093h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15076c.f15094i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f15081h = fVar;
        }
    }
}
