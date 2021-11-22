package b.a.r0.x0.x2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28146a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f28147b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f28148c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f28149d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28150e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f28151f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f28152g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f28153h;

    /* renamed from: i  reason: collision with root package name */
    public View f28154i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f28155e;

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
            this.f28155e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f28155e;
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
        this.f28146a = inflate;
        this.f28147b = (RelativeLayout) inflate.findViewById(f1.head_top_bg_container);
        this.f28148c = (LinearGradientView) this.f28146a.findViewById(f1.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f28146a.findViewById(f1.head_top_bg_mask);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(c1.transparent);
        this.j.setDefaultResource(e1.pic_frs_head_default);
        this.f28149d = (BarImageView) this.f28146a.findViewById(f1.frs_image);
        TextView textView = (TextView) this.f28146a.findViewById(f1.forum_name);
        this.f28150e = textView;
        SkinManager.setViewTextColor(textView, c1.CAM_X0101);
        this.f28151f = (FrsHeaderBannerView) this.f28146a.findViewById(f1.frs_header_banner);
        this.f28152g = (LinearLayout) this.f28146a.findViewById(f1.fake_content_layout);
        this.f28153h = (ImageView) this.f28146a.findViewById(f1.fake_content_img);
        this.f28154i = this.f28146a.findViewById(f1.header_round_corner_layout);
        this.k = (ImageView) this.f28146a.findViewById(f1.fake_return_icon);
        this.l = (ImageView) this.f28146a.findViewById(f1.fake_share_icon);
        this.m = (ImageView) this.f28146a.findViewById(f1.fake_information_icon);
        this.n = (ImageView) this.f28146a.findViewById(f1.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f28149d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f28149d.setContentDescription(context.getResources().getString(i1.bar_header));
        this.f28149d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), d1.tbds4));
        this.f28149d.setShowOval(true);
        this.f28149d.setBorderColor(SkinManager.getColor(c1.black_alpha15));
        this.f28149d.setStrokeColorResId(c1.CAM_X0201);
        SkinManager.setBackgroundColor(this.f28146a, c1.CAM_X0201);
        SkinManager.setBackgroundResource(this.f28154i, e1.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f28153h, c1.CAM_X0201);
        SkinManager.setImageResource(this.k, e1.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f28153h, e1.bg_pure_loadingskeleton_svg, c1.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
