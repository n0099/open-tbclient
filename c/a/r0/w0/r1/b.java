package c.a.r0.w0.r1;

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
    public View f27698a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f27699b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27700c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27701d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27702e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f27703f;

    /* renamed from: g  reason: collision with root package name */
    public View f27704g;

    /* renamed from: h  reason: collision with root package name */
    public int f27705h;

    /* renamed from: i  reason: collision with root package name */
    public int f27706i;

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
        this.f27706i = 3;
        this.f27698a = view;
        this.f27699b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f27700c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f27701d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f27702e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f27703f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f27704g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
