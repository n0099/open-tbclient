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
import c.a.s0.d1.o0;
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
    public TbPageContext<?> f14849b;

    /* renamed from: c  reason: collision with root package name */
    public c f14850c;

    /* renamed from: d  reason: collision with root package name */
    public View f14851d;

    /* renamed from: e  reason: collision with root package name */
    public int f14852e;

    /* renamed from: f  reason: collision with root package name */
    public String f14853f;

    /* renamed from: g  reason: collision with root package name */
    public e2 f14854g;

    /* renamed from: h  reason: collision with root package name */
    public f f14855h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14856i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f14857j;
    public View.OnClickListener k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14858e;

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
            this.f14858e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f14858e.f14854g == null || this.f14858e.f14854g.p1() == null || this.f14858e.f14855h == null) {
                        return;
                    }
                    this.f14858e.f14855h.a(this.f14858e.f14852e, this.f14858e.f14853f, this.f14858e.f14854g);
                    return;
                }
                n.K(this.f14858e.f14849b.getPageActivity(), this.f14858e.f14849b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14859e;

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
            this.f14859e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14859e.f14854g == null || this.f14859e.f14854g.J() == null || StringUtils.isNull(this.f14859e.f14854g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14859e.f14854g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14859e.f14849b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14859e.f14854g.J().isBigV())));
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14860b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14861c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14862d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14863e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14864f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14865g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14866h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14867i;

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
            this.f14860b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14861c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14862d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14863e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14864f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14865g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14866h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14867i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f14857j);
            this.f14860b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14860b.setDrawerType(0);
            this.f14864f.setIsRound(true);
            this.f14864f.setDrawBorder(true);
            this.f14864f.setBorderColor(eVar.f14849b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14864f.setBorderWidth(eVar.f14849b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14864f.setIsGod(false);
            this.f14864f.setIsBigV(false);
            this.f14864f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14863e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f14863e.setLayoutParams(layoutParams);
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
        this.f14857j = new a(this);
        this.k = new b(this);
        this.f14849b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f14851d = inflate;
        this.f14850c = new c(this, inflate);
        this.f14856i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14851d : (View) invokeV.objValue;
    }

    public void h(c.a.t0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14484h) != null && e2Var.p1() != null) {
                g().setVisibility(0);
                this.f14854g = eVar.f14484h;
                this.f14852e = eVar.f14481e;
                this.f14853f = !TextUtils.isEmpty(eVar.f14483g) ? eVar.f14483g : eVar.f14482f;
                this.f14850c.f14860b.setDrawerType(0);
                this.f14850c.f14860b.setBorderSurroundContent(true);
                this.f14850c.f14860b.setDrawBorder(true);
                this.f14850c.f14860b.startLoad(this.f14854g.p1().cover, 10, false);
                this.f14850c.f14862d.setText(this.f14849b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f14854g.p1().audience_count)));
                this.f14850c.f14864f.setData(this.f14854g, false);
                this.f14850c.f14866h.setText(this.f14854g.getTitle());
                if (this.f14854g.J() != null) {
                    String name_show = this.f14854g.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + "...";
                    }
                    this.f14850c.f14865g.setText(name_show);
                }
                String str = this.f14854g.p1().label_name;
                if (this.f14856i && !StringUtils.isNull(str)) {
                    this.f14850c.f14861c.setText(str);
                    this.f14850c.f14861c.setVisibility(0);
                } else {
                    this.f14850c.f14861c.setVisibility(8);
                }
                if (eVar.f14486j) {
                    this.f14850c.f14867i.setText(this.f14849b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f14854g.p1().distance / 1000.0d))));
                    this.f14850c.f14867i.setVisibility(0);
                } else {
                    this.f14850c.f14867i.setVisibility(8);
                }
                this.f14850c.f14865g.setOnClickListener(this.k);
                i(this.f14849b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f14850c.f14863e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14850c.f14862d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14850c.f14865g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14850c.f14866h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14850c.f14867i, R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14855h = fVar;
        }
    }
}
