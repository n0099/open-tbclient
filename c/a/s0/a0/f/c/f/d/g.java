package c.a.s0.a0.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
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
    public View f14347b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f14348c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14349d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14350e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14351f;

    /* renamed from: g  reason: collision with root package name */
    public i f14352g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.a0.f.a.e f14353h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f14354i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14355e;

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
            this.f14355e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (k.z()) {
                    if (this.f14355e.f14353h == null || this.f14355e.f14353h.f14193h == null || view != this.f14355e.f14347b || this.f14355e.f14352g == null) {
                        return;
                    }
                    this.f14355e.f14352g.a(this.f14355e.f14353h);
                    return;
                }
                m.J(this.f14355e.a.getPageActivity(), this.f14355e.a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f14354i = new a(this);
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f14347b = inflate;
        this.f14351f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f14348c = (HeadImageView) this.f14347b.findViewById(R.id.iv_anchor_avatar);
        this.f14349d = (TextView) this.f14347b.findViewById(R.id.tv_anchor_name);
        this.f14350e = (TextView) this.f14347b.findViewById(R.id.tv_live_aud_num);
        this.f14347b.setOnClickListener(this.f14354i);
        this.f14348c.setBorderWidth(m.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f14348c.setIsRound(true);
        this.f14348c.setPlaceHolder(1);
        this.f14348c.setAutoChangeStyle(true);
        this.f14348c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14351f.setLayoutParams(new LinearLayout.LayoutParams((m.k(this.a.getPageActivity()) - (this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14347b : (View) invokeV.objValue;
    }

    public void f(c.a.s0.a0.f.a.e eVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (eVar != null && (d2Var = eVar.f14193h) != null && d2Var.J() != null) {
                e().setVisibility(0);
                this.f14353h = eVar;
                eVar.f14193h.J().getUserId();
                this.f14348c.startLoad(eVar.f14193h.J().getPortrait(), 25, false, false);
                String name_show = eVar.f14193h.J().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (l.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, "...");
                    }
                    this.f14349d.setText(name_show);
                }
                if (eVar.f14193h.o1() != null) {
                    this.f14350e.setText(String.format(this.a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(eVar.f14193h.o1().audience_count)));
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
            SkinManager.setViewTextColor(this.f14349d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f14350e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f14348c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f14348c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f14350e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f14350e.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f14352g = iVar;
        }
    }
}
