package c.a.r0.m.g;

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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f12777b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f12778c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f12779d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12780e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12781f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12782g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12783h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12784i;

    public c(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f12777b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f12778c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12777b : (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (paramBean = this.f12778c) == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f12778c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f12779d.startLoad(this.f12778c.getVideo_info().getThumbnail_url(), 10, false);
        this.f12784i.setText(StringHelper.numFormatOverWanWithNegative(this.f12778c.getAgree_num()));
        this.f12781f.setText(StringHelper.numFormatOverWanWithNegative(this.f12778c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12781f = (TextView) this.f12777b.findViewById(R.id.comment_num);
            this.f12782g = (TextView) this.f12777b.findViewById(R.id.comment_desc);
            this.f12783h = (TextView) this.f12777b.findViewById(R.id.praise_desc);
            TextView textView = (TextView) this.f12777b.findViewById(R.id.praise_num);
            this.f12784i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12781f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12783h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12782g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.f12777b.findViewById(R.id.video_img);
            this.f12779d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f12779d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f12779d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.f12777b.findViewById(R.id.play_icon);
            this.f12780e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
