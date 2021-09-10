package c.a.r0.v.d.h.d;

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
    public int f25911a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f25912b;

    /* renamed from: c  reason: collision with root package name */
    public c f25913c;

    /* renamed from: d  reason: collision with root package name */
    public View f25914d;

    /* renamed from: e  reason: collision with root package name */
    public int f25915e;

    /* renamed from: f  reason: collision with root package name */
    public String f25916f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f25917g;

    /* renamed from: h  reason: collision with root package name */
    public f f25918h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25919i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25920j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25921e;

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
            this.f25921e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f25921e.f25917g == null || this.f25921e.f25917g.l1() == null || this.f25921e.f25918h == null) {
                        return;
                    }
                    this.f25921e.f25918h.a(this.f25921e.f25915e, this.f25921e.f25916f, this.f25921e.f25917g);
                    return;
                }
                l.J(this.f25921e.f25912b.getPageActivity(), this.f25921e.f25912b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f25922e;

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
            this.f25922e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f25922e.f25917g == null || this.f25922e.f25917g.J() == null || StringUtils.isNull(this.f25922e.f25917g.J().getUserId())) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(this.f25922e.f25917g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f25922e.f25912b.getPageActivity()).createNormalConfig(g2, g2 == c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f25922e.f25917g.J().isBigV())));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f25923a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f25924b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25925c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25926d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f25927e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f25928f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f25929g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f25930h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f25931i;

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
            this.f25923a = view;
            this.f25924b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f25925c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f25926d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f25927e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f25928f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f25929g = (TextView) view.findViewById(R.id.tvUserName);
            this.f25930h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f25931i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.f25920j);
            this.f25924b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f25924b.setDrawerType(0);
            this.f25928f.setIsRound(true);
            this.f25928f.setDrawBorder(true);
            this.f25928f.setBorderColor(eVar.f25912b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f25928f.setBorderWidth(eVar.f25912b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f25928f.setIsGod(false);
            this.f25928f.setIsBigV(false);
            this.f25928f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25927e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f25927e.setLayoutParams(layoutParams);
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
        this.f25911a = 3;
        this.f25920j = new a(this);
        this.k = new b(this);
        this.f25912b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f25914d = inflate;
        this.f25913c = new c(this, inflate);
        this.f25919i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25914d : (View) invokeV.objValue;
    }

    public void h(c.a.r0.v.d.a.c cVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (d2Var = cVar.f25469h) != null && d2Var.l1() != null) {
                g().setVisibility(0);
                this.f25917g = cVar.f25469h;
                this.f25915e = cVar.f25466e;
                this.f25916f = !TextUtils.isEmpty(cVar.f25468g) ? cVar.f25468g : cVar.f25467f;
                this.f25913c.f25924b.setDrawerType(0);
                this.f25913c.f25924b.setBorderSurroundContent(true);
                this.f25913c.f25924b.setDrawBorder(true);
                this.f25913c.f25924b.startLoad(this.f25917g.l1().cover, 10, false);
                this.f25913c.f25926d.setText(this.f25912b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f25917g.l1().audience_count)));
                this.f25913c.f25928f.setData(this.f25917g, false);
                this.f25913c.f25930h.setText(this.f25917g.getTitle());
                if (this.f25917g.J() != null) {
                    String name_show = this.f25917g.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f25913c.f25929g.setText(name_show);
                }
                String str = this.f25917g.l1().label_name;
                if (this.f25919i && !StringUtils.isNull(str)) {
                    this.f25913c.f25925c.setText(str);
                    this.f25913c.f25925c.setVisibility(0);
                } else {
                    this.f25913c.f25925c.setVisibility(8);
                }
                if (cVar.f25470i) {
                    this.f25913c.f25931i.setText(this.f25912b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f25917g.l1().distance / 1000.0d))));
                    this.f25913c.f25931i.setVisibility(0);
                } else {
                    this.f25913c.f25931i.setVisibility(8);
                }
                this.f25913c.f25929g.setOnClickListener(this.k);
                i(this.f25912b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f25911a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f25913c.f25927e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f25913c.f25926d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25913c.f25929g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f25913c.f25930h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f25913c.f25931i, R.color.CAM_X0109);
        this.f25911a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f25918h = fVar;
        }
    }
}
