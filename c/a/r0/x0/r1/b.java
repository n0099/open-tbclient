package c.a.r0.x0.r1;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27874a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f27875b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27876c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27877d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27878e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f27879f;

    /* renamed from: g  reason: collision with root package name */
    public View f27880g;

    /* renamed from: h  reason: collision with root package name */
    public int f27881h;

    /* renamed from: i  reason: collision with root package name */
    public int f27882i;

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
        this.f27882i = 3;
        this.f27874a = view;
        this.f27875b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f27876c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f27877d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f27878e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f27879f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f27880g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
