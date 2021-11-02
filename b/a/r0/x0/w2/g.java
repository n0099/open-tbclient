package b.a.r0.x0.w2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
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

    /* renamed from: a  reason: collision with root package name */
    public View f26550a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26551b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f26552c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f26553d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26554e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f26555f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f26556g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f26557h;

    /* renamed from: i  reason: collision with root package name */
    public View f26558i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f26559e;

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
            this.f26559e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f26559e;
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
        View inflate = LayoutInflater.from(context).inflate(f1.frs_fake_view, (ViewGroup) null);
        this.f26550a = inflate;
        this.f26551b = (RelativeLayout) inflate.findViewById(e1.head_top_bg_container);
        this.f26552c = (LinearGradientView) this.f26550a.findViewById(e1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f26550a.findViewById(e1.head_top_bg_mask);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(b1.transparent);
        this.j.setDefaultResource(d1.pic_frs_head_default);
        this.f26553d = (BarImageView) this.f26550a.findViewById(e1.frs_image);
        TextView textView = (TextView) this.f26550a.findViewById(e1.forum_name);
        this.f26554e = textView;
        SkinManager.setViewTextColor(textView, b1.CAM_X0101);
        this.f26555f = (FrsHeaderBannerView) this.f26550a.findViewById(e1.frs_header_banner);
        this.f26556g = (LinearLayout) this.f26550a.findViewById(e1.fake_content_layout);
        this.f26557h = (ImageView) this.f26550a.findViewById(e1.fake_content_img);
        this.f26558i = this.f26550a.findViewById(e1.header_round_corner_layout);
        this.k = (ImageView) this.f26550a.findViewById(e1.fake_return_icon);
        this.l = (ImageView) this.f26550a.findViewById(e1.fake_share_icon);
        this.m = (ImageView) this.f26550a.findViewById(e1.fake_information_icon);
        this.n = (ImageView) this.f26550a.findViewById(e1.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f26553d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26553d.setContentDescription(context.getResources().getString(h1.bar_header));
        this.f26553d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), c1.tbds4));
        this.f26553d.setShowOval(true);
        this.f26553d.setBorderColor(SkinManager.getColor(b1.black_alpha15));
        this.f26553d.setStrokeColorResId(b1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f26550a, b1.CAM_X0201);
        SkinManager.setBackgroundResource(this.f26558i, d1.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f26557h, b1.CAM_X0201);
        SkinManager.setImageResource(this.k, d1.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, d1.ic_icon_pure_topbar_share40_svg, b1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(d1.icon_pure_topbar_information40, SkinManager.getColor(b1.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, d1.ic_icon_pure_topbar_search40_svg, b1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f26557h, d1.bg_pure_loadingskeleton_svg, b1.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
