package b.a.r0.x0.b2;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f25540a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f25541b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25542c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25543d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25544e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f25545f;

    /* renamed from: g  reason: collision with root package name */
    public View f25546g;

    /* renamed from: h  reason: collision with root package name */
    public int f25547h;

    /* renamed from: i  reason: collision with root package name */
    public int f25548i;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25548i = 3;
        this.f25540a = view;
        this.f25541b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f25542c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f25543d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f25544e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f25545f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f25546g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
