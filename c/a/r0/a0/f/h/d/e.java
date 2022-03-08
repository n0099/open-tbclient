package c.a.r0.a0.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.q0.c1.o0;
import c.a.q0.r.r.e2;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f14538b;

    /* renamed from: c  reason: collision with root package name */
    public c f14539c;

    /* renamed from: d  reason: collision with root package name */
    public View f14540d;

    /* renamed from: e  reason: collision with root package name */
    public int f14541e;

    /* renamed from: f  reason: collision with root package name */
    public String f14542f;

    /* renamed from: g  reason: collision with root package name */
    public e2 f14543g;

    /* renamed from: h  reason: collision with root package name */
    public f f14544h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14545i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f14546j;
    public View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14547e;

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
            this.f14547e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f14547e.f14543g == null || this.f14547e.f14543g.p1() == null || this.f14547e.f14544h == null) {
                        return;
                    }
                    this.f14547e.f14544h.a(this.f14547e.f14541e, this.f14547e.f14542f, this.f14547e.f14543g);
                    return;
                }
                n.K(this.f14547e.f14538b.getPageActivity(), this.f14547e.f14538b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14548e;

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
            this.f14548e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14548e.f14543g == null || this.f14548e.f14543g.J() == null || StringUtils.isNull(this.f14548e.f14543g.J().getUserId())) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(this.f14548e.f14543g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14548e.f14538b.getPageActivity()).createNormalConfig(g2, g2 == c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f14548e.f14543g.J().isBigV())));
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f14549b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14550c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14551d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f14552e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f14553f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f14554g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f14555h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f14556i;

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
            this.f14549b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f14550c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f14551d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f14552e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f14553f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f14554g = (TextView) view.findViewById(R.id.tvUserName);
            this.f14555h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f14556i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f14546j);
            this.f14549b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14549b.setDrawerType(0);
            this.f14553f.setIsRound(true);
            this.f14553f.setDrawBorder(true);
            this.f14553f.setBorderColor(eVar.f14538b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f14553f.setBorderWidth(eVar.f14538b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f14553f.setIsGod(false);
            this.f14553f.setIsBigV(false);
            this.f14553f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14552e.getLayoutParams();
            int k = (n.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f14552e.setLayoutParams(layoutParams);
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
        this.f14546j = new a(this);
        this.k = new b(this);
        this.f14538b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f14540d = inflate;
        this.f14539c = new c(this, inflate);
        this.f14545i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14540d : (View) invokeV.objValue;
    }

    public void h(c.a.r0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14173h) != null && e2Var.p1() != null) {
                g().setVisibility(0);
                this.f14543g = eVar.f14173h;
                this.f14541e = eVar.f14170e;
                this.f14542f = !TextUtils.isEmpty(eVar.f14172g) ? eVar.f14172g : eVar.f14171f;
                this.f14539c.f14549b.setDrawerType(0);
                this.f14539c.f14549b.setBorderSurroundContent(true);
                this.f14539c.f14549b.setDrawBorder(true);
                this.f14539c.f14549b.startLoad(this.f14543g.p1().cover, 10, false);
                this.f14539c.f14551d.setText(this.f14538b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f14543g.p1().audience_count)));
                this.f14539c.f14553f.setData(this.f14543g, false);
                this.f14539c.f14555h.setText(this.f14543g.getTitle());
                if (this.f14543g.J() != null) {
                    String name_show = this.f14543g.J().getName_show();
                    if (o0.d(name_show) > 10) {
                        name_show = o0.n(name_show, 10) + "...";
                    }
                    this.f14539c.f14554g.setText(name_show);
                }
                String str = this.f14543g.p1().label_name;
                if (this.f14545i && !StringUtils.isNull(str)) {
                    this.f14539c.f14550c.setText(str);
                    this.f14539c.f14550c.setVisibility(0);
                } else {
                    this.f14539c.f14550c.setVisibility(8);
                }
                if (eVar.f14175j) {
                    this.f14539c.f14556i.setText(this.f14538b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f14543g.p1().distance / 1000.0d))));
                    this.f14539c.f14556i.setVisibility(0);
                } else {
                    this.f14539c.f14556i.setVisibility(8);
                }
                this.f14539c.f14554g.setOnClickListener(this.k);
                i(this.f14538b, TbadkCoreApplication.getInst().getSkinType());
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
        SkinManager.setBackgroundResource(this.f14539c.f14552e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f14539c.f14551d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14539c.f14554g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f14539c.f14555h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14539c.f14556i, (int) R.color.CAM_X0109);
        this.a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14544h = fVar;
        }
    }
}
