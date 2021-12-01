package c.a.q0.m.g;

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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f12450b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f12451c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f12452d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12453e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12454f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12455g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12456h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12457i;

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
        this.f12450b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f12451c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12450b : (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (paramBean = this.f12451c) == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f12451c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f12452d.startLoad(this.f12451c.getVideo_info().getThumbnail_url(), 10, false);
        this.f12457i.setText(StringHelper.numFormatOverWanWithNegative(this.f12451c.getAgree_num()));
        this.f12454f.setText(StringHelper.numFormatOverWanWithNegative(this.f12451c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f12454f = (TextView) this.f12450b.findViewById(R.id.comment_num);
            this.f12455g = (TextView) this.f12450b.findViewById(R.id.comment_desc);
            this.f12456h = (TextView) this.f12450b.findViewById(R.id.praise_desc);
            TextView textView = (TextView) this.f12450b.findViewById(R.id.praise_num);
            this.f12457i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12454f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f12456h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f12455g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.f12450b.findViewById(R.id.video_img);
            this.f12452d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f12452d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f12452d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.f12450b.findViewById(R.id.play_icon);
            this.f12453e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
