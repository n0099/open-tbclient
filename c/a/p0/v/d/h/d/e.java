package c.a.p0.v.d.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.o0.b1.l0;
import c.a.o0.s.q.c2;
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
    public int f25100a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25101b;

    /* renamed from: c  reason: collision with root package name */
    public c f25102c;

    /* renamed from: d  reason: collision with root package name */
    public View f25103d;

    /* renamed from: e  reason: collision with root package name */
    public int f25104e;

    /* renamed from: f  reason: collision with root package name */
    public String f25105f;

    /* renamed from: g  reason: collision with root package name */
    public c2 f25106g;

    /* renamed from: h  reason: collision with root package name */
    public f f25107h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25108i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25109j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25110e;

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
            this.f25110e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25110e.f25106g == null || this.f25110e.f25106g.j1() == null || this.f25110e.f25107h == null) {
                        return;
                    }
                    this.f25110e.f25107h.a(this.f25110e.f25104e, this.f25110e.f25105f, this.f25110e.f25106g);
                    return;
                }
                l.J(this.f25110e.f25101b.getPageActivity(), this.f25110e.f25101b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25111e;

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
            this.f25111e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25111e.f25106g == null || this.f25111e.f25106g.J() == null || StringUtils.isNull(this.f25111e.f25106g.J().getUserId())) {
                return;
            }
            long f2 = c.a.e.e.m.b.f(this.f25111e.f25106g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25111e.f25101b.getPageActivity()).createNormalConfig(f2, f2 == c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25111e.f25106g.J().isBigV())));
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25112a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25113b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25114c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25115d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25116e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25117f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25118g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25119h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25120i;

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
            this.f25112a = view;
            this.f25113b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25114c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25115d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25116e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25117f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25118g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25119h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25120i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f25109j);
            this.f25113b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25113b.setDrawerType(0);
            this.f25117f.setIsRound(true);
            this.f25117f.setDrawBorder(true);
            this.f25117f.setBorderColor(eVar.f25101b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25117f.setBorderWidth(eVar.f25101b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25117f.setIsGod(false);
            this.f25117f.setIsBigV(false);
            this.f25117f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25116e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f25116e.setLayoutParams(layoutParams);
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
        this.f25100a = 3;
        this.f25109j = new a(this);
        this.k = new b(this);
        this.f25101b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f25103d = inflate;
        this.f25102c = new c(this, inflate);
        this.f25108i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25103d : (View) invokeV.objValue;
    }

    public void h(c.a.p0.v.d.a.c cVar) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (c2Var = cVar.f24658h) != null && c2Var.j1() != null) {
                g().setVisibility(0);
                this.f25106g = cVar.f24658h;
                this.f25104e = cVar.f24655e;
                this.f25105f = !TextUtils.isEmpty(cVar.f24657g) ? cVar.f24657g : cVar.f24656f;
                this.f25102c.f25113b.setDrawerType(0);
                this.f25102c.f25113b.setBorderSurroundContent(true);
                this.f25102c.f25113b.setDrawBorder(true);
                this.f25102c.f25113b.startLoad(this.f25106g.j1().cover, 10, false);
                this.f25102c.f25115d.setText(this.f25101b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f25106g.j1().audience_count)));
                this.f25102c.f25117f.setData(this.f25106g, false);
                this.f25102c.f25119h.setText(this.f25106g.getTitle());
                if (this.f25106g.J() != null) {
                    String name_show = this.f25106g.J().getName_show();
                    if (l0.d(name_show) > 10) {
                        name_show = l0.m(name_show, 10) + "...";
                    }
                    this.f25102c.f25118g.setText(name_show);
                }
                String str = this.f25106g.j1().label_name;
                if (this.f25108i && !StringUtils.isNull(str)) {
                    this.f25102c.f25114c.setText(str);
                    this.f25102c.f25114c.setVisibility(0);
                } else {
                    this.f25102c.f25114c.setVisibility(8);
                }
                if (cVar.f24659i) {
                    this.f25102c.f25120i.setText(this.f25101b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f25106g.j1().distance / 1000.0d))));
                    this.f25102c.f25120i.setVisibility(0);
                } else {
                    this.f25102c.f25120i.setVisibility(8);
                }
                this.f25102c.f25118g.setOnClickListener(this.k);
                i(this.f25101b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25100a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25102c.f25116e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25102c.f25115d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25102c.f25118g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25102c.f25119h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25102c.f25120i, R.color.CAM_X0109);
        this.f25100a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f25107h = fVar;
        }
    }
}
