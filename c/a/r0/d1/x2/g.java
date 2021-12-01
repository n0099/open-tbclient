package c.a.r0.d1.x2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
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
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16223b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f16224c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f16225d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16226e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f16227f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f16228g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16229h;

    /* renamed from: i  reason: collision with root package name */
    public View f16230i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f16231j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f16232k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f16233e;

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
            this.f16233e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f16233e;
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
        this.f16223b = (RelativeLayout) inflate.findViewById(f1.head_top_bg_container);
        this.f16224c = (LinearGradientView) this.a.findViewById(f1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(f1.head_top_bg_mask);
        this.f16231j = tbImageView;
        tbImageView.setDefaultBgResource(c1.transparent);
        this.f16231j.setDefaultResource(e1.pic_frs_head_default);
        this.f16225d = (BarImageView) this.a.findViewById(f1.frs_image);
        TextView textView = (TextView) this.a.findViewById(f1.forum_name);
        this.f16226e = textView;
        SkinManager.setViewTextColor(textView, c1.CAM_X0101);
        this.f16227f = (FrsHeaderBannerView) this.a.findViewById(f1.frs_header_banner);
        this.f16228g = (LinearLayout) this.a.findViewById(f1.fake_content_layout);
        this.f16229h = (ImageView) this.a.findViewById(f1.fake_content_img);
        this.f16230i = this.a.findViewById(f1.header_round_corner_layout);
        this.f16232k = (ImageView) this.a.findViewById(f1.fake_return_icon);
        this.l = (ImageView) this.a.findViewById(f1.fake_share_icon);
        this.m = (ImageView) this.a.findViewById(f1.fake_information_icon);
        this.n = (ImageView) this.a.findViewById(f1.fake_search_icon);
        this.f16232k.setOnClickListener(new a(this, context));
        this.f16225d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f16225d.setContentDescription(context.getResources().getString(i1.bar_header));
        this.f16225d.setStrokeWith(l.f(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f16225d.setShowOval(true);
        this.f16225d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
        this.f16225d.setStrokeColorResId(c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, c1.CAM_X0201);
        SkinManager.setBackgroundResource(this.f16230i, e1.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f16229h, c1.CAM_X0201);
        SkinManager.setImageResource(this.f16232k, e1.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16229h, e1.bg_pure_loadingskeleton_svg, c1.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
