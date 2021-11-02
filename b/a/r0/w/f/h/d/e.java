package b.a.r0.w.f.h.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
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
    public int f24939a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f24940b;

    /* renamed from: c  reason: collision with root package name */
    public c f24941c;

    /* renamed from: d  reason: collision with root package name */
    public View f24942d;

    /* renamed from: e  reason: collision with root package name */
    public int f24943e;

    /* renamed from: f  reason: collision with root package name */
    public String f24944f;

    /* renamed from: g  reason: collision with root package name */
    public d2 f24945g;

    /* renamed from: h  reason: collision with root package name */
    public f f24946h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24947i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f24948e;

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
            this.f24948e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f24948e.f24945g == null || this.f24948e.f24945g.l1() == null || this.f24948e.f24946h == null) {
                        return;
                    }
                    this.f24948e.f24946h.a(this.f24948e.f24943e, this.f24948e.f24944f, this.f24948e.f24945g);
                    return;
                }
                l.J(this.f24948e.f24940b.getPageActivity(), this.f24948e.f24940b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f24949e;

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
            this.f24949e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24949e.f24945g == null || this.f24949e.f24945g.J() == null || StringUtils.isNull(this.f24949e.f24945g.J().getUserId())) {
                return;
            }
            long g2 = b.a.e.e.m.b.g(this.f24949e.f24945g.J().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f24949e.f24940b.getPageActivity()).createNormalConfig(g2, g2 == b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f24949e.f24945g.J().isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f24950a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f24951b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24952c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f24953d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f24954e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f24955f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f24956g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f24957h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f24958i;

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
            this.f24950a = view;
            this.f24951b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f24952c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f24953d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f24954e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f24955f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f24956g = (TextView) view.findViewById(R.id.tvUserName);
            this.f24957h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f24958i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f24951b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f24951b.setDrawerType(0);
            this.f24955f.setIsRound(true);
            this.f24955f.setDrawBorder(true);
            this.f24955f.setBorderColor(eVar.f24940b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f24955f.setBorderWidth(eVar.f24940b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f24955f.setIsGod(false);
            this.f24955f.setIsBigV(false);
            this.f24955f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24954e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f24954e.setLayoutParams(layoutParams);
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
        this.f24939a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f24940b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f24942d = inflate;
        this.f24941c = new c(this, inflate);
        this.f24947i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24942d : (View) invokeV.objValue;
    }

    public void h(b.a.r0.w.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f24510h) != null && d2Var.l1() != null) {
                g().setVisibility(0);
                this.f24945g = eVar.f24510h;
                this.f24943e = eVar.f24507e;
                this.f24944f = !TextUtils.isEmpty(eVar.f24509g) ? eVar.f24509g : eVar.f24508f;
                this.f24941c.f24951b.setDrawerType(0);
                this.f24941c.f24951b.setBorderSurroundContent(true);
                this.f24941c.f24951b.setDrawBorder(true);
                this.f24941c.f24951b.startLoad(this.f24945g.l1().cover, 10, false);
                this.f24941c.f24953d.setText(this.f24940b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f24945g.l1().audience_count)));
                this.f24941c.f24955f.setData(this.f24945g, false);
                this.f24941c.f24957h.setText(this.f24945g.getTitle());
                if (this.f24945g.J() != null) {
                    String name_show = this.f24945g.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.f24941c.f24956g.setText(name_show);
                }
                String str = this.f24945g.l1().label_name;
                if (this.f24947i && !StringUtils.isNull(str)) {
                    this.f24941c.f24952c.setText(str);
                    this.f24941c.f24952c.setVisibility(0);
                } else {
                    this.f24941c.f24952c.setVisibility(8);
                }
                if (eVar.j) {
                    this.f24941c.f24958i.setText(this.f24940b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f24945g.l1().distance / 1000.0d))));
                    this.f24941c.f24958i.setVisibility(0);
                } else {
                    this.f24941c.f24958i.setVisibility(8);
                }
                this.f24941c.f24956g.setOnClickListener(this.k);
                i(this.f24940b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f24939a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f24941c.f24954e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f24941c.f24953d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f24941c.f24956g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f24941c.f24957h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f24941c.f24958i, R.color.CAM_X0109);
        this.f24939a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f24946h = fVar;
        }
    }
}
