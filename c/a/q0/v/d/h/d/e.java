package c.a.q0.v.d.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.b1.l0;
import c.a.p0.s.q.c2;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25433a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25434b;

    /* renamed from: c  reason: collision with root package name */
    public c f25435c;

    /* renamed from: d  reason: collision with root package name */
    public View f25436d;

    /* renamed from: e  reason: collision with root package name */
    public int f25437e;

    /* renamed from: f  reason: collision with root package name */
    public String f25438f;

    /* renamed from: g  reason: collision with root package name */
    public c2 f25439g;

    /* renamed from: h  reason: collision with root package name */
    public f f25440h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25441i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25442j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25443e;

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
            this.f25443e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25443e.f25439g == null || this.f25443e.f25439g.j1() == null || this.f25443e.f25440h == null) {
                        return;
                    }
                    this.f25443e.f25440h.a(this.f25443e.f25437e, this.f25443e.f25438f, this.f25443e.f25439g);
                    return;
                }
                l.J(this.f25443e.f25434b.getPageActivity(), this.f25443e.f25434b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25444e;

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
            this.f25444e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25444e.f25439g == null || this.f25444e.f25439g.J() == null || StringUtils.isNull(this.f25444e.f25439g.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25444e.f25439g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25444e.f25434b.getPageActivity()).createNormalConfig(f2, f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25444e.f25439g.J().isBigV())));
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25445a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25446b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25447c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25448d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25449e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25450f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25451g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25452h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25453i;

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
            this.f25445a = view;
            this.f25446b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25447c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25448d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25449e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25450f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25451g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25452h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25453i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f25442j);
            this.f25446b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25446b.setDrawerType(0);
            this.f25450f.setIsRound(true);
            this.f25450f.setDrawBorder(true);
            this.f25450f.setBorderColor(eVar.f25434b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25450f.setBorderWidth(eVar.f25434b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25450f.setIsGod(false);
            this.f25450f.setIsBigV(false);
            this.f25450f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25449e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f25449e.setLayoutParams(layoutParams);
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
        this.f25433a = 3;
        this.f25442j = new a(this);
        this.k = new b(this);
        this.f25434b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f25436d = inflate;
        this.f25435c = new c(this, inflate);
        this.f25441i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25436d : (View) invokeV.objValue;
    }

    public void h(c.a.q0.v.d.a.c cVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (c2Var = cVar.f24991h) != null && c2Var.j1() != null) {
                g().setVisibility(0);
                this.f25439g = cVar.f24991h;
                this.f25437e = cVar.f24988e;
                this.f25438f = !TextUtils.isEmpty(cVar.f24990g) ? cVar.f24990g : cVar.f24989f;
                this.f25435c.f25446b.setDrawerType(0);
                this.f25435c.f25446b.setBorderSurroundContent(true);
                this.f25435c.f25446b.setDrawBorder(true);
                this.f25435c.f25446b.startLoad(this.f25439g.j1().cover, 10, false);
                this.f25435c.f25448d.setText(this.f25434b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f25439g.j1().audience_count)));
                this.f25435c.f25450f.setData(this.f25439g, false);
                this.f25435c.f25452h.setText(this.f25439g.getTitle());
                if (this.f25439g.J() != null) {
                    String name_show = this.f25439g.J().getName_show();
                    if (l0.d(name_show) > 10) {
                        name_show = l0.m(name_show, 10) + "...";
                    }
                    this.f25435c.f25451g.setText(name_show);
                }
                String str = this.f25439g.j1().label_name;
                if (this.f25441i && !StringUtils.isNull(str)) {
                    this.f25435c.f25447c.setText(str);
                    this.f25435c.f25447c.setVisibility(0);
                } else {
                    this.f25435c.f25447c.setVisibility(8);
                }
                if (cVar.f24992i) {
                    this.f25435c.f25453i.setText(this.f25434b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f25439g.j1().distance / 1000.0d))));
                    this.f25435c.f25453i.setVisibility(0);
                } else {
                    this.f25435c.f25453i.setVisibility(8);
                }
                this.f25435c.f25451g.setOnClickListener(this.k);
                i(this.f25434b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25433a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25435c.f25449e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25435c.f25448d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25435c.f25451g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25435c.f25452h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25435c.f25453i, R.color.CAM_X0109);
        this.f25433a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f25440h = fVar;
        }
    }
}
