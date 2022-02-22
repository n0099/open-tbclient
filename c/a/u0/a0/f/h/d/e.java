package c.a.u0.a0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.d1.p0;
import c.a.t0.s.r.e2;
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
    public TbPageContext<?> f15123b;

    /* renamed from: c  reason: collision with root package name */
    public c f15124c;

    /* renamed from: d  reason: collision with root package name */
    public View f15125d;

    /* renamed from: e  reason: collision with root package name */
    public int f15126e;

    /* renamed from: f  reason: collision with root package name */
    public String f15127f;

    /* renamed from: g  reason: collision with root package name */
    public e2 f15128g;

    /* renamed from: h  reason: collision with root package name */
    public f f15129h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15130i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f15131j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15132e;

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
            this.f15132e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f15132e.f15128g == null || this.f15132e.f15128g.p1() == null || this.f15132e.f15129h == null) {
                        return;
                    }
                    this.f15132e.f15129h.a(this.f15132e.f15126e, this.f15132e.f15127f, this.f15132e.f15128g);
                    return;
                }
                n.K(this.f15132e.f15123b.getPageActivity(), this.f15132e.f15123b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15133e;

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
            this.f15133e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15133e.f15128g == null || this.f15133e.f15128g.J() == null || StringUtils.isNull(this.f15133e.f15128g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f15133e.f15128g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f15133e.f15123b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f15133e.f15128g.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15134b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15135c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15136d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f15137e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f15138f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15139g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15140h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f15141i;

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
            this.f15134b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f15135c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f15136d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f15137e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f15138f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f15139g = (TextView) view.findViewById(R.id.tvUserName);
            this.f15140h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f15141i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f15131j);
            this.f15134b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f15134b.setDrawerType(0);
            this.f15138f.setIsRound(true);
            this.f15138f.setDrawBorder(true);
            this.f15138f.setBorderColor(eVar.f15123b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f15138f.setBorderWidth(eVar.f15123b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f15138f.setIsGod(false);
            this.f15138f.setIsBigV(false);
            this.f15138f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15137e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f15137e.setLayoutParams(layoutParams);
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
        this.f15131j = new a(this);
        this.k = new b(this);
        this.f15123b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f15125d = inflate;
        this.f15124c = new c(this, inflate);
        this.f15130i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15125d : (View) invokeV.objValue;
    }

    public void h(c.a.u0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14758h) != null && e2Var.p1() != null) {
                g().setVisibility(0);
                this.f15128g = eVar.f14758h;
                this.f15126e = eVar.f14755e;
                this.f15127f = !TextUtils.isEmpty(eVar.f14757g) ? eVar.f14757g : eVar.f14756f;
                this.f15124c.f15134b.setDrawerType(0);
                this.f15124c.f15134b.setBorderSurroundContent(true);
                this.f15124c.f15134b.setDrawBorder(true);
                this.f15124c.f15134b.startLoad(this.f15128g.p1().cover, 10, false);
                this.f15124c.f15136d.setText(this.f15123b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f15128g.p1().audience_count)));
                this.f15124c.f15138f.setData(this.f15128g, false);
                this.f15124c.f15140h.setText(this.f15128g.getTitle());
                if (this.f15128g.J() != null) {
                    String name_show = this.f15128g.J().getName_show();
                    if (p0.d(name_show) > 10) {
                        name_show = p0.n(name_show, 10) + "...";
                    }
                    this.f15124c.f15139g.setText(name_show);
                }
                String str = this.f15128g.p1().label_name;
                if (this.f15130i && !StringUtils.isNull(str)) {
                    this.f15124c.f15135c.setText(str);
                    this.f15124c.f15135c.setVisibility(0);
                } else {
                    this.f15124c.f15135c.setVisibility(8);
                }
                if (eVar.f14760j) {
                    this.f15124c.f15141i.setText(this.f15123b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f15128g.p1().distance / 1000.0d))));
                    this.f15124c.f15141i.setVisibility(0);
                } else {
                    this.f15124c.f15141i.setVisibility(8);
                }
                this.f15124c.f15139g.setOnClickListener(this.k);
                i(this.f15123b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f15124c.f15137e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f15124c.f15136d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15124c.f15139g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f15124c.f15140h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15124c.f15141i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f15129h = fVar;
        }
    }
}
