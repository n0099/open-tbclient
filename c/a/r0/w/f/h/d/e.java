package c.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f26109a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f26110b;

    /* renamed from: c  reason: collision with root package name */
    public c f26111c;

    /* renamed from: d  reason: collision with root package name */
    public View f26112d;

    /* renamed from: e  reason: collision with root package name */
    public int f26113e;

    /* renamed from: f  reason: collision with root package name */
    public String f26114f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f26115g;

    /* renamed from: h  reason: collision with root package name */
    public f f26116h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26117i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f26118j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26119e;

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
            this.f26119e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26119e.f26115g == null || this.f26119e.f26115g.l1() == null || this.f26119e.f26116h == null) {
                        return;
                    }
                    this.f26119e.f26116h.a(this.f26119e.f26113e, this.f26119e.f26114f, this.f26119e.f26115g);
                    return;
                }
                l.J(this.f26119e.f26110b.getPageActivity(), this.f26119e.f26110b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26120e;

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
            this.f26120e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26120e.f26115g == null || this.f26120e.f26115g.J() == null || StringUtils.isNull(this.f26120e.f26115g.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f26120e.f26115g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26120e.f26110b.getPageActivity()).createNormalConfig(g2, g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f26120e.f26115g.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26121a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26122b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26123c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26124d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26125e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26126f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26127g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26128h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f26129i;

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
            this.f26121a = view;
            this.f26122b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26123c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26124d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26125e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26126f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26127g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26128h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f26129i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f26118j);
            this.f26122b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26122b.setDrawerType(0);
            this.f26126f.setIsRound(true);
            this.f26126f.setDrawBorder(true);
            this.f26126f.setBorderColor(eVar.f26110b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f26126f.setBorderWidth(eVar.f26110b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f26126f.setIsGod(false);
            this.f26126f.setIsBigV(false);
            this.f26126f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26125e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f26125e.setLayoutParams(layoutParams);
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
        this.f26109a = 3;
        this.f26118j = new a(this);
        this.k = new b(this);
        this.f26110b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f26112d = inflate;
        this.f26111c = new c(this, inflate);
        this.f26117i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26112d : (View) invokeV.objValue;
    }

    public void h(c.a.r0.w.f.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25667h) != null && d2Var.l1() != null) {
                g().setVisibility(0);
                this.f26115g = cVar.f25667h;
                this.f26113e = cVar.f25664e;
                this.f26114f = !TextUtils.isEmpty(cVar.f25666g) ? cVar.f25666g : cVar.f25665f;
                this.f26111c.f26122b.setDrawerType(0);
                this.f26111c.f26122b.setBorderSurroundContent(true);
                this.f26111c.f26122b.setDrawBorder(true);
                this.f26111c.f26122b.startLoad(this.f26115g.l1().cover, 10, false);
                this.f26111c.f26124d.setText(this.f26110b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f26115g.l1().audience_count)));
                this.f26111c.f26126f.setData(this.f26115g, false);
                this.f26111c.f26128h.setText(this.f26115g.getTitle());
                if (this.f26115g.J() != null) {
                    String name_show = this.f26115g.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f26111c.f26127g.setText(name_show);
                }
                String str = this.f26115g.l1().label_name;
                if (this.f26117i && !StringUtils.isNull(str)) {
                    this.f26111c.f26123c.setText(str);
                    this.f26111c.f26123c.setVisibility(0);
                } else {
                    this.f26111c.f26123c.setVisibility(8);
                }
                if (cVar.f25668i) {
                    this.f26111c.f26129i.setText(this.f26110b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f26115g.l1().distance / 1000.0d))));
                    this.f26111c.f26129i.setVisibility(0);
                } else {
                    this.f26111c.f26129i.setVisibility(8);
                }
                this.f26111c.f26127g.setOnClickListener(this.k);
                i(this.f26110b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26109a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26111c.f26125e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26111c.f26124d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26111c.f26127g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26111c.f26128h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26111c.f26129i, R.color.CAM_X0109);
        this.f26109a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f26116h = fVar;
        }
    }
}
