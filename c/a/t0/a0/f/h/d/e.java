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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14709b;

    /* renamed from: c  reason: collision with root package name */
    public c f14710c;

    /* renamed from: d  reason: collision with root package name */
    public View f14711d;

    /* renamed from: e  reason: collision with root package name */
    public int f14712e;

    /* renamed from: f  reason: collision with root package name */
    public String f14713f;

    /* renamed from: g  reason: collision with root package name */
    public e2 f14714g;

    /* renamed from: h  reason: collision with root package name */
    public f f14715h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14716i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f14717j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14718e;

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
            this.f14718e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f14718e.f14714g == null || this.f14718e.f14714g.o1() == null || this.f14718e.f14715h == null) {
                        return;
                    }
                    this.f14718e.f14715h.a(this.f14718e.f14712e, this.f14718e.f14713f, this.f14718e.f14714g);
                    return;
                }
                n.K(this.f14718e.f14709b.getPageActivity(), this.f14718e.f14709b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14719e;

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
            this.f14719e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14719e.f14714g == null || this.f14719e.f14714g.J() == null || StringUtils.isNull(this.f14719e.f14714g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14719e.f14714g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14719e.f14709b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14719e.f14714g.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14720b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14721c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14722d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14723e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14724f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14725g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14726h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14727i;

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
            this.f14720b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14721c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14722d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14723e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14724f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14725g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14726h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14727i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f14717j);
            this.f14720b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14720b.setDrawerType(0);
            this.f14724f.setIsRound(true);
            this.f14724f.setDrawBorder(true);
            this.f14724f.setBorderColor(eVar.f14709b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14724f.setBorderWidth(eVar.f14709b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14724f.setIsGod(false);
            this.f14724f.setIsBigV(false);
            this.f14724f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14723e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f14723e.setLayoutParams(layoutParams);
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
        this.f14717j = new a(this);
        this.k = new b(this);
        this.f14709b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f14711d = inflate;
        this.f14710c = new c(this, inflate);
        this.f14716i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14711d : (View) invokeV.objValue;
    }

    public void h(c.a.t0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14344h) != null && e2Var.o1() != null) {
                g().setVisibility(0);
                this.f14714g = eVar.f14344h;
                this.f14712e = eVar.f14341e;
                this.f14713f = !TextUtils.isEmpty(eVar.f14343g) ? eVar.f14343g : eVar.f14342f;
                this.f14710c.f14720b.setDrawerType(0);
                this.f14710c.f14720b.setBorderSurroundContent(true);
                this.f14710c.f14720b.setDrawBorder(true);
                this.f14710c.f14720b.startLoad(this.f14714g.o1().cover, 10, false);
                this.f14710c.f14722d.setText(this.f14709b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f14714g.o1().audience_count)));
                this.f14710c.f14724f.setData(this.f14714g, false);
                this.f14710c.f14726h.setText(this.f14714g.getTitle());
                if (this.f14714g.J() != null) {
                    String name_show = this.f14714g.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.m(name_show, 10) + "...";
                    }
                    this.f14710c.f14725g.setText(name_show);
                }
                String str = this.f14714g.o1().label_name;
                if (this.f14716i && !StringUtils.isNull(str)) {
                    this.f14710c.f14721c.setText(str);
                    this.f14710c.f14721c.setVisibility(0);
                } else {
                    this.f14710c.f14721c.setVisibility(8);
                }
                if (eVar.f14346j) {
                    this.f14710c.f14727i.setText(this.f14709b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f14714g.o1().distance / 1000.0d))));
                    this.f14710c.f14727i.setVisibility(0);
                } else {
                    this.f14710c.f14727i.setVisibility(8);
                }
                this.f14710c.f14725g.setOnClickListener(this.k);
                i(this.f14709b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f14710c.f14723e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14710c.f14722d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14710c.f14725g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14710c.f14726h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14710c.f14727i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14715h = fVar;
        }
    }
}
