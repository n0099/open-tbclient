package b.a.r0.x0.c2;

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
    public View f27128a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f27129b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27130c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27131d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27132e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f27133f;

    /* renamed from: g  reason: collision with root package name */
    public View f27134g;

    /* renamed from: h  reason: collision with root package name */
    public int f27135h;

    /* renamed from: i  reason: collision with root package name */
    public int f27136i;

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
        this.f27136i = 3;
        this.f27128a = view;
        this.f27129b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f27130c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f27131d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f27132e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f27133f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f27134g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
