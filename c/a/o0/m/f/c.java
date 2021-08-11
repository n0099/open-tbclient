package c.a.o0.m.f;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13326a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13327b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13328c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f13329d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13330e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13331f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13332g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13333h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13334i;

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
        this.f13326a = context;
        this.f13327b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f13328c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13327b : (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (paramBean = this.f13328c) == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f13328c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f13329d.startLoad(this.f13328c.getVideo_info().getThumbnail_url(), 10, false);
        this.f13334i.setText(StringHelper.numFormatOverWanWithNegative(this.f13328c.getAgree_num()));
        this.f13331f.setText(StringHelper.numFormatOverWanWithNegative(this.f13328c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13331f = (TextView) this.f13327b.findViewById(R.id.comment_num);
            this.f13332g = (TextView) this.f13327b.findViewById(R.id.comment_desc);
            this.f13333h = (TextView) this.f13327b.findViewById(R.id.praise_desc);
            TextView textView = (TextView) this.f13327b.findViewById(R.id.praise_num);
            this.f13334i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13331f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13333h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13332g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.f13327b.findViewById(R.id.video_img);
            this.f13329d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f13329d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13329d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.f13327b.findViewById(R.id.play_icon);
            this.f13330e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
