package c.a.u0.e1.a3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16122b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f16123c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f16124d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16125e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f16126f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f16127g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16128h;

    /* renamed from: i  reason: collision with root package name */
    public View f16129i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f16130j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f16131e;

        public a(g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16131e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f16131e;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(g1.frs_fake_view, (ViewGroup) null);
        this.a = inflate;
        this.f16122b = (RelativeLayout) inflate.findViewById(f1.head_top_bg_container);
        this.f16123c = (LinearGradientView) this.a.findViewById(f1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(f1.head_top_bg_mask);
        this.f16130j = tbImageView;
        tbImageView.setDefaultBgResource(c1.transparent);
        this.f16130j.setDefaultResource(e1.pic_frs_head_default);
        this.f16124d = (BarImageView) this.a.findViewById(f1.frs_image);
        TextView textView = (TextView) this.a.findViewById(f1.forum_name);
        this.f16125e = textView;
        SkinManager.setViewTextColor(textView, c1.CAM_X0101);
        this.f16126f = (FrsHeaderBannerView) this.a.findViewById(f1.frs_header_banner);
        this.f16127g = (LinearLayout) this.a.findViewById(f1.fake_content_layout);
        this.f16128h = (ImageView) this.a.findViewById(f1.fake_content_img);
        this.f16129i = this.a.findViewById(f1.header_round_corner_layout);
        this.k = (ImageView) this.a.findViewById(f1.fake_return_icon);
        this.l = (ImageView) this.a.findViewById(f1.fake_share_icon);
        this.m = (ImageView) this.a.findViewById(f1.fake_information_icon);
        this.n = (ImageView) this.a.findViewById(f1.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f16124d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f16124d.setContentDescription(context.getResources().getString(i1.bar_header));
        this.f16124d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f16124d.setShowOval(true);
        this.f16124d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
        this.f16124d.setStrokeColorResId(c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, c1.CAM_X0201);
        SkinManager.setBackgroundResource(this.f16129i, e1.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f16128h, c1.CAM_X0201);
        SkinManager.setImageResource(this.k, e1.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16128h, e1.bg_pure_loadingskeleton_svg, c1.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
