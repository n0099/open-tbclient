package c.a.r0.d1.q2;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16162b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f16163c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f16164d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16165e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f16166f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f16167g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16168h;

    /* renamed from: i  reason: collision with root package name */
    public View f16169i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f16170j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public int o;
    public int p;
    public int q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f16171e;

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
            this.f16171e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f16171e;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f16172e;

        public b(g gVar, Context context) {
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
            this.f16172e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f16172e;
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
            newInitContext.initArgs = r3;
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
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds42) + UtilHelper.getStatusBarHeight();
        this.p = UtilHelper.getDimenPixelSize(R.dimen.tbds50) + UtilHelper.getStatusBarHeight();
        this.q = UtilHelper.getDimenPixelSize(R.dimen.tbds51) + UtilHelper.getStatusBarHeight();
        if (context == null) {
            return;
        }
        if (UbsABTestHelper.isFrsModifyABTestA()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.new_frs_fake_view, (ViewGroup) null);
            this.a = inflate;
            this.f16162b = (RelativeLayout) inflate.findViewById(R.id.head_top_bg_container);
            this.f16163c = (LinearGradientView) this.a.findViewById(R.id.head_top_gradient_bg);
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.head_top_bg_mask);
            this.f16170j = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f16164d = (BarImageView) this.a.findViewById(R.id.frs_image);
            TextView textView = (TextView) this.a.findViewById(R.id.forum_name);
            this.f16165e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            ViewCommonUtil.setViewMargin(this.f16165e, -1, this.q, -1, -1);
            this.f16166f = (FrsHeaderBannerView) this.a.findViewById(R.id.frs_header_banner);
            this.f16167g = (LinearLayout) this.a.findViewById(R.id.fake_content_layout);
            this.f16168h = (ImageView) this.a.findViewById(R.id.fake_content_img);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.fake_return_icon);
            this.k = imageView;
            ViewCommonUtil.setViewMargin(imageView, -1, this.p, -1, -1);
            this.k.setOnClickListener(new a(this, context));
            this.f16164d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16164d.setContentDescription(context.getResources().getString(R.string.bar_header));
            this.f16164d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.f16164d.setShowOval(true);
            this.f16164d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f16164d.setStrokeColorResId(R.color.CAM_X0201);
            ViewCommonUtil.setViewMargin(this.f16164d, -1, this.o, -1, -1);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f16168h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16168h, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
        this.a = inflate2;
        this.f16162b = (RelativeLayout) inflate2.findViewById(R.id.head_top_bg_container);
        this.f16163c = (LinearGradientView) this.a.findViewById(R.id.head_top_gradient_bg);
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.head_top_bg_mask);
        this.f16170j = tbImageView2;
        tbImageView2.setDefaultBgResource(R.color.transparent);
        this.f16170j.setDefaultResource(R.drawable.pic_frs_head_default);
        this.f16164d = (BarImageView) this.a.findViewById(R.id.frs_image);
        TextView textView2 = (TextView) this.a.findViewById(R.id.forum_name);
        this.f16165e = textView2;
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
        this.f16166f = (FrsHeaderBannerView) this.a.findViewById(R.id.frs_header_banner);
        this.f16167g = (LinearLayout) this.a.findViewById(R.id.fake_content_layout);
        this.f16168h = (ImageView) this.a.findViewById(R.id.fake_content_img);
        this.f16169i = this.a.findViewById(R.id.header_round_corner_layout);
        this.k = (ImageView) this.a.findViewById(R.id.fake_return_icon);
        this.l = (ImageView) this.a.findViewById(R.id.fake_share_icon);
        this.m = (ImageView) this.a.findViewById(R.id.fake_information_icon);
        this.n = (ImageView) this.a.findViewById(R.id.fake_search_icon);
        this.k.setOnClickListener(new b(this, context));
        this.f16164d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f16164d.setContentDescription(context.getResources().getString(R.string.bar_header));
        this.f16164d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f16164d.setShowOval(true);
        this.f16164d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.f16164d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f16169i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f16168h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16168h, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
