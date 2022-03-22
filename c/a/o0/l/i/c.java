package c.a.o0.l.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f10428b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f10429c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f10430d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10431e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f10432f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f10433g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f10434h;
    public TextView i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
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
        this.f10428b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0880, (ViewGroup) null);
        this.f10429c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10428b : (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (paramBean = this.f10429c) == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f10429c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f10430d.J(this.f10429c.getVideo_info().getThumbnail_url(), 10, false);
        this.i.setText(StringHelper.numFormatOverWanWithNegative(this.f10429c.getAgree_num()));
        this.f10432f.setText(StringHelper.numFormatOverWanWithNegative(this.f10429c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10432f = (TextView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f09068e);
            this.f10433g = (TextView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f090684);
            this.f10434h = (TextView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f0918d4);
            TextView textView = (TextView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f0918d5);
            this.i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f10432f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f10434h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f10433g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f092332);
            this.f10430d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f10430d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f10430d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.f10428b.findViewById(R.id.obfuscated_res_0x7f09185c);
            this.f10431e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
