package c.a.p0.f1.q2;

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
    public RelativeLayout f14457b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f14458c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f14459d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14460e;

    /* renamed from: f  reason: collision with root package name */
    public FrsHeaderBannerView f14461f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f14462g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14463h;
    public View i;
    public TbImageView j;
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
        public final /* synthetic */ Context a;

        public a(g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.a;
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
        public final /* synthetic */ Context a;

        public b(g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Context context = this.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05f6, (ViewGroup) null);
            this.a = inflate;
            this.f14457b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d28);
            this.f14458c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090d2b);
            TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d29);
            this.j = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f14459d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b37);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f14460e = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            ViewCommonUtil.setViewMargin(this.f14460e, -1, this.q, -1, -1);
            this.f14461f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b26);
            this.f14462g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090964);
            this.f14463h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090963);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090966);
            this.k = imageView;
            ViewCommonUtil.setViewMargin(imageView, -1, this.p, -1, -1);
            this.k.setOnClickListener(new a(this, context));
            this.f14459d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14459d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
            this.f14459d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.f14459d.setShowOval(true);
            this.f14459d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
            this.f14459d.setStrokeColorResId(R.color.CAM_X0201);
            ViewCommonUtil.setViewMargin(this.f14459d, -1, this.o, -1, -1);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f14463h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080624);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14463h, R.drawable.obfuscated_res_0x7f0802d6, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
            return;
        }
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d030d, (ViewGroup) null);
        this.a = inflate2;
        this.f14457b = (RelativeLayout) inflate2.findViewById(R.id.obfuscated_res_0x7f090d28);
        this.f14458c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090d2b);
        TbImageView tbImageView2 = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d29);
        this.j = tbImageView2;
        tbImageView2.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.obfuscated_res_0x7f080efd);
        this.f14459d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b37);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a67);
        this.f14460e = textView2;
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
        this.f14461f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090b26);
        this.f14462g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090964);
        this.f14463h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090963);
        this.i = this.a.findViewById(R.id.obfuscated_res_0x7f090d3f);
        this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090966);
        this.l = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090968);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090965);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090967);
        this.k.setOnClickListener(new b(this, context));
        this.f14459d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14459d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02d1));
        this.f14459d.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f14459d.setShowOval(true);
        this.f14459d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.f14459d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.i, R.drawable.white_bg_frs_header_round_corner);
        SkinManager.setBackgroundResource(this.f14463h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.obfuscated_res_0x7f080624);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f080626, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b8, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f080625, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14463h, R.drawable.obfuscated_res_0x7f0802d6, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
