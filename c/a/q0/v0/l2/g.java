package c.a.q0.v0.l2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26429a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26430b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f26431c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f26432d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26433e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f26434f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f26435g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f26436h;

    /* renamed from: i  reason: collision with root package name */
    public View f26437i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f26438j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f26439e;

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
            this.f26439e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.f26439e;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_fake_view, (ViewGroup) null);
        this.f26429a = inflate;
        this.f26430b = (RelativeLayout) inflate.findViewById(R.id.head_top_bg_container);
        this.f26431c = (LinearGradientView) this.f26429a.findViewById(R.id.head_top_gradient_bg);
        TbImageView tbImageView = (TbImageView) this.f26429a.findViewById(R.id.head_top_bg_mask);
        this.f26438j = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.f26438j.setDefaultResource(R.drawable.pic_frs_head_default);
        this.f26432d = (BarImageView) this.f26429a.findViewById(R.id.frs_image);
        TextView textView = (TextView) this.f26429a.findViewById(R.id.forum_name);
        this.f26433e = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        this.f26434f = (FrsHeaderBannerView) this.f26429a.findViewById(R.id.frs_header_banner);
        this.f26435g = (LinearLayout) this.f26429a.findViewById(R.id.fake_content_layout);
        this.f26436h = (ImageView) this.f26429a.findViewById(R.id.fake_content_img);
        this.f26437i = this.f26429a.findViewById(R.id.header_round_corner_layout);
        this.k = (ImageView) this.f26429a.findViewById(R.id.fake_return_icon);
        this.l = (ImageView) this.f26429a.findViewById(R.id.fake_share_icon);
        this.m = (ImageView) this.f26429a.findViewById(R.id.fake_information_icon);
        this.n = (ImageView) this.f26429a.findViewById(R.id.fake_search_icon);
        this.k.setOnClickListener(new a(this, context));
        this.f26432d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26432d.setContentDescription(context.getResources().getString(R.string.bar_header));
        this.f26432d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f26432d.setShowOval(true);
        this.f26432d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.f26432d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f26429a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f26437i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f26436h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f26436h, R.drawable.bg_pure_loadingskeleton_svg, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
