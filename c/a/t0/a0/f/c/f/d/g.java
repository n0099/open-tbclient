package c.a.t0.a0.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.q.e2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f14631b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f14632c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14633d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14634e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14635f;

    /* renamed from: g  reason: collision with root package name */
    public i f14636g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.a0.f.a.e f14637h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f14638i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14639e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14639e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    if (this.f14639e.f14637h == null || this.f14639e.f14637h.f14484h == null || view != this.f14639e.f14631b || this.f14639e.f14636g == null) {
                        return;
                    }
                    this.f14639e.f14636g.a(this.f14639e.f14637h);
                    return;
                }
                n.K(this.f14639e.a.getPageActivity(), this.f14639e.a.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14638i = new a(this);
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f14631b = inflate;
        this.f14635f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f14632c = (HeadImageView) this.f14631b.findViewById(R.id.iv_anchor_avatar);
        this.f14633d = (TextView) this.f14631b.findViewById(R.id.tv_anchor_name);
        this.f14634e = (TextView) this.f14631b.findViewById(R.id.tv_live_aud_num);
        this.f14631b.setOnClickListener(this.f14638i);
        this.f14632c.setBorderWidth(n.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f14632c.setIsRound(true);
        this.f14632c.setPlaceHolder(1);
        this.f14632c.setAutoChangeStyle(true);
        this.f14632c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14635f.setLayoutParams(new LinearLayout.LayoutParams((n.k(this.a.getPageActivity()) - (this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14631b : (View) invokeV.objValue;
    }

    public void f(c.a.t0.a0.f.a.e eVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (e2Var = eVar.f14484h) != null && e2Var.J() != null) {
                e().setVisibility(0);
                this.f14637h = eVar;
                eVar.f14484h.J().getUserId();
                this.f14632c.startLoad(eVar.f14484h.J().getPortrait(), 25, false, false);
                String name_show = eVar.f14484h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (m.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f14633d.setText(name_show);
                }
                if (eVar.f14484h.p1() != null) {
                    this.f14634e.setText(String.format(this.a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(eVar.f14484h.p1().audience_count)));
                }
                g(this.a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f14633d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14634e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f14632c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f14632c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f14634e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14634e.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f14636g = iVar;
        }
    }
}
