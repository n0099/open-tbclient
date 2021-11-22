package b.a.q0.m.g;

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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f13505a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13506b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f13507c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f13508d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13509e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13510f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13511g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13512h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13513i;

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
        this.f13505a = context;
        this.f13506b = LayoutInflater.from(context).inflate(R.layout.video_interaction_achievement, (ViewGroup) null);
        this.f13507c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13506b : (View) invokeV.objValue;
    }

    public final void b() {
        ThreadAchievementShareInfo.ParamBean paramBean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (paramBean = this.f13507c) == null || paramBean.getVideo_info() == null || TextUtils.isEmpty(this.f13507c.getVideo_info().getThumbnail_url())) {
            return;
        }
        this.f13508d.startLoad(this.f13507c.getVideo_info().getThumbnail_url(), 10, false);
        this.f13513i.setText(StringHelper.numFormatOverWanWithNegative(this.f13507c.getAgree_num()));
        this.f13510f.setText(StringHelper.numFormatOverWanWithNegative(this.f13507c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13510f = (TextView) this.f13506b.findViewById(R.id.comment_num);
            this.f13511g = (TextView) this.f13506b.findViewById(R.id.comment_desc);
            this.f13512h = (TextView) this.f13506b.findViewById(R.id.praise_desc);
            TextView textView = (TextView) this.f13506b.findViewById(R.id.praise_num);
            this.f13513i = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13510f.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f13512h.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13511g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TbImageView tbImageView = (TbImageView) this.f13506b.findViewById(R.id.video_img);
            this.f13508d = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.f13508d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f13508d.setPlaceHolder(2);
            ImageView imageView = (ImageView) this.f13506b.findViewById(R.id.play_icon);
            this.f13509e = imageView;
            imageView.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play44_svg, R.color.CAM_X0101, null));
        }
    }
}
