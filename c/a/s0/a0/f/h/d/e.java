package c.a.s0.a0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14577b;

    /* renamed from: c  reason: collision with root package name */
    public c f14578c;

    /* renamed from: d  reason: collision with root package name */
    public View f14579d;

    /* renamed from: e  reason: collision with root package name */
    public int f14580e;

    /* renamed from: f  reason: collision with root package name */
    public String f14581f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f14582g;

    /* renamed from: h  reason: collision with root package name */
    public f f14583h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14584i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f14585j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f14586k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14587e;

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
            this.f14587e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    if (this.f14587e.f14582g == null || this.f14587e.f14582g.o1() == null || this.f14587e.f14583h == null) {
                        return;
                    }
                    this.f14587e.f14583h.a(this.f14587e.f14580e, this.f14587e.f14581f, this.f14587e.f14582g);
                    return;
                }
                m.J(this.f14587e.f14577b.getPageActivity(), this.f14587e.f14577b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14588e;

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
            this.f14588e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14588e.f14582g == null || this.f14588e.f14582g.J() == null || StringUtils.isNull(this.f14588e.f14582g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14588e.f14582g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14588e.f14577b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14588e.f14582g.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14589b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14590c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14591d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14592e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14593f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14594g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14595h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14596i;

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
            this.f14589b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14590c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14591d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14592e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14593f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14594g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14595h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14596i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f14585j);
            this.f14589b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14589b.setDrawerType(0);
            this.f14593f.setIsRound(true);
            this.f14593f.setDrawBorder(true);
            this.f14593f.setBorderColor(eVar.f14577b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14593f.setBorderWidth(eVar.f14577b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14593f.setIsGod(false);
            this.f14593f.setIsBigV(false);
            this.f14593f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14592e.getLayoutParams();
            int k2 = (m.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k2;
            layoutParams.height = k2;
            this.f14592e.setLayoutParams(layoutParams);
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
        this.f14585j = new a(this);
        this.f14586k = new b(this);
        this.f14577b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f14579d = inflate;
        this.f14578c = new c(this, inflate);
        this.f14584i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14579d : (View) invokeV.objValue;
    }

    public void h(c.a.s0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f14193h) != null && d2Var.o1() != null) {
                g().setVisibility(0);
                this.f14582g = eVar.f14193h;
                this.f14580e = eVar.f14190e;
                this.f14581f = !TextUtils.isEmpty(eVar.f14192g) ? eVar.f14192g : eVar.f14191f;
                this.f14578c.f14589b.setDrawerType(0);
                this.f14578c.f14589b.setBorderSurroundContent(true);
                this.f14578c.f14589b.setDrawBorder(true);
                this.f14578c.f14589b.startLoad(this.f14582g.o1().cover, 10, false);
                this.f14578c.f14591d.setText(this.f14577b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f14582g.o1().audience_count)));
                this.f14578c.f14593f.setData(this.f14582g, false);
                this.f14578c.f14595h.setText(this.f14582g.getTitle());
                if (this.f14582g.J() != null) {
                    String name_show = this.f14582g.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.m(name_show, 10) + "...";
                    }
                    this.f14578c.f14594g.setText(name_show);
                }
                String str = this.f14582g.o1().label_name;
                if (this.f14584i && !StringUtils.isNull(str)) {
                    this.f14578c.f14590c.setText(str);
                    this.f14578c.f14590c.setVisibility(0);
                } else {
                    this.f14578c.f14590c.setVisibility(8);
                }
                if (eVar.f14195j) {
                    this.f14578c.f14596i.setText(this.f14577b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f14582g.o1().distance / 1000.0d))));
                    this.f14578c.f14596i.setVisibility(0);
                } else {
                    this.f14578c.f14596i.setVisibility(8);
                }
                this.f14578c.f14594g.setOnClickListener(this.f14586k);
                i(this.f14577b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f14578c.f14592e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14578c.f14591d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14578c.f14594g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14578c.f14595h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14578c.f14596i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14583h = fVar;
        }
    }
}
