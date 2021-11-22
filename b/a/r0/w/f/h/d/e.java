package b.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f26456a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f26457b;

    /* renamed from: c  reason: collision with root package name */
    public c f26458c;

    /* renamed from: d  reason: collision with root package name */
    public View f26459d;

    /* renamed from: e  reason: collision with root package name */
    public int f26460e;

    /* renamed from: f  reason: collision with root package name */
    public String f26461f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f26462g;

    /* renamed from: h  reason: collision with root package name */
    public f f26463h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26464i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26465e;

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
            this.f26465e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f26465e.f26462g == null || this.f26465e.f26462g.m1() == null || this.f26465e.f26463h == null) {
                        return;
                    }
                    this.f26465e.f26463h.a(this.f26465e.f26460e, this.f26465e.f26461f, this.f26465e.f26462g);
                    return;
                }
                l.J(this.f26465e.f26457b.getPageActivity(), this.f26465e.f26457b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26466e;

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
            this.f26466e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26466e.f26462g == null || this.f26466e.f26462g.J() == null || StringUtils.isNull(this.f26466e.f26462g.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.f.m.b.g(this.f26466e.f26462g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f26466e.f26457b.getPageActivity()).createNormalConfig(g2, g2 == b.a.e.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f26466e.f26462g.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f26467a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f26468b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f26469c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f26470d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f26471e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f26472f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f26473g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f26474h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f26475i;

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
            this.f26467a = view;
            this.f26468b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f26469c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f26470d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f26471e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f26472f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f26473g = (TextView) view.findViewById(R.id.tvUserName);
            this.f26474h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f26475i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f26468b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26468b.setDrawerType(0);
            this.f26472f.setIsRound(true);
            this.f26472f.setDrawBorder(true);
            this.f26472f.setBorderColor(eVar.f26457b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f26472f.setBorderWidth(eVar.f26457b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f26472f.setIsGod(false);
            this.f26472f.setIsBigV(false);
            this.f26472f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26471e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f26471e.setLayoutParams(layoutParams);
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
        this.f26456a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f26457b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f26459d = inflate;
        this.f26458c = new c(this, inflate);
        this.f26464i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26459d : (View) invokeV.objValue;
    }

    public void h(b.a.r0.w.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f26027h) != null && d2Var.m1() != null) {
                g().setVisibility(0);
                this.f26462g = eVar.f26027h;
                this.f26460e = eVar.f26024e;
                this.f26461f = !TextUtils.isEmpty(eVar.f26026g) ? eVar.f26026g : eVar.f26025f;
                this.f26458c.f26468b.setDrawerType(0);
                this.f26458c.f26468b.setBorderSurroundContent(true);
                this.f26458c.f26468b.setDrawBorder(true);
                this.f26458c.f26468b.startLoad(this.f26462g.m1().cover, 10, false);
                this.f26458c.f26470d.setText(this.f26457b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f26462g.m1().audience_count)));
                this.f26458c.f26472f.setData(this.f26462g, false);
                this.f26458c.f26474h.setText(this.f26462g.getTitle());
                if (this.f26462g.J() != null) {
                    String name_show = this.f26462g.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f26458c.f26473g.setText(name_show);
                }
                String str = this.f26462g.m1().label_name;
                if (this.f26464i && !StringUtils.isNull(str)) {
                    this.f26458c.f26469c.setText(str);
                    this.f26458c.f26469c.setVisibility(0);
                } else {
                    this.f26458c.f26469c.setVisibility(8);
                }
                if (eVar.j) {
                    this.f26458c.f26475i.setText(this.f26457b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f26462g.m1().distance / 1000.0d))));
                    this.f26458c.f26475i.setVisibility(0);
                } else {
                    this.f26458c.f26475i.setVisibility(8);
                }
                this.f26458c.f26473g.setOnClickListener(this.k);
                i(this.f26457b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f26456a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f26458c.f26471e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f26458c.f26470d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26458c.f26473g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f26458c.f26474h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f26458c.f26475i, R.color.CAM_X0109);
        this.f26456a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f26463h = fVar;
        }
    }
}
