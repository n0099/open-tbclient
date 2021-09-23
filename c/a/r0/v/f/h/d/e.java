package c.a.r0.v.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.d1.n0;
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
    public int f25934a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25935b;

    /* renamed from: c  reason: collision with root package name */
    public c f25936c;

    /* renamed from: d  reason: collision with root package name */
    public View f25937d;

    /* renamed from: e  reason: collision with root package name */
    public int f25938e;

    /* renamed from: f  reason: collision with root package name */
    public String f25939f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f25940g;

    /* renamed from: h  reason: collision with root package name */
    public f f25941h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25942i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25943j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25944e;

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
            this.f25944e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25944e.f25940g == null || this.f25944e.f25940g.l1() == null || this.f25944e.f25941h == null) {
                        return;
                    }
                    this.f25944e.f25941h.a(this.f25944e.f25938e, this.f25944e.f25939f, this.f25944e.f25940g);
                    return;
                }
                l.J(this.f25944e.f25935b.getPageActivity(), this.f25944e.f25935b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25945e;

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
            this.f25945e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25945e.f25940g == null || this.f25945e.f25940g.J() == null || StringUtils.isNull(this.f25945e.f25940g.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f25945e.f25940g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25945e.f25935b.getPageActivity()).createNormalConfig(g2, g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25945e.f25940g.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25946a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25947b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25948c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25949d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25950e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25951f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25952g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25953h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25954i;

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
            this.f25946a = view;
            this.f25947b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25948c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25949d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25950e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25951f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25952g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25953h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25954i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f25943j);
            this.f25947b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25947b.setDrawerType(0);
            this.f25951f.setIsRound(true);
            this.f25951f.setDrawBorder(true);
            this.f25951f.setBorderColor(eVar.f25935b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25951f.setBorderWidth(eVar.f25935b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25951f.setIsGod(false);
            this.f25951f.setIsBigV(false);
            this.f25951f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25950e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f25950e.setLayoutParams(layoutParams);
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
        this.f25934a = 3;
        this.f25943j = new a(this);
        this.k = new b(this);
        this.f25935b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f25937d = inflate;
        this.f25936c = new c(this, inflate);
        this.f25942i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25937d : (View) invokeV.objValue;
    }

    public void h(c.a.r0.v.f.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25492h) != null && d2Var.l1() != null) {
                g().setVisibility(0);
                this.f25940g = cVar.f25492h;
                this.f25938e = cVar.f25489e;
                this.f25939f = !TextUtils.isEmpty(cVar.f25491g) ? cVar.f25491g : cVar.f25490f;
                this.f25936c.f25947b.setDrawerType(0);
                this.f25936c.f25947b.setBorderSurroundContent(true);
                this.f25936c.f25947b.setDrawBorder(true);
                this.f25936c.f25947b.startLoad(this.f25940g.l1().cover, 10, false);
                this.f25936c.f25949d.setText(this.f25935b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f25940g.l1().audience_count)));
                this.f25936c.f25951f.setData(this.f25940g, false);
                this.f25936c.f25953h.setText(this.f25940g.getTitle());
                if (this.f25940g.J() != null) {
                    String name_show = this.f25940g.J().getName_show();
                    if (n0.d(name_show) > 10) {
                        name_show = n0.m(name_show, 10) + "...";
                    }
                    this.f25936c.f25952g.setText(name_show);
                }
                String str = this.f25940g.l1().label_name;
                if (this.f25942i && !StringUtils.isNull(str)) {
                    this.f25936c.f25948c.setText(str);
                    this.f25936c.f25948c.setVisibility(0);
                } else {
                    this.f25936c.f25948c.setVisibility(8);
                }
                if (cVar.f25493i) {
                    this.f25936c.f25954i.setText(this.f25935b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f25940g.l1().distance / 1000.0d))));
                    this.f25936c.f25954i.setVisibility(0);
                } else {
                    this.f25936c.f25954i.setVisibility(8);
                }
                this.f25936c.f25952g.setOnClickListener(this.k);
                i(this.f25935b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25934a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25936c.f25950e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25936c.f25949d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25936c.f25952g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25936c.f25953h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25936c.f25954i, R.color.CAM_X0109);
        this.f25934a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f25941h = fVar;
        }
    }
}
