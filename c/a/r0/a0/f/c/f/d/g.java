package c.a.r0.a0.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.j;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f14007b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f14008c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14009d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14010e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14011f;

    /* renamed from: g  reason: collision with root package name */
    public i f14012g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.a0.f.a.e f14013h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f14014i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14015e;

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
            this.f14015e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f14015e.f14013h == null || this.f14015e.f14013h.f13853h == null || view != this.f14015e.f14007b || this.f14015e.f14012g == null) {
                        return;
                    }
                    this.f14015e.f14012g.a(this.f14015e.f14013h);
                    return;
                }
                l.J(this.f14015e.a.getPageActivity(), this.f14015e.a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f14014i = new a(this);
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f14007b = inflate;
        this.f14011f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f14008c = (HeadImageView) this.f14007b.findViewById(R.id.iv_anchor_avatar);
        this.f14009d = (TextView) this.f14007b.findViewById(R.id.tv_anchor_name);
        this.f14010e = (TextView) this.f14007b.findViewById(R.id.tv_live_aud_num);
        this.f14007b.setOnClickListener(this.f14014i);
        this.f14008c.setBorderWidth(l.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f14008c.setIsRound(true);
        this.f14008c.setPlaceHolder(1);
        this.f14008c.setAutoChangeStyle(true);
        this.f14008c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14011f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.a.getPageActivity()) - (this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14007b : (View) invokeV.objValue;
    }

    public void f(c.a.r0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f13853h) != null && d2Var.J() != null) {
                e().setVisibility(0);
                this.f14013h = eVar;
                eVar.f13853h.J().getUserId();
                this.f14008c.startLoad(eVar.f13853h.J().getPortrait(), 25, false, false);
                String name_show = eVar.f13853h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f14009d.setText(name_show);
                }
                if (eVar.f13853h.o1() != null) {
                    this.f14010e.setText(String.format(this.a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(eVar.f13853h.o1().audience_count)));
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
            SkinManager.setViewTextColor(this.f14009d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14010e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f14008c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f14008c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f14010e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14010e.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f14012g = iVar;
        }
    }
}
